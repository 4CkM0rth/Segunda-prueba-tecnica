🛒 Product Catalog API
Segunda prueba técnica: backend para gestión de productos de un e-commerce, desarrollado en Java con Spring Boot y arquitectura hexagonal. Este proyecto implementa operaciones CRUD completas sobre productos, siguiendo principios RESTful y buenas prácticas de desarrollo profesional.

🚀 Tecnologías utilizadas
Java 17

Spring Boot 3.x

Spring Data JPA

PostgreSQL (puede usarse H2 para pruebas)

Maven

Swagger (OpenAPI 3 – springdoc-openapi)

Arquitectura hexagonal (puertos y adaptadores)

🧱 Estructura del proyecto
productcatalog/
├── domain/                  # Entidad y puerto del dominio
│   ├── model/
│   │   └── Product.java
│   └── repository/
│       └── ProductRepository.java
│
├── application/
│   └── service/
│       ├── ProductService.java
│       └── impl/ProductServiceImpl.java
│
├── infrastructure/
│   ├── controller/
│   │   └── ProductController.java
│   └── persistence/
│       ├── entity/ProductEntity.java
│       ├── repository/JpaProductRepository.java
│       └── adapter/ProductRepositoryImpl.java
│
├── config/
│   └── OpenApiConfig.java   # Configuración de Swagger/OpenAPI
│
├── resources/
│   └── application.properties
│
└── EcommerceApplication.java

⚙️ Cómo ejecutar el proyecto
1. Clonar el repositorio

   git clone https://github.com/4CkM0rth/Segunda-prueba-tecnica.git
   cd Segunda-prueba-tecnica
2. Compilar el proyecto

   mvn clean install

3. Ejecutar la aplicación

   mvn spring-boot:run

   La API estará disponible en:
   http://localhost:8080

📘 Documentación Swagger
Swagger UI está disponible automáticamente en:
http://localhost:8080/swagger-ui.html

🧪 Endpoints disponibles

Método	Ruta	Descripción
GET	/api/products	Listar todos los productos
GET	/api/products/{id}	Obtener producto por ID
POST	/api/products	Crear nuevo producto
PUT	/api/products/{id}	Actualizar producto existente
DELETE	/api/products/{id}	Eliminar producto
🧠 Arquitectura aplicada
Este proyecto aplica los principios de la arquitectura hexagonal (ports and adapters), separando claramente:

El dominio del negocio (Product, ProductRepository)

Los casos de uso (ProductService)

Los adaptadores de infraestructura (JPA, REST)

Las configuraciones externas (Swagger)

Esto permite mantener el sistema desacoplado, escalable y fácil de testear.

✅ Estado actual del proyecto
✔ Servicio de productos implementado

✔ Persistencia con JPA

✔ Documentación Swagger

✔ Arquitectura limpia y desacoplada

🔜 Servicio de órdenes (en desarrollo)

📎 Autor
Desarrollado por Sebastian Rojas – 2025
Repositorio: github.com/4CkM0rth/Segunda-prueba-tecnica