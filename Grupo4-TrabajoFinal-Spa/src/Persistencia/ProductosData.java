package Persistencia;

import Modelo.Conexion;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public List<Producto> buscarProductos(int id) {
        List<Producto> productos = null;
        try {

            String sql = "SELECT * FROM productos WHERE idTratamiento = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idP = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                String marca = rs.getString("marca");
                double costo = rs.getDouble("costo");
                boolean estado = rs.getBoolean("estado");
                Producto p = new Producto(nombre, marca, costo, estado);

                productos.add(p);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar.");
        }
        return productos;
    }
}
