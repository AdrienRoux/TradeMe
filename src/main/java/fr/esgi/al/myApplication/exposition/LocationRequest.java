package fr.esgi.al.myApplication.exposition;

public class LocationRequest {

    public String address;
    public String city;

    @Override
    public String toString() {
        return "AddressDTO{" +
                "address='" + address + "'," +
                "city='" + city + "'" +
                '}';
    }
}

