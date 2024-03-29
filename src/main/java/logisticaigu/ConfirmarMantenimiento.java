/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraMantenimiento;
import Controladoras.ControladoraMantenimientoRealizado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import logisticalogica.MantenimientoRealizado;
import logisticalogica.Vehiculo;
/**
 *
 * @author ULTRA
 */
public class ConfirmarMantenimiento extends javax.swing.JFrame {

    Vehiculo vehiculoSeleccionado; // Deja de inicializarlo aquí
        private Vehiculo vehiculo;
    private ControladoraMantenimientoRealizado controladoraMantenimientoRealizado = new ControladoraMantenimientoRealizado();
    private MantenimientoRealizado mantenimientoExistente; // Agrega esta línea
    private boolean tieneMantenimientoRealizado; // Agrega esta línea
    public ConfirmarMantenimiento(Vehiculo vehiculo)  {
        this.vehiculo = vehiculo;

        initComponents();
        inicializarVentana(); // Llama a la inicialización después de haber asignado el vehículo
        establecerFormatoFecha();

    }
  private void establecerFormatoFecha() {
    try {
        MaskFormatter mask = new MaskFormatter("##/##/####");
        mask.setPlaceholderCharacter(' '); // Usa un espacio en blanco como carácter de relleno

        // Establece el formato en el campo existente jFormattedTextField1
        jFormattedTextField1.setFormatterFactory(new DefaultFormatterFactory(mask));
        jFormattedTextField1.setColumns(10); // Puedes ajustar el número de columnas según tus necesidades
        jFormattedTextField1.setFocusLostBehavior(JFormattedTextField.COMMIT); // Asegura que la entrada se confirme al perder el foco

    } catch (ParseException ex) {
        ex.printStackTrace();
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Marca = new javax.swing.JLabel();
        Patente = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Confirmar Mantenimiento");

        jLabel2.setText("Fecha:");

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Marca.setText("Marca");

        Patente.setText("Patente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField1))
                    .addComponent(Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(Patente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Marca)
                    .addComponent(Patente))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private ControladoraMantenimiento controladoraMantenimiento = new ControladoraMantenimiento();

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    guardarDatosMantenimientoRealizado() ;
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       AvisosMantenimiento avisomante =  new AvisosMantenimiento();
       avisomante.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
  

    /**
     * @param args the command line arguments
     */
   void inicializarVentana() {
    if (vehiculo != null) {
        String patente = vehiculo.getPatente();
        String marca = vehiculo.getMarca().getModelo();

        // Actualizar las etiquetas con la información del vehículo
        Marca.setText("Marca: " + marca);
        Patente.setText("Patente: " + patente);
    }
}
private void guardarDatosMantenimientoRealizado() {
    try {
        // Obtener el último kilómetro recorrido del vehículo
        int ultimoKmRecorrido = controladoraMantenimientoRealizado.obtenerKmRecorridosMasRecientes(vehiculo);

        // Obtener la fecha ingresada por el usuario
        String fechaStr = jFormattedTextField1.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = sdf.parse(fechaStr);

        // Crear un nuevo mantenimiento
        MantenimientoRealizado nuevoMantenimiento = new MantenimientoRealizado();
        nuevoMantenimiento.setFechaMantenimiento(fecha);
        nuevoMantenimiento.setVehiculo(vehiculo);
        
        // Establecer el último kilómetro recorrido
        nuevoMantenimiento.setKmMantenimiento(ultimoKmRecorrido);

        // Guardar el nuevo mantenimiento realizado
        controladoraMantenimientoRealizado.guardarmantenimiento(nuevoMantenimiento);

        // Crear una instancia de TipoMantenimiento y pasar el MantenimientoRealizado
        TipoMantenimiento tipoMantenimientoFrame = new TipoMantenimiento(nuevoMantenimiento);

        // Hacer visible la ventana de TipoMantenimiento
        tipoMantenimientoFrame.setVisible(true);

        // Mostrar un mensaje de éxito
        JOptionPane.showMessageDialog(this, "Mantenimiento realizado guardado exitosamente");

        // Cerrar la ventana actual después de abrir la nueva ventana
        this.dispose();
    } catch (ParseException ex) {
        ex.printStackTrace();
        // Mostrar un mensaje de error si hay un problema con la fecha
        JOptionPane.showMessageDialog(this, "Error al procesar la fecha", "Error", JOptionPane.ERROR_MESSAGE);
    }
}








   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Marca;
    private javax.swing.JLabel Patente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

   
}
