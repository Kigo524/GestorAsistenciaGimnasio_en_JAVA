public class Gerente extends Persona{
    private String username;
    private String password;
    //private String departamento; //ya sea ventas o administracion para escalar el proyecto

    public Gerente(String nombre, String ine, String email, String username, String password){
        super(nombre, ine, email);
        this.username = username;
        this.password = password;
        //this.departamento = "Administración General";
    }

    //en éste método trato de simular el login
    public boolean autenticar(String user, String pass){
        return this.username.equals(user) && this.password.equals(pass);
    }

    //éste metodo solo lo puede hacer el gerente
    public void generarReporteDeVentas(double totalRecaudado){
        System.out.println("--- REPORTE DE VENTAS ---");
        System.out.println("Gerente a cargo: " + getNombre());
        System.out.println("Total en caja: $" + totalRecaudado);
        System.out.println("-------------------");
    }
}
