package pl.edu.agh.internetshop;

public class Shipment {

    private boolean shipped;
    private Address senderAddress;
    private Address recipientAddress;

    public Shipment(Address senderAddress, Address recipientAddress) {
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
        shipped = false;
    }

    public Address getSenderAddress() { return senderAddress; }

    public Address getRecipientAddress() { return recipientAddress; }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }
}
