package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {
    
    @Test
    public void testCreation() {
    	// given
    	String name = "Adam Smith";
        String streetAndHomeNr = "1234 Main Street";
        String postalCode = "01003";
        String city = "New York";
        
        // when
        Address address = new Address(name, streetAndHomeNr, postalCode, city);
        
        // then    	
        assertEquals(name, address.getName());
        assertEquals(streetAndHomeNr, address.getStreetAndHomeNr());
        assertEquals(postalCode, address.getPostalCode());
        assertEquals(city, address.getCity());
    }
}