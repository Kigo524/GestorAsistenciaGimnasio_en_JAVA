public abstract class Persona {

    private String nombre;
    private String ine;
    private String email;

    public Persona(String nombre, String ine, String email){
        this.nombre = nombre;
        this.ine = ine;
        this.email = email;
    }

    //getters y setters
    public String getNombre() {return nombre;}
    public String getEmail() {return email;}
    public String getIne() {return ine;}
}