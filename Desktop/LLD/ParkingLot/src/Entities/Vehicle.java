package Entities;

import enums.VehicleType;

public class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType, String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
    public String getVehicleNumber(){return vehicleNumber;}

    public VehicleType getVechileType() {
        return vehicleType;
    }
}
