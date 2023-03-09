package su22_10_tuandm_se150430;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Validate {

    static Element t = new Element();
    static Management managemenet = new Management();
    static final String CHECKDATE = "\\\\d{1,2}[-]\\\\d{1,2}[-]\\\\d{4}";
    private static final Scanner in = new Scanner(System.in);

    //show menu task program
    public int menu() {
        System.out.println("= = = = = Task Program = = = = =");
        System.out.println("\t1.    Add Task");
        System.out.println("\t2.    Delete Task");
        System.out.println("\t3.    Display Task");
        System.out.println("\t4.    Exit");
        System.out.print("  Enter your choice: ");
        int choice = checkInput(1, 4);
        return choice;
    }

    //check user input number limit
    public int checkInput(int min, int max) {
        //lặp lại cho đến khi người dùng nhập  giá trị chính xác
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input double
    public double checkDouble() {
        //lặp lại cho đến khi người dùng nhập  giá trị chính xác
        while (true) {
            try {
                String str = checkString();
                if (str.matches("^(\\\\d+\\\\.([5]|[0]))$")) {
                    System.out.println("Input must be x.0 or x.5 number");
                }
                double result = Double.parseDouble(str);
                if (result >= 8.0 && result <= 17.5) {
                    return result;
                } else {
                    System.out.println("Plan From and To must be within 8h-17h30");
                    System.out.print("Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("The number must be input double");
                System.out.print("Enter again: ");
            }
        }
    }

    //kiểm tra đầu vào của người dùng một số nguyên
    public int checkInt() {
        //lặp lại cho đến khi người dùng nhập  giá trị chính xác
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * check user input string
     *
     * @return
     */
    public String checkString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.matches("[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]")) {
                System.out.println("String contains no special characters!"); // thông báo ngoại lệ
            }
            if (result.isEmpty()) {
                System.out.println("Not empty!"); // thông báo ngoại lệ
                System.out.print("Enter again: "); // thông báo ngoại lệ
            } else {
                return result;
            }
        }
    }

    boolean checkDuplicate(String date, String takeJob, double planFrom, double planTo) {
        boolean isExist = false;
        //loop use to access each element of arraylist from begining to the end
        for (Element task : managemenet.getWorkList()) {
            //compare date in list with date input and assignee in list and assignee input
            if (date.equals(task.getDate()) && takeJob.equals(task.getTakeJob())) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }
// Kiểm tra ngày hợp lệ hay không
    public String checkDate() {
        String check = "";
        Date date;
        do {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy"); // tạo format cho date
            sdfrmt.setLenient(false);
            String inp = checkString();
            if (inp.matches("\\\\d{1,2}[-]\\\\d{1,2}[-]\\\\d{4}")) { //kiểm tra date nhập
                System.out.println("Format is incorrect");  // thông báo ngoại lệ
            } else {
                try {
                    date = sdfrmt.parse(inp);
                    Date now = new Date();
                    if (date.before(now)) {
                        System.out.println("Date cannot be the past. Please Re-enter!"); // thông báo ngoại lệ
                    } else {
                        break;
                    }
                } catch (ParseException ex) {
                    System.out.println("The date you entered does not exist!!"); // thông báo ngoại lệ
                }
            }
        } while (true);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        check = dateFormat.format(date);
        return check;
    }
// tạo ra danh sách loại công việc
    public String checkType(int check) {
        String[] arr = {"Code", "Test", "Design", "Review"}; // loại công việc
        String result = arr[check - 1];
        return result;
    }

    // Kiểm tra array list có rỗng hay không
    public boolean checkEmpty() {
        if (managemenet.getWorkList().isEmpty()) {
            return true;
        }
        return false;
    }
// tìm id cho task
    public int findTask(int id) {
        for (int i = 0; i < managemenet.getWorkList().size(); i++) { // vòng lặp for chạy list arraylist
            Element task = managemenet.getWorkList().get(i);
            if (task.getID() == id) {
                return i;
            }
        }
        return -1;
    }

    
    // Kiểm tra ID nhập vào để tìm kiếm
    public int checkID(String Name, int taskTypeID, String date, double from, double to, String TakeJob) {
        int id = 0, d = 0;
        for (int j = 1;; ++j) { // vòng lặp
            boolean valid = true;
            for (int i = 0; i < managemenet.getWorkList().size(); i++) { // vòng lặp cho list arrayList
                Element a = managemenet.getWorkList().get(i);
                if (a.getID() == j) { // kiểm tra id có bằng chưa
                    valid = false;
                } else if (a.getContent().equals(Name) && a.getPlanFrom() == from && a.getDate().equals(date) && a.getPlanTo() == to && a.getTakeJob().equals(TakeJob)) { // điều kiện thứ 2
                    ++d;
                }
            }
            if (valid == true) {
                id = j;
                return id;
            } else if (d != 0) {
                break;
            }
        }
        return 0;
    }
}
