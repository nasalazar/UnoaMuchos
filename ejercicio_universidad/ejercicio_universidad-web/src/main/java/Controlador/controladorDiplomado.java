
package Controlador;

import Interfaces.DiplomadoFacadeLocal;
import Interfaces.UniversidadFacadeLocal;
import Entity.Diplomado;
import Entity.Universidad;
import Pojo.DiplomadoP;
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
@ManagedBean(name="controlD")
@ViewScoped
public class controladorDiplomado implements Serializable {
    /**
     * ejb doplomado
     */
    @EJB
    private DiplomadoFacadeLocal diplofacade;
    /**
     * ejb universidad
     */
    @EJB
    private UniversidadFacadeLocal unifacade;
    /**
     * Pojo diplomado
     */
    private DiplomadoP pojodiplo;
    /**
     * Lista de diplomados
     */
    private List<Diplomado> listadiplo;
    
    /**
     * Constructor
     */
    public controladorDiplomado() {
    }
    /**
     * inicio instancias
     */
    @PostConstruct
    public void iniciar(){
        pojodiplo = new DiplomadoP();
        listadiplo = new ArrayList();
       
    }
    /**
     * get interface diplomado
     * @return 
     */
    public DiplomadoFacadeLocal getDiplofacade() {
        return diplofacade;
    }
    /**
     * Set diplomado interface
     * @param diplofacade 
     */
    public void setDiplofacade(DiplomadoFacadeLocal diplofacade) {
        this.diplofacade = diplofacade;
    }
    /**
     * Get universidad interface
     * @return 
     */
    public UniversidadFacadeLocal getUnifacade() {
        return unifacade;
    }
    /**
     * Set universidad interface
     * @param unifacade 
     */
    public void setUnifacade(UniversidadFacadeLocal unifacade) {
        this.unifacade = unifacade;
    }
    /**
     * Get del pojo diplomado
     * @return 
     */
    public DiplomadoP getPojodiplo() {
        return pojodiplo;
    }
    /**
     * Set pojo diplomado
     * @param pojodiplo 
     */
    public void setPojodiplo(DiplomadoP pojodiplo) {
        this.pojodiplo = pojodiplo;
    }
    /**
     * Get lista diplomados
     * @return 
     */
    public List<Diplomado> getListadiplo() {
        return listadiplo;
    }
    /**
     * Set lista diplomados
     * @param listadiplo 
     */
    public void setListadiplo(List<Diplomado> listadiplo) {
        this.listadiplo = listadiplo;
    }
    /**
     * Metodo que crea un diplomado
     */
    public void crearDiplomado(){
        Universidad uni = unifacade.find(pojodiplo.getId_uni());
        Diplomado dip = new Diplomado(pojodiplo.getNombre(),pojodiplo.getDuracion(),uni);
        try
        {
            List<Diplomado> diploTemporal = diplofacade.validaUniversidadAsignada(uni,pojodiplo.getNombre());
            if(diploTemporal.isEmpty()){
                diplofacade.create(dip);
            }else{
                for(Diplomado d:diploTemporal){
                    if(d.getNombre().equals(pojodiplo.getNombre())){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No permitido", "El diplomado que usted intenta asignar '"
                        + dip.getNombre() +"', ya existe"));
                        break;
                    }else{
                        diplofacade.create(dip);
                        break;
                    }
                }
            }

        }catch(Exception e){
            diplofacade.create(dip);   
        }
    }
    /**
     * Metodo que lista los diplomados
     * @return 
     */
    public List<Diplomado> listaDiplomados(){
        listadiplo = diplofacade.findAll();
       
        return listadiplo;
    }
    /**
     * redireccionm
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
     * redireccion
     * @return 
     */
    public String redireccionUniversidad(){
        return "index.xhtml";    
    }
}
