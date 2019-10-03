package Default;

import java.util.List;
import javax.persistence.EntityManager;
/**
 * @author Cristian Roemro
 * @author Nathaly Salazar
 * @param <T>
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;
    /**
     * Metodo por defecto 
     * @param entityClass
     */
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    /**
     * Metodo por defecto 
     * @return 
     */
    protected abstract EntityManager getEntityManager();
    /**
     * Metodo por defecto 
     * @param entity
     */
    public void create(T entity) {
        getEntityManager().persist(entity);
    }
    /**
     * Metodo por defecto 
     * @param entity
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }
    /**
     * Metodo por defecto 
     * @param entity
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    /**
     * Metodo por defecto 
     * @param id
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    /**
     * Metodo por defecto 
     * @return 
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
   /**
     * Metodo por defecto 
     * @param range
     * @return 
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    /**
     * Metodo por defecto 
     * @return 
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
