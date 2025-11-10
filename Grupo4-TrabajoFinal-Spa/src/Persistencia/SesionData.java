package Persistencia;

import Modelo.Conexion;
import Modelo.DiaDeSpa;
import Modelo.Instalacion;
import Modelo.Masajista;
import Modelo.Sesion;
import Modelo.TratamientoMasaje;
import Persistencia.MasajistaData;
import Persistencia.DiadeSpaData;
import Persistencia.TratamientoMasajeData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;


public class SesionData {
    private Connection con;
    
    public SesionData(){
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }
    
    public void agregarSesion(Sesion sesion) {
        try {
            String sql = "INSERT INTO sesion(fecha_hora_inicio,fecha_hora_fin,idTratamiento,matricula,idPack,estado) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(sesion.getFechaHoraInicio()));
            ps.setTimestamp(2, Timestamp.valueOf(sesion.getFechaHoraFin()));
            ps.setInt(3,sesion.getTratamiento().getIdTratamiento());
            ps.setInt(4, sesion.getMasajista().getMatricula());
            ps.setInt(5,sesion.getDiaDeSpa().getIdPack());
            ps.setBoolean(6, sesion.isEstado());
          


            int registro = ps.executeUpdate();

            if (registro > 0) {
                // Obtenemos el ID generado automáticamente por la base
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idSesionGenerado = rs.getInt(1);
                        sesion.setIdSesion(idSesionGenerado); // guardamos el id en el objeto
                    }
                }
                JOptionPane.showMessageDialog(null, "¡Sesión guardada correctamente!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar sesión: " + ex.getMessage());
        }
    
    }
    
    public void agregarInstalacionesASesion(int idSesion, List<Instalacion> instalacion) {
    String sql = "INSERT INTO sesion_instalacion (idSesion, idInstalacion) VALUES (?, ?)";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        for (Instalacion inst : instalacion) {
            ps.setInt(1, idSesion);
            ps.setInt(2, inst.getIdInstalacion());
            ps.executeUpdate();
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al guardar instalaciones: " + ex.getMessage());
    }
}

    
    public void elimarSesion(int id) {
        try {
            String sql = "DELETE FROM sesion WHERE idSesion = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Sesion eliminada correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar.");
        }
    }
    
    public void actualizarSesion(Sesion sesionAc) {
        String sql = "UPDATE sesion SET fecha_hora_inicio = ?, fecha_hora_fin = ?, "
                   + "idTratamiento = ?, matricula = ?, idPack = ?, estado = ? "
                   + "WHERE idSesion = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(sesionAc.getFechaHoraInicio()));
            ps.setTimestamp(2, Timestamp.valueOf(sesionAc.getFechaHoraFin()));
            ps.setInt(3, sesionAc.getTratamiento().getIdTratamiento());
            ps.setInt(4, sesionAc.getMasajista().getMatricula());
            ps.setInt(5, sesionAc.getDiaDeSpa().getIdPack());
            ps.setBoolean(6, sesionAc.isEstado());
            ps.setInt(7, sesionAc.getIdSesion()); // importante para el WHERE

            int actualizado = ps.executeUpdate();
            if (actualizado > 0) {
                JOptionPane.showMessageDialog(null, "¡Sesión actualizada correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la sesión a actualizar.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar sesión: " + ex.getMessage());
        }
    }
     

     public void actualizarInstalacionesDeSesion(int idSesion, List<Instalacion> nuevasInstalaciones) {
        try {
            // 1️⃣ Eliminamos todas las asociaciones actuales
            String deleteSQL = "DELETE FROM sesion_instalacion WHERE idSesion = ?";
            try (PreparedStatement psDelete = con.prepareStatement(deleteSQL)) {
                psDelete.setInt(1, idSesion);
                psDelete.executeUpdate();
            }

            // 2️⃣ Insertamos las nuevas asociaciones
            agregarInstalacionesASesion(idSesion, nuevasInstalaciones);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar instalaciones: " + ex.getMessage());
        }
    }
     
public Sesion buscarSesion(int id) {
    Sesion sesion = null;
    try {
        String sql = "SELECT * FROM sesion WHERE idSesion = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            // 1️⃣ Extraer los datos de la base y guardarlos en variables
            int ID = rs.getInt("idSesion");
            LocalDateTime fechaHoraInicio = rs.getTimestamp("fecha_hora_inicio").toLocalDateTime();
            LocalDateTime fechaHoraFin = rs.getTimestamp("fecha_hora_fin").toLocalDateTime();
            int idTratamiento = rs.getInt("idTratamiento");
            int Matricula = rs.getInt("matricula");
            int idPack = rs.getInt("idPack");
            boolean estado = rs.getBoolean("estado");
            
            
             // 2️⃣ Crear los objetos Data para buscar los relacionados
            TratamientoMasajeData tratData = new TratamientoMasajeData();
            MasajistaData masData = new MasajistaData();
            DiadeSpaData diaData = new DiadeSpaData();

            // 3️⃣ Usar los métodos de cada Data para obtener los objetos reales
            TratamientoMasaje tratamiento = tratData.buscarTratamiento(idTratamiento);
            Masajista masajista = masData.buscarMasajista(Matricula);
            DiaDeSpa diaDeSpa = diaData.buscarDiaDeSpa(idPack);
            // 2️⃣ Crear una nueva sesión con los datos extraídos
            sesion = new Sesion(fechaHoraInicio,fechaHoraFin, tratamiento, masajista,null, diaDeSpa, estado);

            // 3️⃣ Asignar el id de la sesión
            sesion.setIdSesion(ID);
        
}
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar sesión: " + ex.getMessage());
    }

    return sesion;
}

 public void darDeBaja(Sesion sesion) {
        try {
            if (sesion.isEstado()) {
                String slq = "UPDATE sesion SET estado = false WHERE idSesion = ?";
                PreparedStatement ps = con.prepareStatement(slq);
                ps.setInt(1, sesion.getIdSesion());

                int registro = ps.executeUpdate();
                if (registro > 0) {
                    JOptionPane.showMessageDialog(null, "Dada de baja correctamente!");

                }
                ps.close();
            } else {
                JOptionPane.showMessageDialog(null, "Ya está dado de baja!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja.");
        }
    }
public void darDeAlta(Sesion sesion) {
        try {
            if (sesion.isEstado()) {
                JOptionPane.showMessageDialog(null, "Ya está dado de alta!");
            } else {
                String slq = "UPDATE sesion SET estado = true WHERE idSesion = ?";
                PreparedStatement ps = con.prepareStatement(slq);
                ps.setInt(1, sesion.getIdSesion());

                int registro = ps.executeUpdate();
                if (registro > 0) {
                    JOptionPane.showMessageDialog(null, "Dada de alta correctamente!");
                }
                ps.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta.");
        }
    }
}
    

