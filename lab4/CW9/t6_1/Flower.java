/**
* CW9
* lab4 Flower realization for t6_1 performance.
* Run file t6_1.java to check the result.
* @author Yaroslav Yanhol
*/
package lab4.CW9.t6_1;

/**
 * Represents a flower with properties such as name, freshness, stem length, and cost.
 */
class Flower {

    private String name;
    private int freshness;
    private double stemLength;
    private double cost;

    /**
     * Constructs a Flower object with the specified properties.
     *
     * @param name        The name of the flower.
     * @param freshness   The freshness level of the flower.
     * @param stemLength  The length of the flower's stem.
     * @param cost        The cost of the flower.
     */
    public Flower(String name, int freshness, double stemLength, double cost) {
        this.name = name;
        this.freshness = freshness;
        this.stemLength = stemLength;
        this.cost = cost;
    }

    // Getters and setters for Flower properties

    /**
     * Returns the name of the flower.
     *
     * @return The name of the flower.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the flower.
     *
     * @param name The new name of the flower.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the freshness level of the flower.
     *
     * @return The freshness level of the flower.
     */
    public int getFreshness() {
        return freshness;
    }

    /**
     * Sets the freshness level of the flower.
     *
     * @param freshness The new freshness level of the flower.
     */
    public void setFreshness(int freshness) {
        this.freshness = freshness;
    }

    /**
     * Returns the length of the flower's stem.
     *
     * @return The length of the flower's stem.
     */
    public double getStemLength() {
        return stemLength;
    }

    /**
     * Sets the length of the flower's stem.
     *
     * @param stemLength The new length of the flower's stem.
     */
    public void setStemLength(double stemLength) {
        this.stemLength = stemLength;
    }

    /**
     * Returns the cost of the flower.
     *
     * @return The cost of the flower.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost of the flower.
     *
     * @param cost The new cost of the flower.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns a string representation of the flower.
     *
     * @return A string representation of the flower.
     */
    @Override
    public String toString() {
        return "Flower{name='" + name + "', freshness=" + freshness +
                ", stemLength=" + stemLength + ", cost=" + cost + '}';
    }
    
}

