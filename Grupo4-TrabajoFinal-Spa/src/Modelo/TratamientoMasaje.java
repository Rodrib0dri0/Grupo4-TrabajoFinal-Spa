package Modelo;

import java.util.List;

public class TratamientoMasaje {

    private int IdTratamiento;
    private List<Producto> productos;
    private int idServicio;
    private String detalle;
    private double precio;
    private boolean estado;

    public TratamientoMasaje(List<Producto> productos, int idServicio, String detalle, double precio, boolean estado) {
        this.productos = productos;
        this.idServicio = idServicio;
        this.detalle = detalle;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdTratamiento() {
        return IdTratamiento;
    }

    public void setIdTratamiento(int IdTratamiento) {
        this.IdTratamiento = IdTratamiento;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TratamientoMasaje{" + "IdTratamiento=" + IdTratamiento + ", idProducto=" + idServicio + ", detalle=" + detalle + ", precio=" + precio + '}';
    }

}
