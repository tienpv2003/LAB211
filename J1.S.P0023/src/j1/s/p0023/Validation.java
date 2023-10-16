/**
 * Class valid use to check value input from user, if user enter wrong, program
 * request enter again, and catch the exception
 *
 * @author PhamVinhTien
 * @version 1.0 6/Oct/2023
 */
package j1.s.p0023;

import java.util.Scanner;

public class Validation {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Function check Integer input from user, allows enter in limit, if user
     * enter wrong , will catch exception
     *
     * @param mess to display message
     * @param min allows enter min value
     * @param max allows enter max value
     */
    public int getInt(String mess, int min, int max) {
        String input;
        int number;

        //B1: display message want to show
        System.out.print(mess);
        while (true) {

            //B2: create input from keyboard
            input = scanner.nextLine();
            try {

                //B3: parse from String to Integer
                number = Integer.parseInt(input);

                /* B4: check limit of number, if exceeds the allowable limit 
                 * requires enter agaain, otherwise, return it 
                 */
                if (number < min || number > max) {
                    System.out.print(Message.INPUTBETWEEN + min + Message.PHAY
                            + max + Message.CL + Message.HAI);
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print(Message.INTEGER);
            }
        }
    }

    /**
     * Function check Double input from user, allows enter in limit, if user
     * enter wrong , will catch exception
     *
     * @param mess to display message
     * @param min allows enter min value
     * @param max allows enter max value
     */
    public double getDouble(String mess, double min, double max) {
        String input;
        double number;

        //B1: display message want to show
        System.out.print(mess);
        while (true) {

            //B2: create input from keyboard
            input = scanner.nextLine();
            try {

                //B3: parse from String to Double
                number = Double.parseDouble(input);

                /**
                 * B4: check limit of number, if exceeds the allowable limit
                 * requires enter again, otherwise, return it
                 */
                if (number < min || number > max) {
                    System.out.print(Message.INPUTBETWEEN + min + Message.PHAY
                            + max + Message.CL + Message.HAI);
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print(Message.DOUBLE);
            }
        }
    }

    /**
     * Function check String input from user and show regex requires user input
     * correct
     *
     * @param mess to display message
     * @param regex to show users entering in the correct format
     */
    public String getString(String mess, String regex) {
        String input;
        //B1: display message want to show
        System.out.print(mess);
        while (true) {

            //B2: create input from keyboard
            input = scanner.nextLine();

            /* B3: Check match , if wrong format, requires enter again, 
             *  otherwise , return it
             */
            if (!input.matches(regex)) {
                System.out.print(Message.REGEX + regex +
                        Message.CL + Message.HAI);
                continue;
            }
            return input;
        }
    }

    /**
     * Function check requires from user , just allow enter Y or N
     *
     * @param mess to display message
     */
    public boolean checkYN(String mess) {
        String result;
        
        //B1: display message want to show
        System.out.print(mess);
        while (true) {
            
            //B2: create input from keyboard
            result = scanner.nextLine();
            
            //B3: input equal "Y" return true,equal "N" return false
            if (result.equalsIgnoreCase(Message.YES)) {
                return true;
            }

            if (result.equalsIgnoreCase(Message.NO)) {
                return false;
            }
            System.err.print(Message.INPUTYS);
            System.out.println(Message.AGAIN);
        }
    }
}
