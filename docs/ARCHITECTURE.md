# Arquitetura (reconstruída a partir do bytecode)

## Camadas

```
 Activities / UI                 Dados / Estado              Comunicação
 ─────────────────────────────────────────────────────────────────────────
 ConnectActivity  (launcher)    Settings (SharedPrefs)      Discovery
 SyncActivity                  Library  (índice local)      ├─ mDNS  _sonixlink._tcp.
 MainActivity                   Covers   (cache de capas)    └─ UDP   7801 / "SONIXLINK1"
 NowPlayingActivity             PlayerInfo / PlayerState    Transport (interface)
 SearchActivity                 Row / Section / Folder       ├─ HttpTransport  (host:7800)
 QueueActivity                  QueueWindow / Playmark       └─ BluetoothTransport (RFCOMM 22)
 BrowseFragment                 SortPrefs / PlayMode         PlayerClient (fachada /api)
 VolumePill / RowAdapter        Session / PriorityGate       Response
 PlayerService (foreground)     CrashLog
```

## Fluxo típico

1. `SonixLinkApp.onCreate()` instala `CrashLog`.
2. `ConnectActivity` usa `Discovery` para encontrar players (mDNS + beacon UDP) ou lista dispositivos Bluetooth emparelhados; `Settings.rememberHost()` guarda o último `host:porta`.
3. `SyncActivity` compara os "stamps" (hash/mtime) locais com `/api/info` e descarrega `/api/db` e as capas quando mudaram.
4. `MainActivity`, `SearchActivity`, `QueueActivity`, `NowPlayingActivity` usam `PlayerClient` para estado, navegação e comandos; `PlayerService` mantém a sessão de reprodução em primeiro plano e notificações.
5. `BrowseFragment` / `RowAdapter` constroem listas a partir do índice local (`Library`).

## Ficheiros por responsabilidade

| Ficheiro | Papel |
|---|---|
| `SonixLinkApp.kt` | Application; instala crash logging |
| `ConnectActivity.kt` | Escolha do player (Wi-Fi/Bluetooth) |
| `SyncActivity.kt` | Descarga do índice e capas, com progresso |
| `MainActivity.kt` | Ecrã principal; liga estado → UI |
| `NowPlayingActivity.kt` | Reprodução, capa, volume, favoritos |
| `SearchActivity.kt` | Pesquisa na biblioteca |
| `QueueActivity.kt` | Fila, histórico, paginação |
| `BrowseFragment.kt` | Navegação por pastas/categorias |
| `PlayerService.kt` | Foreground service de media playback |
| `PlayerClient.kt` | Cliente HTTP/Bluetooth da API `/api/*` |
| `Transport.kt`, `HttpTransport.kt`, `BluetoothTransport.kt` | Camada de transporte |
| `Discovery.kt` | mDNS + beacon UDP |
| `PlayerInfo.kt`, `PlayerState.kt`, ... | Modelos de dados (ficheiro original `Models.kt`) |
| `Library.kt`, `Covers.kt`, `Artwork.kt`, `Thumb.kt` | Índice local e cache de imagens |
| `Settings.kt` | Preferências (`sonixlink`) |
| `Session.kt`, `PriorityGate.kt`, `Held.kt` | Concorrência/sessão |
| `CrashLog.kt` | Apanha exceções e mostra diálogo de crash |
| `databinding/*` | Classes geradas pelo Android Data Binding |

## Detalhes de rede

- Porta HTTP padrão: **7800**; beacon UDP: **7801**.
- NSD service type: `_sonixlink._tcp.`.
- Prefixo de beacon: `SONIXLINK1`.
- Bluetooth: host representado como `bt:<MAC>`; UUID `8d6e3a52-4c1f-4b7e-9a2d-5f0c7e1b3a90`, canal RFCOMM 22 (com fallback reflexivo para canal 22).
- Timeouts: ligação 3 s, leitura 4 s (60 s para downloads), ping/bye 1,5 s.

## Notas sobre o código descompilado

- Os nomes de classe/método/campo estão intactos — a app **não foi ofuscada**.
- Os ficheiros `.java` contêm anotações `@Metadata` do Kotlin com os nomes originais, incluindo o ficheiro de origem (ex.: `Models.kt`, `Transport.kt`).
- Métodos `copy$default`, `ComponentN`, `invoke2`, `exchange$default`, etc. são artefactos do compilador Kotlin — não existiam no fonte original.
- Alguns imports (ex.: `androidx.constraintlayout.widget.ConstraintLayout`, `androidx.core.app.NotificationCompat`) são apenas "preenchimento" de constantes usadas pelo jadx nas anotações; devem ser removidos na reconstrução.
