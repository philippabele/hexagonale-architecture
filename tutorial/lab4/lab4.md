# Lab 4: Growing Domain Part 1

## Task 4.1: Implement the Domain Model

Implement the additional domain objects that belongs to the root entity _Vehicle_, like described
in the following uml class diagram.

ADD DIAGRAM

## Task 4.2: Extend the VehicleResource and the Mapper
Extend the _VehicleResource_ like described as follows and adapt the _VehicleController_ and 
the _VehicleToVehicleResourceMapper_.

ADD DIAGRAM

## Task 4.3: Introduce the VehicleMasterDataServiceClient

There are some constraints given by the company context. There is one central
place for vehicle master data. From this source needed master data must be queried.

Due to this you have to introduce the _VehicleMasterDataServiceClient_ and create the adapter
implementation with the name _VehicleMasterDataToVehiceDtoMapper_. For this task
the external data object _VehicleDataDto_ already exists in the package _vehicle/adapter/out/dto_.

The external API with the _VehicleDataDto_ returns a lot of information we do not need in
our domain. Due to this we only extract the properties we defined in the 
_VehicleMasterData_ domain object. Have a look at the _VehicleDataDto_ and implement the service client
and mapper.

## Task 4.4: Extend the VehicleDbEntity and the Mapper

In the own database we store the vehicle motion data and other informations that not belongs to
vehicle master data.

Extend the _VehicleDbEntity_ like described as follows and the _VehicleToVehicleDbEntityMapper_.

## Task 4.5 Extend the VehicleService

Extend the _VehicleService_ so that
* vehicle motion data will be queried from database, and
* vehicle master data will be queried from a external api
