package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.out.db;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.out.db.entity.VehicleDbEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VehicleCrudRepository extends CrudRepository<VehicleDbEntity, String> {

    //@Modifying
    //@Query("UPDATE vehicle SET licensePlate = :licensePlate WHERE ID = :ID")
    boolean updateLicensePlate(@Param("ID") String id, @Param("licensePlate") String licensePlate);

    //@Query("SELECT * FROM vehicle WHERE licensePlate = :licensePlate")
    boolean findByLicensePlate(@Param("licensePlate") String licensePlate);
}
