package com.hexaclean.arc.demo.exercises.two.one;

import com.hexaclean.arc.demo.exercises.BaseArchUnitExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTestExercise2_1 extends BaseArchUnitExerciseTest {

    @Test
    @DisplayName("VehicleController is located correctly and depends only on domain, domain.model as well as ? <insert here>")
    void http_input_adapter_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(CONTROLLER_UNDER_TEST)
                .should()
                .resideInAnyPackage(ADAPTER, ADAPTER_IN)
                .andShould()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        DOMAIN,
                        DOMAIN_MODEL,
                        USECASE_IN,
                        USECASE,
                        ORG,
                        JAVA_LANG,
                        ADAPTER,
                        ADAPTER_IN);
        rule.check(classes);
    }

}
