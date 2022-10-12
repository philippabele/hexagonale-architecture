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
import de.novatec.hexacleanws.garage.management.vehicle.usecase.out.VehicleDbQuery;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@AnalyzeClasses(packages = "de.novatec.hexacleanws.garage.management.vehicle",
        importOptions = {ImportOption.DoNotIncludeJars.class,
                ImportOption.DoNotIncludeArchives.class,
                ImportOption.DoNotIncludeTests.class})
public class Exercise2_3 extends Exercises {

    @ArchTest
    void usecase_out_implementation_check(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(REPOSITORY_UNDER_TEST)
                .should()
                .implement(VehicleDbQuery.class);
        rule.check(classes);
    }

    @ArchTest
    void usecase_out_check(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(USECASE_OUT_QUERY_UNDER_TEST)
                .should()
                .resideInAnyPackage(USECASE, USECASE_OUT)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(DOMAIN, DOMAIN_MODEL);
        rule.check(classes);
    }

    @ArchTest
    void adapter_out_check(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(REPOSITORY_UNDER_TEST)
                .should()
                .resideInAnyPackage(ADAPTER, ADAPTER_OUT)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(ADAPTER, ADAPTER_OUT, USECASE_OUT, USECASE, DOMAIN, DOMAIN_MODEL, JAVA_LANG);
        rule.check(classes);
    }

    @Test
    void vehicle_and_vin_should_be_created_successful() {
        Vehicle vehicle = new VehicleRepository().findVehicleByVin(new Vin(VIN));
        assertThat(vehicle).isEqualTo(new Vehicle(new Vin(VIN)));
    }

}
