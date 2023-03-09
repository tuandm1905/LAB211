/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_08_2slot_tuandm_se150430;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author TuanDM SE150430
 */
public class BinarySearch {

    private final static Scanner in = new Scanner(System.in);
    ElementArrays a;
// Hàm nhập n

    public int Input() {
        while (true) {
            try {
                //Nhập n
                int n = Integer.parseInt(in.nextLine().trim());
                return n;
                //Kiểm tra n có nhập đúng hay kông
            } catch (NumberFormatException e) { // bắt ngoại lệ nếu xảy ra lỗi
                System.out.println("Please re-enter the number of array number"); // thông báo giá trị nhập vào lỗi
                System.out.print("Enter again: ");
            }
        }
    }
//Hàm random số trong mảng

    public void inputNumberOfArray(int n) {
        int[] arr = new int[n];
        //random số trong khoảnh 1 - n
        Random rd = new Random();
        // vòng lập
        for (int i = 0; i < n; i++) {
            // random số ngẫu nhiên
            arr[i] = rd.nextInt(n) + 1;
        }
        //gán mảng a
        a = new ElementArrays(arr);
    }

// Hàm sắp xếp bubble Sort
    public void bubbleSort() {
        int tmp; // biến tạm
        //Vòng lặp
        for (int i = 0; i < a.getArrayNumber().length - 1; ++i) {
            for (int j = 0; j < a.getArrayNumber().length - i - 1; ++j) {
                if (a.getArrayNumber()[j] > a.getArrayNumber()[j + 1]) {
                    // Hoán đổi 2 phần tử
                    tmp = a.getArrayNumber()[j];
                    a.getArrayNumber()[j] = a.getArrayNumber()[j + 1];
                    a.getArrayNumber()[j + 1] = tmp;
                }
            }
        }
//         for (int i = 0; i < n - 1; i++)
//            for (int j = 0; j < n - i - 1; j++)
//                if (arr[j] > arr[j + 1]) {
//                    // swap arr[j+1] và arr[i]
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//        }
    }

//in ra mảng đã sắp xếp
    public void displayArray() {
        System.out.print("[");
        // vòng lặp
        for (int i = 0; i < a.getArrayNumber().length; i++) {
            System.out.print(a.getArrayNumber()[i]);
            if (i < a.getArrayNumber().length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

// hàm tìm kiếm
    public int binarySearch(int value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (a.getArrayNumber()[middle] == value) {
            return middle;
        } else if (a.getArrayNumber()[middle] > value) {
            // đệ quy quay lại hàm để tìm tiếp tục
            return binarySearch(value, left, middle - 1);
        } else {
            // đệ quy quay lại hàm để tìm tiếp tục
            return binarySearch(value, middle + 1, right);
        }
    }
// hàm tìm kiếm giá trị trong mảng nằm ở vị trí nào

    public void searchBinary(int value) {
        int found = binarySearch(value, 0, a.getArrayNumber().length - 1);
        System.out.print("\nFound " + value + " at index: " + found+"\n");
    }

}
