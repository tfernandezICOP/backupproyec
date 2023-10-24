package logisticalogica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logisticalogica.Marca;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-24T18:39:47", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, Integer> capacidad_carga;
    public static volatile SingularAttribute<Vehiculo, Integer> nro_vehiculo;
    public static volatile SingularAttribute<Vehiculo, Marca> marca;
    public static volatile SingularAttribute<Vehiculo, Integer> vehiculoID;
    public static volatile SingularAttribute<Vehiculo, Integer> patente;

}