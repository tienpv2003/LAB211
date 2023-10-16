package j1.s.p0101;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(Message.UPDATE_OPTION);
        Scanner sc = new Scanner(System.in);
        int choice;
        GetData getData = new GetData();
        EmployeeManagement employeemanagement = new EmployeeManagement();
        Display display = new Display();
        ArrayList<Employee> EmployeeList = new ArrayList<>();
        do {
            //1. Display a menu
            display.displayMenu(); // Sửa thành display.displayMenu() để sử dụng phương thức chính xác.
            //2. Ask and Get user's choice
            choice = getData.getInteger(sc, Message.OPTION, Message.MIN, Message.MAX);
            
            //3. Do the option user selected
            switch (choice) {
                case 1:// Add Employee
                    employeemanagement.addEmployee(EmployeeList);
                    break;
                case 2: // Update employees
                    employeemanagement.updateEmployee(EmployeeList); // Sửa thành employeemanagement.updateEmployee(EmployeeList)
                    break;
                case 3:// Remove employees
                    employeemanagement.removedEmployee(EmployeeList); // Sửa thành employeemanagement.removeEmployee(EmployeeList)
                    break;
                case 4: // Search employees
                    employeemanagement.search(EmployeeList); // Sửa thành employeemanagement.search(EmployeeList)
                    break;
                case 5:// Sort employees by salary
                    employeemanagement.sortBySalary(EmployeeList); // Sửa thành employeemanagement.sortBySalary(EmployeeList)
                    break;
            }
        } while (choice < Message.MAX);
    }

}
