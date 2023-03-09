/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_15_4slot_tuandm_se150430;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Manager {

    private static Validation Validation = new Validation();
    ArrayList<Element> stuList = new ArrayList<>();
    private static Element e;
    private static Report r;

// hàm menu
    public void menu() {
        System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");
        System.out.print("Please choose 1 to 5: ");

    }
    //Allow user create new student

    public void input() { // tạo thêm phần tử minh hoạ cho bài
        this.stuList.add(new Element("1", "Dang Minh Tuan", "Spring", "java"));
        this.stuList.add(new Element("2", "Vo Quoc Thai", "Summer", ".net"));
        this.stuList.add(new Element("3", "Vo Quoc Thai", "Fall", "java"));
        this.stuList.add(new Element("4", "Bui Tran Vu Quyen", "Summer", "java"));
        this.stuList.add(new Element("5", "Bui Tran Vu Quyen", "Spring", "java"));
        this.stuList.add(new Element("6", "Vo Quoc Thai", "Summer", ".net"));
        this.stuList.add(new Element("7", "Dang Minh Tuan", "Spring", "c/c++"));
        this.stuList.add(new Element("8", "Dang Minh Tuan", "Fall", "java"));
        this.stuList.add(new Element("9", "Pham Nhat An", "Spring", "c/c++"));
        this.stuList.add(new Element("10", "Pham Nhat An", "Fall", "java"));
    }
// hàm cập nhật thêm sinh viên vào mảng

    public void createStudent() {
        //if number of students greater than 10 ask user continue or not
        if (this.stuList.size() > 10) {
            System.out.print("Do you want to continue (Y/N): "); // thông báo trên 10 sinh viên
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        //loop until user input not duplicate
//        while (true) {
        System.out.print("Enter id: ");
        String id = Validation.checkInputString();
        System.out.print("Enter name student: ");
        String name = Validation.checkInputString();
        if (!Validation.checkIdExist(stuList, id, name)) {
            System.out.println("Id has exist student. Pleas re-input.");
            Validation.checkInputString();
        }
        System.out.print("Enter semester: ");
        String semester = Validation.checkInputString();
        System.out.print("Enter name course: ");
        String course = Validation.checkInputCourse();

        // cập nhật data vào listElement
        if (Validation.checkStudentExist(stuList, id, name, semester, course)) { // kiểm tra phần tử
            stuList.add(new Element(id, name, semester, course)); // add phần tử vào mảng
            System.out.println("Add student success.");
            return;
        }

    }

//Hàm kiểm tra ID và trả về 1 con số nguyên.Nếu có thì trả về vị trí i>= 0 nếu không có thì trả về -1.
    public int checkID(String id) {
        for (int i = 0; i < stuList.size(); i++) {
            if (stuList.get(i).getID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    // hàm show display all list contact
    public void displayAll() {
        // tạo bảng
        System.out.println("+-----+-------------------------+------------+----------+");
        System.out.println("|ID   |Name                     |Semester    |Course    |");
        System.out.println("+-----+-------------------------+------------+----------+");
        for (int i = 0; i < stuList.size(); i++) {// in giá trị ra bảng
            System.out.printf("|%-5s|%-25s|%-12s|%-10s|\n",
                    stuList.get(i).getID(),
                    stuList.get(i).getStudentName(),
                    stuList.get(i).getSemester(),
                    stuList.get(i).getCourseName());
        }
        System.out.println("+-----+-------------------------+------------+----------+");
    }
// hàm tìm tên và sort lại danh sách theo tên

    public void findAndSort() {
        boolean check = false;
        ArrayList<Element> listSP = new ArrayList();
        System.out.print("Enter name to search: ");
        String name = Validation.checkInputString();
        for (Element student : stuList) {
            //check student have name contains input
            if (student.getStudentName().contains(name)) { // kiểm tra name nhập vào có tồn tại hay không
                listSP.add(student);
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Not found student by name."); // thông báo ngoại lệ
            return;
        }
        Collections.sort(listSP, new Comparator<Element>() { // dùng sor comparrator và so sánh 2 name để sort
            @Override
            public int compare(Element o1, Element o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        });
        // tạo bảng
        System.out.println("+--------------------+----------+----------+");
        System.out.println("|Name                |Semester  |Course    |");
        System.out.println("+--------------------+----------+----------+");
        for (int i = 0; i < listSP.size(); i++) {
            System.out.printf("|%-20s|%-10s|%-10s|\n",
                    listSP.get(i).getStudentName(),
                    listSP.get(i).getSemester(),
                    listSP.get(i).getCourseName());
        }
        System.out.println("+--------------------+----------+----------+");
    }

    //Allow user update and delete   
    public void updateOrDelete() {
        //if list empty 

        if (stuList.isEmpty()) {// kiểm tra mảng rỗng hay không
            System.out.println("List empty.");
            return;
        }
        System.out.print("Enter id: ");
        String id = Validation.checkInputString();
        ArrayList<Element> listStudentFindByName = getListStudentById(stuList, id);
        //check list empty
        if (listStudentFindByName.isEmpty()) { // kiểm tra mảng rổng hay không
            System.err.println("Not found student.");
            return;
        } else {
            Element student = getStudentByListFound(listStudentFindByName);
            System.out.print("Do you want to update (U) or delete (D) student: "); // thông báo cần update hay delee
            //check user want to update or delete
            if (Validation.checkInputUD()) {
                System.out.print("Enter id: ");
                String idStudent = Validation.checkInputString();
                System.out.print("Enter name student: ");
                String name = Validation.checkInputString();
                System.out.print("Enter semester: ");
                String semester = Validation.checkInputString();
                System.out.print("Enter name course: ");
                String course = Validation.checkInputCourse();
                //check user change or not
                if (!Validation.checkChangeInfomation(student, id, name, semester, course)) {
                    System.out.println("Nothing change.");
                }
                //check student exist or not
                if (Validation.checkStudentExist(stuList, id, name, semester, course)) {
                    student.setID(idStudent);
                    student.setStudentName(name);
                    student.setSemester(semester);
                    student.setCourseName(course);
                    System.out.println("Update success.");
                }
                return;
            } else {
                stuList.remove(student);
                System.out.println("Delete success."); // thông báo đã xoá
                return;
            }
        }
    }

    //Get list student find by id
    public ArrayList<Element> getListStudentById(ArrayList<Element> ls, String id) {
        ArrayList<Element> getListStudentById = new ArrayList<>();
        for (Element student : stuList) {
            if (id.equalsIgnoreCase(student.getID())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    //Get student user want to update/delete in list found
    public Element getStudentByListFound(ArrayList<Element> listStudentFindByName) {
        System.out.println("List student found: ");
        int count = 1;
        displayAll();
        //display list student found
        for (Element student : listStudentFindByName) {
            System.out.printf("|%-5d|%-25s|%-12s|%-10s|\n",
                    count,
                    student.getStudentName(),
                    student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.print("Enter student: ");
        int choice = Validation.checkInputIntLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice - 1);
    }

//    
    //Print report
    public void report() {
        int total[] = new int[stuList.size()];
        for (int i = 0; i < stuList.size(); i++) {
            total[i] = 1;
        }
        for (int i = 0; i < stuList.size() - 1; i++) {
            String name = stuList.get(i).getStudentName();
            String course = stuList.get(i).getCourseName();
            for (int j = i + 1; j < stuList.size(); j++) {
                if (total[j] != 0) {
                    if (stuList.get(j).getStudentName().equalsIgnoreCase(name)
                            && stuList.get(j).getCourseName().equalsIgnoreCase(course)) { // kiểm tra name có bị trùng hay không để lọc từng tên trùng ra
                        total[i]++;
                        total[j] = 0;
                    }
                }
            }
        }
        System.out.println("+--------------------+----------+----------+");
        System.out.println("|Name                |Course    |Total     |");
        System.out.println("+--------------------+----------+----------+");
        for (int i = 0; i < stuList.size(); i++) {
            if (total[i] != 0) {
                System.out.printf("|%-20s|%-10s|%-10s|\n",
                        stuList.get(i).getStudentName(),
                        stuList.get(i).getCourseName(),
                        total[i]);
            }
        }
        System.out.println("+--------------------+----------+----------+");
    }

}
