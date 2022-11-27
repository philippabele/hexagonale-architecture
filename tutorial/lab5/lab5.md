# Lab 5: Growing Domain Part 2

## Slicing Use Cases with the Interface Segregation Principle

_Robert C. Martin_ points out in his book _Clean Architecture_ that "depending on something that carries baggage that
you don't need can cause you trouble that you didn't expect"!

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
consumer exists and there are difference between their needs, the I recommend to use the option _one method per
usecase (port)_. Also refering to the package structure variants, there is a separation of incoming and outgoing use
cases, which is recommended to apply as standard design principle.

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

Separating in command and query prevents classes that grows to complex and big units of source code that are hard to
understand. A good orientation for modularisation inside a domain module can be found in command and query, even when
you not plan to apply the Command Query Segregation Principle. But there is good foundation if this design decision
changes over time.

It is also I good idea of several clients only need read access. Than there is no reason do depend on command-methods.

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

Even if this variant is perhaps untypical for Java, slicing use cases per method reduces coupling between clients, what
means the overal coupling between components of the software system will be keep low. Coupling will rise quickly and
unavoidable. Due to this we should avoid it every time when possible in fast growing software system for complex
business domains.

Small sliced use cases allows to assemble these use cases to a higher composition of functionality. Based on this,
functionality can be extended fast and flexible for new or changing business proceses or user group specific
requirements.

### Slicing Use Cases in Practice

There is no right way by default. It depend on complexity and requirements of the specific use case. In pratice a
reasonable combination of these variants is may the best way to find a good balance between flexibility and simplicitity
in the architecture in the longterm.

Let's have a look on following functional requirements. As we already know, we have the mission to build a great garage
management that is maintainable, extendable and flexible. We want to modernize existing business processes and establish
new business models. And the system now starts to live and we can expected an evolution over the years because the
digtized business model change of time due to changing requirements of the stakeholder and also technical evolution
which creates the need of modernization over time.

Slicing use case makes a typical problem of architects' visible. In the moment of defining specific use cases, for
example read, create or update a vehicle, the complexitiy and arguments for slicing fine-grained use cases is not
obvouisly. So may there is some resistance against this design approach in your team. Another example is the mapping,
which often felt to be too much.

## Task 5.1: Refactor VehicleService and VehicleRepository

Now it will be clear, why we named the already implemented use cases the way we did. The next step is to make this
separation more clear in our current implementation.

Rename the

* VehicleService to VehicleQueryService
* VehicleRepository to VehicleQueryRepository

Execute all tests.

## Task 5.2: Introduce VehicleCommand and VehicleDbCommand

In the next step, we want to introduce functionality to create and update a vehicle.

1. Introduce the incoming use case VehicleCommand with following methods:
2. Introduce the VehicleCommandService and implement VehicleCommand
3. Introduce the outgoing use case VehicleDbCommand with following method:
4. Introduce the VehicleCommandRepository and implement VehicleDbCommand

Consider the package structure varianta and place all classes it in the designated package and reuse existing mappings
when possible.

## Rich vs. Anemic Domain Model

Based on the functionality if a vehicle supports 2G connections, a comparison between a rich domain model. Let's imaging
the fact if a vehicle supports 2G or not can be derived from the equipment list. If there is a 2G modul built-in, then
the vehicle supports 2G.

This simplified code snippet should make the scenario clear.

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

1. Add the property _boolean has2GSupport_ to the _Vehicle_ class
2. Implement a the determination and trigger it, as soon as the equipment list is available or changed.

## Task 5.4: Hold the Domain Model Clean with Full Mapping Strategy

Let's change the secnario a little bit. For our domain the equipment list is not important. We need this only to
determine enriched information like the _has2GSupport_ property.

We are very accurate and want to create a absolutely clean domain model. When our domain does not know a equipment list
then it should not a property of the root entity _Vehicle_.

Implement this idea to get a feeling about more complex scenarios and architecture decisions.

Look in the package _vehicle/domain/dto_. The so-called _DomainDTO_ differs from the DTO of an infrastructure component
like a _DbEntity_ oder _Resource_. The DomainDTO is used to decouple a DTO from the domain model, when this is only
possible with an additional stage and mapping between all this objects.

## Group discussion: Alternative Domain Service Approach

