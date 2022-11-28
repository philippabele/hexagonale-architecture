## Task 2.4: Dependency Inversion Principle and the Ports & Adapters Pattern - Additional Questions

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