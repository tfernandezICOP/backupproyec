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
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clienteID")
    private Integer clienteID;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correoElectronico")
    private String correoElectronico;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nro_documento")
    private long nro_documento;

    @Column(name = "nro_telefono")
    private long nro_telefono;

    public Cliente() {
    }

    public Cliente(Integer clienteID, String apellido, String correoElectronico, String direccion, String nombre, long nro_documento, long nro_telefono) {
        this.clienteID = clienteID;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.nombre = nombre;
        this.nro_documento = nro_documento;
        this.nro_telefono = nro_telefono;
    }

    
    
    

    public Integer getClienteID() {
        return clienteID;
    }

    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(long nro_documento) {
        this.nro_documento = nro_documento;
    }

    public long getNro_telefono() {
        return nro_telefono;
    }

    public void setNro_telefono(long nro_telefono) {
        this.nro_telefono = nro_telefono;
    }

   

    

   
    
    
}

