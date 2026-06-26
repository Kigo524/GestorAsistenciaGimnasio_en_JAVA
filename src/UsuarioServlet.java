import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Esta etiqueta define la URL con la que el HTML llamará a este código Java
@WebServlet("/registrarUsuario")
public class UsuarioServlet extends HttpServlet {
    
    // Instancias tu DAO que ya interactúa con tu MySQL
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Configurar respuestas para evitar problemas de acentos
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // 2. Capturar los datos que vienen desde el formulario HTML
        String nombre = request.getParameter("nombre");
        // Asegúrate de cambiar "cedula" o "id" según los atributos reales de tu clase Usuario
        String cedula = request.getParameter("cedula"); 

        try {
            // 3. Crear el objeto Usuario usando tus clases actuales
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(nombre);
            // nuevoUsuario.setCedula(cedula); // Usa el método set real de tu clase

            // 4. Mandar a llamarla a tu Base de Datos con tu DAO existente
            // Reemplaza "insertar" por el nombre exacto de tu método en UsuarioDAO
            boolean guardado = usuarioDAO.insertar(nuevoUsuario); 

            if (guardado) {
                out.print("¡Usuario " + nombre + " registrado exitosamente en el Gimnasio!");
            } else {
                out.print("Error: No se pudo registrar el usuario en la base de datos."); // <-- Asegúrate de que diga out.print y no out.print(s: ...
            }

        } catch (Exception e) {
            out.print("Ocurrió un error en el servidor: " + e.getMessage());
        }
    }
}
