package Modelo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiaDeSpa {

    private int idPack;
    private Timestamp fechaHora;
    private String preferencias;
    private Cliente cliente;
    private List<Sesion> sesiones;
    private double monto;
    private boolean estado;
    

    
    public DiaDeSpa() {
        sesiones = new ArrayList<>();
    }

   // un constructor por si creo una sesion con una lista cargada con instalaciones 
    public DiaDeSpa(Timestamp fechaHora, String preferencias, Cliente cliente, List<Sesion> sesiones, double monto, boolean estado) {
        this.fechaHora = fechaHora;
        this.preferencias = preferencias;
        this.cliente = cliente;
        this.sesiones =(sesiones != null) ? sesiones : new ArrayList<>();//“Si el parámetro sesiones que recibo no es null, entonces lo asigno.Si es null, creo una nueva lista vacía.”
        this.monto = monto;
        this.estado = estado;
    }

    //  // un constructor al que lo creo sin sesiones y despues se las asigno a traves de un metodo 
    public DiaDeSpa(int idPack, Timestamp fechaHora, String preferencias, Cliente cliente, double monto, boolean estado) {
        this.idPack = idPack;
        this.fechaHora = fechaHora;
        this.preferencias = preferencias;
        this.cliente = cliente;
        this.monto = monto;
        this.estado = estado;
    }
    
   
    public int getIdPack() {
        return idPack;
    }

    public void setIdPack(int idPack) {
        this.idPack = idPack;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechahora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    //Agrega una Sesion a la lista 
    public void agregarSesion(Sesion ses) {
        if (sesiones != null && !sesiones.contains(ses)) 
        sesiones.add(ses);
    }
    
    // Quita una Sesion de la lista
    public void eliminarSesion(Sesion sesion) {
        sesiones.remove(sesion);
    }
    
    
    public List<Sesion> getSesion() {
        return sesiones;
    }

    public void setSesion(List<Sesion> sesiones) {
        this.sesiones = sesiones;
    }
 /*este metodo me permite a mi obtener el numero total de las sesiones y guardar directamente
  un valor double en mi base de datos, algo representativo, ya que no puedo guardar una list en una columna*/
    public int getTotalSesion() {
    if (sesiones == null) {
        return 0; // por seguridad, si no hay lista
    }
    return sesiones.size(); // cantidad de sesiones
}

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isEstado() {
        return estado;
    }


    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DiaDeSpa{" + "idPack=" + idPack + ", fechaHora=" + fechaHora + ", preferencias=" + preferencias + ", cliente=" + cliente + ", sesiones=" + sesiones + ", monto=" + monto + ", estado=" + estado + '}';
    }

    
}
