package su22_01_tuandm_se150430;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.FilerException;

/**
 *
 * @author SE150430
 */
public class FileManagement {

    private String path;
    private int countFile;

    // List files with extension .java
    public List<String> getAllFileNameJavaInDirectory(String path) throws FileException {
        File pathName = new File(path); // Create an instance file
        List<String> listAllFile = new ArrayList<>(); // Create arraylist to store
        String FILE_TEXT_EXT = ".java";
        if (pathName.exists()) { // Check the path exists or not
            if (pathName.isDirectory()) { // Check if the path is a directory or not
                String[] list = pathName.list(new FilenameFilter() { // communicate with FilenameFilter interface
                    @Override
                    public boolean accept(File dir, String name) { // Overide phương thức appect có trong interface FilenameFilter
                        return name.endsWith(FILE_TEXT_EXT); // Kiểm tra tham số có kết thúc phần đuôi có .java hay không 
                    }                                        // Rồi sau đó, thêm vào mảng có tên là list   
                }
                );
                if (list.length == 0) {  // kiểm tra độ dài của list để biết rằng trong thư mục có chứa file .java
                    System.out.println("There is no file ending in .java");
                } else {
                    for (int i = 0; i < list.length; i++) {
                        listAllFile.add(list[i]);
                    }
                }
            } else { // Bắt ngoại lệ khi đường dẫn là một tệp tin
                throw new FileException("The path does not exist");
            }
        } else {
            throw new FileException("The path does not exist");
        }
        return listAllFile; // Return a list
    }

    public FileManagement(String path) throws FileException {
        this.setPath(path);
    }

    public boolean appendContentToFile(String path, String contentInput) throws IOException, FileException {
        File pathFile = new File(path); // Create an instance file
        if (!pathFile.exists()) { // Check the path exists or not
            throw new FileException("Invalid path");
        } else {
            if (!pathFile.isFile()) {  // Check if the path is a directory or not
                throw new FileException("Invalid path");
            } else {
                // Do là thêm nội dung nên đường dẫn hợp lệ khi là tệp tin
                FileWriter fw = new FileWriter(pathFile); // Lớp dùng để ghi file và văn bản
                BufferedWriter bw = new BufferedWriter(fw); //  cung cấp việc ghi dữ liệu hiệu quả với các mảng đơn, các ký tự và chuỗi.
                bw.write(contentInput); // Viết vào thư mục
                bw.close(); // đóng tập tin
                return true;
            }
        }
    }

    // get method to get value
    public String getPath() {
        return path;
    }

    // Set method to assign value
    public void setPath(String path) throws FileException {
        // Check if the user-entered path is empty or not
        if (path.equals("")) {
            throw new FileException("The file cannot be empty!");
        } else {
            this.path = path;
        }
    }

    public int countCharacter(String path) throws IOException, FileException {
        File pathFile = new File(path); // Tạo một instance file
        int count = 0; // Biến dùng để điếm từ
        if (!pathFile.exists()) { // Kiểm tra đường dẫn có tồn tại hay  không
            throw new FileException("Invalid path");
        } else {
            if (!pathFile.isFile()) {  // Kiểm tra đường dẫn có phải là thư mục hay không
                throw new FileException("Invalid path");
            } else {
                BufferedReader br = new BufferedReader(new FileReader(pathFile));
                try {
                    String str = br.readLine();
                    String[] arrChar = str.split("[ ,.]"); // Dùng để cắt một chuổi thành mảng. 
                    for (String string : arrChar) { // Nó Cắt luôn cái khoảng trắng thành các phần tử của mảng
                        if (!string.equals("")) { // Kiểm tra xem phần tử trong mảng có phải là rỗng ( khoảng trắng )
                            count++;
                        }
                    }
                } finally {
                    br.close(); // Đóng file
                }
            }
        }
        return count;
    }

// Check if the path is valid or not
    public void checkInputPath(String path) throws FileException {
        File pathName = new File(path);
        // check the path exists or not
        if (pathName.exists()) {
            if (pathName.isDirectory()) { // check if the path is a directory or not
                System.out.println("Path to folder");
            } else { // Since the path is correct, there are only 2 cases 1 is a directory 2 is a file
                System.out.println("The path to the file");
            }
        } else {
            throw new FileException("The path does not exist");
        }
    }

}
