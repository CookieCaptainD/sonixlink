# Protocolo SonixLink (lado cliente)

Endpoints extraídos de `PlayerClient.java`. Base URL: `http://<host>:7800` (HTTP) ou canal RFCOMM (Bluetooth, prefixo `bt:`).

| Método | Caminho | Finalidade |
|---|---|---|
| GET | `/api/info` | Informação do player (nome, modelo, firmware, contagem de faixas, hashes/mtime do índice e capas, serial, accent) |
| GET | `/api/state` | Estado de reprodução (ver campos abaixo) |
| POST | `/api/command?do=<acao>&...` | Comandos (play, pause, next, prev, volume, mode, seek,...) |
| POST | `/api/command?do=queue_remove&rev=<rev>` | Remover da fila (body = bytes) |
| GET | `/api/history?limit=<n>` | Histórico |
| GET | `/api/favourites` | Favoritos |
| GET | `/api/playlists` | Lista de playlists |
| GET | `/api/playlist?name=<urlencoded>` | Faixas de uma playlist |
| GET | `/api/queue` / `/api/queue?from=<n>` | Fila (paginada — `QueueWindow`) |
| GET | `/api/browse<query>` | Navegação da biblioteca (pastas/álbuns/artistas) |
| GET | `/api/ping` | Teste de ligação |
| GET | `/api/bye` | Fechar sessão (timeout curto, 1500 ms) |
| GET | `/api/db` | Descarregar índice (ficheiro binário, com progresso) |
| GET | `/api/thumbkeys` | Chaves das miniaturas (resposta "bulk") |
| GET | `/api/thumbs?keys=<...>` | Miniaturas em lote (resposta "bulk") |
| GET | `/api/art?path=<urlencoded>` | Capa de uma faixa |

## Convenções

- `request()` usa `GET` por omissão, `readTimeout` 4000 ms e aceita 2xx como sucesso; caso contrário lança `PlayerException` com `"<code> <primeiros 120 chars>"`.
- Tempo limite de *download*: 60 000 ms. Ligação: 3000 ms.
- Corpo de POST: `Content-Type: text/plain; charset=utf-8`.
- Respostas "bulk" (`/api/db`, `/api/thumbkeys`, `/api/thumbs`) usam `Content-Length` e stream direto.

## Modelos JSON

### `/api/info` → `PlayerInfo`
`name`, `model`, `firmware`, `tracks`, `scanning`, `dbAvailable`, `dbSize`, `dbMtime`, `coversAvailable`, `coversSize`, `coversMtime`, `accent`, `serial`, `dbHash`, `coversHash`, `sort`.

- `identity(host)` = `serial` se não vazio, senão `host`.
- `dbVersion` = `dbHash` ou, se vazio, `dbMtime`. O mesmo para `coversVersion`.

### `/api/state` → `PlayerState`
`playState`, `mode`, `volume`, `position`, `duration`, `title`, `artist`, `album`, `path`, `sampleRate`, `bits`, `bitrate`, `lossless`, `battery`, `charging`, `favourite`, `accent`, `queuePosition`, `queueCount`, `queueRevision`, `scanning`, `scanCount`, `tracks`, `sort`, `displayPosition`, `displayCount`, `albumArtist`, `favouritesRevision`, `playlistsRevision`, `historyRevision`.

Modos (`PlayMode`): `NORMAL`, `SHUFFLE`, `REPEAT_ALL`, `REPEAT_ONE`, `SHUFFLE_REPEAT`.

### Outros modelos
`Row`, `Section`, `Folder`, `FolderEntry`, `Artwork`, `ArtPending`, `Thumb`, `HistoryEntry`, `Playmark`, `QueueWindow`, `Response` (`code`, `length`, `body`, `onClose`).

> Nota: os nomes exatos dos campos JSON devem ser confirmados nos métodos `parse*` de `PlayerClient.java` — esta tabela é um resumo do que é lido.
