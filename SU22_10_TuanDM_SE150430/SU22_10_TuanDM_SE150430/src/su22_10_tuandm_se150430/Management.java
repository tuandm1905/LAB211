package su22_10_tuandm_se150430;

import java.util.ArrayList;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Management {

    private int number = 0;
    public static Validate val = new Validate();
//    public static Table table = new Table();
    public static Element e = new Element();
    public static ArrayList<Element> workList = new ArrayList<>(); // lưu trữ task

    public int addWork() {
        System.out.println("\n---------- Add Task ----------");
        System.out.print("Requirement Name: ");
        String Name = val.checkString();
        System.out.print("Task Type: ");
        int TaskTypeID = val.checkInput(1, 4);
        System.out.print("Date: ");
        String date = val.checkDate();
        System.out.print("From: ");
        double from = val.checkDouble();
        System.out.print("To: ");
        double to = val.checkDouble();
        System.out.print("Assignee: ");
        String assignee = val.checkString();
        System.out.print("Reviewer: ");
        String review = val.checkString();
        boolean isExist = val.checkDuplicate(date, assignee, from, to);
        // check value of variable isExist
        if (isExist) {
            System.out.println("Input data is duplicated!!!");
        } else {
            String type = val.checkType(TaskTypeID);
            int id = val.checkID(Name, TaskTypeID, date, from, to, assignee);
            Element newElement = new Element(id, type, Name, date, from, to, assignee, review);
//            table.updateWidth(String.valueOf(id), type, Name, date, String.valueOf(from));
            setWorkList(newElement);
            System.out.println("You was add successful to the job data!!!");
        }
        return ++this.number;
    }

    public void deleteWork() {
        if (val.checkEmpty()) {
            System.out.println("List empty!");
            return;
        } else {
            System.out.println("\n---------- Del Task ----------");
            System.out.print("Enter ID: ");
            int id = val.checkInt();
            // kiểm tra indexInList không bằng - 1 hay không
            int check = val.findTask(id);
            if (check != -1) {
                getWorkList().remove(check);
                System.out.println("Delete successful!!!");
            } else {
                System.out.println("ID is not exist!!!");
            }
        }
    }

    public void displayWork() {
        if (getWorkList().isEmpty()) {
            System.out.println("List task is empty!");
            return;
        } else {
            System.out.println("\n---------- Task ----------");
            System.out.format("%-7s%-20s%-12s%-15s%-7s%-15s%-15s\n", "Id", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            //loop use to access each element of arraylist from begining to the end
            for (int j = 0; j < workList.size(); j++) { // vòng lặp in ra bảng công việc
                Element task = workList.get(j);
                double time = task.getPlanTo() - task.getPlanFrom(); // tính thời gian làm việc
                String planTime = String.format("%.1f", time);
                System.out.printf("%-7d%-20s%-12s%-15s%-7s%-15s%-15s\n", task.getID() , task.getContent() , task.getTaskTypeID() , task.getDate() , planTime , task.getTakeJob() , task.getTester() );
            }
            System.out.println("\n");
        }
    }

    public ArrayList<Element> getWorkList() {
        return workList;
    }

    public void setWorkList(Element wkList) {
        this.workList.add(wkList);
    }

}
