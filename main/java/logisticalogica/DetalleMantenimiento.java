/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logisticalogica;


import javax.persistence.*;

@Entity
@Table(name = "DetalleMantenimiento")
public class DetalleMantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detalleMantenimientoID")
    private Integer detalleMantenimientoID;

    @Column(name = "tipoServicio")
    private String tipoServicio;

    @ManyToOne
    @JoinColumn(name = "mantenimientoRealizadoID", referencedColumnName = "mantenimientoRealizadoID")
    private MantenimientoRealizado mantenimientoRealizado;

    // Constructores, getters y setters

    // Constructor sin argumentos requerido por JPA
    public DetalleMantenimiento() {
    }

    // Constructor con todos los campos excepto el ID (ya que se genera automáticamente)
    public DetalleMantenimiento(String tipoServicio, MantenimientoRealizado mantenimientoRealizado) {
        this.tipoServicio = tipoServicio;
        this.mantenimientoRealizado = mantenimientoRealizado;
    }

    // Getters y setters

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

    public MantenimientoRealizado getMantenimientoRealizado() {
        return mantenimientoRealizado;
    }

    public void setMantenimientoRealizado(MantenimientoRealizado mantenimientoRealizado) {
        this.mantenimientoRealizado = mantenimientoRealizado;
    }
}
