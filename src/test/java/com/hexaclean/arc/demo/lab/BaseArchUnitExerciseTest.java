package com.hexaclean.arc.demo.lab;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseArchUnitExerciseTest extends BaseExerciseTest {

    protected JavaClasses classes;

    @BeforeEach
    void setUp() {
        classes = new ClassFileImporter().importPackages(ROOT_PACKAGE);
    }
}
