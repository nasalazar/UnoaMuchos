package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @author Cristian Roemro
 * @author Nathaly Salazar
 */
@NamedQueries({
    @NamedQuery(name="buscarNombreUniversidad", query="SELECT uni FROM Universidad uni WHERE uni.nombre = :nombre")
})
@Entity
@Table(name= "universidad")
public class Universidad implements Serializable {
    /**
     * id universidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_uni")
    private int id;
    /**
     * nombre universidad
     */
    @Column(name="nombre_uni")
    private String nombre;
    /**
     * extension universidad
     */
    @Column(name="extension")
    private String extension;
    /**
     * Escudo universidad
     */
    @Column(name="escudo")
    private String escudo;
    /**
     * diplomado universidad
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universidad")
    private List<Diplomado> listaDiplomado;
    /**
     * Constructor
     * @param nombre
     * @param extension 
     */
    public Universidad(String nombre, String extension) {
        this.nombre = nombre;
        this.extension = extension;
    }
    /**
     * Constructor
     */
    public Universidad() {
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
     * set nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Get extension
     * @return 
     */
    public String getExtension() {
        return extension;
    }
    /**
     * Set extension
     * @param extension 
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }
    /**
     * Get escudo
     * @return 
     */
    public String getEscudo() {
        return escudo;
    }
    /**
     * Set escudo
     * @param escudo 
     */
    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }
    /**
     * Get diplomado
     * @return 
     */
    public List<Diplomado> getListaDiplomado() {
        return listaDiplomado;
    }
    /**
     * Set diplomado
     * @param listaDiplomado 
     */
    public void setListaDiplomado(List<Diplomado> listaDiplomado) {
        this.listaDiplomado = listaDiplomado;
    }
}
