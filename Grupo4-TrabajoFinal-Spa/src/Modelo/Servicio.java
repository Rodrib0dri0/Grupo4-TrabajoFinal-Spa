
package Modelo;

public class Servicio {
    private int IdServicio;
    private String nombre;
    private String tipo;
    private String detalle;
    private int duracion; 
    private double costo;
    private boolean estado;

    public Servicio(String nombre, String tipo, int duracion, String detalle, double costo, boolean estado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.detalle = detalle;
        this.duracion = duracion;
        this.costo = costo;
        this.estado = estado;
    }

    public int getIdServicio() {
        return IdServicio;
    }

    public void setIdServicio(int IdServicio) {
        this.IdServicio = IdServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
 
    
     
}


