package Clases;

public class Sucursal {
    private int ID_Sucursal;
    private String Correo_sucursal;
    private String Telefono_Sucursal; 
    private String Nombre_Sucursal; 
    private String Direccion_Sucursal; 

    public Sucursal(int ID_Sucursal, String Correo_sucursal, String Telefono_Sucursal, String Nombre_Sucursal, String Direccion_Sucursal) {
        this.ID_Sucursal = ID_Sucursal;
        this.Correo_sucursal = Correo_sucursal;
        this.Telefono_Sucursal = Telefono_Sucursal;
        this.Nombre_Sucursal = Nombre_Sucursal;
        this.Direccion_Sucursal = Direccion_Sucursal;
    }
    
    public Sucursal() {

    }

    public int getID_Sucursal() {
        return ID_Sucursal;
    }

    public void setID_Sucursal(int ID_Sucursal) {
        this.ID_Sucursal = ID_Sucursal;
    }

    public String getCorreo_sucursal() {
        return Correo_sucursal;
    }

    public void setCorreo_sucursal(String Correo_sucursal) {
        this.Correo_sucursal = Correo_sucursal;
    }

    public String getTelefono_Sucursal() {
        return Telefono_Sucursal;
    }

    public void setTelefono_Sucursal(String Telefono_Sucursal) {
        this.Telefono_Sucursal = Telefono_Sucursal;
    }

    public String getNombre_Sucursal() {
        return Nombre_Sucursal;
    }

    public void setNombre_Sucursal(String Nombre_Sucursal) {
        this.Nombre_Sucursal = Nombre_Sucursal;
    }

    public String getDireccion_Sucursal() {
        return Direccion_Sucursal;
    }

    public void setDireccion_Sucursal(String Direccion_Sucursal) {
        this.Direccion_Sucursal = Direccion_Sucursal;
    }
    
    
}
