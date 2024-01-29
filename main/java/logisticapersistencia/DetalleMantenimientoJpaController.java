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
import logisticalogica.DetalleMantenimiento;
import logisticapersistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ULTRA
 */
public class DetalleMantenimientoJpaController implements Serializable {

    public DetalleMantenimientoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
     public DetalleMantenimientoJpaController(){
    this.emf = Persistence.createEntityManagerFactory("proyectoJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleMantenimiento detalleMantenimiento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detalleMantenimiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleMantenimiento detalleMantenimiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detalleMantenimiento = em.merge(detalleMantenimiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detalleMantenimiento.getDetalleMantenimientoID();
                if (findDetalleMantenimiento(id) == null) {
                    throw new NonexistentEntityException("The detalleMantenimiento with id " + id + " no longer exists.");
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
            DetalleMantenimiento detalleMantenimiento;
            try {
                detalleMantenimiento = em.getReference(DetalleMantenimiento.class, id);
                detalleMantenimiento.getDetalleMantenimientoID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleMantenimiento with id " + id + " no longer exists.", enfe);
            }
            em.remove(detalleMantenimiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleMantenimiento> findDetalleMantenimientoEntities() {
        return findDetalleMantenimientoEntities(true, -1, -1);
    }

    public List<DetalleMantenimiento> findDetalleMantenimientoEntities(int maxResults, int firstResult) {
        return findDetalleMantenimientoEntities(false, maxResults, firstResult);
    }

    private List<DetalleMantenimiento> findDetalleMantenimientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleMantenimiento.class));
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

    public DetalleMantenimiento findDetalleMantenimiento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleMantenimiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleMantenimientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleMantenimiento> rt = cq.from(DetalleMantenimiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
