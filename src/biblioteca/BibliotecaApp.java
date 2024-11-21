package biblioteca;

import biblioteca.models.Libro;
import biblioteca.models.Usuario;
import biblioteca.models.Prestamo;
import biblioteca.services.LibroService;
import biblioteca.services.UsuarioService;
import biblioteca.services.PrestamoService;

import java.util.Date;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibroService libroService = new LibroService();
        UsuarioService usuarioService = new UsuarioService();
        PrestamoService prestamoService = new PrestamoService();

        boolean running = true;

        System.out.println("¡Bienvenido al Sistema de Gestión de Biblioteca!");

        while (running) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Gestión de Libros");
            System.out.println("2. Gestión de Usuarios");
            System.out.println("3. Gestión de Préstamos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> gestionarLibros(scanner, libroService);
                case 2 -> gestionarUsuarios(scanner, usuarioService);
                case 3 -> gestionarPrestamos(scanner, prestamoService, libroService, usuarioService);
                case 4 -> {
                    running = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void gestionarLibros(Scanner scanner, LibroService libroService) {
        System.out.println("\nGestión de Libros:");
        System.out.println("1. Agregar Libro");
        System.out.println("2. Listar Libros");
        System.out.println("3. Actualizar Libro");
        System.out.println("4. Eliminar Libro");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcion) {
            case 1 -> {
                System.out.print("Título: ");
                String titulo = scanner.nextLine();
                System.out.print("Autor: ");
                String autor = scanner.nextLine();
                System.out.print("ISBN: ");
                String isbn = scanner.nextLine();
                Libro libro = new Libro(0, titulo, autor, isbn, true);
                libroService.agregarLibro(libro);
                System.out.println("Libro agregado con éxito.");
            }
            case 2 -> {
                System.out.println("Listado de Libros:");
                libroService.listarLibros().forEach(libro ->
                        System.out.println(libro.getId() + " - " + libro.getTitulo() + " (Disponible: " + libro.isDisponible() + ")"));
            }
            case 3 -> {
                System.out.print("ID del Libro a actualizar: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nuevo Título: ");
                String titulo = scanner.nextLine();
                System.out.print("Nuevo Autor: ");
                String autor = scanner.nextLine();
                System.out.print("Nuevo ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("¿Está disponible? (true/false): ");
                boolean disponible = scanner.nextBoolean();
                Libro libro = new Libro(id, titulo, autor, isbn, disponible);
                libroService.actualizarLibro(libro);
                System.out.println("Libro actualizado con éxito.");
            }
            case 4 -> {
                System.out.print("ID del Libro a eliminar: ");
                int id = scanner.nextInt();
                libroService.eliminarLibro(id); // Uso del método corregido
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    private static void gestionarUsuarios(Scanner scanner, UsuarioService usuarioService) {
        System.out.println("\nGestión de Usuarios:");
        System.out.println("1. Agregar Usuario");
        System.out.println("2. Listar Usuarios");
        System.out.println("3. Actualizar Usuario");
        System.out.println("4. Eliminar Usuario");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcion) {
            case 1 -> {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Apellido: ");
                String apellido = scanner.nextLine();
                Usuario usuario = new Usuario(0, nombre, apellido);
                usuarioService.agregarUsuario(usuario);
                System.out.println("Usuario agregado con éxito.");
            }
            case 2 -> {
                System.out.println("Listado de Usuarios:");
                usuarioService.listarUsuarios().forEach(usuario ->
                        System.out.println(usuario.getId() + " - " + usuario.getNombre() + " " + usuario.getApellido()));
            }
            case 3 -> {
                System.out.print("ID del Usuario a actualizar: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nuevo Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Nuevo Apellido: ");
                String apellido = scanner.nextLine();
                Usuario usuario = new Usuario(id, nombre, apellido);
                usuarioService.actualizarUsuario(usuario);
                System.out.println("Usuario actualizado con éxito.");
            }
            case 4 -> {
                System.out.print("ID del Usuario a eliminar: ");
                int id = scanner.nextInt();
                usuarioService.eliminarUsuario(id);
                System.out.println("Usuario eliminado con éxito.");
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    private static void gestionarPrestamos(Scanner scanner, PrestamoService prestamoService, LibroService libroService, UsuarioService usuarioService) {
        System.out.println("\nGestión de Préstamos:");
        System.out.println("1. Registrar Préstamo");
        System.out.println("2. Devolver Préstamo");
        System.out.println("3. Listar Préstamos");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcion) {
            case 1 -> {
                System.out.print("ID del Libro: ");
                int libroId = scanner.nextInt();
                System.out.print("ID del Usuario: ");
                int usuarioId = scanner.nextInt();
                Libro libro = new Libro(libroId, null, null, null, true);
                Usuario usuario = new Usuario(usuarioId, null, null);
                Prestamo prestamo = new Prestamo(0, libro, usuario, new Date(), null);
                prestamoService.agregarPrestamo(prestamo);
                System.out.println("Préstamo registrado con éxito.");
            }
            case 2 -> {
                System.out.print("ID del Préstamo a devolver: ");
                int prestamoId = scanner.nextInt();
                prestamoService.devolverPrestamo(prestamoId);
                System.out.println("Préstamo devuelto con éxito.");
            }
            case 3 -> {
                System.out.println("Listado de Préstamos:");
                prestamoService.listarPrestamos().forEach(prestamo ->
                        System.out.println("Préstamo ID: " + prestamo.getId() +
                                ", Libro ID: " + prestamo.getLibro().getId() +
                                ", Usuario ID: " + prestamo.getUsuario().getId() +
                                ", Fecha Préstamo: " + prestamo.getFechaPrestamo() +
                                ", Fecha Devolución: " + prestamo.getFechaDevolucion()));
            }
            default -> System.out.println("Opción no válida.");
        }
    }
}