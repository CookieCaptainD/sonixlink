# SonixLink — Recuperação de código-fonte

> Recuperação / engenharia inversa de um APK de um projeto desaparecido da internet.
> **Estado:** código descompilado e documentado; reconstrução compilável ainda em curso.

## O que é a app

**SonixLink** é um controlo remoto Android para um player de música em rede (Wi-Fi ou Bluetooth). Não é um player: ele liga-se a um "player" que corre a SonixLink e envia comandos, sincroniza o índice da biblioteca e as capas, e mostra o que está a tocar.

| Dado | Valor |
|---|---|
| Nome | SonixLink |
| Package | `com.mattiadoronzo.sonixlink` |
| Versão | 1.2 (`versionCode` 3) — build **debug** |
| Linguagem original | **Kotlin** (confirmado pelas anotações `@Metadata` e pelos nomes de ficheiros `*.kt`) |
| minSdk / targetSdk | 24 / 34 (Android 14) |
| UI | Jetpack Compose? **Não** — Views + Android Data Binding + Material Components 3 |
| Construção original | Gradle / Android, sem ofuscação (nomes de classes intactos) |
| Dependências | AndroidX, Kotlin coroutines, Material 3, org.json |

## O que já foi feito

1. Extração do APK (`sonixlink.apk`, 6,1 MB, 991 entradas).
2. Descompilação com **jadx 1.5.7** (`sources/` + `resources/`).
3. Identificação do pacote da app entre ~3.000 classes (o resto são AndroidX/Kotlin/Google).
4. Organização dos ficheiros da app numa estrutura de projeto Android convencional.
5. Documentação da arquitetura e do protocolo HTTP em [`docs/`](docs/).

## Estrutura deste repositório

```
.
├── app/src/main/
│   ├── AndroidManifest.xml
│   ├── java/com/mattiadoronzo/sonixlink/   # 78 ficheiros .java descompilados
│   └── res/                                 # layouts, drawables, strings, styles
├── docs/
│   ├── ARCHITECTURE.md   # módulos e fluxo da app
│   ├── PROTOCOL.md       # API /api/* do player
│   └── RECOVERY-NOTES.md # limites, pendências e como continuar
├── build.gradle.kts          # esqueleto Gradle (a ajustar)
├── app/build.gradle.kts      # esqueleto Gradle (a ajustar)
└── settings.gradle.kts
```

## Resumo técnico

### Descoberta do player
- **mDNS/NSD:** `_sonixlink._tcp.`
- **Beacon UDP:** porta `7801`, prefixo `SONIXLINK1`
- **Bluetooth RFCOMM:** UUID `8d6e3a52-4c1f-4b7e-9a2d-5f0c7e1b3a90`, canal 22, host com prefixo `bt:`

### Comunicação
- Transporte abstrato [`Transport`](app/src/main/java/com/mattiadoronzo/sonixlink/Transport.java) com duas implementações: `HttpTransport` (HTTP sobre `http://host:7800`) e `BluetoothTransport`.
- `PlayerClient` é a fachada da API: `info()`, `state()`, `command()`, `queue()`, `browse()`, `search()`, `favourites()`, `playlists()`, `history()`, `downloadDatabase()`, `covers()`.
- As respostas são JSON (`org.json`) e binário para capas/índice.

### Ecrãs (6 activities + 1 service)
`ConnectActivity` (launcher) → `SyncActivity` → `MainActivity` → `NowPlayingActivity`, `SearchActivity`, `QueueActivity`. O `PlayerService` é um *foreground service* de reprodução.

### Dados locais
A app guarda em `SharedPreferences` (`sonixlink`): último host/porta, "stamps" (hash/mtime) do índice e das capas, cor de acento e estado da permissão de notificações. O índice é descarregado do player e lido localmente via `Library` / `Covers`.

## Limitações importantes

Ver [`docs/RECOVERY-NOTES.md`](docs/RECOVERY-NOTES.md). Em resumo:

- O jadx gera **Java a partir de Kotlin**: o código é legível e fiel, mas não é o Kotlin original (nomes de funções sintéticas, `@Metadata`, imports de preenchimento).
- Comentários, nomes locais e formatação originais **não sobrevivem**.
- O servidor/player (a outra ponta da API) **não está no APK** — só a app cliente.
- 89 avisos/erros de descompilação em métodos complexos (coroutines/lambdas).
- O esqueleto Gradle **ainda não compila** — é preciso recriar `build.gradle`, converter/afinar o código e gerar o `R`.

## Como continuar

1. Revisar `docs/PROTOCOL.md` e confirmar os endpoints com o player, se ainda existir.
2. Substituir os imports de preenchimento do jadx (ex.: `androidx.constraintlayout.widget.ConstraintLayout` usado apenas como "fill" nas anotações `@Metadata`).
3. Recriar os ficheiros de build com as versões reais das dependências (lidas de `META-INF/*.version` no APK).
4. Opcionalmente, usar um decompilador Kotlin (ex.: plugin do IntelliJ) sobre o `@Metadata` para chegar mais perto do fonte original.

## Aviso

Este trabalho é de **preservação de software abandonado**. Usa-o com respeito pelos direitos do autor original: se o projeto reaparecer ou tiver licença conhecida, atribui e segue essa licença.
