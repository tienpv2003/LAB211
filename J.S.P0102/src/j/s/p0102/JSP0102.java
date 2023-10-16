package j.s.p0102;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class JSP0102 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.println("Please enter date with format [dd/MM/yyyy]: ");
            String inputDateStr = scanner.nextLine(); //input

            // Kiểm tra định dạng ngày tháng hợp lệ
            if (!isValidDateFormat(inputDateStr)) {
                System.out.println("Invalid date format. Please use the format [dd/MM/yyyy].");
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                try {
                    Date inputDate = dateFormat.parse(inputDateStr);

                    int day = Integer.parseInt(inputDateStr.split("/")[0]);
                    int month = Integer.parseInt(inputDateStr.split("/")[1]);
                    int year = Integer.parseInt(inputDateStr.split("/")[2]);

                    if (isValidDate(day, month, year)) {
                        SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE");
                        String dayOfWeek = dayOfWeekFormat.format(inputDate);
                        System.out.println("Your day is " + dayOfWeek);
                        isValidInput = true; // Đã có đầu vào hợp lệ, thoát khỏi vòng lặp
                    } else {
                        System.out.println("Invalid date.");
                    }
                } catch (ParseException e) {
                    System.out.println("Invalid date.");
                }
            }
        }
        scanner.close();
    }

    public static boolean isValidDateFormat(String inputDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inputDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public static boolean isValidDate(int day, int month, int year) {
        if (day < 1 || month < 1 || month > 12) {
            return false;
        }

        if (month == 2) {
            // Kiểm tra năm nhuận
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (isLeapYear) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        } else {
            return day <= 31;
        }
    }
}
