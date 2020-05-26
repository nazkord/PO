package pl.edu.agh.internetshop;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ShipmentTest {
    
    @Test
    public void testGetSenderAddressThroughShipment() {
    	// given
    	Address senderAddress = mock(Address.class);
		Address recipientAddress = mock(Address.class);
		Shipment shipment = new Shipment(senderAddress, recipientAddress);
    	
    	// when
		Address actualSenderAddress = shipment.getSenderAddress();
		
    	// then
        assertSame(senderAddress, actualSenderAddress);
    }

    @Test
    public void testGetRecipientAddressThroughShipment() {
    	// given
    	Address senderAddress = mock(Address.class);
		Address recipientAddress = mock(Address.class);
		Shipment shipment = new Shipment(senderAddress, recipientAddress);
    	
    	// when
		Address actualRecipientAddress = shipment.getRecipientAddress();
		
    	// then
        assertSame(recipientAddress, actualRecipientAddress);
    }

    private Shipment getShipmentWithMockedAddresses()
	{
		Address senderAddress = mock(Address.class);
		Address recipientAddress = mock(Address.class);
		return new Shipment(senderAddress, recipientAddress);
	}
    
    @Test
    public void testSetShipped() throws Exception {
    	// given
    	Shipment shipment = getShipmentWithMockedAddresses();
    	
    	// when
    	shipment.setShipped(true);
    	
    	// then
        assertTrue(shipment.isShipped());
    }
    
    @Test
    public void testSetShippedWithoutSetting() throws Exception {
    	// given
    	Shipment shipment = getShipmentWithMockedAddresses();
    	
    	// when
    	
    	// then
        assertFalse(shipment.isShipped());
    }
}
