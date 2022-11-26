package com.hexaclean.arc.demo.lab.one;


import com.hexaclean.arc.demo.lab.BaseArchUnitExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest_Task_1_2 extends BaseArchUnitExerciseTest {

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
