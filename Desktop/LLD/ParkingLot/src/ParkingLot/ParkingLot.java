package ParkingLot;

import Entities.Ticket;
import Entities.Vehicle;
import Payments.Payment;

public class ParkingLot {
    private final ParkingBuilding parkingBuilding;
    private final EntryGate entryGate;
    private final ExitGate exitGate;

    public ParkingLot(ParkingBuilding parkingBuilding, EntryGate entryGate, ExitGate exitGate) {
        this.parkingBuilding = parkingBuilding;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }
    public Ticket vehicleEntry(Vehicle vehicle) {
        return  entryGate.entry(parkingBuilding,vehicle);
    }
    public void vehicleRelease(Ticket ticket, Payment payment) {
        exitGate.processExit(parkingBuilding, ticket, payment);
    }

}
