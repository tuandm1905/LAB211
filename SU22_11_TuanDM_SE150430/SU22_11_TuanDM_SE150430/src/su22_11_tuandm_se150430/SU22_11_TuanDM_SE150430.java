package su22_11_tuandm_se150430;

import java.util.Locale;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class SU22_11_TuanDM_SE150430 {

    /**
     * @param args the command line arguments
     */
    private static Validate val = new Validate();
    private static CheckProgram check = new CheckProgram();

    public static void main(String[] args) {
        Locale vietnamese = new Locale("vi");
        Locale english = Locale.ENGLISH;
        //loop until user want to exit
        while (true) {
            int choice = val.menu();
            switch (choice) {
                case 1:
                    check.log(vietnamese);
                    break;
                case 2:
                    check.log(english);
                    break;
                case 3:
                    return;
            }
        }
    }

}
