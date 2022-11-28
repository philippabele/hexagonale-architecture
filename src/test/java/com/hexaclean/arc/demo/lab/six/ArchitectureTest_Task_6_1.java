package com.hexaclean.arc.demo.lab.six;

import com.hexaclean.arc.demo.lab.BaseArchUnitExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest_Task_6_1 extends BaseArchUnitExerciseTest {

    @Test
    @DisplayName("A usecase.in should be implemented by a a domain service")
    void usecase_in_implementation_check() throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(SERVICE_UNDER_TEST)
                .and()
                .resideInAnyPackage("..app.vehicle.domain.service..", "..app.vehicle.domain..")
                .should()
                .implement(Class.forName("com.hexaclean.arc.demo.app.vehicle.usecase.in.FindVehicleByLicensePlate"));
        rule.check(classes);
    }

}
