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
@Table(name = "MantenimientoRealizado")
public class MantenimientoRealizado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mantenimientoRealizadoID")
    private Integer mantenimientoRealizadoID;

    @Column(name = "fechaMantenimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaMantenimiento;

    @Column(name = "kmMantenimiento")
    private int kmMantenimiento;
    @ManyToOne
    @JoinColumn(name = "vehiculoID")
    private Vehiculo vehiculo;

    public MantenimientoRealizado() {
    }

    public MantenimientoRealizado(Integer mantenimientoRealizadoID, Date fechaMantenimiento, int kmMantenimiento, Vehiculo vehiculo) {
        this.mantenimientoRealizadoID = mantenimientoRealizadoID;
        this.fechaMantenimiento = fechaMantenimiento;
        this.kmMantenimiento = kmMantenimiento;
        this.vehiculo = vehiculo;
    }

    

    public Integer getMantenimientoRealizadoID() {
        return mantenimientoRealizadoID;
    }

    public void setMantenimientoRealizadoID(Integer mantenimientoRealizadoID) {
        this.mantenimientoRealizadoID = mantenimientoRealizadoID;
    }

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getKmMantenimiento() {
        return kmMantenimiento;
    }

    public void setKmMantenimiento(int kmMantenimiento) {
        this.kmMantenimiento = kmMantenimiento;
    }
    @Override
    public String toString() {
        return "MantenimientoRealizado{" +
                "mantenimientoRealizadoID=" + mantenimientoRealizadoID +
                ", fechaMantenimiento=" + fechaMantenimiento +
                ", vehiculo=" + vehiculo +
                ", kmMantenimiento=" + kmMantenimiento +
                '}';
    }

}
