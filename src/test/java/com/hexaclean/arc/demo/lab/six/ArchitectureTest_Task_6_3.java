package com.hexaclean.arc.demo.lab.six;

import com.hexaclean.arc.demo.lab.BaseArchUnitExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest_Task_6_3 extends BaseArchUnitExerciseTest {

    public static final String PARTS_CATALOGUE_APPSERVICE = "..parts.catalogue.appservice..";

    @Test
    @DisplayName("application service pattern between parts catalogue and vehicle")
    void application_service_mapper_check() throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName("VehicleToOriginVehicleMapper")
                .and()
                .resideInAnyPackage(PARTS_CATALOGUE_APPSERVICE)
                .should()
                .onlyAccessClassesThat()
                .resideInAnyPackage(PARTS_CATALOGUE_APPSERVICE, "..app.vehicle.domain..", "..app.vehicle.domain.model..", "..garage.order.domain..");
        rule.check(classes);
    }

    @Test
    @DisplayName("application service pattern between parts catalogue and vehicle")
    void application_service_check() throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName("ExplosionChartApplicationService")
                .and()
                .resideInAnyPackage(PARTS_CATALOGUE_APPSERVICE)
                .should()
                .onlyAccessClassesThat()
                .resideInAnyPackage(JAVA_LANG, JAVA_UTIL, ORG, "..parts.catalogue.usecase.out..", PARTS_CATALOGUE_APPSERVICE, "..app.vehicle.usecase.in..", "..app.vehicle.domain..", "..parts.catalogue.domain..");
        rule.check(classes);
    }

    @Test
    @DisplayName("A usecase.in should be implemented by an application service")
    void application_service_patter_usecase_in_implementation_check() throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName("ExplosionChartApplicationService")
                .and()
                .resideInAnyPackage(PARTS_CATALOGUE_APPSERVICE)
                .should()
                .implement(Class.forName("com.hexaclean.arc.demo.app.parts.catalogue.usecase.in.ExplosionChartQuery"));
        rule.check(classes);
    }

}
