package Principal;

import Modelo.DiaDeSpa;
import Persistencia.InstalacionData;
import Modelo.Instalacion;
import Modelo.Masajista;
import Modelo.Producto;
import Modelo.TratamientoMasaje;
import Persistencia.ServicioData;
import Modelo.Servicio;
import Modelo.Sesion;
import Persistencia.SesionData;
import Persistencia.MasajistaData;
import java.util.*;
import javax.swing.SpinnerDateModel;
import javax.swing.JDesktopPane;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Persistencia.TratamientoMasajeData;
import java.time.ZoneId;

public class GestionarSesion extends JInternalFrameImagen {

    InstalacionData insD = new InstalacionData();
    MasajistaData md = new MasajistaData();
    ServicioData sd = new ServicioData();
    SesionData sed = new SesionData();
    TratamientoMasajeData tmd = new TratamientoMasajeData();
    private JDesktopPane desk;
    private TratamientoMasaje trata;
    private VistaDiaDeSpa padre;
    private DiaDeSpa diaactual; //la sesion necesita saber a que diadespa pertenece, guardamos el dia de spa actual

    double total = 0;

    List<Instalacion> instalaciones = new ArrayList();

    //Modelo de tabla Instalaciones
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    //Modelo de tabla masajistas
    private DefaultTableModel modeloM = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    Masajista masa = null;

    public GestionarSesion(JDesktopPane desk, VistaDiaDeSpa padre, DiaDeSpa diaactual) {
        initComponents();
        this.SetImagen("/Imagenes/FondoSesion.jpg");
        this.desk = desk;
        this.padre = padre;
        this.diaactual = diaactual;
        SpinnerDateModel modelohora = new SpinnerDateModel();
        armarCabecera();
        armarCabeceraMasajista();
        jSFechaI.setModel(modelohora);
        jSFechaF.setModel(modelohora);
        cargarInstalaciones();
        cargarInsta();
        jR30.setSelected(true);
        jTTotal.setEditable(false);
        cargarMasajistas();
        jTTratamiento.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCProductos = new javax.swing.JComboBox<>();
        jTTratamiento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBSelec = new javax.swing.JButton();
        jCInsta = new javax.swing.JComboBox<>();
        jBAgregar = new javax.swing.JButton();
        jBQuitar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTInstalaciones = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSFechaI = new javax.swing.JSpinner();
        jSFechaF = new javax.swing.JSpinner();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jR30 = new javax.swing.JRadioButton();
        jR60 = new javax.swing.JRadioButton();
        jR120 = new javax.swing.JRadioButton();
        jR90 = new javax.swing.JRadioButton();
        jBGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMasa = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTMSeleccionado = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel1.setText("Fecha-Hora inicio:");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setText("Fecha-Hora fin:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel3.setText("Tratamiento:");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel4.setText("Masajistas disponibles:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel5.setText("Instalacion/es:");

        jTTratamiento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTTratamientoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel6.setText("Productos:");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel7.setText("Sesiones");

        jBSelec.setText("Seleccionar");
        jBSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelecActionPerformed(evt);
            }
        });

        jBAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton-agregar.png"))); // NOI18N
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/resta.png"))); // NOI18N
        jBQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitarActionPerformed(evt);
            }
        });

        jTInstalaciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTInstalaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTInstalaciones);

        buttonGroup1.add(jR30);
        jR30.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jR30.setText("30m");

        buttonGroup1.add(jR60);
        jR60.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jR60.setText("60m");

        buttonGroup1.add(jR120);
        jR120.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jR120.setText("120m");

        buttonGroup1.add(jR90);
        jR90.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jR90.setText("90m");

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jTMasa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTMasa.setModel(new javax.swing.table.DefaultTableModel(
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
        jTMasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTMasaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTMasa);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel8.setText("Total:");

        jTTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel9.setText("Masajista seleccionada/o:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBGuardar)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jCInsta, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jR60)
                                    .addComponent(jR90)
                                    .addComponent(jR30))
                                .addGap(10, 10, 10))
                            .addComponent(jR120))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBQuitar)
                            .addComponent(jBAgregar))
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jBSelec)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(80, 80, 80)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jCProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jSFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jTMSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator1))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jSFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jBSelec)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jTMSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(jCInsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jBAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jBQuitar)
                            .addGap(12, 12, 12)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jR30)
                        .addGap(2, 2, 2)
                        .addComponent(jR60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jR90)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jR120)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar)
                    .addComponent(jLabel8)
                    .addComponent(jTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        // TODO add your handling code here:
        //Según la opción de tiempo se cambia el precio
        String nombre = jCInsta.getSelectedItem().toString();
        Instalacion insta = insD.buscarInstaporNombre(nombre);

        for (Instalacion i : instalaciones) {
            if (i.getIdInstalacion() == insta.getIdInstalacion()) {
                JOptionPane.showMessageDialog(null, "instalación ya agregada!");
            }
        }

        double precio = insta.getPrecio30m();
        if (jR30.isSelected()) {

        } else if (jR60.isSelected()) {
            precio *= 2;
        } else if (jR90.isSelected()) {
            precio *= 3;
        } else if (jR120.isSelected()) {
            precio *= 4;
        }
        insta.setPrecio30m(precio);
        instalaciones.add(insta);

        total += precio;
        jTTotal.setText(String.valueOf(total));

        cargarInsta();

    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitarActionPerformed
        // TODO add your handling code here:

        if (!instalaciones.isEmpty()) {

            Instalacion quitar = instalaciones.get(instalaciones.size() - 1);

            total -= quitar.getPrecio30m();

            instalaciones.remove(instalaciones.size() - 1);

            jTTotal.setText(String.valueOf(total));

            cargarInsta();

        } else {

            JOptionPane.showMessageDialog(null, "No hay instalaciones agregadas!");
        }

    }//GEN-LAST:event_jBQuitarActionPerformed

    private void jBSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelecActionPerformed
        // TODO add your handling code here:
        GuardarTratamientos t = new GuardarTratamientos(this);
        desk.add(t);
        t.setVisible(true);
    }//GEN-LAST:event_jBSelecActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:

        if (trata == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tratamiento.");
            return;
        }
        if (masa == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un/a masajista.");
            return;
        }
        try {
            
            trata = tmd.guardarTratamiento(trata);

            System.out.println("ID Tratamiento generado: " + trata.getIdTratamiento());
            TratamientoMasaje tratamiento = tmd.buscarTratamiento(trata.getIdTratamiento());
            System.out.println(tratamiento.toString());

            Date dIni = (Date) jSFechaI.getValue();
            LocalDateTime fechaI = dIni.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            Date dFin = (Date) jSFechaF.getValue();
            LocalDateTime fechaF = dFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            List<Instalacion> copiaInst = new ArrayList<>();
            for (Instalacion i : instalaciones) {
                copiaInst.add(new Instalacion(i.getIdInstalacion(), i.getNombre(), i.getDetalleDeUso(), i.getPrecio30m(), i.isEstado()));
            }

            Sesion sesi = new Sesion(fechaI, fechaF, tmd.buscarTratamiento(trata.getIdTratamiento()), masa, copiaInst, true);

            padre.agregarSesion(sesi);  // agrega la sesión a listaSesiones de VistaDiaDeSpa
            sed.agregarSesion(sesi);
            
            dispose();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar.");
        } catch (java.lang.ClassCastException e) {
            JOptionPane.showMessageDialog(null, "Error en fechas.");
        } catch(Exception c){
            JOptionPane.showMessageDialog(null, "Error "+ c);
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jTTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTTratamientoActionPerformed
        // TODO add your handling code here:
        total += trata.getPrecio();

        jTTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_jTTratamientoActionPerformed

    private void jTMasaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMasaMousePressed
        // TODO add your handling code here:
        masa = masajistaSeleccionado();
        jTMSeleccionado.setText(masa.getNombre() + " " + masa.getApellido());
    }//GEN-LAST:event_jTMasaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBQuitar;
    private javax.swing.JButton jBSelec;
    private javax.swing.JComboBox<String> jCInsta;
    private javax.swing.JComboBox<String> jCProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jR120;
    private javax.swing.JRadioButton jR30;
    private javax.swing.JRadioButton jR60;
    private javax.swing.JRadioButton jR90;
    private javax.swing.JSpinner jSFechaF;
    private javax.swing.JSpinner jSFechaI;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTInstalaciones;
    private javax.swing.JTextField jTMSeleccionado;
    private javax.swing.JTable jTMasa;
    private javax.swing.JTextField jTTotal;
    private javax.swing.JTextField jTTratamiento;
    // End of variables declaration//GEN-END:variables

    public void cargarMasajistas() {
        List<Masajista> masajistas = md.traerMasajistas();

        for (Masajista m : masajistas) {
            if (m.isEstado()) {
                modeloM.addRow(new Object[]{m.getMatricula(), m.getNombre(), m.getApellido()});
            }
        }
    }

    public void armarCabeceraMasajista() {
        modeloM.addColumn("Matricula");
        modeloM.addColumn("Nombre");
        modeloM.addColumn("Apellido");
        jTMasa.setModel(modeloM);
    }

    public void recibirTratamiento(TratamientoMasaje t) {
        trata = t;

        Servicio servi = sd.buscarServicio(trata.getIdServicio());

        jTTratamiento.setText(servi.getNombre());

        jCProductos.removeAllItems();
        for (Producto p : trata.getProductos()) {
            jCProductos.addItem(p.getNombre());
        }
    }

    public void armarCabecera() {
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio 30m");
        jTInstalaciones.setModel(modelo);
    }

    public void cargarInsta() {
        modelo.setRowCount(0);

        for (Instalacion i : instalaciones) {
            if (i.isEstado() == true) {
                modelo.addRow(new Object[]{i.getNombre(), i.getPrecio30m()});
            }
        }
    }

    public void cargarInstalaciones() {
        List<Instalacion> instalacionesDispo = insD.traerInstalaciones();

        jCInsta.removeAllItems();

        for (Instalacion i : instalacionesDispo) {
            if (i.isEstado()) {
                jCInsta.addItem(i.getNombre());
            }
        }
    }

    public Masajista masajistaSeleccionado() {
        int fila = jTMasa.getSelectedRow();

        int matri = Integer.parseInt(jTMasa.getValueAt(fila, 0).toString());

        Masajista produ = md.buscarMasajista(matri);

        return produ;
    }
}
