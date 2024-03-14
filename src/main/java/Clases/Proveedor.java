package Clases;

public class Proveedor {
    private int ID_Proveedor;
    private String Nombre_Proveedor;
    private String Telefono_Proveedor;
    private String Direccion_Proveedor;

    public Proveedor(int ID_Proveedor, String Nombre_Proveedor, String Telefono_Proveedor, String Direccion_Proveedor) {
        this.ID_Proveedor = ID_Proveedor;
        this.Nombre_Proveedor = Nombre_Proveedor;
        this.Telefono_Proveedor = Telefono_Proveedor;
        this.Direccion_Proveedor = Direccion_Proveedor;
    }
    
    public Proveedor() {
 
    }

    public int getID_Proveedor() {
        return ID_Proveedor;
    }

    public void setID_Proveedor(int ID_Proveedor) {
        this.ID_Proveedor = ID_Proveedor;
    }

    public String getNombre_Proveedor() {
        return Nombre_Proveedor;
    }

    public void setNombre_Proveedor(String Nombre_Proveedor) {
        this.Nombre_Proveedor = Nombre_Proveedor;
    }

    public String getTelefono_Proveedor() {
        return Telefono_Proveedor;
    }

    public void setTelefono_Proveedor(String Telefono_Proveedor) {
        this.Telefono_Proveedor = Telefono_Proveedor;
    }

    public String getDireccion_Proveedor() {
        return Direccion_Proveedor;
    }

    public void setDireccion_Proveedor(String Direccion_Proveedor) {
        this.Direccion_Proveedor = Direccion_Proveedor;
    }
    
    
}
