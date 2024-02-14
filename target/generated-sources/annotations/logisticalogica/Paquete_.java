package logisticalogica;

import java.sql.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logisticalogica.Cliente;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-12T18:58:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Paquete.class)
public class Paquete_ { 

    public static volatile SingularAttribute<Paquete, String> descripcion;
    public static volatile SingularAttribute<Paquete, String> estado;
    public static volatile SingularAttribute<Paquete, Integer> paqueteID;
    public static volatile SingularAttribute<Paquete, Cliente> receptor;
    public static volatile SingularAttribute<Paquete, Date> fechaRecibido;
    public static volatile SingularAttribute<Paquete, Integer> codigo_paquete;
    public static volatile SingularAttribute<Paquete, String> domicilioEntrega;
    public static volatile SingularAttribute<Paquete, Date> fechaEntrega;
    public static volatile SingularAttribute<Paquete, Cliente> emisor;

}