package Priceing;

import Entities.Ticket;

public class FixedPricingStrategy implements PricingStrategy  {
    @Override
    public double calculates(Ticket ticket) {
        return 100;
    }
}
