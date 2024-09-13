package biblioteca;

public interface Gestionable {
    void prestarLibro(Libro libro, Usuario usuario);
    void devolverLibro(Libro libro);
}