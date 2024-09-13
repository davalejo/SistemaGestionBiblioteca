# Sistema de Gestión de Biblioteca

Este es un sistema básico de gestión de bibliotecas desarrollado en **Java** aplicando los principios de **Programación Orientada a Objetos (POO)**. Permite gestionar libros, usuarios y préstamos de libros. El código está diseñado para principiantes y sigue las mejores prácticas de POO.

## Requisitos

Antes de ejecutar el programa, asegúrate de tener instalado en el PC:

- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Git](https://git-scm.com/)

## Lógica del Programa

El sistema de gestión de la biblioteca sigue una estructura basada en clases y objetos, implementando los principios clave de POO: **herencia**, **encapsulamiento**, **polimorfismo** y **abstracción**.

- **Persona (Clase abstracta)**: Clase base de la que heredan las clases `Usuario` y `Bibliotecario`. Incluye los atributos comunes de una persona como `nombre` y `apellido`.
- **Usuario y Bibliotecario (Herencia)**: Ambas clases heredan de `Persona` e implementan el método `mostrarDatos()` de manera personalizada.
- **Libro (Encapsulamiento)**: Clase con atributos privados `titulo`, `autor`, `isbn` y `disponible`. Incluye métodos `prestar()` y `devolver()` para gestionar el estado de los libros.
- **Gestionable (Interfaz)**: Define los métodos `prestarLibro()` y `devolverLibro()`, implementados por la clase `Bibliotecario`.

El programa simula el proceso de préstamo y devolución de libros, adiconal verifica disponibilidad y gestiona los usuarios que solicitan préstamos.

## Cómo ejecutar el programa

Sigue los siguientes pasos para ejecutar el programa:

| Paso | Descripción | Instrucciones detalladas |
|------|-------------|--------------------------|
| **1** | Clonar el repositorio | - Abre la terminal o el panel de Git en **IntelliJ IDEA**. <br> - Ejecuta el siguiente comando en la terminal: <br> `git clone https://github.com/tu-usuario/Sistema-Gestion-Biblioteca.git` |
| **2** | Abrir el proyecto | - Ve a **File** > **Open...** en el menú superior. <br> - Navega hasta la carpeta donde clonaste el repositorio y selecciona el proyecto. <br>  |
| **3** | Compilar y ejecutar el proyecto | - Asegúrate de que el JDK esté configurado en el proyecto. Para esto, ve a **File** > **Project Structure** > **Project** y selecciona la versión del JDK adecuada. <br> - En el panel izquierdo, ve a la clase `Main.java`. <br> - Haz clic derecho en `Main.java` y selecciona **Run 'Main'** para ejecutar el programa. |
| **4** | Interactuar con el programa | - El programa mostrará información sobre los libros disponibles, los usuarios y bibliotecarios. <br> - Puedes ver cómo se simulan los préstamos y devoluciones de libros. |
| **5** | Realizar modificaciones (opcional) | - Puedes modificar el código en las clases `Libro`, `Usuario`, `Bibliotecario`, etc., para personalizar el comportamiento del sistema. <br> - Después de realizar modificaciones, vuelve a compilar y ejecutar el programa para ver los cambios. |

## Cómo funciona el sistema

1. **Creación de Usuarios y Bibliotecarios**: El programa crea instancias de las clases `Usuario` y `Bibliotecario`, heredando la funcionalidad de la clase `Persona`.
2. **Gestión de Libros**: La clase `Libro` encapsula los detalles de cada libro (título, autor, ISBN) y permite prestar o devolver libros utilizando métodos de la clase.
3. **Préstamo y Devolución**: La clase `Bibliotecario` implementa la interfaz `Gestionable` para gestionar el préstamo y devolución de libros, verificando la disponibilidad y el número máximo de libros prestados por usuario.
4. **Salida del Programa**: A través de la clase `Main`, el sistema simula los diferentes casos de préstamos y devoluciones y muestra la información relevante en la consola.

## Estructura del Proyecto

El proyecto sigue la siguiente estructura:

Sistema-Gestion-Biblioteca/ │ ├── src/ │ ├── main/ │ │ ├── java/ │ │ │ ├── Biblioteca/ │ │ │ │ ├── Persona.java │ │ │ │ ├── Usuario.java │ │ │ │ ├── Bibliotecario.java │ │ │ │ ├── Libro.java │ │ │ │ ├── Gestionable.java │ │ │ │ └── Main.java │ └── README.md

## Notas adicionales

- Si tienes problemas al ejecutar el programa, verifica la versión de Java, que tenga correcta configuración.
- Puedes hacer pruebas adicionales o agregar más funcionalidades para mejorar el sistema.

## Contribuir

Si deseas contribuir a este proyecto, puedes realizar un fork del repositorio, hacer las mejoras necesarias y enviar un pull request. 
