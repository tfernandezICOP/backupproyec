/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import java.util.List;
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
    public List<Paquete> obtenerTodosLosPaquetes() {
    return controlpersis.obtenerTodosLosPaquetes();
    }
        public List<Paquete> filtrarPaquetesPorCodigo(int codigo) {
        return controlpersis.obtenerPaquetesPorCodigo(codigo);
    }

    public void actualizarEstadoPaquete(Paquete paquete) {
        controlpersis.actualizarEstadoPaquete(paquete);
    }
    
        
}

