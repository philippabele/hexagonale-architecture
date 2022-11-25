# Lab 2: Dependency Inversion Principle and the Ports & Adapters Pattern

## Task 2.1: Create a HTTP Input Adapter

The class-stereotype <i>Controller</i> is the place to

* implement HTTP-based inbound into our application,
* wiring incoming use cases to execute domain functionality and,
* transform domain-related exceptions to HTTP status codes.

1. Create a <i>VehicleController</i> and place it in the designated package
2. Implement the REST endpoint <i>/vehicle/{vin}</i> and return a hard-coded vehicle object. Use following method
   signature.
3. You can ignore spring specific annotations.

```java

public Vehicle readVehicle(@PathVariable String vin);

```

### Verify Your Implementation

1. Move the test _ControllerTestExercise2_1.java_ from _exercises/tests/two/one_ to _
   src/test/java/com/daimler/dcp/clean/arc/demo/exercise/two/one_
2. Run _mvn clean install -DskipTests_
3. Execute _ControllerTestExercise2_1.java_

### Verify Your Architecture

1. Move the test _ArchitectureTestExercise2_1.java_ from _exercises/tests/two/one_ to _
   src/test/java/com/daimler/dcp/clean/arc/demo/exercise/two/one_
2. Run _mvn clean install -DskipTests_
3. Execute _ArchitectureTestExercise2_1.java_

## Dependency Injection

Dependency injection is a pattern described as follows:

A central component, the dependency injector, manages the lifecycle of class instances and injects these instances into
several consumers.

![Dependency injection](../img/di.png)

Relevant types of dependency injection by example:

```java

import org.springframework.beans.factory.annotation.Autowired;

public class VehicleService {

   @Autowired //field injection
   private DependencyOne one;
   
   private DependencyTwo two;
   
   @Autowired // contructor injection
   public VehicleService(DependencyTwo two) {
       this.two = two;
   }
   
   @Autowired //method injection
   public void doSomething(DependencyThree three) {
       three.doSomething();
   }
}
```

In short, the goal of dependency injection is to reduce the coupling between a consumer and provider class by the
externalization of object creation and management of the object's lifecycle. So consumers can only focus on the usage of
this dependency. In combination with interfaces, the consumer will be decoupled from a provider-specific implementation.
Both help to reduce coupling in the software architecture.

[Futher informations about dependency injection](https://martinfowler.com/articles/dipInTheWild.html)

## Task 2.2: Query About a Domain Object Using a Use Case

1. Create the incoming use case <i>VehicleQuery</i> with the method

```java

Vehicle readVehicle(Vin vin);

```

and place it in the designated package.

3. Replace the hard-coded <i>Vehicle</i> within <i>VehicleController</i> with the usage of <i>VehicleQuery</i>
4. The dependency between <i>VehicleController</i> and <i>VehicleQuery</i> should be resolved via constructor injection
5. Implement the incoming usecase <i>VehicleQuery</i> using the right class-stereotype

### Verify Your Implementation

1. Now there must come up a compilation error in _ControllerTestExercise2_1.java_.
2. Fix the compilation error and execute _ControllerTestExercise2_1.java_ again.

### Verify Your Architecture

1. Since the usage of _VehicleQuery_ in _VehicleController_, the test _ArchitectureTestExercise2_1.java_ can not be
   passed anymore
2. Have a look at the ArchUnit code and try to fix the test. Please notice there are some constants available that gives
   orientation.

```java
void http_input_adapter_check() {
     ArchRule rule = classes()
     .that().haveSimpleName(CONTROLLER_UNDER_TEST)
     .should().resideInAnyPackage(ADAPTER, ADAPTER_IN)
     .andShould().onlyDependOnClassesThat()
     .resideInAnyPackage(
             DOMAIN,
            DOMAIN_MODEL,
            //which stereotype is allowed to be accessed by the controller?
            //insert here...
            //ignore this list elements below
            ORG,
            JAVA_LANG,
            ADAPTER,
            ADAPTER_IN
        );
     
     rule.check(classes);
}
```

[Solution](Exercise2-fix-architecture-test.md)

## Dependency Inversion Principle

The dependency inversion principle says:

---
Abstractions should not depend on details. Details should depend on abstractions.

The _VehicleService_ is a concrete implementation. This means it is a detail. Following the dependency inversion
principle, the _VehicleService should depend on an abstraction e.g. an interface. This interface will be implemented by
the provider of a functionality. As a result, there is no direct dependency on a specific implementation. The dependency
is inverted.

![Dependency inversion principle](../img/dip.png)

## Task 2.3: Introduce a Outgoing Use Case and Create a Database Adapter

The class-stereotype <i>Repository</i> is the place to

* wire a JdbcRepository or JpaRepository,
* connect to a database with plain jdbc,
* define and execute sql statements as well as
* handle sql errors.

1. Create the outgoing usecase <i>VehicleDbQuery</i> with the method

```java

Vehicle findVehicleByVin(Vin vin);

```

2. Create the repository <i>VehicleRepository</i> and place it in the designated package
3. The repository should return a hard-coded <i>Vehicle</i> instance
4. Implement the outgoing usecase <i>VehicleDbQuery</i>  with the correct class-stereotype
5. Replace the hard-coded <i>Vehicle</i> within <i>VehicleService</i> with the usage of <i>VehicleDbQuery</i>
6. The dependency between <i>VehicleService</i> and <i>VehicleDbQuery</i> should be resolved via constructor injection

### Verify Your Implementation

1. Move the test _RepositoryTestExercise2_3.java_ from _exercises/tests/two/three_ to _
   src/test/java/com/daimler/dcp/clean/arc/demo/exercise/two/three_
2. Run _mvn clean install -DskipTests_
3. Execute _RepositoryTestExercise2_3.java_

### Verify Your Architecture

1. Move the test _ArchitectureTestExercise2_3.java_ from _exercises/tests/two/three_ to _
   src/test/java/com/daimler/dcp/clean/arc/demo/exercise/two/three_
2. Run _mvn clean install -DskipTests_
3. Execute _ArchitectureTestExercise2_3.java_

## Task 2.4: Additional Questions

For handling with persistence aspects spring-data-jpa or spring-data-jdbc uses annotations like
<i>@Entity</i>, <i>@Table</i>, <i>@Id</i>, <i>@Column</i>, etc. Often this concepts need also an empty constructor as
well as setter and getters for all properties.

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
    1. Is the domain object _Vehicle_ decoupled from infrastructure aspects?
    2. Is it possible to ensure a valid creation of the domain object like implemented in Lab 1?
    3. Is there fully control that the domain object state stays valid over the lifetime of the object?
2. Is a value object a good structure for a relational database?
    1. What are benefits of a value object like the <i>Vin</i>?
3. How would you describe the relationship between dependency inversion and dependency injection?
4. How would you describe the single responsibility principles for the following classes
    1. <i>VehicleController</i>,
    2. <i>VehicleService</i>,
    3. <i>VehicleRepository</i> and
    4. <i>Vehicle</i>

[Solution](Exercise2-additional-questions.md)