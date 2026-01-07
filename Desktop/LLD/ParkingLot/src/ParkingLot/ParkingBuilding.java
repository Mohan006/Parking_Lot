package ParkingLot;

import Entities.ParkingSpot;
import Entities.Ticket;
import Entities.Vehicle;

import java.util.List;

public class ParkingBuilding {
    private final List<ParkingLevel> levels;

    public ParkingBuilding(List<ParkingLevel> levels) {
        this.levels = levels;
    }
    public Ticket allocate(Vehicle vehicle) {
        for (ParkingLevel level: levels) {
            if (level.checkAvailability(vehicle.getVechileType())){
                ParkingSpot spot = level.park(vehicle.getVechileType());
                if (spot != null) {
                    Ticket ticket = new Ticket(vehicle,level,spot);
                    System.out.println("Parking allocated at level: "
                            + level.getLevelNumber()
                            + " spot: " + spot.getSpotId());
                    return ticket;
                }
            }
        }
        throw new RuntimeException("Parking Full");
    }
    void release(Ticket ticket) {
        ticket.getLevel().unPark(
                ticket.getVehicle().getVechileType(),
                ticket.getSpot()
        );
    }



}
