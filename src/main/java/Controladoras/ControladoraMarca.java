/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public List<Marca> obtenerTodasLasMarcas() {
    return controlpersis.obtenerTodasLasMarcas();
}
         public List<Marca> filtrarMarcasPorModelo(String modelo) {
        return controlpersis.filtrarMarcasPorModelo(modelo);
    }

    public List<Marca> filtrarMarcasPorTipo(String tipo) {
        return controlpersis.filtrarMarcasPorTipo(tipo);
    }  
    public void guardarMarca(Marca marca) {
        controlpersis.guardarMarca(marca);
    }
     public boolean modeloExiste(String modelo) {
        // Llamamos al método de la controladora de persistencia para verificar si el modelo ya existe
        return controlpersis.modeloExiste(modelo);
    }
     public Marca obtenerMarcaPorModeloYTipo(String modelo, String tipo) {
        return controlpersis.obtenerMarcaPorModeloYTipo(modelo, tipo);
    }
}
