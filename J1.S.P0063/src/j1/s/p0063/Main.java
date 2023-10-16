/*
 * Class: Main chứa chương trình chính để quản lý thông tin của các người dùng.
 * @version: 1.0   29/Sep/2023
 * @author: PhạmVinhTiến
 */
package j1.s.p0063;

import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    /**
     * Hàm kiểm tra người dùng nhập vào là chuỗi.
     *
     * @return Chuỗi nhập từ người dùng.
     */
    private static String checkInputString() {
        // Lặp cho đến khi người dùng nhập đúng
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {

                // Nếu rỗng in thông báo
                System.err.println(Message.NOT_EMPTY);
            } else {

                // Trả về chuỗi
                return result;
            }
        }
    }

    /**
     * Hàm kiểm tra người dùng nhập vào là số nguyên dương.
     *
     * @return Số nguyên dương nhập từ người dùng.
     */
    private static int checkInputInt() {
        while (true) {
            // Lặp cho đến khi người dùng nhập vào là số nguyên
            try {
                int result = Integer.parseInt(in.nextLine());

                //Nếu input nhỏ hơn 0 thì vứt vào exception xử lí
                if (result <= Message.ZERO) {
                    throw new NumberFormatException();
                }

                // trả về số nguyên
                return result;
            } catch (NumberFormatException e) {

                //Thông báo nếu xảy ra ngoại lệ
                System.err.println(Message.INPUT_DIGIT);
            }
        }
    }

    /**
     * Hàm kiểm tra người dùng nhập vào là số lương (salary) hợp lệ.
     *
     * @return Số lương nhập từ người dùng.
     */
    private static double checkInputSalary() {
        while (true) {
            // Lặp cho đến khi người dùng nhập vào là số lương hợp lệ
            try {
                double result = Double.parseDouble(in.nextLine());

                //Nếu lương < 0 thì báo lỗi
                if (result < Message.ZERO) {
                    System.err.println(Message.SALARY_INVALID);
                } else {

                    //trả về lương dạng double
                    return result;
                }
            } catch (NumberFormatException e) {

                // Thông báo ngoại lệ
                System.err.println(Message.INPUT_DIGIT);
                System.out.print(Message.INPUT_SALARY_AGAIN);
            }
        }
    }

    /**
     * Hàm để người dùng nhập thông tin của một người.
     *
     * @return Đối tượng Person chứa thông tin của người vừa nhập.
     */
    private static Person inputPersonInfo() {

        //Người dùng nhập thông tin
        System.out.println(Message.NOTIFICATION);
        System.out.print(Message.INPUT_NAME);
        String name = checkInputString();
        System.out.print(Message.INPUT_ADDRESS);
        String address = checkInputString();
        System.out.print(Message.INPUT_SALARY);
        double salary = checkInputSalary();
        return new Person(name, address, salary); // Trả về đối tượng Person mới với tên, địa chỉ và lương
    }

    /**
     * Hàm để hoán đổi vị trí của lương giữa hai người.
     */
    private static void swap(PersonWrapper person1, PersonWrapper person2) {
        Person temp = person1.person;
        person1.person = person2.person;
        person2.person = temp;
    }

    /**
     * Hàm để sắp xếp danh sách các người theo lương (salary) bằng phương pháp
     * sắp xếp nổi bọt (bubble sort).
     */
    private static void sortBySalary(Person[] persons, PersonWrapper[] listPersonWrappers) {
        for (int i = 0; i < persons.length; i++) {
            listPersonWrappers[i] = new PersonWrapper(persons[i]); // Sử dụng để lưu danh sách đã sắp xếp
        }

        //Thuật toán sắp xếp buble sort
        for (int i = 0; i < persons.length; i++) {
            for (int j = 0; j < persons.length; j++) {
                if (listPersonWrappers[i].person.getSalary() < listPersonWrappers[j].person.getSalary()) {
                    swap(listPersonWrappers[i], listPersonWrappers[j]); // goi ham swap
                }
            }
        }

        //Thông báo sorted thành công 
        System.err.println(Message.SORT_SUCCESS);
        return;
    }

    /**
     * Hàm chính của chương trình.
     */
    public static void main(String[] args) {
        System.out.println(Message.TITLE_PROGRAM);
        Person[] persons = new Person[Message.THREE]; //Danh sách người là 3

        //Nhập thông tin lần lượt 3 người
        for (int i = 0; i < persons.length; i++) {
            persons[i] = inputPersonInfo();
        }

        //tạo đối tượng để đóng gói danh sách thông tin của từng người
        PersonWrapper[] listPersonWrappers = new PersonWrapper[persons.length];

        //sắp xếp theo lương
        sortBySalary(persons, listPersonWrappers);

        //In ra thứ tự thông tin 3 người sorted theo lương
        for (int i = 0; i < persons.length; i++) {
            System.out.println(Message.NOTIFICATION_PERSON);
            listPersonWrappers[i].person.displayPersonInfo();
            System.out.println(Message.SPACE);
        }
    }
}
