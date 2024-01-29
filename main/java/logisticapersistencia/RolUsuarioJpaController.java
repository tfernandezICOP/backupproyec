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
import logisticalogica.RolUsuario;
import logisticapersistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author ULTRA
 */
public class RolUsuarioJpaController implements Serializable {

    public RolUsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
     public RolUsuarioJpaController(){
        this.emf = Persistence.createEntityManagerFactory("proyectoJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RolUsuario rolUsuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(rolUsuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RolUsuario rolUsuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            rolUsuario = em.merge(rolUsuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rolUsuario.getRolUsuarioID();
                if (findRolUsuario(id) == null) {
                    throw new NonexistentEntityException("The rolUsuario with id " + id + " no longer exists.");
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
            RolUsuario rolUsuario;
            try {
                rolUsuario = em.getReference(RolUsuario.class, id);
                rolUsuario.getRolUsuarioID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rolUsuario with id " + id + " no longer exists.", enfe);
            }
            em.remove(rolUsuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RolUsuario> findRolUsuarioEntities() {
        return findRolUsuarioEntities(true, -1, -1);
    }

    public List<RolUsuario> findRolUsuarioEntities(int maxResults, int firstResult) {
        return findRolUsuarioEntities(false, maxResults, firstResult);
    }

    private List<RolUsuario> findRolUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RolUsuario.class));
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

    public RolUsuario findRolUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RolUsuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RolUsuario> rt = cq.from(RolUsuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
