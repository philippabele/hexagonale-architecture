package com.daimler.dcp.clean.arc.demo.exercises.one;


import com.daimler.dcp.clean.arc.demo.exercises.BaseArchUnitExerciseTest;
import com.daimler.dcp.clean.arc.demo.exercises.BaseExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTestExercise1 extends BaseArchUnitExerciseTest {

    @Test
    @DisplayName("The Vehicle should reside in a package called 'domain' or 'domain.model' and should only access classes of the same package.")
    void root_entity_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(ROOT_ENTITY_UNDER_TEST)
                .should()
                .resideInAnyPackage(DOMAIN, DOMAIN_MODEL)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(DOMAIN_MODEL, JAVA_LANG, JAVA_UTIL)
                .andShould()
                .dependOnClassesThat().haveSimpleName(VALUE_OBJECT_UNDER_TEST);
        rule.check(classes);
    }

    @Test
    @DisplayName("The Vin should reside in a package called 'domain' or 'domain.model' and should not depend on other classes.")
    void value_object_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(VALUE_OBJECT_UNDER_TEST)
                .should()
                .resideInAnyPackage(DOMAIN, DOMAIN_MODEL)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(JAVA_LANG, JAVA_UTIL, DOMAIN, DOMAIN_MODEL);
        rule.check(classes);
    }

    @Test
    @DisplayName("The VehicleService should reside in a package called 'domain' or 'domain.service' and should only depend on classes that reside in a package called 'domain' and 'domain.model'")
    void service_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(SERVICE_UNDER_TEST)
                .should()
                .resideInAnyPackage(DOMAIN, DOMAIN_SERVICE)
                .andShould()
                .dependOnClassesThat()
                .resideInAnyPackage(DOMAIN, DOMAIN_MODEL, JAVA_LANG, JAVA_UTIL);
        rule.check(classes);
    }
}
