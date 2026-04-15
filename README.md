# Projeto Revisão 3 - API de Gestão (Funcionários e Produtos)

Este projeto é uma API REST desenvolvida em Java com Spring Boot, criada para gerenciar cadastros de funcionários e produtos. O sistema utiliza JPA/Hibernate para persistência de dados em banco MySQL e possui um sistema robusto de tratamento de erros.

## 🛠️ Tecnologias Utilizadas

* **Java 23**
* **Spring Boot 4.0.5**
* **Spring Data JPA** (Persistência)
* **MySQL Connector** (Banco de dados)
* **Maven** (Gerenciador de dependências)

## 📋 Funcionalidades

### Gestão de Funcionários
* **Listar:** Retorna todos os funcionários cadastrados.
* **Salvar:** Cadastro de novos funcionários (com validação de e-mail duplicado).
* **Atualizar:** Edição de dados de funcionários existentes por ID.
* **Excluir:** Remoção de funcionários do sistema.

### Gestão de Produtos
* **Atributos:** Nome, Quantidade e Preço.
* **Operações:** Listagem, cadastro e atualização de produtos.

## ⚠️ Tratamento de Exceções (GlobalException)

A API possui um `RestControllerAdvice` que captura erros em toda a aplicação e retorna mensagens amigáveis em JSON. Ele trata especificamente:
* `RuntimeException`: Erros de negócio (ex: duplicidade de cadastro).
* `IllegalArgumentException`: Erros de validação (ex: registro não encontrado).

## 🚀 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/nome-do-repositorio.git](https://github.com/seu-usuario/nome-do-repositorio.git)
    ```

2.  **Configure o banco de dados:**
    Certifique-se de que o MySQL está rodando e crie o schema:
    ```sql
    CREATE DATABASE Revisao3;
    ```
    Ajuste as credenciais no arquivo `src/main/resources/application.properties`.

3.  **Execute a aplicação:**
    Utilize sua IDE preferida (IntelliJ, Eclipse, VS Code) ou via terminal:
    ```bash
    mvn spring-boot:run
    ```

## 📍 Endpoints Principais

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| GET | `/funcionario` | Lista todos os funcionários |
| POST | `/funcionario` | Salva um novo funcionário |
| PUT | `/funcionario/{id}` | Atualiza um funcionário |
| GET | `/produto` | Lista todos os produtos |
| POST | `/produto` | Salva um novo produto |

---
Desenvolvido como parte do aprendizado de Spring Boot e APIs REST.
