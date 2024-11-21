package biblioteca.services;

import biblioteca.database.DatabaseConnection;
import biblioteca.models.Libro;
import biblioteca.models.Prestamo;
import biblioteca.models.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrestamoService {
    public void agregarPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO Prestamo (libro_id, usuario_id, fecha_prestamo, fecha_devolucion) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, prestamo.getLibro().getId());
            statement.setInt(2, prestamo.getUsuario().getId());
            statement.setDate(3, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
            statement.setDate(4, prestamo.getFechaDevolucion() == null ? null : new java.sql.Date(prestamo.getFechaDevolucion().getTime()));
            statement.executeUpdate();
            System.out.println("Préstamo registrado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void devolverPrestamo(int prestamoId) {
        String sql = "UPDATE Prestamo SET fecha_devolucion = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(new Date().getTime())); // Fecha actual
            statement.setInt(2, prestamoId);
            statement.executeUpdate();
            System.out.println("Préstamo devuelto con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Prestamo> listarPrestamos() {
        List<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM Prestamo";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Prestamo prestamo = new Prestamo(
                        resultSet.getInt("id"),
                        new Libro(resultSet.getInt("libro_id"), null, null, null, true), // Simplificado
                        new Usuario(resultSet.getInt("usuario_id"), null, null),         // Simplificado
                        resultSet.getDate("fecha_prestamo"),
                        resultSet.getDate("fecha_devolucion")
                );
                prestamos.add(prestamo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prestamos;
    }

    public void eliminarPrestamo(int prestamoId) {
        String sql = "DELETE FROM Prestamo WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, prestamoId);
            statement.executeUpdate();
            System.out.println("Préstamo eliminado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}