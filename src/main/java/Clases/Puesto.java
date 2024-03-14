package Clases;
public class Puesto {
    private int ID_Puesto;
    private String Descripcion_Puesto;

    public Puesto(int ID_Puesto, String Descripcion_Puesto) {
        this.ID_Puesto = ID_Puesto;
        this.Descripcion_Puesto = Descripcion_Puesto;
    }
    
    public Puesto() {
        
    }

    public int getID_Puesto() {
        return ID_Puesto;
    }

    public void setID_Puesto(int ID_Puesto) {
        this.ID_Puesto = ID_Puesto;
    }

    public String getDescripcion_Puesto() {
        return Descripcion_Puesto;
    }

    public void setDescripcion_Puesto(String Descripcion_Puesto) {
        this.Descripcion_Puesto = Descripcion_Puesto;
    }
    
    
}
