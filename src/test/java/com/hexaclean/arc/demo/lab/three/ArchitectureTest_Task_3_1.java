package com.hexaclean.arc.demo.lab.three;


import com.hexaclean.arc.demo.lab.BaseArchUnitExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;


public class ArchitectureTest_Task_3_1 extends BaseArchUnitExerciseTest {

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

}
