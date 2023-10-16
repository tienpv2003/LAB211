/**
 * Class Validate: check valid input
 *
 * @author PhạmVinhTiến
 * @version 1.0 14/Oct/2023
 */
package j1.s.p0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validate {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Function checkIntLimit Task: Check limit input Number
     *
     * @param min: smallest number value received
     * @param max: max number value received
     * @return
     */
    public static int checkIntLimit(int min, int max) {

        //b1: create parameter
        int number;

        // b2: use loop and try catch to catch error
        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine());

                //b2.1: Check limited number
                if ((number < min) || (number > max)) {
                    throw new NumberFormatException();
                }
                return number;

                //b2.2: if error number will catch
            } catch (NumberFormatException ex) {
                System.err.println(Message.LIMIT_INT);
                System.out.print(Message.ENTER_AGAIN);
            }
        }
    }

    /**
     * Function checkInputDate Task: Check format date, VD: 23-06-2015
     *
     * @return
     */
    public static String checkInputDate() {

        //b1: create parameter
        String result;
        SimpleDateFormat dateFormat;
        Date date;

        //b2: use loop and try catch to catch error
        while (true) {
            try {
                result = scanner.nextLine().trim();

                //b2.1: check fomat date
                dateFormat = new SimpleDateFormat(Message.FOMAT_DATE);
                date = dateFormat.parse(result);

                //b2.2: Check date valid regex
                if (result.equalsIgnoreCase(dateFormat.format(date))) {
                    return result;
                } else {
                    System.err.println(Message.RE_INPUT);
                    System.out.print(Message.ENTER_AGAIN);
                }

                //b2.3: if error date fomat will catch
            } catch (NumberFormatException ex) {
                System.err.println(Message.RE_INPUT);
                System.out.print(Message.ENTER_AGAIN);
            } catch (ParseException ex) {
                System.err.println(Message.RE_INPUT);
                System.out.print(Message.ENTER_AGAIN);
            }
        }
    }

    /**
     * Function checkInputString Task: Check format string, not empty
     *
     * @return
     */
    public static String checkInputString() {

        //b1: create parameter
        String result;
        while (true) {
            result = scanner.nextLine().trim();

            //b2: check length of string > 0
            if (result.length() == 0) {
                System.err.println(Message.NOT_EMPTY);
                System.out.print(Message.ENTER_AGAIN);
            } else {
                return result;
            }
        }
    }

    /**
     * Function checkInputInt Task: Check typeInt, is number
     *
     * @return
     */
    public static int checkInputInt() {

        //b1: create parameter  
        int result;
        while (true) {
            try {

                //b2: parse string to Interger, if int return
                result = Integer.parseInt(scanner.nextLine());
                return result;

                //b3: if don't type int catch
            } catch (NumberFormatException ex) {
                System.err.println(Message.RE_INPUT);
                System.out.print(Message.ENTER_AGAIN);
            }
        }
    }

    /**
     * Function checkInputTaskTypeId Task: Check limit task type id: 1-4, and
     * help users choice task type id
     *
     * @return
     */
    public static String checkInputTaskTypeId() {

        //b1: create parameter   
        int choice;
        String result = null;

        //b2: use loop and switch case need user choicetask type id
        while (true) {

            //b2.1: call checkIntLimit need check limit choice
            choice = checkIntLimit(1, 4);
            result = null;
            switch (choice) {

                //case 1: task type id = code
                case 1:
                    result = Message.CODE;
                    break;

                //case 2:task type id = test
                case 2:
                    result = Message.TEST;
                    break;

                //case 3:task type id = Design
                case 3:
                    result = Message.DESIGN;
                    break;

                // case 4:task type id = Review
                case 4:
                    result = Message.REVIEW;
            }
            return result;
        }
    }

    /**
     * Function checkInputPlan Task: Check limit PlanTo > 8.0, PlanFrom > 17.5
     *
     * @return
     */
    public static String checkInputPlan() {

        //b1: create parameter
        String result;
        while (true) {

            //b2: check input not empty
            result = checkInputString();

            //b3: Check limit PlanTo > 8.0, PlanFrom > 17.5
            if (((result.matches(Message.PLAN_VALID)
                    && Double.parseDouble(result) >= Message.TIME_START_JOB)
                    && Double.parseDouble(result) <= Message.TIME_END_JOB)) {
                return result;
            } else {
                System.err.println(Message.RE_INPUT);
                System.out.print(Message.ENTER_AGAIN);
            }
        }
    }

    /**
     * Function checkInputPlanTo Task: Check PlanFrom < PlanTo
     *
     * @param planFrom: time to start
     * @return
     */
    public static String checkInputPlanTo(String planFrom) {

        //b1: create parameter
        String planTo;
        while (true) {

            //b2: enter planTo and call functuon checkInputPlan() need check plan
            System.out.print(Message.ENTER_PLAN_TO);
            planTo = checkInputPlan();

            //b3: Check  PlanTo > PlanFrom
            if (Double.parseDouble(planTo) > Double.parseDouble(planFrom)) {
                return planTo;
            } else {
                System.err.println(Message.TO_GRATE_FROM);
            }
        }
    }
}
