/**
 * Class main contains all the main function of program
 *
 * @author PhamVinhTien
 * @version 1.0 6/Oct/2023
 */
package j1.s.p0023;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Validation validation = new Validation();

        // call function 
        manager.generateFruit();

        //Choice until user want exist
        while (true) {
            System.out.println(Message.MENU);
            System.out.println(Message.CREATE);
            System.out.println(Message.ORDER);
            System.out.println(Message.SHOPPING);
            System.out.println(Message.EXIT);
            int choice = validation.getInt(Message.VIEW, 1, 4);
            switch (choice) {
                case 1:
                    // create fruit
                    manager.createFruit();
                    break;
                case 2:
                    //check order of buyer 
                    manager.viewOrder();
                    break;
                case 3:
                    // show list of fruit for buyer and order
                    manager.shopping();
                    break;
                case 4:
                    // exit program
                    System.exit(0);
            }
        }
    }
}
