/**
* HW7
* lab4 t2_6.
* Run file t2_6.java to check the result.
* @author Yaroslav Yanhol
*/

package lab4.HW7.t2_6;

public class t2_6 {

    public static void main(String[] args) {

        House[] tHousesArray = House.createHouseArray(7);

        // base info
        String[] buildingTypes = {"Apartment", "House", "Mansion"};
        String[] streets = {
            "Main Street", "Oak Avenue", "Pine Street", "Maple Lane"
        };

        // Other info generation
        for (int i = 0; i < tHousesArray.length; i++) {
            tHousesArray[i].setId(i);
            tHousesArray[i].setApartmentNumber(i + 101);
            tHousesArray[i].setArea((int) (Math.random() * 150));
            tHousesArray[i].setFloor((int) (Math.random() * 11));
            tHousesArray[i].setRoomsAmount((int) (Math.random() * 6 + 1));
            tHousesArray[i].setStreet(streets[i % streets.length]);
            tHousesArray[i].setBuildingType(buildingTypes[i 
                % buildingTypes.length]);
            tHousesArray[i].setLifespan((int) (Math.random() * 100 + i));
        }

        System.out.println();
        System.out.println("List of houses: ");
        for (House house : tHousesArray) {
            house.ConsoleOut();
        }

        System.out.println();
        System.out.println("\nTask A): ");
        int roomsAmount = (int) (Math.random() * 6 + 1);
        System.out.println("\nHas " + roomsAmount + " rooms: ");
        for (House house : tHousesArray) {
            int currentRoomsAmount = house.getRoomsAmount();
            if (currentRoomsAmount == roomsAmount) {
                house.ConsoleOut();
            }
        }
        
        System.out.println();
        System.out.println("\nTask B): ");
        int roomsAmount1 = (int) (Math.random() * 6 + 1);
        int minFloor = 3;
        int maxFloor = 6;
        System.out.println("\nHas " + roomsAmount1 + " rooms and floor between "
                + minFloor + " and " + maxFloor + ": ");
        for (House house : tHousesArray) {
            int currentRoomsAmount = house.getRoomsAmount();
            if (currentRoomsAmount == roomsAmount1) {
                if (minFloor <= house.getFloor() 
                        && house.getFloor() <= maxFloor) {
                    house.ConsoleOut();
                }
            }
        }

        System.out.println();
        System.out.println("\nTask C): ");
        double area = (int) (Math.random() * 150);
        System.out.println("\nHas area > " + area + " sq. m: ");
        for (House house : tHousesArray) {
            double currentArea = house.getArea();
            if (currentArea > area) {
                house.ConsoleOut();
            }
        }
        System.out.println();

    }
    
}
