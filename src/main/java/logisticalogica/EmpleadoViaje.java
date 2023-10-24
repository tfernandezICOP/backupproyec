/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logisticalogica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

    @Entity
    @Table(name = "EmpleadoViaje")
    public class EmpleadoViaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empleadoViajeID")
    private Integer empleadoViajeID;

    @ManyToOne
    @JoinColumn(name = "viajeID")
    private Viaje viaje;

    @ManyToOne
    @JoinColumn(name = "empleadoID")
    private Empleado empleado;    

    public EmpleadoViaje() {
    }

    public EmpleadoViaje(Integer empleadoViajeID, Viaje viaje, Empleado empleado) {
        this.empleadoViajeID = empleadoViajeID;
        this.viaje = viaje;
        this.empleado = empleado;
    }

    public Integer getEmpleadoViajeID() {
        return empleadoViajeID;
    }

    public void setEmpleadoViajeID(Integer empleadoViajeID) {
        this.empleadoViajeID = empleadoViajeID;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
}
