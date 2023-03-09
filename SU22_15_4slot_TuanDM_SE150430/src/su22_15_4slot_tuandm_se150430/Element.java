/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_15_4slot_tuandm_se150430;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Element {
// tạo đối tượng

    private String ID;
    private String studentName;
    private String Semester;
    private String CourseName;
    private int count;
    private int countCourse;
// tạo phương thức

    public Element() {

    }

    public Element(String ID, String studentName, String Semester, String CourseName) {
        this.ID = ID;
        this.studentName = studentName;
        this.Semester = Semester;
        this.CourseName = CourseName;
    }
// tạo hàm set get

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountCourse() {
        return countCourse;
    }

    public void setCountCourse(int countCourse) {
        this.countCourse = countCourse;
    }

}
