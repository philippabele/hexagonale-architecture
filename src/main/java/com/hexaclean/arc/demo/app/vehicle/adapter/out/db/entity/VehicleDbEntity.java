package com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("VEHICLE")
public class VehicleDbEntity {

    @Column("ID")
    private String vin;


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
    
}
