/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logisticapersistencia;

import logisticalogica.Cliente;
import logisticalogica.DetalleMantenimiento;
import logisticalogica.Empleado;
import logisticalogica.EmpleadoViaje;
import logisticalogica.Mantenimiento;
import logisticalogica.Marca;
import logisticalogica.Paquete;
import logisticalogica.ParteDiario;
import logisticalogica.Vehiculo;
import logisticalogica.Viaje;
import logisticalogica.ViajePaquete;

/**
 *
 * @author ULTRA
 */
public class ControladoraPersistencia {
    ClienteJpaController clienteJPA = new ClienteJpaController();
    DetalleMantenimientoJpaController detallemanteJPA = new DetalleMantenimientoJpaController();
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    EmpleadoViajeJpaController empleviajeJPA = new EmpleadoViajeJpaController();
    MantenimientoJpaController manteJPA = new MantenimientoJpaController();
    MarcaJpaController marcaJPA = new MarcaJpaController();
    PaqueteJpaController paqueteJPA = new PaqueteJpaController();
    ParteDiarioJpaController partediarioJPA = new ParteDiarioJpaController();
    VehiculoJpaController vehiculoJPA = new VehiculoJpaController();
    ViajeJpaController viajeJPA = new ViajeJpaController();
    ViajePaqueteJpaController viajepaqueteJPA = new ViajePaqueteJpaController();

    public void crearcliente(Cliente cliente) {
        clienteJPA.create(cliente);
    }
    public void crearempleado (Empleado empleado){
        empleadoJPA.create(empleado);
     }

    public void crearmarca(Marca marca) {
        marcaJPA.create(marca);
    }

    public void crearvehiculo(Vehiculo vehiculo) {
        vehiculoJPA.create(vehiculo);
    }

    public void crearmantenimiento(Mantenimiento mantenimiento) {
        manteJPA.create(mantenimiento);
    }

    public void creardetallemante(DetalleMantenimiento detallemante) {
        detallemanteJPA.create(detallemante);
    }

    public void crearviaje(Viaje viaje) {
        viajeJPA.create(viaje);
    }

    public void crearpaquete(Paquete paquete) {
        paqueteJPA.create(paquete);
    }

    public void crearempleadoviaje(EmpleadoViaje empleadoviaje) {
        empleviajeJPA.create(empleadoviaje);
    }

    public void crearpartediario(ParteDiario partediario) {
        partediarioJPA.create(partediario);
    }

    public void crearviajepaquete(ViajePaquete viajepaquete) {
        viajepaqueteJPA.create(viajepaquete);
    }
}
