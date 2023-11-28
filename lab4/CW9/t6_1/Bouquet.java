/**
* CW9
* lab4 Flower bouquet realization for t6_1 performance.
* Run file t6_1.java to check the result.
* @author Yaroslav Yanhol
*/
package lab4.CW9.t6_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bouquet of flowers with methods for manipulation.
 */
class Bouquet {

    private List<Flower> flowers = new ArrayList<>();

    /**
     * Adds a flower to the bouquet.
     *
     * @param flower The flower to be added to the bouquet.
     */
    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    /**
     * Sorts the flowers in the bouquet based on freshness level in descending order.
     */
    public void sortFlowersByFreshness() {
        for (int i = 0; i < flowers.size() - 1; i++) {
            for (int j = 0; j < flowers.size() - 1 - i; j++) {
                Flower currentFlower = flowers.get(j);
                Flower nextFlower = flowers.get(j + 1);

                if (currentFlower.getFreshness() < nextFlower.getFreshness()) {
                    // Swap the flowers
                    flowers.set(j, nextFlower);
                    flowers.set(j + 1, currentFlower);
                }
            }
        }
    }

    /**
     * Calculates the total cost of the bouquet.
     *
     * @return The total cost of the bouquet.
     */
    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (Flower flower : flowers) {
            totalCost += flower.getCost();
        }
        return totalCost;
    }

    /**
     * Finds flowers in the bouquet with stem length within the specified range.
     *
     * @param minLength The minimum length of the stem.
     * @param maxLength The maximum length of the stem.
     * @return A list of flowers within the specified stem length range.
     */
    public List<Flower> findFlowersByStemLength(double minLength, double maxLength) {
        List<Flower> result = new ArrayList<>();
        for (Flower flower : flowers) {
            if (flower.getStemLength() >= minLength && flower.getStemLength() <= maxLength) {
                result.add(flower);
            }
        }
        return result;
    }

    /**
     * Collects the bouquet (implementation depends on specific requirements).
     */
    public void collectBouquet() {
        // Implementation of bouquet collection
    }

    /**
     * Changes a flower in the bouquet at the specified index.
     *
     * @param index     The index of the flower to be changed.
     * @param newFlower The new flower to replace the existing one.
     */
    public void changeFlower(int index, Flower newFlower) {
        if (index >= 0 && index < flowers.size()) {
            flowers.set(index, newFlower);
        }
    }

    /**
     * Removes a flower from the bouquet.
     *
     * @param flower The flower to be removed from the bouquet.
     */
    public void removeFlower(Flower flower) {
        flowers.remove(flower);
    }

    /**
     * Returns the list of flowers in the bouquet.
     *
     * @return The list of flowers in the bouquet.
     */
    public List<Flower> getFlowers() {
        return flowers;
    }

    /**
     * Sets the list of flowers in the bouquet.
     *
     * @param flowers The new list of flowers for the bouquet.
     */
    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }
}

