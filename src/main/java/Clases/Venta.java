package Clases;

import java.time.LocalDate;

public class Venta {
    private int Num_Factura;
    private int ID_Cliente;
    private int ID_Sucursal;
    private int Monto_Venta;
    private LocalDate Fecha;    

    public Venta(int Num_Factura, int ID_Cliente, int ID_Sucursal, int Monto_Venta, LocalDate Fecha) {
        this.Num_Factura = Num_Factura;
        this.ID_Cliente = ID_Cliente;
        this.ID_Sucursal = ID_Sucursal;
        this.Monto_Venta = Monto_Venta;
        this.Fecha = Fecha;
    }
    
    public Venta() {

    }

    public int getNum_Factura() {
        return Num_Factura;
    }

    public void setNum_Factura(int Num_Factura) {
        this.Num_Factura = Num_Factura;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public int getID_Sucursal() {
        return ID_Sucursal;
    }

    public void setID_Sucursal(int ID_Sucursal) {
        this.ID_Sucursal = ID_Sucursal;
    }

    public int getMonto_Venta() {
        return Monto_Venta;
    }

    public void setMonto_Venta(int Monto_Venta) {
        this.Monto_Venta = Monto_Venta;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }
    
    
}

