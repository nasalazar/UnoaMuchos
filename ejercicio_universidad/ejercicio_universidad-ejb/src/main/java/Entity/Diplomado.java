package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @author Cristian Roemro
 * @author Nathaly Salazar
 */
@NamedQueries({
    @NamedQuery(name="buscarUniversidadAsignada", query="SELECT dip FROM Diplomado dip WHERE dip.nombre = :nombre")
})
@Entity
@Table
public class Diplomado implements Serializable {
    /**
     * id de diplomado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_dip")
    private int id;
    /**
     * nombre de diplomado
     */
    @Column(name="nombre_dip")
    private String nombre;
    /**
     * duracion de diplomado
     */
    @Column(name="duracion")
    private String duracion;
    /**
     * Relacion muchos a uno contra universidad
     */
    @ManyToOne
    @JoinColumn(name = "id_uni", nullable = false)
    private Universidad universidad;
    /**
     * Relacion uno a muchos con estudiante
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diplomado")
    private List<Estudiante> listaEstudiante;
    /**
     * Constructor
     * @param nombre
     * @param duracion
     * @param universidad 
     */
    public Diplomado(String nombre, String duracion, Universidad universidad) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.universidad = universidad;
    }
    /**
     * Constructor
     */
    public Diplomado() {
    }
    /**
     * Get id
     * @return 
     */
    public int getId() {
        return id;
    }
    /**
     * Set id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * get id
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Set id
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Get duracion
     * @return 
     */
    public String getDuracion() {
        return duracion;
    }
    /**
     * Set duracion
     * @param duracion 
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    /**
     * Get universidad
     * @return 
     */
    public Universidad getUniversidad() {
        return universidad;
    }
    /**
     * Set universidad
     * @param universidad 
     */
    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
    /**
     * Get estudiantes
     * @return 
     */
    public List<Estudiante> getListaEstudiante() {
        return listaEstudiante;
    }
    /**
     * Set estudiantes
     * @param listaEstudiante 
     */
    public void setListaEstudiante(List<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }
}
