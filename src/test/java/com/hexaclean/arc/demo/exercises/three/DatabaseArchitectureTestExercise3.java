package com.hexaclean.arc.demo.exercises.three;


import com.hexaclean.arc.demo.exercises.BaseArchUnitExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;


public class DatabaseArchitectureTestExercise3 extends BaseArchUnitExerciseTest {

    @Test
    @DisplayName("The VehicleDbEntity should reside in a package called 'adapter.out' or 'adapter' and should only access db entities of the same package.")
    void db_entity_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(DB_ENTITY_UNDER_TEST)
                .should()
                .resideInAnyPackage(ADAPTER_OUT, ADAPTER)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(ADAPTER_OUT, ADAPTER, JAVA_LANG, JAVA_UTIL, ORG);
        rule.check(classes);
    }

    @Test
    @DisplayName("The VehicleRepository should reside in a package called 'adapter.out' or 'adapter' and should only access classes of the same package, outgoing use cases and domain models")
    void repository_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(REPOSITORY_UNDER_TEST)
                .should()
                .resideInAnyPackage(ADAPTER_OUT, ADAPTER)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(USECASE_OUT, DOMAIN, USECASE, DOMAIN_MODEL, ADAPTER_OUT, ADAPTER, JAVA_LANG, JAVA_UTIL, ORG)
                .andShould()
                .dependOnClassesThat().haveSimpleName(DB_ENTITY_UNDER_TEST)
                .andShould()
                .dependOnClassesThat().haveSimpleName(ROOT_ENTITY_UNDER_TEST);
        rule.check(classes);
    }

}
