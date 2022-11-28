* Mapping between db entities and domain object
* OR-Mapping between result set / queries and domain object
* Definition and execution of sql statements
* Handling of database errors
* The usage of third party classes to handle persistence, like spring-data repositories

An additional example to illustrate the responsibilities:

```java

public class VehicleRepository implements VehicleDbQuery {

    private VehicleToVehicleDbEntityMapper mapper;
    private SqlSource sqlSource;

    private final static String VEHICLE_QUERY = "SELECT * FROM VEHICLE_TBL";

    public VehicleRepository(VehicleToVehicleDbEntityMapper mapper, SqlSource sqlSource) {
        this.mapper = mapper;
        this.sqlSource = sqlSource; //a fake sql source
    }

    public Vehicle findVehicleByVin(Vin vin) {
        VehicleDbEntity dbEntity = sqlSource.execute(VEHICLE_QUERY);  // a fake sql execution

        return mapper.mapVehicleDbEntityToVehicle(dbEntity);
    }
}

```