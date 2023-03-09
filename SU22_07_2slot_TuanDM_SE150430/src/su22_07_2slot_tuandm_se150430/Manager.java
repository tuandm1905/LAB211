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
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author SE150430
 */
public class Manager {

    Validate val = new Validate();
    Account acc;

    //create a new account
    public void addAccount() {
        //check file data exist or not
        if (!val.checkFileExist()) {
            return;
        }
        String username = val.checkInputUsername();
        String password = val.checkInputPassword();
        //check username exist or not
        if (!val.checkUsernameExist(username)) {
            System.out.println("Username exist.");
            return;
        }
        acc = new Account(username, password);
        addData(username, password);
    }

    //login system
    public void find() {
        //check file data exist or not
        if (!val.checkFileExist()) {
            return;
        }
        String username = val.checkInputUsername();
        String password = val.checkInputPassword();
        //check username exist or not
        if (!val.checkUsernameExist(username)) {
            if (!password.equalsIgnoreCase(val.passwordByUsername(username))) {
                System.out.println("Password incorrect.");
            } else
            System.out.println("Login success.");
        }
    }

    //write new account to data
    public static void addData(String username, String password) {
        File file = new File("user.dat");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(username + ";" + password + "\n");
            fileWriter.close();
            System.out.println("Create successly.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
