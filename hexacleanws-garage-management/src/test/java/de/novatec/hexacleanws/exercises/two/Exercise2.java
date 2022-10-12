package de.novatec.hexacleanws.exercises.two;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.novatec.hexacleanws.exercises.Exercises;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static org.junit.jupiter.api.Assertions.assertTrue;

@AnalyzeClasses(packages = "de.novatec.hexacleanws.garage.management.vehicle",
        importOptions = {ImportOption.DoNotIncludeJars.class,
                ImportOption.DoNotIncludeArchives.class,
                ImportOption.DoNotIncludeTests.class})
public class Exercise2 extends Exercises {

    public static final String ROOT_ENTITY_UNDER_TEST = "Vehicle";
    public static final String SERVICE_UNDER_TEST = "VehicleService";
    public static final String VALUE_OBJECT_UNDER_TEST = "Vin";

    @Test
    void create_root_entity_check() {
        assertTrue(true);
    }

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
                .resideInAnyPackage(DOMAIN_MODEL, DOMAIN_PRIMITIVES)
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
                .resideInAnyPackage(DOMAIN_MODEL, DOMAIN_PRIMITIVES);
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


}
