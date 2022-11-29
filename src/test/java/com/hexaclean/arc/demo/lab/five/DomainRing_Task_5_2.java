package com.hexaclean.arc.demo.lab.five;

import com.hexaclean.arc.demo.lab.BaseArchUnitExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class DomainRing_Task_5_2 extends BaseArchUnitExerciseTest {

    public static final String VEHICLE_COMMAND_SERVICE = "VehicleCommandService";

    @Test
    @DisplayName("VehicleCommandService is located correctly and depends only on domain and usecase")
    void http_input_adapter_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(VEHICLE_COMMAND_SERVICE)
                .should()
                .resideInAnyPackage("..app.vehicle.domain.service..")
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(
                        "..app.vehicle.domain..",
                        "..app.vehicle.usecase..",
                        JAVA_LANG, JAVA_UTIL, ORG);
        rule.check(classes);
    }

    @Test
    @DisplayName("A usecase.out should be located in the correct package and depends only on domain.model")
    void usecase_in_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleName("VehicleCommand")
                .should()
                .resideInAnyPackage("..app.vehicle.usecase.in..")
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage("..app.vehicle.domain.model..");
        rule.check(classes);
    }

    @Test
    @DisplayName("A usecase.in should be implemented by a a domain service")
    void usecase_in_implementation_check() throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(VEHICLE_COMMAND_SERVICE)
                .and()
                .resideInAnyPackage("..app.vehicle.domain.service..")
                .should()
                .implement(Class.forName("com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleCommand"));
        rule.check(classes);
    }

}
