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
    @Table(name = "ViajePaquete")
    public class ViajePaquete implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "viajePaqueteID")
    private Integer viajePaqueteID;

    @ManyToOne
    @JoinColumn(name = "paqueteID")
    private Paquete paquete;

    @ManyToOne
    @JoinColumn(name = "viajeID")
    private Viaje viaje;

    public ViajePaquete() {
    }

    public ViajePaquete(Integer viajePaqueteID, Paquete paquete, Viaje viaje) {
        this.viajePaqueteID = viajePaqueteID;
        this.paquete = paquete;
        this.viaje = viaje;
    }

    public Integer getViajePaqueteID() {
        return viajePaqueteID;
    }

    public void setViajePaqueteID(Integer viajePaqueteID) {
        this.viajePaqueteID = viajePaqueteID;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    
}
