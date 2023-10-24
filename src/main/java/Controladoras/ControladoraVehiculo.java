/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import logisticalogica.Vehiculo;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraVehiculo {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void crearvehiculo (Vehiculo vehiculo){
        controlpersis.crearvehiculo(vehiculo);
    }
}
