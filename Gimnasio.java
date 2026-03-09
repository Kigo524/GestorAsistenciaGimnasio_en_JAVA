import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Gimnasio {
    
    private String nombre;
    private ArrayList <Usuario> listaUsuarios;
    private double totalVentas;
    private Gerente gerente;

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
    public void registrarNuevoUsuario(Usuario u){
        listaUsuarios.add(u);
        totalVentas += u.getMembresia().getPrecio();
        System.out.println("Socio " + u.getNombre()+ " registrado con éxito.");
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
