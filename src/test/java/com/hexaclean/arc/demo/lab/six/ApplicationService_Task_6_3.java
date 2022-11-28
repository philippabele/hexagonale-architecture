package com.hexaclean.arc.demo.lab.six;


import com.hexaclean.arc.demo.app.parts.catalogue.appservice.ExplosionChartApplicationService;
import com.hexaclean.arc.demo.app.parts.catalogue.appservice.VehicleToOriginVehicleMapper;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.ExplosionChart;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.PartsCategoryCode;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.VehicleModel;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.service.ExplosionChartDomainService;
import com.hexaclean.arc.demo.app.parts.catalogue.usecase.out.FetchExplosionChart;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.when;


public class ApplicationService_Task_6_3 extends BaseExerciseTest {

    @Test
    @DisplayName("The vehicle supports not 2G")
    void the_vehicle_supports_not_2G() {
        FetchExplosionChart fetchExplosionChart = Mockito.mock(FetchExplosionChart.class);
        VehicleQuery vehicleQuery = Mockito.mock(VehicleQuery.class);
        VehicleToOriginVehicleMapper mapper = Mockito.mock(VehicleToOriginVehicleMapper.class);
        Vehicle vehicle = createExpectedVehicle();
        com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.Vehicle expectedVehicle =
                new com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.Vehicle(VIN, false, new VehicleModel(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE, VEHICLE_MODEL_TYPE_TEST_VALUE));

        when(fetchExplosionChart.fetch(any(), any(), anyBoolean())).thenReturn(new ExplosionChart(expectedVehicle, null, null));
        when(vehicleQuery.findByVin(new Vin(VIN))).thenReturn(vehicle);
        when(mapper.mapOriginVehicleToVehicle(vehicle)).thenReturn(expectedVehicle);

        ExplosionChartApplicationService appService = new ExplosionChartApplicationService(fetchExplosionChart, vehicleQuery,
                mapper, new ExplosionChartDomainService());

        ExplosionChart explosionChart = appService.read(new PartsCategoryCode("123", "testcode"), VIN);

        assertThat(explosionChart.getVehicle().vehicleModel().modelType()).isEqualTo(expectedVehicle.vehicleModel().modelType());
        assertThat(explosionChart.getVehicle().vehicleModel().modelDescription()).isEqualTo(expectedVehicle.vehicleModel().modelDescription());
        assertThat(vehicle.isHas2GSupport()).isEqualTo(expectedVehicle.has2GSupport());
    }
}
