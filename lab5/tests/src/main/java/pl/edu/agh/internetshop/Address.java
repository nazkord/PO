package pl.edu.agh.internetshop;

public class Address {
    private final String name;
    private final String streetAndHomeNr;
    private final String postalCode;
    private final String city;

    public Address(String name, String streetAndHomeNr, String postalCode, String city) {
        this.name = name;
        this.streetAndHomeNr = streetAndHomeNr;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getStreetAndHomeNr() {
        return streetAndHomeNr;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
