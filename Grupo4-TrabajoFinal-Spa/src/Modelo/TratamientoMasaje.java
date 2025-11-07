
package Modelo;

import java.sql.Time;
import java.util.List;

/*Tratamiento/Masaje: codTratam, nombre, tipo(facial, corporal, relajación, o estético), detalle, List<productos>, duración, costo, activo*/
public class TratamientoMasaje {
    private int IdTratamiento;
    private String nombre;
    private String tipo;
    private String detalle;
    private Producto producto; 
    private int duracion; 
    private double costo;
    private boolean activo;

    public TratamientoMasaje(int IdTratamiento,String nombre, String tipo, String detalle, int duracion, double costo, boolean activo) {
        this.nombre = nombre;
        this.IdTratamiento = IdTratamiento;
        this.tipo = tipo;
        this.detalle = detalle;
        this.duracion = duracion;
        this.activo = activo;
        this.costo = costo;
    }

    public int getIdTratamiento() {
        return IdTratamiento;
    }

    public void setIdTratamiento(int IdTratamiento) {
        this.IdTratamiento = IdTratamiento;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProductos(Producto productos) {
        this.producto = producto;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
 
    
     
}
