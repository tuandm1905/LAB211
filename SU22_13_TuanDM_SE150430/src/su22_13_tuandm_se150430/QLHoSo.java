package su22_13_tuandm_se150430;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Đặng Minh Tuấn SE150430
 */
public class QLHoSo implements Serializable {

    ArrayList<HoSo> hosoList = new ArrayList<>();

    ; // tạo arraylist để lưu tổ chức nhập vào và để lưu vào file

// hàm xử lý
    public void Menu() {
        Scanner scanner_num = new Scanner(System.in);
        while (true) {
            System.out.println("\n- - - - - - - - - - File Management - - - - - - - - - - ");
            System.out.println("1. Thêm hồ sơ.");
            System.out.println("2. Hiển thị danh sách hồ sơ.");
            System.out.println("0. Thoát.");
            System.out.print("Please choose: ");
            int n = scanner_num.nextInt();
            if (n == 1) {
                Add();
            }
            if (n == 2) {
                Show();
            }
            if (n == 0) {
                System.out.println("GOOD BYE!");
                xuatFile(); // kết thúc ghi chương trình đã chạy vào file
                break;
            }
        }
    }
// hàm đọc dữ liệu từ file

    public void nhapFile() {
        try {
            FileInputStream file = new FileInputStream("Data.txt"); //tạo file mới data.txt          
            ObjectInputStream ois = new ObjectInputStream(file);
            hosoList = (ArrayList<HoSo>) ois.readObject(); //đọc file, lưu file vào list            
            ois.close();
            this.hosoList = hosoList;
        } catch (Exception e) {
        }

    }

    // hàm ghi dữ liệu ra file
    public void xuatFile() {
        try {
            FileOutputStream file = new FileOutputStream("Data.txt"); //lữu dữ liệu ra file data.txt       
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(hosoList); //lưu vào file          
            oos.flush();
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // hàm thêm giá trị vào array list

    public void Add() {
        HoSo hoso = new HoSo();
        hoso.Nhap();
        hosoList.add(hoso);
    }
// hàm tạo bảng
    public void Show() {
        System.out.println("\nID\tName\tDate\tAddress");
        for (HoSo i : hosoList) { // in các đối tượng
            i.Xuat();
        }
    }
}
