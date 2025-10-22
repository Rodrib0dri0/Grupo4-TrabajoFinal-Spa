
package proyectofinal;

//Cliente: codCli, dni, nombre completo, teléfono, edad, afecciones, estado (Clase Opcional Grupos 3)

public class Cliente {
    private int CodCli;
    private int dni;
    private String nombre;
    private String apellido;
    private int telefono;
    private int edad;
    private String afecciones;
    private String estado;

    public Cliente(int dni, String nombre, String apellido, int telefono, int edad, String afecciones, String estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.afecciones = afecciones;
        this.estado = estado;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAfecciones() {
        return afecciones;
    }

    public void setAfecciones(String afecciones) {
        this.afecciones = afecciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}

