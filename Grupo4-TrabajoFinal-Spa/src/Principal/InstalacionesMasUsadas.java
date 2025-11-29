package Principal;

import Modelo.Instalacion;
import Persistencia.InformesData;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JOptionPane;

public class InstalacionesMasUsadas extends JInternalFrameImagen {

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
        this.SetImagen("/Imagenes/FondoMadera.png");
        cargarCabecera();
        cargarTablaUsadas();
        habilitarFiltrar();
        jBBorrar.setEnabled(false);
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
        jLabel3 = new javax.swing.JLabel();
        jBBorrar = new javax.swing.JButton();

        jScrollPane1.setBackground(new java.awt.Color(209, 115, 22));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTTable.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
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

        jDI.setBackground(new java.awt.Color(94, 67, 41));
        jDI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDI.setForeground(new java.awt.Color(255, 255, 255));
        jDI.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDIPropertyChange(evt);
            }
        });

        jDf.setBackground(new java.awt.Color(94, 67, 41));
        jDf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDf.setForeground(new java.awt.Color(255, 255, 255));
        jDf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDfPropertyChange(evt);
            }
        });

        jBFiltrar.setBackground(new java.awt.Color(102, 70, 39));
        jBFiltrar.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jBFiltrar.setText("Filtrar");
        jBFiltrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFiltrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar entre: ");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("y");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/forma-natural-hoja-negra.png"))); // NOI18N
        jLabel3.setText("Instalaciones Solicitadas");

        jBBorrar.setBackground(new java.awt.Color(102, 70, 39));
        jBBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton.png"))); // NOI18N
        jBBorrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jDI, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDf, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
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

        cargarTablaMasUsadas(fi, ff);

        jBBorrar.setEnabled(true);
    }//GEN-LAST:event_jBFiltrarActionPerformed

    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed
        // TODO add your handling code here:
        cargarTablaUsadas();
        jBBorrar.setEnabled(false);
    }//GEN-LAST:event_jBBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBorrar;
    private javax.swing.JButton jBFiltrar;
    private com.toedter.calendar.JDateChooser jDI;
    private com.toedter.calendar.JDateChooser jDf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
