package Persistencia;

import Modelo.Cliente;
import Modelo.Conexion;
//import Principal.DiaDeSpa;
import Modelo.DiaDeSpa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

public class DiadeSpaData {
    private Connection con;
    
    public DiadeSpaData(){
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }
    
    public void agregarDiadeSpa(DiaDeSpa diadespa) {
        try {
            String sql = "INSERT INTO diadespa(fecha_hora, preferencias, idCliente, totalSesion, monto, estado) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1,diadespa.getFechaHora());
            ps.setString(2, diadespa.getPreferencias());
            ps.setInt(3,diadespa.getCliente().getIdCliente());
            ps.setDouble(4, diadespa.getTotalSesion());//metodo nuevo declarado en clase DiaDeSpa
            ps.setDouble(5, diadespa.getMonto());
            ps.setBoolean(6, diadespa.isEstado());
           

            int registro = ps.executeUpdate();

            if (registro > 0) {
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
            String sql = "UPDATE diadespa SET fecha_hora=?, preferencias=?, idCliente=?, totalSesion=?, monto=?, estado=? WHERE idPack = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1,diadespaAc.getFechaHora());
            ps.setString(2, diadespaAc.getPreferencias());
            ps.setInt(3, diadespaAc.getCliente().getIdCliente());
            ps.setInt(4, diadespaAc.getTotalSesion());
            ps.setDouble(5, diadespaAc.getMonto());
            ps.setBoolean(6, diadespaAc.isEstado());
            ps.setInt(7, diadespaAc.getIdPack());

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
                int ID = rs.getInt("idPack");
                //el tipo de dato es el que recibe la BD o el de la clase JAVA ?
                Timestamp fechaHora = rs.getTimestamp("fecha_hora");
                String preferencias = rs.getString("preferencias");
                int idCliente = rs.getInt("idCliente");
                Double monto = rs.getDouble("monto");
                boolean estado = rs.getBoolean("estado");
                
                 ClienteData cliData = new ClienteData();
                 Cliente cliente = cliData.buscarCliente(idCliente);
                 
                diadespa= new DiaDeSpa (ID,fechaHora,preferencias,cliente,0,monto,estado);


            } 
            ps.close();
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

    
    
    
    
    
    
    
    
    
    

