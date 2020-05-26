package pl.edu.agh.internetshop;


public interface PaymentMethod {
    boolean commit(MoneyTransfer transfer);
}
