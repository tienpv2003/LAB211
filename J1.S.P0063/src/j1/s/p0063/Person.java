/*
 * Class: Person biểu diễn thông tin về một người bao gồm tên, địa chỉ và lương.
 * @version: 1.0  29/Sep/2023
 * @author: PhạmVinhTiến
 */
package j1.s.p0063;

public class Person {

    /** name of person. */
    private String name; 

    /** address of person*/
    private String address;  
    
    /** Salary of person*/
    private double salary;   

    /**
     * Constructor mặc định không tham số.
     */
    public Person() {
    }

    /**
     * Constructor khởi tạo một đối tượng Person với tên, địa chỉ và lương.
     *
     * @param name Tên người.
     * @param address Địa chỉ người.
     * @param salary Lương người.
     */
    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Hiển thị thông tin của người, bao gồm tên, địa chỉ và lương.
     */
    void displayPersonInfo() {
        System.out.println(Message.NAME + this.name);
        System.out.println(Message.ADDRESS + this.address);
        System.out.println(Message.SALARY + this.salary);
    }
}
