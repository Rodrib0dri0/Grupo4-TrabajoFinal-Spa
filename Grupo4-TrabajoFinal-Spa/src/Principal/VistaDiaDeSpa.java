package Principal;

import Modelo.Cliente;
import Modelo.DiaDeSpa;
import Modelo.Servicio;
import Modelo.Sesion;

import Persistencia.ClienteData;
import Persistencia.DiadeSpaData;
import Persistencia.ServicioData;
import java.awt.Color;
import java.sql.Connection;
import java.util.Date;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author franc
 */
public class VistaDiaDeSpa extends JInternalFrameImagen {

    private GestionarSesion ventanaSesion;
    private VistaTablaSesiones tablasesiones;
    private DiadeSpaData diaDeSpaData = new DiadeSpaData();
    private Sesion sesion;
    private DiaDeSpa diaactual;
    ServicioData servidata = new ServicioData();

    /**
     * Creates new form DiaDeSpa
     */
    public VistaDiaDeSpa() {
        initComponents();
        cargarClientes();
        inicializaMonto();
        diaactual = new DiaDeSpa();

        SpinnerDateModel modelo = new SpinnerDateModel();
        jshora.setModel(modelo);

        JSpinner.DateEditor editor = new JSpinner.DateEditor(jshora, "dd/MM/yyyy HH:mm");
        jshora.setEditor(editor);

        // Hacer que el campo del spinner NO sea editable
        JFormattedTextField txt = editor.getTextField();
        txt.setEditable(false);
        txt.setBackground(Color.WHITE);  // opcional: para que no quede gris
    }

    public VistaDiaDeSpa(Sesion sesion) {
        initComponents();
        cargarClientes();
        inicializaMonto();
        diaactual = new DiaDeSpa();

        SpinnerDateModel modelo = new SpinnerDateModel();
        jshora.setModel(modelo);

        JSpinner.DateEditor editor = new JSpinner.DateEditor(jshora, "dd/MM/yyyy HH:mm");
        jshora.setEditor(editor);

        // Hacer que el campo del spinner NO sea editable
        JFormattedTextField txt = editor.getTextField();
        txt.setEditable(false);
        txt.setBackground(Color.WHITE);  // opcional: para que no quede gris

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpreferencias = new javax.swing.JTextArea();
        jtmonto = new javax.swing.JTextField();
        jcclientes = new javax.swing.JComboBox<>();
        jCSesiones = new javax.swing.JComboBox<>();
        jshora = new javax.swing.JSpinner();
        jRadioButton1 = new javax.swing.JRadioButton();
        jabonado = new javax.swing.JRadioButton();
        jagregar = new javax.swing.JButton();
        jversesiones = new javax.swing.JButton();
        jbguardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jBTotal = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(736, 1104));

        jPanel1.setMinimumSize(new java.awt.Dimension(736, 1104));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtpreferencias.setColumns(20);
        jtpreferencias.setRows(5);
        jScrollPane1.setViewportView(jtpreferencias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 340, 100));
        jPanel1.add(jtmonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 520, -1, -1));

        jPanel1.add(jcclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 140, -1));

        jPanel1.add(jCSesiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, 140, -1));
        jPanel1.add(jshora, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 140, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jRadioButton1.setText("Pago pendiente");
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

        buttonGroup1.add(jabonado);
        jabonado.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jabonado.setText("Abonado");
        jPanel1.add(jabonado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, -1, -1));

        jagregar.setText("Agregar Sesion");
        jagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jagregarActionPerformed(evt);
            }
        });
        jPanel1.add(jagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, -1, -1));

        jversesiones.setText("Ver Sesiones");
        jversesiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jversesionesActionPerformed(evt);
            }
        });
        jPanel1.add(jversesiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, -1, -1));

        jbguardar.setText("Guardar");
        jbguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardarActionPerformed(evt);
            }
        });
        jPanel1.add(jbguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 630, -1, -1));

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 630, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 520, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sesiones");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cliente");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Preferencias");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hora");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/DiaDeSpa.jpeg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 720));

        jBTotal.setText("Calcular Total");
        jBTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBTotal)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 338, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBTotal)
                .addGap(507, 507, 507))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardarActionPerformed
        try {
            // === Validamos datos
            if (!validarPreferencias()) {
                return;
            }
            if (!validarFechaHora()) {
                return;
            }

            // === EXTRAER datos validados
            Timestamp fechaHora = obtenerFechaHora();

            String preferencias = obtenerPreferencias();

            Cliente cli = (Cliente) jcclientes.getSelectedItem();

            if (cli == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente.");
                return;
            }

            List<Sesion> sesiones = diaactual.getSesion();

            if (sesiones.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe agregar una sesión.");
                return;
            }

            double monto = Double.parseDouble(jtmonto.getText());

            boolean estado = obtenerEstadoPago();

            // Crear objeto DiaDeSpa
            diaactual = new DiaDeSpa(fechaHora, preferencias, cli, sesiones,
                    monto, estado);

            DiadeSpaData diaData = new DiadeSpaData(); // tu conexión
            diaData.agregarDiadeSpa(diaactual);
            
            /*
            No conviene poner este mensaje ya que se puede mezclar con el mismo mensaje de DiaDeSpaData
            JOptionPane.showMessageDialog(this, "Día de Spa guardado correctamente.");
            */
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Monto inválid");
        }
    }//GEN-LAST:event_jbguardarActionPerformed

    private void jversesionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jversesionesActionPerformed

        if (tablasesiones == null || tablasesiones.isClosed()) {
            tablasesiones = new VistaTablaSesiones(diaactual.getSesion()
            );
            getDesktopPane().add(tablasesiones);
            tablasesiones.setVisible(true);
        } else {
            try {
                tablasesiones.setSelected(true);
                tablasesiones.actualizarTabla(); 
            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_jversesionesActionPerformed

    private void jagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jagregarActionPerformed

        // Si la ventana está cerrada o nunca se abrió → crearla
        if (ventanaSesion == null || ventanaSesion.isClosed()) {
            ventanaSesion = new GestionarSesion(getDesktopPane(), this); // pasar el objeto DiaDeSpa
            getDesktopPane().add(ventanaSesion);
            ventanaSesion.setVisible(true);
        } else {
            ventanaSesion.toFront(); // si ya está abierta, la traemos al frente
        }

    }//GEN-LAST:event_jagregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTotalActionPerformed
        // TODO add your handling code here:
        double total = obtenerTotal();
        
        jtmonto.setText(String.valueOf(total));
    }//GEN-LAST:event_jBTotalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBTotal;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCSesiones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jabonado;
    private javax.swing.JButton jagregar;
    private javax.swing.JButton jbguardar;
    private javax.swing.JComboBox<Cliente> jcclientes;
    private javax.swing.JSpinner jshora;
    private javax.swing.JTextField jtmonto;
    private javax.swing.JTextArea jtpreferencias;
    private javax.swing.JButton jversesiones;
    // End of variables declaration//GEN-END:variables

    // MÉTODO RECIBIR SESIÓN
    public double obtenerTotal() {
        double total = 0;

        for (Sesion sesi : diaactual.getSesion()) {
            total += sesi.getTotal();
        }
        return total;
    }

    public void recibirSesion(Sesion s) {
        sesion = null;
        sesion = s;

        jCSesiones.removeAllItems();

        diaactual.getSesion().add(sesion);

        for (Sesion se : diaactual.getSesion()) {
            Servicio servi = null;
            servi = servidata.buscarServicio(se.getTratamiento().getIdServicio());
            jCSesiones.addItem(servi.getNombre());
        }

    }

    private String obtenerPreferencias() {
        return jtpreferencias.getText().trim();
    }

    private void inicializaMonto() {
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));
        String montoFormateado = formato.format(0);
        jtmonto.setText(montoFormateado);
    }

    private double obtenerMonto() {
       /* String texto = jtmonto.getText()
                .replace("$", "") // quita el símbolo $
                .replace(".", "") // quita separadores de miles
                .replace(",", ".") // convierte coma decimal a punto
                .trim();

        if (texto.isEmpty()) {
            return 0;
        }  

        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Monto inválido.");
            return 0;
        }*/
       
    
    String texto = jtmonto.getText();

    if (texto == null) return 0;

    // SOLO permitir dígitos, coma y punto
    texto = texto.replaceAll("[^0-9,\\.]", "");

    // convertir formato latino a formato parseable
    texto = texto.replace(".", "");   // quita miles
    texto = texto.replace(",", ".");  // coma → punto

    if (texto.isEmpty()) {
        return 0;
    }

    try {
        return Double.parseDouble(texto);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Monto inválido: " + texto);
        return 0;
    }



    }

    private boolean obtenerEstadoPago() {
        return jabonado.isSelected();
    }

    private Timestamp obtenerFechaHora() {
        Date valor = (Date) jshora.getValue();

        LocalDateTime fechaHora = valor.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        return Timestamp.valueOf(fechaHora);

    }

    private void cargarClientes() {
        ClienteData clienteData = new ClienteData();
        List<Cliente> lista = clienteData.traerClientes();

        jcclientes.removeAllItems(); // Limpia el combo por las dudas

        for (Cliente c : lista) {
            if (c.getEstado()) {
                jcclientes.addItem(c);
            }

        }
    }

    private boolean validarFechaHora() {

        // Verifica que el spinner tenga un valor Date válido
        Object valor = jshora.getValue();

        if (valor == null || !(valor instanceof Date)) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar una fecha y hora válidas.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean validarPreferencias() {
        String texto = jtpreferencias.getText().trim();

        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El campo no puede estar vacío.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (texto.length() < 5) {
            JOptionPane.showMessageDialog(this,
                    "Las preferencias deben tener al menos 5 caracteres.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (texto.length() > 300) {
            JOptionPane.showMessageDialog(this,
                    "Las preferencias no pueden superar los 300 caracteres.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Solo letras, números, acentos y signos básicos
        if (!texto.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ,.()/-]*")) {
            JOptionPane.showMessageDialog(this,
                    "Las preferencias contienen caracteres inválidos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void actualizarTotal() {
        double total = diaactual.getTotal();

        // lo formateás como moneda
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));
        jtmonto.setText(formato.format(total));
    }

    public DiaDeSpa getDiaActual() {
        return diaactual;
    }
}
