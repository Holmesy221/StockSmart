/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstockcontrolsystem;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import smartstockcontrolsystem.exceptions.NonexistentEntityException;

/**
 *
 * @author Holmesy
 */
public class StockreportJpaController implements Serializable {

    public StockreportJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Stockreport stockreport) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stockreport);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Stockreport stockreport) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stockreport = em.merge(stockreport);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = stockreport.getId();
                if (findStockreport(id) == null) {
                    throw new NonexistentEntityException("The stockreport with id " + id + " no longer exists.");
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
            Stockreport stockreport;
            try {
                stockreport = em.getReference(Stockreport.class, id);
                stockreport.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stockreport with id " + id + " no longer exists.", enfe);
            }
            em.remove(stockreport);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Stockreport> findStockreportEntities() {
        return findStockreportEntities(true, -1, -1);
    }

    public List<Stockreport> findStockreportEntities(int maxResults, int firstResult) {
        return findStockreportEntities(false, maxResults, firstResult);
    }

    private List<Stockreport> findStockreportEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Stockreport.class));
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

    public Stockreport findStockreport(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Stockreport.class, id);
        } finally {
            em.close();
        }
    }

    public int getStockreportCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Stockreport> rt = cq.from(Stockreport.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
