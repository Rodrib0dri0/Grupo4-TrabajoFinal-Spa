
package Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sesion {
    private int idSesion;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private TratamientoMasaje Tratamiento;
    private Masajista masajista;
    private List<Instalacion> instalaciones; //relacion muchos a muchos
    private DiaDeSpa diaDeSpa;
    private boolean estado;
    
    
     public Sesion() {
        instalaciones = new ArrayList<>(); // Siempre inicializamos la lista
    }
    
     // un constructor por si creo una sesion con una lista cargada con instalaciones 
    public Sesion(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, TratamientoMasaje Tratamiento, Masajista masajista, List<Instalacion> Instalacion, DiaDeSpa diaDeSpa, boolean estado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.Tratamiento = Tratamiento;
        this.masajista = masajista;
        this.instalaciones =(instalaciones != null) ? instalaciones : new ArrayList<>(); //“Si el parámetro instalaciones que recibo no es null, entonces lo asigno.Si es null, creo una nueva lista vacía.”
        this.diaDeSpa = diaDeSpa;
        this.estado = estado;
    }
    // un constructor al que lo creo sin instalaciones y despues se las asigno a traves de un metodo 
    public Sesion(int idSesion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, TratamientoMasaje Tratamiento, Masajista masajista, DiaDeSpa diaDeSpa, boolean estado) {
        this.idSesion = idSesion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.Tratamiento = Tratamiento;
        this.masajista = masajista;
        this.diaDeSpa = diaDeSpa;
        this.estado = estado;
    }
    

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public TratamientoMasaje getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(TratamientoMasaje Tratamiento) {
        this.Tratamiento = Tratamiento;
    }

    public Masajista getMasajista() {
        return masajista;
    }

    public void setMasajista(Masajista masajista) {
        this.masajista = masajista;
    }

    public List<Instalacion> getInstalacion() {
        return instalaciones;
    }

    public void setInstalacion(List<Instalacion> instalacion) {
        this.instalaciones = instalacion;
    }
 
    //Agrega una instalacion a la lista 
    public void agregarInstalacion(Instalacion ins) {
        if (instalaciones != null && !instalaciones.contains(instalaciones)) 
        instalaciones.add(ins);
    }
    
    
    
    // Quita una instalación de la lista
    public void eliminarInstalacion(Instalacion instalacion) {
        instalaciones.remove(instalacion);
    }
    
    public DiaDeSpa getDiaDeSpa() {
        return diaDeSpa;
    }

    public void setDiaDeSpa(DiaDeSpa diaDeSpa) {
        this.diaDeSpa = diaDeSpa;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Sesion{" + "idSesion=" + idSesion + ", fechaHoraInicio=" + fechaHoraInicio + ", fechaHoraFin=" + fechaHoraFin + ", Tratamiento=" + Tratamiento + ", masajista=" + masajista + ", instalacion=" + instalaciones + ", diaDeSpa=" + diaDeSpa + ", estado=" + estado + '}';
    }
    
    
}
