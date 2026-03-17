import java.sql.Connection;

public class Main {
    public static void main(String[] args){

        Conexion.conectar();

        //todo lo demás se delega al Gimnasio

        //se crea un admin y un gimnasio
        Gerente admin = new Gerente("Raul", "123", "raul@gym.com", "admin", "1234");
        Gimnasio miGimnasio = new Gimnasio("Gimnasio *Mr México*", admin);

        //se crea un par de usuario con diferentes membresias
        //usuario 1: normal
        Membresia m1 = new Membresia("Mensual", 500.0, 1);
        Usuario u1 = new Usuario("Ana Lopez", "4455", "ana@gmail.com", m1);

        //usuario 2: Prueba de racha
        Membresia m2 = new Membresia("Anual", 5000.0, 12);
        Usuario u2 = new Usuario("Pedro Pascal", "6677", "pedro@gmail.com", m2);

        //usuario 3: Prueba de alerta (para probar el envio de correo) se crea con 0 meses (vence hoy mismo)
        Membresia m3 = new Membresia("Basica", 300.0, 0);
        Usuario u3 = new Usuario("José Alerta", "9999", "jose@correo.com", m3);

        //se registran en el gimnasio los usuarios con la hora corregida
        System.out.println("=== PROCESO DE REGISTROS ===");
        miGimnasio.registrarNuevoUsuario(u1);
        miGimnasio.registrarNuevoUsuario(u2);
        miGimnasio.registrarNuevoUsuario(u3);

        //que imprima la lista de los usuarios y el reporte en general
        miGimnasio.mostrarReporteEstado();

        //demostracion de toString
        System.out.println("=== VISTA DE SOCIO (toString) ===");
        System.out.println(u1);
        System.out.println(u3);
        System.out.println("--------------------------\n");

        //prueba de racha y descuento automatico
        System.out.println("=== SIMULANDO RACHA A PEDRO PASCAL (20 dias)===");
        for(int i=1; i<=20; i++){
            u2.registrarAsistencia(); //aqui llama internamente a verficarPremio() en Usuario
        }

        //simular una búsqueda
        Usuario encontrado = miGimnasio.buscarUsuario("6677");
        if(encontrado != null){ //si lo encuentra, que lo regrese
            System.out.println("Usuario encontrado: " + encontrado.getNombre());
        }

        //esto para ver que el precio de Pedro bajo un 10% automaticamente
        System.out.println("Estado final de Pedro: "+ u2);
        System.out.println("Precio de Pedro: " + u2.getMembresia().getPrecio());

        //esto es para probar las alertas con lo que está en Gimnasio
        System.out.println("\n--- Ejecutando proceso autpmático de alertas ---");
        miGimnasio.revisarVencimiento();
    }
}
