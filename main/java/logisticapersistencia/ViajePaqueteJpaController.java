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
import logisticalogica.ViajePaquete;
import logisticapersistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ULTRA
 */
public class ViajePaqueteJpaController implements Serializable {

    public ViajePaqueteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public ViajePaqueteJpaController(){
        this.emf= Persistence.createEntityManagerFactory("proyectoJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViajePaquete viajePaquete) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viajePaquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViajePaquete viajePaquete) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viajePaquete = em.merge(viajePaquete);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viajePaquete.getViajePaqueteID();
                if (findViajePaquete(id) == null) {
                    throw new NonexistentEntityException("The viajePaquete with id " + id + " no longer exists.");
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
            ViajePaquete viajePaquete;
            try {
                viajePaquete = em.getReference(ViajePaquete.class, id);
                viajePaquete.getViajePaqueteID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viajePaquete with id " + id + " no longer exists.", enfe);
            }
            em.remove(viajePaquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViajePaquete> findViajePaqueteEntities() {
        return findViajePaqueteEntities(true, -1, -1);
    }

    public List<ViajePaquete> findViajePaqueteEntities(int maxResults, int firstResult) {
        return findViajePaqueteEntities(false, maxResults, firstResult);
    }

    private List<ViajePaquete> findViajePaqueteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViajePaquete.class));
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

    public ViajePaquete findViajePaquete(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViajePaquete.class, id);
        } finally {
            em.close();
        }
    }

    public int getViajePaqueteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViajePaquete> rt = cq.from(ViajePaquete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
