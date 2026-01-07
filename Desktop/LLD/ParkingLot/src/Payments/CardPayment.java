package Payments;

public class CardPayment implements Payment {

    @Override
    public boolean pay(Double amount) {
        System.out.println("Paid though card" + amount);
        return true;
    }
}
