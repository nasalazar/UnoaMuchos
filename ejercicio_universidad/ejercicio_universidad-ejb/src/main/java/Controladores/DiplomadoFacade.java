package Controladores;

import Interfaces.DiplomadoFacadeLocal;
import Default.AbstractFacade;
import Entity.Diplomado;
import Entity.Universidad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * @author Cristian Roemro
 * @author Nathaly Salazar
 */
@Stateless
public class DiplomadoFacade extends AbstractFacade<Diplomado> implements DiplomadoFacadeLocal {
    @PersistenceContext(unitName = "com.mycompany_ejercicio_universidad-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    /**
     * Entity Manager abierto
     * @return 
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    /**
     * EM
     */
    public DiplomadoFacade() {
        super(Diplomado.class);
    }
    /**
     * ¨Metodo que trae de BD una lista de universidades ya asignadas con un diplomado
     * @param uni
     * @param nombre
     * @return Lista de Diplomados
     */
    @Override
    public List<Diplomado> validaUniversidadAsignada(Universidad uni, String nombre) {
        TypedQuery<Diplomado> consulta = em.createNamedQuery("buscarUniversidadAsignada",Diplomado.class);
        consulta.setParameter("nombre", nombre);
        return consulta.getResultList();
    }
    
}
