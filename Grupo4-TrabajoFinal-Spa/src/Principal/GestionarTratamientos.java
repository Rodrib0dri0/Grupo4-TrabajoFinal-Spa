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
        inhabilitar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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

        jLabel1.setText("Facial:");

        jCheckBox1.setText("Mascarilla de oro 24k");

        jCheckBox2.setText("Ampolla de ácido hilúronico");

        jCheckBox3.setText("Tónico floral premium");

        jCheckBox4.setText("Sérum de colageno concentrado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4))
        );

        jLabel2.setText("Corporal:");

        jCheckBox5.setText("Aceite reafirmante de algas");

        jCheckBox6.setText("Exfoliante con café organico");

        jCheckBox7.setText("Envoltura de chocolate gourmet");

        jCheckBox8.setText("Vela de masaje corporal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jCheckBox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox8)
                .addContainerGap())
        );

        jLabel3.setText("Relajación:");

        jCheckBox9.setText("Aceite esencial de lavanda");

        jCheckBox10.setText("Aceite de coco premium");

        jCheckBox11.setText("Toalla térmica");

        jCheckBox12.setText("Aromaterapia personalizada");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jCheckBox9)
                    .addComponent(jCheckBox10)
                    .addComponent(jCheckBox11)
                    .addComponent(jCheckBox12))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox12)
                .addContainerGap())
        );

        jLabel4.setText("Estético:");

        jCheckBox13.setText("Esmalte de lujo hipoalergénico");

        jCheckBox14.setText("Bruma corporal con fragancia");

        jCheckBox15.setText("Sérum nutritivo para cúticulas");

        jCheckBox16.setText("Mascarilla capilar con keratina");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox15))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox16)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButton1.setText("Salir");

        jButton2.setText("Guardar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCTipo;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
        jCTipo.addItem("Relajación");
        jCTipo.addItem("Facial");
        jCTipo.addItem("Corporal");
        jCTipo.addItem("Estético");
    }

    public void cargarTratamientos() {
        modelo.setRowCount(0);

        String tipo = jCTipo.getSelectedItem().toString();
        for (TratamientoMasaje t : tratamientos) {
            if (t.getTipo().equals(tipo)) {
                if (t.isActivo() == true) {
                    modelo.addRow(new Object[]{t.getNombre(), t.getTipo(), t.getDuracion(), t.getCosto()});
                }
            }
        }
    }

    public void falseR() {
        jCheckBox1.setEnabled(false);
        jCheckBox2.setEnabled(false);
        jCheckBox3.setEnabled(false);
        jCheckBox4.setEnabled(false);
    }

    public void falseF() {
        jCheckBox5.setEnabled(false);
        jCheckBox6.setEnabled(false);
        jCheckBox7.setEnabled(false);
        jCheckBox8.setEnabled(false);
    }

    public void falseC() {
        jCheckBox9.setEnabled(false);
        jCheckBox10.setEnabled(false);
        jCheckBox11.setEnabled(false);
        jCheckBox12.setEnabled(false);
    }

    public void falseE() {
        jCheckBox13.setEnabled(false);
        jCheckBox14.setEnabled(false);
        jCheckBox15.setEnabled(false);
        jCheckBox16.setEnabled(false);
    }

    public void inhabilitar() {
        falseR();
        falseF();
        falseC();
        falseE();
    }

    public void porTipo() {
        String tipo = jCTipo.getSelectedItem().toString();

        switch (tipo) {
            case "Relajación":
                jCheckBox1.setEnabled(true);
                jCheckBox2.setEnabled(true);
                jCheckBox3.setEnabled(true);
                jCheckBox4.setEnabled(true);
                falseF();
                falseC();
                falseE();
                break;
            case "Facial":
                jCheckBox5.setEnabled(true);
                jCheckBox6.setEnabled(true);
                jCheckBox7.setEnabled(true);
                jCheckBox8.setEnabled(true);
                falseR();
                falseC();
                falseE();
                break;
            case "Corporal":
                jCheckBox9.setEnabled(true);
                jCheckBox10.setEnabled(true);
                jCheckBox11.setEnabled(true);
                jCheckBox12.setEnabled(true);
                falseR();
                falseF();
                falseE();
                break;
            case "Estético":
                jCheckBox13.setEnabled(true);
                jCheckBox14.setEnabled(true);
                jCheckBox15.setEnabled(true);
                jCheckBox16.setEnabled(true);
                falseR();
                falseF();
                falseC();
                break;
        }
    }

    public void habilitar() {
        if (jTTable.getSelectedRow() >= 0) {
            porTipo();
        }
    }
}
