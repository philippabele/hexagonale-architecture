# Exercise 1: Single responsibility principle, domain model and (domain) service

## Package structure variant
You have to decide which package style you want to use. 

May, it depends on personal perspective, but think about the
definitions of architecture. Ask yourself if this an decision that
is hard to change (cost-intensive, time-consuming) later.

There are several variants (and maybe more):
* architectural expressive, 
* architectural expressive domain or, 
* rings by layers

Please select between the variant you want to use in this training.

```java
Rings as layes has three top level packages
        
adapter
usecase
domain

```

```java
Archiectural expressive domain considers the port & adapters pattern partly

adapter
        
usecase 
        in
        out
        
domain
        model
        service

```

```java
Archiectural expressive considers the port & adapters pattern in this package structure

adapter
        in 
        out
        
usecase 
        in
        out
        
domain
        model
        service

```

### Hints
Even when you not like package and class names, please follow them for the exercises like described. If not, the tests will never be green ;)
It is absolutly ok, if you prefer business.model instead of domain.model. You can do this, but not here! ;)

## Create the domain model

1. Create the aggregate (aka. root entity) <i>Vehicle</i> and place it in the designated package
2. Create the value object <i>Vin</i> and place it in the designated package
3. Ensure that the <i>Vehicle</i> can only be create with a valid vehicle identification number (vin)
4. A vehicle identification number is valid when the value follows this regex pattern. Throw an IllegalStateException if the <i>Vehicle</i> in case of a validation error.
5. 

```java

// examples
// WP0ZZZ99ZTS392155
// WBAOLZ99ZTS349156

(?=.\\d|=.[A-Z])(?=.[A-Z])[A-Z0-9]{17}

```
### Hints
In our world it gives only a vin!


## Create the (domain) service

1. Create the (domain) service <i>VehiclesService</i> and place it in the designated package
2. The <i>VehiclesService</i> should offer following method
3. 
```java

public Vehicle readVehicle(Vin vin) {...}

```
### Hints:
For this exercise a hard coded <i>Vehicle</i> as return value is enough
