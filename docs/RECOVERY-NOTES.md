# Notas de recuperação e pendências

## Fonte

- APK: `/home/diogo/Downloads/sonixlink.apk` (6,1 MB, assinado, `versionName` 1.2, `versionCode` 3, build **debug**).
- Ferramenta: `jadx 1.5.7`, opções `--show-bad-code --deobf --threads-count 4`.
- Resultado: 3.013 ficheiros `.java` no total; 90 pertencem a `com.mattiadoronzo.sonixlink`; 78 mantidos aqui (excluído o `R` gerado e ficheiros de binding duplicados).
- 89 erros/avisos de descompilação — concentrados em lambdas/coroutines e `when` do Kotlin.

## O que NÃO é recuperável

| Item | Motivo |
|---|---|
| Ficheiros `.kt` originais | O dex contém bytecode + metadados; jadx produz Java |
| Comentários, nomes de variáveis locais, formatação | Não compilados |
| Código do **player/servidor** | Não está no APK; só o cliente |
| Chave de assinatura | Nunca incluída no APK |
| Segredos remotos | Só existiriam se estivessem hardcoded (não encontrados) |

## Como chegar mais perto do original

1. **Anotações `@Metadata`** — cada classe conserva assinaturas Kotlin e o nome do ficheiro original. Um decompilador Kotlin (plugin do IntelliJ / `kotlin-decompiler`) pode recuperar `.kt` com mais fidelidade que o jadx.
2. **Reconstruir o Gradle** — ler `META-INF/*.version` do APK para obter as versões exatas de AndroidX/Material/Kotlin. O esqueleto incluído é apenas indicativo.
3. **Limpar imports de preenchimento** — substituir/remover `ConstraintLayout`, `NotificationCompat`, etc., usados só como Constantes nas anotações.
4. **R.java** — gerado pelo Android Gradle Plugin a partir de `res/`; não deve ser versionado.
5. **Data Binding** — `databinding/*` é gerado a partir dos layouts; ao recompilar, é regenerado.

## Verificação sugerida

- Confirmar com um player real (se ainda existir) todos os endpoints em `PROTOCOL.md`.
- Comparar `strings.xml` com as versões de idioma para recuperar textos originais.
- Procurar o autor (`mattiadoronzo`) em arquivos (Wayback Machine, GitHub) para confirmar licença e repo original.

## Estado do esqueleto Gradle

Os ficheiros `build.gradle.kts` são **documentação estrutural**, não um build funcional:
- não há `gradlew`/wrapper;
- as versões das dependências são aproximadas;
- o código Java descompilado ainda tem artefactos Kotlin que impedem compilação direta.

Não apagar estes ficheiros sem os substituir por um build real.
