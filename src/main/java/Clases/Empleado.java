package Clases;

public class Empleado {
    private int ID_Empleado;
    private int ID_Puesto;
    private int ID_Rol;
    private String Nombre_Empleado;
    private String Apellido;
    private String Correo;
    private String Contraseña;
    private int Salario;

    public Empleado(int ID_Empleado, int ID_Puesto, int ID_Rol, String Nombre_Empleado, String Apellido, String Correo, String Contraseña, int Salario) {
        this.ID_Empleado = ID_Empleado;
        this.ID_Puesto = ID_Puesto;
        this.ID_Rol = ID_Rol;
        this.Nombre_Empleado = Nombre_Empleado;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Contraseña = Contraseña;
        this.Salario = Salario;
    }
    
        public Empleado() {

    }

    public int getID_Empleado() {
        return ID_Empleado;
    }

    public void setID_Empleado(int ID_Empleado) {
        this.ID_Empleado = ID_Empleado;
    }

    public int getID_Puesto() {
        return ID_Puesto;
    }

    public void setID_Puesto(int ID_Puesto) {
        this.ID_Puesto = ID_Puesto;
    }

    public int getID_Rol() {
        return ID_Rol;
    }

    public void setID_Rol(int ID_Rol) {
        this.ID_Rol = ID_Rol;
    }

    public String getNombre_Empleado() {
        return Nombre_Empleado;
    }

    public void setNombre_Empleado(String Nombre_Empleado) {
        this.Nombre_Empleado = Nombre_Empleado;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int Salario) {
        this.Salario = Salario;
    }
        
    
}
