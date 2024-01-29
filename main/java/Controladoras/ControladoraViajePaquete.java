/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import logisticalogica.ViajePaquete;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraViajePaquete {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void crearviajepaquete (ViajePaquete viajepaquete){
        controlpersis.crearviajepaquete(viajepaquete);
    }
    
}
