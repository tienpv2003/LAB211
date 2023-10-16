package j1.s.p0103;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        
       try{
           System.out.println("Enter the fisrt date with [dd/MM/yyyy] format: ");
           String dateStr1 = sc.nextLine(); //input
           if (!isValueDateFormat(dateStr1)){ //check date  1
               throw new ParseException("Invalid date format", 0); //if invalid -> throw exception
           }
           Date date1 = dateFormat.parse(dateStr1);

           System.out.println("Enter the second date with [dd/MM/yyyy] format: ");
           String dateStr2 = sc.nextLine();
           if (!isValueDateFormat(dateStr1)){ //check date 2
               throw new ParseException("Invalid date format", 0);
           }
           Date date2 = dateFormat.parse(dateStr2);
           
           int compareDate = date1.compareTo(date2);
           if (compareDate <0){
               System.out.println("Date 1 is before Date 2");
           } else if (compareDate >0){
               System.out.println("Date 1 is after Date 2");
           }else{
               System.out.println("Date 1 is the same as Date 2");
           }
           
       }catch (ParseException e){
           System.out.println("Invalid date. Please enter againt !");
       }
    }
    
    private static boolean isValueDateFormat(String dateStr){ //check date is valid
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); 
        try{
            dateFormat.parse(dateStr);
            return true;
        }catch (ParseException e){
            return false;
        }
    }
}