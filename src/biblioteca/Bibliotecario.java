package biblioteca;

public class Bibliotecario extends Persona {
    public Bibliotecario(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Bibliotecario: " + getNombre() + " " + getApellido());
    }
}