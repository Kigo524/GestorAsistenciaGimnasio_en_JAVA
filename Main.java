public class Main {
    public static void main(String[] args){
        System.out.println("--- Sistema de Gimnasio KIGOCODE GYM - Prueba");

        //primero crear una membresia, será mensual, de 500 pesos y dira un mes
        Membresia membresiaJuan = new Membresia("Mensual", 500.0, 1);

        //ahora un usuario que tenga esa membresia
        Usuario juan = new Usuario("Juan Perez", "12345678", "juan@email.com", membresiaJuan);

        //Primero mostramos la ficha del usuario
        System.out.println("Socio: " + juan.getNombre());
        System.out.println("Vencimiento: " + juan.getMembresia().getFechaVencimiento());
        System.out.println("Precio inicial: $" + juan.getMembresia().getPrecio());
        System.out.println("--------------------------");

        //aqui simulo 20 asistencias 
        System.out.println("Registrando 20 dias de entrenmanieto...");
        for (int i = 1; i<= 20; i++){
            juan.registrarAsistencia();
        }

        //verifico si es que se ganó el premio por constancia
        juan.verificarPremio(); //está en usuario

        //para el resultado final
        System.out.println("-------------");
        System.out.println("Nuevo precio para el próximo pago: $" + juan.getMembresia().getPrecio());
        System.out.println("Asistencias actuales (reset): " + juan.getAsistenciasSeguidas());
    }
}
