# Projeto ToDoList

Este é um projeto simples de API REST para gerenciar tarefas diárias, desenvolvido em Java com Spring Boot e utilizando um banco de dados PostgreSQL.

## Funcionalidades

- Criar, atualizar, listar e excluir tarefas.
- As tarefas têm atributos como nome, descrição, status (Dependente, Em Progresso, Concluída), observações, data de criação e data de atualização.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.4**
- **Maven**
- **PostgreSQL**
- **Hibernate (JPA)**

## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:

- [JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)
- Um cliente de API, como o [Postman](https://www.postman.com/downloads/), para testar as rotas da API.

## Configuração do Banco de Dados

1. Crie um banco de dados no PostgreSQL:
   ```sql
   CREATE DATABASE tarefasdb;


# Executando a Aplicação

## Clone o repositório:

```
git clone https://github.com/seu_usuario/todolist.git
```
Navegue até a pasta do projeto:

```
cd todolist
```
Execute o projeto usando Maven:

```
./mvnw spring-boot:run
```

# Rotas da API

- Listar todas as tarefas
- Método: GET
- Endpoint: /api/tarefas

```
[
  {
    "id": 1,
    "nome": "Tarefa 1",
    "descricao": "Descrição da tarefa 1",
    "status": "DEPENDENTE",
    "observacoes": "Nenhuma",
    "dataCriacao": "2024-09-24T19:20:32",
    "dataAtualizacao": "2024-09-24T19:25:32"
  }
]
```


# Criar uma nova tarefa
- Método: POST
- Endpoint: /api/tarefas

```
{
  "nome": "Nova tarefa",
  "descricao": "Descrição da nova tarefa",
  "status": "DEPENDENTE",
  "observacoes": "Alguma observação"
}
```

# Atualizar uma tarefa
- Método: PUT
- Endpoint: /api/tarefas/{id}

