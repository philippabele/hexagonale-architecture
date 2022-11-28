package com.hexaclean.arc.demo.lab.three;


import com.hexaclean.arc.demo.lab.BaseArchUnitExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;


public class ArchitectureTest_Task_3_3 extends BaseArchUnitExerciseTest {

    @Test
    @DisplayName("A Mapper should reside in a package called 'adapter.in' or 'adapter' and should only access dto's (resources) and domain models")
    void repository_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleNameEndingWith("VehicleToVehicleResourceMapper")
                .should()
                .resideInAnyPackage(ADAPTER_IN, ADAPTER)
                .andShould()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "..vehicle.domain..",
                        "..vehicle.domain.model..",
                        "..vehicle.adapter..",
                        "..vehicle.adapter.in..",
                        "..vehicle.usecase..",
                        "..vehicle.usecase.in..",
                        JAVA_LANG,
                        JAVA_UTIL,
                        ORG);
        rule.check(classes);
    }

}
