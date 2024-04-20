package Clases;
public class Detalle {
     private int ID_DETALLE;
    private int ID_PRODUCTO;
    private int CANTIDAD;
    private int PRECIO;
    private int ID_VENTA;

    public Detalle(int ID_DETALLE, int ID_PRODUCTO, int CANTIDAD, int PRECIO, int ID_VENTA) {
        this.ID_DETALLE = ID_DETALLE;
        this.ID_PRODUCTO = ID_PRODUCTO;
        this.CANTIDAD = CANTIDAD;
        this.PRECIO = PRECIO;
        this.ID_VENTA = ID_VENTA;
    }

    public Detalle() {

    }

    public int getID_DETALLE() {
        return ID_DETALLE;
    }

    public void setID_DETALLE(int ID_DETALLE) {
        this.ID_DETALLE = ID_DETALLE;
    }

    public int getID_PRODUCTO() {
        return ID_PRODUCTO;
    }

    public void setID_PRODUCTO(int ID_PRODUCTO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public int getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(int PRECIO) {
        this.PRECIO = PRECIO;
    }

    public int getID_VENTA() {
        return ID_VENTA;
    }

    public void setID_VENTA(int ID_VENTA) {
        this.ID_VENTA = ID_VENTA;
    }
}
