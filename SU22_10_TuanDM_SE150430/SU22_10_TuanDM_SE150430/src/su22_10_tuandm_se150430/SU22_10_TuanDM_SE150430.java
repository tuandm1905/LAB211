package su22_10_tuandm_se150430;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class SU22_10_TuanDM_SE150430 {

    /**
     * @param args the command line arguments
     */
    private static Management manager = new Management();
    private static Validate val = new Validate();

    public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            int choice = val.menu();
            switch (choice) {
                case 1:
                    manager.addWork();
                    break;
                case 2:
                    manager.deleteWork();
                    break;
                case 3:
                    manager.displayWork();
                    break;
                case 4:
                    return;
            }
        }
    }
}
