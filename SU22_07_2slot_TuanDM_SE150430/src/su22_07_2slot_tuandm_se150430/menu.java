package su22_07_2slot_tuandm_se150430;

import java.util.Scanner;

/**
 *
 * @author SE150430
 */
public class menu {

    private final static Scanner in = new Scanner(System.in);
    //kiểm tra giới hạn số đầu vào của người dùng
    public int checkInput(int min, int max) {
        //lặp lại cho đến khi người dùng nhập chính xác
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

    //kiểm tra chuỗi đầu vào của người dùng
    public String checkInputString() {
        //lặp lại cho đến khi người dùng nhập chính xác
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) { // Kiểm tra dữ liệu vào có rỗng hay không
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //kiểm tra đầu vào của người dùng có / không
    public boolean checkInputYN() {
        //lặp lại cho đến khi người dùng nhập chính xác
        while (true) {
            String result = checkInputString();
            //trả về true nếu người dùng nhập y / Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //trả về false nếu người dùng nhập n / N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //display menu
    public int menu() {
        System.out.println("======== USER MANAGEMENT SYSTEM ========");
        System.out.println("1. Create a new account.");
        System.out.println("2. Login system.");
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
        int choice = checkInput(1, 3);
        return choice;
    }
}
