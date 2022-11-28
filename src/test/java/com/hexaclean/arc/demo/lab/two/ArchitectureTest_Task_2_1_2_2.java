package com.hexaclean.arc.demo.lab.two;

import com.hexaclean.arc.demo.lab.BaseArchUnitExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest_Task_2_1_2_2 extends BaseArchUnitExerciseTest {

    @Test
    @DisplayName("VehicleController is located correctly and depends only on domain, domain.model as well as ? <insert here>")
    void http_input_adapter_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(CONTROLLER_UNDER_TEST)
                .should()
                .resideInAnyPackage(ADAPTER, ADAPTER_IN)
                .andShould()
                .onlyAccessClassesThat()
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
                .and()
                .resideInAnyPackage("..app.vehicle.domain.service..", "..app.vehicle.domain..")
                .should()
                .implement(Class.forName("com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery"));
        rule.check(classes);
    }

}
