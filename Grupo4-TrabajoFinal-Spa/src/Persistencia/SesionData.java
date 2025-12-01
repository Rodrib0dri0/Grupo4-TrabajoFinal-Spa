package Persistencia;

import Modelo.Conexion;
import Modelo.DiaDeSpa;
import Modelo.Instalacion;
import Modelo.Masajista;
import Modelo.Sesion;
import Modelo.TratamientoMasaje;
import Persistencia.MasajistaData;
//import Persistencia.DiadeSpaData;
import Persistencia.TratamientoMasajeData;
import Persistencia.InstalacionData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SesionData {

    private Connection con;

    public SesionData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }

    public Sesion agregarSesion(Sesion sesion) {
        try {
            String sql = "INSERT INTO sesion(fecha_hora_inicio,fecha_hora_fin,idTratamiento,matricula,estado) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(sesion.getFechaHoraInicio()));
            ps.setTimestamp(2, Timestamp.valueOf(sesion.getFechaHoraFin()));
            ps.setInt(3, sesion.getTratamiento().getIdTratamiento());
            ps.setInt(4, sesion.getMasajista().getMatricula());
            ps.setBoolean(5, sesion.isEstado());

            int registro = ps.executeUpdate();

            if (registro > 0) {
                // Obtenemos el ID generado automáticamente por la base
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idSesionGenerado = rs.getInt(1);
                        sesion.setIdSesion(idSesionGenerado);
                        if (!sesion.getInstalacion().isEmpty()) {
                            agregarInstalacionesASesion(idSesionGenerado, sesion.getInstalacion());
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "¡Sesión guardada correctamente!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar sesión: " + ex.getMessage());
        }
        return sesion;
    }

    public void agregarInstalacionesASesion(int idSesion, List<Instalacion> instalaciones) {
        String sql = "INSERT INTO sesion_instalacion (idSesion, idInstalacion) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            for (Instalacion inst : instalaciones) {
                ps.setInt(1, idSesion);
                ps.setInt(2, inst.getIdInstalacion());
                ps.addBatch();//Agrupa todas las inserciones y las hace de una sola vez
            }
            ps.executeBatch();
            System.out.println("instalaciones vinculadas correctamente a la sesion ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar instalaciones: " + ex.getMessage());
        }
    }

    public void eliminarSesion(int id) {
        try {
            // Primero eliminamos instalaciones asociadas
            String deleteSQL = "DELETE FROM sesion_instalacion WHERE idSesion = ?";
            try (PreparedStatement psDelete = con.prepareStatement(deleteSQL)) {
                psDelete.setInt(1, id);
                psDelete.executeUpdate();
            }

            // Luego eliminamos la sesión
            String sql = "DELETE FROM sesion WHERE idSesion = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                int registro = ps.executeUpdate();

                if (registro > 0) {
                    JOptionPane.showMessageDialog(null, "Sesión eliminada correctamente!");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
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

                // Actualizamos instalaciones si hay una lista cargada
                //CORROBORAR SI EN MIS METODOS DE INSTALACION ES INSTALACION O INSTALACIONES como esta declarado en la clase SESION
                if (sesionAc.getInstalacion() != null) {
                    actualizarInstalacionesDeSesion(sesionAc.getIdSesion(), sesionAc.getInstalacion());
                }
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
                //DiaDeSpa diaDeSpa = diaData.buscarDiaDeSpa(idPack);

                // Nueva sesión con sus instalaciones
                List<Instalacion> instalaciones = buscarInstalacionesDeSesion(ID);
                // 2️⃣ Crear una nueva sesión con los datos extraídos
                sesion = new Sesion(fechaHoraInicio, fechaHoraFin, tratamiento, masajista, instalaciones, estado);

                // 3️⃣ Asignar el id de la sesión
                sesion.setIdSesion(ID);

                //necesitamos reconstruir la lista de instalaciones
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar sesión: " + ex.getMessage());
        }

        return sesion;
    }

    private List<Instalacion> buscarInstalacionesDeSesion(int idSesion) {
        List<Instalacion> lista = new ArrayList<>();
        String sql = "SELECT i.* FROM instalacion i JOIN sesion_instalacion si ON i.idInstalacion = si.idInstalacion WHERE si.idSesion = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idSesion);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Instalacion inst = new Instalacion();
                inst.setIdInstalacion(rs.getInt("idInstalacion"));
                inst.setNombre(rs.getString("nombre"));
                inst.setDetalleDeUso(rs.getString("uso"));
                inst.setPrecio30m(rs.getDouble("precio30m"));
                inst.setEstado(rs.getBoolean("estado"));
                lista.add(inst);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar: " + ex.getMessage());
        }
        return lista;
    }

    public List<Sesion> buscarSesionesPorDia(int idPack) {
        List<Sesion> lista = new ArrayList<>();
        String sql = "SELECT * FROM sesion WHERE idPack = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPack);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idSesion = rs.getInt("idSesion");
                LocalDateTime inicio = rs.getTimestamp("fecha_hora_inicio").toLocalDateTime();
                LocalDateTime fin = rs.getTimestamp("fecha_hora_fin").toLocalDateTime();
                int idTratamiento = rs.getInt("idTratamiento");
                int matricula = rs.getInt("matricula");
                boolean estado = rs.getBoolean("estado");

                // Buscar tratamiento y masajista
                TratamientoMasajeData tData = new TratamientoMasajeData();
                TratamientoMasaje t = tData.buscarTratamiento(idTratamiento);

                MasajistaData mData = new MasajistaData();
                Masajista m = mData.buscarMasajista(matricula);

                // Recuperar instalaciones
                List<Instalacion> instalaciones = buscarInstalacionesDeSesion(idSesion);

                // Crear la sesión
                Sesion sesion = new Sesion(inicio, fin, t, m, instalaciones, estado);
                lista.add(sesion);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar sesiones por Día de Spa: " + ex.getMessage());
        }

        return lista;
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
