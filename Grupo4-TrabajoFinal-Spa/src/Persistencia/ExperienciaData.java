package Persistencia;

import Modelo.Experiencia;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ExperienciaData {

    private Connection con;

    public ExperienciaData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }

    public void guardar(Experiencia exp) {
        String sql = "INSERT INTO reseñas (estrellas, comentarios) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, exp.getPuntuacion());
            ps.setString(2, exp.getComentario());
            int registro = ps.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Reseña enviada correctamente!.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar.");
        }
    }

    public List<Experiencia> obtenerTodas() {
        List<Experiencia> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM reseñas";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Experiencia exp = new Experiencia();
                exp.setPuntuacion(rs.getInt("estrellas"));
                exp.setComentario(rs.getString("comentarios"));
                lista.add(exp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar.");
        }
        return lista;
    }
}
