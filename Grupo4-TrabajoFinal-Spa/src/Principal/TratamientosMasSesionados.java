package Principal;

import Modelo.Instalacion;
import Modelo.Servicio;
import Persistencia.InformesData;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class TratamientosMasSesionados extends JInternalFrameImagen {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int colum) {
            return false;
        }
    };
    Map<Servicio, Integer> insta = new HashMap();
    
    InformesData ifd = new InformesData();

    public TratamientosMasSesionados() {
        initComponents();
        this.SetImagen("/Imagenes/FondoMarmol.jpg");
        armarCabecera();
        cargarTabla();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTTabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jTTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTTabla);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("instalaciones más sesionadas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTTabla;
    // End of variables declaration//GEN-END:variables
public void armarCabecera() {
        modelo.addColumn("Tratamiento");
        modelo.addColumn("Veces elegidos");
        jTTabla.setModel(modelo);
    }

    public void cargarTabla() {
        modelo.setRowCount(0);
        
        insta = ifd.serviUsadas();
        
        for(Map.Entry<Servicio, Integer> entry : insta.entrySet()){
            Servicio ins  = entry.getKey();
            Integer usos = entry.getValue();
            
            modelo.addRow(new Object[]{ins.getNombre(), usos});
        }
    }
}
