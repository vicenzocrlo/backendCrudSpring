# Cadastro de Usuários — Spring Boot + MySQL

CRUD completo (GET, POST, PUT, DELETE) em arquitetura MVC.

## Pré-requisitos
- JDK 17 ou superior
- MySQL/MariaDB rodando em localhost:3306 (ex.: XAMPP)
- Banco criado: `CREATE DATABASE teste_spring;`

## Configuração
Edite `src/main/resources/application.properties` e ajuste usuário/senha do seu MySQL.

## Executar
Pelo VS Code: abra `CadastroUsuariosApplication.java` e clique em Run.
Ou pelo terminal (com Maven instalado): `mvn spring-boot:run`

## Endpoints (base: http://localhost:8080/usuarios)
| Método | URL | Descrição |
|---|---|---|
| GET | /usuarios | Lista todos |
| GET | /usuarios/{id} | Busca um (404 se não existir) |
| POST | /usuarios | Cria (body JSON: nome, email) |
| PUT | /usuarios/{id} | Atualiza (404 se não existir) |
| DELETE | /usuarios/{id} | Exclui (404 se não existir) |
