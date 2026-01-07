package LookupStrategy;

import Entities.ParkingSpot;

import java.util.List;

public class RandomLookupStrategy implements ParkingSpotLookupStrategy {

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> spots) {
        for (ParkingSpot spot: spots) {
            if (spot.isFree()) {
                return  spot;
            }
        }
        return null;
    }
}
