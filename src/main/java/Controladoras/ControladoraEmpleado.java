/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import logisticalogica.Empleado;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraEmpleado {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void crearempleado (Empleado empleado){
        controlpersis.crearempleado (empleado);
    }
}
