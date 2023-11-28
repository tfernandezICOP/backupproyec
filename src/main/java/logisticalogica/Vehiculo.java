/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logisticalogica;
import logisticalogica.Mantenimiento;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

    @Entity
    @Table(name = "Vehiculo")
    public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehiculoID")
    private Integer vehiculoID;

    @Column(name = "capacidad_carga")
    private Integer capacidad_carga;

    @Column(name = "nro_vehiculo")
    private Integer nro_vehiculo;

    @Column(name = "patente")
    private String patente; // Cambio de Integer a String

    @ManyToOne
    @JoinColumn(name = "marcaID")
    private Marca marca;
    
    @OneToOne(mappedBy = "vehiculo")
    private Mantenimiento mantenimiento;
    public Vehiculo() {
    }

    public Vehiculo(Integer vehiculoID, Integer capacidad_carga, Integer nro_vehiculo, String patente, Marca marca) {
        this.vehiculoID = vehiculoID;
        this.capacidad_carga = capacidad_carga;
        this.nro_vehiculo = nro_vehiculo;
        this.patente = patente; // Cambio de tipo en el constructor
        this.marca = marca;
    }

    public Integer getVehiculoID() {
        return vehiculoID;
    }

    public void setVehiculoID(Integer vehiculoID) {
        this.vehiculoID = vehiculoID;
    }

    public Integer getCapacidad_carga() {
        return capacidad_carga;
    }

    public void setCapacidad_carga(Integer capacidad_carga) {
        this.capacidad_carga = capacidad_carga;
    }

    public Integer getNro_vehiculo() {
        return nro_vehiculo;
    }

    public void setNro_vehiculo(Integer nro_vehiculo) {
        this.nro_vehiculo = nro_vehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
    
    
    public Mantenimiento obtenerMantenimiento() {
        return this.mantenimiento;
    }

    public void actualizarMantenimiento(Date nuevaFecha, int nuevosKilometros) {
        if (this.mantenimiento != null) {
            this.mantenimiento.setFecha(nuevaFecha);
            this.mantenimiento.setKm(nuevosKilometros);
        }
    }
}
