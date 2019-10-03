package Entity;

import Entity.Diplomado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-02T22:49:08")
@StaticMetamodel(Universidad.class)
public class Universidad_ { 

    public static volatile SingularAttribute<Universidad, String> extension;
    public static volatile ListAttribute<Universidad, Diplomado> listaDiplomado;
    public static volatile SingularAttribute<Universidad, String> escudo;
    public static volatile SingularAttribute<Universidad, Integer> id;
    public static volatile SingularAttribute<Universidad, String> nombre;

}