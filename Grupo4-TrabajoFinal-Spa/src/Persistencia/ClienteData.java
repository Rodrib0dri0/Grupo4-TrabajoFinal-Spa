package Persistencia;

import Modelo.Cliente;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteData {
    
    private Connection con;
    
    public ClienteData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }
    
    public void agregarCliente (Cliente cliente){
        try {
            String sql = "INSERT INTO cliente(dni, nombre, apellido, edad, afecciones, estado, telefono) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setInt(4, cliente.getEdad());
            ps.setString(5, cliente.getAfecciones());
            ps.setBoolean(6, cliente.getEstado());
            ps.setInt(7, cliente.getTelefono());
            
            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Cliente guardado correctamente!");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar.");
        }
    }
    
    public void eliminarCliente(int id) {
        try {
            String sql = "DELETE FROM cliente WHERE idCliente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar.");
        }
    }
    
    public void actualizarCliente(Cliente clienteAc) {
        try {
            String sql = "UPDATE cliente SET dni= ?, nombre= ? ,apellido= ? ,edad= ? ,afecciones= ? , estado= ? ,telefono= ? WHERE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, clienteAc.getDni());
            ps.setString(2, clienteAc.getNombre());
            ps.setString(3, clienteAc.getApellido());
            ps.setInt(4, clienteAc.getEdad());
            ps.setString(5, clienteAc.getAfecciones());
            ps.setBoolean(6, clienteAc.getEstado());
            ps.setInt(7, clienteAc.getTelefono());
            ps.setInt(8, clienteAc.getIdCliente());

            int registro = ps.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Actualizado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar.");
        }
    }
    
    public Cliente buscarCliente(int id) {
        Cliente cliente = null;
        try {
            String sql = "SELECT * FROM cliente WHERE idCliente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("idCliente");
                int dni = rs.getInt("dni");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                int telefono = rs.getInt("telefono");
                String afecciones = rs.getString("afecciones");
                boolean estado = rs.getBoolean("estado");

                cliente = new Cliente(dni,nombre,apellido,edad,telefono,afecciones,estado);
                cliente.setIdCliente(ID);
                
                System.out.println("encontrado");
            }
            //ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar.");
        }
        return cliente;
    }
    
    public void darDeBaja(Cliente cliente) {
        try {
            if (!cliente.getEstado()) {
                JOptionPane.showMessageDialog(null, "Ya está dado de baja!");
            }
            String slq = "UPDATE masajista SET estado = false WHERE matricula = ?";
            PreparedStatement ps = con.prepareStatement(slq);
            ps.setInt(1, cliente.getIdCliente());

            int registro = ps.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Dado de baja correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja.");
        }
    }

    public void darDeAlta(Cliente cliente) {
        try {
            if (cliente.getEstado()) {
                JOptionPane.showMessageDialog(null, "Ya está dado de alta!");
            } else {
                String slq = "UPDATE masajista SET estado = true WHERE matricula = ?";
                PreparedStatement ps = con.prepareStatement(slq);
                ps.setInt(1, cliente.getIdCliente());

                int registro = ps.executeUpdate();
                if (registro > 0) {
                    JOptionPane.showMessageDialog(null, "Dado de alta correctamente!");
                }
                ps.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta.");
        }
    }
}
