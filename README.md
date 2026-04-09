# Controle de Chuvas Maringaense

Sistema de gerenciamento de solicitações relacionadas a problemas causados por chuvas na cidade de Maringá. O usuário pode registrar ocorrências como alagamentos, veículos danificados, problemas com energia, água, eletrônicos, ruas interditadas, entre outros, e acompanhar o status de cada solicitação.

## Funcionalidades

- **Criar solicitação** — registra uma nova ocorrência informando categoria, dados do usuário e descrição do problema.
- **Buscar solicitação por ID** — consulta os detalhes de uma solicitação específica.
- **Listar todas as solicitações** — exibe todas as solicitações cadastradas.
- **Alterar status** — atualiza o status de uma solicitação (ABERTA, EM_ANDAMENTO, RESOLVIDA).

## Tecnologias e Dependências

| Tecnologia | Versão |
|---|---|
| Java | 8+ |
| Maven | 3.x |
| JUnit | 3.8.1 (testes) |

## Estrutura do Projeto

```
controle-chuvas/
├── pom.xml
└── src/
    └── main/java/com/aep/
        ├── App.java                  # Classe principal (menu interativo)
        ├── Solicitacao.java          # Modelo de solicitação
        ├── Usuario.java              # Modelo de usuário
        ├── enums/
        │   ├── Categoria.java        # Categorias de ocorrência
        │   └── Status.java           # Status da solicitação
        └── services/
            └── SolicitacaoService.java  # Lógica de negócio e fluxos
```

## Pré-requisitos

- **Java JDK 8** ou superior instalado
- **Apache Maven 3.x** instalado

Verifique se estão instalados:

```bash
java -version
mvn -version
```

## Como Rodar

1. Clone ou baixe o repositório.

2. Acesse a pasta do projeto:

```bash
cd controle-chuvas
```

3. Compile o projeto com Maven:

```bash
mvn compile
```

4. Execute a aplicação:

```bash
mvn exec:java -Dexec.mainClass="com.aep.App"
```

Ou, alternativamente, empacote e execute o JAR:

```bash
mvn package
java -cp target/controle-chuvas-1.0-SNAPSHOT.jar com.aep.App
```

## Como Rodar os Testes

```bash
mvn test
```

## Uso

Ao iniciar, o sistema exibe um menu no terminal:

```
===CONTROLE DE CHUVAS MARINGAENSE===
1 - Criar solicitação
2 - Buscar solicitação por ID
3 - Listar todas
4 - Alterar status
5 - Sair
Escolha:
```

Basta digitar o número da opção e seguir as instruções exibidas na tela.
