/*
 * Class: Message Dùng để khai báo các message, biến và hằng số.
 * @version: 1.0  04/Oct/2023
 * @author: PhạmVinhTiến
 */
package j1.s.p0057;

public class Message {

    // Tiêu đề chương trình
    final static String TITLE_PROGRAM = "====== USER MANAGEMENT SYSTEM ======";

    // Yêu cầu nhập lại
    final static String ENTER_AGAIN = "Enter again: ";

    // Hướng dẫn chọn y/n
    final static String CHECK_YN = "Please input y/Y or n/N.";

    // Thông báo file không tồn tại
    final static String FILE_NOT_EXIST = "File not exist!!!";

    // Thông báo file đã được tạo
    final static String CREATED_FILE = "File created";

    // Yêu cầu nhập tên người dùng
    final static String ENTER_USERNAME = "Enter username: ";

    // Yêu cầu nhập mật khẩu
    final static String ENTER_PASSWORD = "Enter password: ";

    // Kiểm tra đầu vào tên người dùng
    final static String CHECK_INPUT_USERNAME = "You must enter at least 5 characters, and no spaces!";

    // Kiểm tra đầu vào mật khẩu
    final static String CHECK_INPUT_PASSWORD = "You must enter at least 6 characters, and no spaces!";

    // Kiểm tra giới hạn đầu vào
    final static String CHECK_INPUT_LIMIT = "PLEASE INPUT FROM 1 TO 3";

    // Thông báo không được để trống
    final static String NOT_EMPTY = "Not Empty";

    // Tạo tài khoản mới
    final static String CREATE_ACCOUNT = "1. Create a new account ";

    // Đăng nhập vào hệ thống
    final static String LOGIN_ACCOUNT = "2. Login system ";

    // Thoát
    final static String EXIT = "3. Exit ";

    // Yêu cầu nhập lựa chọn
    final static String CHOICE = "Enter your choice: ";

    // Giá trị tối thiểu cho lựa chọn
    final static int MIN = 1;

    // Giá trị tối đa cho lựa chọn
    final static int MAX = 3;

    // Đăng nhập thành công
    final static String LOGIN_SUCCESSFUL = "Login successfully.";

    // Mật khẩu không chính xác
    final static String PASSWORD_INCORRECT = "Password incorrect.";

    // Tạo tài khoản thành công
    final static String CREATE_SUCCESSFUL = "Create successfully. ";

    // Tên người dùng đã tồn tại
    final static String USER_EXIST = "Username exists";

    // Tên người dùng không tồn tại
    final static String USERNAME_NOT_EXIST = "Username does not exist ";

    // Biểu thức chính quy cho tên người dùng hợp lệ
    final static String VALID_USERNAME = "^\\S{5}\\S*$";

    // Biểu thức chính quy cho mật khẩu hợp lệ
    final static String VALID_PASSWORD = "^\\S{6}\\S*$";

    // Có
    final static String YES = "Y";

    // Không
    final static String NO = "N";

    // Đường dẫn tới tập tin
    final static String FILE_PATH = "D:/user.dat";

    // Dấu chấm phẩy
    final static String CHAM_PHAY = ";";

}
