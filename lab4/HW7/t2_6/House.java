/**
* HW7
* lab4 House class implementation.
* Run file t2_6.java to check the result.
* @author Yaroslav Yanhol
*/

package lab4.HW7.t2_6;

public class House {

    private int id;
    private int apartmentNumber;
    private double area;
    private int floor;
    private int roomsAmount;
    private String street;
    private String buildingType;
    private int lifespan;

    public House(int id, int apartmentNumber, double area, int floor, 
            int roomsAmount, String street, String buildingType, int lifespan) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.roomsAmount = roomsAmount;
        this.street = street;
        this.buildingType = buildingType;
        this.lifespan = lifespan;
    }

    House(int id) {
        this(id, 0, 0.0, 0, 0, 
            null, null, 0);
    }

    House() {}

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoomsAmount() {
        return roomsAmount;
    }

    public void setRoomsAmount(int roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    @Override
    public String toString() {
        return "House ID: " + id +
                ", Apartment Number: " + apartmentNumber +
                ", Area: " + area + " sq. m" +
                ", Floor: " + floor +
                ", Number of Rooms: " + roomsAmount +
                ", Street: " + street +
                ", Building Type: " + buildingType +
                ", Lifespan: " + lifespan;
    }

    public void ConsoleOut() {
        System.out.println(this.toString());
    }

    public static House[] createHouseArray(int size) {
        House[] houses = new House[size];
        for (int i = 0; i < size; i++) {
            houses[i] = new House();
        }
        return houses;
    }

}
