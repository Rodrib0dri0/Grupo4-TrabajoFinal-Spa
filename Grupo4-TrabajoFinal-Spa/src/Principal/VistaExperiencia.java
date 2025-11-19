package Principal;

import Persistencia.ExperienciaData;
import Modelo.Experiencia;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VistaExperiencia extends javax.swing.JInternalFrame {

    ExperienciaData data = new ExperienciaData();

    public VistaExperiencia() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jR1 = new javax.swing.JRadioButton();
        jR3 = new javax.swing.JRadioButton();
        jR2 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jR4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTComen = new javax.swing.JTextArea();
        Enviar = new javax.swing.JButton();
        jSalir = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(153, 102, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("¡CALIFICA NUESTRO SERVICIO!");

        buttonGroup2.add(jR1);
        jR1.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jR1.setForeground(new java.awt.Color(0, 0, 0));
        jR1.setText("Malo");
        jR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jR1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jR3);
        jR3.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jR3.setForeground(new java.awt.Color(0, 0, 0));
        jR3.setText("Bueno");

        buttonGroup2.add(jR2);
        jR2.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jR2.setForeground(new java.awt.Color(0, 0, 0));
        jR2.setText("Regular");
        jR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jR2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton4.setText("Excelente");

        buttonGroup2.add(jR4);
        jR4.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jR4.setForeground(new java.awt.Color(0, 0, 0));
        jR4.setText("Muy bueno");
        jR4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jR4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jR1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jR2)
                .addGap(51, 51, 51)
                .addComponent(jR3)
                .addGap(57, 57, 57)
                .addComponent(jR4)
                .addGap(51, 51, 51)
                .addComponent(jRadioButton4)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jR1)
                    .addComponent(jR3)
                    .addComponent(jR2)
                    .addComponent(jRadioButton4)
                    .addComponent(jR4))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 130));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tu opinion nos interesa");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jTComen.setBackground(new java.awt.Color(204, 204, 204));
        jTComen.setColumns(20);
        jTComen.setRows(5);
        jScrollPane1.setViewportView(jTComen);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 630, -1));

        Enviar.setBackground(new java.awt.Color(255, 255, 255));
        Enviar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Enviar.setForeground(new java.awt.Color(0, 0, 0));
        Enviar.setText("ENVIAR");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });
        jPanel2.add(Enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jSalir.setBackground(new java.awt.Color(213, 213, 141));
        jSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        jSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });
        jPanel2.add(jSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jR1ActionPerformed

    private void jR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jR2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jR2ActionPerformed

    private void jR4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jR4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jR4ActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        int puntaje = 0;
        if (jR1.isSelected()) {
            puntaje = 1;
        } else if (jR2.isSelected()) {
            puntaje = 2;
        } else if (jR3.isSelected()) {
            puntaje = 3;
        } else if (jR4.isSelected()) {
            puntaje = 4;
        } else if (jRadioButton4.isSelected()) {
            puntaje = 5;
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una puntuación antes de enviar");
        }
        
        String comentario = jTComen.getText();
        
        Experiencia exp = new Experiencia(puntaje, comentario);
        
        data.guardar(exp);
        limpiar();
    }//GEN-LAST:event_EnviarActionPerformed

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Enviar;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jR1;
    private javax.swing.JRadioButton jR2;
    private javax.swing.JRadioButton jR3;
    private javax.swing.JRadioButton jR4;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JButton jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTComen;
    // End of variables declaration//GEN-END:variables
    public void limpiar(){
        jR1.setSelected(false);
        jR2.setSelected(false);
        jR3.setSelected(false);
        jR4.setSelected(false);
        jRadioButton4.setSelected(false);
        
        jTComen.setText("");
    }
}
