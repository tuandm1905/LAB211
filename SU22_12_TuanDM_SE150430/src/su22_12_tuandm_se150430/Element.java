/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_12_tuandm_se150430;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Element {

    //tạo thuộc tính
    private int ID;
    private String name;
    private String firstName;
    private String lastName;
    private String group;
    private String address;
    private String phone;

    public Element() {

    }
// tạo phương thức mới

    public Element(int ID, String name, String group, String address, String phone) {
        this.ID = ID;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    /**
     * tạo phương thức mới
     *
     * @param name
     * @param group
     * @param address
     * @param phone
     */
    public Element(String name, String group, String address, String phone) {
        this.name = name;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
// lấy first name từ name
    // vd dang minh tuan -> tuan

    public String getFirstName() {
        int index = spaceLetter(this.getName());
        // first name lấy tên của người nhập
        if (index != - 1) {
            this.firstName = this.getName().substring(0, index);
            return firstName;
        } else {
            this.firstName = "";
            return this.firstName;
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
// lấy last name từ name
    // vd dang minh tuan -> dang

    public String getLastName() {
        int index = spaceLetter(this.getName());
        // last name lấy họ của người nhập 
        int n = this.getName().length();
        if (index != - 1) {
            this.lastName = this.getName().substring(index + 1, n);
            return lastName;
        } else {
            this.lastName = this.getName();
            return this.lastName;
        }
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
// tìm dấu cách của name
    // lấy dấu cách nằm trước tên name

    public int spaceLetter(String name) {
        for (int i = this.getName().length() - 1; i >= 0; i--) {
            if (this.getName().charAt(i) == ' ') {
                return i;
            }
        }
        return -1;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
