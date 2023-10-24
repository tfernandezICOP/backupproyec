/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import logisticalogica.Marca;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraMarca {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void crearmarca(Marca marca){
        controlpersis.crearmarca(marca);
        
    }
}
