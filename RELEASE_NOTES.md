# SonixLink v1.2-recovered

This release rebuilds SonixLink, the Android remote control that Mattia Doronzo ("M4ttiA", GitHub `Jepl4r`) created before his repository disappeared. The rebuild uses the original Kotlin source recovered from a community mirror and checks its output against the last v1.2 APK. The original author has not endorsed this release, and we found no license for the Android app.

## Source artifacts

| Field | Value |
|---|---|
| Recovered APK | `sonixlink.apk`, 6.1 MB, signed, debug build |
| SHA-256 | `019e3e8a7473ab237acb8e7ec6c0715b07e7933044db3c428843343d7112679d` |
| Package | `com.mattiadoronzo.sonixlink` |
| Version | 1.2 (`versionCode` 3) |
| Original source | https://github.com/bill-kolokithas/sonixlink-app |
| Original project | https://github.com/Jepl4r/sonixlink-app (deleted) |

## Contents

- Original Kotlin sources and Android resources for SonixLink v1.2.
- Architecture and `/api/*` protocol documentation in `docs/`.
- A Gradle project that builds the attached `app-debug.apk` with `./gradlew assembleDebug`.

## Rebuilt APK

| Field | Value |
|---|---|
| File | `app-debug.apk` (6.1 MB) |
| SHA-256 | `2f6cae8ef824c4c1c56ea17e3bae0ff32a4f541ec42a5cddb4e1c99ff316a35b` |
| Manifest | Identical to the recovered APK |
| Dex files | `classes.dex` (10,215,948 B), `classes2.dex` (491,692 B), `classes3.dex` (17,528 B), `classes4.dex` (480,824 B) |

## Features

- Player discovery over mDNS (`_sonixlink._tcp.`) and a UDP beacon (`SONIXLINK1`, port 7801).
- Bluetooth discovery and RFCOMM transport on channel 22.
- HTTP API client on port 7800: info, state, commands, queue, browse, search, favourites, playlists, history, index and cover downloads.
- Local library index and cover cache, six UI screens and a media playback foreground service.

## Build

```bash
export JAVA_HOME=/path/to/jdk17
export ANDROID_HOME=/path/to/android-sdk
./gradlew clean assembleDebug --no-daemon
```

A clean build succeeds with JDK 17 and Android SDK platform 34 plus build-tools 34.0.0. The build changes one line of the mirror source: `versionCode` goes from 2 to 3. See `docs/RECOVERY-NOTES.md` for the aarch64 `aapt2` workaround used here.

## Verification

`aapt dump badging` output matches the recovered APK byte for byte. Both APKs carry four dex files with about 114,293 strings each. The sorted string diff spans five lines in a generated class-hash map, and the app strings and protocol identifiers match. No method needed stubbing.

## Limits

- We tested the endpoints against the original README and the player source, not against a live player.
- The mirror says `versionCode` 2; this build sets 3 to match the recovered APK.
- The build is a debug build, matching the original artifact.
- The original author retains the rights to the original code, artwork and documentation. If the project returns or a license appears, update the attribution in this repo.

## Install

Install `app-debug.apk` on Android 7.0 (API 24) or newer. Android blocks installs from unknown sources by default, so approve the install prompt. The app needs network access, Bluetooth access and, on Android 13 or newer, notification permission.
