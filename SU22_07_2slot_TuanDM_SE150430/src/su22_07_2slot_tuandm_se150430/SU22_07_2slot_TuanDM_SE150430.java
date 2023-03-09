/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_07_2slot_tuandm_se150430;

/**
 *
 * @author SE150430
 */
public class SU22_07_2slot_TuanDM_SE150430 {

    private static Manager mv = new Manager(); //tạo đối tượng
    private static menu menu = new menu(); //tạo đối tượng

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            int choice = menu.menu();
            switch (choice) {
                case 1:
                    mv.addAccount();
                    break;
                case 2:
                    mv.find();
                    break;
                case 3:
                    return;
            }
        }
    }

}
