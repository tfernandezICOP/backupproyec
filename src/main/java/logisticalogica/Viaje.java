/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logisticalogica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Viaje")
public class Viaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "viajeID")
    private Integer viajeID;

    @Column(name = "destino")
    private String destino;
    
    @Temporal(TemporalType.DATE)     
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "origen")
    private String origen;

    @ManyToOne
    @JoinColumn(name = "vehiculoID")
    private Vehiculo vehiculo;

    public Viaje() {
    }

    public Viaje(Integer viajeID, String destino, Date fecha, String origen, Vehiculo vehiculo) {
        this.viajeID = viajeID;
        this.destino = destino;
        this.fecha = fecha;
        this.origen = origen;
        this.vehiculo = vehiculo;
    }

    public Integer getViajeID() {
        return viajeID;
    }

    public void setViajeID(Integer viajeID) {
        this.viajeID = viajeID;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
}
