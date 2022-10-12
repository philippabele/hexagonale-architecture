package de.novatec.hexacleanws.exercises.one;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.novatec.hexacleanws.exercises.Exercises;
import de.novatec.hexacleanws.garage.management.vehicle.adapter.out.VehicleRepository;
import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vehicle;
import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vin;
import de.novatec.hexacleanws.garage.management.vehicle.domain.service.VehicleService;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@AnalyzeClasses(packages = "de.novatec.hexacleanws.garage.management.vehicle",
        importOptions = {ImportOption.DoNotIncludeJars.class,
                ImportOption.DoNotIncludeArchives.class,
                ImportOption.DoNotIncludeTests.class})
public class Exercise1 extends Exercises {

    @ArchTest
    void root_entity_check(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(ROOT_ENTITY_UNDER_TEST)
                .should()
                .resideInAnyPackage(
                        DOMAIN,
                        DOMAIN_MODEL)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(DOMAIN_MODEL,
                        DOMAIN_PRIMITIVES,
                        JAVA_LANG,
                        JAVA_UTIL)
                .andShould()
                .dependOnClassesThat().haveSimpleName(VALUE_OBJECT_UNDER_TEST);
        rule.check(classes);
    }

    @ArchTest
    void value_object_check(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(VALUE_OBJECT_UNDER_TEST)
                .should()
                .resideInAnyPackage(
                        DOMAIN,
                        DOMAIN_MODEL)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(DOMAIN, DOMAIN_MODEL, JAVA_LANG);
        rule.check(classes);
    }

    @ArchTest
    void service_check(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(SERVICE_UNDER_TEST)
                .should()
                .resideInAnyPackage(
                        DOMAIN,
                        DOMAIN_SERVICE)
                .andShould()
                .dependOnClassesThat()
                .haveSimpleName(ROOT_ENTITY_UNDER_TEST)
                .andShould().dependOnClassesThat().haveSimpleName(VALUE_OBJECT_UNDER_TEST);
        rule.check(classes);
    }

    @Test
    void should_throw_illegal_state_exception_due_to_invalid_vin() {
        assertThrows(IllegalStateException.class, () -> new Vehicle(new Vin("")));
    }

    @Test
    void should_throw_illegal_state_exception_due_to_null_for_vin() {
        assertThrows(IllegalStateException.class, () -> new Vehicle(null));
    }

    @Test
    void vehicle_and_vin_should_be_created_successful() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new Vehicle(vin);
        assertThat(vehicle).isEqualTo(new Vehicle(vin));
    }

    /*@Test
    void vehicle_service_should_return_a_valid_vehicle() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new VehicleService().readVehicle(vin);
        assertThat(vehicle).isEqualTo(new Vehicle(vin));
    }*/

    @Test
    void vehicle_service_should_return_a_valid_vehicle() {
        //@TODO: Improve with a spy
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new VehicleService(new VehicleRepository()).readVehicle(vin);
        assertThat(vehicle).isEqualTo(new Vehicle(vin));
    }
}
