/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import logisticalogica.Mantenimiento;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraMantenimiento {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void crearmantenimiento (Mantenimiento mantenimiento) {
        controlpersis.crearmantenimiento (mantenimiento);
        
    }
}
