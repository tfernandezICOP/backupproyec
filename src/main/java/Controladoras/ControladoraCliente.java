/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

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
}
