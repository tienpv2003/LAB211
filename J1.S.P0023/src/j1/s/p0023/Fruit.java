/**
 * Class contains attributes, generate constructor, getter and setter all
 *
 * @author PhamVinhTien
 * @version 1.0 6/Oct/2023
 */
package j1.s.p0023;

public class Fruit {

    /* ID of fruit */
    private String fruitID;

    /* Name of fruit*/
    private String fruitName;

    /* Price of fruit */
    private double price;

    /*quantity of fruit*/
    private int quantity;

    /* Origin of fruit */
    private String origin;


    /* Contrustor no parameter */
    public Fruit() {
    }

    /**
     * Contrustor parameter
     *
     * @param fruitID
     * @param fruitName
     * @param price
     * @param quantity
     * @param origin
     */
    public Fruit(String fruitID, String fruitName, double price, int quantity, String origin) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getFruitID() {
        return fruitID;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
