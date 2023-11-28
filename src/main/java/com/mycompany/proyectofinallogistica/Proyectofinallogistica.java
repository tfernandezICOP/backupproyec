/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinallogistica;

import Controladoras.ControladoraCliente;
import Controladoras.ControladoraDetalleMante;
import Controladoras.ControladoraEmpleado;
import Controladoras.ControladoraEmpleadoViaje;
import Controladoras.ControladoraMantenimiento;
import Controladoras.ControladoraMarca;
import Controladoras.ControladoraPaquete;
import Controladoras.ControladoraParteDiario;
import Controladoras.ControladoraVehiculo;
import Controladoras.ControladoraViaje;
import Controladoras.ControladoraViajePaquete;
import java.util.Date;
import logisticaigu.Menu;
import logisticalogica.Cliente;
import logisticalogica.DetalleMantenimiento;
import logisticalogica.Empleado;
import logisticalogica.EmpleadoViaje;
import logisticalogica.Mantenimiento;
import logisticalogica.Marca;
import logisticalogica.Paquete;
import logisticalogica.ParteDiario;
import logisticalogica.Vehiculo;
import logisticalogica.Viaje;
import logisticalogica.ViajePaquete;
import logisticapersistencia.ControladoraPersistencia;
import logisticapersistencia.PaqueteJpaController;

/**
 *
 * @author ULTRA
 */
public class Proyectofinallogistica {

    public static void main(String[] args) {
    /*   Controladoras.ControladoraCliente controlcliente = new ControladoraCliente();
        Cliente cliente = new Cliente();
       //CLIENTE
// Establecemos los valores de las propiedades del cliente.
   cliente.setNombre("Juan");
    cliente.setApellido("Perez");
    cliente.setCorreoElectronico("juan.perez@example.com");
    cliente.setDireccion("Calle 123, Ciudad de Buenos Aires");
    cliente.setNro_documento(12345678);
    cliente.setNro_telefono(98765432);
    
    controlcliente.crearcliente(cliente);
  
  Cliente cliente2 = new Cliente();
cliente2.setNombre("Maria");
cliente2.setApellido("Gonzalez");
cliente2.setCorreoElectronico("maria.gonzalez@example.com");
cliente2.setDireccion("Calle 456, Ciudad de Córdoba");
cliente2.setNro_documento(23456789);
cliente2.setNro_telefono(87654321);

// Cliente 3
Cliente cliente3 = new Cliente();
cliente3.setNombre("Pedro");
cliente3.setApellido("Lopez");
cliente3.setCorreoElectronico("pedro.lopez@example.com");
cliente3.setDireccion("Calle 789, Ciudad de Mendoza");
cliente3.setNro_documento(34567890);
cliente3.setNro_telefono(76543210);

// Cliente 4
Cliente cliente4 = new Cliente();
cliente4.setNombre("Ana");
cliente4.setApellido("Martinez");
cliente4.setCorreoElectronico("ana.martinez@example.com");
cliente4.setDireccion("Calle 1012, Ciudad de Neuquén");
cliente4.setNro_documento(45678901);
cliente4.setNro_telefono(65432100);

// Cliente 5
Cliente cliente5 = new Cliente();
cliente5.setNombre("Juan");
cliente5.setApellido("Rodriguez");
cliente5.setCorreoElectronico("juan.rodriguez@example.com");
cliente5.setDireccion("Calle 1314, Ciudad de Salta");
cliente5.setNro_documento(56789012);
cliente5.setNro_telefono(54321000);

    controlcliente.crearcliente(cliente2);
        controlcliente.crearcliente(cliente3);
            controlcliente.crearcliente(cliente4);

             controlcliente.crearcliente(cliente5);


  //EMPLEADO
   Controladoras.ControladoraEmpleado controlempleado = new ControladoraEmpleado();
       
        
        // Empleado 1
Empleado empleado1 = new Empleado();
empleado1.setNombre("Juan");
empleado1.setApellido("Perez");
empleado1.setDireccion(12345678);
empleado1.setNombre("Juan.Perez@example.com");
empleado1.setNro_documento(12345678);
empleado1.setNro_telefono(98765432);
empleado1.setSalario(10000);

// Empleado 2
Empleado empleado2 = new Empleado();
empleado2.setNombre("Maria");
empleado2.setApellido("Gonzalez");
empleado2.setDireccion(23456789);
empleado2.setNombre("Maria.Gonzalez@example.com");
empleado2.setNro_documento(23456789);
empleado2.setNro_telefono(87654321);
empleado2.setSalario(20000);

// Empleado 3
Empleado empleado3 = new Empleado();
empleado3.setNombre("Pedro");
empleado3.setApellido("Lopez");
empleado3.setDireccion(34567890);
empleado3.setNombre("Pedro.Lopez@example.com");
empleado3.setNro_documento(34567890);
empleado3.setNro_telefono(76543210);
empleado3.setSalario(30000);

// Empleado 4
Empleado empleado4 = new Empleado();
empleado4.setNombre("Ana");
empleado4.setApellido("Martinez");
empleado4.setDireccion(45678901);
empleado4.setNombre("Ana.Martinez@example.com");
empleado4.setNro_documento(45678901);
empleado4.setNro_telefono(65432100);
empleado4.setSalario(40000);

// Empleado 5
Empleado empleado5 = new Empleado();
empleado5.setNombre("Juan");
empleado5.setApellido("Rodriguez");
empleado5.setDireccion(56789012);
empleado5.setNombre("Juan.Rodriguez@example.com");
empleado5.setNro_documento(56789012);
empleado5.setNro_telefono(54321000);
empleado5.setSalario(50000);

controlempleado.crearempleado(empleado1);
controlempleado.crearempleado(empleado2);
controlempleado.crearempleado(empleado3);
controlempleado.crearempleado(empleado4);
controlempleado.crearempleado(empleado5);
        
        
 
  Controladoras.ControladoraMarca controlmarca = new ControladoraMarca();
  
  
  Marca marca1 = new Marca();
marca1.setModelo("Iveco");
marca1.setTipo("Camion");

// Marca 2
Marca marca2 = new Marca();
marca2.setModelo("Volvo");
marca2.setTipo("Camion");

// Marca 3
Marca marca3 = new Marca();
marca3.setModelo("Mercedes-Benz");
marca3.setTipo("Camion");

// Marca 4
Marca marca4 = new Marca();
marca4.setModelo("Scania");
marca4.setTipo("Camion");

// Marca 5
Marca marca5 = new Marca();
marca5.setModelo("MAN");
marca5.setTipo("Camion");

controlmarca.crearmarca(marca1);
controlmarca.crearmarca(marca2);
controlmarca.crearmarca(marca3);
controlmarca.crearmarca(marca4);
controlmarca.crearmarca(marca5);
    
//vehiculo
Controladoras.ControladoraVehiculo controlvehiculo = new ControladoraVehiculo();
     Vehiculo vehiculo1 = new Vehiculo(1, 1000, 1, 1, marca1);
     Vehiculo vehiculo2 = new Vehiculo(2, 2000, 2, 2, marca2);
     Vehiculo vehiculo3 = new Vehiculo(3, 3000, 3, 3, marca3);
     Vehiculo vehiculo4 = new Vehiculo(4, 4000, 4, 4, marca4);
     Vehiculo vehiculo5 = new Vehiculo(5, 5000, 5, 5, marca5);   
      controlvehiculo.crearvehiculo(vehiculo1);
        controlvehiculo.crearvehiculo(vehiculo2);
        controlvehiculo.crearvehiculo(vehiculo3);
        controlvehiculo.crearvehiculo(vehiculo4);
        controlvehiculo.crearvehiculo(vehiculo5);  
        
 //mantenimiento
 Controladoras.ControladoraMantenimiento controlmante = new ControladoraMantenimiento();
        Mantenimiento mantenimiento1 = new Mantenimiento(1, new Date(), 1000, vehiculo1);
        Mantenimiento mantenimiento2 = new Mantenimiento(2, new Date(2020, 8, 5), 2000, vehiculo2);
        Mantenimiento mantenimiento3 = new Mantenimiento(3, new Date(2023, 7, 21), 3000, vehiculo3);
        Mantenimiento mantenimiento4 = new Mantenimiento(4, new Date(2021, 10, 10), 4000, vehiculo4);
        Mantenimiento mantenimiento5 = new Mantenimiento(5, new Date(2019, 9, 25), 5000, vehiculo5);
        controlmante.crearmantenimiento(mantenimiento1);
        controlmante.crearmantenimiento(mantenimiento2);
        controlmante.crearmantenimiento(mantenimiento3);
        controlmante.crearmantenimiento(mantenimiento4);
        controlmante.crearmantenimiento(mantenimiento5);



//detalle mantenimiento
Controladoras.ControladoraDetalleMante controldetallemante = new ControladoraDetalleMante();
DetalleMantenimiento detallemante1 = new DetalleMantenimiento();
        detallemante1.setTipoServicio("Cambio de aceite y filtro");
        detallemante1.setMantenimiento(mantenimiento1);
DetalleMantenimiento detallemante2 = new DetalleMantenimiento();
        detallemante2.setTipoServicio("Rotación de neumáticos");
        detallemante2.setMantenimiento(mantenimiento2);

DetalleMantenimiento detallemante3 = new DetalleMantenimiento();
        detallemante3.setTipoServicio("Cambio de pastillas de freno");
        detallemante3.setMantenimiento(mantenimiento3);

DetalleMantenimiento detallemante4 = new DetalleMantenimiento();
        detallemante4.setTipoServicio("Cambio de filtro de aire");
        detallemante4.setMantenimiento(mantenimiento4);

DetalleMantenimiento detallemante5 = new DetalleMantenimiento();
        detallemante5.setTipoServicio("Alineación y balanceo");
        detallemante5.setMantenimiento(mantenimiento5);

controldetallemante.creardetallemante(detallemante1);
controldetallemante.creardetallemante(detallemante2);
controldetallemante.creardetallemante(detallemante3);
controldetallemante.creardetallemante(detallemante4);
controldetallemante.creardetallemante(detallemante5);

Controladoras.ControladoraViaje controlviaje = new ControladoraViaje();
Viaje viaje1 = new Viaje();
viaje1.setDestino("Destination 1");
viaje1.setFecha(new Date()); // Set the date accordingly
viaje1.setOrigen("Origin 1");
viaje1.setVehiculo(vehiculo1); // You should have vehiculo1 defined

Viaje viaje2 = new Viaje();
viaje2.setDestino("Destination 2");
viaje2.setFecha(new Date()); // Set the date accordingly
viaje2.setOrigen("Origin 2");
viaje2.setVehiculo(vehiculo2); // You should have vehiculo2 defined

Viaje viaje3 = new Viaje();
viaje3.setDestino("Destination 3");
viaje3.setFecha(new Date()); // Set the date accordingly
viaje3.setOrigen("Origin 3");
viaje3.setVehiculo(vehiculo3); // You should have vehiculo3 defined

Viaje viaje4 = new Viaje();
viaje4.setDestino("Destination 4");
viaje4.setFecha(new Date()); // Set the date accordingly
viaje4.setOrigen("Origin 4");
viaje4.setVehiculo(vehiculo4); // You should have vehiculo4 defined

Viaje viaje5 = new Viaje();
viaje5.setDestino("Destination 5");
viaje5.setFecha(new Date()); // Set the date accordingly
viaje5.setOrigen("Origin 5");
viaje5.setVehiculo(vehiculo5); // You should have vehiculo5 defined

// Save the trips using ControladoraViaje
controlviaje.crearviaje(viaje1);
controlviaje.crearviaje(viaje2);
controlviaje.crearviaje(viaje3);
controlviaje.crearviaje(viaje4);
controlviaje.crearviaje(viaje5);

Controladoras.ControladoraPaquete controlpaquete = new ControladoraPaquete();
        Paquete paquete1 = new Paquete();
        paquete1.setCodigo_paquete(123);
        paquete1.setDescripcion("Descripción del paquete 1");
        paquete1.setDomicilioEntrega("Dirección de entrega 1");
        paquete1.setEstado("Pendiente");
        paquete1.setEmisor(cliente);
        paquete1.setReceptor(cliente2);
        controlpaquete.crearpaquete(paquete1);

        // Crear Paquete 2
        Paquete paquete2 = new Paquete();
        paquete2.setCodigo_paquete(124);
        paquete2.setDescripcion("Descripción del paquete 2");
        paquete2.setDomicilioEntrega("Dirección de entrega 2");
        paquete2.setEstado("Pendiente");
        paquete2.setEmisor(cliente2);
        paquete2.setReceptor(cliente3);
        controlpaquete.crearpaquete(paquete2);
        
        Paquete paquete3 = new Paquete();
        paquete3.setCodigo_paquete(125);
        paquete3.setDescripcion("Descripción del paquete 3");
        paquete3.setDomicilioEntrega("Dirección de entrega 3");
        paquete3.setEstado("Pendiente");
        paquete3.setEmisor(cliente3);
        paquete3.setReceptor(cliente5);
        controlpaquete.crearpaquete(paquete3);
        
        Paquete paquete4 = new Paquete();
        paquete4.setCodigo_paquete(126);
        paquete4.setDescripcion("Descripción del paquete 4");
        paquete4.setDomicilioEntrega("Dirección de entrega 4");
        paquete4.setEstado("Pendiente");
        paquete4.setEmisor(cliente4);
        paquete4.setReceptor(cliente);
        controlpaquete.crearpaquete(paquete4);

        // Crear Paquete 5
        Paquete paquete5 = new Paquete();
        paquete5.setCodigo_paquete(127);
        paquete5.setDescripcion("Descripción del paquete 5");
        paquete5.setDomicilioEntrega("Dirección de entrega 5");
        paquete5.setEstado("Pendiente");
        paquete5.setEmisor(cliente5);
        paquete5.setReceptor(cliente4);
        controlpaquete.crearpaquete(paquete5);
        
    
       
        Controladoras.ControladoraParteDiario controlpartediario = new ControladoraParteDiario();
         ParteDiario parteDiario1 = new ParteDiario();
        parteDiario1.setFecha(new Date()); // Añade la fecha actual o una fecha específica
        parteDiario1.setHoras(6); // Ejemplo: 6 horas trabajadas
        parteDiario1.setKm(120); // Ejemplo: 120 kilómetros recorridos
        parteDiario1.setVehiculo(vehiculo1); // Asigna el Vehículo correspondiente a este parte diario
        controlpartediario.crearpartediario(parteDiario1);

        ParteDiario parteDiario2 = new ParteDiario();
        parteDiario2.setFecha(new Date()); // Añade la fecha actual o una fecha específica
        parteDiario2.setHoras(5); // Ejemplo: 5 horas trabajadas
        parteDiario2.setKm(90); // Ejemplo: 90 kilómetros recorridos
        parteDiario2.setVehiculo(vehiculo2); // Asigna el Vehículo correspondiente a este parte diario
        controlpartediario.crearpartediario(parteDiario2);

        // Crea los otros ParteDiario de manera similar.

        // ParteDiario 3
        ParteDiario parteDiario3 = new ParteDiario();
        parteDiario3.setFecha(new Date()); // Añade la fecha actual o una fecha específica
        parteDiario3.setHoras(7); // Ejemplo: 7 horas trabajadas
        parteDiario3.setKm(150); // Ejemplo: 150 kilómetros recorridos
        parteDiario3.setVehiculo(vehiculo3);
        controlpartediario.crearpartediario(parteDiario3);

        // ParteDiario 4
        ParteDiario parteDiario4 = new ParteDiario();
        parteDiario4.setFecha(new Date()); // Añade la fecha actual o una fecha específica
        parteDiario4.setHoras(8); // Ejemplo: 8 horas trabajadas
        parteDiario4.setKm(110); // Ejemplo: 110 kilómetros recorridos
        parteDiario4.setVehiculo(vehiculo4);
        controlpartediario.crearpartediario(parteDiario4);

        // ParteDiario 5
        ParteDiario parteDiario5 = new ParteDiario();
        parteDiario5.setFecha(new Date()); // Añade la fecha actual o una fecha específica
        parteDiario5.setHoras(6); // Ejemplo: 6 horas trabajadas
        parteDiario5.setKm(100); // Ejemplo: 100 kilómetros recorridos
        parteDiario5.setVehiculo(vehiculo5);
        controlpartediario.crearpartediario(parteDiario5);
        
        Controladoras.ControladoraViajePaquete controlviajepaquete = new ControladoraViajePaquete();

// ViajePaquete 1
ViajePaquete viajepaquete1 = new ViajePaquete();
viajepaquete1.setPaquete(paquete1);
viajepaquete1.setViaje(viaje1);
controlviajepaquete.crearviajepaquete(viajepaquete1);

// ViajePaquete 2
ViajePaquete viajepaquete2 = new ViajePaquete();
viajepaquete2.setPaquete(paquete1); // Asigna el mismo paquete o el que desees
viajepaquete2.setViaje(viaje2);
controlviajepaquete.crearviajepaquete(viajepaquete2);

// ViajePaquete 3
ViajePaquete viajepaquete3 = new ViajePaquete();
viajepaquete3.setPaquete(paquete3); // Asigna el paquete correspondiente
viajepaquete3.setViaje(viaje3);
controlviajepaquete.crearviajepaquete(viajepaquete3);

// ViajePaquete 4
ViajePaquete viajepaquete4 = new ViajePaquete();
viajepaquete4.setPaquete(paquete4); // Asigna el paquete correspondiente
viajepaquete4.setViaje(viaje4);
controlviajepaquete.crearviajepaquete(viajepaquete4);

// ViajePaquete 5
ViajePaquete viajepaquete5 = new ViajePaquete();
viajepaquete5.setPaquete(paquete5); // Asigna el paquete correspondiente
viajepaquete5.setViaje(viaje5);
controlviajepaquete.crearviajepaquete(viajepaquete5);
       


 Controladoras.ControladoraEmpleadoViaje controlempleviaje = new ControladoraEmpleadoViaje();
        EmpleadoViaje empleadoviaje1 = new EmpleadoViaje();
        empleadoviaje1.setViaje(viaje1);
        empleadoviaje1.setEmpleado(empleado1);
         EmpleadoViaje empleadoviaje2 = new EmpleadoViaje();
        empleadoviaje2.setViaje(viaje3);
        empleadoviaje2.setEmpleado(empleado2);
         EmpleadoViaje empleadoviaje3 = new EmpleadoViaje();
        empleadoviaje3.setViaje(viaje4);
        empleadoviaje3.setEmpleado(empleado3);
         EmpleadoViaje empleadoviaje4 = new EmpleadoViaje();
        empleadoviaje4.setViaje(viaje2);
        empleadoviaje4.setEmpleado(empleado4);
         EmpleadoViaje empleadoviaje5 = new EmpleadoViaje();
        empleadoviaje5.setViaje(viaje5);
        empleadoviaje5.setEmpleado(empleado5);
        controlempleviaje.crearempleadoviaje(empleadoviaje1);
        controlempleviaje.crearempleadoviaje(empleadoviaje2);
        controlempleviaje.crearempleadoviaje(empleadoviaje3);
        controlempleviaje.crearempleadoviaje(empleadoviaje4);
        controlempleviaje.crearempleadoviaje(empleadoviaje5);
*/
        
    /*    Controladoras.ControladoraMarca controlmarca = new ControladoraMarca();
  
  
    Marca marca6 = new Marca();
    marca6.setModelo("Renault");
    marca6.setTipo("Utilitario");
    controlmarca.crearmarca(marca6);

      Controladoras.ControladoraVehiculo controlvehiculo = new ControladoraVehiculo();
     Vehiculo vehiculo10 = new Vehiculo();
     vehiculo10.setCapacidad_carga(800);
     vehiculo10.setNro_vehiculo(6);
     vehiculo10.setPatente("AC296CD");
     vehiculo10.setMarca(marca6);
     controlvehiculo.crearvehiculo(vehiculo10);


   Menu menu = new Menu();
   menu.setVisible(true);
*/
    
        PaqueteJpaController paque = new PaqueteJpaController();
}
}