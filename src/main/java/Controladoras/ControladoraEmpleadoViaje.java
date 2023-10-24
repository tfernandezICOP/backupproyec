/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import logisticalogica.EmpleadoViaje;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraEmpleadoViaje {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void crearempleadoviaje (EmpleadoViaje empleadoviaje){
        controlpersis.crearempleadoviaje(empleadoviaje);
    }
}
