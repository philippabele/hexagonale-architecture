package com.hexaclean.arc.demo.exercises;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity.VehicleDbEntity;
import com.clean.arc.demo.app.vehicle.domain.model.*;
import com.daimler.dcp.clean.arc.demo.app.vehicle.domain.model.*;
import com.hexaclean.arc.demo.app.vehicle.domain.model.*;

import java.util.ArrayList;

public abstract class BaseExerciseTest {

    protected static final String ROOT_PACKAGE = "com.daimler.dcp.clean.arc.demo";
    protected static final String DOMAIN = "..domain..";
    protected static final String DOMAIN_SERVICE = "..domain.service..";
    protected static final String DOMAIN_MODEL = "..domain.model..";
    protected static final String JAVA_LANG = "..java.lang..";
    protected static final String ROOT_ENTITY_UNDER_TEST = "Vehicle";
    protected static final String DB_ENTITY_UNDER_TEST = "VehicleDbEntity";
    protected static final String SERVICE_UNDER_TEST = "VehicleService";
    protected static final String VALUE_OBJECT_UNDER_TEST = "Vin";
    protected static final String JAVA_UTIL = "..java.util..";
    protected static final String ORG = "..org..";
    protected static final String VIN = "WP0ZZZ99ZTS392155";
    protected static final String ADAPTER_IN = "..adapter.in..";
    protected static final String ADAPTER = "..adapter..";
    protected static final String USECASE = "..usecase..";
    protected static final String USECASE_IN = "..usecase.in..";
    protected static final String USECASE_OUT = "..usecase.out..";
    protected static final String USECASE_OUT_QUERY_UNDER_TEST = "VehicleDbQuery";
    protected static final String USECASE_IN_QUERY_UNDER_TEST = "VehicleQuery";
    protected static final String REPOSITORY_UNDER_TEST = "VehicleRepository";
    protected static final String ADAPTER_OUT = "..adapter.out..";
    protected static final String CONTROLLER_UNDER_TEST = "VehicleController";

    protected VehicleDbEntity createVehicleDbEntity() {
        VehicleDbEntity dbEntity = new VehicleDbEntity();
        dbEntity.setVin(VIN);
        return dbEntity;
    }

    protected Vehicle createExpectedVehicle() {
        return new Vehicle(new Vin(VIN),
                new VehicleMotionData(new LicensePlate("ES-EM 385"),
                        new Mileage(100000, MileageUnitValue.KM),
                        new RegistrationCountry("DE")),
                new VehicleMasterData(new ArrayList<Equipment>(),
                        new VehicleModel("E30 Limousine", "3er"),
                        new SerialNumber("1")));
    }
}
