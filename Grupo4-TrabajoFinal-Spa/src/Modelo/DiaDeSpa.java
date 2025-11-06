package Modelo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class DiaDeSpa {

    private int idPack;
    private Timestamp fechaHora;
    private String preferencias;
    private Cliente cliente;
    private List<Sesion> sesion;
    private double monto;
    private boolean estado;
   

    public DiaDeSpa(Timestamp fechaHora, String preferencias, Cliente cliente, List<Sesion> sesion, double monto, boolean estado) {
        this.fechaHora = fechaHora;
        this.preferencias = preferencias;
        this.cliente = cliente;
        this.sesion = sesion;
        this.monto = monto;
        this.estado = estado;
    }

    public DiaDeSpa( Timestamp fechaHora, String preferencias, Cliente cliente, int Totalsesion, double monto, boolean estado) {
        this.idPack = idPack;
        this.fechaHora = fechaHora;
        this.preferencias = preferencias;
        this.cliente = cliente;
        //this.sesion = TotalSesion;
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

    public List<Sesion> getSesion() {
        return sesion;
    }

    public void setSesion(List<Sesion> sesion) {
        this.sesion = sesion;
    }
 /*este metodo me permite a mi obtener el numero total de las sesiones y guardar directamente
  un valor double en mi base de datos, algo representativo, ya que no puedo guardar una list en una columna*/
    public int getTotalSesion() {
    if (sesion == null) {
        return 0; // por seguridad, si no hay lista
    }
    return sesion.size(); // cantidad de sesiones
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
        return "DiaDeSpa{" + "idPack=" + idPack + ", fechaHora=" + fechaHora + ", preferencias=" + preferencias + ", cliente=" + cliente + ", sesion=" + sesion + ", monto=" + monto + ", estado=" + estado + '}';
    }

    
}
