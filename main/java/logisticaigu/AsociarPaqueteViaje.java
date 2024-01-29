/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraPaquete;
import Controladoras.ControladoraViaje;
import Controladoras.ControladoraViajePaquete;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import logisticalogica.Paquete;
import logisticalogica.Vehiculo;
import logisticalogica.Viaje;
import logisticalogica.ViajePaquete;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class AsociarPaqueteViaje extends javax.swing.JFrame {
  ControladoraPaquete ctrlPaquete = new ControladoraPaquete();
    private int idViaje;
        private Vehiculo vehiculoSeleccionado; // Add this line

     private DefaultListModel<String> listModel = new DefaultListModel<>();

    /**
     * Creates new form AsociarPaqueteViaje
     */
    public AsociarPaqueteViaje(int idViaje) {
        initComponents();
        this.idViaje = idViaje;
        this.vehiculoSeleccionado = vehiculoSeleccionado; // Add this line

        
        cargarListaPaquetes();

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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Paquetes");

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // Obtener los elementos seleccionados de la lista
    // Obtener las filas seleccionadas de la tabla
    int[] selectedRows = jTable1.getSelectedRows();

    // Hacer algo con las filas seleccionadas
    for (int selectedRow : selectedRows) {
        // Obtener el código de paquete de la fila seleccionada
        Integer codigoPaquete = (Integer) jTable1.getValueAt(selectedRow, 0);

        // Resto del código para asociar el paquete al viaje
        ViajePaquete viajePaquete = new ViajePaquete();

        ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
        Paquete paquete = controladoraPersistencia.obtenerPaquetePorCodigo(codigoPaquete);

        ControladoraViaje controladoraViaje = new ControladoraViaje();
        Viaje viaje = controladoraViaje.obtenerViajePorId(idViaje);

        // Guardar la asociación en la base de datos
        viajePaquete.setPaquete(paquete);
        viajePaquete.setViaje(viaje);
        ControladoraViajePaquete ctrlViajePaquete = new ControladoraViajePaquete();
        ctrlViajePaquete.crearviajepaquete(viajePaquete);

        // Eliminar la fila asociada al paquete de la JTable
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(selectedRow);
    }

    // Preguntar si desea seguir asociando paquetes
    int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Desea seguir asociando paquetes a este vehículo?",
            "Confirmar",
            JOptionPane.YES_NO_OPTION
    );

    if (confirmacion == JOptionPane.NO_OPTION) {
        // Si elige NO, ir a la pantalla ViajeIGU
        new ViajeIGU().setVisible(true);
        dispose();
    } else {
        // Si elige YES, cargar nuevamente la lista de paquetes y actualizar la JTable
        cargarListaPaquetes();
        // Actualizar la JTable con la nueva lista de paquetes
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.fireTableDataChanged();
        // Puedes agregar lógica adicional aquí si es necesario
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     ViajeIGU atras = new ViajeIGU();
     atras.setVisible(true);
     dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
     private void cargarListaPaquetes() {
    // Obtener todos los paquetes en estado "Pendiente"
    List<Paquete> paquetesPendientes = ctrlPaquete.filtrarPaquetesPorEstado("PENDIENTE");

    // Obtener todos los paquetes en estado "Devuelto"
    List<Paquete> paquetesDevueltos = ctrlPaquete.filtrarPaquetesPorEstado("Devuelto");

    // Fusionar ambas listas
    paquetesPendientes.addAll(paquetesDevueltos);

    // Crear un modelo de tabla personalizado
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Código Paquete");
    modelo.addColumn("Descripción");
    modelo.addColumn("Estado");
    modelo.addColumn("Domicilio de Entrega");
    modelo.addColumn("Fecha Recibido");

    // Limpiar el modelo de la tabla
    jTable1.setModel(modelo);

    // Agregar los paquetes al modelo de la tabla
    for (Paquete paquete : paquetesPendientes) {
        // Asumo que los campos son objetos, ajusta según tu implementación
        Object[] fila = new Object[]{
            paquete.getCodigo_paquete(),
            paquete.getDescripcion(),
            paquete.getEstado(),
            paquete.getDomicilioEntrega(),
            paquete.getFechaRecibido() // Asumo que tienes un método getFechaRecibido(), ajusta según tu implementación
        };

        modelo.addRow(fila);
    }
}
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
