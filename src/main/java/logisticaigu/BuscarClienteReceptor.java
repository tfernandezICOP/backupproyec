/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraCliente;
import Controladoras.ControladoraPaquete;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import logisticalogica.Cliente;
import logisticalogica.Paquete;


/**
 *
 * @author ULTRA
 */
public class BuscarClienteReceptor extends javax.swing.JFrame {
     private ControladoraCliente controladoraCliente;
    private DefaultTableModel tableModel;
    private Paquete paquete; 
    private Paquete paqueteTemporal; // Asegúrate de tener este atributo en tu clase
    private ControladoraPaquete controladoraPaquete;
    private int idClienteEmisorSeleccionado; // Nuevo atributo
    private RegistrarPaquete registrarEnvio;
    

    /**
     * Creates new form BuscarClienteReceptor
     */
    public BuscarClienteReceptor(Paquete paqueteTemporal) {

    initComponents();
     this.paqueteTemporal = paqueteTemporal;

    tableModel = (DefaultTableModel) jTable1.getModel();
    controladoraCliente = new ControladoraCliente();
    cargarClientesEnTabla();
    inicializarVentana();
    botonAceptar.setEnabled(false);
    registrarEnvio = new RegistrarPaquete(); // Esto es un ejemplo, ajusta según tu implementación
    paquete = new Paquete();
    
    // Inicializar campos del paquete
    paquete.setEstado("PENDIENTE");
    paquete.setFechaRecibido(new java.sql.Date(System.currentTimeMillis())); // Utiliza la fecha actual
    paquete.setFechaEntrega(null); // Establecer la fecha de entrega como null inicialmente
}
    private void mostrarInfoPaqueteTemporal(Paquete paqueteTemporal) {
        if (paqueteTemporal != null) {
            System.out.println("Datos de paqueteTemporal:");
            System.out.println("Código de paquete: " + paqueteTemporal.getCodigo_paquete());
            System.out.println("Domicilio de entrega: " + paqueteTemporal.getDomicilioEntrega());
            // Mostrar otros atributos según sea necesario
        } else {
            System.out.println("paqueteTemporal es nulo.");
        }
    }
     public void setPaqueteTemporal(Paquete paqueteTemporal) {
    this.paqueteTemporal = paqueteTemporal;
    if (paqueteTemporal != null) {
        Codpaquete.setText("Cod paquete: " + String.valueOf(paqueteTemporal.getCodigo_paquete()));
    } else {
        Codpaquete.setText("Paquete temporal es nulo");
    }
}


    public void setIdClienteEmisorSeleccionado(int idClienteEmisorSeleccionado) {
        this.idClienteEmisorSeleccionado = idClienteEmisorSeleccionado;
    }
      private void cargarClientesEnTabla() {
        // Limpiar la tabla antes de cargar nuevos datos
        tableModel.setRowCount(0);

        List<Cliente> clientes = controladoraCliente.obtenerTodosLosClientes();

        for (Cliente cliente : clientes) {
            String nombreCompleto = cliente.getNombre() + " " + cliente.getApellido();

            Object[] rowData = {
                    nombreCompleto,
                    cliente.getNro_documento(),
                    cliente.getNro_telefono()
            };
            tableModel.addRow(rowData);
        }
    }

    private void inicializarVentana() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow >= 0) {
                        // Habilitar el botón "Aceptar" cuando se selecciona una fila en la tabla
                        botonAceptar.setEnabled(true);
                    } else {
                        // Deshabilitar el botón "Aceptar" si no hay fila seleccionada
                        botonAceptar.setEnabled(false);
                    }
                }
            }
        });
        ingresardocumento.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            filtrarClientes();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            filtrarClientes();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            filtrarClientes();
        }
    });
    jTextField1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarClientespornombreyape();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarClientespornombreyape();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarClientespornombreyape();
            }
        });
    
    }

    private Cliente obtenerClienteDesdeFilaSeleccionada(int filaSeleccionada) {
        List<Cliente> clientes = controladoraCliente.obtenerTodosLosClientes();
        if (filaSeleccionada >= 0 && filaSeleccionada < clientes.size()) {
            return clientes.get(filaSeleccionada);
        } else {
            return null;
        }
    }
      private void filtrarClientes() {
    String numeroDocumentoStr = ingresardocumento.getText().trim();

    if (numeroDocumentoStr.isEmpty()) {
        cargarClientesEnTabla(); // Si el campo de búsqueda está vacío, muestra todos los clientes
    } else {
        try {
            int numeroDocumento = Integer.parseInt(numeroDocumentoStr);

            // Realizar la búsqueda de clientes según los valores ingresados
            List<Cliente> clientes = controladoraCliente.filtrarClientesPorNumeroDocumento(numeroDocumento);

            // Limpiar la tabla antes de cargar nuevos datos
            tableModel.setRowCount(0);

            for (Cliente cliente : clientes) {
                String nombreCompleto = cliente.getNombre() + " " + cliente.getApellido();

                Object[] rowData = {
                    nombreCompleto,
                    cliente.getNro_documento(),
                    cliente.getNro_telefono()
                };
                tableModel.addRow(rowData);
            }
        } catch (NumberFormatException e) {
            // Manejo de error si el texto no es un número válido
            JOptionPane.showMessageDialog(null, "Ingrese un número válido para el documento.");
        }
    }
}


        
       private void filtrarClientespornombreyape() {
    String nombre = jTextField1.getText().trim(); // Obtener el nombre desde el campo correspondiente
    String apellido = ingresardocumento.getText().trim(); // Obtener el apellido desde el campo de número de documento

    if (nombre.isEmpty() && apellido.isEmpty()) {
        cargarClientesEnTabla(); // Si ambos campos están vacíos, muestra todos los clientes
    } else {
        // Realizar la búsqueda de clientes según los valores ingresados
        List<Cliente> clientes = controladoraCliente.filtrarNombreyApellido(nombre + " " + apellido);

        // Limpiar la tabla antes de cargar nuevos datos
        tableModel.setRowCount(0);

        for (Cliente cliente : clientes) {
            String nombreCompleto = cliente.getNombre() + " " + cliente.getApellido();

            Object[] rowData = {
                nombreCompleto,
                cliente.getNro_documento(),
                cliente.getNro_telefono()
            };
            tableModel.addRow(rowData);
        }
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
         
    // En el método seleccionarClienteReceptor()
// En el método seleccionarClienteReceptor()
// En el método seleccionarClienteReceptor()
public void seleccionarClienteReceptor() {
    if (paqueteTemporal != null) {
        // Obtén la fila seleccionada en la tabla
        int filaSeleccionada = jTable1.getSelectedRow();

        // Asegúrate de que haya una fila seleccionada
        if (filaSeleccionada >= 0) {
            // Obtén el cliente desde la fila seleccionada
            Cliente clienteSeleccionado = obtenerClienteDesdeFilaSeleccionada(filaSeleccionada);

            // Asegúrate de que el cliente seleccionado no sea nulo
            if (clienteSeleccionado != null) {
                // Mostrar confirmación antes de establecer el cliente receptor
                int confirmacion = JOptionPane.showConfirmDialog(this,
                        "¿Deseas seleccionar al siguiente cliente como receptor?\n\n" +
                        "Nombre: " + clienteSeleccionado.getNombre() + "\n" +
                        "Apellido: " + clienteSeleccionado.getApellido(),
                        "Confirmar selección", JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    // El usuario confirmó la selección, establecer el cliente receptor en el paqueteTemporal
                    paqueteTemporal.setReceptor(clienteSeleccionado);

                    // Añade mensajes de depuración
                    System.out.println("PaqueteTemporal en BuscarClienteReceptor:");
                    mostrarInfoPaqueteTemporal(paqueteTemporal);

                    // Actualizar estado y fecha de recibido
                    paqueteTemporal.setEstado("PENDIENTE");
                    paqueteTemporal.setFechaRecibido(new java.sql.Date(System.currentTimeMillis()));

                    // Llamar al método para persistir el paquete en la base de datos
                    persistirPaqueteEnBD();

                    // Mostrar el ID del Cliente Receptor en la consola (puedes cambiarlo según tus necesidades)
                    mostrarCuadroDialogoIDClienteReceptor(clienteSeleccionado.getClienteID());
                } else {
                    // El usuario optó por no confirmar la selección
                    System.out.println("Selección del cliente cancelada.");
                    return; // Puedes agregar más lógica aquí según tus necesidades
                }
            } else {
                // Si el cliente seleccionado es nulo, simplemente no hacemos nada aquí.
            }
        } else {
            System.out.println("Por favor, selecciona un cliente.");
        }
    } else {
        System.out.println("El paquete es nulo. Verifica su inicialización.");
    }
}







private void persistirPaqueteEnBD() {
    if (paqueteTemporal != null) {
        System.out.println("Código de paquete: " + paqueteTemporal.getCodigo_paquete());

        // Resto del código para persistir el paquete en la base de datos
        try {
            // Actualizar estado y fecha de recibido antes de persistir
            paqueteTemporal.setEstado("PENDIENTE");
            paqueteTemporal.setFechaRecibido(new java.sql.Date(System.currentTimeMillis()));

            // Ejemplo: Guardar el paquete en la base de datos utilizando la controladora del paquete
            ControladoraPaquete controladoraPaquete = new ControladoraPaquete();
            controladoraPaquete.guardarPaquete(paqueteTemporal);

            System.out.println("Paquete persistido en la base de datos correctamente.");
        } catch (Exception e) {
            // Manejo de excepciones en caso de error al persistir el paquete
            System.out.println("Error al persistir el paquete en la base de datos: " + e.getMessage());
            e.printStackTrace();
            // Puedes agregar más acciones según tus necesidades, como mostrar un mensaje de error al usuario.
        }

    } else {
        System.out.println("paqueteTemporal es nulo.");
        // Manejo de la situación cuando paqueteTemporal es nulo
        // Puedes agregar mensajes de error, lanzar excepciones u otras acciones según tus necesidades
    }
}









private void mostrarCuadroDialogoIDClienteReceptor(int idClienteReceptor) {
    JOptionPane.showMessageDialog(null, "ID del Cliente Receptor: " + idClienteReceptor);
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        numerodocclienteemisor = new javax.swing.JLabel();
        ingresardocumento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Codpaquete = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre y Apellido", "N° documento", "N° Telefono"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        numerodocclienteemisor.setText("Numero documento:");

        ingresardocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresardocumentoActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre y Apellido");

        Codpaquete.setText("Cod paquete:");

        jButton3.setText("Registrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Buscar Cliente receptor");

        jLabel1.setText("id emisor: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 478, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(numerodocclienteemisor)
                .addGap(18, 18, 18)
                .addComponent(ingresardocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Codpaquete)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ingresardocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numerodocclienteemisor)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Codpaquete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(botonAceptar)
                    .addComponent(jButton1))
                .addContainerGap())
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

    private void ingresardocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresardocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresardocumentoActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
      seleccionarClienteReceptor();
    System.out.println("ID del Cliente Emisor en BuscarClienteReceptor: " + idClienteEmisorSeleccionado);
    
    int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres seguir registrando paquetes?", "Confirmar", JOptionPane.YES_NO_OPTION);

    // Verificar la opción seleccionada
    if (opcion == JOptionPane.YES_OPTION) {
        // Si el usuario elige "Sí", cerrar la ventana actual
        dispose();

        // Abrir la pantalla para registrar un nuevo envío
        registrarEnvio.mostrarVentana();
    } else {
        // Si el usuario elige "No", salir del programa
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }
    

    }//GEN-LAST:event_botonAceptarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuscarClientes buscarclientes = new BuscarClientes(paqueteTemporal);
    buscarclientes.setPaqueteTemporal(paqueteTemporal); // Restaura el paqueteTemporal en la nueva ventana
    buscarclientes.mostrarVentana(); // Muestra la ventana RegistrarPaquete
    this.dispose(); // Cierra la ventana actual (BuscarClientes)
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    RegistrarClienteRecep registrarclienterecep = new RegistrarClienteRecep(paqueteTemporal);
        registrarclienterecep.setVisible(true);
        this.dispose();


        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    // ... (otros métodos de la clase)

   


public void actualizarIDClienteEmisor(int idClienteEmisor) {
    jLabel1.setText("ID del Cliente Emisor: " + idClienteEmisor);
}
private void asignarClientesAlPaquete(Cliente clienteEmisor, Cliente clienteReceptor) {
    paquete.setEmisor(clienteEmisor);
    paquete.setReceptor(clienteReceptor);
}
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Codpaquete;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JTextField ingresardocumento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel numerodocclienteemisor;
    // End of variables declaration//GEN-END:variables
}
