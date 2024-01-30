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
import logisticalogica.MantenimientoRealizado;
import logisticapersistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ULTRA
 */
public class MantenimientoRealizadoJpaController implements Serializable {

    public MantenimientoRealizadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public MantenimientoRealizadoJpaController(){
        this.emf = Persistence.createEntityManagerFactory("proyectoJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MantenimientoRealizado mantenimientoRealizado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mantenimientoRealizado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MantenimientoRealizado mantenimientoRealizado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mantenimientoRealizado = em.merge(mantenimientoRealizado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mantenimientoRealizado.getMantenimientoRealizadoID();
                if (findMantenimientoRealizado(id) == null) {
                    throw new NonexistentEntityException("The mantenimientoRealizado with id " + id + " no longer exists.");
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
            MantenimientoRealizado mantenimientoRealizado;
            try {
                mantenimientoRealizado = em.getReference(MantenimientoRealizado.class, id);
                mantenimientoRealizado.getMantenimientoRealizadoID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mantenimientoRealizado with id " + id + " no longer exists.", enfe);
            }
            em.remove(mantenimientoRealizado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MantenimientoRealizado> findMantenimientoRealizadoEntities() {
        return findMantenimientoRealizadoEntities(true, -1, -1);
    }

    public List<MantenimientoRealizado> findMantenimientoRealizadoEntities(int maxResults, int firstResult) {
        return findMantenimientoRealizadoEntities(false, maxResults, firstResult);
    }

    private List<MantenimientoRealizado> findMantenimientoRealizadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MantenimientoRealizado.class));
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

    public MantenimientoRealizado findMantenimientoRealizado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MantenimientoRealizado.class, id);
        } finally {
            em.close();
        }
    }

    public int getMantenimientoRealizadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MantenimientoRealizado> rt = cq.from(MantenimientoRealizado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
