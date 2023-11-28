/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logisticapersistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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
    
public class ControladoraPersistencia {
    ClienteJpaController clienteJPA = new ClienteJpaController();
    DetalleMantenimientoJpaController detallemanteJPA = new DetalleMantenimientoJpaController();
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    EmpleadoViajeJpaController empleviajeJPA = new EmpleadoViajeJpaController();
    MantenimientoJpaController manteJPA = new MantenimientoJpaController();
    MarcaJpaController marcaJPA = new MarcaJpaController();
    PaqueteJpaController paqueteJPA = new PaqueteJpaController();
    ParteDiarioJpaController partediarioJPA = new ParteDiarioJpaController();
    VehiculoJpaController vehiculoJPA = new VehiculoJpaController();
    ViajeJpaController viajeJPA = new ViajeJpaController();
    ViajePaqueteJpaController viajepaqueteJPA = new ViajePaqueteJpaController();
    private EntityManagerFactory emf;
    public ControladoraPersistencia() {
        // Debes proporcionar el nombre de la unidad de persistencia que configuraste en el archivo persistence.xml
        emf = Persistence.createEntityManagerFactory("proyectoJPAPU");
    }
    
    public void crearcliente(Cliente cliente) {
        clienteJPA.create(cliente);
    }
    public void crearempleado (Empleado empleado){
        empleadoJPA.create(empleado);
     }

    public void crearmarca(Marca marca) {
        marcaJPA.create(marca);
    }

    public void crearvehiculo(Vehiculo vehiculo) {
        vehiculoJPA.create(vehiculo);
    }

    public void crearmantenimiento(Mantenimiento mantenimiento) {
        manteJPA.create(mantenimiento);
    }

    public void creardetallemante(DetalleMantenimiento detallemante) {
        detallemanteJPA.create(detallemante);
    }

    public void crearviaje(Viaje viaje) {
        viajeJPA.create(viaje);
    }

    public void crearpaquete(Paquete paquete) {
        paqueteJPA.create(paquete);
    }

    public void crearempleadoviaje(EmpleadoViaje empleadoviaje) {
        empleviajeJPA.create(empleadoviaje);
    }

    public void crearpartediario(ParteDiario partediario) {
        partediarioJPA.create(partediario);
    }

    public void crearviajepaquete(ViajePaquete viajepaquete) {
        viajepaqueteJPA.create(viajepaquete);
    }
    
  
   private EntityManager getEntityManager() {
        return emf.createEntityManager(); // Crea y devuelve una instancia de EntityManager
    }

   public List<Vehiculo> filtrarVehiculosPorPatente(String patente) {
    EntityManager em = getEntityManager();
    TypedQuery<Vehiculo> query;
    
    if (patente.isEmpty()) {
        return obtenerTodosLosVehiculos(); // Retorna todos los vehículos si el campo de patente está vacío
    } else {
        query = em.createQuery(
            "SELECT v FROM Vehiculo v WHERE UPPER(v.patente) LIKE UPPER(CONCAT('%', :patente, '%'))", Vehiculo.class);
        query.setParameter("patente", patente);
        return query.getResultList();
    }
}


    public List<Vehiculo> obtenerTodosLosVehiculos() {
        EntityManager em = getEntityManager();
    try {
        TypedQuery<Vehiculo> query = em.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);
        return query.getResultList();
    } finally {
        em.close();
    }

    }

    public List<Vehiculo> filtrarVehiculosPorModeloCoincidente(String modelo) {
    List<Vehiculo> vehiculos = obtenerTodosLosVehiculos();
    List<Vehiculo> vehiculosCoincidentes = new ArrayList<>();

    for (Vehiculo vehiculo : vehiculos) {
        if (vehiculo.getMarca().getModelo().toLowerCase().startsWith(modelo.toLowerCase())) {
            vehiculosCoincidentes.add(vehiculo);
        }
    }

    return vehiculosCoincidentes;
}

  public int insertarMantenimiento(Date fechaDate, int nuevosKilometros, int vehiculoId) {
    EntityManager em = getEntityManager();
    int mantenimientoId = -1; // Valor predeterminado en caso de error

    try {
        em.getTransaction().begin();

        Vehiculo vehiculo = em.find(Vehiculo.class, vehiculoId);

        if (vehiculo != null) {
            Mantenimiento mantenimiento = vehiculo.getMantenimiento();

            if (mantenimiento != null) {
                // Si existe un mantenimiento asociado al vehículo, actualiza los detalles
                mantenimiento.setFecha(fechaDate);
                mantenimiento.setKm(nuevosKilometros);
                em.merge(mantenimiento); // Actualiza el mantenimiento existente
                mantenimientoId = mantenimiento.getMantenimientoID(); // Obtén el ID del mantenimiento
            } else {
                // Si no hay un mantenimiento asociado al vehículo, crea uno nuevo
                Mantenimiento nuevoMantenimiento = new Mantenimiento();
                nuevoMantenimiento.setFecha(fechaDate);
                nuevoMantenimiento.setKm(nuevosKilometros);
                nuevoMantenimiento.setVehiculo(vehiculo);
                em.persist(nuevoMantenimiento); // Persiste el nuevo mantenimiento
                mantenimientoId = nuevoMantenimiento.getMantenimientoID(); // Obtén el ID del nuevo mantenimiento
            }

            em.getTransaction().commit();
            System.out.println("Mantenimiento actualizado/creado exitosamente. ID: " + mantenimientoId);
        } else {
            System.out.println("No se encontró el vehículo con el ID proporcionado: " + vehiculoId);
        }
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
    }

    return mantenimientoId;
}


    public List<DetalleMantenimiento> obtenerDetallesMantenimiento() {
         EntityManager em = getEntityManager();
    try {
        TypedQuery<DetalleMantenimiento> query = em.createQuery("SELECT v FROM DetalleMantenimiento v", DetalleMantenimiento.class);
        return query.getResultList();
    } finally {
        em.close();
    }
    }

    

    public List<Paquete> obtenerTodosLosPaquetes() {
         EntityManager em = getEntityManager();
    try {
        TypedQuery<Paquete> query = em.createQuery("SELECT v FROM Paquete v", Paquete.class);
        return query.getResultList();
    } finally {
        em.close();
    }
    }

    public List<Paquete> obtenerPaquetesPorCodigo(int codigo) {
    EntityManager em = getEntityManager();
    
    try {
        TypedQuery<Paquete> query = em.createQuery(
            "SELECT p FROM Paquete p WHERE p.codigo_paquete = :codigo", Paquete.class);
        query.setParameter("codigo", codigo);
        
        return query.getResultList();
    } finally {
        em.close();
    }
}

    public List<Paquete> obtenerPaquetesPorVehiculo(Vehiculo vehiculo) {
    EntityManager em = getEntityManager();
    try {
        String jpql = "SELECT p FROM Paquete p " +
                      "JOIN ViajePaquete vp ON p = vp.paquete " +
                      "JOIN Viaje v ON vp.viaje = v " +
                      "JOIN Vehiculo ve ON v.vehiculo = ve " +
                      "WHERE ve.vehiculoID = :vehiculoId";

        TypedQuery<Paquete> query = em.createQuery(jpql, Paquete.class);
        query.setParameter("vehiculoId", vehiculo.getVehiculoID());
        return query.getResultList();
    } finally {
        em.close();
    }
}

    public void actualizarEstadoPaquete(Paquete paquete) {
        EntityManager em = getEntityManager();

    try {
        em.getTransaction().begin();

        Paquete paqueteEnBD = em.find(Paquete.class, paquete.getPaqueteID()); // Suponiendo que la clase Paquete tiene un campo de ID que identifica el paquete

        if (paqueteEnBD != null) {
            paqueteEnBD.setEstado(paquete.getEstado()); // Actualiza el estado del paquete en la base de datos
            em.merge(paqueteEnBD); // Actualiza el paquete en la base de datos
            em.getTransaction().commit();
        } else {
            System.out.println("El paquete no fue encontrado en la base de datos.");
        }
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
    }
    }

    public List<Cliente> obtenerTodosLosClientes() {
        EntityManager em = getEntityManager();
    try {
        TypedQuery<Cliente> query = em.createQuery("SELECT v FROM Cliente v", Cliente.class);
        return query.getResultList();
    } finally {
        em.close();
    }

    }

public List<Cliente> filtrarClientesPorNumeroDocumento(int parteDocumento) {
    EntityManager em = getEntityManager();
    
    try {
        TypedQuery<Cliente> query;
        
        if (parteDocumento == 0) {
            return obtenerTodosLosClientes(); // Retorna todos los clientes si el campo del número de documento está vacío
        } else {
            query = em.createQuery(
                "SELECT c FROM Cliente c WHERE c.nro_documento = :parteDocumento", Cliente.class);
            query.setParameter("parteDocumento", parteDocumento);
            return query.getResultList();
        }
    } finally {
        em.close();
    }
}

   public List<Cliente> filtrarNombreyApellido(String nombreape) {
    EntityManager em = getEntityManager();

    try {
        TypedQuery<Cliente> query;

        if (nombreape.isEmpty()) {
            return obtenerTodosLosClientes(); // Retorna todos los clientes si el campo del nombre y apellido está vacío
        } else {
            query = em.createQuery(
                "SELECT c FROM Cliente c WHERE CONCAT(c.nombre, ' ', c.apellido) LIKE :nombreape", Cliente.class);
            query.setParameter("nombreape", "%" + nombreape + "%");
            return query.getResultList();
        }
    } finally {
        em.close();
    }
}

    public void guardarTipoMantenimiento(DetalleMantenimiento tipoMantenimiento) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(tipoMantenimiento); // Persiste el nuevo tipo de mantenimiento
            em.getTransaction().commit();
            System.out.println("Tipo de mantenimiento guardado exitosamente.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}
   





    

    

    



