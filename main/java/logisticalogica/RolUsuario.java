package logisticalogica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RolUsuario")
public class RolUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rolUsuario_ID")
    private Integer rolUsuarioID;

    @Column(name = "nombreRol")
    private String nombreRol;

    // Constructors, getters, and setters

    public RolUsuario() {
    }

    public RolUsuario(Integer rolUsuarioID, String nombreRol) {
        this.rolUsuarioID = rolUsuarioID;
        this.nombreRol = nombreRol;
    }

    public Integer getRolUsuarioID() {
        return rolUsuarioID;
    }

    public void setRolUsuarioID(Integer rolUsuarioID) {
        this.rolUsuarioID = rolUsuarioID;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
