/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_12_tuandm_se150430;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Validate {

    private static final Scanner in = new Scanner(System.in);

//show display menu
    public int menu() {
        System.out.println("========== Contact program ==========");
        System.out.println("1. Add a contact.");
        System.out.println("2. Display all contact.");
        System.out.println("3. Delete a contact.");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 4);
        return choice;

    }

    //check user input number limit
    public int checkInputIntLimit(int min, int max) {
        //loop until user input correct
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

//check user input string
    public String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Cannot be empty!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check input int
    public int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("The input must be a integer number");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputPhone() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            // kiểm tra mật khẩu có chứa ít nhất một kí tự và có chữ cái hay không?
            String regex = "^[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}|"
                    + "[0-9]{3}[-][0-9]{3}[-][0-9]{4}$"; //123.456.7890
            String regex1 = "[0-9]{3}[-]{1}[0-9]{3}[-]{1}[0-9]{4}[ ]{1}[x]{1}[0-9]{4}"; //123-456-7890 x1234
            String regex2 = "[0-9]{3}[-]{1}[0-9]{3}[-]{1}[0-9]{4}[ ]{1}[e]{1}[x]{1}[t]{1}[0-9]{4}"; //123-456-7890 ext1234
            if (result.isEmpty()) {
                System.out.println("Cannot be empty!"); // Kiểm tra vào có rỗng hay không
            }
            boolean isVaild = checkInputPhone(result, regex, regex1, regex2);
            if (!isVaild) { // nếu trả về false nghĩa là input đầu vào sai format
                // thông báo cho người dùng nhập lại số điện thoại
                System.out.println("Please input Phone flow\n"
                        + "• 1234567890\n"
                        + "• 123-456-7890 \n"
                        + "• 123-456-7890 x1234\n"
                        + "• 123-456-7890 ext1234\n"
                        + "• (123)-456-7890\n"
                        + "• 123.456.7890\n"
                        + "• 123 456 7890");
                System.out.print("Enter again: "); // nhập lại
            } else {
                // đúng format trả về String phone theo yêu cầu                 
                return result;
            }
        }

    }
    // kiểm tra mật khẩu có đúng theo format hay không

    public boolean checkInputPhone(String result, String regex, String regex1, String regex2) {
        Pattern pattern = Pattern.compile(regex);
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher = pattern.matcher(result);
        Matcher matcher1 = pattern1.matcher(result);
        Matcher matcher2 = pattern2.matcher(result);
        if (matcher.matches()) {
            return matcher.matches();
        } else if (matcher1.matches()) {
            return matcher1.matches();
        } else {
            return matcher2.matches();
        }
    }
}
