package Clases;

public class Producto {
    private int ID_Producto;
    private int ID_Categoria;
    private int ID_Proveedor;
    private String Descripcion;
    private int Precio;
    private int Stock;

    public Producto(int ID_Producto, int ID_Categoria, int ID_Proveedor, String Descripcion, int Precio, int Stock) {
        this.ID_Producto = ID_Producto;
        this.ID_Categoria = ID_Categoria;
        this.ID_Proveedor = ID_Proveedor;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Stock = Stock;
    }
    
    public Producto() {

    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public int getID_Categoria() {
        return ID_Categoria;
    }

    public void setID_Categoria(int ID_Categoria) {
        this.ID_Categoria = ID_Categoria;
    }

    public int getID_Proveedor() {
        return ID_Proveedor;
    }

    public void setID_Proveedor(int ID_Proveedor) {
        this.ID_Proveedor = ID_Proveedor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }
    
    
}
