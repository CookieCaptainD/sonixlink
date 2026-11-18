# SonixLink protocol (client side)

Endpoints extracted from `PlayerClient.java`. Base URL: `http://<host>:7800` (HTTP) or an RFCOMM channel (Bluetooth, `bt:` prefix).

| Method | Path | Purpose |
|---|---|---|
| GET | `/api/info` | Player information (name, model, firmware, track count, index/cover hashes and mtimes, serial, accent) |
| GET | `/api/state` | Playback state (fields below) |
| POST | `/api/command?do=<action>&...` | Commands (play, pause, next, prev, volume, mode, seek, ...) |
| POST | `/api/command?do=queue_remove&rev=<rev>` | Remove from queue (body = bytes) |
| GET | `/api/history?limit=<n>` | Playback history |
| GET | `/api/favourites` | Favourites |
| GET | `/api/playlists` | List of playlists |
| GET | `/api/playlist?name=<urlencoded>` | Tracks in a playlist |
| GET | `/api/queue` / `/api/queue?from=<n>` | Queue (paginated — `QueueWindow`) |
| GET | `/api/browse<query>` | Library browsing (folders/albums/artists) |
| GET | `/api/ping` | Connection test |
| GET | `/api/bye` | Close session (short timeout, 1500 ms) |
| GET | `/api/db` | Download the index (binary file, with progress) |
| GET | `/api/thumbkeys` | Thumbnail keys ("bulk" response) |
| GET | `/api/thumbs?keys=<...>` | Thumbnails in batch ("bulk" response) |
| GET | `/api/art?path=<urlencoded>` | Cover art for a track |

## Conventions

- `request()` defaults to `GET`, a 4000 ms read timeout and accepts 2xx as success; otherwise it throws `PlayerException` with `"<code> <first 120 chars>"`.
- Download timeout: 60,000 ms. Connection timeout: 3000 ms.
- POST body: `Content-Type: text/plain; charset=utf-8`.
- "Bulk" responses (`/api/db`, `/api/thumbkeys`, `/api/thumbs`) use `Content-Length` and a direct stream.

## JSON models

### `/api/info` → `PlayerInfo`
`name`, `model`, `firmware`, `tracks`, `scanning`, `dbAvailable`, `dbSize`, `dbMtime`, `coversAvailable`, `coversSize`, `coversMtime`, `accent`, `serial`, `dbHash`, `coversHash`, `sort`.

- `identity(host)` = `serial` when not empty, otherwise `host`.
- `dbVersion` = `dbHash`, or `dbMtime` if empty. The same applies to `coversVersion`.

### `/api/state` → `PlayerState`
`playState`, `mode`, `volume`, `position`, `duration`, `title`, `artist`, `album`, `path`, `sampleRate`, `bits`, `bitrate`, `lossless`, `battery`, `charging`, `favourite`, `accent`, `queuePosition`, `queueCount`, `queueRevision`, `scanning`, `scanCount`, `tracks`, `sort`, `displayPosition`, `displayCount`, `albumArtist`, `favouritesRevision`, `playlistsRevision`, `historyRevision`.

Play modes (`PlayMode`): `NORMAL`, `SHUFFLE`, `REPEAT_ALL`, `REPEAT_ONE`, `SHUFFLE_REPEAT`.

### Other models
`Row`, `Section`, `Folder`, `FolderEntry`, `Artwork`, `ArtPending`, `Thumb`, `HistoryEntry`, `Playmark`, `QueueWindow`, `Response` (`code`, `length`, `body`, `onClose`).

> Note: confirm the exact JSON field names in the `parse*` methods of `PlayerClient.java` — this table is a summary of what the code reads.
