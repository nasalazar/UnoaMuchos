package Controlador;

import Interfaces.UniversidadFacadeLocal;
import Entity.Universidad;
import Pojo.UniversidadP;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
/**
 * @author Cristian Roemro
 * @author Nathaly Salazar
 */
@ManagedBean(name="controlU")
@ViewScoped
public class controladorUniversidad implements Serializable {
    /**
     * ejb universidad
     */
    @EJB
    private UniversidadFacadeLocal unifacade;
    /**
     * pojo universidad
     */
    private UniversidadP pojouni;
    /**
     * lista de universidades
     */
    private List<Universidad> listauni;
    /**
     * Constructor
     */
    public controladorUniversidad() {
    }
    /**
     * Instancias iniciadas
     */
    @PostConstruct
     public void iniciar(){
    pojouni = new UniversidadP();
    
    listauni = new ArrayList();
    }
     /**
      * Get interface unviersidad
      * @return 
      */
    public UniversidadFacadeLocal getUnifacade() {
        return unifacade;
    }
    /**
     * Set interface niversidad
     * @param unifacade 
     */
    public void setUnifacade(UniversidadFacadeLocal unifacade) {
        this.unifacade = unifacade;
    }
    /**
     * Get pojo
     * @return 
     */
    public UniversidadP getPojouni() {
        return pojouni;
    }
    /**
     * Set pojo
     * @param pojouni 
     */
    public void setPojouni(UniversidadP pojouni) {
        this.pojouni = pojouni;
    }
    /**
     * Get lista unviersidades
     * @return 
     */
    public List<Universidad> getListauni() {
        return listauni;
    }
    /**
     * Set lista universidades
     * @param listauni 
     */
    public void setListauni(List<Universidad> listauni) {
        this.listauni = listauni;
    }
    /**
     * Metodo que crea una universidad
     */
    public void crearUniversidad(){
        
    Universidad uni = new Universidad(pojouni.getNombre(),pojouni.getExtension());    
        try{
            Universidad uniTemporal = unifacade.buscarNombre(uni.getNombre());
            if(uniTemporal!=null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atencion", "La universidad "+ uniTemporal.getNombre() +" ya existe, pruebe con otra"));            
            }else{
                unifacade.create(uni);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atencion", "La universidad "+ uniTemporal.getNombre() +" ya existe, pruebe con otra"));            
        }catch(Exception e){
            unifacade.create(uni);
        }

    }
    /**
     * Redireccion
     * @return 
     */
    public List<Universidad> listaUniversidad(){
        listauni = unifacade.findAll();
       
        return listauni;
    }
    /**
     * Redireccion
     * @return 
     */
    public String redireccionEstudiante(){
        return "estudiante.xhtml";    
    }
    /**
     * Redireccion
     * @return 
     */
    public String redireccionDiplomado(){
        return "diplomado.xhtml";    
    }
    /**
     * Redireccion
     * @return 
     */
    public String redireccionUniversidad(){
        return "index.xhtml";    
    }
}
