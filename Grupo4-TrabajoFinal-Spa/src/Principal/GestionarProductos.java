package Principal;

import Modelo.Producto;
import Persistencia.ProductosData;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JOptionPane;

public class GestionarProductos extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    ProductosData pd = new ProductosData();

    public GestionarProductos() {
        initComponents();
        armarCabecera();
        cargarTabla();
        cargarTipos();
        noSeleccionar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jTMarca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCTipo = new javax.swing.JComboBox<>();
        jTPrecio = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jBGuardar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBBaja = new javax.swing.JButton();
        jBAlta = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jSalir = new javax.swing.JButton();

        jTTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTTable);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Marca:");

        jLabel4.setText("Costo:");

        jTMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTMarcaActionPerformed(evt);
            }
        });

        jLabel5.setText("Guardar Productos");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar-el-archivo.png"))); // NOI18N
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cambio.png"))); // NOI18N
        jBActualizar.setText("Edit");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/esconder.png"))); // NOI18N
        jBBaja.setText("Baja");
        jBBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBajaActionPerformed(evt);
            }
        });

        jBAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ojo.png"))); // NOI18N
        jBAlta.setText("Alta");
        jBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltaActionPerformed(evt);
            }
        });

        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton.png"))); // NOI18N
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTMarca, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(75, 75, 75)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBBaja)
                        .addGap(29, 29, 29)
                        .addComponent(jBAlta)
                        .addGap(104, 104, 104)
                        .addComponent(jSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBEliminar)
                            .addComponent(jBGuardar)
                            .addComponent(jBActualizar)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAlta)
                    .addComponent(jBBaja)
                    .addComponent(jSalir)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTMarcaActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        // TODO add your handling code here:
        if (validarVacios()) {
            try {
                Producto producSeleccionado = productoSeleccionado();

                String nombre = jTNombre.getText();
                String marca = jTMarca.getText();
                String tipo = jCTipo.getSelectedItem().toString();
                double precio = Double.parseDouble(jTPrecio.getText());
                boolean estado = producSeleccionado.isEstado();

                Producto producto = new Producto(nombre, marca, tipo, precio, estado);
                producto.setIdProducto(producSeleccionado.getIdProducto());
                pd.actualizarProducto(producto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No deben haber espacios vacios.");
        }
        cargarTabla();
        noSeleccionar();
        limpiar();
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        if (validarVacios()) {
            try {
                String nombre = jTNombre.getText();
                String marca = jTMarca.getText();
                String tipo = jCTipo.getSelectedItem().toString();
                double precio = Double.parseDouble(jTPrecio.getText());
                boolean estado = true;

                Producto producto = new Producto(nombre, marca, tipo, precio, estado);
                pd.agregarProducto(producto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No deben haber espacios vacios.");
        }
        cargarTabla();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBajaActionPerformed
        // TODO add your handling code here:
        pd.darDeBaja(productoSeleccionado().getIdProducto());
        cargarTabla();

        cargarTabla();
        noSeleccionar();
        limpiar();
    }//GEN-LAST:event_jBBajaActionPerformed

    private void jBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltaActionPerformed
        // TODO add your handling code here:
        pd.darDeAlta(productoSeleccionado().getIdProducto());
        cargarTabla();

        cargarTabla();
        noSeleccionar();
        limpiar();
    }//GEN-LAST:event_jBAltaActionPerformed

    private void jTTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTableMousePressed
        // TODO add your handling code here:
        Producto produ = productoSeleccionado();

        jTNombre.setText(produ.getNombre());
        jTMarca.setText(produ.getMarca());
        jCTipo.setSelectedItem(produ.getTipo());
        String precio = String.valueOf(produ.getCosto());
        jTPrecio.setText(precio);

        seleccionar();
    }//GEN-LAST:event_jTTableMousePressed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        jTTable.getSelectionModel().clearSelection();

        limpiar();
        noSeleccionar();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        Producto producto = productoSeleccionado();
        pd.eliminarProducto(producto.getIdProducto());
        cargarTabla();
        noSeleccionar();
        limpiar();
    }//GEN-LAST:event_jBEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBAlta;
    private javax.swing.JButton jBBaja;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JComboBox<String> jCTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTMarca;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTPrecio;
    private javax.swing.JTable jTTable;
    // End of variables declaration//GEN-END:variables

    public void cargarTipos() {
        jCTipo.addItem("Relajación");
        jCTipo.addItem("Facial");
        jCTipo.addItem("Corporal");
        jCTipo.addItem("Estético");
    }

    public void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Tipo");
        modelo.addColumn("Precio");
        modelo.addColumn("Estado");
        jTTable.setModel(modelo);
    }

    public void seleccionar() {
        jBActualizar.setEnabled(true);
        jBGuardar.setEnabled(false);
        jBBaja.setEnabled(true);
        jBAlta.setEnabled(true);
        jBEliminar.setEnabled(true);
    }

    public void noSeleccionar() {
        jBActualizar.setEnabled(false);
        jBGuardar.setEnabled(true);
        jBBaja.setEnabled(false);
        jBAlta.setEnabled(false);
        jBEliminar.setEnabled(false);
    }

    public void cargarTabla() {
        List<Producto> productos = new ArrayList();

        productos = pd.traerProductos();

        modelo.setRowCount(0);

        for (Producto p : productos) {
            modelo.addRow(new Object[]{p.getIdProducto(), p.getNombre(), p.getMarca(), p.getTipo(), p.getCosto(), p.isEstado()});
        }
    }

    public boolean validarVacios() {
        boolean valido;
        if (jTNombre.getText().equals("") || jTMarca.getText().equals("") || jTPrecio.getText().equals("")) {
            valido = false;
        } else {
            valido = true;
        }
        return valido;
    }

    public Producto productoSeleccionado() {
        int fila = jTTable.getSelectedRow();

        int id = Integer.parseInt(jTTable.getValueAt(fila, 0).toString());

        Producto produ = pd.buscarProducto(id);

        return produ;
    }

    public void limpiar() {
        jTNombre.setText("");
        jTMarca.setText("");
        jCTipo.setSelectedIndex(0);
        jTPrecio.setText("");
    }
}
