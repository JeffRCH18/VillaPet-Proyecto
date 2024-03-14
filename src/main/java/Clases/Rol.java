package Clases;
public class Rol {
    private int ID_Rol;
    private String Descripcion_Rol;

    public Rol(int ID_Rol, String Descripcion_Rol) {
        this.ID_Rol = ID_Rol;
        this.Descripcion_Rol = Descripcion_Rol;
    }
    
    public Rol() {
        
    }

    public int getID_Rol() {
        return ID_Rol;
    }

    public void setID_Rol(int ID_Rol) {
        this.ID_Rol = ID_Rol;
    }

    public String getDescripcion_Rol() {
        return Descripcion_Rol;
    }

    public void setDescripcion_Rol(String Descripcion_Rol) {
        this.Descripcion_Rol = Descripcion_Rol;
    }
    
    
    
}
