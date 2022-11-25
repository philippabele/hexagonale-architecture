package com.hexaclean.arc.demo.exercises.three;


import com.hexaclean.arc.demo.exercises.BaseArchUnitExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;


public class MapperArchitectureTestExercise3 extends BaseArchUnitExerciseTest {

    @Test
    @DisplayName("A class *Mapper should reside in a package called 'adapter.out' or 'adapter' and should only access dto's (db entities) and domain models")
    void repository_check() {
        ArchRule rule = classes()
                .that()
                .haveSimpleNameEndingWith("Mapper")
                .should()
                .resideInAnyPackage(ADAPTER_OUT, ADAPTER)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(ADAPTER_OUT, ADAPTER, JAVA_LANG, JAVA_UTIL)
                .andShould()
                .dependOnClassesThat().haveSimpleName(VALUE_OBJECT_UNDER_TEST)
                .andShould()
                .dependOnClassesThat().haveSimpleName(ROOT_ENTITY_UNDER_TEST)
                .andShould()
                .dependOnClassesThat().haveSimpleName(DB_ENTITY_UNDER_TEST);
        rule.check(classes);
    }

}
