# 🗄️ Documentación de la Base de Datos

Este documento describe la estructura de la base de datos utilizada para el servicio de catálogo de productos (`ProductCatalogService`) dentro de la plataforma e-commerce.

---

## 📦 Tabla: `products`

Esta tabla almacena la información de cada producto disponible en la tienda virtual.

| Columna       | Tipo de dato         | Restricciones          | Descripción                           |
|---------------|----------------------|-------------------------|----------------------------------------|
| `id`          | BIGINT               | PRIMARY KEY, AUTO_INCREMENT | Identificador único del producto     |
| `name`        | VARCHAR(255)         | NOT NULL               | Nombre del producto                   |
| `description` | TEXT                 | NULLABLE               | Descripción detallada del producto     |
| `price`       | DECIMAL(10, 2)       | NOT NULL               | Precio del producto                    |
| `stock`       | INTEGER              | NOT NULL, DEFAULT 0    | Cantidad disponible en inventario     |
| `created_at`  | TIMESTAMP            | NOT NULL, DEFAULT now()| Fecha y hora de creación del registro |

---

## 🔄 Relaciones

Actualmente esta tabla **no tiene relaciones** con otras entidades, ya que el sistema de órdenes no ha sido implementado aún. Sin embargo, en futuras versiones, cada producto estará vinculado con las órdenes a través de una tabla intermedia `order_items`.

---

## 🛠️ Notas técnicas

- Implementada mediante `ProductEntity.java` con anotaciones JPA (`@Entity`, `@Table`, `@Id`, etc.)
- Gestionada con Spring Data JPA a través de `JpaProductRepository`
- Se usa `BigDecimal` para el campo `price` para evitar errores de precisión en cálculos financieros

---

## 🧪 Ambiente de pruebas

Durante el desarrollo local se puede utilizar una base de datos en memoria (por ejemplo, H2) o PostgreSQL.  
La conexión se configura en el archivo:

src/main/resources/application.properties

---

## 🧭 Próximas extensiones

- Tabla `orders`: para registrar órdenes realizadas por los clientes
- Tabla `order_items`: relación entre productos y órdenes (muchos-a-muchos con cantidad y subtotal)
- Relación futura: `products.id` → `order_items.product_id`

---