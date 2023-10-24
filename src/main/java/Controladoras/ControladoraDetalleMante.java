/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import logisticalogica.DetalleMantenimiento;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraDetalleMante {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void creardetallemante(DetalleMantenimiento detallemante){
        controlpersis.creardetallemante(detallemante);
    }
    
}
