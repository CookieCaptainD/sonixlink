# SonixLink — Successor to the original project

![Status: successor of original SonixLink](https://img.shields.io/badge/status-successor%20of%20original%20SonixLink-blue) ![Version: 1.2 (recovered)](https://img.shields.io/badge/version-1.2%20%28recovered%29-green)

> **This repository is the successor to the original SonixLink project**, created by Mattia Doronzo
> (inferred from the package name `com.mattiadoronzo.sonixlink`). The original project has
> disappeared from the internet. This repo preserves and continues its code from the latest known
> release of the APK (v1.2), with the goal of recovering, documenting and keeping it alive.
>
> **This is not an official continuation, nor is it endorsed by the original author.** It is a
> community preservation effort: if the original project reappears or a license is found,
> attribution and licensing must be updated accordingly.
>
> **Status:** sources decompiled and documented; a compilable rebuild is still in progress.

**At a glance:** a community-led recovery of an abandoned Android remote-control app — decompiled, documented, and being rebuilt in the open.

## What the app is

**SonixLink** is an Android remote control for a network music player (Wi-Fi or Bluetooth). It is
not a player itself: it connects to a device running the SonixLink player, sends commands, syncs
the library index and cover art, and shows what is currently playing.

| Field | Value |
|---|---|
| Name | SonixLink |
| Package | `com.mattiadoronzo.sonixlink` |
| Version | 1.2 (`versionCode` 3) — **debug** build |
| Original language | **Kotlin** (confirmed by `@Metadata` annotations and `*.kt` source names) |
| minSdk / targetSdk | 24 / 34 (Android 14) |
| UI | Views + Android Data Binding + Material Components 3 (not Compose) |
| Original build | Gradle / Android, no obfuscation (class names intact) |
| Dependencies | AndroidX, Kotlin coroutines, Material 3, `org.json` |

## What has been done

1. Extracted the APK (`sonixlink.apk`, 6.1 MB, 991 entries).
2. Decompiled with **jadx 1.5.7** (`sources/` + `resources/`).
3. Identified the app package among ~3,000 classes (the rest are AndroidX/Kotlin/Google).
4. Organized the app files into a conventional Android project layout.
5. Documented the architecture and HTTP protocol in [`docs/`](docs/).

## Repository layout

```
.
├── app/src/main/
│   ├── AndroidManifest.xml
│   ├── java/com/mattiadoronzo/sonixlink/   # 78 decompiled .java files
│   └── res/                                 # layouts, drawables, strings, styles
├── docs/
│   ├── ARCHITECTURE.md   # modules and app flow
│   ├── PROTOCOL.md       # the player's /api/* protocol
│   └── RECOVERY-NOTES.md # limitations, pending work and next steps
├── build.gradle.kts          # Gradle skeleton (to be adjusted)
├── app/build.gradle.kts      # Gradle skeleton (to be adjusted)
└── settings.gradle.kts
```

## Technical summary

### Player discovery
- **mDNS/NSD:** `_sonixlink._tcp.`
- **UDP beacon:** port `7801`, prefix `SONIXLINK1`
- **Bluetooth RFCOMM:** UUID `8d6e3a52-4c1f-4b7e-9a2d-5f0c7e1b3a90`, channel 22, hosts prefixed with `bt:`

### Communication
- Abstract [`Transport`](app/src/main/java/com/mattiadoronzo/sonixlink/Transport.java) with two implementations: `HttpTransport` (HTTP at `http://host:7800`) and `BluetoothTransport`.
- `PlayerClient` is the API facade: `info()`, `state()`, `command()`, `queue()`, `browse()`, `search()`, `favourites()`, `playlists()`, `history()`, `downloadDatabase()`, `covers()`.
- Responses are JSON (`org.json`) and binary data for cover art and the index.

### Screens (6 activities + 1 service)
`ConnectActivity` (launcher) → `SyncActivity` → `MainActivity` → `NowPlayingActivity`, `SearchActivity`, `QueueActivity`. `PlayerService` is a media playback foreground service.

### Local data
`SharedPreferences` file `sonixlink` stores: last host/port, index and cover "stamps" (hash/mtime), accent colour and notification permission state. The library index is downloaded from the player and read locally through `Library` / `Covers`.

## Limitations

See [`docs/RECOVERY-NOTES.md`](docs/RECOVERY-NOTES.md). In short:

- jadx generates **Java from Kotlin**: the code is readable and faithful, but it is not the original Kotlin (synthetic function names, `@Metadata`, filler imports).
- Comments, local variable names and original formatting **do not survive**.
- The server/player (the other end of the API) **is not in the APK** — only the client app is.
- 89 decompiler warnings/errors in complex methods (coroutines/lambdas).
- The Gradle skeleton **does not compile yet** — the build files, code and generated `R` must be recreated.

## Next steps

1. Review `docs/PROTOCOL.md` and verify the endpoints against a real player, if one still exists.
2. Replace the jadx filler imports (e.g. `androidx.constraintlayout.widget.ConstraintLayout` used only as constants inside `@Metadata`).
3. Recreate the build files using the actual dependency versions (read from `META-INF/*.version` in the APK).
4. Optionally use a Kotlin decompiler (e.g. the IntelliJ plugin) on the `@Metadata` to get closer to the original source.

## Succession and disclaimer

This repository takes over from the **original SonixLink** project (author inferred as Mattia Doronzo /
`com.mattiadoronzo`), now gone from the internet. The continuation is based on the recovered v1.2
APK, not on an authorized copy of the source.

This is **abandoned-software preservation** work. Please respect the original author's rights: if
the project reappears or the original license is found, add the proper attribution and license, and
update this succession note accordingly.
