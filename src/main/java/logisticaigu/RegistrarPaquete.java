/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraPaquete;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import logisticalogica.Cliente;
import logisticalogica.Paquete;

/**
 *
 * @author ULTRA
 */
public class RegistrarPaquete extends javax.swing.JFrame {
    private ControladoraPaquete controladoraPaquete;
    private Paquete paquete;
   
    private Paquete paqueteTemporal; // Agregar una variable para almacenar el paqueteTemporal

    /**
     * Creates new form RegistrarEnvio
     */
    public RegistrarPaquete() {
        initComponents();
        controladoraPaquete = new ControladoraPaquete();

    }
    public void setPaqueteTemporal(Paquete paqueteTemporal) {
        this.paqueteTemporal = paqueteTemporal;
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Registroenvio = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Registroenvio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Registroenvio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Registroenvio.setText("Registrar Envio");

        jLabel1.setText("Domicilio:");

        jLabel2.setText("Descripcion");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Registroenvio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 116, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Registroenvio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Menu atras = new Menu();
        atras.setVisible(true);
        dispose(); // Cierra la pantalla actual
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   String domicilio = jTextField1.getText();
    String descripcion = jTextField2.getText();

    paqueteTemporal = inicializarPaquete(domicilio, descripcion);

    // Añade mensajes de depuración
    System.out.println("PaqueteTemporal en RegistrarEnvio:");
    mostrarInfoPaqueteTemporal(paqueteTemporal);

    // Crea la instancia de BuscarClientes
    BuscarClientes busqueda = new BuscarClientes(paqueteTemporal);
    busqueda.setPaqueteTemporal(paqueteTemporal); // Establece el paqueteTemporal
    busqueda.setVisible(true);
    this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void mostrarInfoPaqueteTemporal(Paquete paqueteTemporal) {
    if (paqueteTemporal != null) {
        System.out.println("Código de paquete: " + paqueteTemporal.getCodigo_paquete());
        System.out.println("Domicilio de entrega: " + paqueteTemporal.getDomicilioEntrega());
        // Mostrar otros atributos según sea necesario
    } else {
        System.out.println("paqueteTemporal es nulo.");
    }
}/*
     * @param args the command line arguments
     */
public Paquete inicializarPaquete(String domicilio, String descripcion) {
    Paquete paquete = new Paquete();
    paquete.setDomicilioEntrega(domicilio);
    paquete.setDescripcion(descripcion);

    // Generar código único basado en 10 dígitos aleatorios
    StringBuilder codigoPaqueteStr = new StringBuilder();
    for (int i = 0; i < 10; i++) {
        int digitoAleatorio = (int) (Math.random() * 10);
        codigoPaqueteStr.append(digitoAleatorio);
    }

    // Convertir la cadena resultante a un número Long
    long codigoPaquete = Long.parseLong(codigoPaqueteStr.toString());

    // Asegurar que el código generado no exceda el rango de un int
    codigoPaquete = codigoPaquete % Integer.MAX_VALUE;

    // Convertir el código a un número entero
    int codigoPaqueteInt = (int) codigoPaquete;
    paquete.setCodigo_paquete(codigoPaqueteInt);

    return paquete;
}


   
    public Paquete obtenerPaqueteTemporal() {
    return paqueteTemporal;
}
     public void mostrarVentana() {
        // Código para mostrar la ventana de registro de envío
        // Ajusta según tu implementación
        this.setVisible(true);  // Ajusta según cómo se muestra la ventana en tu aplicación
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Registroenvio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
