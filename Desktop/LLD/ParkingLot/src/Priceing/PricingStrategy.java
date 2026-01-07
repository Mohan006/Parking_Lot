package Priceing;

import Entities.Ticket;

public interface PricingStrategy {
    double calculates(Ticket ticket);
}
