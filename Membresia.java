import java.time.LocalDate;

/*Gestiona los detalles financieros y de vigencia de la suscripcion */

public class Membresia {
    
    private String tipo; //mensual o anual
    private double precio;
    private LocalDate fechaVencimiento;
    private boolean pagada;
    //para la id para la base de datos
    private int id;

    public Membresia(String tipo, double precio, int mesesDuracion){
        this.tipo = tipo;
        this.precio = precio;
        //calcula la fecha sumando los meses a la fecha actual
        this.fechaVencimiento = LocalDate.now().plusMonths(mesesDuracion);
        this.pagada = false;
    }

    //para descuento al precio.
    //mejora: Validacion de rango y redondeo de decimales
    public void aplicarDescuento(double porcentaje){
        if (porcentaje > 0 && porcentaje <= 100){
            this.precio -= (this.precio * (porcentaje / 100));
            //redondeo a 2 decimales para evitar el error de presicion de los doubles
            this.precio = Math.round(this.precio * 100) / 100;
        } else {
            System.out.println("Aviso: El Porcentaje "+ porcentaje+ "% no es valido.");
        }
    }

    /*Determina si la membresia sigue vigente comparando con la fecha del sistema */

    public boolean isActiva(){
        return !LocalDate.now().isAfter(fechaVencimiento);
    }

    //getters
    public LocalDate getFechaVencimiento() {return fechaVencimiento; }
    public double getPrecio() {return precio;}
    public String getTipo() {return tipo;}
    public boolean isPagada() {return pagada;} //cambio de get a is por ser booleano
    //getter y setter de el id para la base de datos
    public void setId(int id){this.id = id;}
    public int getId() {return id;}

    //setter para el pago
    public void setPagada(boolean pagada) {this.pagada = pagada;}

    /*agregar tostring para evitar llamar a cada getter al mostrar informacion */
    @Override
    public String toString(){
        String estadoPago = pagada ? "Pagada" : "Pendiente de pago";
        String estadoVigencia = isActiva() ? "Vigente" : "EXPIRADA";

        return String.format("Membresia %s | Precio: $%.2f | Vencimiento: %s | [%s] | (%s)",
        tipo, precio, fechaVencimiento, estadoPago, estadoVigencia);
    }
}
