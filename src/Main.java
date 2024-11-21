import biblioteca.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Conexión exitosa a la base de datos.");

            // Aquí simula las operaciones CRUD y préstamos
            // Ejemplo: Agregar un libro o registrar un préstamo

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
