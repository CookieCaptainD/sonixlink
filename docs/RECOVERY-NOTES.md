# Recovery notes and evidence

## Source artifact

| Field | Value |
|---|---|
| APK | `/home/diogo/Downloads/sonixlink.apk` (6.1 MB, signed, debug build) |
| SHA-256 | `019e3e8a7473ab237acb8e7ec6c0715b07e7933044db3c428843343d7112679d` |
| Version | `versionName` 1.2, `versionCode` 3 |
| Package | `com.mattiadoronzo.sonixlink` |
| Decompiler | jadx 1.5.7 with `--show-bad-code --deobf --threads-count 4` |
| Result | 3,013 Java files; 90 in the app package; 89 decompiler warnings |

The decompiled copy stays at `/home/diogo/Downloads/Hiby/recovery/sonixlink-src` as a reference. The rebuild uses the original Kotlin source instead.

## Tracing the original project

GitHub API queries, Wayback CDX and web search produced the following evidence on 2026-11-18:

- Mattia Doronzo used the GitHub handle `Jepl4r` and the display name `M4ttiA`. His commits carry the email `sensoriale_echidna_0w@icloud.com`. The package name `com.mattiadoronzo.sonixlink` matches.
- The original repo `Jepl4r/sonixlink-app` returns 404. Wayback still records the v1.2 release assets `sonixlink.apk` and `releases/latest/download/sonixlink.apk`, captured on 2026-11-10.
- `bogdanwebdeveloper/sonixlink-app` keeps the original author's commits for v1.0. `bill-kolokithas/sonixlink-app` keeps the v1.2 source, including the README that documents the protocol. Other forks include `twykyt-alt/sonixlink-app`, `qir3k/sonixlink-app-by-qirke` and `minayat241-create/sonixlink-app`.
- The companion player `Jepl4r/sonix-player` is gone. `Tartarus6/sonix-player` continues it under GPL-3.0 and contains the server code in `sonixlink.c`, `sonixlink_bt.c` and `sonixlink.h`.
- The project site https://sonix-os.com has Wayback snapshots of its download and guide pages.

We found no LICENSE file in the app mirrors and no license section in their READMEs. GitHub reports `license: null`. The GPL-3.0 license covers the player successor, not the Android app. Treat the app's license as unknown.

## Original source recovered

`/tmp/opencode/reference/sonixlink-app-main` holds the v1.2 Kotlin project downloaded from https://github.com/bill-kolokithas/sonixlink-app. It contains 27 `.kt` files and a full Gradle setup, including the wrapper. The rebuild copies this project into the repo. The recovered APK reports `versionCode` 3 while the mirror says 2, so the build sets 3 to match the artifact.

## Limits of the APK alone

The APK cannot supply comments, local variable names, original formatting or the server-side implementation. Those limits no longer block the rebuild because the original source turned up in mirrors. They remain relevant for anyone who only has the APK.

## Reproducing the build

Use JDK 17 and the Android SDK with platform 34 and build-tools 34.0.0:

```bash
export JAVA_HOME=/path/to/jdk17
export ANDROID_HOME=/path/to/android-sdk
./gradlew clean assembleDebug --no-daemon
```

The APK lands in `app/build/outputs/apk/debug/app-debug.apk`. Point `sdk.dir` at the SDK in `local.properties` if Android Studio is not installed.

On aarch64 hosts, AGP ships an x86_64 `aapt2` that fails under a broken FEX dispatcher. Run the SDK `aapt2` through `qemu-x86_64-static` with an x86_64 sysroot and set `android.aapt2FromMavenOverride` in `~/.gradle/gradle.properties` to that wrapper. This setting stays outside the repo. The coordinator used this route on 2026-11-18.

The build changes one line of the original source: `versionCode` goes from 2 to 3 to match the APK. Everything else comes from the mirror unchanged.

`aapt dump badging` output matches the recovered APK byte for byte. Both APKs contain four dex files with about 114,293 strings each. The sorted string diff spans five lines in a generated class-hash map; app strings and protocol identifiers match.

## Verification checklist

1. Compare the rebuilt APK with the recovered APK: package, version, strings and API paths.
2. Test every endpoint in `PROTOCOL.md` against a live player. The v1.2 README and the player source list the exact JSON keys and command values.
3. Keep the attribution accurate. Ask the original author about a license and about this succession.
