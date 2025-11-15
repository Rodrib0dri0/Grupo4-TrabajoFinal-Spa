package Persistencia;

import Modelo.Cliente;
import Modelo.Conexion;
//import Principal.DiaDeSpa;
import Modelo.DiaDeSpa;
import Modelo.Sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.JOptionPane;

public class DiadeSpaData {
    private Connection con;
    
    public DiadeSpaData(){
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }
    
    public void agregarDiadeSpa(DiaDeSpa diadespa) {
        try {
            String sql = "INSERT INTO diadespa(fecha_hora, preferencias, idCliente, monto, estado) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setTimestamp(1,diadespa.getFechaHora());
            ps.setString(2, diadespa.getPreferencias());
            ps.setInt(3,diadespa.getCliente().getIdCliente());
            ps.setDouble(4, diadespa.getMonto());
            ps.setBoolean(5, diadespa.isEstado());
           

            int registro = ps.executeUpdate(); 
            
            
          

            if (registro > 0) {
                 // Obtener el ID generado para el Día de Spa
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int idPackGenerado = rs.getInt(1);
                    diadespa.setIdPack(idPackGenerado);
                }
            }
            
            // Si el día tiene sesiones cargadas, guardarlas
            if (diadespa.getSesion() != null && !diadespa.getSesion().isEmpty()) {
                SesionData sesionData = new SesionData();
                for (Sesion sesion : diadespa.getSesion()) {
                    sesion.setDiaDeSpa(diadespa);
                    sesionData.agregarSesion(sesion);
                }
            }
            
                System.out.println("Dia de Spa guardado correctamente!");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Dia de Spa");
        }
    }
        
        
     public void eliminarDiaDeSpa (int id) {
        try {
            String sql = "DELETE FROM diadespa WHERE idPack = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int registro = ps.executeUpdate();

            if (registro > 0) {
                System.out.println("Dia de Spa eliminado correctamente!");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar.");
        }
    }
     
     public void actualizarDiadeSpa(DiaDeSpa diadespaAc) {
        try {
            String sql = "UPDATE diadespa SET fecha_hora=?, preferencias=?, idCliente=?, monto=?, estado=? WHERE idPack = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1,diadespaAc.getFechaHora());
            ps.setString(2, diadespaAc.getPreferencias());
            ps.setInt(3, diadespaAc.getCliente().getIdCliente());
            ps.setDouble(4, diadespaAc.getMonto());
            ps.setBoolean(5, diadespaAc.isEstado());
            ps.setInt(6, diadespaAc.getIdPack());

            int registro = ps.executeUpdate();
            if (registro > 0) {
                System.out.println("Dia de Spa actualizado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el dia de Spa.");
        }
    }
     
     //ENCONTRAR EL ERROR Y CORREGIRLO
     public DiaDeSpa buscarDiaDeSpa(int id) {
        DiaDeSpa diadespa = null;
        try {
            String sql = "SELECT * FROM diadespa WHERE idPack = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idPack = rs.getInt("idPack");
                //el tipo de dato es el que recibe la BD o el de la clase JAVA ?
                Timestamp fechaHora = rs.getTimestamp("fecha_hora");
                String preferencias = rs.getString("preferencias");
                int idCliente = rs.getInt("idCliente");
                double monto = rs.getDouble("monto");
                boolean estado = rs.getBoolean("estado");
                
                 ClienteData cliData = new ClienteData();
                 Cliente cliente = cliData.buscarCliente(idCliente);
                 
                diadespa= new DiaDeSpa (idPack,fechaHora,preferencias,cliente,monto,estado);

                // 4️⃣ Recuperar las sesiones asociadas
            SesionData sesionData = new SesionData();
            List<Sesion> sesiones = sesionData.buscarSesionesPorDia(idPack);

            diadespa.setSesion(sesiones); // reconstruyo la relación
        }
 
            //} 
            //ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar.");
        }
        return diadespa;
    }




      public void darDeBaja(DiaDeSpa diadespa) {
        try {
            if (diadespa.isEstado()) {
                String slq = "UPDATE diadespa SET estado = false WHERE idPack = ?";
                PreparedStatement ps = con.prepareStatement(slq);
                ps.setInt(1, diadespa.getIdPack());

                int registro = ps.executeUpdate();
                if (registro > 0) {
                   JOptionPane.showMessageDialog(null,"se dio de baja");
                    
                }
                ps.close();
            } else {
               JOptionPane.showMessageDialog(null,"Ya está dado de baja!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja.");
        }
    }

      //este metodo podria ser para un dia de spa que por alguna razon aun no se reservada por estar pendiente algo y luego se reserva
      public void darDeAlta(DiaDeSpa diadespa) {
        try {
            if (diadespa.isEstado()) {
                JOptionPane.showMessageDialog(null,"Ya está dado de alta!");
            } else {
                String slq = "UPDATE diadespa SET estado = true WHERE idPack = ?";
                PreparedStatement ps = con.prepareStatement(slq);
                ps.setInt(1, diadespa.getIdPack());

                int registro = ps.executeUpdate();
                if (registro > 0) {
                    JOptionPane.showMessageDialog(null,"Dado de alta correctamente!");
                }
                ps.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta.");
        }
    }
}

    
    
    
    
    
    
    
    
    
    

