/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import java.util.List;
import logisticalogica.Cliente;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraCliente {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void crearcliente (Cliente cliente){
        controlpersis.crearcliente (cliente);
    }
    public List<Cliente> obtenerTodosLosClientes() {
    return controlpersis.obtenerTodosLosClientes();
}
    public List<Cliente> filtrarClientesPorNumeroDocumento(int documento) {
        return controlpersis.filtrarClientesPorNumeroDocumentoParcial(documento);
    }
     public List<Cliente> filtrarNombreyApellido(String nombreape) {
        return controlpersis.filtrarNombreyApellido(nombreape);
    }
    public void registrarCliente(String nombre, String apellido, String correo, String direccion, long nroDocumento, long nroTelefono) {
        // Crea un objeto Cliente con la información proporcionada
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCorreoElectronico(correo);
        cliente.setDireccion(direccion);
        cliente.setNro_documento(nroDocumento);
        cliente.setNro_telefono(nroTelefono);

        controlpersis.crearcliente(cliente);
    }
    public Cliente obtenerClientePorNombreCompleto(String nombreCompleto) {
    return controlpersis.obtenerClientePorNombreCompleto (nombreCompleto);
}
    public Cliente  obtenerClientePorID(int idCliente) {
    return controlpersis.obtenerClientePorID (idCliente);
    }

   public void darDeBajaCliente(Integer clienteID) {
        controlpersis.darDeBajaCliente(clienteID);
    }
   public List<Cliente> filtrarClientesPorEstado(String estado) {
       return controlpersis.filtrarClientesPorEstado(estado);
   }
}
