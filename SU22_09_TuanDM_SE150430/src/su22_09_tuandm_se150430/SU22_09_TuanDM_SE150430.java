/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_09_tuandm_se150430;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class SU22_09_TuanDM_SE150430 {

    /**
     * @param args the command line arguments
     */
    private static Manager Manager = new Manager();

    public static void main(String[] args) {
        //Khởi tạo hàm gọi các phương thức
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.InputSuperlative();
                    Manager.Superlative();
                    break;
                case 2:
                    Manager.InputQuadratic();
                    Manager.Quadratic();
                    break;
                case 3:
                    return;
            }
        }
    }

}
