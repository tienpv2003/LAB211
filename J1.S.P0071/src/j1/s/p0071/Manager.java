/**
 * class Manager: manager task
 *
 * @author PhạmVinhTiến
 * @version 1.0 14/Oct/2023
 */
package j1.s.p0071;

import java.util.ArrayList;

public class Manager {

    /**
     * FunctionaddTask Task: Add task Have task add for list
     *
     * @param listTask: list of task
     * @param id: id of task
     */
    public static void addTask(ArrayList<Task> listTask, int id) {

        //b1: Variable paramenter
        String requirementName;
        String taskTypeId;
        String date;
        String planFrom;
        String planTo;
        String assign;
        String reviewer;

        //b2: Enter value and check validate
        System.out.print(Message.ENTER_REQUIREMENT);
        requirementName = Validate.checkInputString();
        System.out.print(Message.ENTER_TASK_TYPE);
        taskTypeId = Validate.checkInputTaskTypeId();
        System.out.print(Message.ENTER_DATE);
        date = Validate.checkInputDate();
        System.out.print(Message.ENTER_PLAN_FROM);
        planFrom = Validate.checkInputPlan();
        planTo = Validate.checkInputPlanTo(planFrom);
        System.out.print(Message.ENTER_ASSIGNEE);
        assign = Validate.checkInputString();
        System.out.print(Message.ENTER_REVIEWER);
        reviewer = Validate.checkInputString();

        //b3: add value from task
        listTask.add(new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer) {
        });
        System.out.println(Message.ADD_TASK_SUCSESS);
    }

    /**
     * function findTaskExist Task: find task by id
     *
     * @param listTask: list of task
     * @return
     */
    public static int findTaskExist(ArrayList<Task> listTask) {

        //b1: check id is number 
        System.out.print(Message.ENTER_ID);
        int id = Validate.checkInputInt();

        //b2: use loop check duplicate
        for (int i = 0; i < listTask.size(); i++) {
            if (listTask.get(i).getId() == id) {
                return i;
            }
        }

        //b3: If don't duplicate return -1
        System.err.println(Message.NOT_FIND);
        return -1;
    }

    /**
     * Function Delete Task: Delete task by id
     *
     * @param listTask: list of task
     * @param id: id of task
     */
    public static void deleteTask(ArrayList<Task> listTask, int id) {

        //b1: Check list have empty
        if (listTask.isEmpty()) {
            System.err.println(Message.LIST_EMPTY);
            return;
        }

        //b2: callback findTaskExist need find id task need delete.   
        int findId = findTaskExist(listTask);
        if (findId != -1) {
            listTask.remove(findId);
            for (int i = findId; i < listTask.size(); i++) {
                listTask.get(i).setId(listTask.get(i).getId() - 1);
            }
            System.err.println(Message.DELETE_SUCSESS);
        }
    }

    /**
     * function print Task: helps print according to format
     *
     * @param listTask: list of task
     */
    public static void print(ArrayList<Task> listTask) {

        //b1: check list have empty
        if (listTask.isEmpty()) {
            System.out.printf(Message.FORM_1, Message.ID,
                    Message.NAME, Message.TASK_TYPE,
                    Message.DATE, Message.TIME, Message.ASSIGN,
                    Message.REVIEWER);
            System.out.println();
            return;
        }

        //b2: use printf crate fomat
        System.out.printf(Message.FORM_1, Message.ID,
                Message.NAME, Message.TASK_TYPE,
                Message.DATE, Message.TIME, Message.ASSIGN,
                Message.REVIEWER);

        //b3: use loop and prinf need print value of Task
        for (int i = 0; i < listTask.size(); i++) {
            System.out.printf(Message.FORM_2,
                    listTask.get(i).getId(),
                    listTask.get(i).getRequirementName(),
                    listTask.get(i).getTaskTypeId(),
                    listTask.get(i).getDate(),
                    Double.parseDouble(listTask.get(i).getPlanTo())
                    - Double.parseDouble(listTask.get(i).getPlanFrom()),
                    listTask.get(i).getassign(),
                    listTask.get(i).getreviewer()
            );

        }
    }

    /**
     * Function display Task: Show for users choice
     */
    public static void display() {

        //b1: Variable paramenter
        ArrayList<Task> listTask = new ArrayList<>();
        int choice;
        int id = 1;

        //b2: use loop and swich case need show for user choice
        while (true) {
            System.out.println(Message.ADD_TASK);
            System.out.println(Message.DELETE_TASK);
            System.out.println(Message.DISPLAY_TASK);
            System.out.println(Message.EXIT);
            System.out.print(Message.ENTER_CHOICE);

            //b2.1: Check limit choice
            choice = Validate.checkIntLimit(1, 4);
            switch (choice) {

                //case 1: add Task to list
                case 1:
                    addTask(listTask, id);
                    id++;
                    break;

                //case 2: Delete task for list
                case 2:
                    deleteTask(listTask, id);
                    id--;
                    break;

                //case 3: Display List
                case 3:
                    print(listTask);
                    break;

                //case 4: exit program      
                case 4:
                    return;

            }
        }
    }
}
