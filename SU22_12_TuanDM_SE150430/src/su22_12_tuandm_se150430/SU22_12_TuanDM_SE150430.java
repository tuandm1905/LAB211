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
public class SU22_12_TuanDM_SE150430 {

    /**
     * @param args the command line arguments
     */
    private static Manager Manager = new Manager();
    private static Validate Validate = new Validate();
    public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            int choice = Validate.menu();
            switch (choice) {
                case 1:
                    Manager.addContact();
                    break;
                case 2:
                    Manager.displayAll();
                    break;
                case 3:
                    Manager.deleteContact();
                    break;
                case 4:
                    return;
            }
        }
    }

}
