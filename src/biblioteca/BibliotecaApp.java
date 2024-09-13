package biblioteca;

public class BibliotecaApp {
    public static void main(String[] args) {
        // Crear instancias de usuario, bibliotecario y libro
        Usuario usuario = new Usuario("Juan", "Pérez");
        Bibliotecario bibliotecario = new Bibliotecario("Ana", "Gómez");
        Libro libro = new Libro("El Quijote", "Cervantes", "12345");

        // Mostrar datos del usuario y bibliotecario
        usuario.mostrarDatos();
        bibliotecario.mostrarDatos();

        // Préstamo de libro
        bibliotecario.prestar(libro, usuario);

        // Devolución de libro
        bibliotecario.devolverLibro(libro);
    }
}