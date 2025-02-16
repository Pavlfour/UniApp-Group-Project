package uniapp.utils;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uniapp.utils.University;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-16T11:17:43", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile ListAttribute<Country, University> universityList;
    public static volatile SingularAttribute<Country, String> countryCode;
    public static volatile SingularAttribute<Country, String> name;

}