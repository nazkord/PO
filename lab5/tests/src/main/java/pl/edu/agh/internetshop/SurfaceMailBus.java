package pl.edu.agh.internetshop;


public interface SurfaceMailBus extends ShipmentMethod {
    boolean isSent(Object shipment);
}
