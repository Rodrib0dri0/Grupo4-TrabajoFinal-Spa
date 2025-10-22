package proyectofinal;

public class Producto {
    private String nombre;
    private String marca;
    private double cantidad; 

    public Producto(String nombre, String marca, double cantidad) {
        this.nombre = nombre;
        this.marca = marca;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return nombre + "," + marca + "," + cantidad + ",";
    }
}
