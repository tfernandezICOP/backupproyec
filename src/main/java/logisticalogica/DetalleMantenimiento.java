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
    @Table(name = "DetalleMantenimiento")
    public class DetalleMantenimiento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detalleMantenimientoID")
    private Integer detalleMantenimientoID;

    @Column(name = "tipoServicio")
    private String tipoServicio;

    @ManyToOne
    @JoinColumn(name = "mantenimientoID")
    private Mantenimiento mantenimiento;

    public DetalleMantenimiento() {
    }

    public DetalleMantenimiento(Integer detalleMantenimientoID, String tipoServicio, Mantenimiento mantenimiento) {
        this.detalleMantenimientoID = detalleMantenimientoID;
        this.tipoServicio = tipoServicio;
        this.mantenimiento = mantenimiento;
    }

    public Integer getDetalleMantenimientoID() {
        return detalleMantenimientoID;
    }

    public void setDetalleMantenimientoID(Integer detalleMantenimientoID) {
        this.detalleMantenimientoID = detalleMantenimientoID;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    
}
