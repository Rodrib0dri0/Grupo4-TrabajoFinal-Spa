package Modelo;

public class Masajista {
    private int matricula;
    private String nombre;
    private String apellido;
    private int telefono;
    private String especialidad;
    private boolean estado;

    public Masajista(int matricula, String nombre, String apellido, int telefono, String especialidad, boolean estado) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Masajista{" + "matricula=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", especialidad=" + especialidad + ", estado=" + estado + '}';
    }
    
    
}
