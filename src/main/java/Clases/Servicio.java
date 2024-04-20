package Clases;
public class Servicio {
 private int ID_Servicio;
    private int ID_Empleado;
    private String Nombre_Servicios;
    private String Descripcion_Servicio;
    private int Precio;

    public Servicio(int ID_Servicio, int ID_Empleado, String Nombre_Servicios, String Descripcion_Servicio, int Precio) {
        this.ID_Servicio = ID_Servicio;
        this.ID_Empleado = ID_Empleado;
        this.Nombre_Servicios = Nombre_Servicios;
        this.Descripcion_Servicio = Descripcion_Servicio;
        this.Precio = Precio;
    }
    
    public Servicio() {

    }

    public int getID_Servicio() {
        return ID_Servicio;
    }

    public void setID_Servicio(int ID_Servicio) {
        this.ID_Servicio = ID_Servicio;
    }

    public int getID_Empleado() {
        return ID_Empleado;
    }

    public void setID_Empleado(int ID_Empleado) {
        this.ID_Empleado = ID_Empleado;
    }

    public String getNombre_Servicios() {
        return Nombre_Servicios;
    }

    public void setNombre_Servicios(String Nombre_Servicios) {
        this.Nombre_Servicios = Nombre_Servicios;
    }

    public String getDescripcion_Servicio() {
        return Descripcion_Servicio;
    }

    public void setDescripcion_Servicio(String Descripcion_Servicio) {
        this.Descripcion_Servicio = Descripcion_Servicio;
    }
    
    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getPrecio() {
        return Precio;
    }
}
