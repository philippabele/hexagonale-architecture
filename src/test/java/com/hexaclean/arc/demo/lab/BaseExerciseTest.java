package com.hexaclean.arc.demo.lab;

import com.hexaclean.arc.demo.app.vehicle.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseExerciseTest {

    protected static final String ROOT_PACKAGE = "com.hexaclean.arc.demo";
    protected static final String DOMAIN = "..domain..";
    protected static final String DOMAIN_SERVICE = "..domain.service..";
    protected static final String DOMAIN_MODEL = "..domain.model..";
    protected static final String JAVA_LANG = "..java.lang..";
    protected static final String ROOT_ENTITY_UNDER_TEST = "Vehicle";
    protected static final String DB_ENTITY_UNDER_TEST = "VehicleDbEntity";
    protected static final String SERVICE_UNDER_TEST = "VehicleQueryService";
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
    protected static final String REPOSITORY_UNDER_TEST = "VehicleQueryRepository";
    protected static final String ADAPTER_OUT = "..adapter.out..";
    protected static final String CONTROLLER_UNDER_TEST = "VehicleController";
    protected static final String LICENSE_PLATE_TEST_VALUE = "ES-EM 385";
    protected static final double MILEAGE_TEST_VALUE = 100000;
    protected static final String REGISTRATION_COUNTRY_TEST_VALUE = "DE-de";
    public static final String VEHICLE_MODEL_DESCRIPTION_TEST_VALUE = "E30 Limousine";
    public static final String VEHICLE_MODEL_TYPE_TEST_VALUE = "3er";
    public static final String SERIAL_NUMBER_TEST_VALUE = "0123456789";

}
