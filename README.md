# SonixLink: successor to the original project

![Status: successor of original SonixLink](https://img.shields.io/badge/status-successor%20of%20original%20SonixLink-blue) ![Version: 1.2 (recovered)](https://img.shields.io/badge/version-1.2%20%28recovered%29-green)

> This repository continues the original SonixLink project. Mattia Doronzo ("M4ttiA", GitHub `Jepl4r`) built SonixLink and the SonixOS / Sonix Player project (https://sonix-os.com). The original repository, https://github.com/Jepl4r/sonixlink-app, is gone. This repo carries the project forward from the last v1.2 APK and from community mirrors of the original source.
>
> The original author has not endorsed this repo. We found no open-source license for the Android app, so the original author keeps rights to the original code, artwork and documentation. If the original project or its license reappears, update the attribution and license here.
>
> Status: original Kotlin source recovered from mirrors; rebuild in progress.

**At a glance:** a community preservation effort for an abandoned Android remote-control app. The original Kotlin source, protocol docs and a rebuild live here.

## What the app is

SonixLink is an Android remote control for a network music player. It runs on a phone, connects to a device running the SonixLink player, sends commands, syncs the library index and cover art, and shows the current track.

| Field | Value |
|---|---|
| Name | SonixLink |
| Package | `com.mattiadoronzo.sonixlink` |
| Version | 1.2 (`versionCode` 3), debug build |
| Language | Kotlin |
| minSdk / targetSdk | 24 / 34 (Android 14) |
| UI | Views, Android Data Binding, Material Components 3 |
| Build system | Gradle, Android Gradle Plugin 8.5.2 |
| Dependencies | AndroidX, Kotlin coroutines, Material 3, `org.json` |

## Origins

- **Author:** Mattia Doronzo ("M4ttiA", GitHub `Jepl4r`), commit email `sensoriale_echidna_0w@icloud.com`.
- **Original repository:** https://github.com/Jepl4r/sonixlink-app. The site returns 404. The Wayback Machine still records its v1.2 release asset, `sonixlink.apk`, captured on 2026-11-10.
- **Companion player:** https://github.com/Jepl4r/sonix-player, also deleted. Its successor, https://github.com/Tartarus6/sonix-player, ships the server-side protocol under GPL-3.0.
- **Source mirrors:** https://github.com/bill-kolokithas/sonixlink-app holds the v1.2 source that we use for the rebuild. https://github.com/bogdanwebdeveloper/sonixlink-app holds v1.0. Several other forks exist.
- **License:** none found for the Android app. The GPL-3.0 player is a separate project and grants no rights to this one.
- **Project site:** https://sonix-os.com

## What has been done

1. Extracted `sonixlink.apk` (6.1 MB, 991 entries) and decompiled it with jadx 1.5.7.
2. Documented the architecture and the `/api/*` protocol in [`docs/`](docs/).
3. Traced the original author and repository through web archives and community forks.
4. Recovered the original Kotlin source (27 `.kt` files and a complete Gradle project) from the mirror above. The rebuild uses this source, not decompiled Java.

## Repository layout

```
.
├── app/src/main/
│   ├── AndroidManifest.xml
│   ├── java/com/mattiadoronzo/sonixlink/   # original Kotlin sources
│   └── res/                                 # layouts, drawables, strings, styles
├── docs/
│   ├── ARCHITECTURE.md   # modules and app flow
│   ├── PROTOCOL.md       # the player's /api/* protocol
│   └── RECOVERY-NOTES.md # evidence, limits and pending work
├── RELEASE_NOTES.md
├── build.gradle.kts
├── app/build.gradle.kts
└── settings.gradle.kts
```

## Technical summary

### Player discovery

- mDNS/NSD: `_sonixlink._tcp.`
- UDP beacon: port `7801`, prefix `SONIXLINK1`
- Bluetooth RFCOMM: UUID `8d6e3a52-4c1f-4b7e-9a2d-5f0c7e1b3a90`, channel 22, hosts prefixed with `bt:`

### Communication

[`Transport.kt`](app/src/main/java/com/mattiadoronzo/sonixlink/Transport.kt) defines two implementations: `HttpTransport` (HTTP on `http://host:7800`) and `BluetoothTransport`. `PlayerClient.kt` wraps the API: `info()`, `state()`, `command()`, `queue()`, `browse()`, `search()`, `favourites()`, `playlists()`, `history()`, `downloadDatabase()`, `covers()`. Responses carry JSON or binary cover and index data. See [`docs/PROTOCOL.md`](docs/PROTOCOL.md) for the full endpoint list.

### Screens

`ConnectActivity` handles the launcher and player selection. `SyncActivity` downloads the index. `MainActivity`, `NowPlayingActivity`, `SearchActivity` and `QueueActivity` cover playback, browsing and queue management. `PlayerService` runs as a media playback foreground service.

### Local data

The `sonixlink` SharedPreferences file stores the last host and port, index and cover stamps, the accent colour and the notification permission state. `Library.kt` and `Covers.kt` read the downloaded index and cached images.

## Limits

- The player and server code sit outside this repo. The protocol comes from the client and from server code in the successor player project. We have no live player to test against.
- The mirror marks its build `versionCode` 2; the recovered APK says 3. The rebuild sets 3 to match the APK.
- We have no license grant for the original Android app.

## Next steps

1. Build and publish a debug APK from the recovered Kotlin source.
2. Check every endpoint in [`docs/PROTOCOL.md`](docs/PROTOCOL.md) against a live player when one is available.
3. Ask the original author about the license and about official succession.

## Succession and disclaimer

This repo takes over from the original SonixLink by Mattia Doronzo, now off the internet. We base the rebuild on the recovered v1.2 APK and on community mirrors of the original source. This work preserves abandoned software. If the original project returns or its license turns up, add the proper attribution and license and rewrite this note.
