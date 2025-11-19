package Persistencia;

import Modelo.Experiencia;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExperienciaData {
    private Connection con;

    public ExperienciaData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }

 
    public void guardar(Experiencia exp) throws SQLException {
        String sql = "INSERT INTO experiencia (puntuacion, comentario) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, exp.getPuntuacion());
            ps.setString(2, exp.getComentario());
            ps.executeUpdate();
        }
    }

  
    public void eliminar(Experiencia exp) throws SQLException {
        String sql = "DELETE FROM experiencia WHERE puntuacion = ? AND comentario = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, exp.getPuntuacion());
            ps.setString(2, exp.getComentario());
            ps.executeUpdate();
        }
    }


    public List<Experiencia> obtenerTodas() throws SQLException {
        List<Experiencia> lista = new ArrayList<>();
        String sql = "SELECT * FROM experiencia";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Experiencia exp = new Experiencia();
                exp.setPuntuacion(rs.getInt("puntuacion"));
                exp.setComentario(rs.getString("comentario"));
                lista.add(exp);
            }
        }
        return lista;
    }
}
