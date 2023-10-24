package logisticalogica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logisticalogica.Paquete;
import logisticalogica.Viaje;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-24T18:39:47", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ViajePaquete.class)
public class ViajePaquete_ { 

    public static volatile SingularAttribute<ViajePaquete, Integer> viajePaqueteID;
    public static volatile SingularAttribute<ViajePaquete, Viaje> viaje;
    public static volatile SingularAttribute<ViajePaquete, Paquete> paquete;

}