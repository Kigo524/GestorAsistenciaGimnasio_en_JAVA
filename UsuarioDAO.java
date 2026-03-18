import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    /**
     * Toma un objeto Usuario y lo guarda en la base de datos.
     * Este es un método clave para el portafolio.
     */
    public void insertar(Usuario usuario) {
        // La consulta SQL con '?' para evitar Inyección SQL para seguridad
        //ya añadí el id_membresia a la consulta
        String sql = "INSERT INTO usuarios (nombre, ine, email, asistencias_seguidas, id_membresia) VALUES (?, ?, ?, ?, ?)";

        // Uso try-with-resources para que la conexión se cierre sola (eficiencia)
        try (Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getIne());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4, usuario.getAsistenciasSeguidas());

            //aquí pasamos el ID de la membresía que el usuario tiene asociada
            ps.setInt(5, usuario.getMembresia().getId());

            ps.executeUpdate();
            System.out.println(">>> [DB] Usuario " + usuario.getNombre() + " vinculado a su membresía.");

        } catch (SQLException e) {
            System.out.println(">>> [ERROR DB] Error al insertar usuario: " + e.getMessage());
        }
    }
}
