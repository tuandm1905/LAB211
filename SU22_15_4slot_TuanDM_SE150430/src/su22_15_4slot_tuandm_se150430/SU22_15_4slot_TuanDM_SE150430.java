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
public class SU22_15_4slot_TuanDM_SE150430 {

    /**
     * @param args the command line arguments
     */
    private static Validation v = new Validation();
    private static Manager m = new Manager();

    public static void main(String[] args) {
        // TODO code application logic here
        //loop until user want to exit program
        m.input();// tạo phần tử minh hoạ cho bài
        while (true) {
            //Show menu option
            m.menu();
            int choice = v.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    m.createStudent();
                    break;
                case 2:
                    m.findAndSort();
                    break;
                case 3:
                    m.updateOrDelete();
                    break;
                case 4:
                    m.report();
                    break;
                case 5:
                    return;
            }

        }
    }

}
