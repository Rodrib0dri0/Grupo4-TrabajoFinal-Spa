
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
    private List<Instalacion> instalaciones;
    private DiaDeSpa diaDeSpa;
    private boolean estado;

    public Sesion(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, TratamientoMasaje Tratamiento, Masajista masajista, List<Instalacion> instalaciones, boolean estado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.Tratamiento = Tratamiento;
        this.masajista = masajista;
        this.instalaciones = instalaciones;
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
