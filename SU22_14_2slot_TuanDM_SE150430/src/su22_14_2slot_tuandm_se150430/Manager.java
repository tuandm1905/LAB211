/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_14_2slot_tuandm_se150430;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author SE150430
 */
public class Manager {

    private static Element e = new Element();
    private static final Scanner in = new Scanner(System.in);
    public static ArrayList<Element> stringList = new ArrayList<>(); // lưu trữ task

    public void input() {
        System.out.println("===== Analysis String program ====");
        System.out.print("Input String: ");
        String inputString = in.nextLine().trim();
//        String inputString = "32hg321sdhkjDFGH!@#$%^22fdsf3fdgdf/";
//        String inputString = "321sdhkjDFGH!@#$%^16fdsf3";
        e = new Element(inputString);
        this.stringList.add(e);
    }
// hàm check số trong chuỗi

    public void checkNumber() {
        HashMap<String, ArrayList<Integer>> hmNumber = new HashMap<>(); // chuỗi hashmap
        String number = e.getInputStr().replaceAll("\\D+", ",");//  tìm khoảnh giữa các số và ký tự để thêm dấu phẩy vào
        if (number.charAt(number.length() - 1) == ',') {
            number = number.substring(0, number.length() - 1); // đánh dấu vị trí độ dài số trong chuỗi
        }
        if (number.charAt(0) == ',') {
            number = number.substring(1);
        }
        String[] listNumber = number.split(",");
        int lenNum = listNumber.length; // độ dài của số
        ArrayList<Integer> PerfectSquare = new ArrayList<>();
        ArrayList<Integer> Odd = new ArrayList<>();
        ArrayList<Integer> Even = new ArrayList<>();
        ArrayList<Integer> All = new ArrayList<>();
        for (int i = 0; i < lenNum; i++) { // vòng lặp kiểm tra các số trong chuỗi
            int numberCheck = Integer.parseInt(listNumber[i]);
            if (numberCheck % 2 == 1) { // kiểm tra số lẻ
                Odd.add(numberCheck);
            }
            if (numberCheck % 2 == 0) { // kiểm tra số chẳn
                Even.add(numberCheck);
            }
            if (checkSquareNumber(numberCheck)) { // kiểm tra số chính phương
                PerfectSquare.add(numberCheck);

            }
            All.add(numberCheck); // tất cả các số có trong chuỗi
        }// thêm giá trị vào mảng hashmap
        hmNumber.put("Perfect Square Numbers: ", PerfectSquare);
        hmNumber.put("Odd Numbers: ", Odd);
        hmNumber.put("Even Numbers: ", Even);
        hmNumber.put("All Numbers: ", All);
        for (Map.Entry m : hmNumber.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
// hàm check ký tự trong chuỗi

    public void checkCharacter() {
        HashMap<String, String> hmString = new HashMap<>();
        e.setUppercase(e.getInputStr().replaceAll("\\W|[0-9]|[a-z]", "")); // lọc những ký tự in hoa
        e.setLowercase(e.getInputStr().replaceAll("\\W|[0-9]|[A-Z]", "")); // lọc những ký tự không in hoa
        e.setSpecial(e.getInputStr().replaceAll("\\w", "")); // lọc những ký tự đặc biệt
        e.setAllCharacter(e.getInputStr().replaceAll("\\W", "")); // tất cả các ký tự trong chuỗi
        hmString.put("Uppercase: ", e.getUppercase());
        hmString.put("Lowercase: ", e.getLowercase());
        hmString.put("Special: ", e.getSpecial());
        hmString.put("All Character: ", e.getAllCharacter());
        for (Map.Entry m : hmString.entrySet()) { // in ra các ký tự theo đề bài yêu cầu
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
// hàm kiểm tra số chính phương
    public boolean checkSquareNumber(double n) {
        double sq = Math.sqrt(n);
        sq = sq - Math.floor(sq);
        if (sq == 0) {
            return true;
        }
        return false;
    }
}
