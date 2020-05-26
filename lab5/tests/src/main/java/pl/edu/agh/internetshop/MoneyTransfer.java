package pl.edu.agh.internetshop;


import java.math.BigInteger;

public class MoneyTransfer {
    private final BigInteger accountNumber;
    private final String ownerDetails;
    private final String description;
    private final int amount;
    private boolean committed;

    public MoneyTransfer(BigInteger accountNumber, String ownerDetails, String description, int amount) {
        this.accountNumber = accountNumber;
        this.ownerDetails = ownerDetails;
        this.description = description;
        this.amount = amount;
        committed = false;
    }

    public BigInteger getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerDetails() {
        return ownerDetails;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isCommitted() {
        return committed;
    }

    public void setCommitted(boolean committed) {
        this.committed = committed;
    }
}
