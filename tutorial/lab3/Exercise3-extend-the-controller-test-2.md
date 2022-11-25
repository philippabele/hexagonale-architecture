@Test @DisplayName("VehicleController should return a valid vehicle")
void vehicle_controller_should_return_a_valid_vehicle() { VehicleResource vehicle = new VehicleController(
new VehicleService(), new VehicleToVehicleResourceMapper()).readVehicle(VIN); assertThat(vehicle.getVin()).isEqualTo(
createExpectedVehicle().vin().value()); }