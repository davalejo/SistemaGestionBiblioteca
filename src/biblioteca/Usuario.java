package biblioteca;

public class Usuario extends Persona {
    public Usuario(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Usuario: " + nombre + " " + apellido);
    }
}