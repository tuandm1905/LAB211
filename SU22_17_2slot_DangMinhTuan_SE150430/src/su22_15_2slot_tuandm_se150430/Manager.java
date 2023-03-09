/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_15_2slot_tuandm_se150430;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Manager {

    public static ArrayList<Element> student = new ArrayList<>();
    private static Validation v = new Validation();

    public void menu() {
        addStudent();
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (v.checkInputYN()) {
                addStudent();
            } else {
                break;
            }
        }
        display();
    }
// hàm nhập vào thông tin sinh viên
    public void addStudent() {
        System.out.println("Please input student information ");
        System.out.print("Name: ");
        String name = v.checkInputString();
        System.out.print("Classes: ");
        String classes = v.checkInputString();
        System.out.print("Mark: ");
        float mark = v.checkInputFloat();
        student.add(new Element(name, mark, classes));
    }
// hàm in ra kết quả khi nhập và sắp xếp theo thứ tự A-Z
    public void display() {
        if (student.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        // hàm sort
        Collections.sort(student, new Comparator<Element>() { // dùng sor comparrator và so sánh 2 name để sort
            @Override
            public int compare(Element o1, Element o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (int i = 0; i < student.size(); i++) {
            System.out.printf("-------- Student %d --------", i + 1,"\n");
            System.out.println("Name: " + student.get(i).getName());
            System.out.println("Classes: " + student.get(i).getClasses());
            System.out.println("Mark: " + student.get(i).getMark());
        }
    }

}
