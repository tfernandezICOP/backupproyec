package logisticalogica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logisticalogica.Empleado;
import logisticalogica.Viaje;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-24T18:39:47", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(EmpleadoViaje.class)
public class EmpleadoViaje_ { 

    public static volatile SingularAttribute<EmpleadoViaje, Integer> empleadoViajeID;
    public static volatile SingularAttribute<EmpleadoViaje, Empleado> empleado;
    public static volatile SingularAttribute<EmpleadoViaje, Viaje> viaje;

}