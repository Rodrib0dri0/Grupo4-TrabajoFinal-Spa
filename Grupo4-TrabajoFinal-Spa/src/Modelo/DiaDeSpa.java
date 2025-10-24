package Modelo;

import java.time.LocalDateTime;
import java.util.List;

public class DiaDeSpa {

    private int idPack;
    private LocalDateTime fechaHora;
    private String preferencias;
    private Cliente cliente;
    private List<Sesion> sesion;
    private double monto;
    private boolean estado;
    private LocalDateTime fecha_hora;

    public DiaDeSpa(LocalDateTime fechaHora, String preferencias, Cliente cliente, List<Sesion> sesion, double monto, boolean estado) {
        this.fechaHora = fechaHora;
        this.preferencias = preferencias;
        this.cliente = cliente;
        this.sesion = sesion;
        this.monto = monto;
        this.estado = estado;
    }

    public int getIdPack() {
        return idPack;
    }

    public void setIdPack(int idPack) {
        this.idPack = idPack;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFecha_hora(LocalDateTime fechaHora) {
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

    public List<Sesion> getSesion() {
        return sesion;
    }

    public void setSesion(List<Sesion> sesion) {
        this.sesion = sesion;
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

    
}
