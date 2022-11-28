package com.hexaclean.arc.demo.lab.clean.arch.test;

import com.hexaclean.arc.demo.lab.clean.arch.template.CleanArchitecture;
import com.hexaclean.arc.demo.lab.clean.arch.template.CleanArchitectureCheck;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;

@AnalyzeClasses(packages = "com.hexaclean.arc.demo.app")
public class CleanArchitectureTest {

    @ArchTest
    void should_check_clean_architecture_all_rings_architectural_expressive(JavaClasses javaClasses) {
        CleanArchitecture rule = CleanArchitecture.cleanArchitecture(CleanArchitectureCheck.ALL_RINGS_ARCHITECTURAL_EXPRESSIVE)
                .domainModel("..domain.model..")
                .domainService("..domain.service..")
                .adapterIn("..adapter.in..")
                .adapterOut("..adapter.out..")
                .useCaseIn("..usecase.in..")
                .useCaseOut("..usecase.out..")
                .ignore("..domain.dto..", "..domain.command..")
                .adapterOutOfAdapterOutUseCaseInPattern("..garage.order.adapter.out..")
                .applicationService("..parts.catalogue.appservice..");
        rule.check(javaClasses);
    }


    @ArchTest
    void should_check_clean_architecture_domain_and_usecase_ring_architectural_expressive(JavaClasses javaClasses) {
        CleanArchitecture rule = CleanArchitecture.cleanArchitecture(CleanArchitectureCheck.DOMAIN_AND_USECASE_RING_ARCHITECTURAL_EXPRESSIVE)
                .domainModel("..domain.model..")
                .domainService("..domain.service..")
                .adapter("..adapter..")
                .useCaseIn("..usecase.in..")
                .useCaseOut("..usecase.out..")
                .ignore("..domain.dto..", "..domain.command..")
                .adapterOutOfAdapterOutUseCaseInPattern("..garage.order.adapter.out..")
                .applicationService("..parts.catalogue.appservice..");
        rule.check(javaClasses);
    }


    @ArchTest
    void should_check_clean_architecture_rings_as_layers(JavaClasses javaClasses) {
        CleanArchitecture rule = CleanArchitecture.cleanArchitecture(CleanArchitectureCheck.RINGS_AS_LAYERS)
                .domain("..domain..")
                .adapter("..adapter..")
                .useCase("..usecase..")
                .ignore("..domain.dto..", "..domain.command..")
                .adapterOutOfAdapterOutUseCaseInPattern("..garage.order.adapter.out..")
                .applicationService("..appservice..");
        rule.check(javaClasses);
    }

}
