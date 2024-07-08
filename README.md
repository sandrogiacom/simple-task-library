# Simple Task Library


## Features

- [x] CRUD task definition
- [x] CRUD task step definition
- [x] CRUD task attribute definition
- [x] Add Swagger
- [ ] Create task instance
- [ ] Start task instance
- [ ] Start task (step instance)
- [ ] Complete task (step instance)
- [ ] Complete task instance
- [ ] Add Konsist

```sql
SELECT * FROM TASK_DEFINITION;
SELECT * FROM TASK_STEP_DEFINITION ;
SELECT * FROM TASK_ATTRIBUTE_DEFINITION;
SELECT * FROM TASK_INSTANCE;
SELECT * FROM TASK_STEP_INSTANCE;
SELECT * FROM TASK_ATTRIBUTE_INSTANCE;
```

```sql delete
delete from TASK_ATTRIBUTE_INSTANCE;
delete from TASK_STEP_INSTANCE;
delete from TASK_INSTANCE;
```


## Swagger UI
http://localhost:8080/swagger-ui.html

## H2 Console
http://localhost:8080/h2-console

## Problem solved: mapstruct with kotlin and maven
https://stackoverflow.com/questions/68819675/mapstruct-cannot-find-symbol-kotlin-maven


