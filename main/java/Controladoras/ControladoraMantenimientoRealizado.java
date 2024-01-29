/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import java.util.List;
import logisticalogica.MantenimientoRealizado;
import logisticalogica.Vehiculo;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraMantenimientoRealizado {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();

    public void guardarmantenimiento(MantenimientoRealizado mantenimientorealizado) {
        controlpersis.guardarMantenimientoRealizado(mantenimientorealizado);
    }

    public boolean tieneMantenimientoRealizado(Vehiculo vehiculo) {
        return controlpersis.tieneMantenimientoRealizado(vehiculo);
    }

    public void actualizarMantenimiento(MantenimientoRealizado mantenimiento) {
        controlpersis.actualizarMantenimientoRealizado(mantenimiento);
    }

    public List<MantenimientoRealizado> obtenerMantenimientoRealizado(Vehiculo vehiculo) {
        return controlpersis.obtenerMantenimientoRealizado(vehiculo);
    }

    public int obtenerKmRecorridosMasRecientes(Vehiculo vehiculo) {
        return controlpersis.obtenerKmRecorridosMasRecientes(vehiculo);
    }

    public MantenimientoRealizado obtenerUltimoMantenimientoRealizado(Vehiculo vehiculo) {
        return controlpersis.obtenerUltimoMantenimientoRealizado(vehiculo);
    }
}