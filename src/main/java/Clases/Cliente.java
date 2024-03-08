package Clases;
public class Cliente {
    private int ID_Cliente;
    private String Nombre_Cliente;
    private String Apellido_Cliente;
    private String Direccion_Cliente;
    private int Telefono_Clienre;
    private String Correo_Cliente;

    public Cliente(int ID_Cliente, String Nombre_Cliente, String Apellido_Cliente, String Direccion_Cliente, int Telefono_Clienre, String Correo_Cliente) {
        this.ID_Cliente = ID_Cliente;
        this.Nombre_Cliente = Nombre_Cliente;
        this.Apellido_Cliente = Apellido_Cliente;
        this.Direccion_Cliente = Direccion_Cliente;
        this.Telefono_Clienre = Telefono_Clienre;
        this.Correo_Cliente = Correo_Cliente;
    }

    public Cliente() {
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public String getApellido_Cliente() {
        return Apellido_Cliente;
    }

    public void setApellido_Cliente(String Apellido_Cliente) {
        this.Apellido_Cliente = Apellido_Cliente;
    }

    public String getDireccion_Cliente() {
        return Direccion_Cliente;
    }

    public void setDireccion_Cliente(String Direccion_Cliente) {
        this.Direccion_Cliente = Direccion_Cliente;
    }

    public int getTelefono_Clienre() {
        return Telefono_Clienre;
    }

    public void setTelefono_Clienre(int Telefono_Clienre) {
        this.Telefono_Clienre = Telefono_Clienre;
    }

    public String getCorreo_Cliente() {
        return Correo_Cliente;
    }

    public void setCorreo_Cliente(String Correo_Cliente) {
        this.Correo_Cliente = Correo_Cliente;
    }
    
    
    
    
}
