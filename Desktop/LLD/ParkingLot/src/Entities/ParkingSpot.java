package Entities;

public class ParkingSpot {
    private final String spotId;
    private boolean isFree = true;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
    }

    public String getSpotId() {
        return spotId;
    }

    public boolean isFree() {
        return isFree;
    }
    public void occupySpot() {
        isFree = false;
    }
    public void releaseSpot(){
        isFree = true;
    }
}
