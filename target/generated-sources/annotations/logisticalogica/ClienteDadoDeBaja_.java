package logisticalogica;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-12T18:58:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ClienteDadoDeBaja.class)
public class ClienteDadoDeBaja_ { 

    public static volatile SingularAttribute<ClienteDadoDeBaja, Long> nro_documento;
    public static volatile SingularAttribute<ClienteDadoDeBaja, Date> fechaDadoDeBaja;
    public static volatile SingularAttribute<ClienteDadoDeBaja, Integer> clienteID;
    public static volatile SingularAttribute<ClienteDadoDeBaja, String> apellido;
    public static volatile SingularAttribute<ClienteDadoDeBaja, String> direccion;
    public static volatile SingularAttribute<ClienteDadoDeBaja, Long> nro_telefono;
    public static volatile SingularAttribute<ClienteDadoDeBaja, String> correoElectronico;
    public static volatile SingularAttribute<ClienteDadoDeBaja, String> nombre;

}