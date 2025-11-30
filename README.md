<h1 align="center">📚 Challenge: Foro Hub API REST 📚</h1>

<p align="center">
<img src="https://img.shields.io/badge/Spring_Boot-F2F4F7?style=for-the-badge&logo=spring-boot" alt="Spring Boot Badge"/>
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java Badge"/>
<img src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL Badge"/>
<img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON-Web-Tokens&logoColor=white" alt="JWT Badge"/>
<img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black" alt="Swagger Badge"/>
</p>

## 🎯 Objetivo del Challenge

<em>Este proyecto fue desarrollado como parte de un desafío de programación con el objetivo de fortalecer habilidades en el desarrollo de APIs RESTful utilizando Spring Boot. Se trabajó en la implementación de un sistema completo de gestión de datos, incluyendo operaciones CRUD para múltiples entidades, seguridad con Spring Security y autenticación basada en JSON Web Tokens (JWT).</em>

---

## 📝 Descripción General

<em>
Foro Hub es una API REST que simula la funcionalidad de un foro en línea. Permite a los usuarios autenticarse, crear tópicos, responder a ellos y gestionar su información personal. La aplicación está diseñada para ser segura, escalable y fácil de mantener, siguiendo buenas prácticas de arquitectura y desarrollo backend. Todos los endpoints están protegidos mediante autenticación JWT.
</em>

---

## 🚀 Funcionalidades Principales

### 1️⃣ Autenticación de Usuario

🔐 Endpoint: `/login`  
<em>Los usuarios pueden autenticarse con su correo y contraseña. Si las credenciales son válidas, se genera un token JWT que debe incluirse en las solicitudes posteriores a endpoints protegidos.</em>

---

### 2️⃣ CRUD de Tópicos

🗣️ Endpoints para crear, listar, actualizar y eliminar tópicos.  
<em>Solo los usuarios autenticados pueden gestionar sus propios tópicos.</em>

---

### 3️⃣ CRUD de Usuarios

👤 Registro y gestión de usuarios.  
<em>Incluye creación, consulta, actualización y eliminación. Las contraseñas se almacenan de forma segura mediante hashing.</em>

---

### 4️⃣ CRUD de Respuestas

💬 Interacción en los tópicos mediante respuestas.  
<em>Los usuarios pueden publicar, consultar, editar y eliminar sus respuestas, filtradas por tópico.</em>

---

### 5️⃣ Manejo Global de Errores

⚠️ Respuestas claras y específicas para errores comunes:  
- ❌ 404: Recurso no encontrado  
- 🛑 400: Validaciones fallidas  
- 🔒 401: Credenciales inválidas  
- 🚫 403: Acceso denegado

---

## 🛠 Tecnologías Utilizadas

| Tecnología              | Descripción                                      |
|------------------------|--------------------------------------------------|
| ☕ Java                 | Lenguaje principal del proyecto                  |
| 🍃 Spring Boot         | Framework para construir la API REST             |
| 🔒 Spring Security     | Autenticación y autorización                     |
| 🌿 Spring Data JPA     | Persistencia de datos y repositorios             |
| 🐘 MySQL               | Base de datos relacional                         |
| ✈️ Flyway              | Migración y versionado del esquema de BD         |
| 🌐 Springdoc OpenAPI   | Documentación interactiva con Swagger UI         |
| 🔑 JWT (Auth0)         | Generación y validación de tokens de acceso      |

---

## 📁 Estructura del Proyecto

```plaintext
📦 src/main/java/com/forohub/
├── 📂 controller/       → 🎯 Controladores de la API (Topico, Usuario, etc.)
├── 📂 domain/           → 🧠 Lógica de negocio: entidades, DTOs, servicios
│   ├── 📁 topico/       → 🗣️ Funcionalidad relacionada con los tópicos
│   ├── 📁 usuario/      → 👤 Gestión de usuarios
│   └── 📁 respuesta/    → 💬 Gestión de respuestas
├── 📂 infra/            → 🛠️ Infraestructura: seguridad y excepciones
│   ├── 🔐 security/     → 🔒 Configuración de autenticación y JWT
│   └── ⚠️ exceptions/   → 🚨 Manejo global de errores
└── 🚀 ForoHubApplication.java → 🧩 Clase principal que inicia la aplicación

📦 src/main/resources/
├── ⚙️ application.properties → 📝 Configuración de la base de datos
└── 📂 db/migration/          → ✈️ Scripts de migración Flyway
```
⚙ Instalación y Ejecución

1️⃣ Clonar el Repositorio

```bash
git clone https://github.com/JhonatanO24/foro-hub.git
```

2️⃣ Configurar la Base de Datos
Edita el archivo application.properties con tus credenciales:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=validate
flyway.enabled=true
```
3️⃣ Ejecutar la Aplicación
Abre el proyecto en tu IDE favorito y ejecuta:

```java
ForoHubApplication.java
```
El servidor se iniciará en el puerto 8080.

📄 Documentación Interactiva
Accede a Swagger UI para probar los endpoints:

🔗 http://localhost:8080/swagger-ui.html
