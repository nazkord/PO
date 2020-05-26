package pl.edu.agh.internetshop;

public interface MoneyTransferPaymentTransaction extends PaymentMethod {
    boolean validate(MoneyTransfer transfer);
}
