/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0101;

/**
 *
 * @author PhạmVinhTiến
 */
import com.sun.javafx.scene.DirtyBits;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 */
public class Display {

    public void displayMenu() {
        System.out.println(Message.MENU);
    }

    public void DisplayElementofList(ArrayList<Employee> EmployeeList, int index) {
        DateFormat dateFormat = new SimpleDateFormat(Message.DATE);
        String DayofBirth = dateFormat.format(EmployeeList.get(index).getDOB());
        System.out.format(Message.DATE_BIRTH_FORMAT,
                EmployeeList.get(index).getId(), EmployeeList.get(index).getFirstName(), EmployeeList.get(index).getLastName(),
                EmployeeList.get(index).getPhone(), EmployeeList.get(index).getEmail(), EmployeeList.get(index).getAddress(), DayofBirth,
                EmployeeList.get(index).getSex(), EmployeeList.get(index).getSalary(), EmployeeList.get(index).getAgency());
    }

    public void DisplayAllList(ArrayList<Employee> EmployeeList) {
        System.out.println(Message.ENTER_EMPOYEES);
        System.out.format(Message.DATE_BIRTH_FORMAT, Message.ID, Message.FIRST_NAME,
                Message.LAST_NAME, Message.PHONE_NUMBER, Message.EMAIL, Message.ADDRESS, Message.BIRTHDAY, Message.GENDER, Message.SALARY, Message.AGENCY);
        //loop use to access each element of arraylist from begining to the end
        for (int i = 0; i < EmployeeList.size(); i++) {
            DisplayElementofList(EmployeeList, i);
        }
    }
}
