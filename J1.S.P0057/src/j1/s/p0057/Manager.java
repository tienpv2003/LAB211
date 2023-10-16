/*
 * Class: Manager Quản lý các tài khoản của người dùng.
 * @version: 1.0 04/Oct/2023
 * @author: PhạmVinhTiến
 */
package j1.s.p0057;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Manager {

    /*
     * Hiển thị menu
     */
    final static File file = new File(Message.FILE_PATH);

    public static int Menu() {
        System.out.println(Message.CREATE_ACCOUNT);
        System.out.println(Message.LOGIN_ACCOUNT);
        System.out.println(Message.EXIT);
        System.out.println(Message.CHOICE);

        // Kiểm tra choice nằm trong khoảng min, max
        int choice = Validate.checkInputLimit(Message.MIN, Message.MAX);
        return choice;
    }

    /**
     * Tạo tài khoản mới
     */
    public static void createNewAccount() {

        // Kiểm tra sự tồn tại của tệp dữ liệu         
        if (!Validate.checkFileExist()) {
            return;
        }
        String username = Validate.checkInputUserName();
        String password = Validate.checkInputPassword();

        // Kiểm tra sự tồn tại của tên người dùng         
        if (!Validate.checkUsernameExist(username)) {
            System.err.println(Message.USER_EXIST);
            return;
        }
        addAccountData(username, password);
    }

    /**
     * Đăng nhập vào hệ thống
     */
    public static void loginSystem() {

        // Kiểm tra sự tồn tại của tệp dữ liệu         
        if (!Validate.checkFileExist()) {
            return;
        }
        String username = Validate.checkInputUserName();
        String password = Validate.checkInputPassword();

        // Kiểm tra sự tồn tại của tên người dùng        
        if (Validate.checkUsernameExist(username)) {
            System.err.println(Message.USERNAME_NOT_EXIST);
            return;
        }

        String storedPassword = passwordByUsername(username);

        if (storedPassword != null && storedPassword.equalsIgnoreCase(password)) {
            System.err.println(Message.LOGIN_SUCCESSFUL);
        } else {
            System.err.println(Message.PASSWORD_INCORRECT);
        }
    }

    /**
     * Thêm tài khoản mới vào hệ thống và lưu vào tệp dữ liệu
     *
     * @param username Tên người dùng
     * @param password Mật khẩu
     */
    private static void addAccountData(String username, String password) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            
            //ghi tài khoản vào tệp tách nhau bằng dấu ";"
            fileWriter.write(username + ";" + password + "\n"); 
            
            //đóng tệp ghi
            fileWriter.close(); 
            System.err.println(Message.CREATE_SUCCESSFUL);
        } catch (IOException e) {

            //Báo lỗi IO và stacktrace
            e.printStackTrace();
        }
    }

    /**
     * Lấy mật khẩu dựa trên tên người dùng
     *
     * @param username Tên người dùng
     * @return Mật khẩu tương ứng hoặc null nếu không tìm thấy
     */
    private static String passwordByUsername(String username) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            //Đọc file tu đầu đến dòng cuối = null
            while ((line = bufferedReader.readLine()) != null) {
                
                 //tách username và password bằng dấu ";"
                String[] account = line.split(Message.CHAM_PHAY);

                //So sánh nếu trùng với username thì trả về password
                if (username.equalsIgnoreCase(account[0])) {
                    return account[1];
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {

            //Báo lỗi không tìm thấy file
            ex.printStackTrace();
        } catch (IOException ex) {

            //Báo lỗi xuất nhập input
            ex.printStackTrace();
        }
        
        //nếu không tìm thấy
        return null; 
    }
}
