/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import java.util.List;
import logisticalogica.ParteDiario;
import logisticalogica.Vehiculo;
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
    public void guardarpartediario(ParteDiario partediario){
        controlpersis.guardarParteDiario(partediario);
    }
     public ParteDiario obtenerParteDiarioExistente(Vehiculo vehiculo) {
        return controlpersis.obtenerParteDiarioExistente(vehiculo);
    }
     public int obtenerTotalKmVehiculo(Vehiculo vehiculo) {
        return controlpersis.obtenerTotalKmVehiculo(vehiculo);
    }
public void actualizarParteDiario(ParteDiario parteDiario) {
    controlpersis.actualizarParteDiario(parteDiario);
}
    
public List<ParteDiario> obtenerParteDiarioPorVehiculo(Vehiculo vehiculo) {
    return controlpersis.obtenerParteDiarioPorVehiculo(vehiculo);
            
}
     
}
