/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_12_tuandm_se150430;

import java.util.ArrayList;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Manager {

    ArrayList<Element> listElement = new ArrayList<>();
    public static Validate v = new Validate();
    public static Element e;

    public void addContact() {
        System.out.println("----------- Add a contact ----------");
        System.out.print("Enter name: ");
        String name = v.checkInputString();
        System.out.print("Enter group: ");
        String group = v.checkInputString();
        System.out.print("Enter address: ");
        String address = v.checkInputString();
        System.out.print("Enter phone: ");
        String phone = v.checkInputPhone();
        // cập nhật ID tự động
        int id = 0, count = 0;
        for (int j = 1;; ++j) {
            boolean check = true;
            for (int i = 0; i < this.listElement.size(); i++) {
                Element a = this.listElement.get(i);
                if (a.getID() == j) { // kiêm tra ID có trùng hay không
                    check = false;
                } else if (name == a.getName() && a.getGroup().equals(group) && a.getAddress().equals(address)) { // nguoc lai kiểm tra liên lạc đó có trong bảng chưa
                    count++;
                }
            }
            if (check == true) {
                id = j;
                // cập nhật data vào listElement
                e = new Element(id, name, group, address, phone);
                this.listElement.add(e);
                System.out.println("Add successful.");
                break;
            } else if (count != 0) {
                System.out.println("Error");// thông báo lỗi
                break;
            }
        }

    }
// hàm show display all list contact

    public void displayAll() {
        System.out.println("------- Display all contact -------");
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        //print infomation of contact from first to last list contact
        for (int i = 0; i < listElement.size(); i++) { // in thông tin liên lạc
            Element e = listElement.get(i);
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n", e.getID(), e.getName(), e.getFirstName(), e.getLastName(), e.getGroup(), e.getAddress(), e.getPhone());
        }
    }

    // tìm kiếm ID từ người dùng nhập vào
    public int findContact(int ID) {
        for (int i = 0; i < this.listElement.size(); i++) {
            Element b = this.listElement.get(i);
            if (b.getID() == ID) { // nếu ID đúng thì return ra i (i là vị trí của id cần xoá)
                return i;
            }
        }
        return -1; // id không được tìm thấy return -1
    }

    // xóa danh sách liên lạc theo yêu cầu của người dùng
    public boolean deleteContact() {
        System.out.println("------ Delete a contact ------");
        System.out.print("Enter ID: ");
        int id = v.checkInputInt();
        int index = findContact(id);
        if (index != - 1) { // nếu id trả về khác -1 thì xóa
            this.listElement.remove(index); // xóa liên lạc ở vị trí thứ i
            System.out.println("Contact Deleted Successfully.");
            return true;
        } else {
            // index = -1  nghĩa là không tìm thấy ID
            System.out.println("Couldn't find contact " + id + " from user input");
            return false;
        }
    }

}
