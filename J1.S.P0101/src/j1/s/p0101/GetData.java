/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0101;

/**
 *
 * @author PhạmVinhTiến
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *
 */
public class GetData {

    int getInteger(Scanner sc, String msg, int min, int max) {
        String input;
        int IntNumber = Message.NEGATIVE_ONE;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println(Message.INPUT_NOT_EMPTY);
                continue;
            }
            try {
                IntNumber = Integer.parseInt(input);
                //check choice in range min and max
                if (IntNumber >= min && IntNumber <= max) {
                    break;
                } else {
                    System.out.println(Message.INPUT_RANGE);
                    continue;
                }
            } catch (NumberFormatException ex) {
                System.out.println(Message.INPUT_INTEGER);
            }
        } while (true);
        return IntNumber;
    }

    String getString(Scanner sc, String msg, String regex) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println(Message.INPUT_NOT_EMPTY);
                continue;
            } else {
                if (regex.isEmpty()) {
                    break;
                } else if (input.matches(regex)) {
                    break;
                } else {
                    System.out.println(Message.INPUT_NOT_MATCH);
                    continue;
                }
            }
        } while (true);
        return input;
    }

    Date getDate(Scanner sc, String msg) {
        String input;
        Date date;
        do {
            System.out.print(msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println(Message.INPUT_NOT_EMPTY);
                continue;
            } // \d{1,2}: the number have 1 or 2 digit number
            //[/]: contain character /
            //\d{4}: the number must have 4 digit
            else if (!input.matches(Message.INPUT_FORMAT)) {
                System.out.println(Message.INPUT_WRONG_FORMAT);
                continue;
            }
            try {
                date = dateFormat.parse(input);
                break;
            } catch (ParseException exception) {
                System.out.println(Message.DATE_NOT_EXIST);
            }
        } while (true);
        return date;
    }
}
