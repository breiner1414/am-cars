# am-cars
apuntes mecanica carros

## Descripción
Demo back apuntes mecánica - Aplicación backend para gestión de apuntes sobre mecánica de carros.

## Tecnologías

### Lenguaje y Framework
- **Java 17**
- **Spring Boot 3.5.7**

### Gestión de Dependencias
- **Maven**

## Dependencias y Librerías

### Spring Boot Starters
- **spring-boot-starter-web**: Framework para crear APIs REST, incluye Spring MVC y servidor Tomcat embebido
- **spring-boot-starter-data-jpa**: Persistencia de datos con JPA/Hibernate y repositorios (incluye JDBC internamente)
- **spring-boot-starter-data-jdbc**: Acceso a base de datos mediante JDBC (redundante si se usa JPA)

### Herramientas de Desarrollo
- **spring-boot-devtools**: Herramientas de desarrollo con recarga automática
- **lombok**: Reducción de código boilerplate mediante anotaciones (@Getter, @Setter, @Data, etc.)

### Testing
- **spring-boot-starter-test**: Framework de testing con JUnit, Mockito y AssertJ

## Arquitectura

El proyecto sigue una **arquitectura de 4 capas** con DTOs:

1. **Controller** - Capa de presentación (REST API)
2. **Service** - Capa de lógica de negocio
3. **Repository** - Capa de acceso a datos
4. **Entity** - Capa de entidades JPA
5. **DTO** - Data Transfer Objects

## Estructura del Proyecto
```
apuntes-mecanica/
├── src/
│   ├── main/
│   │   ├── java/com/am_cars/apuntes_mecanica/
│   │   │   ├── controller/     # Controladores REST
│   │   │   ├── service/        # Lógica de negocio
│   │   │   ├── repository/     # Repositorios JPA
│   │   │   ├── entity/         # Entidades JPA
│   │   │   ├── dto/            # Data Transfer Objects
│   │   │   └── ApuntesMecanicaApplication.java
│   │   └── resources/
│   └── test/
└── pom.xml
```

### Flujo de Datos
```
Cliente → Controller → Service → Repository → Base de Datos
         (DTO)       (DTO)     (Entity)      (Entity)
```

## Requisitos
- Java 17 o superior
- Maven 3.6+

## Ejecución
```bash
mvn spring-boot:run
```