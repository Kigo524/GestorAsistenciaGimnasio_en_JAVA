public class Usuario extends Persona{
    
    //asistencias necesarias para el descuento
    private static final int META_ASISTENCIA = 20;
    private static final double DESCUENTO_PREMIO = 10.0;

    private int asistenciasSeguidas;
    private Membresia membresia; //para por si tiene o mas de una o para cuando cambie de memebresia

    public Usuario(String nombre, String ine, String email, Membresia membresia){
        super(nombre, ine, email);//desde persona
        this.membresia = membresia;
        this.asistenciasSeguidas = 0; //para comenzar la suscripcion
    }

    public void registrarAsistencia(){
        this.asistenciasSeguidas++;
        System.out.println("Asistencia registrada: " + getNombre());
    }

    public Membresia getMembresia() {return membresia;}
    public int getAsistenciasSeguidas() {return asistenciasSeguidas;}

    public void verificarPremio(){
        if (this.asistenciasSeguidas >= META_ASISTENCIA) {
            System.out.println("Felicidades! Has ganado un descuento!");
            this.getMembresia().aplicarDescuento(DESCUENTO_PREMIO);
            this.asistenciasSeguidas = 0; //para reiniciar el contador despues de ganar el descuento
        }
    }
}
