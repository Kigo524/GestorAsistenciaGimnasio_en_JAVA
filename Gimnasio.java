import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Gimnasio {
    
    private String nombre;
    private ArrayList <Usuario> listaUsuarios;
    private double totalVentas;
    private Gerente gerente;

    //aqui defino el horario de venta (para mi, de 8 a 22 horas)
    private final LocalTime HORA_APRETURA = LocalTime.of(8, 0);
    private final LocalTime HORA_CIERRE = LocalTime.of(22, 0);

    public Gimnasio(String nombre, Gerente gerente){
        this.nombre = nombre;
        this.gerente = gerente;
        this.listaUsuarios = new ArrayList<>();
        this.totalVentas = 0.0;
    }

    public void mostrarReporteEstado(){
        System.out.println("\n *****REPORTE: " + this.nombre + " ******");
        System.out.println("Gerente en turno: " + gerente.getNombre());
        System.out.println("Total de usuario suscritos: " + listaUsuarios.size());
        System.out.println("Ingresos: $" + totalVentas);
        System.out.println("****************\n");
    }

    //Buscador por INE (para cuando se necesite)
    public Usuario buscarUsuario(String ine){
        for (Usuario u: listaUsuarios){
            if(u.getIne().equalsIgnoreCase(ine)){
                return u;
            }
        }
        return null; //si es que no lo encuentra
    }

    //para inscribir a alguien y cobrarle el mismo dia
    //aqui también van las variables de apretura y cierre
    public void registrarNuevoUsuario(Usuario u){
        //esto es para sacar el tiempo de ahora
        LocalTime ahora = LocalTime.now();

        //verificar si la hora actual está entre la apertura y el cierre
        if(ahora.isAfter(HORA_APRETURA) && ahora.isBefore(HORA_CIERRE)){
            listaUsuarios.add(u);
            totalVentas += u.getMembresia().getPrecio();
            System.out.println("[VENTA] Socio " + u.getNombre() + " registrado con éxito a las " + ahora);
        } else{
            System.out.println("[SISTEMA CERRADO] No se pueden realizar ventas fuera de horario.");
            System.out.println("Horario de atención: " + HORA_APRETURA + " a " + HORA_CIERRE);
            System.out.println("Hora actual: " + ahora);
        }
    }

    //estos dos métodos seguidos son para enviar correos cuando se vaya a terminar la memebresia
    public void revisarVencimiento(){
        LocalDate hoy = LocalDate.now();
        System.out.println("=====ESCANEANDO MEMBRESIAS PROXIMAS A VENCER ====");

        for (Usuario u: listaUsuarios){
            LocalDate venci = u.getMembresia().getFechaVencimiento();
            long diasRestantes = ChronoUnit.DAYS.between(hoy, venci);

            //si faltan entre 0 y 3 días, se manda alerta
            if(diasRestantes >= 0 && diasRestantes <= 3){
                enviarEmailSimulado(u, diasRestantes);
            }
        }
    }

    private void enviarEmailSimulado(Usuario u, long dias){
        System.out.println("[EMAIL] Enviando a: " + u.getEmail());
        System.out.println("Hola " +u.getNombre() +", tu membresía vence en " +dias +" días.");
        System.out.println("------------------------------------");
    }
}
