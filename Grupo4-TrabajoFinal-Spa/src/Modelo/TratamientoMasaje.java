
package Modelo;

import java.sql.Time;
import java.util.List;

/*Tratamiento/Masaje: codTratam, nombre, tipo(facial, corporal, relajación, o estético), detalle, List<productos>, duración, costo, activo*/
public class TratamientoMasaje {
    private int IdTratamiento;
    private String nombre;
    private String tipo;
    private String detalle;
    private List<Producto> productos; 
    private Time duracion; 
    private double costo;
    private boolean activo;

    public TratamientoMasaje(int IdTratamiento, String nombre, String tipo, String detalle, List<Producto> productos, Time duracion, double costo, boolean activo) {
        this.IdTratamiento = IdTratamiento;
        this.nombre = nombre;
        this.tipo = tipo;
        this.detalle = detalle;
        this.productos = productos;
        this.duracion = duracion;
        this.costo = costo;
        this.activo = activo;
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
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
