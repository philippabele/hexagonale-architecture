package com.daimler.dcp.clean.arc.demo.exercises.two.one;

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

public class ArchitectureTestExercise2_1 extends BaseArchUnitExerciseTest {

    @Test
    @DisplayName("VehicleController as adapter is located correctly and depends only on domain.model")
    void http_input_adapter_check() {
        //@TODO Improve with optional dependencies
        ArchRule rule = classes()
                .that()
                .haveSimpleName(CONTROLLER_UNDER_TEST)
                .should()
                .resideInAnyPackage(ADAPTER, ADAPTER_IN)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(DOMAIN, DOMAIN_MODEL, JAVA_LANG);
        rule.check(classes);
    }

}
