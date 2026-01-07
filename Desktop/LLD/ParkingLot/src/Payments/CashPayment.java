package Payments;

public class CashPayment implements Payment {
    @Override
    public boolean pay(Double amount) {
        System.out.println("paid though cash" + amount);
        return true;
    }
}
