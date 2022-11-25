package com.daimler.dcp.clean.arc.demo.exercises.two.two;

import com.daimler.dcp.clean.arc.demo.exercises.BaseArchUnitExerciseTest;
import com.daimler.dcp.clean.arc.demo.exercises.BaseExerciseTest;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;


public class ArchitectureTestExercise2_2 extends BaseArchUnitExerciseTest {

    @Test
    @DisplayName("A adapter in is only allowed to depend on a usecase.in and domain.model")
    void adapter_in_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(CONTROLLER_UNDER_TEST)
                .should()
                .resideInAnyPackage(ADAPTER, ADAPTER_IN)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(DOMAIN, DOMAIN_MODEL, USECASE, USECASE_IN, JAVA_LANG, ADAPTER, ADAPTER_IN);
        rule.check(classes);
    }

    @Test
    @DisplayName("A usecase.in should be located in the correct package and depends only on domain.model")
    void usecase_in_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(USECASE_IN_QUERY_UNDER_TEST)
                .should()
                .resideInAnyPackage(USECASE, USECASE_IN)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(DOMAIN, DOMAIN_MODEL);
        rule.check(classes);
    }

    @Test
    @DisplayName("A usecase.in should be implemented by a a domain service")
    void usecase_in_implementation_check() throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(SERVICE_UNDER_TEST)
                .should()
                .implement(Class.forName("com.daimler.dcp.clean.arc.demo.vehicle.usecase.in.VehicleQuery"));
        rule.check(classes);
    }

}
