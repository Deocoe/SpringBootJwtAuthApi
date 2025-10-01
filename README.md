# Spring Boot JWT Auth API

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=spring)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-blue?style=for-the-badge&logo=postgresql)

API RESTful completa construída com Java e Spring Boot que implementa um sistema com autenticação e autorização seguras baseadas em token JWT. Este projeto serve como um boilerplate robusto para iniciar novas aplicações back-end.

## ✨ Features

-   **Autenticação Segura com JWT:** Endpoints de registro e login com geração e validação de token.
-   **Estrutura de Segurança Robusta:** O Spring Security está configurado com JWT, permitindo a fácil implementação futura de autorização e controle de acesso por papéis (Roles).
-   **Arquitetura em Camadas:** Código organizado em Controllers, Services e Repositories.
-   **Operações CRUD:** Funcionalidades completas para gerenciamento de Produtos.
-   **Tratamento de Exceções Centralizado:** Respostas de erro consistentes e claras para o cliente.
-   **Spring Data JPA:** Integração com banco de dados PostgreSQL.

## 🛠️ Tecnologias Utilizadas

-   **Java 17+**
-   **Spring Boot 3**
-   **Spring Security 6**
-   **JPA / Hibernate**
-   **PostgreSQL**
-   **JWT (JSON Web Tokens)**
-   **Maven**

## ⚙️ Configuração do Ambiente

Para executar este projeto, você precisa configurar as seguintes variáveis de ambiente no seu sistema ou na sua IDE:

-   `DB_NAME`: O nome do banco de dados que você criou no PostgreSQL (ex: `authApi`).
-   `PORT`: A porta onde seu servidor PostgreSQL está rodando (o padrão é `5432`).
-   `USERNAME`: O nome de usuário para acessar seu banco PostgreSQL.
-   `PASSWORD`: A senha para acessar seu banco PostgreSQL.

**Importante:** O banco de dados especificado em `DB_NAME` precisa ser criado manualmente no PostgreSQL antes de iniciar a aplicação.

## 🚀 Como Executar o Projeto




```bash
# 1. Clone o repositório
git clone [https://github.com/Deocoe/SpringBootJwtAuthApi.git](https://github.com/Deocoe/SpringBootJwtAuthApi.git)

# 2. Navegue até o diretório do projeto
cd SpringBootJwtAuthApi

# 3. Configure as variáveis de ambiente (veja a seção acima)

# 4. Execute o projeto com o Maven
./mvnw spring-boot:run
```

## 📋 Endpoints da API

Abaixo estão os principais endpoints disponíveis. Para rotas protegidas, é necessário enviar o token JWT no cabeçalho `Authorization` (ex: `Authorization: Bearer <token>`).

| Método | Rota                 | Descrição                        | Protegido |
| :---   |:---------------------| :---                             | :---:     |
| `POST` | `/auth/register`     | Registra um novo usuário.        | Não       |
| `POST` | `/auth/login`        | Autentica um usuário e retorna um token. | Não       |
|        |                      |                                  |           |
| `GET`  | `/api/produtos`      | Lista todos os produtos.           | Sim       |
| `GET`  | `/api/produtos/{id}` | Busca um produto específico pelo seu ID. | Sim       |
| `POST` | `/api/produtos`      | Cria um novo produto.            | Sim       |
| `PUT`  | `/api/produtos/{id}` | Atualiza um produto existente pelo seu ID. | Sim       |
| `DELETE`| `/api/produtos/{id}` | Deleta um produto pelo seu ID.     | Sim       |