package su22_11_tuandm_se150430;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Validate {

    private static final Scanner in = new Scanner(System.in);

    //show display menu
    public int menu() {
        System.out.println(" = = = = = Login Program = = = = = ");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = checkInput(1, 3);
        return choice;
    }

    //check user input number limit
    public int checkInput(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //kiểm tra đầu vào của người dùng một số nguyên
    public int checkInputInt(Locale lang) {
        //lặp lại cho đến khi người dùng nhập chính xác
        while (true) {
            String result = in.nextLine().trim();
            // kiểm tra số có đủ 10 chữ số hay không và có đầy đủ từ 0 đến 9
            if (result.matches("^[0-9]{10}$")) {
                return Integer.parseInt(result);
            } else {
                wordLanguage(lang, "errCheckInputAccount");
                System.out.println("");
                wordLanguage(lang, "again");
            }
        }
    }

    /**
     * check user input string
     *
     * @return
     */
    public String checkInputString(Locale lang) {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                // lấy dữ liệu theo ngôn ngữ
                wordLanguage(lang, "errCheckInputIntLimit");
                wordLanguage(lang, "again");
            } else {
                // trả về kế quả Nhập vào
                return result;
            }
        }
    }

    // chuyển đổi từ ngôn ngữ
    public void wordLanguage(Locale language, String str) {
        //  một class trong Java dùng để lấy dữ liệu / văn bản /string theo các ngôn ngữ khác nhau
        ResourceBundle words = ResourceBundle.getBundle("Language/" + language, language);
        String key = words.getString(str);
        System.out.printf(key); // lấy ngôn ngữ
    }

}
