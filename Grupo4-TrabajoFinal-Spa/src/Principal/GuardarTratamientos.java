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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jCEstetico, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCRelajacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCFacial, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCCorporal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jCEstetico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCFacial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCRelajacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCCorporal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)))
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
    private javax.swing.JComboBox<String> jCCorporal;
    private javax.swing.JComboBox<String> jCEstetico;
    private javax.swing.JComboBox<String> jCFacial;
    private javax.swing.JComboBox<String> jCRelajacion;
    private javax.swing.JComboBox<String> jCTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTDetalle;
    private javax.swing.JTable jTTable;
    // End of variables declaration//GEN-END:variables
    private void armarCabecera() {
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
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
                    modelo.addRow(new Object[]{s.getNombre(), s.getTipo(), s.getDuracion(), s.getCosto()});
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
