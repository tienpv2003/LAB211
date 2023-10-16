/*
 * Class: EastAsiaCountries con kế thừa từ lớp Country, đại diện cho thông tin về một quốc gia trong khu vực ĐNÁ.
 * @version: 1.0   27/Sep/2023
 * @author: PhạmVinhTiến
 */
public class EastAsiaCountries extends Country {

    /** Terrain of country*/
    private String countryTerrain;

    /**
     * Constructor khởi tạo đối tượng EastAsiaCountries thuọc tính địa hình
     * (terrain).
     *
     * @param countryTerrain Đặc điểm địa hình của quốc gia.
     */
    public EastAsiaCountries(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    /**
     * Constructor khởi tạo đối tượng EastAsiaCountries bằng mã quốc gia, tên
     * quốc gia, tổng diện tích và đặc điểm địa hình.
     *
     * @param countryCode Mã quốc gia.
     * @param countryName Tên quốc gia.
     * @param totalArea Tổng diện tích quốc gia.
     * @param countryTerrain Đặc điểm địa hình của quốc gia.
     */
    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    /**
     * Ghi đè phương thức display để hiển thị thông tin về quốc gia Đông Á, bao
     * gồm mã quốc gia, tên quốc gia, tổng diện tích và đặc điểm địa hình.
     */
    @Override
    public void display() {
        System.out.printf(Message.FORMAT_EAST_COUNTRY, countryCode, countryName, totalArea, countryTerrain);
    }
}
