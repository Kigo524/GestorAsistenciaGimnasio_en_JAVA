public class Usuario extends Persona{
    
    private int asistenciasSeguidas;
    private Membresia membresia; //para por si tiene o mas de una o para cuando cambie de memebresia

    public Usuario(String nombre, String ine, String email, Membresia membresia){
        super(nombre, ine, email);//desde persona
        this.membresia = membresia;
        this.asistenciasSeguidas = 0; //para comenzar la suscripcion
    }

    
}
