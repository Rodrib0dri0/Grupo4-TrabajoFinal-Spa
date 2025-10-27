package Modelo;

public class Producto {
    private String nombre;
    private String marca;
    private double costo; 

    public Producto(String nombre, String marca, double costo) {
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
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

    @Override
    public String toString() {
        return nombre + "," + marca + "," + costo + ",";
    }
}
