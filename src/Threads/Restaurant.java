package Threads;

class Table {
    private int number;
    private final int chairs = 5;

    public Table(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getChairs() {
        return chairs;
    }
}

class Waiter {
    private String name;
    private int badgeNumber;

    public Waiter(int badgeNumber, String name) {
        this.name = name;
        this.badgeNumber = badgeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }
}

class Address {
    private int buildingNumber;
    private String street;
    private String city;
    private String state;

    public Address(int buildingNumber, String street, String city, String state) {
        this.buildingNumber = buildingNumber;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

public class Restaurant {
    private String name;
    private Table[] tables;
    private Address address;
    private Waiter waiters[];
    private int numWaiters;
    private int numTables;

    public Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void buildTables(int numTables) {
        if(numTables > 0) {
            this.numTables = numTables;
            tables = new Table[numTables];
            for(int i = 0; i < numTables; ++i) {
                tables[i] = new Table(i + 1);
            }
        }
    }

    public void assignWaiters(int numWaiters) {
        if(numWaiters > 0) {
            this.numWaiters = numWaiters;
            waiters = new Waiter[numWaiters];
            for(int i = 0; i < numWaiters; ++i) {
                waiters[i] = new Waiter(i + 1, String.valueOf((char)((int)'a' + i)));
            }
        }
    }

    @Override
    public String toString() {
        return "This joint of " + this.name + " located at " + this.address.getStreet() + " in " + 
                this.address.getCity() + " has " + this.numWaiters + " waiters and " + this.numTables + " tables";
    }

    public static void main(String[] args) {
        Restaurant dominos = new Restaurant("Domino's");
        Address address = new Address(140, "W Taylor", "Chicago", "Illinois");
        dominos.setAddress(address);
        dominos.assignWaiters(25);
        dominos.buildTables(20);
        System.out.println(dominos);
    }
}