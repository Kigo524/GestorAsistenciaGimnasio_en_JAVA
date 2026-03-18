/*Representa a un socio activo del gimnasio
Gestiona su membresia y su historial de fidelizacion por asistencia */

public class Usuario extends Persona{
    
    //asistencias necesarias para el descuento. Se pueden cambiar desde aqui.
    private static final int META_ASISTENCIA = 20;
    private static final double DESCUENTO_PREMIO = 10.0;

    private int asistenciasSeguidas;
    private Membresia membresia; //para por si tiene o mas de una o para cuando cambie de memebresia
    // agrego id para la base de datos
    private int id;

    public Usuario(String nombre, String ine, String email, Membresia membresia){
        super(nombre, ine, email);//desde persona
        this.membresia = membresia;
        this.asistenciasSeguidas = 0; //para comenzar la suscripcion
    }

    //setter y getter del id para la base de datos
    public void setId(int id){this.id = id;}
    public int getId(){return id;}

    /*Registrar una visita y verificar automaticamente si el usuario es acreedor 
    a un beneficio por su constancia */

    public void registrarAsistencia(){
        this.asistenciasSeguidas++;
        System.out.println("Asistencia #"+ asistenciasSeguidas+ " registrada: "+ getNombre());

        //aqui el sistema checa el premio
        verificarPremio();
    }

    /*El metodo es privado porque la propia clase debe decidir cuando dar premios */
    private void verificarPremio(){
        if (this.asistenciasSeguidas >= META_ASISTENCIA) {
            System.out.println("Felicidades! Por tu constacia se te ha aplicado un "+ DESCUENTO_PREMIO+ "% de descuento.");
            this.membresia.aplicarDescuento(DESCUENTO_PREMIO);
            this.asistenciasSeguidas = 0; //para reiniciar el contador despues de ganar el descuento
        }
    }

    public Membresia getMembresia() {return membresia;}
    public int getAsistenciasSeguidas() {return asistenciasSeguidas;}

    @Override
    public String toString(){
        return String.format("Usuario: %s | INE: %s | Asistencias: %d | Mmebresia: %s",
            getNombre(), getIne(), asistenciasSeguidas, membresia.getTipo());
    }
}
