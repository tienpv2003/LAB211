/**
 * Class Manager do main function of program : create fruit, show list of order,
 * shopping for buyer, and display list of fruit
 *
 * @author PhamVinhTien
 * @version 1.0 6/Oct/2023
 */
package j1.s.p0023;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Manager {

    // let fruits in arraylist to save list Fruit
    List<Fruit> fruits = new ArrayList<>();

    // let fruits in arraylist to save list Fruit
    Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();
    Validation validation = new Validation();

    /**
     * Function check id of fruit , if ID match ,return fruit
     *
     * @param ID
     */
    public Fruit getFruitByID(String id) {

        //B1: Loop each fruit of fruits
        for (Fruit fruit : fruits) {

            //B2: Match ID, if equal then return fruit, otherwise return null
            if (id.equals(fruit.getFruitID())) {
                return fruit;
            }
        }
        return null;
    }

    /**
     * Function use to create Fruit for user, and add in List<Fruit>
     *
     */
    public void createFruit() {
        String fruitName;
        double price;
        int quantity;
        String origin;

        while (true) {

            //B1: Enter ID. ".+" the hien chuoi do khong duoc rong           
            String fruitID = validation.getString(Message.FRUITID, Message.FORMATEMPTY);

            /* B2: Check ID exist or not, if exist, request re-entry, after add 
             * name, price,quantity,origin from keyboard
             */
            if (getFruitByID(fruitID) != null) {
                System.err.println(Message.EXIST);
                continue;
            }
            fruitName = validation.getString(Message.FRUITNAME, Message.FORMATSTRING);
            price = validation.getDouble(Message.FRUITPRICE, 1, Double.MAX_VALUE);
            quantity = validation.getInt(Message.FRUITQUANTITY, 1, Integer.MAX_VALUE);
            origin = validation.getString(Message.FRUITORIGIN, Message.FORMATSTRING);

            //B3: Add in List<Fruit> by collections add
            fruits.add(new Fruit(fruitID, fruitName, price, quantity, origin));

            //B4: Ask user want to enter more, if not,break program
            if (!validation.checkYN(Message.CHECKYN)) {
                System.err.println(Message.ADD);
                break;
            }
        }
    }

    /**
     * Function use to check quantity of fruit in shop
     *
     * @param quantity of Fruit
     */
    public Fruit getFruit(int quantity) {

        //B1: variable initiazation count
        int count = 0;

        //B2: loop each fruit of List<Fruit>
        for (Fruit fruit : fruits) {

            //B3: check quantity, if different from 0, count increase
            if (fruit.getQuantity() != 0) {
                count++;
            }

            /* B4: if quantity equal count, fruit is exist in shop, if not, 
            * quantity over max limit or out of stock  in shop
             */
            if (quantity == count) {
                return fruit;
            }
        }
        return null;
    }

    /**
     * Function use to check Fruit in order or not
     *
     * @param listOrder
     * @param id of fruit
     */
    public Fruit checkFruitInOrder(ArrayList<Fruit> listOrder, String id) {

        //B1: loop each fruit in listOrder
        for (Fruit fruit : listOrder) {

            //B2: check ID fruit and compare with new ID, if equals return fruit
            if (fruit.getFruitID().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }

    /**
     * Function display List Of Fruit in shop
     *
     */
    public int displayListFruit() {

        int count = 0;//variable initiazation count
        int min = 1;//variable initiazation min is min value 

        //B1: Check fruit have Empty or not, if empty return -1
        if (fruits.isEmpty()) {
            return -1;
        }

        //B2: Loop each fruit of fruits
        for (Fruit fruit : fruits) {

            //B3: Check quantity of fruit, if count increase , the product is still in store
            if (fruit.getQuantity() != 0) {
                count++;

                //B4: if count equal min, show list of fruit for buyer
                if (count == min) {
                    System.out.printf(Message.DISPLAYFRUIT, Message.DISPLAYITEM,
                            Message.DISPLAYFRUITNAME, Message.DISPLAYORIGIN, Message.DISPLAYPRICE);
                }
                System.out.printf(Message.DISPLAYOUTFRUIT, count,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }

        //B5: if count equal 0, the product out of stock 
        if (count == 0) {
            return -1;
        }

        //B6: variable initiazation item , be enter from user want to buy product
        int item = validation.getInt(Message.ITEM, min, count);
        return item;
    }

    /**
     * Function display List Of Fruit and allows buyers to choose products and
     * update quantity in list fruit
     */
    public void shopping() {

        //variable initiazation listOrder from arraylist
        ArrayList<Fruit> listOrder = new ArrayList<>();

        String name;
        int item;
        int min;
        int quantity;

        //use while for false
        while (true) {

            //B1: Check quantity if equal -1 then remove from the list
            item = displayListFruit();
            min = -1;
            if (item == min) {
                System.out.println(Message.STOCK);
                return;
            }

            //B2: Request user select fruit want to buy
            Fruit fruit = getFruit(item);
            System.out.println(Message.SELECT + fruit.getFruitName());

            //B3: Request user enter quantity want to buy
            quantity = validation.getInt(Message.FRUITQUANTITY, 0, fruit.getQuantity());

            //B4: set again quantity in list
            fruit.setQuantity(fruit.getQuantity() - quantity);

            /* B5: check this order have equal before ID order or not, 
             * if different null, update new quantity in order  
             */
            Fruit fruitInOrder = checkFruitInOrder(listOrder,
                    fruit.getFruitID());
            if (fruitInOrder != null) {
                fruitInOrder.setQuantity(fruitInOrder.getQuantity() + quantity);

                //B6: if equal null and different 0, add new order in listOrder
            } else {
                if (quantity != 0) {

                    listOrder.add(new Fruit(fruit.getFruitID(),
                            fruit.getFruitName(), fruit.getPrice(),
                            quantity, fruit.getOrigin()));
                }
            }

            //B7: ask user want to buy continue or not?
            if (!validation.checkYN(Message.CHECKYN)) {
                break;
            }
        }

        /* B8: Check listOrder empty or not, if not, display listOrder
         * of this person , and request enter name, and put in List Order
         */
        if (listOrder.isEmpty()) {
            System.out.println(Message.NO_ORDER);
        } else {
            displayListOrder(listOrder);
            name = setName();
            orders.put(name, listOrder);
        }
    }

    /**
     * Function request user input name and check name have equal before name in
     * order or not
     */
    public String setName() {

        String realName;
        int count;
        String name;

        //B1: Request user input name
        name = validation.getString(Message.ENTERNAME, Message.FORMATSTRING);
        count = 0;

        //B2: Loop each namekey of orders by keySet(), can check 
        for (String namekey : orders.keySet()) {

            /* B3:Each order name (key) typically includes the customer name and
             * a count (#). This line is used to separate the customer name (the
             * part before the # sign) from the order name (key).
             */
            realName = namekey.split(Message.DAU_THANG)[0];

            //B4:Check if the name the user entered matches the customer name in an existing order.
            if (name.equals(realName)) {

                /* If equal, an order from this customer has been found, 
                 * so count increased  1 to count the number of their orders.
                 */
                count++;
            }
        }
        return name + Message.DAU_THANG + count;
    }

    /**
     * Function display list order of buyer
     *
     * @param listOrder
     */
    public void displayListOrder(ArrayList<Fruit> listOrder) {
        double total = 0;

        //B1: Show list order of buyer
        System.out.println(Message.DISPLAYLISTORDER);

        //B2: loop each fruit in listOrder
        for (Fruit fruit : listOrder) {

            //B3: display product of user bought
            System.out.printf(Message.LISTORDER, fruit.getFruitName(),
                    fruit.getQuantity(), fruit.getPrice(),
                    fruit.getPrice() * fruit.getQuantity());

            //B4: Calculate price with quantity of user bought
            total += fruit.getPrice() * fruit.getQuantity();
        }

        //B5: Display in screen
        System.out.println(Message.TOTAL + total + Message.MONEY);
    }

    /**
     * Function display list order to manager orders that customer have
     * purchased at the shop
     *
     */
    public void viewOrder() {
        ArrayList<Fruit> listOrder;

        //B1: Check orders is empty or not
        if (orders.isEmpty()) {
            System.out.println(Message.NO_ORDER);
            return;
        }

        //B2: Loop each name in orders by keySet
        for (String name : orders.keySet()) {

            //B3: Display name customer 
            System.out.println(Message.CUSTOMER + name.split(Message.DAU_THANG)[0]);

            //B4: And get name with product of this person
            listOrder = orders.get(name);

            //B5: Display product of this person have purchased
            displayListOrder(listOrder);
        }
    }

    /**
     * Function create a list of avaible fruit in shop
     */
    public void generateFruit() {
        fruits.add(new Fruit("1", "Coconut", 2, 5, "VietNam"));
        fruits.add(new Fruit("2", "Banana", 3, 6, "ThaiLand"));
        fruits.add(new Fruit("3", "Grape", 4, 10, "USA"));
    }
}
