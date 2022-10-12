package de.novatec.hexacleanws.exercises.two;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.novatec.hexacleanws.exercises.Exercises;
import de.novatec.hexacleanws.garage.management.vehicle.adapter.in.VehicleController;
import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vehicle;
import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vin;
import de.novatec.hexacleanws.garage.management.vehicle.usecase.in.VehicleQuery;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@AnalyzeClasses(packages = "de.novatec.hexacleanws.garage.management.vehicle",
        importOptions = {ImportOption.DoNotIncludeJars.class,
                ImportOption.DoNotIncludeArchives.class,
                ImportOption.DoNotIncludeTests.class})
public class Exercise2_2 extends Exercises {

    @ArchTest
    void adapter_in_check(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(CONTROLLER_UNDER_TEST)
                .should()
                .resideInAnyPackage(ADAPTER, ADAPTER_IN)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(DOMAIN, DOMAIN_MODEL, USECASE, USECASE_IN, JAVA_LANG, ADAPTER, ADAPTER_IN);
        rule.check(classes);
    }

    @ArchTest
    void usecase_in_check(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(USECASE_IN_QUERY_UNDER_TEST)
                .should()
                .resideInAnyPackage(USECASE, USECASE_IN)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(DOMAIN, DOMAIN_MODEL);
        rule.check(classes);
    }

    @ArchTest
    void usecase_in_implementation_check(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(SERVICE_UNDER_TEST)
                .should()
                .implement(VehicleQuery.class);
        rule.check(classes);
    }

}
