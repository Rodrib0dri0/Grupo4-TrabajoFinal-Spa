package Modelo;

public class Experiencia {
    private int puntuacion;
    private String comentario;

    public Experiencia() {
    }

    public Experiencia(int puntuacion, String comentario) {
        this.setPuntuacion(puntuacion);
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        if (puntuacion < 1) puntuacion = 1;
        if (puntuacion > 5) puntuacion = 5;
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Experiencia{" +
                "puntuacion=" + puntuacion +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
