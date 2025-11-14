package Principal;

import Modelo.Producto;
import Modelo.Servicio;
import Persistencia.Guardar;
import Modelo.TratamientoMasaje;
import Persistencia.ProductosData;
import Persistencia.ServicioData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class GuardarTratamientos extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    List<Servicio> servicios = new ArrayList();

    ProductosData pd = new ProductosData();
    ServicioData sd = new ServicioData();

    public GuardarTratamientos() {
        initComponents();
        armarCabecera();
        cargarTipos();
        servicios = sd.traerServicios();
        cargarTratamientos();
        inhabilitar();
        cargarProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCEstetico = new javax.swing.JComboBox<>();
        jCRelajacion = new javax.swing.JComboBox<>();
        jCCorporal = new javax.swing.JComboBox<>();
        jCFacial = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTDetalle = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTProductos = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jCTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jCTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCTipoItemStateChanged(evt);
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
        jTTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTTable);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar-el-archivo.png"))); // NOI18N
        jButton2.setText("Guardar");

        jCEstetico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jCRelajacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jCCorporal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jCCorporal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jCFacial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jCFacial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCFacialActionPerformed(evt);
            }
        });

        jTDetalle.setColumns(20);
        jTDetalle.setRows(5);
        jScrollPane2.setViewportView(jTDetalle);

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
        jScrollPane3.setViewportView(jTProductos);

        jLabel1.setText("Servicio seleccionado:");

        jLabel2.setText("Producto/s seleccionado/s:");

        jButton3.setText("jButton3");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCFacial, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCEstetico, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCRelajacion, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCCorporal, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(36, 36, 36)
                        .addComponent(jButton1)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCRelajacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCCorporal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCFacial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCEstetico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jButton1))
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        inhabilitar();
    }//GEN-LAST:event_jCTipoItemStateChanged

    private void jTTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTableMousePressed
        // TODO add your handling code here:
        porTipo();
    }//GEN-LAST:event_jTTableMousePressed

    private void jCFacialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCFacialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCFacialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCCorporal;
    private javax.swing.JComboBox<String> jCEstetico;
    private javax.swing.JComboBox<String> jCFacial;
    private javax.swing.JComboBox<String> jCRelajacion;
    private javax.swing.JComboBox<String> jCTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTDetalle;
    private javax.swing.JTable jTProductos;
    private javax.swing.JTable jTTable;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    private void armarCabecera() {
        modelo.addColumn("Nombre");
        modelo.addColumn("Duración");
        modelo.addColumn("Costo");
        jTTable.setModel(modelo);
    }

    public void cargarTipos() {
        jCTipo.addItem("Relajación");
        jCTipo.addItem("Facial");
        jCTipo.addItem("Corporal");
        jCTipo.addItem("Estético");
    }

    public void cargarTratamientos() {
        modelo.setRowCount(0);

        String tipo = jCTipo.getSelectedItem().toString();
        for (Servicio s : servicios) {
            if (s.getTipo().equals(tipo)) {
                if (s.isEstado() == true) {
                    modelo.addRow(new Object[]{s.getNombre(),s.getDuracion(), s.getCosto()});
                }
            }
        }
    }

    public void inhabilitar() {
        jCEstetico.setEnabled(false);
        jCRelajacion.setEnabled(false);
        jCFacial.setEnabled(false);
        jCCorporal.setEnabled(false);
    }

    public void porTipo() {
        String tipo = jCTipo.getSelectedItem().toString();

        switch (tipo) {
            case "Relajación":
                jCEstetico.setEnabled(false);
                jCRelajacion.setEnabled(true);
                jCFacial.setEnabled(false);
                jCCorporal.setEnabled(false);
                break;
            case "Facial":
                jCEstetico.setEnabled(false);
                jCRelajacion.setEnabled(false);
                jCFacial.setEnabled(true);
                jCCorporal.setEnabled(false);
                break;
            case "Corporal":
                jCEstetico.setEnabled(false);
                jCRelajacion.setEnabled(false);
                jCFacial.setEnabled(false);
                jCCorporal.setEnabled(true);
                break;
            case "Estético":
                jCEstetico.setEnabled(true);
                jCRelajacion.setEnabled(false);
                jCFacial.setEnabled(false);
                jCCorporal.setEnabled(false);
                break;
        }
    }

    public void habilitar() {
        if (jTTable.getSelectedRow() >= 0) {
            porTipo();
        }
    }

    public void cargarProductos() {
        List<Producto> productos = pd.traerProductos();

        for (Producto p : productos) {
            String nombre = p.getNombre();
            switch (p.getTipo()) {
                case "Estético":
                    jCEstetico.addItem(nombre);
                    break;
                case "Facial":
                    jCFacial.addItem(nombre);
                    break;
                case "Corporal":
                    jCCorporal.addItem(nombre);
                    break;
                case "Relajación":
                    jCRelajacion.addItem(nombre);
                    break;
            }
        }
    }
}
