package ParkingLot;

import Entities.Ticket;
import Payments.Payment;
import Priceing.CostComputation;

public class ExitGate {
    private final CostComputation costComputation;

    public ExitGate(CostComputation costComputation) {
        this.costComputation = costComputation;
    }
    public void processExit(ParkingBuilding parkingBuilding, Ticket ticket, Payment payment){
        double price = calculatePrice(ticket);
        boolean paymentDon = payment.pay(price);
        if (!paymentDon) {
            throw new RuntimeException("payment failed for some reason");
        }
        parkingBuilding.release(ticket);
        System.out.println("payment done , exit permitted");
    }
    public double calculatePrice(Ticket ticket) {
        return costComputation.compute(ticket);
    }
}
