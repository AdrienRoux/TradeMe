package fr.esgi.al.addMemberShip.domain;

public class Location {

    private String address;
    private String city;

    public Location(String address, String city) {
        this.address = address;
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }
}
