package logisticalogica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logisticalogica.Empleado;
import logisticalogica.Viaje;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-26T18:46:05", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(EmpleadoViaje.class)
public class EmpleadoViaje_ { 

    public static volatile SingularAttribute<EmpleadoViaje, Integer> empleadoViajeID;
    public static volatile SingularAttribute<EmpleadoViaje, Empleado> empleado;
    public static volatile SingularAttribute<EmpleadoViaje, Viaje> viaje;

}