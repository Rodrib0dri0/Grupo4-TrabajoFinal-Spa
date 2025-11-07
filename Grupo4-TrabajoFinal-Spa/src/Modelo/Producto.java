package Modelo;

public class Producto {

    private int idProducto;
    private String nombre;
    private String marca;
    private double costo;
    private boolean estado;
    private int idTratamientoMasaje;

    public Producto(String nombre, String marca, double costo, boolean estado) {
        this.nombre = nombre;
        this.marca = marca;
        this.estado = estado;
        this.costo = costo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getCosto() {
        return costo;
    }

    public int getIdTratamientoMasaje() {
        return idTratamientoMasaje;
    }

    public void setIdTratamientoMasaje(int idTratamientoMasaje) {
        this.idTratamientoMasaje = idTratamientoMasaje;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return " nombre=" + nombre + ", marca=" + marca + ", costo=" + costo + ", estado=" + estado + ", idTratamientoMasaje=" + idTratamientoMasaje + '}';
    }

}
