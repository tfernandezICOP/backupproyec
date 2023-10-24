/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import logisticalogica.ParteDiario;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraParteDiario {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void crearpartediario(ParteDiario partediario){
        controlpersis.crearpartediario(partediario);
    }
}
