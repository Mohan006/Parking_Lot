import Entities.ParkingSpot;
import Entities.Ticket;
import Entities.Vehicle;
import LookupStrategy.ParkingSpotLookupStrategy;
import LookupStrategy.RandomLookupStrategy;
import ParkingLot.ParkingBuilding;
import ParkingLot.ParkingLevel;
import ParkingLot.ParkingLot;
import Payments.CardPayment;
import Payments.CashPayment;
import Priceing.CostComputation;
import Priceing.FixedPricingStrategy;
import SpotManagers.FourWheelerSpotManager;
import SpotManagers.ParkingSpotManager;
import SpotManagers.TwoWheelerSpotManager;
import enums.VehicleType;
import  ParkingLot.EntryGate;
import  ParkingLot.ExitGate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingSpotLookupStrategy strategy = new RandomLookupStrategy();
        Map<VehicleType, ParkingSpotManager> levelOneManagers = new HashMap<>();
        levelOneManagers.put(VehicleType.TWO_WHEELER,
                new TwoWheelerSpotManager(List.of(new ParkingSpot("L1-S1"),
                        new ParkingSpot("L1-S2")), strategy));
        levelOneManagers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerSpotManager(List.of(new ParkingSpot("L1-S3")), strategy));

        ParkingLevel level1 = new ParkingLevel(1,levelOneManagers);
        Map<VehicleType, ParkingSpotManager> levelTwoManagers = new HashMap<>();
        levelTwoManagers.put(VehicleType.TWO_WHEELER,
                new TwoWheelerSpotManager(List.of(new ParkingSpot("L2-S1")), strategy));

        levelTwoManagers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerSpotManager(List.of(new ParkingSpot("L2-S2"),
                        new ParkingSpot("L2-S3")), strategy));


        ParkingLevel level2 = new ParkingLevel(
                2, levelTwoManagers
        );

        ParkingBuilding parkingBuilding = new ParkingBuilding(List.of(level2,level1));
        ParkingLot parkingLot = new ParkingLot(
                parkingBuilding,new EntryGate(), new ExitGate(new CostComputation(new FixedPricingStrategy()))
        );

        Vehicle bike = new Vehicle(VehicleType.TWO_WHEELER, "BIKE-101");
        Vehicle car = new Vehicle(VehicleType.FOUR_WHEELER,"CAR-201");
        Ticket t1 = parkingLot.vehicleEntry(bike);
        Ticket t2 = parkingLot.vehicleEntry(car);
        parkingLot.vehicleRelease(t1, new CardPayment());
        parkingLot.vehicleRelease(t2,new CashPayment());

    }

}
