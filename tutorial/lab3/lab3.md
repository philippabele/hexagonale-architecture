# Lab 3: Interface Segregation Principle and the Ports & Adapters Pattern

## Mappings Between Boundaries

Currently, the _Vehicle_ is the model of the application, and it is not separated from infrastructure. In conclusion the
idea of ports and adapters is not consequently followed. The missing element to fully decoupled domain and
infrastructure is a _mapping between these boundaries_.

---
**Mapping**

Mappings between boundaries describes a transformation of the state of a source entity model to a target entity model.
The following code snippets shows an example of different entity model, where for example the _baumuster_ of _
VehicleDto_ must be mapped on the the property
_modelDescription_ of _Vehicle_.

```java
public class Vehicle {

    public String modelDescription;

    public String vin;

    public Double mileage;

}
```

```java
public class VehicleDto {

    public String baumuster;

    public String vehicleId;

    public Double mileage;

}
```

---
**Pro mapping**

* If we don't map between layers, we have to use the same model on both layers, which means that the layers will be
  tightly coupled.
* Mappings enables use (1) to reduce the amount of data from external models and (2) implement a model in our domain
  language, which (3) is easier to understand and (4) extend.

---
**Contra mapping**

* If we do map between layers, we produce a lot of boilerplate code, which is overkill for many use cases.

---

All arguments are true. We have to consider our software architecture goals for this decision. Our goals are to create

1) a isolated domain, and
2) source code that expresses the domain functionality and language crystal clear.

A key element to reach this is mapping. But a good balance between boilerplate code and decoupling can be reached by
simplifying and automation of mappings as well as using the so-called _two-way mapping strategy_.

### Data Transfer Objects Between Layers

The class-stereotype <i>Data Transfer Object</i> described data objects provided by infrastructure components. In
detail <i>Data Transfer Object</i> can be a:

* _DbEntity_
* _Event_
* _Resource_
* _Response Object_
* and so on

### Benefits of Mappings

---
**Stable domain and fast adaption**

Changes in the infrastructure affect not the domain. When for example an external service changes its response model
then the changes affect only the mapping part of the adapter implementation. This single point of change enables us to
adapt very fast to change in the infrastructure.

In addition to that, it is possible to reduce test efforts. There are no tests of the domain needed when nothing
changed. The adapter implementation could be tested in isolation on a pure technical level, which is less complex and
cost-intensive.

---
**Evolutionary design**

Change comes fast and unexpected. But for sure - it comes! Domain-related change could arise due to

* changing behaviour,
* new requirements,
* growing business model,
* changing business model,
* new consumers, and so on.

Since we cannot foresee change, we must look ahead and act. On an architectural level, this means that we have to **
apply** **architecture** and **design** **principle** that **enables** **change**.

The idea of ports and adapters is a powerful pattern to support change based on the decoupling of domain and
infrastructure. Each of them can grow, modernize and tested independently.

## Task 3.1: Introduce a DbEntity

1. Create the class <i>VehicleDbEntity</i> and place it in the designated package
2. Ignore framework specific annotations like discussed in the previous lab
**Java**
```java

public class VehicleDbEntity {

    //id
    private String vin;

    //getter and setter
}

```
**Kotlin**
```kotlin

class VehicleDbEntity {
    
    //id
    var vin: String? = null

}

```
**C#**
```java

public class VehicleDbEntity {

    //id
    private string Vin {get; set;};

}

```

### Verify Your Implementation

**RUN** _DbEntity_Task_3_1_

### Verify Your Architecture

**RUN** _ArchitectureTest_Task_3_1_

## Task 3:2: Extend the VehicleRepository and Introduce a Mapper

1. Add the private method _findVehicleDbEntity_ to _VehicleRepository_ which returns a hard coded _VehicleDbEntity_
2. Use _findVehicleDbEntity_ in the existing public method _findVehicleByVin_ and replace the hard code _Vehicle_
   creation
**Java**
```java

private VehicleDbEntity findVehicleDbEntity(Vin vin){ ... }

```
**Kotlin**
```kotlin

private fun findVehicleDbEntity(vin: Vin): VehicleDbEntity {...}

```
**C#**
```java

private VehicleDbEntity FindVehicleDbEntity(Vin vin){ ... }

```
As a result you have a compiltation error.

3. Remember the responsibilities of the class stereotype repository. Which source code elements do you expected in the
   class _VehicleRepository_? **Make a list**.
   [Solution](lab3-repository-solution.md)

4. Introduce the _VehicleToVehicleDbEntityMapper_ with the following method and fix the compilation error.
   **Java**
```java
public Vehicle mapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity){...}
```
**Kotlin**
```kotlin

fun mapVehicleDbEntityToVehicle(dbEntity: VehicleDbEntity): Vehicle{...}

```
**C#**
```java

public VehicleRootEntity MapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity){...}

```
### Verify your Implementation

**RUN** _Mapper_Task_3_2_
**RUN** _OutputAdapter_Task_3_2_

### Verify Your Architecture

**RUN** _ArchitectureTest_Task_3_2_

## Task 3.3: Extend the VehicleController with a Resource and a Mapper

1. Change the method _Vehicle readVehicle(String vin)_ to
**Java**
```java

public VehicleResource readVehicle(String vin);

```
**Kotlin**
```java

fun readVehicle(vin: String): VehicleResource;

```
**C#**
```java

public VehicleResource ReadVehicle(string vin);

```

Now a compilation error occur in the _VehicleController_.

1. Implement the class _VehicleResource_ and,
2. a mapper class with the name _VehicleToVehicleResourceMapper_ which uses MapStruct

**Java & Kotlin**

Sources for MapStruct:

* [MapStruct Basics](https://www.baeldung.com/mapstruct)
* [Custom Mapper with MapStruct](https://www.baeldung.com/mapstruct-custom-mapper)
* [MapStruct Reference Guide Version 1.5.3](https://mapstruct.org/documentation/stable/reference/html/)
* [Other sources](https://mapstruct.org/community/other-resources/)

**C#**

Sources for AutoMapper:
* [AutoMapper Tutorial](https://dotnettutorials.net/lesson/automapper-in-c-sharp/)
* [AutoMapper Documentation](https://docs.automapper.org/en/stable/index.html)

### Verify your Implementation

**RUN** _Mapper_Task_3_3_
**RUN** _InputAdapter_Task_3_3_

### Verify Your Architecture

**RUN** _ArchitectureTest_Task_3_3_