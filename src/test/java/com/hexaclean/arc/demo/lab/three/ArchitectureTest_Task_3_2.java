package com.hexaclean.arc.demo.lab.three;


import com.hexaclean.arc.demo.lab.BaseArchUnitExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;


public class ArchitectureTest_Task_3_2 extends BaseArchUnitExerciseTest {

    @Test
    @DisplayName("A Mapper should reside in a package called 'adapter.out' or 'adapter' and should only access dto's (db entities) and domain models")
    void repository_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleNameEndingWith("VehicleToVehicleDbEntityMapper")
                .should()
                .resideInAnyPackage(ADAPTER_OUT, ADAPTER)
                .andShould()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "..vehicle.domain..",
                        "..vehicle.domain.model..",
                        "..vehicle.adapter..",
                        "..vehicle.adapter.out..",
                        "..vehicle.usecase..",
                        "..vehicle.usecase.out..",
                        JAVA_LANG,
                        JAVA_UTIL,
                        ORG);
        rule.check(classes);
    }

}
