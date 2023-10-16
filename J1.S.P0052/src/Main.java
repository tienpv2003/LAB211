/*
 * Class: Main chính thực hiện quản lý thông tin về quốc gia trong khu vực ĐNÁ.
 * @version: 1.0  27/09/2023
 * @author: PhạmVinhTiến
 */
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * Phương thức dùng để kiểm tra xem chuỗi nhập vào có rỗng hay không.
     *
     * @param scanner Scanner để nhập dữ liệu từ bàn phím.
     * @param prompt Hướng dẫn cho người dùng.
     * @return Chuỗi không rỗng.
     */
    private static String inputNotEmpty(Scanner scanner, String prompt) {

        String input;

        //Người dùng nhập input không rỗng thì dừng
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                return input; // Trả về giá trị nếu chuỗi không trống
            } else {

                //Thông báo nếu chuỗi rỗng
                System.err.println(Message.INPUT_NOT_EMPTY);
            }
        }
    }

    /**
     * Phương thức main thực hiện các chức năng quản lý thông tin về quốc gia
     * trong khu vực ĐNÁ.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        DecimalFormat decimalFormat = new DecimalFormat(Message.DECIMAL_FORMAT);
        while (true) {
            System.out.println(Message.MENU);
            System.out.println(Message.DAU_BANG);
            System.out.println(Message.MENU_1);
            System.out.println(Message.MENU_2);
            System.out.println(Message.MENU_3);
            System.out.println(Message.MENU_4);
            System.out.println(Message.MENU_5);
            System.out.println(Message.DAU_BANG);

            int choice;

            /*
             * Kiểm tra người dùng nhập từ 1-5
             */
            while (true) {
                try {
                    System.out.print(Message.ENTER_CHOICE);
                    choice = Integer.parseInt(scanner.nextLine().trim());

                    // Thoát khỏi vòng lặp nếu lựa chọn hợp lệ (1-5)
                    if (choice >= Message.ONE && choice <= Message.FIVE) {
                        break;
                    } else {

                        //Thông báo nếu vượt khỏi lựa chọn
                        System.err.println(Message.INPUT_OVER_RANGE);
                        System.out.print(Message.ENTER_AGAIN);
                    }
                } catch (NumberFormatException e) {

                    //Thông báo ngoại lệ
                    System.err.println(Message.INPUT_INVALID);
                    System.out.print(Message.ENTER_AGAIN);
                }
            }

            switch (choice) {
                /*
                 * Nhập thông tin về 11 quốc gia
                 */
                case 1:
                    System.out.println(Message.NOTIFICATION);
                    for (int i = 0; i < 1; i++) {
                        String code = inputNotEmpty(scanner, Message.ENTER_COUNTRY);  //nhập code country
                        String name = inputNotEmpty(scanner, Message.ENTER_NAME_COUNTRY); //nhập tên country

                        float area = Message.ZERO; //diện tích ban đầu bằng 0

                        boolean validInput = false;

                        //Nhập diện tích nếu vẫn còn hợp lệ
                        do {
                            try {
                                System.out.print(Message.ENTER_AREA);
                                area = scanner.nextFloat();

                                //Nếu nhỏ hơn 0 thì báo lỗi
                                if (area <= Message.ZERO) {
                                    System.err.println(Message.AREA_INVALID);
                                } else {

                                    //Ngược lại thì input hợp lệ
                                    validInput = true;
                                }
                            } catch (InputMismatchException e) {

                                //Thông báo ngoại lệ
                                System.err.println(Message.INPUT_INVALID);
                                scanner.nextLine(); // Tiêu thụ dữ liệu nhập không hợp lệ
                            }
                        } while (!validInput);
                        decimalFormat.format(area);
                        scanner.nextLine(); // Tiêu thụ ký tự xuống dòng

                        //nhập và kiểm tra input Terrain
                        String terrain = inputNotEmpty(scanner, Message.ENTER_TERRAIN_COUNTRY);

                        //Lưu thông tin các quốc gia trong đối tượng country
                        EastAsiaCountries country = new EastAsiaCountries(code, name, area, terrain);
                        manager.addCountryInformation(country);
                        System.out.println(Message.SPACE);
                    }
                    break;

                /*
                 * Hiển thị thông tin về 11 quốc gia
                 */
                case 2:
                    System.out.println(Message.DISPLAY);
                    manager.displayRecentlyEnteredInformation();
                    break;

                /*
                 * Tìm kiếm quốc gia bằng tên
                 */
                case 3:
                    System.out.print(Message.ENTER_SEARCH_NAME);
                    String searchName = scanner.nextLine();

                    //Gọi ham tim kiem thông tin bằng tên, và lưu vào đối tượng
                    EastAsiaCountries[] searchResults = manager.searchInformationByName(searchName);

                    /* Nếu tìm thấy sẽ trả về giá trị > 0
                       In thông tin quốc gia được tìm thấy
                     */
                    if (searchResults.length > Message.ZERO) {
                        System.out.println(Message.SHOW_INFO_COUNTRY);
                        for (EastAsiaCountries country : searchResults) {
                            country.display();
                            System.out.println();
                        }
                    } else {

                        //Không tìm thấy
                        System.out.println(Message.COUNTRY_NOT_FOUND);
                    }
                    break;

                /*
                 * Hiển thị danh sách đã sắp xếp theo tên
                 */
                case 4:
                    System.out.println(Message.DISPLAY_SORTED);
                    manager.sortInformationByAscendingOrder(); // sắp xếp theo tên
                    manager.displayRecentlyEnteredInformation(); //hiển thị danh sách đã sắp xếp
                    break;

                /*
                 * Thoát khỏi chương trình
                 */
                case 5:
                    System.out.println(Message.EXIT);
                    scanner.close();
                    System.exit(Message.ZERO);

                /*
                 * Trường hợp mặc định in ra thông báo:
                 */
                default:
                    System.out.println(Message.CHOICE_INVALID);
            }
        }
    }
}
