# SonixLink protocol

The client calls an HTTP API on port 7800 or sends the same requests over Bluetooth RFCOMM. The original v1.2 README and the player source confirm the paths and JSON keys below.

## Transport

- HTTP/1.1 on port 7800, JSON replies, no session state. Keep-alive on RFCOMM.
- Heartbeats: `GET /api/ping` and `GET /api/bye`, with a 1500 ms timeout on `bye`.
- Bluetooth SDP UUID `8d6e3a52-4c1f-4b7e-9a2d-5f0c7e1b3a90`, channel 22.
- Discovery: mDNS `_sonixlink._tcp.` with 30 s re-announcements, plus a UDP beacon on port 7801 that sends `SONIXLINK1 <ip> <port> <name>` every 2 s.

## Endpoints

| Method | Path | Purpose |
|---|---|---|
| GET | `/api/info` | Player identity, library counters and index stamps |
| GET | `/api/state` | Playback state |
| GET | `/api/db` | SQLite library index (503 while scanning) |
| GET | `/api/thumbkeys` | 8-byte little-endian thumbnail keys |
| GET | `/api/thumbs?keys=<k>,...` | Up to 64 thumbnails: 16-digit key, width and height (u16 LE), length (u32 LE), RGB565 pixels. `0x0` means no art |
| GET | `/api/covers` | Legacy whole thumbnail store |
| GET | `/api/art?path=&max=` | Raw artwork. 202 while rendering |
| GET | `/api/queue[?from=n]` | Queue page: `count`, `position`, `first`, `revision`, `pending`, `paths[]` (max 200) |
| GET | `/api/browse[?path=]` | `{path, root, parent, entries:[{name, path, dir}]}` |
| GET | `/api/history[?limit=n]` | `{revision, items:[{id, path, title, artist, played_at}]}` |
| GET | `/api/favourites` | `favourites[{path, name, artist}]` |
| GET | `/api/playlists` | `{revision, playlists[{name, count}]}` |
| GET | `/api/playlist?name=` | `{name, tracks[{path, title, artist}]}` |
| POST | `/api/command?do=...` | Playback and library commands |

## JSON fields

`GET /api/info` returns `name`, `model`, `firmware`, `serial`, `tracks`, `scanning`, `db_available`, `db_size`, `db_mtime`, `db_hash`, `covers_available`, `covers_size`, `covers_mtime`, `covers_hash`, `accent`, `sort`.

`GET /api/state` returns `state`, `mode`, `volume`, `position`, `duration`, `title`, `artist`, `album`, `album_artist`, `path`, `sample_rate`, `bits`, `bitrate`, `lossless`, `battery`, `charging`, `favourite`, `accent`, `sort`, `queue_position`, `queue_count`, `queue_revision`, `display_position`, `display_count`, `favourites_revision`, `playlists_revision`, `history_revision`, `scanning`, `scan_count`, `tracks`.

`PlayerInfo.identity(host)` uses `serial` when present and falls back to `host`. `dbVersion` uses `db_hash` or, if empty, `db_mtime`. `coversVersion` follows the same rule with the cover fields.

## Commands

`POST /api/command?do=` accepts:

- Playback: `play`, `pause`, `toggle`, `next`, `prev`, `seek&value=`, `volume&value=`
- Mode: `mode&value=normal|repeat_all|repeat_one|shuffle|shuffle_repeat`
- Selection: `play_path&path=&list=all|album|artist|album_artist|genre|favourites|playlist|queue|folder&value=`, `play_all&list=&value=&how=sequence|shuffle|random`
- Favourites: `favourite&path=&value=0|1`
- Queue: `queue_index&value=`, `queue_remove&rev=`, `queue_move&from=&to=&rev=`
- Library: `scan`

Selection commands that carry a list of paths send the paths in the POST body with `Content-Type: text/plain; charset=utf-8`. These include `queue_next`, `favourites_add`, `favourites_remove`, `playlist_add`, `playlist_remove` and `history_play&id=`.

## Client conventions

`request()` in `PlayerClient.kt` defaults to GET, a 4000 ms read timeout and a 2xx success check. It raises `PlayerException` with the response code and the first 120 characters on failure. Connection timeout is 3000 ms and download timeout is 60000 ms. Bulk responses stream using `Content-Length`.
