package Principal;

import Modelo.Servicio;
import Persistencia.ServicioData;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JOptionPane;

public class GestionarServicios extends JInternalFrameImagen {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    ServicioData sd = new ServicioData();

    public GestionarServicios() {
        initComponents();
       this.SetImagen("/Imagenes/FondoServi.jpg");
        armarCabecera();
        cargarTabla();
        cargarTipos();
        noSeleccionar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPData = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jTDuracion = new javax.swing.JTextField();
        jTCosto = new javax.swing.JTextField();
        jCTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDetalle = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTTable = new javax.swing.JTable();
        jSalir = new javax.swing.JButton();
        jBAlta = new javax.swing.JButton();
        jBBaja = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jBCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jPData.setBackground(new java.awt.Color(234, 206, 234));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("Tipo:");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Detalle");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setText("Costo");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setText("Duración:");

        jTNombre.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jTNombre.setForeground(new java.awt.Color(0, 0, 0));
        jTNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTDuracion.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jTDuracion.setForeground(new java.awt.Color(0, 0, 0));
        jTDuracion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTCosto.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jTCosto.setForeground(new java.awt.Color(0, 0, 0));
        jTCosto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jCTipo.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jCTipo.setForeground(new java.awt.Color(0, 0, 0));

        jTDetalle.setColumns(20);
        jTDetalle.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jTDetalle.setForeground(new java.awt.Color(0, 0, 0));
        jTDetalle.setRows(5);
        jTDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(jTDetalle);

        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPDataLayout = new javax.swing.GroupLayout(jPData);
        jPData.setLayout(jPDataLayout);
        jPDataLayout.setHorizontalGroup(
            jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDataLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPDataLayout.createSequentialGroup()
                        .addGroup(jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPDataLayout.createSequentialGroup()
                        .addGroup(jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPDataLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPDataLayout.createSequentialGroup()
                                        .addComponent(jCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPDataLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPDataLayout.setVerticalGroup(
            jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTTable.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
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
        jScrollPane2.setViewportView(jTTable);

        jSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        jSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });

        jBAlta.setForeground(new java.awt.Color(0, 0, 0));
        jBAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ojo.png"))); // NOI18N
        jBAlta.setText("Alta");
        jBAlta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltaActionPerformed(evt);
            }
        });

        jBBaja.setForeground(new java.awt.Color(0, 0, 0));
        jBBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/esconder.png"))); // NOI18N
        jBBaja.setText("Baja");
        jBBaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBajaActionPerformed(evt);
            }
        });

        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        jBEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBActualizar.setForeground(new java.awt.Color(0, 0, 0));
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

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton.png"))); // NOI18N
        jBCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(102, 51, 0));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flor.png"))); // NOI18N
        jLabel6.setText("Gestionar Servicios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jPData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(95, 95, 95)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBCancelar)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBBaja)
                        .addGap(47, 47, 47)
                        .addComponent(jBAlta)
                        .addGap(136, 136, 136)
                        .addComponent(jSalir)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jPData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBActualizar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAlta)
                    .addComponent(jBBaja)
                    .addComponent(jSalir))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jSalirActionPerformed

    private void jBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltaActionPerformed
        // TODO add your handling code here:
        try {
            sd.darDeAlta(servicioSeleccionado().getIdServicio());
            cargarTabla();

            cargarTabla();
            noSeleccionar();
            limpiar();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "No hay fila seleccionada.");
        }
    }//GEN-LAST:event_jBAltaActionPerformed

    private void jBBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBajaActionPerformed
        // TODO add your handling code here:
        try {
            sd.darDeBaja(servicioSeleccionado().getIdServicio());
            cargarTabla();

            cargarTabla();
            noSeleccionar();
            limpiar();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "No hay fila seleccionada.");
        }
    }//GEN-LAST:event_jBBajaActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        try {
            Servicio servi = servicioSeleccionado();
            sd.eliminarTratamiento(servi.getIdServicio());
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
                Servicio serviSeleccionado = servicioSeleccionado();

                String nombre = jTNombre.getText();
                String detalle = jTDetalle.getText();
                String tipo = jCTipo.getSelectedItem().toString();
                double costo = Double.parseDouble(jTCosto.getText());
                int duracion = Integer.parseInt(jTDuracion.getText());
                boolean estado = sd.estadoActual(serviSeleccionado.getIdServicio());

                Servicio producto = new Servicio(nombre, tipo, duracion, detalle, costo, estado);
                producto.setIdServicio(serviSeleccionado.getIdServicio());
                sd.actualizarTratamiento(producto);
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
                String detalle = jTDetalle.getText();
                String tipo = jCTipo.getSelectedItem().toString();
                double costo = Double.parseDouble(jTCosto.getText());
                int duracion = Integer.parseInt(jTDuracion.getText());
                boolean estado = true;

                Servicio servi = new Servicio(nombre, tipo, duracion, detalle, costo, estado);
                sd.guardarTratamiento(servi);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            }
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "No deben haber espacios vacios.");
        }
        cargarTabla();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        jTTable.getSelectionModel().clearSelection();

        limpiar();
        noSeleccionar();
        cargarTabla();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jTTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTableMousePressed
        // TODO add your handling code here:
        try {
            Servicio ser = servicioSeleccionado();

            jTNombre.setText(ser.getNombre());
            jCTipo.setSelectedItem(ser.getTipo());
            jTDetalle.setText(ser.getDetalle());
            jTDuracion.setText(String.valueOf(ser.getDuracion()));
            jTCosto.setText(String.valueOf(ser.getCosto()));

            seleccionar();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "No hay fila seleccionada.");
        }
    }//GEN-LAST:event_jTTableMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        filtrarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBAlta;
    private javax.swing.JButton jBBaja;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPData;
    private javax.swing.JButton jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTCosto;
    private javax.swing.JTextArea jTDetalle;
    private javax.swing.JTextField jTDuracion;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTable jTTable;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Detalle");
        modelo.addColumn("Duración");
        modelo.addColumn("Costo");
        modelo.addColumn("Estado");
        jTTable.setModel(modelo);
    }

    public void cargarTabla() {
        List<Servicio> servicios = new ArrayList();

        servicios = sd.traerServicios();

        modelo.setRowCount(0);

        for (Servicio s : servicios) {
            modelo.addRow(new Object[]{s.getIdServicio(), s.getNombre(), s.getTipo(), s.getDetalle(), s.getDuracion(), s.getCosto(), s.isEstado()});
        }
    }

    public void cargarTipos() {
        jCTipo.addItem("Relajación");
        jCTipo.addItem("Facial");
        jCTipo.addItem("Corporal");
        jCTipo.addItem("Estético");
    }

    public boolean validarVacios() {
        boolean valido;
        if (jTNombre.getText().equals("") || jTDetalle.getText().equals("") || jTCosto.getText().equals("") || jTDuracion.getText().equals("")) {
            valido = false;
        } else {
            valido = true;
        }
        return valido;
    }

    public void limpiar() {
        jTNombre.setText("");
        jTDetalle.setText("");
        jCTipo.setSelectedIndex(0);
        jTCosto.setText("");
        jTDuracion.setText("");
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

    public Servicio servicioSeleccionado() {

        int fila = jTTable.getSelectedRow();

        int id = Integer.parseInt(jTTable.getValueAt(fila, 0).toString());

        Servicio servi = sd.buscarServicio(id);

        return servi;

    }

    public void filtrarTabla() {
        List<Servicio> servicios = new ArrayList();

        String tipo = jCTipo.getSelectedItem().toString();

        servicios = sd.traerServicios();

        modelo.setRowCount(0);

        for (Servicio s : servicios) {
            if (s.getTipo().equals(tipo)) {
                modelo.addRow(new Object[]{s.getIdServicio(), s.getNombre(), s.getTipo(), s.getDetalle(), s.getDuracion(), s.getCosto(), s.isEstado()});
            }
        }
    }
}
