/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_19_tuandm_se150430;

/**
 *
 * @author Đặng Minh Tuấn SE150430
 */
public class SU22_19_TuanDM_SE150430 {

    /**
     * @param args the command line arguments
     */
    private static ZooManagement zm = new ZooManagement();

    public static void main(String[] args) {
        int choice = 0;
        zm.uploadFile();
        do {
            choice = zm.menu();
            switch (choice) {
                case 1:
                    // in ra danh sách animal theo id hoặc type
                    zm.show();
                    break;
                case 2:
                    // thêm animal
                    zm.add();
                    break;
                case 3:
                    // cập nhật theo ID
                    zm.update();
                    break;
                case 4:
                    // xóa sách theo id
                    zm.deleteZooByID();
                    break;
                case 5:
                    // tìm kiếm theo name or loại
                    zm.search();
                    break;
                case 6:
                    // lưu sách vào file animal.txt
                    zm.saveFile();
                    // thoat chương trình và cảm ơn
                    System.out.println("===========> THANK FOR USING PROGRAM <===========");
                    break;
                default:
                    // ngoài số 1->6 thì in ra 
                    System.out.println("===========> YOU MUST ENTER CHOICE FROM 1->6! <===========");
            }
        } while (choice != 6);
    }

}
