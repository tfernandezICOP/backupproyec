package logisticalogica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logisticalogica.MantenimientoRealizado;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-12T18:58:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(DetalleMantenimiento.class)
public class DetalleMantenimiento_ { 

    public static volatile SingularAttribute<DetalleMantenimiento, String> tipoServicio;
    public static volatile SingularAttribute<DetalleMantenimiento, MantenimientoRealizado> mantenimientoRealizado;
    public static volatile SingularAttribute<DetalleMantenimiento, Integer> detalleMantenimientoID;

}