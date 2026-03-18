import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class MembresiaDAO {

    public int insertar(Membresia membresia) {
        String sql = "INSERT INTO membresias (tipo, precio, fecha_vencimiento, pagada) VALUES (?, ?, ?, ?)";
        int idGenerado = -1;

        // Pedimos explícitamente que nos devuelva las llaves generadas (el ID)
        try (Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, membresia.getTipo());
            ps.setDouble(2, membresia.getPrecio());
            // Convertimos LocalDate de Java a Date de SQL
            ps.setDate(3, Date.valueOf(membresia.getFechaVencimiento()));
            ps.setBoolean(4, membresia.isPagada());

            ps.executeUpdate();

            // Aquí recuperamos el ID que MySQL inventó para esta fila
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
                membresia.setId(idGenerado); // Se lo asignamos al objeto en Java
            }
            
            System.out.println(">>> [DB] Membresía guardada con ID: " + idGenerado);

        } catch (SQLException e) {
            System.out.println(">>> [ERROR DB] Error al insertar membresía: " + e.getMessage());
        }
        return idGenerado;
    }
}
