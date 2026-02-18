import java.time.LocalDate;

public class Membresia {
    
    private String tipo; //mensual o anual
    private double precio;
    private LocalDate fechaVencimiento;
    private boolean pagada;

    public Membresia(String tipo, double precio, int mesesDuracion){
        this.tipo = tipo;
        this.precio = precio;
        this.fechaVencimiento = LocalDate.now().plusMonths(mesesDuracion);
        this.pagada = false;
    }

    //para descuento
    public void aplicarDescuento(double porcentaje){
        this.precio -= (this.precio * (porcentaje / 100));
    }

    public LocalDate getFechaVencimiento() {return fechaVencimiento; }
}
