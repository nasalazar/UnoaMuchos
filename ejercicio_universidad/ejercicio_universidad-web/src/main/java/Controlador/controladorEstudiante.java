package Controlador;

import Interfaces.DiplomadoFacadeLocal;
import Interfaces.EstudianteFacadeLocal;
import Entity.Diplomado;
import Entity.Estudiante;
import Pojo.EstudianteP;
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
@ManagedBean(name="controlE")
@ViewScoped
public class controladorEstudiante {
    /**
     * ejb diplomado
     */
    @EJB
    private DiplomadoFacadeLocal diplofacade;
    /**
     * ejb estudiante
     */
    @EJB
    private EstudianteFacadeLocal estudiantefacade;
    /**
     * pojo estudiante
     */
    private EstudianteP pojoestudiante;
    /**
     * lista estudantes
     */
    private List<Estudiante>listaestu;
    /**
     * construcor
     */
    public controladorEstudiante() {
    }
    /**
     * instancias iniciadas
     */
    @PostConstruct
    public void inicio(){
      pojoestudiante = new EstudianteP();
      listaestu = new ArrayList();
    }
    /**
     * get interface diplomado
     * @return 
     */
    public DiplomadoFacadeLocal getDiplofacade() {
        return diplofacade;
    }
    /**
     * set diplomado interfaces
     * @param diplofacade 
     */
    public void setDiplofacade(DiplomadoFacadeLocal diplofacade) {
        this.diplofacade = diplofacade;
    }
    /**
     * get estudiante interface
     * @return 
     */
    public EstudianteFacadeLocal getEstudiantefacade() {
        return estudiantefacade;
    }
    /**
     * set estudiante interfaces
     * @param estudiantefacade 
     */
    public void setEstudiantefacade(EstudianteFacadeLocal estudiantefacade) {
        this.estudiantefacade = estudiantefacade;
    }
    /**
     * Get pojo estudiante
     * @return 
     */
    public EstudianteP getPojoestudiante() {
        return pojoestudiante;
    }
    /**
     * set estudiante pojo
     * @param pojoestudiante 
     */
    public void setPojoestudiante(EstudianteP pojoestudiante) {
        this.pojoestudiante = pojoestudiante;
    }
    /**
     * Get lista de estuantes
     * @return 
     */
    public List<Estudiante> getListaestu() {
        return listaestu;
    }
    /**
     * Set lista de estudiantes
     * @param listaestu 
     */
    public void setListaestu(List<Estudiante> listaestu) {
        this.listaestu = listaestu;
    }
    /**
     * Crea un estudiante
     */
    public void crearEstudiante(){
        
        Diplomado dip = diplofacade.find(pojoestudiante.getId_dip());
        Estudiante est = new Estudiante(pojoestudiante.getNombre(),pojoestudiante.getCedula(),dip);
        try
        {
            List<Estudiante> estTemporal = estudiantefacade.consultaDiplomado(pojoestudiante.getNombre());
            if(estTemporal.isEmpty()){
                estudiantefacade.create(est);
            }else{
                for(Estudiante d:estTemporal){
                    if(d.getNombre().equals(pojoestudiante.getNombre())){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No permitido", "El estudiante que usted intenta asignar '"
                        + dip.getNombre() +"', ya existe"));
                        break;
                    }else{
                        estudiantefacade.create(est);
                        break;
                    }
                }
            }

        }catch(Exception e){
            estudiantefacade.create(est);   
        }
    }
    /**
     * Lista estudiantes
     * @return 
     */
    public List<Estudiante>listarEstudiante(){
        
        listaestu = estudiantefacade.findAll();
        return listaestu;
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
