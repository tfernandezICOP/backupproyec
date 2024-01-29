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
@Table(name = "Empleado")
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empleadoID")
    private Integer empleadoID;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private Integer direccion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nro_documento")
    private Integer nro_documento;

    @Column(name = "nro_telefono")
    private Integer nro_telefono;

    @Column(name = "salario")
    private Integer salario;

    public Empleado() {
    }

    public Empleado(Integer empleadoID, String apellido, Integer direccion, String nombre, Integer nro_documento, Integer nro_telefono, Integer salario) {
        this.empleadoID = empleadoID;
        this.apellido = apellido;
        this.direccion = direccion;
        this.nombre = nombre;
        this.nro_documento = nro_documento;
        this.nro_telefono = nro_telefono;
        this.salario = salario;
    }

    public Integer getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(Integer empleadoID) {
        this.empleadoID = empleadoID;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDireccion() {
        return direccion;
    }

    public void setDireccion(Integer direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(Integer nro_documento) {
        this.nro_documento = nro_documento;
    }

    public Integer getNro_telefono() {
        return nro_telefono;
    }

    public void setNro_telefono(Integer nro_telefono) {
        this.nro_telefono = nro_telefono;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }
    
    
}
