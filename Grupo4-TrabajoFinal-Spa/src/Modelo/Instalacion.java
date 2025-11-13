package Modelo;

public class Instalacion {
    private int idInstalacion;
    private String nombre;
    private String detalleDeUso;
    private double precio30m;
    private boolean estado;
   //seria conveniente un atributo asi para representar que pertenece a una sesion?  private Sesion sesion;

    
    //Constructor con id
    public Instalacion(int idInstalacion, String nombre, String detalleDeUso, double precio30m, boolean estado) {
        this.idInstalacion = idInstalacion;
        this.nombre = nombre;
        this.detalleDeUso = detalleDeUso;
        this.precio30m = precio30m;
        this.estado = estado;
    }

    //Constructor vacio
    public Instalacion() {
    }

    
    public Instalacion(String nombre, String detalleDeUso, double precio30m, boolean estado) {
        this.nombre = nombre;
        this.detalleDeUso = detalleDeUso;
        this.precio30m = precio30m;
        this.estado = estado;
        //this.sesion=sesion;
    }

    public int getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(int idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalleDeUso() {
        return detalleDeUso;
    }

    public void setDetalleDeUso(String detalleDeUso) {
        this.detalleDeUso = detalleDeUso;
    }

    public double getPrecio30m() {
        return precio30m;
    }

    public void setPrecio30m(double precio30m) {
        this.precio30m = precio30m;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /*public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }*/

    @Override
    public String toString() {
        return "Instalacion{" + "idInstalacion=" + idInstalacion + ", nombre=" + nombre + ", detalleDeUso=" + detalleDeUso + ", precio30m=" + precio30m + ", estado=" + estado + '}';
    }
     

}
