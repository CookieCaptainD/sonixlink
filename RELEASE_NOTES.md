# SonixLink v1.2-recovered — release notes

This is the first rebuilt release of **SonixLink**, the successor to the original Android app
that disappeared from the internet. It is reconstructed from the last known APK (v1.2,
`versionCode` 3) and published as a community preservation effort. It is not affiliated with or
endorsed by the original author.

## Source artifact

| Field | Value |
|---|---|
| Original APK | `sonixlink.apk` (6.1 MB, signed, debug build) |
| SHA-256 | `019e3e8a7473ab237acb8e7ec6c0715b07e7933044db3c428843343d7112679d` |
| Package | `com.mattiadoronzo.sonixlink` |
| Decompiler | jadx 1.5.7 (`--show-bad-code --deobf`) |
| Original language | Kotlin (recovered as Java, then rebuilt) |

## What this release contains

- The recovered application sources and resources for SonixLink v1.2.
- Documentation of the architecture and the `/api/*` player protocol.
- A rebuildable Android project (Gradle / AGP 8.5.2), with a debug APK attached to this release.
- Successor attribution: this repository continues the original project; see `README.md`.

## What works

- Player discovery over mDNS (`_sonixlink._tcp.`) and UDP beacon (`SONIXLINK1`, port 7801).
- Bluetooth discovery and RFCOMM transport (`bt:` hosts, channel 22).
- HTTP client for the player API on port 7800: info, state, commands, queue, browse, search,
  favourites, playlists, history, index and cover downloads.
- Local library index and cover cache, UI screens, and the media playback foreground service.

## Known limitations

- The code was decompiled from Kotlin bytecode: comments, local names and original formatting are
  irrecoverable. Kotlin-specific compiler artefacts were removed to make the project build.
- A small number of complex methods may be reconstructed as approximations — see
  `docs/RECOVERY-NOTES.md` for the exact list.
- The player/server side of the protocol is not part of this project. Endpoints were recovered
  from the client and could not be verified against a live player.
- This is a **debug** build, matching the original APK.

## Install

Install the attached `app-debug.apk` on Android 7.0 (API 24) or newer, with "Install unknown
apps" enabled. The app needs network access, Bluetooth permissions and notification permission
on Android 13+.

## Attribution and license

Original project: SonixLink by Mattia Doronzo (inferred from the package name
`com.mattiadoronzo.sonixlink`). If the original repository or its license reappears, update the
attribution and licensing in this repository accordingly.
