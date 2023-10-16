/**
 * Class: Validate Kiểm tra tính hợp lệ của Input
 *
 * @version 1.1 22 Sep 2023
 * @author Phạm Vinh Tiến
 */
package j1.s.p0011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validate {

    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));

    /*
     * Kiem tra gia tri input của các lựa chọn
     * @param mes , err
     * @return Trả về cơ số hợp lệ
     */
    public int getBase(String mes, String err) {
        /* mes: Biến này chứa một chuỗi mô tả mục tiêu của việc nhập liệu. 
         * err: Biến này chứa một chuỗi thông báo lỗi. 
         */

        // Thông báo lỗi đến khi người dùng nhập đúng cơ số
        while (true) {
            try {
                System.out.println(mes);
                int base = Integer.parseInt(bufferedreader.readLine());

                //Nếu input đúng cơ số thì trả về
                if ((base == Message.CASE1) || (base == Message.CASE2) || (base == Message.CASE3)) {
                    return base;
                }
            } catch (IOException e) {
                e.printStackTrace(System.out);
            } catch (NumberFormatException e) {
                e.printStackTrace(System.out);
            }
            System.out.println(err);
        }
    }

    /*
     * Kiểm tra sự hợp lệ của các giá trị nhập vào
     * @param mes, err, base
     * @return Giá trị hợp lệ
     */
    public String getValue(String mes, String err, int base) {

        /* mes: Biến này chứa một chuỗi mô tả mục tiêu của việc nhập liệu. 
         * err: Biến này chứa một chuỗi thông báo lỗi. 
         * base: Biến này chứa giá trị cơ số (base) được chọn. 
         */
        while (true) {
            System.out.println(mes);
            try {
                String value = bufferedreader.readLine();

                switch (base) {
                    case 1:
                        if (value.matches(Message.VALUEBINARY)) {
                            return value;
                        }
                        break;
                    case 2:
                        if (value.matches(Message.VALUEDEC)) {
                            return value;
                        }
                        break;
                    case 3:
                        if (value.matches(Message.VALUEHEX)) {
                            return value;
                        }
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }

            /* Kiểm tra dữ liệu nhập dựa trên 'base' 
             * được chỉ định và hiển thị 
             * thông báo lỗi nếu dữ liệu không hợp lệ 
             */
            System.out.println(err);
        }
    }
}
