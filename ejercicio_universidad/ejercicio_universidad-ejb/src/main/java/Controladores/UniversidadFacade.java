package Controladores;

import Interfaces.UniversidadFacadeLocal;
import Default.AbstractFacade;
import Entity.Universidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * @author Cristian Roemro
 * @author Nathaly Salazar
 */
@Stateless
public class UniversidadFacade extends AbstractFacade<Universidad> implements UniversidadFacadeLocal {
    @PersistenceContext(unitName = "com.mycompany_ejercicio_universidad-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    /**
     * Entity Manager
     * @return EM
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    /**
     * EM
     */
    public UniversidadFacade() {
        super(Universidad.class);
    }
    /**
     * Metodo que valida registrar universidades
     * @param nombre
     * @return 
     */
    @Override
    public Universidad buscarNombre(String nombre){
        TypedQuery<Universidad> consulta = em.createNamedQuery("buscarNombreUniversidad", Universidad.class);
        consulta.setParameter("nombre", nombre);
        return consulta.getSingleResult();
    }
    
    
}
