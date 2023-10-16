/*
 * Class: Country mô tả thông tin về một quốc gia.
 * @version: 1.0   27/09/2023
 * @author: PhạmVinhTiến
 */
public class Country {

    /** Code of country*/
    protected String countryCode;
    
    /** name of country*/
    protected String countryName;
    
    /** Total area of country*/
    protected float totalArea;

    /**
     * Constructor mặc định không tham số.
     */
    public Country() {
    }

    /**
     * Constructor khởi tạo đối tượng Country với thông tin về countryCode,
     * countryName và totalArea.
     *
     * @param countryCode Mã quốc gia.
     * @param countryName Tên quốc gia.
     * @param totalArea Tổng diện tích của quốc gia.
     */
    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    /*
     Phương thức để hiển thị thông tin về quốc gia: mã quốc gia, tên
     quốc gia và tổng diện tích.
     */
    public void display() {
        System.out.printf(Message.FORMAT_COUNTRY, countryCode, countryName, totalArea);
    }
}
