package community.com;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {
	 
    /**
     * Chuyển đổi đối tượng object về định dạng XML
     * Sau đo lưu vào fileName
     * 
     * @param fileName
     * @param object
     */
    public static void writeXMLtoFile(String fileName,  List<Student> studentList) {
    	 try {
             File file = new File(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
             for (Student student :
                     studentList) {
                 bufferedWriter.write(student.getInfo());
                 bufferedWriter.newLine();
             }
             bufferedWriter.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
    public static List<Student> readFile(String path) {
    	List<Student> studentList = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            @SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            @SuppressWarnings("unused")
			String[] array;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Student student = new Student();
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
}