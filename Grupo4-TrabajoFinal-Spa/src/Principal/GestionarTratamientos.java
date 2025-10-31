package Principal;

import Persistencia.Guardar;
import Modelo.TratamientoMasaje;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class GestionarTratamientos extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    Guardar guardar = new Guardar();

    List<TratamientoMasaje> tratamientos = new ArrayList();

    public GestionarTratamientos() {
        initComponents();
        armarCabecera();
        cargarTipos();
        tratamientos = guardar.guardarTra();
        cargarTratamientos();
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCTratamientos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTable = new javax.swing.JTable();

        jCTratamientos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jCTratamientos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCTratamientosItemStateChanged(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jCTratamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCTratamientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCTratamientosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCTratamientosItemStateChanged
        // TODO add your handling code here:
        cargarTratamientos();
    }//GEN-LAST:event_jCTratamientosItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCTratamientos;
    private javax.swing.JScrollPane jScrollPane1;
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
        jCTratamientos.addItem("Relajación");
        jCTratamientos.addItem("Facial");
        jCTratamientos.addItem("Corporal");
    }

    public void cargarTratamientos() {
        modelo.setRowCount(0);

        String tipo = jCTratamientos.getSelectedItem().toString();
        for (TratamientoMasaje t : tratamientos) {
            if (t.getTipo().equals(tipo)) {
                if (t.isActivo() == true) {
                    modelo.addRow(new Object[]{t.getNombre(), t.getTipo(), t.getDuracion(), t.getCosto()});
                }
            }
        }
    }
}
