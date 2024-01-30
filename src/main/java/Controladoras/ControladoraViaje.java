/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import logisticalogica.Vehiculo;
import logisticalogica.Viaje;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraViaje {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void crearviaje (Viaje viaje){
        controlpersis.crearviaje(viaje);
    }
    public void guardarViaje(Viaje viaje) {
        controlpersis.guardarViaje(viaje);
    }
    public Viaje obtenerViajePorId(int viajeID) {
        return controlpersis.obtenerViajePorId(viajeID);
    }

}
