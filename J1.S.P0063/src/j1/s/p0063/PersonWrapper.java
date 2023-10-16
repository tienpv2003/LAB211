/*
 * Class: PersonWrapper đóng gói (wrapper) cho đối tượng Person.
 * @version: 1.0   29/Sep/2023
 * @author: PhạmVinhTiến
 */
package j1.s.p0063;

public class PersonWrapper {

    /** person dai dien cho tat ca thong tin 1 nguoi*/
    Person person;

    /**
     * Constructor mặc định không tham số.
     */
    public PersonWrapper() {
    }

    /**
     * Constructor khởi tạo đối tượng PersonWrapper bằng một đối tượng Person.
     *
     * @param person Đối tượng Person cần đóng gói.
     */
    public PersonWrapper(Person person) {
        this.person = person;
    }
}
