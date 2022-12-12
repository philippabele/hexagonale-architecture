# Lab 5: Growing Domain Part 2

## Slicing Use Cases with the Interface Segregation Principle

_Robert C. Martin_ points out in his book _Clean Architecture_ that _"depending on something that carries baggage that
you don't need can cause you trouble that you didn't expect"_!

The interface segregation principle provides an answer to this problem. It states that broad interfaces should be split
into specific ones so that clients only know the methods they need.

Applying the interface segregation principle

* **removes unnecessary dependencies** to methods the consumer doesn't need,
* makes the existing **dependencies more visible**,
* **prevents** potential trouble based on **side effects** and,
* enables **extendibility** and **flexibility** 

In origin sense the interface segregation principle says:

---
Many client-specific interfaces are better than one general-purpose interface. No clients should be forced to depend on
methods it does not use. In conclusion, interfaces should be separated into small responsibilities as minimalistic as
possible.

![Variants of slicing use cases](../img/usecaseslicing.png)

Personally I do not use the option _Root Entity_. As a default I use the option _Command & Query_. When different
consumer exists and there are difference between their needs, then I recommend using the option _one method per
usecase (port)_. Also referring to the package structure variants, there is a _separation of incoming and outgoing use
cases_, which is recommended to _apply_ as _standard design principle_.

Following code examples for different variants of slicing use cases.

**Use cases by Root Entity**

```java

public interface VehicleUseCase {

    Vehicle readByVin(Vin vin);

    Vehicle readByLicensePlate(LicensePlate licensePlate);

    Vehicle update(Vin vin, VehicleMotionData vehicleMotionData);

    Vehicle create(Vehicle vehicle);

    void delete(Vin vin);
}
```

**Use case by separating command and query***

```java

public interface VehicleQuery {

    Vehicle readByVin(Vin vin);

    Vehicle readByLicensePlate(LicensePlate licensePlate);
}
```

```java

public interface VehicleCommand {

    Vehicle update(Vin vin, VehicleMotionData vehicleMotionData);

    Vehicle create(Vehicle vehicle);

    void delete(Vin vin);
}
```

A separation in _command and query_ helps to prevent, that classes grow into complex and big units of code that are
hard to understand. A good orientation for modularisation inside a domain module can be found in _command and query_, even
when you do not plan to apply the _command query segregation principle_. But we can create a good foundation for such an
evolution.

**One method per use case (port)***

```java
public interface ReadVehicleByVin {

    Vehicle read(Vin vin);
}
```

```java
public interface ReadVehicleByLicensePlate {

    Vehicle read(LicensePlate licensePlate);
}
```

```java
public interface CreateVehicle {

    Vehicle readByVin(Vin vin);

    Vehicle readByLicensePlate(LicensePlate licensePlate);
}
```

```java
public interface UpdateVehicle {

    Vehicle update(Vin vin, VehicleMotionData vehicleMotionData);
}
```

```java
public interface DeleteVehicle {

    void delete(Vin vib);
}
```

Even when the variant _one method per use case_ is not typical Java, slicing use cases this way reduces coupling
between clients. In conclusion, the overall coupling between components of the software system will be kept low.
Coupling rises quickly and unavoidable. Due to this, we should avoid it every time when possible, especially in
fast-growing software systems for complex business domains.

Small sliced use cases allow assembling these use cases to a higher composition of functionality. Based on this,
functionality can be extended fast for new or changing business processes or user group specific requirements.

### Slicing Use Cases in Practice

There is no right way by default. It depends on complexity and specific requirements. In practice a
reasonable combination of these variants is may the best way to find a good balance between flexibility and simplicity
in the architecture in the long term.

Let's have a look on following functional requirements. As we already know, we have the mission to build a great garage
management that is maintainable, extendable and flexible. We want to modernize existing business processes and establish
new business models. And the system now starts to live, and we can expect an evolution over the years because the
business model change over time due to changing requirements of the stakeholder as well as technical evolution, which
creates the need of modernization.

## Task 5.1: Refactor VehicleService and VehicleRepository

Now it will be clear, why we named the already implemented use cases the way we did. The next step is to make the
separation more clear in our current implementation.

Rename the

* _VehicleService_ to _VehicleQueryService_
* _VehicleRepository_ to _VehicleQueryRepository_

### Verify your Implementation

**RUN** _OutputAdapter_Task_5_1_
**RUN** _DomainRing_Task_5_1_

### Verify Your Architecture

**Java & Kotlin**

The _CleanArchitectureTest_ located in _src/test/java/com/hexaclean/arc/demo/lab/test_ is a generic test for checking
the architecture rules of the clean architecture pattern based on [ArchUnit](https://www.archunit.org/).

**RUN**  _CleanArchitectureTest.java_
**RUN**  all architecture tests

**C#**

**RUN**  all architecture tests

## Task 5.2: Introduce VehicleCommand and VehicleDbCommand

In the next step, we want to introduce functionality to create a vehicle and update the vehicle motion data for a
vehicle.

1. Introduce the incoming use case _VehicleCommand_ with following methods:
**Java**
```java
    Vehicle create(Vehicle vehicle);
    Vehicle update(Vin vin,VehicleMotionData vehicleMotionData);
```
**Kotlin**
```kotlin
    fun create(vehicle: Vehicle): Vehicle
    fun update(vin: Vin, vehicleMotionData: VehicleMotionData): Vehicle
```
**C#**
```java
    Vehicle Create(Vehicle vehicle);
    Vehicle Update(Vin vin, VehicleMotionData vehicleMotionData);
```
2. Introduce the _VehicleCommandService_ and implement _VehicleCommand_
3. Introduce the outgoing use case _VehicleDbCommand_ with following method:
4. Introduce the _VehicleCommandRepository_ and implement _VehicleDbCommand_ with the following method:
**Java**
```java
    Vehicle save(Vehicle vehicle);
```
**Kotlin**
```kotlin
    fun save(vehicle: Vehicle): Vehicle
```
**C#**
```java
    Vehicle Save(Vehicle vehicle);
```
5. Introduce the _VehicleCommandRepository_ and implement the _VehicleDbCommand_
6. Extend the _VehicleToVehicleDbEntityMapper_ with the necessary mappings
7. Extend the _VehicleController_ with REST interface for create and update. Use the _VehicleCommand_ to connect to the
   domain.
**Java**
```java
    VehicleResource create(VehicleResource vehicle);
    VehicleResource update(String vin,VehicleMotionDataResource vehicleMotionData);
```
**Kotlin**
```java
    fun save(vehicle: Vehicle): Vehicle
```
**C#**
```java
    Vehicle Save(Vehicle vehicle);
```
8. Extend the _VehicleToVehicleResourceMapper_ with the necessary mappings

Consider always to place all classes it in the designated packages!

### Verify Your Architecture

**Java & Kotlin**

**RUN** _CleanArchitectureTest_
**RUN** all architecture tests

**C#**

**RUN** all architecture tests

## Rich vs. Anemic Domain Model

Based on the functionality if a vehicle supports a 2G connection, a comparison between a rich or anemic domain model
will be discussed. Lets imaging the fact if a vehicle supports 2G or not can be derived from the equipment list. If
there is a 2G modul built-in, then the vehicle supports 2G.

This simplified code snippet should make the scenario more clear:

```java
boolean determine2GSupport(List<Equipment> equipmentList){
        for(Equipment equipment:equipmentList){
        if(equipment.getCode().equals("GS200")){
        return true;
        }
        }
        return false;
        }
```

## Task 5.3: Rich Domain Model - Data, Validation and Behaviour

Currently, our domain model contains data and validation. Now the functionality to determine 2G support will be added as
additional behaviour. The determination can be done without any additional dependencies. So it is possible to integrate
the behaviour within the domain model.

1. Add the property boolean property has2GSupport_ to the _Vehicle_ and _VehicleResource_ class
2. Adapt the _VehicleToVehicleResourceMapper_
4. Implement the behaviour for _has2GSupport_
5. Trigger the behaviour during object creation or as soon as the equipment list will changed

### Verify your Implementation

**RUN** _DomainRing_Task_5_3_ 
**RUN** _DomainRing_Task_4_5_

### Verify Your Architecture

**Java & Kotlin**

**RUN** _CleanArchitectureTest.java_
**RUN** Execute all architecture tests

**C#**

**RUN** all architecture tests

## (Optional) Task 5.4: Hold the Domain Model Clean with Full Mapping Strategy

Let's change the scenario a little. For our domain the equipment list is not relevant. We need this only to
determine the enriched domain value  _has2GSupport_.

We are very accurate and want to create an absolutely clean domain model. When our domain does not have to know a equipment list,
then it should the _Vehicle_ should not have a property for this.

Implement this simplified scenario to get a feeling about decoupling domain logic from infrastructure in more complex scenarios 
by using the full mapping strategy.

Look in the package _vehicle/domain/dto_. The so-called _DomainDTO_ differs from the DTO of an infrastructure component
like a _DbEntity_ oder _Resource_. The _DomainDTO_ is used to decouple a DTO from the domain model, when this is only
possible with an additional stage and mapping between all this objects.

1. Remove the property _equipmentList_ of _Vehicle_ class
2. Remove the domain objects _Equipment_ and _EquipmentCode_
3. Remove the property _equipmentList_ in _VehicleResource_
4. Move the method _determine2GSupport_ to _VehicleQueryService_ or to an dedicated domain service
5. Adapt the constructor of _Vehicle_, so that the property _has2GSupport_ is part of it.
6. Change the return value of the use case _FetchVehicleMasterData_ to _VehicleMasterDataDomainDTO_
7. Adapt the mapper _VehicleToVehicleDataDtoMapper_
8. Adapt the orchestration within the method _findByVin_ of _VehicleQueryService_
9. Fix the compilation erros in existing unit tests 
10. **RUN** the unit tests

### Verify Your Architecture

**Java & Kotlin**

**RUN** _CleanArchitectureTest.java_
**RUN** Execute all architecture tests

**C#**

**RUN** all architecture tests

## Group discussion: Alternative Domain Service Approach

