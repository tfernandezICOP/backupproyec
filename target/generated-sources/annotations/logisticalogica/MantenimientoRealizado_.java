package logisticalogica;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logisticalogica.Vehiculo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-12T18:58:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(MantenimientoRealizado.class)
public class MantenimientoRealizado_ { 

    public static volatile SingularAttribute<MantenimientoRealizado, Integer> mantenimientoRealizadoID;
    public static volatile SingularAttribute<MantenimientoRealizado, Integer> kmMantenimiento;
    public static volatile SingularAttribute<MantenimientoRealizado, Vehiculo> vehiculo;
    public static volatile SingularAttribute<MantenimientoRealizado, Date> fechaMantenimiento;

}