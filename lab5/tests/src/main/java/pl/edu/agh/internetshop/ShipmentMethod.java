package pl.edu.agh.internetshop;


public interface ShipmentMethod {
    boolean send(Object shipment, Address sender, Address recipient);
}
