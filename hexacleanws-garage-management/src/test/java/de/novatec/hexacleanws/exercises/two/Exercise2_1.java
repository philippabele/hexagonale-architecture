package de.novatec.hexacleanws.exercises.two;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.novatec.hexacleanws.exercises.Exercises;
import de.novatec.hexacleanws.garage.management.vehicle.adapter.in.VehicleController;
import de.novatec.hexacleanws.garage.management.vehicle.adapter.out.VehicleRepository;
import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vehicle;
import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vin;
import de.novatec.hexacleanws.garage.management.vehicle.domain.service.VehicleService;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@AnalyzeClasses(packages = "de.novatec.hexacleanws.garage.management.vehicle",
        importOptions = {ImportOption.DoNotIncludeJars.class,
                ImportOption.DoNotIncludeArchives.class,
                ImportOption.DoNotIncludeTests.class})
public class Exercise2_1 extends Exercises {

    @ArchTest
    void adapter_in_check(JavaClasses classes) {
        //@TODO Improve with optional dependencies
        ArchRule rule = classes()
                .that()
                .haveSimpleName(CONTROLLER_UNDER_TEST)
                .should()
                .resideInAnyPackage(ADAPTER, ADAPTER_IN)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(DOMAIN, DOMAIN_MODEL, JAVA_LANG);
        rule.check(classes);
    }

    /*@Test
    void vehicle_and_vin_should_be_created_successful() {
        Vehicle vehicle = new VehicleController().readVehicle(VIN);
        assertThat(vehicle).isEqualTo(new Vehicle(new Vin(VIN)));
    }*/

    @Test
    void vehicle_and_vin_should_be_created_successful() {
        //@TODO: Improve with a spy
        Vehicle vehicle = new VehicleController(new VehicleService(new VehicleRepository())).readVehicle(VIN);
        assertThat(vehicle).isEqualTo(new Vehicle(new Vin(VIN)));
    }

}
