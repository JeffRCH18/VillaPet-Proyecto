package Clases;
public class Categoria {
    private int ID_Categoria;
    private String Descripcion_Categoria;

    public Categoria(int ID_Categoria, String Descripcion_Categoria) {
        this.ID_Categoria = ID_Categoria;
        this.Descripcion_Categoria = Descripcion_Categoria;
    }
    
    public Categoria() {
        
    }

    public int getID_Categoria() {
        return ID_Categoria;
    }

    public void setID_Categoria(int ID_Categoria) {
        this.ID_Categoria = ID_Categoria;
    }

    public String getDescripcion_Categoria() {
        return Descripcion_Categoria;
    }

    public void setDescripcion_Categoria(String Descripcion_Categoria) {
        this.Descripcion_Categoria = Descripcion_Categoria;
    }
    
    
}
