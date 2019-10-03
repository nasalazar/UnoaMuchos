package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * @author Cristian Roemro
 * @author Nathaly Salazar
 */
@NamedQueries({
    @NamedQuery(name="buscarDiplomadoAsignado", query="SELECT est FROM Estudiante est WHERE est.nombre = :nombre")
})
@Entity
@Table
public class Estudiante implements Serializable {
    /**
     * id estudiante
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_est")
    private int id;
    /**
     * 
     */
    @Column(name="nombre_est")
    private String nombre;
    /**
     * cedula estudiante
     */
    @Column(name="cedula")
    private int cedula;
    /**
     * diplomado estudiante
     */
    @ManyToOne
    @JoinColumn(name = "id_dip", nullable = false)
    Diplomado diplomado;
    /**
     * Constructor
     */
    public Estudiante() {
    }
    /**
     * COnstructor
     * @param nombre
     * @param cedula
     * @param diplomado 
     */
    public Estudiante(String nombre, int cedula, Diplomado diplomado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.diplomado = diplomado;
    }
    /**
     * get id
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
     * Get nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Set nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Get cedula
     * @return 
     */
    public int getCedula() {
        return cedula;
    }
    /**
     * Set cedula
     * @param cedula 
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    /**
     * Get diplomado
     * @return 
     */
    public Diplomado getDiplomado() {
        return diplomado;
    }
    /**
     * Set diplomado
     * @param diplomado 
     */
    public void setDiplomado(Diplomado diplomado) {
        this.diplomado = diplomado;
    }
}
