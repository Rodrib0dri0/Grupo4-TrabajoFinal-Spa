package Principal;

import Modelo.Producto;
import Modelo.Servicio;
import Modelo.TratamientoMasaje;
import Persistencia.ProductosData;
import Persistencia.ServicioData;
import Persistencia.TratamientoMasajeData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GuardarTratamientos extends JInternalFrameImagen {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private DefaultTableModel modelo2 = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    List<Servicio> servicios = new ArrayList();

    ProductosData pd = new ProductosData();
    ServicioData sd = new ServicioData();
    TratamientoMasajeData tmd = new TratamientoMasajeData();

    List<Producto> productosSele = new ArrayList();

    TratamientoMasaje trataSele;

    double total = 0;

    public GuardarTratamientos() {
        initComponents();
        this.SetImagen("/Imagenes/FondoGuardarT.jpg");
        armarCabecera();
        armarCabecera2();
        cargarTipos();
        servicios = sd.traerServicios();
        cargarTratamientos();
        inhabilitar();
        cargarProductos();
        jTTotal.setEditable(false);
        jTTratasele.setEditable(false);
        jBGuardar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jCProductos = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTDetalle = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTProductos = new javax.swing.JTable();
        jTTratasele = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jTTotal = new javax.swing.JTextField();
        jTBloq = new javax.swing.JToggleButton();
        jBQuitar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jCTipo.setBackground(new java.awt.Color(204, 204, 255));
        jCTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jCTipo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCTipoItemStateChanged(evt);
            }
        });

        jTTable.setBackground(new java.awt.Color(204, 255, 255));
        jTTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTTable.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jTTable.setForeground(new java.awt.Color(0, 0, 0));
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
        jTTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTTable.setSelectionBackground(new java.awt.Color(153, 204, 255));
        jTTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTTable);

        jButton1.setBackground(new java.awt.Color(171, 214, 214));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBGuardar.setBackground(new java.awt.Color(171, 214, 214));
        jBGuardar.setForeground(new java.awt.Color(0, 0, 0));
        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar-el-archivo.png"))); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jCProductos.setBackground(new java.awt.Color(204, 204, 255));
        jCProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jCProductos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTDetalle.setColumns(20);
        jTDetalle.setRows(5);
        jScrollPane2.setViewportView(jTDetalle);

        jTProductos.setBackground(new java.awt.Color(204, 255, 255));
        jTProductos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTProductos.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jTProductos.setForeground(new java.awt.Color(0, 0, 0));
        jTProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTProductos.setSelectionBackground(new java.awt.Color(153, 204, 255));
        jScrollPane3.setViewportView(jTProductos);

        jTTratasele.setBackground(new java.awt.Color(204, 204, 255));
        jTTratasele.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Servicio seleccionado:");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Producto/s seleccionado/s:");

        jBAgregar.setBackground(new java.awt.Color(171, 214, 214));
        jBAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jBAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton-agregar.png"))); // NOI18N
        jBAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total:");

        jTBloq.setBackground(new java.awt.Color(171, 214, 214));
        jTBloq.setForeground(new java.awt.Color(0, 0, 0));
        jTBloq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tornillo.png"))); // NOI18N
        jTBloq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTBloq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBloqActionPerformed(evt);
            }
        });

        jBQuitar.setBackground(new java.awt.Color(171, 214, 214));
        jBQuitar.setForeground(new java.awt.Color(0, 0, 0));
        jBQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/resta.png"))); // NOI18N
        jBQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Agregar productos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTTratasele, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTBloq, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBGuardar)
                        .addGap(42, 42, 42)
                        .addComponent(jButton1)
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTBloq, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTTratasele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBGuardar))))
                        .addContainerGap(8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jCProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCTipoItemStateChanged
        // TODO add your handling code here:
        cargarTratamientos();
        productosSele.clear();
        cargarTablaProdu();

        total = 0;
        jTTotal.setText(String.valueOf(total));

    }//GEN-LAST:event_jCTipoItemStateChanged

    private void jTTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTableMousePressed
        // TODO add your handling code here:
        if (!jTBloq.isSelected()) {
            cargarProductos();
            jTTratasele.setText(tratamientoSeleccionado().getNombre());
            total = tratamientoSeleccionado().getCosto();
            jTTotal.setText(String.valueOf(total));
        }
    }//GEN-LAST:event_jTTableMousePressed

    private void jTBloqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBloqActionPerformed
        // TODO add your handling code here:
        if (jTBloq.isSelected()) {
            jTTratasele.setEnabled(false);
            jCProductos.setEnabled(true);
            jTTable.setEnabled(false);
            jCTipo.setEnabled(false);
            jTDetalle.setEnabled(false);
            jBAgregar.setEnabled(true);
            jBQuitar.setEnabled(true);
            jBGuardar.setEnabled(true);
        } else {
            jTTratasele.setEnabled(true);
            jCProductos.setEnabled(false);
            jTTable.setEnabled(true);
            jCTipo.setEnabled(true);
            jTDetalle.setEnabled(true);
            jBAgregar.setEnabled(false);
            jBQuitar.setEnabled(false);
            jBGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_jTBloqActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        // TODO add your handling code here:
        String nombre = jCProductos.getSelectedItem().toString();
        Producto produ = pd.buscarProductoporNombre(nombre);
        productosSele.add(produ);

        total += produ.getCosto();
        jTTotal.setText(String.valueOf(total));

        cargarTablaProdu();
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:

        String detalle = jTDetalle.getText();
        double precio = Double.parseDouble(jTTotal.getText());

        trataSele = new TratamientoMasaje(productosSele, tratamientoSeleccionado().getIdServicio(), detalle, precio, true);

        tmd.guardarTratamiento(trataSele);


    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitarActionPerformed
        // TODO add your handling code here:
        if (productosSele.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos cargados!");
        } else {

            Producto quitar = productosSele.get(productosSele.size() - 1);

            total -= quitar.getCosto();

            productosSele.remove(productosSele.size() - 1);

            jTTotal.setText(String.valueOf(total));

            cargarTablaProdu();
        }

    }//GEN-LAST:event_jBQuitarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBQuitar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCProductos;
    private javax.swing.JComboBox<String> jCTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jTBloq;
    private javax.swing.JTextArea jTDetalle;
    private javax.swing.JTable jTProductos;
    private javax.swing.JTable jTTable;
    private javax.swing.JTextField jTTotal;
    private javax.swing.JTextField jTTratasele;
    // End of variables declaration//GEN-END:variables
    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Duración");
        jTTable.setModel(modelo);
    }

    private void armarCabecera2() {
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Marca");
        jTProductos.setModel(modelo2);
    }

    public void cargarTipos() {
        jCTipo.addItem("Relajación");
        jCTipo.addItem("Facial");
        jCTipo.addItem("Corporal");
        jCTipo.addItem("Estético");
    }

    public void cargarTablaProdu() {
        modelo2.setRowCount(0);

        for (Producto p : productosSele) {
            if (p.isEstado() == true) {
                modelo2.addRow(new Object[]{p.getNombre(), p.getMarca()});
            }
        }
    }

    public void cargarTratamientos() {
        modelo.setRowCount(0);

        String tipo = jCTipo.getSelectedItem().toString();
        for (Servicio s : servicios) {
            if (s.getTipo().equals(tipo)) {
                if (s.isEstado() == true) {
                    modelo.addRow(new Object[]{s.getIdServicio(), s.getNombre(), s.getDuracion()});
                }
            }
        }
    }

    public void inhabilitar() {
        jCProductos.setEnabled(false);
        jBAgregar.setEnabled(false);
        jBQuitar.setEnabled(false);
    }

    public void cargarProductos() {
        List<Producto> productos = pd.traerProductos();
        jCProductos.removeAllItems();

        for (Producto p : productos) {
            String nombre = p.getNombre();
            if (p.getTipo().equals(jCTipo.getSelectedItem().toString())) {
                switch (p.getTipo()) {
                    case "Estético":
                        jCProductos.addItem(nombre);
                        break;
                    case "Facial":
                        jCProductos.addItem(nombre);
                        break;
                    case "Corporal":
                        jCProductos.addItem(nombre);
                        break;
                    case "Relajación":
                        jCProductos.addItem(nombre);
                        break;
                }
            }
        }
    }

    public Servicio tratamientoSeleccionado() {
        int fila = jTTable.getSelectedRow();

        int id = Integer.parseInt(jTTable.getValueAt(fila, 0).toString());

        Servicio servi = sd.buscarServicio(id);

        return servi;
    }
}
