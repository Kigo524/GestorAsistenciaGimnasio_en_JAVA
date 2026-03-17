import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //DAtos de mi base de datos (los configurados en la terminal)
    private static final String URL = "jdbc:mysql://localhost:3306/gym_db";
    private static final String USUARIO = "kigocode";
    private static final String CLAVE = "Enriqu3.";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            // Intentamos establecer el vínculo
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println(">>> [EXITO] Conexión establecida con la base de datos.");
        } catch (SQLException e) {
            System.out.println(">>> [ERROR] No se pudo conectar: " + e.getMessage());
        }
        return conexion;
    }
}
