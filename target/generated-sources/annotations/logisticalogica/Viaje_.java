package logisticalogica;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logisticalogica.Vehiculo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-12T18:58:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Viaje.class)
public class Viaje_ { 

    public static volatile SingularAttribute<Viaje, Integer> viajeID;
    public static volatile SingularAttribute<Viaje, Date> fecha;
    public static volatile SingularAttribute<Viaje, String> destino;
    public static volatile SingularAttribute<Viaje, String> origen;
    public static volatile SingularAttribute<Viaje, Vehiculo> vehiculo;

}