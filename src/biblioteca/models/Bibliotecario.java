package biblioteca.models;

import biblioteca.Gestionable;
import biblioteca.Persona;
import biblioteca.services.PrestamoService;

import java.util.Date;

public class Bibliotecario extends Persona implements Gestionable {
    public Bibliotecario(int id, String nombre, String apellido) {
        super(id, nombre, apellido);
    }

    @Override
    public void consultarLibro(String titulo) {
            System.out.println("Consultando el libro: " + titulo);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Bibliotecario: " + getNombre() + " " + getApellido());
    }

    @Override
    public void prestarLibro(Libro libro, Usuario usuario) {
        if (libro.isDisponible()) {
            libro.setDisponible(false); // Cambiar estado del libro
            Prestamo prestamo = new Prestamo(0, libro, usuario, new Date(), null); // Crear el préstamo
            PrestamoService prestamoService = new PrestamoService();
            prestamoService.agregarPrestamo(prestamo); // Registrar el préstamo en la base de datos
            System.out.println("El libro '" + libro.getTitulo() + "' ha sido prestado a " + usuario.getNombre());
        } else {
            System.out.println("El libro no está disponible.");
        }
    }


    @Override
    public void devolverLibro(Libro libro) {
        libro.devolver(); // Actualiza el estado del libro localmente
        System.out.println("Libro devuelto: " + libro.getTitulo());
    }
}