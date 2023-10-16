/**
 * Class: Main thực hiện các bước để chuyển đổi
 *
 * @version 1.1 22/Sep/2023 *
 * @author PhạmVinhTiến
 */
package j1.s.p0011;

public class Main {

    public static void main(String[] args) {
        
        // Tạo đối tượng Validate để kiểm tra và xác nhận đầu vào từ người dùng
        Validate vali = new Validate();

        // Tạo đối tượng Covert để thực hiện chuyển đổi cơ số
        Convert covert = new Convert();

        while (true) {

            // B1: Nhận cơ số đầu vào từ người dùng
            int inbase = vali.getBase(Message.BASE_PROMPT, Message.INVALID_BASE);

            // B2: Nhận cơ số đầu ra từ người dùng
            int outBase = vali.getBase(Message.BASE_PROMPT, Message.INVALID_BASE);

            //B3: Nhận giá trị muốn đổi từ người dùng
            String value = vali.getValue(Message.VALUE_PROMPT, 
                    Message.INVALID_VALUE, inbase);

            //Chọn hệ cơ số đầu vào
            switch (inbase) {
                case 1:
                    inbase = Message.BINARY;
                    break;
                case 2:
                    inbase = Message.DECIMAL;
                    break;
                case 3:
                    inbase = Message.HEXADECIMAL;
                    break;
            }

            //Chọn hệ cơ số đầu ra
            switch (outBase) {
                case 1:
                    outBase = Message.BINARY;
                    break;
                case 2:
                    outBase = Message.DECIMAL;
                    break;
                case 3:
                    outBase = Message.HEXADECIMAL;
                    break;
            }

            System.out.println(Message.THE_RESULT);

            //B4: Kiểm tra nếu giá trị đầu vào đã ở cơ số decimal (base=10)
            if (inbase == Message.DECIMAL) {
                
                // In kết quả chuyển đổi trực tiếp sang cơ số đầu ra
                System.out.println(covert.CovertDecToOther(Integer.parseInt(value), outBase));
            } else {
                
                // Chuyển đổi giá trị đầu vào thành decimal
                int temDec = covert.CovertToDec(value, inbase);

                // In kết quả chuyển đổi thành giá trị cơ số đầu ra
                System.out.println(covert.CovertDecToOther(temDec, outBase));
            }
        }
    }
}
