/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import java.util.List;
import logisticalogica.DetalleMantenimiento;
import logisticalogica.Mantenimiento;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraDetalleMante {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void guardarTipoMantenimiento(DetalleMantenimiento tipoMantenimiento, int idMantenimiento) {
       
        controlpersis.guardarTipoMantenimiento(tipoMantenimiento);
    }
    
    public List<DetalleMantenimiento> obtenerDetallesMantenimiento() {
       return controlpersis.obtenerDetallesMantenimiento();
    }
    
}
