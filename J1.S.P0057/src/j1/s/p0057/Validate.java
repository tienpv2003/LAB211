/*
 * Class: Validate Để xử lí các input nhập vào.
 * @version: 1.0  04/Oct/2023
 * @author: PhạmVinhTiến
 */
package j1.s.p0057;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Validate {

    final static File file = new File(Message.FILE_PATH);

    private static Scanner in = new Scanner(System.in);

    /**
     * Kiểm tra và giới hạn số nguyên nhập từ người dùng.
     *
     * @param min Giá trị tối thiểu cho số nhập.
     * @param max Giá trị tối đa cho số nhập.
     * @return Số nguyên hợp lệ.
     */
    public static int checkInputLimit(int min, int max) {

        /**
         * Vòng lặp cho đến khi người dùng nhập đúng
         */
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());

                // Nếu nằm ngoài khoảng min max thì đưa ra ngoại lệ
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {

                // Xử lí ngoại lệ và yêu cầu nhập lại
                System.err.println(Message.CHECK_INPUT_LIMIT);
                System.out.print(Message.ENTER_AGAIN);
            }
        }
    }

    /**
     * Kiểm tra input có phải là chuỗi hay không.
     *
     * @return Chuỗi hợp lệ.
     */
    private static String checkInputString() {

        /**
         * Vòng lặp cho đến khi người dùng nhập đúng
         */
        while (true) {
            String result = in.nextLine().trim();

            // Nếu rỗng, hiển thị "Not Empty" và yêu cầu nhập lại
            if (result.isEmpty()) {
                System.err.println(Message.NOT_EMPTY);
                System.out.print(Message.ENTER_AGAIN);
            } else {

                // Trả về kết quả nếu chuỗi hợp lệ
                return result;
            }
        }
    }

    /**
     * Kiểm tra input có phải là yes/no.
     *
     * @return True nếu người dùng nhập "y/Y", False nếu nhập "n/N".
     */
    private static boolean checkInputYN() {
        /*
         * Vòng lặp cho đến khi người dùng nhập đúng
         */
        while (true) {
            String result = checkInputString(); // result: lưu chuỗi nhập vào

            // Trả về true nếu người dùng nhập "y/Y"
            if (result.equalsIgnoreCase(Message.YES)) {
                return true;
            }
            // Trả về false nếu người dùng nhập "n/N"
            if (result.equalsIgnoreCase(Message.NO)) {
                return false;
            }

            // Hiển thị thông báo lỗi và yêu cầu nhập lại
            System.err.println(Message.CHECK_YN);
            System.out.print(Message.ENTER_AGAIN);
        }
    }

    /**
     * Kiểm tra sự tồn tại của tệp dữ liệu.
     *
     * @return True nếu tệp tồn tại, False nếu tệp không tồn tại và không thể
     * tạo mới.
     */
    public static boolean checkFileExist() {

        // Nếu tệp không tồn tại, hiển thị lỗi
        if (!file.exists()) {
            try {
                System.err.println(Message.FILE_NOT_EXIST);
                file.createNewFile();
                System.err.println(Message.CREATED_FILE);
                return false;
            } catch (IOException e) {

                // Hiển thị lỗi trên và báo lỗi dạng Stack Trace
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * Cho phép người dùng nhập tên người dùng.
     *
     * @return Tên người dùng hợp lệ.
     */
    public static String checkInputUserName() {
        System.out.print(Message.ENTER_USERNAME);
        /*
         * Vòng lặp cho đến khi người dùng nhập đúng
         */

        while (true) {
            String result = checkInputString();

            // Nếu thỏa mãn, trả về tên người dùng
            if (result.matches(Message.VALID_USERNAME)) {
                return result;
            }

            // Nếu không, hiển thị lỗi và yêu cầu nhập lại
            System.err.println(Message.CHECK_INPUT_USERNAME);
            System.out.print(Message.ENTER_AGAIN);
        }
    }

    /**
     * Cho phép người dùng nhập mật khẩu.
     *
     * @return Mật khẩu hợp lệ.
     */
    public static String checkInputPassword() {
        System.out.print(Message.ENTER_PASSWORD);
        // Vòng lặp cho đến khi người dùng nhập đúng

        while (true) {
            String result = checkInputString();

            // Nếu thỏa mãn, trả về mật khẩu
            if (result.matches(Message.VALID_PASSWORD)) {
                return result;
            }

            // Nếu không, hiển thị lỗi và yêu cầu nhập lại
            System.err.printf(Message.CHECK_INPUT_PASSWORD);
            System.out.printf(Message.ENTER_AGAIN);
        }
    }

    /**
     * Kiểm tra sự tồn tại của tên người dùng trong tệp dữ liệu.
     *
     * @param username Tên người dùng cần kiểm tra.
     * @return True nếu tên người dùng không tồn tại trong tệp, ngược lại trả về
     * False.
     */
    public static boolean checkUsernameExist(String username) {
        try {
            FileReader fileReader = new FileReader(file); // Mở tệp để đọc
            BufferedReader bufferedReader = new BufferedReader(fileReader); // Sử dụng BufferedReader để đọc tệp
            String line;

            // Đọc từng dòng trong tệp dữ liệu
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";"); // Tách dòng thành mảng dựa trên ký tự ';'

                // So sánh tên người dùng nhập với tên người dùng trong tệp
                if (username.equalsIgnoreCase(account[0])) {
                    return false; // Tên người dùng tồn tại, trả về False
                }
            }

            bufferedReader.close(); // Đóng BufferedReader
            fileReader.close(); // Đóng FileReader
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true; // Xảy ra lỗi, trả về True
    }
}
