/**
* CW9
* lab4 t6_1.
* Run file t6_1.java to check the result.
* @author Yaroslav Yanhol
*/
package lab4.CW9.t6_1;

import java.util.List;
import java.util.Scanner;

public class t6_1 {

    public class ConsoleScreen {

        private static void displayMenu() {
            System.out.println("Menu:");
            System.out.println("=================================");
            System.out.println("1. Display Bouquet");
            System.out.println("2. Add Flower to Bouquet");
            System.out.println("3. Edit Flower in Bouquet");
            System.out.println("4. Remove Flower from Bouquet");
            System.out.println("5. Sort Bouquet by Freshness");
            System.out.println("6. Find Flower by Stem Length");
            System.out.println("0. Exit");
            System.out.println("=================================");

        }

        private static int getUserOption(Scanner userInput) {
            System.out.print("Enter your choice: ");
            return userInput.nextInt();
        }

        private static void clearConsole() {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                System.out.println("Error clearing the console: " + e.getMessage());
            }
        }

        private static void sleepForTwoSeconds() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private static void displayOrHideBouquet(Bouquet bouquet, Scanner userInput) {
            clearConsole();
            if (bouquet.getFlowers().isEmpty()) {
                System.out.println("Bouquet is empty. Add flowers to display.");
            } else {
                System.out.println("Bouquet:");
                int id = 0;
                for (Flower flower : bouquet.getFlowers()) {
                    System.out.println("ID: " + Integer.toString(id++) + " " + flower);
                }
            }
            System.out.println("Press enter to continue...");
            userInput.nextLine();
            userInput.nextLine();
        }

        private static void addFlowerToBouquet(Bouquet bouquet, Scanner userInput) {

            clearConsole();
            System.out.println("Enter flower details:");
            System.out.print("Name: ");
            String name = userInput.next();
            System.out.print("Freshness (int): ");
            int freshness = userInput.nextInt();
            System.out.print("Stem Length (int): ");
            double stemLength = userInput.nextDouble();
            System.out.print("Cost (int): ");
            double cost = userInput.nextDouble();

            Flower newFlower = new Flower(name, freshness, stemLength, cost);
            bouquet.addFlower(newFlower);
            System.out.println("Flower added successfully!");
            sleepForTwoSeconds();
        }

        private static void editFlowerInBouquet(Bouquet bouquet, Scanner userInput) {
            clearConsole();
            System.out.print("Enter the index of the flower to edit: ");
            int index = userInput.nextInt();

            if (index >= 0 && index < bouquet.getFlowers().size()) {
                Flower flowerToEdit = bouquet.getFlowers().get(index);

                System.out.println("Current details of the flower:");
                System.out.println(flowerToEdit);

                System.out.println("Enter new details:");

                System.out.print("Name: ");
                String newName = userInput.next();
                flowerToEdit.setName(newName);

                System.out.print("Freshness (int): ");
                int newFreshness = userInput.nextInt();
                flowerToEdit.setFreshness(newFreshness);

                System.out.print("Stem Length (int): ");
                double newStemLength = userInput.nextDouble();
                flowerToEdit.setStemLength(newStemLength);

                System.out.print("Cost (int): ");
                double newCost = userInput.nextDouble();
                flowerToEdit.setCost(newCost);

                System.out.println("Flower edited successfully!");
            } else {
                System.out.println("Invalid index. No flower to edit.");
            }

            sleepForTwoSeconds();
        }

        private static void removeFlowerFromBouquet(Bouquet bouquet, Scanner userInput) {
            clearConsole();
            System.out.print("Enter the index of the flower to remove: ");
            int index = userInput.nextInt();

            if (index >= 0 && index < bouquet.getFlowers().size()) {
                Flower removedFlower = bouquet.getFlowers().remove(index);
                System.out.println("Flower removed successfully: " + removedFlower);
            } else {
                System.out.println("Invalid index. No flower to remove.");
            }

            sleepForTwoSeconds();
        }

        private static void sortBouquetByFreshness(Bouquet bouquet, Scanner userInput) {
            clearConsole();
            bouquet.sortFlowersByFreshness();
            System.out.println("Bouquet sorted by freshness.");
            sleepForTwoSeconds();
        }

        private static void findFlowerByStemLength(Bouquet bouquet, Scanner userInput) {
            clearConsole();
            System.out.print("Enter the minimum stem length: ");
            double minLength = userInput.nextDouble();

            System.out.print("Enter the maximum stem length: ");
            double maxLength = userInput.nextDouble();

            List<Flower> foundFlowers = bouquet.findFlowersByStemLength(minLength, maxLength);

            if (!foundFlowers.isEmpty()) {
                System.out.println("Flowers found within the specified stem length range:");
                for (Flower flower : foundFlowers) {
                    System.out.println(flower);
                }
            } else {
                System.out.println("No flowers found within the specified stem length range.");
            }
            System.out.println("Press enter to continue...");
            userInput.nextLine();
            userInput.nextLine();
        }
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        Bouquet bouquet = new Bouquet();
        int option;

        do {
            ConsoleScreen.clearConsole();
            ConsoleScreen.displayMenu();
            option = ConsoleScreen.getUserOption(userInput);

            switch (option) {
                case 1:
                    ConsoleScreen.displayOrHideBouquet(bouquet, userInput);
                    break;
                case 2:
                    ConsoleScreen.addFlowerToBouquet(bouquet, userInput);
                    break;
                case 3:
                    ConsoleScreen.editFlowerInBouquet(bouquet, userInput);
                    break;
                case 4:
                    ConsoleScreen.removeFlowerFromBouquet(bouquet, userInput);
                    break;
                case 5:
                    ConsoleScreen.sortBouquetByFreshness(bouquet, userInput);
                    break;
                case 6:
                    ConsoleScreen.findFlowerByStemLength(bouquet,userInput);
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Such option not provided. Please try again.");
                    ConsoleScreen.sleepForTwoSeconds();
            }
        } while (true);
    }

}
