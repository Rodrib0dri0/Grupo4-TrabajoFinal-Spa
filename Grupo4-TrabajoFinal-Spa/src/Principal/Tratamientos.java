package Principal;

import Modelo.TratamientoMasaje;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Tratamientos extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    
    List<TratamientoMasaje> tratamientos = new ArrayList();
    public Tratamientos() {
        initComponents();
        armarCabecera();
        tratamientosMasajes();
        cargarTratamientos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTTable = new javax.swing.JTable();

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTTable;
    // End of variables declaration//GEN-END:variables
    private void armarCabecera(){
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Detalle");
        modelo.addColumn("Duración");
        modelo.addColumn("Costo");
        jTTable.setModel(modelo);
    }
    
    public void tratamientosMasajes(){
        TratamientoMasaje t1 = new TratamientoMasaje("Masaje Sueco", "Relajación", "Terapia de relajación de cuerpo completo con presión ligera a media.",45 ,8500.00,true );
        tratamientos.add(t1);
        TratamientoMasaje t2 = new TratamientoMasaje("Masaje de tejido profundo", "Relajación", "Para aliviar tensión muscular crónica y tratar contracturas, con presión más intensa.",75 ,9500.00,true );
        tratamientos.add(t2);
    }
    
    public void cargarTratamientos(){
        modelo.setRowCount(0);
        
        for(TratamientoMasaje t : tratamientos){
            modelo.addRow(new Object[]{t.getNombre(),t.getTipo(),t.getDetalle(),t.getDuracion(),t.getCosto()});
        }
    }
}
