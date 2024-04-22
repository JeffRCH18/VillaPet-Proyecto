package Clases;

public class Empleado {

    private int ID_Empleado;
    private int ID_Puesto;
    private int ID_Rol;
    private int ID_Sucursal;
    private String Nombre_Empleado;
    private String Apellido;
    private String Correo;
    private String Contrasena;
    private int Salario;

    public Empleado(int ID_Empleado, int ID_Puesto, int ID_Rol, int ID_Sucursal, String Nombre_Empleado, String Apellido, String Correo, String Contrasena, int Salario) {
        this.ID_Empleado = ID_Empleado;
        this.ID_Puesto = ID_Puesto;
        this.ID_Rol = ID_Rol;
        this.Nombre_Empleado = Nombre_Empleado;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Contrasena = Contrasena;
        this.Salario = Salario;
        this.ID_Sucursal = ID_Sucursal;
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

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int Salario) {
        this.Salario = Salario;
    }

    public int getID_Sucursal() {
        return ID_Sucursal;
    }

    public void setID_Sucursal(int ID_Sucursal) {
        this.ID_Sucursal = ID_Sucursal;
    }
}
