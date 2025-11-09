package Persistencia;

import Modelo.Conexion;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProductosData {

    private Connection con;

    public ProductosData() {
        Conexion conexion = new Conexion("jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa", "root", "");
        con = conexion.buscarconexion();
    }

    public void agregarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, marca ,tipo, precio,estado) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setString(3, producto.getTipo());
            ps.setDouble(4, producto.getCosto());
            ps.setBoolean(5, producto.isEstado());

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Producto guardado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar.");
        }
    }

    public void eliminarProducto(int id) {
        try {
            String sql = "DELETE FROM productos WHERE idProducto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar.");
        }
    }

    public void actualizarProducto(Producto producto) {
        try {
            String sql = "UPDATE productos SET nombre= ?, marca= ?, tipo=?, precio= ? WHERE idProducto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setString(3, producto.getTipo());
            ps.setDouble(4, producto.getCosto());
            ps.setInt(5, producto.getIdProducto());

            int registro = ps.executeUpdate();

            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar.");
        }
    }

    public List<Producto> traerProductos() {
        List<Producto> productos = new ArrayList();
        try {
            String sql = "SELECT * FROM productos";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idP = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                String marca = rs.getString("marca");
                String tipo = rs.getString("tipo");
                double precio = rs.getDouble("precio");
                boolean estado = rs.getBoolean("estado");
                Producto produ = new Producto(nombre, marca, tipo, precio, estado);
                produ.setIdProducto(idP);

                productos.add(produ);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer los productos.");
        }
        return productos;
    }

    public Producto buscarProducto(int id) {
        Producto produ = null;
        try {

            String sql = "SELECT * FROM productos WHERE idProducto = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                String marca = rs.getString("marca");
                String tipo = rs.getString("tipo");
                double costo = rs.getDouble("precio");
                boolean estado = rs.getBoolean("estado");
                produ = new Producto(nombre, marca, tipo, costo, estado);
                produ.setIdProducto(idP);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar.");
        }
        return produ;
    }

    public boolean estadoActual(int id) {
        boolean estado = true;
        try {
            String slq = "SELECT estado FROM productos WHERE idProducto = ?";
            PreparedStatement ps = ps = con.prepareStatement(slq);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                boolean es = rs.getBoolean("estado");
                estado = es;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return estado;

    }

    public void darDeBaja(int id) {
        try {
            if (estadoActual(id)) {
                String slq = "UPDATE productos SET estado = false WHERE idProducto = ?";
                PreparedStatement ps = con.prepareStatement(slq);
                ps.setInt(1, id);

                int registro = ps.executeUpdate();
                if (registro > 0) {
                    JOptionPane.showMessageDialog(null, "Dado de baja correctamente!");
                }
                ps.close();
            } else {
                JOptionPane.showMessageDialog(null, "Ya está dado de baja!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja.");
        }
    }

    public void darDeAlta(int id) {
        try {
            if (!estadoActual(id)) {
                String slq = "UPDATE productos SET estado = true WHERE idProducto = ?";
                PreparedStatement ps = con.prepareStatement(slq);
                ps.setInt(1, id);

                int registro = ps.executeUpdate();
                if (registro > 0) {
                    JOptionPane.showMessageDialog(null, "Dado de alta correctamente!");
                }
                ps.close();
            } else {
                JOptionPane.showMessageDialog(null, "Ya está dado de alta!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta.");
        }
    }
}
