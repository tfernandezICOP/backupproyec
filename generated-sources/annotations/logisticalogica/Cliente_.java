package logisticalogica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-26T18:46:05", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Long> nro_documento;
    public static volatile SingularAttribute<Cliente, Integer> clienteID;
    public static volatile SingularAttribute<Cliente, String> apellido;
    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile SingularAttribute<Cliente, Long> nro_telefono;
    public static volatile SingularAttribute<Cliente, String> correoElectronico;
    public static volatile SingularAttribute<Cliente, String> nombre;

}