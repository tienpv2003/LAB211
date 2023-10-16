/*
 * Class: Main thực hiện tạo tài khoản và đăng nhập vào hệ thống.
 * @version: 1.0  04/Oct/2023
 * @author: PhạmVinhTiến
 */
package j1.s.p0057;

public class Main {

    public static void main(String[] args) {

        // Tạo một đối tượng Message để hiển thị tiêu đề chương trình
        Message msg = new Message();
        System.out.println(msg.TITLE_PROGRAM);

        // Vòng lặp chạy cho đến khi người dùng muốn thoát
        while (true) {

            // Gọi hàm hiển thị menu
            int choice = Manager.Menu();
            switch (choice) {

                // TH1: Tạo tài khoản mới
                case 1:
                    Manager.createNewAccount();
                    break;

                // TH2: Đăng nhập vào hệ thống
                case 2:
                    Manager.loginSystem();
                    break;

                // TH3: Thoát
                case 3:
                    return;
            }
        }
    }

}
