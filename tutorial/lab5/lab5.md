# Lab 5: Growing Domain Part 2

## Slicing Use Cases with the Interface Segregation Principle

_Robert C. Martin_ points out in his book _Clean Architecture_ that _"depending on something that carries baggage that
you don't need can cause you trouble that you didn't expect"_!

The Interface Segregation Principle provides an answer to this problem. It states that broad interfaces should be split
into specific ones so that clients only know the methods they need.

Applying the Interface Segregation Principle

* **removes unnecessary dependencies** to methods the consumer doesn't need,
* makes the existing **dependencies more visible**,
* **prevents** potentical trouble in sense of **side effects** due to change in the software and,
* enables **flexibility** by <b>extendibility</b> (e.g. new interfaces and functionality can be introduce without
  affecting existing interfaces and functionality as well as **fast adaption** (interfaces with small responsibilities
  are less complex, easier to change and to test)

In origin sense the Interface Segregation Principle says:

---
Many client-specific interfaces are better then one general-purpose interface. No clients should be forced to depend on
methods it does not use. In conclusion, interfaces should be separated into small responsibilities as minimalistic as
possible.

![Variants of slicing use cases](../img/usecaseslicing.png)

Personally I do not use the option _Root Entity_. As a default I use the option _Command & Query_. When different
consumer exists and there are difference between their needs, then I recommend to use the option _one method per
usecase (port)_. Also refering to the package structure variants, there is a _separation of incoming and outgoing use
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

A separation in command and query helps to prevent, that classes grow into complex and big units of source code that are
hard to understand. A good orientation for modularisation inside a domain module can be found in command and query, even
when you do not plan to apply the Command Query Segregation Principle. But we can create a good foundation for such an
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

Even when the variant one method per use case may is not typical Java, slicing use cases this way reduces coupling
between clients. In conclusion, the overall coupling between components of the software system will be kept low.
Coupling rises quickly and unavoidable. Due to this, we should avoid it every time when possible, especially in
fast-growing software systems for complex business domains.

Small sliced use cases allow assembling these use cases to a higher composition of functionality. Based on this,
functionality can be extended fast for new or changing business processes or user group specific requirements.

### Slicing Use Cases in Practice

There is no right way by default. It depend on complexity and requirements of the specific use case. In pratice a
reasonable combination of these variants is may the best way to find a good balance between flexibility and simplicity
in the architecture in the longterm.

Let's have a look on following functional requirements. As we already know, we have the mission to build a great garage
management that is maintainable, extendable and flexible. We want to modernize existing business processes and establish
new business models. And the system now starts to live and we can expected an evolution over the years because the
business model change over time due to changing requirements of the stakeholder and also technical evolution, which
creates the need of modernization over time.

## Task 5.1: Refactor VehicleService and VehicleRepository

Now it will be clear, why we named the already implemented use cases the way we did. The next step is to make the
separation more clear in our current implementation.

Rename the

* VehicleService to VehicleQueryService
* VehicleRepository to VehicleQueryRepository

### Verify your Implementation

1. Move the tests _OutputAdapter_Task_5_1.java_ and _DomainRing_Task_5_1 from _tutorial/lab/five_ to _
   src/test/java/com/hexaclean/arc/demo/lab/five_
2. Run _mvn clean install -DskipTests_
3. Execute _OutputAdapter_Task_5_1.java_ and _DomainRing_Task_5_1_

### Verify Your Architecture

The _CleanArchitectureTest_ located in _src/test/java/com/hexaclean/arc/demo/lab/test_ is a generic test for checking
the architecture rules of the clean architecture pattern based on [ArchUnit](https://www.archunit.org/).

1. Execute _CleanArchitectureTest.java_
2. Execute all architecture tests

## Task 5.2: Introduce VehicleCommand and VehicleDbCommand

In the next step, we want to introduce functionality to create a vehicle and update the vehicle motion data for a
vehicle.

1. Introduce the incoming use case _VehicleCommand_ with following methods:

```java
    Vehicle create(Vehicle vehicle);
        Vehicle update(Vin vin,VehicleMotionData vehicleMotionData);
```

2. Introduce the _VehicleCommandService_ and implement _VehicleCommand_
3. Introduce the outgoing use case _VehicleDbCommand_ with following method:
4. Introduce the _VehicleCommandRepository_ and implement _VehicleDbCommand_ with the following method:

```java
    Vehicle save(Vehicle vehicle);
```

5. Introduce the _VehicleCommandRepository_ and implement the _VehicleDbCommand_
6. Extend the _VehicleToVehicleDbEntityMapper_ with the necessary mappings
7. Extend the _VehicleController_ with REST interface for create and update. Use the _VehicleCommand_ to connect to the
   domain.

```java
    VehicleResource create(VehicleResource vehicle);
        VehicleResource update(String vin,VehicleMotionDataResource vehicleMotionData);
```

8. Extend the _VehicleToVehicleResourceMapper_ with the necessary mappings

Consider always to place all classes it in the designated packages!

### Verify Your Architecture

1. Execute _CleanArchitectureTest.java_
2. Execute all architecture tests

## Rich vs. Anemic Domain Model

Based on the functionality if a vehicle supports a 2G connection, a comparison between a rich or anemic domain model
will be discussed. Let's imaging the fact if a vehicle supports 2G or not can be derived from the equipment list. If
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

1. Add the property _boolean has2GSupport_ to the _Vehicle_ and _VehicleResource_ class
2. Adapt the _VehicleToVehicleResourceMapper_
4. Implement the behaviour for _has2GSupport_
5. Trigger the behaviour during object creation or as soon as the equipment list will changed

### Verify your Implementation

1. Move the tests _DomainRing_Task_5_3.java_ from _tutorial/lab/five_ to
   _src/test/java/com/hexaclean/arc/demo/lab/five_
2. Run _mvn clean install -DskipTests_
3. Execute _DomainRing_Task_5_3.java_ and _DomainRing_Task_4_5

### Verify Your Architecture

1. Execute _CleanArchitectureTest.java_
2. Execute all architecture tests

## Task 5.4: Hold the Domain Model Clean with Full Mapping Strategy

Let's change the scenario a little bit. For our domain the equipment list is not important. We need this only to
determine enriched information like the _has2GSupport_ property.

We are very accurate and want to create a absolutely clean domain model. When our domain does not know a equipment list
then it should not a property of the root entity _Vehicle_.

Implement this idea to get a feeling about more complex scenarios and architecture decisions.

Look in the package _vehicle/domain/dto_. The so-called _DomainDTO_ differs from the DTO of an infrastructure component
like a _DbEntity_ oder _Resource_. The _DomainDTO_ is used to decouple a DTO from the domain model, when this is only
possible with an additional stage and mapping between all this objects.

1. Remove the property _equipmentList_ of _Vehicle_ class
2. Remove the domain objects _Equipment_ and _EquipmentCode_
3. Remove the property _equipmentList_ in _VehicleResource_
4. Move the method _determine2GSupport_ to _VehicleQueryService_ or to an dedicated domain service
5. Adapt the constructor of _Vehicle_, so that the property _has2GSupport_ is part of it.
6. Change the return value of the use case _FetchVehicleMasterData_ to _VehicleMasterDataDomainDTO_
7. Adapt the mapper _VehicleToVehicleDataDtoMappper_
8. Adapt the orchestration within the method _findByVin_ of _VehicleQueryService_
9. Adapt the tests

### Verify Your Architecture

1. Execute _CleanArchitectureTest.java_
2. Execute all architecture tests

## Group discussion: Alternative Domain Service Approach

