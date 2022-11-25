## Solve the complilation error

The type your are looking for is the class-stereotype _Mapper_. To be conform with the rules and princples of the clean
architecture pattern, a transformation between the _VehicleDbEntity_ and the _Vehicle_ object is the solution.

To solve the compilation error should implement a VehicleToVehicleDbEntityMapper as an own class.

In simple scenarios you must not create a separated class. In this exercise please implement a class that names end
with _Mapper_.

### Use a privatte method for the mapping

When to use:

1. Small and easy object graphs
3. Trival adapter functionality

```java

import VehicleDbQuery;

public class VehicleRepository implements VehicleDbQuery {

    public Vehicle findVehicleByVin(Vin vin) {
        VehicleDbEntity dbEntity = sqlSource.execute("SELECT * FROM VEHICLE_TBL");  // a fake sql execution

        return mapVehicleDbEntityToVehicle(dbEntity);
    }

    private mapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity) {
        return new Vehicle(new Vin(dbEntity.getVin()));
    }
}
```

### Use a mapper class

When to use:

1. More Complex objects graphs
3. Extensiv and / or complex adapter functionality

```java
import VehicleDbQuery;

public class VehicleRepository implements VehicleDbQuery {

    private VehicleToVehicleDbEntityMapper mapper;

    public VehicleRepository(VehicleToVehicleDbEntityMapper mapper) {
        this.mapper = mapper;
    }

    public Vehicle findVehicleByVin(Vin vin) {
        VehicleDbEntity dbEntity = sqlSource.execute("SELECT * FROM VEHICLE_TBL");  // a fake sql execution

        return mapper.mapVehicleDbEntityToVehicle(dbEntity);
    }
}

public class VehicleToVehicleDbEntityMapper {

    private Vehicle mapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity) {
        return new Vehicle(new Vin(dbEntity.getVin()));
    }
}

```