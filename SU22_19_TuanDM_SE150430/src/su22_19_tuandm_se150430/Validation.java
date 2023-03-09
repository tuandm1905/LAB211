/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_19_tuandm_se150430;

import java.util.Scanner;

/**
 *
 * @author Đặng Minh Tuấn SE150430
 */
public class Validation {

    private final static Scanner in = new Scanner(System.in);

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
                System.out.println("Please input number in rage [" + min + ", " + max + "]"); // thông báo ngoại lệ
                System.out.print("Enter again: ");
            }
        }
    }
// kiểm tra chuỗi nhập vào

    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (!result.trim().isEmpty()) {
                return result;
            }
            System.out.println("Input can not null!");// thông báo ngoại lệ
            System.out.print("Please Input again: ");
        }
    }
// kiểm tra chuỗi có null hay không

    public boolean isNullString(String str) {
        return str.trim().isEmpty();
    }

    /**
     * check kiểu double lớn hơn 0
     *
     */
    public double checkInputDouble(int min) {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                if (result > min) {
                    return result;
                }
                System.out.println("Input lager than 0!");
                System.out.print("Please Input again: ");
            } catch (NumberFormatException e) {
                System.out.println("You must Input digits!!");// thông báo ngoại lệ
                System.out.print("Please Input again: ");
            }
        }
    }

    /**
     *
     * check nhập Y và N để hỏi ý kiến người dùng nhập tiếp không
     */
    public boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input Y/y or N/n.");
            System.out.print("Please Enter again: ");
        }
    }
// kiểm tra ID Zoo

    public String getIDZoo() {
        System.out.print("Input id: ");
        return checkInputString();
    }
//Hàm nhập

    public String getString() {
        return in.nextLine().trim();
    }
// hàm kiểm tra giá trị weight

    public double checkDoubleWeight() {
        do {
            String weight = checkInputString();
            if (isNullString(weight)) {
                break;
            }
            try {
                double cost = Double.parseDouble(weight);
                if (cost <= 0) {
                    System.out.println("Price must than 0!");// thông báo ngoại lệ
                    System.out.print("Input again: ");
                } else {
                    return cost;

                }
            } catch (NumberFormatException e) {
                System.out.println("Digits only!");// thông báo ngoại lệ
                System.out.print("Input again: ");
            }
        } while (true);
        return -1;

    }
}
