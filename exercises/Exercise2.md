# Exercise 2: Dependency inversion principle and the ports & adapters pattern

## 1. Create a HTTP input adapter

1. Create a <i>VehicleController</i> and place it in the designated package
2. Implement the REST endpoint <i>/vehicle/{vin}</i> and return a hard coded vehicle object. Use following method signature.

```java

public Vehicle readVehicle(@PathVariable String vin);

```

## 2. Query the domain based on a use case
1. Create the incoming usecase <i>VehicleQuery</i> with the method
```java

Vehicle readVehicle(Vin vin);

```
and place it in  the designated package.

2. The <i>VehicleService</i> should implement the incoming usecase <i>VehicleQuery</i>
3. Replace the hard coded <i>Vehicle</i> within <i>VehicleController</i> with the usage of <i>VehicleQuery</i>
4. The dependency between <i>VehicleController</i> and <i>VehicleQuery</i> should be resolved via constructor injection

## 3. Introduce a outgoing use case and create a database adapter
1. Create the outgoing usecase <i>VehicleDbQuery</i> with the method
```java

Vehicle findVehicleByVin(Vin vin);

```
2. Create the repository <i>VehicleRepository</i> and place it in the designated package
3. The <i>VehicleRepository</i> should implement the outgoing usecase <i>VehicleDbQuery</i>
4. Return a hard coded <i>Vehicle</i>

### Hints:
1. The <i>VehicleRepository</i> is the place to
* wire a JdbcRepository or JpaRepository or,
* to connect to a database with plain jdbc,
* defined and run sql statements and handle sql errors.

2. Uncomment the test <i>vehicle_and_vin_should_be_created_successful</i> in <i>Excercise2_3</i>

## Connect the domain with the database

1. Replace the hard coded <i>Vehicle</i> within <i>VehicleService></i> with the usage of <i>VehicleDbQuery</i>
2. The dependency between <i>VehicleService</i> and <i>VehicleDbQuery</i> should be resolved via constructor injection

## Additional question

For handling with persistence aspects spring-data-jpa or spring-data-jdbc uses annotations like
<i>@Entity</i>, <i>@Table</i>, <i>@Id</i>, <i>@Column</i>, etc.
Often there also for an empty constructor as well as setter and getters for all properties.

```java

@Table("vehicle")  //jdbc
@Entity //jpa
public class Vehicle {
    
    @Column("vin")
    @Id
    private Vin vin;
    
    //...
    
    public Vehicle() {}
    
    public Vehicle(Vin vin) {
        //...
    }
    
    //getter and setter
}

```

1. Regarding the above code example answer following questions:
    1. Is the domain decoupled from infrastructure?
    2. Is it possible to ensure valid domain object creation?
    3. It there fully control that the domain object state stays valid over the lifetime of the object?
2. Is a value object a good structure for a relational database? What are benefits of a value object like the <i>Vin</i>?
3. How would you describe the single responsibility principle consideres the classes
    1. <i>VehicleController</i>,
    2. <i>VehicleService</i>,
    3. <i>VehicleRepository</i> and
    4. <i>Vehicle</i>