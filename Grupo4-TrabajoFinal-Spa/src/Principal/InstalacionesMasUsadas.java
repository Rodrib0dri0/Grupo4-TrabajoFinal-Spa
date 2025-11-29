package Principal;

import Modelo.Instalacion;
import Persistencia.InformesData;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JOptionPane;

public class InstalacionesMasUsadas extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    Map<Instalacion, Integer> instaU = new HashMap();

    Map<Instalacion, Integer> instaMU = new HashMap();

    InformesData infod = new InformesData();

    public InstalacionesMasUsadas() {
        initComponents();
        cargarCabecera();
        cargarTablaUsadas();
        habilitarFiltrar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jDI = new com.toedter.calendar.JDateChooser();
        jDf = new com.toedter.calendar.JDateChooser();
        jBFiltrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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

        jDI.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDIPropertyChange(evt);
            }
        });

        jDf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDfPropertyChange(evt);
            }
        });

        jBFiltrar.setText("Filtrar");
        jBFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFiltrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar entre: ");

        jLabel2.setText("y");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(169, 169, 169))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jDI, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDf, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBFiltrar)
                                .addGap(56, 56, 56))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBFiltrar)
                    .addComponent(jDI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDIPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDIPropertyChange
        // TODO add your handling code here:
        habilitarFiltrar();
    }//GEN-LAST:event_jDIPropertyChange

    private void jDfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDfPropertyChange
        // TODO add your handling code here:
        habilitarFiltrar();
    }//GEN-LAST:event_jDfPropertyChange

    private void jBFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFiltrarActionPerformed
        // TODO add your handling code here:
        if (jDI.getDate() == null || jDI.getDate().equals("") || jDf.getDate() == null || jDf.getDate().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar fechas validas.");
            return;
        }
        Date fechaI = jDI.getDate();
        
        LocalDateTime fi = fechaI.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        
        Date fechaF = jDf.getDate();
        
        LocalDateTime ff = fechaF.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        
        cargarTablaMasUsadas(fi,ff);

    }//GEN-LAST:event_jBFiltrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBFiltrar;
    private com.toedter.calendar.JDateChooser jDI;
    private com.toedter.calendar.JDateChooser jDf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTTable;
    // End of variables declaration//GEN-END:variables

    public void cargarCabecera() {
        modelo.addColumn("Usos");
        modelo.addColumn("Instalación");
        jTTable.setModel(modelo);
    }

    public void cargarTablaUsadas() {
        modelo.setRowCount(0);

        instaU = infod.instaUsadas();

        for (Map.Entry<Instalacion, Integer> entry : instaU.entrySet()) {
            Instalacion ins = entry.getKey();
            Integer usos = entry.getValue();

            modelo.addRow(new Object[]{usos, ins.getNombre()});
        }
    }

    public void cargarTablaMasUsadas(LocalDateTime fi, LocalDateTime ff) {
        modelo.setRowCount(0);

        instaU = infod.instaMasUsadas(fi, ff);

        for (Map.Entry<Instalacion, Integer> entry : instaU.entrySet()) {
            Instalacion ins = entry.getKey();
            Integer usos = entry.getValue();

            modelo.addRow(new Object[]{usos, ins.getNombre()});
        }
    }

    public void habilitarFiltrar() {
        if (jDI.getDate() == null || jDf.getDate() == null) {
            jBFiltrar.setEnabled(false);
        } else {
            jBFiltrar.setEnabled(true);
        }
    }
}
