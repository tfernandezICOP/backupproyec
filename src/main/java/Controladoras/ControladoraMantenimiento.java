/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logisticalogica.Mantenimiento;
import logisticalogica.Vehiculo;
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
   public void guardarmantenimiento (Mantenimiento mantenimiento){
       controlpersis.guardarMantenimiento(mantenimiento);
   }
  public List<Mantenimiento> obtenerTodosLosMantenimientos() {
    return controlpersis.obtenerTodosLosMantenimientos();
}
  public void actualizarMantenimiento(Mantenimiento mantenimientoActualizado, int nuevoskm) {
   controlpersis.actualizarMantenimiento(mantenimientoActualizado, nuevoskm);
  }
  
  public Mantenimiento obtenerMantenimientoExistente(Vehiculo vehiculo) {
      return controlpersis.obtenerMantenimientoExistente(vehiculo);
  }
}
