package biblioteca.models;

import biblioteca.Persona;

public class Usuario extends Persona {
    public Usuario(int id, String nombre, String apellido) {
        super(id, nombre, apellido);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Usuario: " + getNombre() + " " + getApellido());
    }
}