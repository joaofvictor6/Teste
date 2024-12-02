# User Service

Este é um projeto de serviço para gerenciar usuários. Ele permite a criação de usuários e a autenticação de login com validação de senha e tratamento de exceções para entradas inválidas.

## Funcionalidades

- **Criação de Usuário**: Cria um usuário com nome e senha, com validações para garantir que o nome não seja duplicado e a senha tenha pelo menos 8 caracteres.
- **Login**: Permite que o usuário realize login com suas credenciais de nome de usuário e senha.
- **Validação de Entradas**: A senha deve ter pelo menos 8 caracteres. Não é permitido criar um usuário com um nome já existente.

## Tecnologias Usadas

- **Java 23**
- **Spring Boot 3.1.4**
- **JUnit 5** (para testes unitários)
- **H2 Database** (em memória, usado para testes)


## Requisitos

- **Java 23**
- **Maven** (para gerenciar as dependências)
- **JUnit 5** (para execução de testes)

## Como Rodar o Projeto

1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/user-service.git
    cd user-service
    ```

2. Compile e rode o projeto utilizando Maven:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Como Executar os Testes

Para rodar os testes unitários, utilize o seguinte comando Maven:

```bash
mvn test





