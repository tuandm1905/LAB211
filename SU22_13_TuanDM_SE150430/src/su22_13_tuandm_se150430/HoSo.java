package su22_13_tuandm_se150430;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Đặng Minh Tuấn SE150430
 */
public class HoSo implements Serializable {
// tạo đối tượng

    private String IDHS;
    private String tenTC;
    private String namDK;
    private String diaChi;

    //tạo phương thức
    public HoSo() {
    }
//tạo phương thức

    public HoSo(String IDHS, String tenTC, String namDK, String diaChi) {
        this.IDHS = IDHS;
        this.tenTC = tenTC;
        this.namDK = namDK;
        this.diaChi = diaChi;
    }

//tạo set get cho đối tượng
    public String getIDHS() {
        return IDHS;
    }

    public void setIDHS(String IDHS) {
        this.IDHS = IDHS;
    }

    public String getTenTC() {
        return tenTC;
    }

    public void setTenTC(String tenTC) {
        this.tenTC = tenTC;
    }

    public String getNamDK() {
        return namDK;
    }

    public void setNamDK(String namDK) {
        this.namDK = namDK;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

// hàm nhập thông tin
    public void Nhap() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter ID number: ");
        while (true) {
            try {
                IDHS = in.nextLine();
                if (!IDHS.matches("[0-9]{4}$")) { //Nếu id khác format XXXX phải chứa 4 ký tự đều là số nếu không thì bắt lỗi
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Please id number again: "); // thông báo ngoại lệ
            }
        }
        System.out.print("Please enter TenTC: ");
        while (true) {
            try {
                tenTC = in.nextLine();
                if (tenTC.trim().equals("")) { // Nếu tenTC là null (rỗng) thì bắt lỗi
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Please enter TenTC again: "); // thông báo ngoại lệ
            }
        }

        System.out.print("Please enter NamDK: ");
        while (true) {
            try {
                namDK = in.nextLine();
                if (Integer.parseInt(namDK) < 1900) { // Nếu giá trị nhập vào namDK < 1900 thì bắt lỗi
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Please enter NamDK again (>1900): ");// thông báo ngoại lệ
            }
        }

        System.out.print("Please enter DChi: ");
        while (true) {
            try {
                diaChi = in.nextLine();
                if (diaChi.trim().equals("")) { // Nếu diaChi là null (rỗng) thì bắt lỗi
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Please enter DChi again: ");// thông báo ngoại lệ
            }
        }
    }
// hàm xuất thông tin
    public void Xuat() {
        System.out.printf("%s\t%s\t%s\t%s\n", IDHS, tenTC, namDK, diaChi);
    }

}
