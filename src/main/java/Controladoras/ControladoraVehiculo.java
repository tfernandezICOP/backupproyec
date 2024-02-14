/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import java.util.List;
import logisticalogica.Paquete;
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
    public List<Vehiculo> obtenerTodosLosVehiculos() {
    return controlpersis.obtenerTodosLosVehiculos();
}

    
    public List<Vehiculo> filtrarVehiculosPorPatente(String patente) {
        return controlpersis.filtrarVehiculosPorPatente(patente);
    }

    public List<Vehiculo> filtrarVehiculosPorModeloCoincidente(String modelo) {
        return controlpersis.filtrarVehiculosPorModeloCoincidente(modelo);
    }
    public List<Paquete> obtenerPaquetesPorVehiculo(Vehiculo vehiculo) {
        return controlpersis.obtenerPaquetesPorVehiculo(vehiculo);
    }
    public Vehiculo obtenerVehiculoPorID(int vehiculoID) {
        return controlpersis.obtenerVehiculoPorId(vehiculoID);
    }
    public Vehiculo guardarvehiculo(Vehiculo vehiculo){
        return controlpersis.guardarvehiculo(vehiculo);
    
    }
    public List<Vehiculo> obtenerVehiculosConMantenimiento() {
    return controlpersis.obtenerVehiculosConMantenimiento();
    }
    public void darDeBajaVehiculo(Integer vehiculoID) {
    controlpersis.darDeBajaVehiculo(vehiculoID);
    }
   public List<Vehiculo> obtenerVehiculosActivos() {
  return controlpersis.obtenerVehiculosActivos();
   }
    
}
