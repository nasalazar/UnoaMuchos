package Entity;

import Entity.Estudiante;
import Entity.Universidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-02T22:49:08")
@StaticMetamodel(Diplomado.class)
public class Diplomado_ { 

    public static volatile SingularAttribute<Diplomado, String> duracion;
    public static volatile SingularAttribute<Diplomado, Universidad> universidad;
    public static volatile ListAttribute<Diplomado, Estudiante> listaEstudiante;
    public static volatile SingularAttribute<Diplomado, Integer> id;
    public static volatile SingularAttribute<Diplomado, String> nombre;

}