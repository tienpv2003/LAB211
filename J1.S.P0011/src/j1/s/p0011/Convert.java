/**
 * Class: Convert cho phép chuyển đổi giữa các hệ cơ số
 * 
 * @version 1.1 22/Sep/2023 
 * @author PhạmVinhTiến
 */
package j1.s.p0011;

public class Convert {

    /*
     * Chuyển từ hệ cơ số khác sang hệ cơ số thập phân
     * @param: other, base
     * @return: Giá trị sau khi chuyển sang hệ 10
     */
    public int CovertToDec(String other, int base) {        
        /*
        other: Giá trị muốn đổi sang hệ 10
        base: co số muốn đổi sang hệ mười
        */
        
        int digit;
        int result = 0;
        String hex = Message.HEXVALUE;
        
        for (int i = 0; i < other.length(); i++) {
            // Tìm vị trí của ký tự trong chuỗi hex
            digit = hex.indexOf(other.charAt(i));
            // Sử dụng công thức chuyển đổi hệ cơ số
            result += (digit * Math.pow(base, other.length() - 1 - i));
        }
        return result;
    }

    /* 
     * Chuyển từ hệ cơ số thập phân sang hệ cơ số khác
     * @param dec, base
     * @return Giá trị chuyển từ hệ 10 sang hệ khác
     */
    public String CovertDecToOther(int dec, int base) {
        /* dec: giá trị đang hệ 10
         * base: Cơ số chuyển sang từ hệ 10
        */
        
        String result = Message.SPACE;
        
        //Chuoi gia tri cua he co số lấy từ chuỗi hex
        String hex = Message.HEXVALUE; 
        while (dec > 0) {
            
            // Lấy phần dư khi chia dec cho base
            int remainder = dec % base;
            
            // Thêm ký tự tương ứng vào đầu chuỗi kết quả
            result = hex.charAt(remainder) + result;
            
            // Chia dec cho base để tiếp tục lặp
            dec = dec / base;
        }
        return result;
    }
}
