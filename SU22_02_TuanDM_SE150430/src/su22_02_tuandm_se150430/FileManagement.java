/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_02_tuandm_se150430;

import java.io.*;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author SE150430
 */
class FileManagement {

    private int numberOfAmount;
    private String W_FILE;
    LinkedList<IncomeSpending> linkedList;
    private String path;
    List<String> list = new ArrayList<>();

    public FileManagement(String path) throws FileException {
        this.setPath(path);
    }

    @Override
    public String toString() {
        return "FileManagement{" + "numberOfAmount=" + numberOfAmount + ", W_FILE=" + W_FILE + ", linkedList=" + linkedList + ", path=" + path + '}';
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) throws FileException {
        if (path.equals("")) {
            throw new FileException("The file cannot be empty!");
        } else {
            this.path = path;
        }
    }

    public FileManagement(int numberOfAmount, String W_FILE, LinkedList<IncomeSpending> linkedList, String path) {
        this.numberOfAmount = numberOfAmount;
        this.W_FILE = W_FILE;
        this.linkedList = linkedList;
        this.path = path;
    }

    void importCSV(String path) throws FileNotFoundException, FileException {
        File pathName = new File(path);
        // kiểm tra đường dẫn có tồn tại hay không
        if (pathName.isFile() && pathName.getName().endsWith(".csv")) {
            Scanner sc = new Scanner(pathName);
            sc.useDelimiter("\\n");
            int count = 0;
//            while (sc.hasNext()) {
//                if (count > 0) {
//                    String[] a = nextElement.split(",");
//                    list.add(new person(Integer.parseInt(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4]));
//                }
//                count++;
//            }
            if (pathName.isDirectory()) { // kiểm tra đường dẫn có phải là thư mục hay không
//                System.out.println("Đường dẫn đến thư mục");
                System.out.println("Đường dẫn đến thư mục");
            } else { // Vì đường dẫn đã đúng thì chỉ có 2 trường hợp 1 là thư mục 2 là tệp
                System.out.println("Import: Done");
            }
        } else {
            // Bắt ngoại lệ
            throw new FileException("Đường dẫn không tồn tại");
        }
    }

    void formatAddress() {
        for (String object : list) {
            String address = object.getAddress().toLowerCase();
            String[] test = address.toLowerCase().split("\\s+");
            int count = 0;
            address = "";
            for (String string : test) {
                if (count > 0) {
                    address += " ";
                }
                address += string.toUpperCase().charAt(0) + string.substring(1);
                count++;
            }
            object.setAddress(address);
        }
        System.out.println("------------ Format: Done");
    }

    void formatName() {
        for (String object : list) {
            String name = object.getName().toLowerCase();
            String[] test = name.toLowerCase().split("\\s+");
            int count = 0;
            name = "";
            for (String string : test) {
                if (count > 0) {
                    name += " ";
                }
                name += string.toUpperCase().charAt(0) + string.substring(1);
                count++;
            }
            object.setAddress(name);
        }
        System.out.println("------------ Format: Done");

    }

void exportCSV(String path) throws IOException {
        File file = new File(path);
        if (!file.exists) {
            if (file.isDirectory()) {
                System.out.println("Path to directory");
            } else {
                System.out.println("File does not exit");
                System.out.println("Created new file name %s\n", path);
                file.createNewFile();
            }
        }
        if (file.isFile()) {
            FileWriter writer = new FileWriter(new File(path), false);
            writer.append("ID, Name, Email, Phone, Number, Address\m");
            for (String object : list) {
                writer.append(object.ID + "," + object.name + "," + object.email + "," + object.phone + "," + object.address + "\n");
            }
            writer.flush();
            writer.close();
            System.out.println("Export: Done");
        }
    }
}