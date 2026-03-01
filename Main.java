import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //todo lo demás se delega al Gimnasio

        //se crea un admin y un gimnasio
        Gerente admin = new Gerente("Raul", "123", "raul@gym.com", "admin", "1234");
        Gimnasio miGimnasio = new Gimnasio("Gimnasio Mr México", admin);

        //se crea un par de usuario con diferentes membresias
        Membresia m1 = new Membresia("Mensual", 500.0, 1);
        Usuario u1 = new Usuario("Ana Lopez", "4455", "ana@gmail.com", m1);

        Membresia m2 = new Membresia("Anual", 4500.0, 12);
        Usuario u2 = new Usuario("Pedro Pascal", "6677", "pedro@gmail.com", m2);

        //se registran en el gimnasio los usuarios
        miGimnasio.registrarNuevoUsuario(u1);
        miGimnasio.registrarNuevoUsuario(u2);

        //que imprima la lista de los usuarios y el reporte en general
        miGimnasio.mostrarReporteEstado();

        //simular una búsqueda
        Usuario encontrado = miGimnasio.buscUsuario("6677");
        if(encontrado != null){ //si lo encuentra, que lo regrese
            System.out.println("Usuario encontrado: " + encontrado.getNombre());
        }
    }
}
