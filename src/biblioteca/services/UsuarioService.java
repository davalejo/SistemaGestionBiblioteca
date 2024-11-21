package biblioteca.services;

import biblioteca.database.DatabaseConnection;
import biblioteca.models.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    public void agregarUsuario(Usuario usuario) {
        String sqlPersona = "INSERT INTO Persona (nombre, apellido, tipo) VALUES (?, ?, 'Usuario')";
        String sqlUsuario = "INSERT INTO Usuario (id, prestamos) VALUES (?, 0)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statementPersona = connection.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement statementUsuario = connection.prepareStatement(sqlUsuario)) {

            // Insertar en la tabla Persona
            statementPersona.setString(1, usuario.getNombre());
            statementPersona.setString(2, usuario.getApellido());
            statementPersona.executeUpdate();

            // Obtener el ID generado
            ResultSet generatedKeys = statementPersona.getGeneratedKeys();
            if (generatedKeys.next()) {
                int personaId = generatedKeys.getInt(1);

                // Insertar en la tabla Usuario
                statementUsuario.setInt(1, personaId);
                statementUsuario.executeUpdate();

                System.out.println("Usuario agregado con éxito.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT Persona.id, Persona.nombre, Persona.apellido FROM Persona JOIN Usuario ON Persona.id = Usuario.id";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Usuario usuario = new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE Persona SET nombre = ?, apellido = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setInt(3, usuario.getId());
            statement.executeUpdate();
            System.out.println("Usuario actualizado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int usuarioId) {
        String sqlUsuario = "DELETE FROM Usuario WHERE id = ?";
        String sqlPersona = "DELETE FROM Persona WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statementUsuario = connection.prepareStatement(sqlUsuario);
             PreparedStatement statementPersona = connection.prepareStatement(sqlPersona)) {

            // Eliminar de la tabla Usuario
            statementUsuario.setInt(1, usuarioId);
            statementUsuario.executeUpdate();

            // Eliminar de la tabla Persona
            statementPersona.setInt(1, usuarioId);
            statementPersona.executeUpdate();

            System.out.println("Usuario eliminado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
