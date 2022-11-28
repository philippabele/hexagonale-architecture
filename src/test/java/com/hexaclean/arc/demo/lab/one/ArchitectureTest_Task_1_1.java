package com.hexaclean.arc.demo.lab.one;


import com.hexaclean.arc.demo.lab.BaseArchUnitExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest_Task_1_1 extends BaseArchUnitExerciseTest {

    @Test
    @DisplayName("The Vehicle should reside in a package called 'domain' or 'domain.model' and should only access classes of the same package.")
    void root_entity_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(ROOT_ENTITY_UNDER_TEST)
                .and()
                .resideInAnyPackage(VEHICLE_DOMAIN_MODEL, VEHICLE_DOMAIN)
                .should()
                .onlyAccessClassesThat()
                .resideInAnyPackage(IO_GITHUB_DOMAINPRIMITIVES, VEHICLE_DOMAIN, VEHICLE_DOMAIN_MODEL, JAVA_LANG, JAVA_UTIL)
                .andShould()
                .dependOnClassesThat()
                .haveSimpleName(VALUE_OBJECT_UNDER_TEST);
        rule.check(classes);
    }

    @Test
    @DisplayName("The Vin should reside in a package called 'domain' or 'domain.model' and should not depend on other classes.")
    void value_object_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(VALUE_OBJECT_UNDER_TEST)
                .and().resideInAnyPackage(VEHICLE_DOMAIN_MODEL, VEHICLE_DOMAIN)
                .should()
                .onlyAccessClassesThat()
                .resideInAnyPackage(IO_GITHUB_DOMAINPRIMITIVES, JAVA_LANG, JAVA_UTIL, VEHICLE_DOMAIN, VEHICLE_DOMAIN_MODEL);
        rule.check(classes);
    }

}
