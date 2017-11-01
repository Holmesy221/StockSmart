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
public class StockorderJpaController implements Serializable {

    public StockorderJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Stockorder stockorder) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stockorder);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Stockorder stockorder) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stockorder = em.merge(stockorder);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = stockorder.getId();
                if (findStockorder(id) == null) {
                    throw new NonexistentEntityException("The stockorder with id " + id + " no longer exists.");
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
            Stockorder stockorder;
            try {
                stockorder = em.getReference(Stockorder.class, id);
                stockorder.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stockorder with id " + id + " no longer exists.", enfe);
            }
            em.remove(stockorder);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Stockorder> findStockorderEntities() {
        return findStockorderEntities(true, -1, -1);
    }

    public List<Stockorder> findStockorderEntities(int maxResults, int firstResult) {
        return findStockorderEntities(false, maxResults, firstResult);
    }

    private List<Stockorder> findStockorderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Stockorder.class));
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

    public Stockorder findStockorder(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Stockorder.class, id);
        } finally {
            em.close();
        }
    }

    public int getStockorderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Stockorder> rt = cq.from(Stockorder.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
