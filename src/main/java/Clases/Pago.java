package Clases;

import java.time.LocalDate;

public class Pago {
    private int Cod_Pago;
    private int ID_Proveedor;
    private int Monto;
    private LocalDate Fecha;

    public Pago(int Cod_Pago, int ID_Proveedor, int Monto, LocalDate Fecha) {
        this.Cod_Pago = Cod_Pago;
        this.ID_Proveedor = ID_Proveedor;
        this.Monto = Monto;
        this.Fecha = Fecha;
    }
    
    public Pago() {

    }

    public int getCod_Pago() {
        return Cod_Pago;
    }

    public void setCod_Pago(int Cod_Pago) {
        this.Cod_Pago = Cod_Pago;
    }

    public int getID_Proveedor() {
        return ID_Proveedor;
    }

    public void setID_Proveedor(int ID_Proveedor) {
        this.ID_Proveedor = ID_Proveedor;
    }

    public int getMonto() {
        return Monto;
    }

    public void setMonto(int Monto) {
        this.Monto = Monto;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }
    
    
}
