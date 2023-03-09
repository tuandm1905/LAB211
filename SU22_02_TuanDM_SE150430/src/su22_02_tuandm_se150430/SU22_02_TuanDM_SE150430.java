/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_02_tuandm_se150430;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
import javafx.scene.input.DataFormat;

/**
 *
 * @author SE150430
 */
public class SU22_02_TuanDM_SE150430 {

    /**
     * @param args the command line arguments
     */
    private static FileManagement fm;
    private static boolean isValid = true;

    public static File[] getFileWithSizeGreaterThanInput(String path, int size) throws FileException {
        File pathFile = new File(path); // Create một instance file
        File[] fileList = null; // Create một mảng rỗng
        if (!pathFile.exists()) { // Check link đường dẫn có tồn tại hay không?
            throw new FileException("Invalid input path!");
        } else {
            if (pathFile.isFile()) { // Check if the path is a directory or not
                throw new FileException("Invalid input path!");
            } else {

                // Check if the path is a directory or not?
                int i = 0, j = 0;
                // The while loop is used to initialize the number of elements for the fileList array
                // Because I don't know how many files the directory path contains
                // has a size larger than size

                while (i < pathFile.listFiles().length) {
                    int byteGreater = (int) pathFile.listFiles()[i].length();
                    if (byteGreater > size) {
                        j++;
                    }
                    i++;
                }
                fileList = new File[j];
                j = 0;
                i = 0;
                // Vòng while này dùng gán giá trị cho mảng fileList
                while (i < pathFile.listFiles().length) {
                    int byteGreater = (int) pathFile.listFiles()[i].length();
                    if (byteGreater > size) {
                        fileList[j] = pathFile.listFiles()[i];
                        j++;
                    }
                    i++;
                }

            }
        }

        return fileList;
    }

    public static void main(String[] args) throws FileException, FileNotFoundException {
            Scanner sc = new Scanner(System.in);
            int choice = 0;
            do {
                try {
//                    isValid = true;
                    System.out.println("============== Format CSV Program ==============");
                    System.out.println("1. Import CSV");
                    System.out.println("2. Format Address");
                    System.out.println("3. Format name");
                    System.out.println("4. Export CSV");
                    System.out.println("5. Exit");
                    System.out.print("Please choice one option: ");
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            do {
                                System.out.println("------------Check path------------");
                                System.out.print("Vui lòng nhập đường dẫn: ");
                                String path = sc.nextLine();
                                isValid = true;
                                try {
                                    fm = new FileManagement(path);
                                    fm.importCSV(fm.getPath());
                                } catch (FileException ex) {
                                    System.out.println(ex.getMessage());
                                    isValid = false;
                                    sc.nextLine();
                                }
                            } while (isValid == false);
                            break;
                        case 2:
//                        do {
//                            System.out.println("------------Get file name with type java------------");
//                            System.out.print("Vui lòng nhập đường dẫn: ");
//                            String path = sc.nextLine();
//                            isValid = true;
//                            try {
//                                fm = new FileManagement(path);
//                                int count = 0;
//                                List<String> list = fm.getAllFileNameJavaInDirectory(fm.getPath());
//                                for (int i = 0; i < list.size(); i++) {
//                                    System.out.println(list.get(i));
//                                    count++;
//                                }
//                                if (count == 0) {
//                                    System.out.println("Result: " + count);
//                                } else {
//                                    System.out.println("Result: " + count);
//                                }
//                            } catch (FileException ex) {
//                                System.out.println(ex.getMessage());
//                                isValid = false;
//                                sc.nextLine();
//                            }
//                        } while (isValid == false);
//                        break;
//                    case 3:
//
//                        try {
//                            System.out.println("------------Get file with size greater than input------------");
//                            System.out.print("Vui lòng nhập đường dẫn: ");
//                            String path = sc.nextLine();
//                            fm = new FileManagement(path);
//                            System.out.print("Số size: ");
//                            int size = sc.nextInt();
//                            sc.nextLine();
//                            isValid = true;
//                            File[] fileList = getFileWithSizeGreaterThanInput(fm.getPath(), size);
//                            int n = fileList.length;
//                            if (n == 0) {
//                                System.out.println("Result: " + n);
//                            } else {
//                                for (int i = 0; i < n; i++) {
//                                    System.out.printf("%d ", i + 1);
//                                    System.out.println(fileList[i].getName());
//                                }
//                                System.out.println("Result: " + n);
//                            }
//                        } catch (FileException ex) {
//                            System.out.println(ex.getMessage());
//                            isValid = false;
//                            sc.nextLine();
//                        }
//                        break;
//                    case 4:
//                        try {
//                            System.out.println("------------Write more content to file------------");
//                            System.out.print("Vui lòng nhập đường dẫn: ");
//                            String path = sc.nextLine();
//                            fm = new FileManagement(path);
//                            System.out.print("Vui lòng nhập nội dung: ");
//                            String content = sc.nextLine();
//                            boolean check = fm.appendContentToFile(fm.getPath(), content);
//                            if (check == true) {
//                                System.out.println("Viết xong");
//                            } else {
//                                System.out.println("Đường dẫn không tồn tại");
//                            }
//                        } catch (FileException ex) {
//                            System.out.println(ex.getMessage());
//                            isValid = false;
//                            sc.nextLine();
//                        }
//                        break;
//                case 5:
//                    try {
//                        System.out.println("------------Read file and count characters------------");
//                        System.out.print("Vui lòng nhập đường dẫn: ");
//                        String path = sc.nextLine();
//                        fm = new FileManagement(path);
//                        int countChar = fm.countCharacter(fm.getPath());
//                        System.out.println("Total: " + countChar);
//                    } catch (FileException ex) {
//                        System.out.println(ex.getMessage());
//                        isValid = false;
//                        sc.nextLine();
//                    }
//                    break;
                        case 5:

                            System.out.println("\n--------------------------------------");
                            System.out.println("Cảm ơn đã dùng software của chúng tôi!\n"
                                    + "Hẹn gặp lại!");
                            isValid = true;
                            break;
                        default:
                            System.out.println("Lỗi: Vui lòng chọn từ 1 đến 5 và phải là số nguyên");
                            isValid = false;
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: The function must be a integer number from 1 to 5!");
                    isValid = false;
                    sc.nextLine();
                }
            } while (isValid == false || choice != 5);
        }
    }
