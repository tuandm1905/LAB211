package su22_11_tuandm_se150430;

import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class CheckProgram {

    Validate val = new Validate();
    Program pro = new Program();

    public String generateCaptcha() {
        // tạo ký tự random
        Random r = new Random();
        // tạo mảng chứa các kí tự random trong captcha
        char index[] = new char[6];
        // tạo mảng data chứa các kí tự chữ và số có trong Captcha
        char data[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9'};
        // vòng lặp tạo ký tự random
        for (int i = 0; i < (index.length); i++) {
            int ran = r.nextInt(data.length); // radom các số xuất trong mảng data
            index[i] = data[ran]; // gán các phần tử đã được random vào trong mảng index đã tạo trước đó
        }
        // trả về chuổi captcha
        return new String(index);
    }

    // hàm kiểm tra captcha người nhập có đúng hay không?
    public void checkCaptcha(Locale language) {
        while (true) {
            // tạo ra mã captcha
            String strCaptcha = generateCaptcha();
            System.out.println(strCaptcha);
            // chuyển đổi ngôn ngữ
            val.wordLanguage(language, "Captcha");
            // Nhập mã captcha
            String captchaInput = val.checkInputString(language);
            if (captchaInput.equals(strCaptcha)) { // kiểm tra mã captcha từ người dùng nhập vào
                val.wordLanguage(language, "loginSuccess"); // in ra ngôn ngữ và thông báo kiểm tra ĐÚNG
                System.out.println("");
                return;
            } else {
                // thông báo lỗi
                val.wordLanguage(language, "errCaptchaIncorrect"); // thông báo lỗi khi người nhập vào sai
                System.out.println(""); // xuống dòng mỗi lần báo
            }
        }
    }
// hàm kiểm tra mật khẩu nhập vào từ người dùng

    public boolean isValidPassword(String password, Locale language) {
        int lengthPassword = password.length();
        // kiểm tra độ dài mật khẩu
        if (lengthPassword < 8 || lengthPassword > 31) {
            val.wordLanguage(language, "errCheckLengthPassword");
            System.out.println("");
            val.wordLanguage(language, "errCheckAlphanumeric");
            System.out.println("");
            val.wordLanguage(language, "again");
            return false;
        } else {
            // kiểm tra mật khẩu có chứa ít nhât một kí tự và có chữ cái hay không. 
            // Và độ dài có phù hợp từ  8 đến  20 kí tự hay không
            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,31}$";
            boolean valid = isValidPassword(password, regex); // kiểm tra mật khẩu có đúng theo format hay không
            if (!valid) {
                // thông báo lỗi
                val.wordLanguage(language, "errCheckLengthPassword");
                System.out.println("");
                val.wordLanguage(language, "errCheckAlphanumeric");
                System.out.println("");
                val.wordLanguage(language, "again");
                return false;
            }
        }
        return true;
    }

    // kiểm tra mật khẩu có đúng theo format đã cho hay không?
    public boolean isValidPassword(String password, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // kiểm tra mật khẩu có đúng theo format đã cho hay không?
    public String checkPassword(Locale language) {
        String result;
        while (true) {
            result = val.checkInputString(language);
            if (isValidPassword(result, language)) { // kiểm tra mật khấu
                return result;
            }
        }
    }

    // hàm đăng nhập 
    public void log(Locale language) {
        val.wordLanguage(language, "enterAccountNumber");
        pro.setUserName(val.checkInputInt(language));
        val.wordLanguage(language, "enterPassword");
        pro.setPassword(checkPassword(language));
        checkCaptcha(language);
    }
}
