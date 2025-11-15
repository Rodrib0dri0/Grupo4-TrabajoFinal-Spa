package Principal;

import Persistencia.InstalacionData;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class GestionarInsatalaciones extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    InstalacionData insD = new InstalacionData();
    
    List<Instalacion> insta = new ArrayList();

    public GestionarInsatalaciones() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jTUso = new javax.swing.JTextField();
        jTPrecio30 = new javax.swing.JTextField();
        jBEliminar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBBaja = new javax.swing.JButton();
        jBAlta = new javax.swing.JButton();
        jSalir = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setText("Nombre:");

        jLabel2.setText("Precio 30 minutos:");

        jLabel3.setText("Uso:");

        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        jBEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cambio.png"))); // NOI18N
        jBActualizar.setText("Edit");
        jBActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar-el-archivo.png"))); // NOI18N
        jBGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/esconder.png"))); // NOI18N
        jBBaja.setText("Baja");
        jBBaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBajaActionPerformed(evt);
            }
        });

        jBAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ojo.png"))); // NOI18N
        jBAlta.setText("Alta");
        jBAlta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltaActionPerformed(evt);
            }
        });

        jSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        jSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });

        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton.png"))); // NOI18N
        jBCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(jTTable);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179)
                        .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(1, 1, 1)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTPrecio30, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(jTUso))))))
                .addGap(47, 47, 47)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBBaja)
                        .addGap(29, 29, 29)
                        .addComponent(jBAlta)
                        .addGap(107, 107, 107)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBCancelar)
                    .addComponent(jSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTPrecio30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBActualizar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(63, 63, 63))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBAlta)
                            .addComponent(jBBaja)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBCancelar)
                        .addGap(291, 291, 291)
                        .addComponent(jSalir)))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        try {
            Producto producto = productoSeleccionado();
            pd.eliminarProducto(producto.getIdProducto());
            cargarTabla();
            noSeleccionar();
            limpiar();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "No hay fila seleccionada.");
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

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
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "No hay fila seleccionada.");
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
                String uso = jTUso.getText();
                double precio = Double.parseDouble(jTPrecio30.getText());
                boolean estado = true;

                Instalacion producto = new Instalacion(nombre, uso, precio30, estado);
                pd.agregarProducto(producto);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "No hay fila seleccionada.");
            }
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "No deben haber espacios vacios.");
        }
        cargarTabla();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBajaActionPerformed
        // TODO add your handling code here:
        try {
            pd.darDeBaja(productoSeleccionado().getIdProducto());
            cargarTabla();

            cargarTabla();
            noSeleccionar();
            limpiar();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "No hay fila seleccionada.");
        }
    }//GEN-LAST:event_jBBajaActionPerformed

    private void jBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltaActionPerformed
        // TODO add your handling code here:
        pd.darDeAlta(productoSeleccionado().getIdProducto());
        cargarTabla();

        cargarTabla();
        noSeleccionar();
        limpiar();
    }//GEN-LAST:event_jBAltaActionPerformed

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jSalirActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        jTTable.getSelectionModel().clearSelection();

        limpiar();
        noSeleccionar();
    }//GEN-LAST:event_jBCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBAlta;
    private javax.swing.JButton jBBaja;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTPrecio30;
    private javax.swing.JTable jTTable;
    private javax.swing.JTextField jTUso;
    // End of variables declaration//GEN-END:variables

    public void seleccionar() {
        jBActualizar.setEnabled(true);
        jBGuardar.setEnabled(false);
        jBBaja.setEnabled(true);
        jBAlta.setEnabled(true);
        jBEliminar.setEnabled(true);
    }

    public void armarCabecera() {
        modelo.addColumn("Nombre");
        modelo.addColumn("Uso");
        modelo.addColumn("Precio por 30m");
        jTTable.setModel(modelo);
    }

    public void cargarTabla() {
        insta = insD.traerProductos();

        modelo.setRowCount(0);

        for (Producto p : productos) {
            modelo.addRow(new Object[]{p.getIdProducto(), p.getNombre(), p.getMarca(), p.getTipo(), p.getCosto(), p.isEstado()});
        }
    }

    public void noSeleccionar() {
        jBActualizar.setEnabled(false);
        jBGuardar.setEnabled(true);
        jBBaja.setEnabled(false);
        jBAlta.setEnabled(false);
        jBEliminar.setEnabled(false);
    }

    public boolean validarVacios() {
        boolean valido;
        if (jTNombre.getText().equals("") || jTUso.getText().equals("") || jTPrecio30.getText().equals("")) {
            valido = false;
        } else {
            valido = true;
        }
        return valido;
    }

    public void limpiar() {
        jTNombre.setText("");
        jTUso.setText("");
        jTPrecio30.setText("");
    }
}
