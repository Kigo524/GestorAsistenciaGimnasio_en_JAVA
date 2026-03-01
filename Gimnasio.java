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
        System.out.println("\n *****REPORTE: " + " ******");
        System.out.println("Gerente en turno: " + gerente.getNombre());
        System.out.println("Total de usuario suscritos: " + listaUsuarios.size());
        System.out.println("Ingresos: $" + totalVentas);
        System.out.println("****************\n");
    }

    //Buscador por INE (para cuando se necesite)
    public Usuario buscUsuario(String ine){
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
}
