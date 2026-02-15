# To Do List (Java)

Um projeto de gerenciamento de lista de tarefas (CRUD) desenvolvido com Java e Spring Boot.

---

# Tecnologias Utilizadas (Stack)

- Spring Boot  
- Spring MVC  
- Spring Data JPA  
- SpringDoc OpenAPI 3 (Swagger)  
- MySQL  
- H2 Database (para testes)

---

# Práticas Aplicadas

- SOLID  
- DRY  
- YAGNI  
- KISS  
- API REST  
- Consultas com Spring Data JPA  
- Injeção de Dependências  
- Tratamento de respostas de erro  
- Documentação automática com Swagger (OpenAPI 3)  
- Testes com banco em memória (H2)

---

# Como Executar

## 1 Clonar o repositório
```bash
git clone <url-do-repositorio>
cd to-do-list
```

## 2 Construir o projeto
```bash
./mvnw clean package
```

## 3 Executar a aplicação
```bash
java -jar target/todolist-0.0.1-SNAPSHOT.jar
```
API disponível em:
```bash
http://localhost:8080
```
Swagger UI:
```bash
http://localhost:8080/swagger-ui.html
```

---

# API Endpoints
## Criar Tarefa
POST "/to_dos"
```json
{
    "nome": "Tarefa",
    "descricao": "Descrição da tarefa",
    "prioridade": 1,
    "concluido": false
}
```
## Listar Tarefa (lista tarefas ordenadas por prioridade.)
GET "/to_dos"
```json
[
  {
    "id": 1,
    "nome": "Tarefa",
    "descricao": "Descrição da tarefa",
    "prioridade": 1,
    "concluido": false
  },
  {
    "id": 2,
    "nome": "Tarefa 2",
    "descricao": "Descrição da tarefa 2",
    "prioridade": 2,
    "concluido": true
  }
]
```
## Atualizar Tarefa (atualiza uma tarefa existente com base no Id.)
PUT "/to_dos"
```json
{
    "nome": "Tarefa",
    "descricao": "Descrição da tarefa",
    "prioridade": 1,
    "concluido": false
}
```
## Excluir Tarefa (Remove a tarefa pelo Id e retorna lista.)
DELETE "/to_dos/{id}"
```bash
DELETE http://localhost:8080/to_dos/1
```