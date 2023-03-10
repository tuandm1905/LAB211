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
            // ki???m tra m???t kh???u c?? ch???a ??t nh???t m???t k?? t??? v?? c?? ch??? c??i hay kh??ng?
            String regex = "^[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}|"
                    + "[0-9]{3}[-][0-9]{3}[-][0-9]{4}$"; //123.456.7890
            String regex1 = "[0-9]{3}[-]{1}[0-9]{3}[-]{1}[0-9]{4}[ ]{1}[x]{1}[0-9]{4}"; //123-456-7890 x1234
            String regex2 = "[0-9]{3}[-]{1}[0-9]{3}[-]{1}[0-9]{4}[ ]{1}[e]{1}[x]{1}[t]{1}[0-9]{4}"; //123-456-7890 ext1234
            if (result.isEmpty()) {
                System.out.println("Cannot be empty!"); // Ki???m tra v??o c?? r???ng hay kh??ng
            }
            boolean isVaild = checkInputPhone(result, regex, regex1, regex2);
            if (!isVaild) { // n???u tr??? v??? false ngh??a l?? input ?????u v??o sai format
                // th??ng b??o cho ng?????i d??ng nh???p l???i s??? ??i???n tho???i
                System.out.println("Please input Phone flow\n"
                        + "??? 1234567890\n"
                        + "??? 123-456-7890 \n"
                        + "??? 123-456-7890 x1234\n"
                        + "??? 123-456-7890 ext1234\n"
                        + "??? (123)-456-7890\n"
                        + "??? 123.456.7890\n"
                        + "??? 123 456 7890");
                System.out.print("Enter again: "); // nh???p l???i
            } else {
                // ????ng format tr??? v??? String phone theo y??u c???u                 
                return result;
            }
        }

    }
    // ki???m tra m???t kh???u c?? ????ng theo format hay kh??ng

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
