# Lab Spring Boot Coders

API REST desarrollada con Spring Boot para practicar la construccion de controladores, servicios, repositorios y documentacion interactiva con Swagger/OpenAPI. El proyecto gestiona coders en memoria, expone endpoints de consulta y mantenimiento, e incluye rutas adicionales para ejercicios de saludos personalizados y conteo de tareas.

## Tabla de contenido

- [Caracteristicas](#caracteristicas)
- [Tecnologias](#tecnologias)
- [Requisitos](#requisitos)
- [Instalacion y ejecucion](#instalacion-y-ejecucion)
- [Documentacion Swagger](#documentacion-swagger)
- [Endpoints principales](#endpoints-principales)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Ejemplos de uso](#ejemplos-de-uso)
- [Pruebas](#pruebas)

## Caracteristicas

- Gestion de coders mediante operaciones CRUD.
- Busqueda de coders por clan.
- Conteo total de coders registrados.
- Endpoint de saludo personalizado.
- Endpoint para contar tareas definidas en el servicio.
- Persistencia en memoria usando un repositorio basado en `List`.
- Documentacion interactiva con Swagger UI.
- Arquitectura por capas: controladores, servicios, repositorios y modelos.

## Tecnologias

- Java 21
- Spring Boot 3.5.14
- Spring Web
- Maven
- Lombok
- Springdoc OpenAPI / Swagger UI
- JUnit 5 para pruebas

## Requisitos

Antes de ejecutar el proyecto, asegurate de tener instalado:

- JDK 21 o superior
- Maven 3.9 o superior, o usar el wrapper incluido `./mvnw`

Puedes verificar tu instalacion con:

```bash
java --version
mvn --version
```

## Instalacion y ejecucion

Clona el repositorio:

```bash
git clone https://github.com/Jajodisant/lab-springboot-coders.git
cd lab-springboot-coders
```

Ejecuta la aplicacion con Maven Wrapper:

```bash
./mvnw spring-boot:run
```

En Windows:

```bash
mvnw.cmd spring-boot:run
```

La API quedara disponible por defecto en:

```text
http://localhost:8080
```

## Documentacion Swagger

El proyecto incluye documentacion interactiva generada con Springdoc OpenAPI.

```text
http://localhost:8080/docs
```

Desde esta interfaz puedes explorar los endpoints, revisar los modelos de datos y ejecutar peticiones directamente desde el navegador.

## Endpoints principales

| Metodo | Ruta | Descripcion |
| --- | --- | --- |
| `GET` | `/api/coders` | Lista todos los coders registrados en memoria. |
| `GET` | `/api/coders/{id}` | Consulta un coder por su ID. |
| `GET` | `/api/coders/search?clan={clan}` | Busca coders por clan. |
| `POST` | `/api/coders` | Crea un nuevo coder. |
| `PUT` | `/api/coders/{id}` | Actualiza el nombre y clan de un coder existente. |
| `DELETE` | `/api/coders/{id}` | Elimina un coder por su ID. |
| `GET` | `/api/coders/stats/count` | Retorna la cantidad total de coders. |
| `GET` | `/greet?name={name}` | Genera un saludo personalizado. |
| `GET` | `/tasks/count` | Retorna la cantidad de tareas registradas en el servicio. |

## Estructura del proyecto

```text
src
├── main
│   ├── java/com/riwi/LabSpringBoot
│   │   ├── config
│   │   │   ├── AppConfig.java
│   │   │   └── SwaggerConfig.java
│   │   ├── controllers
│   │   │   ├── CoderController.java
│   │   │   ├── CoderStatsController.java
│   │   │   ├── GreetingController.java
│   │   │   └── TaskController.java
│   │   ├── models
│   │   │   └── Coder.java
│   │   ├── repositories
│   │   │   └── CoderRepository.java
│   │   ├── services
│   │   │   ├── CoderService.java
│   │   │   ├── GreetingService.java
│   │   │   └── TaskService.java
│   │   └── LabSpringBootApplication.java
│   └── resources
│       └── application.properties
└── test
    └── java/com/riwi/LabSpringBoot
        └── LabSpringBootApplicationTests.java
```

## Ejemplos de uso

Crear un coder:

```bash
curl -X POST http://localhost:8080/api/coders \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "name": "Jainer Pabòn",
    "clan": "Hamilton"
  }'
```

Listar coders:

```bash
curl http://localhost:8080/api/coders
```

Buscar coders por clan:

```bash
curl "http://localhost:8080/api/coders/search?clan=Hamilton"
```

Actualizar un coder:

```bash
curl -X PUT http://localhost:8080/api/coders/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Jainer Pabòn Borja",
    "clan": "Hamilton"
  }'
```

Eliminar un coder:

```bash
curl -X DELETE http://localhost:8080/api/coders/1
```

## Pruebas

Para ejecutar las pruebas del proyecto:

```bash
./mvnw test
```

En Windows:

```bash
mvnw.cmd test
```

## Notas

- La informacion de coders se almacena en memoria, por lo que se pierde al reiniciar la aplicacion.
- Este proyecto esta orientado a practica academica y aprendizaje de fundamentos de Spring Boot.
- La ruta de Swagger esta configurada en `application.properties` mediante `springdoc.swagger-ui.path=/docs`.
