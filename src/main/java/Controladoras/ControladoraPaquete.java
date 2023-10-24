/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import logisticalogica.Paquete;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraPaquete {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void crearpaquete (Paquete paquete){
        controlpersis.crearpaquete(paquete);
    }
}
