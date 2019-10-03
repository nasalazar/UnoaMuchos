package Controladores;

import Interfaces.EstudianteFacadeLocal;
import Default.AbstractFacade;
import Entity.Estudiante;
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
public class EstudianteFacade extends AbstractFacade<Estudiante> implements EstudianteFacadeLocal {
    @PersistenceContext(unitName = "com.mycompany_ejercicio_universidad-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    /**
     * Entity Manager abierto
     * @return Entity Manager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    /**
     * EM
     */
    public EstudianteFacade() {
        super(Estudiante.class);
    }
    /**
     * Consulta una lista de estudiantes que ya han sido asignados a un diplomado
     * @param dip
     * @return Lista de estudiantes
     */
    @Override
    public List<Estudiante> consultaDiplomado(String dip) {
        TypedQuery<Estudiante> consulta = em.createNamedQuery("buscarDiplomadoAsignado",Estudiante.class);
        consulta.setParameter("nombre", dip);
        return consulta.getResultList();
    }
    
}
