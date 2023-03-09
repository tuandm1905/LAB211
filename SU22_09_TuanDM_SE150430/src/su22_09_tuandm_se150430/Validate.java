/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_09_tuandm_se150430;

import java.util.Scanner;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Validate {

    private final static Scanner in = new Scanner(System.in);

    //check user input number limit
    public int checkInput(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in range [" + min + ", " + max + "]"); // thông báo ngoại lệ
                System.out.print("Enter again: "); // thông báo ngoại lệ
            }
        }
    }

    // kiểm tra giá trị người dùng nhập vào
    //// Kiểm tra giá trị double nhập vào
    public double checkValueDouble() {
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Please input number: "); // thông báo ngoại lệ
            }

        }
    }

    //kiểm tra số lẻ hay hông
    public boolean Odd(double n) {
        if (n % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    //kiểm tra số chẳn hay hông
    public boolean Even(double n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    //kiểm tra số bình thường hay không
    public boolean SquareNumber(double n) {
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            return true;
        } else {
            return false;
        }
    }
}
