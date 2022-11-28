package com.hexaclean.arc.demo.lab.six;

import com.hexaclean.arc.demo.lab.BaseArchUnitExerciseTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest_Task_6_2 extends BaseArchUnitExerciseTest {

    public static final String VEHICLE_MODULE_CLIENT = "VehicleModuleClient";
    public static final String GARAGE_ORDER_ADAPTER_OUT = "..garage.order.adapter.out..";
    public static final String GARAGE_ORDER_ADAPTER = "..garage.order.adapter..";

    @Test
    @DisplayName("adapter.out - usecase.in pattern between garage order and vehicle")
    void usecase_out_implementation_check() throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(VEHICLE_MODULE_CLIENT)
                .and()
                .resideInAnyPackage(GARAGE_ORDER_ADAPTER_OUT, GARAGE_ORDER_ADAPTER)
                .should()
                .onlyAccessClassesThat()
                .resideInAnyPackage(GARAGE_ORDER_ADAPTER_OUT, GARAGE_ORDER_ADAPTER, DOMAIN, DOMAIN_MODEL, "..app.vehicle.usecase.in..", JAVA_LANG, JAVA_UTIL, ORG);
        rule.check(classes);
    }

    @Test
    @DisplayName("A usecase.in should be implemented by a a domain service")
    void usecase_in_implementation_check() throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(VEHICLE_MODULE_CLIENT)
                .and()
                .resideInAnyPackage(GARAGE_ORDER_ADAPTER_OUT, GARAGE_ORDER_ADAPTER)
                .should()
                .implement(Class.forName("com.hexaclean.arc.demo.app.garage.order.usecase.out.FetchVehicle"));
        rule.check(classes);
    }

}
