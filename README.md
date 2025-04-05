# 🛒 Sales System

**Sales System** es una aplicación de consola en Java que permite gestionar productos, vendedores y ventas en una tienda virtual.  
Fue desarrollada como parte de un ejercicio técnico para demostrar habilidades en diseño orientado a objetos, manejo de excepciones, estructuras en memoria y arquitectura modular.

---

## ✅ Funcionalidades

- Registrar productos con ID, nombre, precio y categoría.
- Registrar vendedores con ID, nombre y sueldo.
- Registrar ventas relacionando productos y vendedores.
- Calcular comisiones por vendedor:
  - 5% si vendió hasta 2 productos.
  - 10% si vendió más de 2 productos.
- Buscar productos por:
  - Categoría
  - Rango de precios
  - Nombre
  - Ordenar por precio o nombre
- Mock de datos precargados para pruebas rápidas.

---

## 🗂️ Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── org.example/
│   │       ├── model/              # Clases de dominio (Product, Salesman, Sale, enum de Category)
│   │       ├── exceptions/         # Excepciones personalizadas
│   │       ├── Repositories/       # Repositorios en memoria
│   │       ├── service/            # Lógica de negocio (StoreService)
│   │       ├── ui/
│   │       │   └── cases/          # Cada acción del menú en consola como clase separada
│   │       ├── utils/              # Filtros y ordenamientos
│   │       ├── data/               # Carga de datos de ejemplo (mock)
│   │       └── Main.java           # Punto de entrada del programa
└── test/
    └── org.example/
        └── SalesSystemIntegrationTest.java  # Test general de flujo completo
```

---

## ▶️ ¿Cómo correrlo?

### Opción 1: Usando IntelliJ IDEA

1. Cloná el proyecto:

   ```bash
   git clone https://github.com/MackyAlimena/Sales-System.git
   ```

2. Abrilo con IntelliJ.
3. Hacé clic derecho en `Main.java` > **Run 'Main.main()'**
4. La consola te mostrará el menú interactivo.

> 🔹 Se cargan automáticamente productos, vendedores y ventas de ejemplo (via `DataSeeder`).

---

### Opción 2: Desde terminal (con Gradle)

1. Asegurate de tener Java 17+ y Gradle instalado.
2. Cloná el proyecto:

   ```bash
   git clone https://github.com/MackyAlimena/Sales-System.git
   cd Sales-System
   ```

3. Ejecutá el sistema:

   ```bash
   ./gradlew run
   ```

> Si no tenés permisos para ejecutar `gradlew`, hacé: `chmod +x gradlew`

---

## 🧪 Test automático

Podés ejecutar un test de integración completo con:

```bash
./gradlew test
```


## 🙋 Autor

**Macky Alimena**  
Desarrollador Java | Ingeniería en Informática  
GitHub: [@MackyAlimena](https://github.com/MackyAlimena)
