/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logisticapersistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logisticalogica.Viaje;
import logisticapersistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ULTRA
 */
public class ViajeJpaController implements Serializable {

    public ViajeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
      public ViajeJpaController(){
        this.emf = Persistence.createEntityManagerFactory("proyectoJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Viaje viaje) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viaje);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Viaje viaje) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viaje = em.merge(viaje);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viaje.getViajeID();
                if (findViaje(id) == null) {
                    throw new NonexistentEntityException("The viaje with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Viaje viaje;
            try {
                viaje = em.getReference(Viaje.class, id);
                viaje.getViajeID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viaje with id " + id + " no longer exists.", enfe);
            }
            em.remove(viaje);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Viaje> findViajeEntities() {
        return findViajeEntities(true, -1, -1);
    }

    public List<Viaje> findViajeEntities(int maxResults, int firstResult) {
        return findViajeEntities(false, maxResults, firstResult);
    }

    private List<Viaje> findViajeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Viaje.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Viaje findViaje(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Viaje.class, id);
        } finally {
            em.close();
        }
    }

    public int getViajeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Viaje> rt = cq.from(Viaje.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
