/*
 * Class: ManageEastAsiaCountries quản lý thông tin về các quốc gia Đông Á.
 * 
 * @version: 1.0  27/Sep/2023
 * @author: PhạmVinhTiến
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManageEastAsiaCountries {

    private final List<EastAsiaCountries> countryList;

    /**
     * Constructor để tạo danh sách các quốc gia.
     */
    public ManageEastAsiaCountries() {
        countryList = new ArrayList<>();
    }

    /**
     * Thêm một quốc gia vào danh sách.
     *
     * @param country Thông tin về quốc gia cần thêm.
     */
    public void addCountryInformation(EastAsiaCountries country) {
        countryList.add(country);
    }

    /**
     * Hiển thị thông tin về các quốc gia vừa được thêm vào.
     */
    public void displayRecentlyEnteredInformation() {
        System.out.println(Message.SHOW_INFO_COUNTRY);
        for (EastAsiaCountries country : countryList) {
            country.display();
            System.out.println();
        }
    }

    /**
     * Tìm kiếm thông tin về quốc gia theo tên.
     *
     * @param name Tên quốc gia cần tìm kiếm.
     * @return Danh sách các quốc gia có tên tương tự.
     */
    public EastAsiaCountries[] searchInformationByName(String name) {
        List<EastAsiaCountries> searchResult = new ArrayList<>();

        /*Lặp đến hết danh sách, so sánh không phân biệt chữ HOA, thường
          Thêm quốc gia đã tìm được vào searchResult
         */
        for (EastAsiaCountries country : countryList) {
            if (country.countryName.equalsIgnoreCase(name)) {
                searchResult.add(country);
            }
        }

        //Trả về danh sách các quốc gia tìm thấy theo dạng mảng
        return searchResult.toArray(new EastAsiaCountries[0]);
    }

    /**
     * Sắp xếp thông tin về các quốc gia theo thứ tự bảng chữ cái tăng dần theo
     * tên.
     */
    public void sortInformationByAscendingOrder() {

        //Dùng phương thức collection sort
        Collections.sort(countryList, new Comparator<EastAsiaCountries>() {
            @Override

            //Ghi đè phương thức so sánh giữa 2 quốc gia
            public int compare(EastAsiaCountries country1, EastAsiaCountries country2) {

                /*
                Trả về > 0 nếu country1 trước country2
                Trả về < 0 nếu country1 sau country2
                 */
                return country1.countryName.compareToIgnoreCase(country2.countryName);
            }
        });
    }
}
