/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_15_2slot_tuandm_se150430;

import java.util.Scanner;

/**
 *
 * @author SE150430
 */
public class Validation {

    private static final Scanner in = new Scanner(System.in);
// kiểm tra người dùng có tiếp tục nhập bằng cách nhập Y & N
    public boolean checkInputYN() {
        while (true) {
            String result = in.nextLine();
            if (result.length() == 1 && result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.length() == 1 && result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Re-input.");
        }
    }
// kiểm tra số điểm nhập vào
    public float checkInputFloat() {
        while (true) {
            try {
                float result = Float.parseFloat(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }
// kiểm tra chuỗi nhập vào
    public String checkInputString() {
        while (true) {
            String result = in.nextLine();
            if (result.length() == 0) {
                System.out.println("Not empty.");
            } else {
                return result;
            }
        }
    }

}
