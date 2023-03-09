/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_07_2slot_tuandm_se150430;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author SE150430
 */
public class Validate {

    private final static Scanner in = new Scanner(System.in);
    private final static String VALID_USERNAME = "^\\S{5}\\S*$";
    private final static String VALID_PASSWORD = "^\\S{6}\\S*$";
    menu m = new menu();

    //kiểm tra dữ liệu tệp có tồn tại hay không
    public boolean checkFileExist() {
        File file = new File("user.dat");
        if (!file.exists()) {
            try {
                System.err.println("File not exist!!!");
                file.createNewFile();
                System.err.println("File created.");
                return false;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    //cho phép người dùng nhập tên người dùng
    public String checkInputUsername() {
        System.out.print("Enter username: ");
        // vòng lặp cho đến khi người dùng nhập chính xác
        while (true) {
            String result = m.checkInputString();
            if (result.matches(VALID_USERNAME)) {
                return result;
            }
            System.out.println("You must enter least at 5 character, and no space!");
            System.out.print("Enter again: ");
        }
    }

    //cho phép người dùng nhập mật khẩu
    public String checkInputPassword() {
        System.out.print("Enter password: ");
        // vòng lặp cho đến khi người dùng nhập chính xác
        while (true) {
            String result = m.checkInputString();
            if (result.matches(VALID_PASSWORD)) {
                return result;
            }
            System.out.println("You must enter least at 6 character, and no space!");
            System.out.print("Enter again: ");
        }
    }

    //kiểm tra username tồn tại
    public boolean checkUsernameExist(String username) {
        File file = new File("user.dat");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";");
                //Cắt chuổi thành mảng bởi dấu ";"
                if (username.equalsIgnoreCase(account[0])) {
                    return false;
                }
            }
            bufferedReader.close();
            fileReader.close();
            return true;
        } catch (FileNotFoundException ex) {
            // ngoại lệ
            ex.printStackTrace();
        } catch (IOException ex) {
            // ngoại lệ
            ex.printStackTrace();
        }
        return true;
    }
    
    //lấy password bằng username
    public String passwordByUsername(String username) {
        File file = new File("user.dat");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //Cắt chuổi thành mảng bởi dấu ";"
                String[] account = line.split(";"); 
                // kiểm tra username hợp lệ hay không?
                if (username.equalsIgnoreCase(account[0])) {
                    return account[1];
                }
            }
            //đóng file
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            // ngoại lệ
            ex.printStackTrace();
        } catch (IOException ex) {
            // ngoại lệ
            ex.printStackTrace();
        }
        return null;
    }
}
