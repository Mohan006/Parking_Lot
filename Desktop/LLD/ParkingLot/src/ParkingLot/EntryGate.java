package ParkingLot;

import Entities.Ticket;
import Entities.Vehicle;

public class EntryGate {
    public Ticket entry(ParkingBuilding building, Vehicle vehicle) {
        return building.allocate(vehicle);
    }
}
