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
@Table(name = "Mantenimiento")
public class Mantenimiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mantenimientoID")
    private Integer mantenimientoID;

    @Column(name = "km")
    private Integer km;

    @ManyToOne
    @JoinColumn(name = "vehiculoID")
    private Vehiculo vehiculo;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer km, Vehiculo vehiculo) {
        this.km = km;
        this.vehiculo = vehiculo;
    }

    public Integer getMantenimientoID() {
        return mantenimientoID;
    }

    public void setMantenimientoID(Integer mantenimientoID) {
        this.mantenimientoID = mantenimientoID;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
