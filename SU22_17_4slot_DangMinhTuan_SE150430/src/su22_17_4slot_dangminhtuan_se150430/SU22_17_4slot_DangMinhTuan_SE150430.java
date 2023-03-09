/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_17_4slot_dangminhtuan_se150430;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class SU22_17_4slot_DangMinhTuan_SE150430 {

    /**
     * @param args the command line arguments
     */
    private static Manager m = new Manager();

    public static void main(String[] args) {
        while (true) {
            int choice = m.menu();
            switch (choice) {
                case 1:
                    m.createCandidate(0);
                    break;
                case 2:
                    m.createCandidate(1);
                    break;
                case 3:
                    m.createCandidate(2);
                    break;
                case 4:
                    m.searchCandidate();
                    break;
                case 5:
                    return;
            }
        }
    }
}
