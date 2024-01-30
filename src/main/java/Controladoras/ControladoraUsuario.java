/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraUsuario {
        ControladoraPersistencia controlpersis = new ControladoraPersistencia();
         public boolean autenticarUsuario(String nombreUsuario, String contraseña) {
        return controlpersis.verificarCredenciales(nombreUsuario, contraseña);
    }
}
