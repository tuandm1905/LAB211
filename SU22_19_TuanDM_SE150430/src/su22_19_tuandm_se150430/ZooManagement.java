/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_19_tuandm_se150430;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Đặng Minh Tuấn SE150430
 */
public class ZooManagement {

    private Zoo zoo;
    ArrayList<Zoo> listZoo;
    ArrayList<Type> listType;
    File animals = new File("animal.txt");
    File types = new File("type.txt");
    ArrayList<Zoo> listData = new ArrayList<>();

    private static Validation v = new Validation();
// hàm menu

    public int menu() {
        System.out.println("\n\n=================== The Zoo Management ===================");
        System.out.println("1. Show animal list");
        System.out.println("2. Add new animal");
        System.out.println("3. Update animal");
        System.out.println("4. Delete animal");
        System.out.println("5. Search animal");
        System.out.println("6. Exit");
        System.out.print("Please enter function: ");
        int choice = v.checkInputIntLimit(1, 6);
        return choice;
    }
// hàm select search animal

    public int getSearchAnimal() {
        System.out.println("\n\n========================== Search animal ==========================");
        System.out.println("1. Search by name");
        System.out.println("2. Search by type");
        System.out.println("0. Exit");
        System.out.print("Please enter function: ");
        int choice = v.checkInputIntLimit(0, 2);
        return choice;
    }
// hàm select show animal

    public int getShowAnimalList() {
        System.out.println("\n\n========================== Show animal list ==========================");
        System.out.println("1. Show by Type");
        System.out.println("2. Show all");
        System.out.println("0. Exit");
        System.out.print("Please enter function: ");
        int choice = v.checkInputIntLimit(0, 2);
        return choice;
    }

    /**
     * phương thức in ra tất cả danh sách của Zoo
     */
    public void showAnimalAll() {
        if (listZoo.isEmpty()) {
            System.out.println("List animal is empty!");
            return;
        }
        System.out.printf("%-20s %-20s %-20s %-20s %n", "ID", "Name", "Weight", "IDType");
        for (Zoo zoo : listZoo) {
            System.out.printf("%-20s %-20s %-20.1f %-20s %n", zoo.getIdAnimal(), zoo.getName(), zoo.getWeight(), zoo.getIdType());
        }
    }

    /**
     * phương thức in ra tất cả danh sách theo Type
     */
    public void showTypelAll() {
        if (listZoo.isEmpty()) {
            System.out.println("List animal is empty!");
            return;
        }
        searchAnimalByType();
    }

    /**
     * Phương thức thêm vào
     */
    private void addingZoo() {
        String idAnimal;
        String name;
        double weight;
        String idType;
        System.out.println("====== ADD NEW ZOO ======");
        System.out.print("Input ID of ZOO: ");
        do {
            idAnimal = v.checkInputString();
            if (isDuplicate(idAnimal)) {
                System.out.println("Zoo ID is duplicate!");
                System.out.print("Input Again: ");
                continue;
            }
            break;
        } while (true);
        System.out.print("Input name of zoo: ");
        name = v.checkInputString();
        System.out.print("Input weight of zoo: ");
        weight = v.checkInputDouble(0);
        System.out.print("Input ID of Type: ");
        do {
            idType = v.checkInputString();
            if (!isExistType(idType)) {
                System.out.println("ID type is not exist!");
                System.out.print("Input Again: ");
                continue;
            }
            break;
        } while (true);
        zoo = new Zoo(idAnimal, name, weight, idType);
        listZoo.add(zoo);
    }

    public boolean isDuplicate(String idInput) {
        if (listZoo.isEmpty()) {
            return false;
        }
        for (Zoo zoo : listZoo) {
            if (zoo.getIdAnimal().equalsIgnoreCase(idInput)) {
                return true;
            }
        }
        return false;
    }

    /**
     * update information book
     */
    public void update() {
        showAnimalAll();
        System.out.print("Please input ID of animal: ");
        zoo = getZoo(v.checkInputString());// kiem tra animal co nam trong danh sach hay khong
        if (zoo == null) {// nếu tim khong thay
            System.out.println("Animal does not exist"); // thông báo
            System.out.println("Updating failing!"); // thông báo fail
        } else {// tim thay va bat dau cap nhat
            String name;
            String idType;
            double weight;
            System.out.println("====== UPDATE ZOO ======");
            System.out.print("Input new name: ");
            name = v.checkInputString();
            zoo.setName(name);
            System.out.print("Input new weight: ");
            weight = v.checkDoubleWeight();
            System.out.print("Input new ID type: ");
            do {
                idType = v.checkInputString();
                if (!isExistType(idType)) {// kiem tra id loại co trung hay khong
                    System.out.println("ID Type is not exist!");
                    for (int i = 0; i < listType.size(); i++) {// in ra danh sach cac loai co trong file
                        System.out.println("id: " + listType.get(i).getIdType() + " name: " + listType.get(i).getName());
                    }
                    System.out.print("Input Again: ");
                    continue;
                }
                zoo.setIdType(idType);// cap nhat id loai
                break;
            } while (true);
            System.out.println("Updating successfully!"); // thông báo thành công
        }
    }

    /**
     * phuong thuc delete
     */
    public void deleteZooByID() {
        showAnimalAll();
        System.out.print("Please input id: ");
        zoo = getZoo(v.checkInputString());//tim ID của animal
        if (zoo == null) {
            System.out.println("Animal does not exist");
            System.out.println("Deleting failing!");
        } else {
            listZoo.remove(zoo);//xoa animal
            System.out.println("Deleting successfully!");
        }
    }

    public void search() {
        int choice = 0;
        do {
            choice = getSearchAnimal();
            switch (choice) {
                case 1:
                    // in ra danh sách animal tìm kiếm theo ID
                    searchAnimalByName();
                    break;
                case 2:
                    // in ra danh sách animal tìm kiếm theo Type
                    searchAnimalByType();
                    break;
                case 0:
                    break;
                default:
                    // ngoài số 1->2 thì in thông báo 
                    System.out.println("===========> YOU MUST ENTER CHOICE FROM 1->2! <===========");
            }
        } while (choice != 0);
    }

    public void show() {
        int choice = 0;
        do {
            choice = getShowAnimalList();
            switch (choice) {
                case 1:
                    // in ra danh sách animal show theo Name
                    showTypelAll();
                    break;
                case 2:
                    // in ra tất cả danh sách animal
                    showAnimalAll();
                    break;
                case 0:
                    System.out.println(choice);
                    break;
                default:
                    // ngoài số 1->2 thì in thông báo 
                    System.out.println("===========> YOU MUST ENTER CHOICE FROM 1->2! <===========");
            }
        } while (choice != 0);
    }

    /**
     * search theo ten animal
     */
    public void searchAnimalByName() {
        String text;
        System.out.print("Input Name: ");
        text = v.checkInputString();

        listData.clear(); // xoá sạch danh sách
        for (Zoo zoo : listZoo) {
            if (zoo.getName().contains(text)) {// dung de tim kiem keyword name
                listData.add(zoo);// dung de luu tru nhung tu trung
            }
        }
        if (listData.isEmpty()) {// khong ton tai
            System.out.println("Not Found!");
        } else {// in ra table
            System.out.printf("%-20s %-20s %-20s %-20s %n", "ID", "Name", "Weight", "Group");
            for (Zoo zoo : listData) {  // vòng lặp in ra các animal theo tên
                System.out.printf("%-20s %-20s %-20.1f %-20s %n", zoo.getIdAnimal(), zoo.getName(), zoo.getWeight(), zoo.getIdType());
            }
        }
    }

    /**
     * search theo ten animal
     */
    public void searchAnimalByType() {
        String text;
        System.out.print("Input Type: ");
        text = v.checkInputString();

        listData.clear(); // xoá sách danh sách
        for (Zoo zoo : listZoo) {
            if (zoo.getIdType().contains(text)) {// dung de tim kiem keyword name
                listData.add(zoo);// dung de luu tru nhung tu trung
            }
        }
        if (listData.isEmpty()) {// khong ton tai
            System.out.println("Not Found!");
        } else {// in ra table
            System.out.printf("%-20s %-20s %-20s %-20s %n", "ID", "Name", "Weight", "Group");
            for (Zoo zoo : listData) { // vòng lặp in ra các animal theo loại
                System.out.printf("%-20s %-20s %-20.1f %-20s %n", zoo.getIdAnimal(), zoo.getName(), zoo.getWeight(), zoo.getIdType());
            }
        }
    }

    /**
     * Check Loại xem có tồn tại không
     */
    public boolean isExistType(String idInput) {
        if (listType.isEmpty()) {
            return false;
        }
        for (Type type : listType) {
            if (type.getIdType().equalsIgnoreCase(idInput)) { // kiểm tra id loại
                return true;
            }
        }
        return false;
    }

    /**
     * thêm vào animal
     */
    public void add() {
        do {
            addingZoo();
            System.out.print("Do you want to add more?(Y/n) "); // y thì thì sẽ thêm sách cho đến khi người dùng nhập no
        } while (v.checkInputYN());
    }
// hàm kiểm tra id loại có rỗng hay không

    private Zoo getZoo(String idType) {
        if (listZoo.isEmpty()) {
            return null;
        }
        for (Zoo zoo : listZoo) { // vòng lặp
            if (zoo.getIdAnimal().equalsIgnoreCase(idType)) { // kiểm tra id animal
                return zoo;
            }
        }
        return null;
    }

    /**
     * viet danh sach animal vao file
     */
    public void DataFile() {
        try {
            if (!animals.exists()) {
                System.out.println("Error"); // thông báo nếu sai
            } else {
                FileWriter fw = new FileWriter(animals); // ghi file vào animal.txt
                int n = listZoo.size(); // đọc số lượng animal trong zoo
                fw.write(String.valueOf(n) + "\n");
                for (int i = 0; i < n; i++) { // vòng lặp
                    String idAnimal = listZoo.get(i).getIdAnimal();
                    String name = listZoo.get(i).getName();
                    double weight = listZoo.get(i).getWeight();
                    String idType = listZoo.get(i).getIdType();
                    fw.write(idAnimal + "\n"); // in ra các animal
                    fw.write(name + "\n");
                    fw.write(String.valueOf(weight) + "\n");
                    fw.write(idType + "\n");
                }
                fw.flush();
                fw.close();
                System.out.println("save successfully"); // thông báo thành công
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    /**
     * doc loại va animal vào
     */
    public void uploadFile() {
        readTypeFile();
        readFile();
    }

    /**
     * ghi danh sach vao file
     */
    public void saveFile() {
        DataFile();
    }

    /**
     * doc danh sach animal vao file
     */
    public void readFile() {
        if (animals.exists()) {
            Scanner sc = null;
            try {
                sc = new Scanner(animals);     // java.util.Scanner
                String idAnimal, name, weight, idType;
                listZoo = new ArrayList<>(); // tạo arraylist mới
                String num = sc.nextLine();
                int n = Integer.parseInt(num);
                for (int i = 0; i < n; i++) { // vòng lặp
                    idAnimal = sc.nextLine();
                    name = sc.nextLine();
                    weight = sc.nextLine();
                    idType = sc.nextLine();
                    listZoo.add(new Zoo(idAnimal, name, Double.parseDouble(weight), idType)); // cập nhật animal
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } finally {
                if (sc != null) { // nhập vào bằng null
                    sc.close();
                }
            }
        } else {
            System.out.println("Cannot find file exits!.");//thông báo nếu sai
            return;
        }

    }

    /**
     * them loai vao file
     */
    public void typeToFile() {
        try {
            if (!types.exists()) {
                System.err.println("Error");
            } else {
                try (ObjectOutputStream ooc = new ObjectOutputStream(new FileOutputStream(types))) {
                    ooc.writeObject(listType);// doc tu type dung de viet vao file
                    ooc.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e); // thông báo lỗi
        }
    }

    /**
     * doc type tu file
     */
    public void readTypeFile() {
        if (types.exists()) {
            Scanner sc = null;
            try {
                sc = new Scanner(types);     // java.util.Scanner
                String id, name;
                listType = new ArrayList<>(); // tạo mảng mới
                while (sc.hasNextLine()) {
                    id = sc.nextLine(); // đọc id loại tu file
                    name = sc.nextLine(); // đọc tên loại tu file
                    listType.add(new Type(id, name)); // cập nhật
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } finally {
                if (sc != null) {
                    sc.close();
                }
            }
        } else {
            System.out.println("The file not exits!"); // thông báo lỗi
            return;
        }
    }

}
