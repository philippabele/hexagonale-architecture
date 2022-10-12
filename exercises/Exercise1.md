# Exercise 1: Single responsibility principle, domain model and (domain) service

## Package structure variants
You have to decide which package style you want to use.

There are several package structure variants:
* architectural expressive,
* architectural expressive domain or,
* rings by layers

Please select between the variant you want to use in this training. Later we have a better feeling
about the variants and we will discuss pros and cons.

The recommodation is to use architectural expressive. Because layers are something your are more familiar with and the
concepts of clean architecture are more visible for you.

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
Archiectural expressive considers the port & adapters pattern fully

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
Even when you not like the package and class names, please follow them for the exercises.
If not, the tests will never be green ;)
It is absolutly ok, when you prefer business.model instead of domain.model. You can do this, but not here! ;)

If you are interested in, I can show some demo applications which follows all the idea of clean architecture. But all
them has different package structure and names.

## Create the domain model

1. Create the aggregate (aka. root entity) <i>Vehicle</i> and place it in the designated package
2. Create the value object <i>Vin</i> and place it in the designated package
3. Ensure that the <i>Vehicle</i> can only be created with a valid vehicle identification number (vin)
4. A vehicle identification number is valid when the value follows the regex pattern above. Throw an IllegalStateException in case of a validations error.

```java

// examples
// WP0ZZZ99ZTS392155
// WBAOLZ99ZTS349156

"(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}"

```
### Hints
In our world it gives only a vin! The system is only for small garage in Germany ;)


## Create the (domain) service

1. Create the (domain) service <i>VehiclesService</i> and place it in the designated package
2. The <i>VehiclesService</i> should offer following method
3.
```java

public Vehicle readVehicle(Vin vin) {...}

```
### Hints:
1. For this exercise a hard coded <i>Vehicle</i> as return value is enough
2. The test <i>vehicle_service_should_return_a_valid_vehicle</i> in test <i>Exercise_1</i>
   must be uncomment 
