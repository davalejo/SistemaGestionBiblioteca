package biblioteca;

public class Usuario extends Persona {
    private int maxLibrosPrestados;
    private int librosPrestados;

    public Usuario(String nombre, String apellido, int maxLibrosPrestados) {
        super(nombre, apellido);
        this.maxLibrosPrestados = maxLibrosPrestados;
        this.librosPrestados = 0;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Usuario: " + getNombre() + " " + getApellido() + ", Máximo de libros prestados: " + maxLibrosPrestados + ", Libros prestados actualmente: " + librosPrestados);
    }

    public int getMaxLibrosPrestados() {
        return maxLibrosPrestados;
    }

    public void setMaxLibrosPrestados(int maxLibrosPrestados) {
        this.maxLibrosPrestados = maxLibrosPrestados;
    }

    public int getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
    }
}