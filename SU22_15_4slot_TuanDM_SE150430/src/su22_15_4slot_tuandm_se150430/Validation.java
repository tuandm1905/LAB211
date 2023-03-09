/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_15_4slot_tuandm_se150430;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dang Minh Tuan SE150430
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
                System.err.println("Please input number in rage [" + min + ", " + max + "]"); // thông báo ngoại lệ
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
                System.out.println("Not empty");
                System.out.print("Enter again: ");// thông báo ngoại lệ
            } else {
                return result;
            }
        }
    }

    //check user input yes/ no
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
            System.out.println("Please input y/Y or n/N.");// thông báo ngoại lệ
            System.out.print("Enter again: ");
        }
    }

    //check user input u / d
    public boolean checkInputUD() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.out.println("Please input u/U or d/D.");// thông báo ngoại lệ
            System.out.print("Enter again: ");
        }
    }

    //check user input course
    public String checkInputCourse() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check input course in java/ .net/ c/c++
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.out.println("There are only three courses: Java, .Net, C/C++");// thông báo ngoại lệ
            System.out.print("Enter again: ");
        }
    }

//     //check student exist
    public static boolean checkStudentExist(ArrayList<Element> ls, String id,
            String studentName, String semester, String courseName) {
        int size = ls.size(); // size của mảng
        for (Element student : ls) {// kiểm tra sinh viên có tồn tại hay không
            if (id.equalsIgnoreCase(student.getID())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }
//
//    //check report exist

    public static boolean checkReportExist(ArrayList<Report> lr, String name,
            String course, int total) {
        for (Report report : lr) { // kiểm tra sinh viên có tồn tại hay không và giá trị của khoá học
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }

    //check id and exist
    public boolean checkIdExist(ArrayList<Element> ls, String id, String name) {
        for (int i = 0; i < ls.size(); i++) {
            Element a = ls.get(i);
            if (id.equalsIgnoreCase(a.getID()) && name.equalsIgnoreCase(a.getStudentName())) { // kiểm tra id có tồn tại hay không
                return false;
            }
        }
        return true;
    }
//
    //check user change or not

    public static boolean checkChangeInfomation(Element student, String id,
            String name, String semester, String course) {
        if (id.equalsIgnoreCase(student.getID()) // kiểm tra phần tử id có bằng hay không?
                && name.equalsIgnoreCase(student.getStudentName()) // kiểm tra phần tử tên có bằng hay không?
                && semester.equalsIgnoreCase(student.getSemester()) // kiểm tra phần tử kỳ có bằng hay không?
                && course.equalsIgnoreCase(student.getCourseName())) { // kiểm tra phần tử số khoá có bằng hay không?
            return false;
        }
        return true;
    }
}
