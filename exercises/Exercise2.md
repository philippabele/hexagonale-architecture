# Exercise 2: Dependency inversion principle and the ports & adapters pattern

## Create a REST-based input adapter

1. Create a <i>VehicleController</i> and place it in the designated package
2. Implement the REST endpoint <i>/vehicle/{vin}</i> and return a hard coded vehicle object

## Query the domain based on a use case
1. Create the incoming usecase <i>VehicleQuery</i> with the method
```java

Vehicle readVehicle(Vin vin);

```
and place it in  the designated package.

2. The <i>VehicleService</i> should implement the incoming usecase <i>VehicleQuery</i>
3. Replace the hard code <i>Vehicle</i> within <i>VehicleController</i> with the usage of <i>VehicleQuery</i>
4. The dependency between <i>VehicleController</i> and <i>VehicleQuery</i> should be resolved via constructor injection

## Introduce a outgoing use case
1. Create the outgoing usecase <i>VehicleDbQuery</i> with the method
```java

Vehicle findVehicleByVin(Vin vin);

```
## Create a database adapter

1. Create the repository <i>VehicleRepository</i> and place it in the designated package
2. The <i>VehicleRepository</i> should implement the outgoing usecase <i>VehicleDbQuery</i>
3. Return a hard coded <i>Vehicle</i>

### Hints:
The <i>VehicleRepository</i> is the place to
* wire a JdbcRepository or JpaRepository or,
* to connect to a database with plain jdbc,
* defined and run sql statements and handle sql errors

But this stuff is not part on these training.

## Connect the domain with the database

1. Replace the hard coded <i>Vehicle</i> within <i>VehicleService></i> with the usage of <i>VehicleDbQuery</i>
2. The dependency between <i>VehicleController</i> and <i>VehicleDbQuery</i> should be resolved via constructor injection

## Addtional question

The way spring-data-jpa or spring-data-jdbc works, is that to have to annotate objects like <i>Vehicle</i> or <i>Vin</i>
must be annoted with <i>@Entity</i>, <i>@Table</i>, <i>@Id</i>, <i>@Column</i>, etc. There also need a empty constructor as well as setter and getters.

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
2. Is a value object a good structure for a relational database? What are benefits of a value object like the <i>Vin</i>?
3. How would you describe the single responsinility principle consideres the classes <i>VehicleController</i>, <i>VehicleService</i>
and <i>VehicleRepository</i> 