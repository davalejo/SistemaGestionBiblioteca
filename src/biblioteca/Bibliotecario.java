package biblioteca;

public class Bibliotecario extends Persona implements Gestionable {

    public Bibliotecario(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Bibliotecario: " + nombre + " " + apellido);
    }

    @Override
    public void prestarLibro(Libro libro, Usuario usuario) {
        // Comprobar si el libro está disponible
        if (libro.isDisponible()) {
            libro.prestar();  // Cambia el estado del libro a no disponible
            System.out.println("El libro '" + libro.getTitulo() + "' ha sido prestado al usuario: " + usuario.nombre);
        } else {
            System.out.println("El libro '" + libro.getTitulo() + "' no está disponible para préstamo.");
        }
    }

    @Override
    public void devolverLibro(Libro libro) {
        libro.devolver();  // Cambia el estado del libro a disponible
        System.out.println("El libro '" + libro.getTitulo() + "' ha sido devuelto.");
    }
}