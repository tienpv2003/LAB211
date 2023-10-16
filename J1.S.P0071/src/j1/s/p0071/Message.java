/**
 * class Message: help take message
 *
 * @author PhạmVinhTiến
 * @version 1.0 14/Oct/2023
 */
package j1.s.p0071;

public class Message {

    /**
     * This statement is a regex in the Java language, used to test whether a
     * string matches an explicitly defined pattern string.Start with one or two
     * digits, then a decimal point and a "5" or a "0"
     */
    final static String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";
    final static String ENTER_CHOICE = "Enter your choice: ";
    final static String LIMIT_INT = "Enter between from 1 to 4";
    final static String ENTER_AGAIN = "Enter agian: ";
    final static String RE_INPUT = "Re-input";
    final static String NOT_EMPTY = "Not empty";
    final static String ENTER_REQUIREMENT = "Enter Requirement Name: ";
    final static String ENTER_TASK_TYPE = "Enter Task Type: ";
    final static String ENTER_DATE = "Enter Date: ";
    final static String ENTER_PLAN_FROM = "Enter From: ";
    final static String ENTER_PLAN_TO = "Enter To: ";
    final static String ENTER_ASSIGNEE = "Enter Assignee: ";
    final static String ENTER_REVIEWER = "Enter Reviewer: ";
    final static String ADD_TASK_SUCSESS = "Add Task Success. ";
    final static String DELETE_SUCSESS = "Delete Success. ";
    final static String ENTER_ID = "Enter id: ";
    final static String NOT_FIND = "Not found ";
    final static String LIST_EMPTY = "List empty";
    final static String TO_GRATE_FROM = "Plan To need grate than plan From";
    final static String FORM_1 = "%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n";
    final static String FORM_2 = "%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n";
    final static String ID = "ID";
    final static String NAME = "Name";
    final static String TASK_TYPE = "Task Type";
    final static String DATE = "Date";
    final static String TIME = "Time";
    final static String ASSIGN = "Assign";
    final static String REVIEWER = "Reviewer";
    final static String ADD_TASK = "1. Add Task";
    final static String DELETE_TASK = "2. Delete Task";
    final static String DISPLAY_TASK = "3. Display Task";
    final static String EXIT = "4. Exit";
    final static String FOMAT_DATE = "dd-MM-yyyy";
    final static String CODE = "Code";
    final static String TEST = "Test";
    final static String DESIGN = "Design";
    final static String REVIEW = "Review";
    final static Double TIME_START_JOB = 8.0;
    final static Double TIME_END_JOB = 17.5;
}
