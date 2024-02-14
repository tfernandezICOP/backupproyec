/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logisticapersistencia;

import Controladoras.ControladoraMantenimiento;
import Controladoras.ControladoraParteDiario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import logisticalogica.Cliente;
import logisticalogica.ClienteDadoDeBaja;
import logisticalogica.DetalleMantenimiento;
import logisticalogica.Empleado;
import logisticalogica.EmpleadoViaje;
import logisticalogica.Mantenimiento;
import logisticalogica.MantenimientoRealizado;
import logisticalogica.Marca;
import logisticalogica.Paquete;
import logisticalogica.ParteDiario;
import logisticalogica.Usuario;
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
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    private EntityManagerFactory emf;
    private List<Vehiculo> vehiculos;
    private static final int LIMITE_KM_PARA_MANTENIMIENTO = 10000;
    private ControladoraParteDiario controladoraPD; // Declare the variable
    private ControladoraMantenimiento controladoraMante; // Declare the variable
    

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

  /*public int insertarMantenimiento(Date fechaDate, int nuevosKilometros, int kmProximoMantenimiento, int vehiculoId) {
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
                mantenimiento.setProximomantenimiento(kmProximoMantenimiento); // Agrega los Km próximo mantenimiento
                em.merge(mantenimiento); // Actualiza el mantenimiento existente
                mantenimientoId = mantenimiento.getMantenimientoID(); // Obtén el ID del mantenimiento
            } else {
                // Si no hay un mantenimiento asociado al vehículo, crea uno nuevo
                Mantenimiento nuevoMantenimiento = new Mantenimiento();
                nuevoMantenimiento.setFecha(fechaDate);
                nuevoMantenimiento.setKm(nuevosKilometros);
                nuevoMantenimiento.setProximomantenimiento(kmProximoMantenimiento); // Agrega los Km próximo mantenimiento
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

*/
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

public List<Cliente> filtrarClientesPorNumeroDocumentoParcial(int parteDocumento) {
    EntityManager em = getEntityManager();
    
    try {
        TypedQuery<Cliente> query;
        
        if (parteDocumento == 0) {
            return obtenerTodosLosClientes(); // Retorna todos los clientes si el campo del número de documento está vacío
        } else {
            query = em.createQuery(
                "SELECT c FROM Cliente c WHERE CAST(c.nro_documento AS text) LIKE :parteDocumento", Cliente.class);
            query.setParameter("parteDocumento", "%" + parteDocumento + "%");
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
                "SELECT c FROM Cliente c WHERE UPPER(CONCAT(c.nombre, ' ', c.apellido)) LIKE :nombreape", Cliente.class);
            query.setParameter("nombreape", "%" + nombreape.trim().toUpperCase() + "%");  // Convertir la cadena a mayúsculas y usar UPPER
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

    public boolean verificarCredenciales(String nombreUsuario, String contraseña) {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Usuario> query = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.nombre = :nombre AND u.contraseña = :contraseña",
                    Usuario.class);
            query.setParameter("nombre", nombreUsuario);
            query.setParameter("contraseña", contraseña);

            Usuario usuario = query.getSingleResult();

            return usuario != null;

        } catch (NoResultException e) {
            return false;

        } finally {
            em.close();
        }
    }

    public Cliente obtenerClientePorNombreCompleto(String nombreCompleto) {
    EntityManager em = getEntityManager();

    try {
        TypedQuery<Cliente> query = em.createQuery(
            "SELECT c FROM Cliente c WHERE CONCAT(c.nombre, ' ', c.apellido) = :nombreCompleto", Cliente.class);
        query.setParameter("nombreCompleto", nombreCompleto);

        return query.getSingleResult();
    } catch (NoResultException e) {
        // Devuelve null si no se encuentra ningún cliente con el nombre completo proporcionado.
        return null;
    } finally {
        em.close();
    }
}

    public Cliente obtenerClientePorID(int idCliente) {
         EntityManager em = getEntityManager();

        try {
            // Utilizar TypedQuery para ejecutar una consulta parametrizada
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.clienteID = :id", Cliente.class);
            query.setParameter("id", idCliente);

            // Obtener el resultado de la consulta
            Cliente cliente = query.getSingleResult();

            return cliente;
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante la consulta
            e.printStackTrace();
            return null;
        } finally {
            // Cerrar el EntityManager
            em.close();
        }
    }

    public void guardarPaquete(Paquete paquete) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // Verifica si el paquete ya tiene un código asignado (ya existe en la base de datos)
            if (paquete.getCodigo_paquete() != null) {
                // Si ya tiene un código, actualiza el paquete en lugar de persistir uno nuevo
                em.merge(paquete);
            } else {
                // Si no tiene un código, es un paquete nuevo, así que lo persiste
                em.persist(paquete);
            }

            tx.commit();
            System.out.println("Paquete guardado exitosamente.");

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public void guardarViaje(Viaje viaje) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();
        em.persist(viaje); // Persiste el nuevo viaje
        tx.commit();
        System.out.println("Viaje guardado exitosamente. ID: " + viaje.getViajeID());
    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
    }
}

public Vehiculo obtenerVehiculoPorId(Integer vehiculoId) {
    EntityManager em = getEntityManager();
    try {
        return em.find(Vehiculo.class, vehiculoId);
    } finally {
        em.close();
    }
}



    public Paquete obtenerPaquetePorCodigo(int codigoPaquete) {
        EntityManager em = getEntityManager(); // Obtén tu EntityManager de alguna manera

        try {
            // Realiza una consulta para obtener el Paquete por su código
            Query query = em.createQuery("SELECT p FROM Paquete p WHERE p.codigo_paquete = :codigo");
            query.setParameter("codigo", codigoPaquete);

            // Ejecuta la consulta y obtén el resultado (debería ser un solo Paquete)
            return (Paquete) query.getSingleResult();
        } catch (Exception e) {
            // Manejo de excepciones (puede ser que no se encuentre el Paquete)
            e.printStackTrace();
            return null;
        } finally {
            em.close(); // Cierra el EntityManager
        }
    }

    public Viaje obtenerViajePorId(int idViaje) {
    EntityManager em = getEntityManager();

    try {
        // Realiza una consulta para obtener el Viaje por su ID
        Query query = em.createQuery("SELECT v FROM Viaje v WHERE v.viajeID = :idViaje");
        query.setParameter("idViaje", idViaje);

        // Ejecuta la consulta y obtén el resultado (debería ser un solo Viaje)
        return (Viaje) query.getSingleResult();
    } catch (Exception e) {
        // Manejo de excepciones (puede ser que no se encuentre el Viaje)
        e.printStackTrace();
        return null;
    } finally {
        em.close(); // Cierra el EntityManager
    }
}
public List<Paquete> obtenerPaquetesPorEstado(String estado) {
    EntityManager em = getEntityManager();

    try {
        TypedQuery<Paquete> query = em.createQuery(
            "SELECT p FROM Paquete p WHERE p.estado = :estado", Paquete.class);
        query.setParameter("estado", estado);

        return query.getResultList();
    } finally {
        em.close();
    }
}

  

    public List<Marca> obtenerTodasLasMarcas() {
         EntityManager em = getEntityManager();
    try {
        TypedQuery<Marca> query = em.createQuery("SELECT v FROM Marca v", Marca.class);
        return query.getResultList();
    } finally {
        em.close();
    }
    }
    
    
   public List<Marca> filtrarMarcasPorModelo(String modelo) {
    EntityManager em = getEntityManager();
    try {
        TypedQuery<Marca> query = em.createQuery(
                "SELECT m FROM Marca m WHERE LOWER(m.modelo) LIKE LOWER(CONCAT('%', :modelo, '%'))", Marca.class);
        query.setParameter("modelo", modelo);
        return query.getResultList();
    } finally {
        em.close();
    }
}

public List<Marca> filtrarMarcasPorTipo(String tipo) {
    EntityManager em = getEntityManager();
    try {
        TypedQuery<Marca> query = em.createQuery(
                "SELECT m FROM Marca m WHERE LOWER(m.tipo) LIKE LOWER(CONCAT('%', :tipo, '%'))", Marca.class);
        query.setParameter("tipo", tipo);
        return query.getResultList();
    } finally {
        em.close();
    }
}

    public void guardarMarca(Marca marca) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();
        em.persist(marca); // Persiste la nueva marca
        tx.commit();
        System.out.println("Marca guardada exitosamente. ID: " + marca.getMarcaID());
    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
    }
}

   public boolean modeloExiste(String modelo) {
    EntityManager em = getEntityManager();

    try {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(m) FROM Marca m WHERE LOWER(m.modelo) = LOWER(:modelo)", Long.class);
        query.setParameter("modelo", modelo);

        Long count = query.getSingleResult();
        return count > 0;

    } finally {
        em.close();
    }
}

    public Vehiculo guardarvehiculo(Vehiculo vehiculo) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();
        em.persist(vehiculo); // Persist the new vehicle
        tx.commit();
        System.out.println("Vehiculo guardado exitosamente. ID: " + vehiculo.getVehiculoID());
        return vehiculo; // Return the saved vehicle
    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        e.printStackTrace();
        return null; // Return null if an exception occurs
    } finally {
        em.close();
    }
}
    
    public Marca obtenerMarcaPorModeloYTipo(String modelo, String tipo) {
        EntityManager em = getEntityManager();
        try {
            // Consulta JPA para obtener la marca por modelo y tipo
            String jpql = "SELECT m FROM Marca m WHERE m.modelo = :modelo AND m.tipo = :tipo";
            TypedQuery<Marca> query = em.createQuery(jpql, Marca.class);
            query.setParameter("modelo", modelo);
            query.setParameter("tipo", tipo);

            return query.getSingleResult();
        } catch (NoResultException e) {
            // Manejar la excepción si no se encuentra la marca
            return null;
        } finally {
            em.close();
        }
    }

   public void actualizarFechaentrega(Paquete paquete) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();

            Paquete paqueteEnBD = em.find(Paquete.class, paquete.getPaqueteID());

            if (paqueteEnBD != null) {
                paqueteEnBD.setFechaEntrega(paquete.getFechaEntrega()); // Actualiza la fecha de entrega del paquete en la base de datos
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

    






   
    public int obtenerTotalKmVehiculo(Vehiculo vehiculo) {
    EntityManager em = getEntityManager();
    try {
        String jpql = "SELECT SUM(pd.km) FROM ParteDiario pd WHERE pd.vehiculo = :vehiculo";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        query.setParameter("vehiculo", vehiculo);

        Long totalKm = query.getSingleResult();
        return totalKm != null ? totalKm.intValue() : 0;

    } finally {
        em.close();
    }
}

     public List<Mantenimiento> obtenerTodosLosMantenimientos() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Mantenimiento> query = em.createQuery("SELECT m FROM Mantenimiento m", Mantenimiento.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

     public void guardarMantenimientoRealizado(MantenimientoRealizado mantenimientoRealizado) {
        EntityManager em = getEntityManager(); // Asegúrate de tener la instancia de EntityManager
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(mantenimientoRealizado);
            tx.commit();
            System.out.println("Mantenimiento realizado guardado exitosamente. ID: " + mantenimientoRealizado.getMantenimientoRealizadoID());
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
     public boolean tieneMantenimientoRealizado(Vehiculo vehiculo) {
        EntityManager em = getEntityManager();
         try {
            Query query = em.createQuery(
                    "SELECT mr FROM MantenimientoRealizado mr WHERE mr.vehiculo = :vehiculo",
                    MantenimientoRealizado.class
            );
            query.setParameter("vehiculo", vehiculo);
            query.setMaxResults(1);

            // Intenta obtener el mantenimiento realizado para el vehículo
            query.getSingleResult();
            
            // Si no se lanza una excepción, significa que hay al menos un mantenimiento realizado para el vehículo
            return true;
        } catch (NoResultException ex) {
            // No se encontraron resultados, no hay mantenimiento realizado para el vehículo
            return false;
        }
    }

  public void actualizarMantenimientoRealizado(MantenimientoRealizado mantenimiento) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();

        // Obtener el mantenimiento realizado existente por ID
        MantenimientoRealizado mantenimientoExistente = em.find(MantenimientoRealizado.class, mantenimiento.getMantenimientoRealizadoID());

        if (mantenimientoExistente != null) {
            // Si existe, actualiza la fecha de mantenimiento y el kilometraje
            mantenimientoExistente.setFechaMantenimiento(mantenimiento.getFechaMantenimiento());
            mantenimientoExistente.setKmMantenimiento(mantenimiento.getKmMantenimiento()); // Actualiza el kilometraje
            em.merge(mantenimientoExistente);
            System.out.println("Mantenimiento realizado actualizado exitosamente. ID: " + mantenimientoExistente.getMantenimientoRealizadoID());
        } else {
            System.out.println("No se encontró el mantenimiento realizado con el ID proporcionado: " + mantenimiento.getMantenimientoRealizadoID());
        }

        tx.commit();

    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
    }
}


public List<MantenimientoRealizado> obtenerMantenimientoRealizado(Vehiculo vehiculo) {
    EntityManager em = getEntityManager();

    try {
        // Utilizar TypedQuery para ejecutar una consulta parametrizada
        TypedQuery<MantenimientoRealizado> query = em.createQuery(
                "SELECT mr FROM MantenimientoRealizado mr WHERE mr.vehiculo = :vehiculo", MantenimientoRealizado.class);
        query.setParameter("vehiculo", vehiculo);

        // Obtener la lista de resultados de la consulta
        List<MantenimientoRealizado> mantenimientosRealizados = query.getResultList();

        return mantenimientosRealizados;
    } finally {
        // Cerrar el EntityManager
        em.close();
    }
}
public void actualizarDetalleMantenimiento(DetalleMantenimiento detalleMantenimiento) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();

        // Obtener el detalle de mantenimiento existente por ID
        DetalleMantenimiento detalleExistente = em.find(DetalleMantenimiento.class, detalleMantenimiento.getDetalleMantenimientoID());

        if (detalleExistente != null) {
            // Si existe, actualiza los campos necesarios
        detalleExistente.setTipoServicio(detalleMantenimiento.getTipoServicio());
            // Actualiza otros campos según sea necesario

            em.merge(detalleExistente);
            System.out.println("Detalle de mantenimiento actualizado exitosamente. ID: " + detalleExistente.getDetalleMantenimientoID());
        } else {
            System.out.println("No se encontró el detalle de mantenimiento con el ID proporcionado: " + detalleMantenimiento.getDetalleMantenimientoID());
        }

        tx.commit();

    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
    }
}
 public Date obtenerUltimaFechaMantenimiento(Vehiculo vehiculo) {
        EntityManager em = getEntityManager();

        try {
            // Utilizar TypedQuery para ejecutar una consulta parametrizada
            TypedQuery<Date> query = em.createQuery(
                    "SELECT MAX(mr.fechaMantenimiento) FROM MantenimientoRealizado mr WHERE mr.vehiculo = :vehiculo", Date.class);
            query.setParameter("vehiculo", vehiculo);

            // Obtener la última fecha de mantenimiento para el vehículo
            Date ultimaFechaMantenimiento = query.getSingleResult();

            return ultimaFechaMantenimiento;
        } finally {
            // Cerrar el EntityManager
            em.close();
        }
    }
public int obtenerKmRecorridosMasRecientes(Vehiculo vehiculo) {
    EntityManager em = null;
    try {
        em = getEntityManager();
        // Consulta para obtener el parte diario más reciente asociado al vehículo
        Query query = em.createQuery("SELECT p.km FROM ParteDiario p WHERE p.vehiculo = :vehiculo ORDER BY p.fecha DESC");
        query.setParameter("vehiculo", vehiculo);
        query.setMaxResults(1); // Obtener solo el resultado más reciente
        Integer ultimoKmRecorrido = (Integer) query.getSingleResult();
        
        if (ultimoKmRecorrido != null) {
            return ultimoKmRecorrido;
        } else {
            // Si no hay parte diario registrado para el vehículo, devuelve 0
            return 0;
        }
    } finally {
        if (em != null) {
            em.close();
        }
    }
}




    



public void guardarParteDiario(ParteDiario parteDiario) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();

        // Resto del código para guardar el parte diario...
        em.persist(parteDiario);

        tx.commit();
    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
    }
}


public ParteDiario obtenerParteDiarioExistente(Vehiculo vehiculo) {
    EntityManager em = getEntityManager();

    try {
        String jpql = "SELECT pd FROM ParteDiario pd WHERE pd.vehiculo = :vehiculo ORDER BY pd.fecha DESC";
        TypedQuery<ParteDiario> query = em.createQuery(jpql, ParteDiario.class);
        query.setParameter("vehiculo", vehiculo);
        query.setMaxResults(1); // Obtener solo el último parte diario

        List<ParteDiario> resultados = query.getResultList();

        return resultados.isEmpty() ? null : resultados.get(0);

    } finally {
        em.close();
    }
}
public void actualizarParteDiario(ParteDiario parteDiario) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();

        // Resto del código para actualizar el parte diario usando merge
        em.merge(parteDiario);

        tx.commit();
    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
    }
}


public void guardarMantenimiento(Mantenimiento mantenimiento) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();
        em.persist(mantenimiento);
        tx.commit();
        System.out.println("Mantenimiento guardado exitosamente. ID: " + mantenimiento.getMantenimientoID());
    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
    }
}

public void actualizarMantenimiento(Mantenimiento mantenimientoExistente, int nuevoKm) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();

        // Actualizar el mantenimientoExistente con el nuevo kilometraje
        mantenimientoExistente.setKm(nuevoKm);

        // Resto del código para actualizar el mantenimiento usando merge
        em.merge(mantenimientoExistente);

        tx.commit();
    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
    }
}


public Mantenimiento obtenerMantenimientoExistente(Vehiculo vehiculo) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Mantenimiento> query = em.createQuery(
                    "SELECT m FROM Mantenimiento m WHERE m.vehiculo = :vehiculo", Mantenimiento.class);
            query.setParameter("vehiculo", vehiculo);
            return query.getSingleResult();
        } catch (NoResultException ex) {
            // Si no hay resultados, retorna null
            return null;
        } finally {
            em.close();
        }
    }
public List<Vehiculo> obtenerVehiculosConMantenimiento() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT v FROM Vehiculo v WHERE v.mantenimiento IS NOT NULL";
        TypedQuery<Vehiculo> query = em.createQuery(jpql, Vehiculo.class);

        // Ejecutar la consulta y obtener la lista de vehículos
        return query.getResultList();
    }

public MantenimientoRealizado obtenerUltimoMantenimientoRealizado(Vehiculo vehiculo) {
    EntityManager em = getEntityManager();
    try {
        TypedQuery<MantenimientoRealizado> query = em.createQuery(
                "SELECT mr FROM MantenimientoRealizado mr WHERE mr.vehiculo = :vehiculo ORDER BY mr.fechaMantenimiento DESC", MantenimientoRealizado.class);
        query.setParameter("vehiculo", vehiculo);
        query.setMaxResults(1); // Obtener solo el último mantenimiento realizado
        return query.getSingleResult();
    } catch (NoResultException ex) {
        // Si no hay resultados, retorna null
        return null;
    } finally {
        em.close();
    }
}
public List<ParteDiario> obtenerParteDiarioPorVehiculo(Vehiculo vehiculo) {
    EntityManager em = getEntityManager();

    try {
        String jpql = "SELECT pd FROM ParteDiario pd WHERE pd.vehiculo = :vehiculo ORDER BY pd.fecha";
        TypedQuery<ParteDiario> query = em.createQuery(jpql, ParteDiario.class);
        query.setParameter("vehiculo", vehiculo);

        return query.getResultList();

    } finally {
        em.close();
    }
}
public void darDeBajaCliente(Integer clienteID) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();

        Cliente cliente = em.find(Cliente.class, clienteID);

        if (cliente != null) {
            // Cambia el estado del cliente a "Baja"
            cliente.setEstado("Baja");

            tx.commit();
            System.out.println("Cliente dado de baja exitosamente. ClienteID: " + clienteID);
        } else {
            System.out.println("No se encontró el cliente con ClienteID: " + clienteID);
        }
    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
    }
}

// En tu clase ControladoraCliente

public List<Cliente> filtrarClientesPorEstado(String estado) {
    EntityManager em = getEntityManager();

    try {
        // Crea la consulta JPQL para obtener los clientes por estado
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.estado = :estado", Cliente.class);
        query.setParameter("estado", estado);

        // Ejecuta la consulta y devuelve el resultado
        return query.getResultList();
    } finally {
        em.close();
    }
}

public void darDeBajaVehiculo(Integer vehiculoID) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Vehiculo vehiculo = em.find(Vehiculo.class, vehiculoID);

            if (vehiculo != null) {
                // Cambiar el estado del vehículo a "Baja"
                vehiculo.setEstado("Baja");

                tx.commit();
                System.out.println("Vehículo dado de baja exitosamente. VehiculoID: " + vehiculoID);
            } else {
                System.out.println("No se encontró el vehículo con VehiculoID: " + vehiculoID);
            }
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


public List<Vehiculo> obtenerVehiculosActivos() {
        EntityManager em = getEntityManager();

        try {
            // Crear una consulta JPQL para obtener los vehículos activos
            TypedQuery<Vehiculo> query = em.createQuery(
                    "SELECT v FROM Vehiculo v WHERE v.estado = 'Activo'", Vehiculo.class);

            // Ejecutar la consulta y devolver los resultados
            return query.getResultList();
        } finally {
            em.close();
        }
    }

   public int obtenerUltimoKmMantenimiento(Vehiculo vehiculo) {
    EntityManager em = getEntityManager();
    try {
        // Utilizar TypedQuery para ejecutar una consulta parametrizada
        TypedQuery<Integer> query = em.createQuery(
                "SELECT COALESCE(MAX(mr.kmMantenimiento), 0) FROM MantenimientoRealizado mr WHERE mr.vehiculo = :vehiculo", Integer.class);
        query.setParameter("vehiculo", vehiculo);

        // Obtener el resultado de la consulta
        Integer ultimoKm = query.getSingleResult();

        // Devolver el último kilometraje registrado
        return ultimoKm != null ? ultimoKm : 0;
    } catch (NoResultException ex) {
        // Si no hay resultados, retornar 0
        return 0;
    } finally {
        em.close();
    }
   }
public void actualizarTipoMantenimiento(DetalleMantenimiento detalle) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();

        // Verificar si el detalle ya está administrado por el contexto de persistencia
        if (!em.contains(detalle)) {
            // Si no está administrado, cargar el detalle desde la base de datos antes de actualizarlo
            detalle = em.find(DetalleMantenimiento.class, detalle.getDetalleMantenimientoID());
        }

        // Actualizar el tipo de servicio del detalle de mantenimiento
        detalle.setTipoServicio(detalle.getTipoServicio());

        tx.commit();
        System.out.println("Detalle de mantenimiento actualizado exitosamente. DetalleMantenimientoID: " + detalle.getDetalleMantenimientoID());
    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        em.close();
    }
}

}

  









   





    

    

    



