package community.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	private static final String STUDENT_FILE_NAME = "student.txt";
	private static StudentService service = new StudentService();
	public static void write(List<Student> studentList) {
		try {
			PrintStream prs = new PrintStream(new FileOutputStream(STUDENT_FILE_NAME));
			for (Student student : studentList) {
				prs.println(student.getInform());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static List<Student> read() {
		List<Student> students = new ArrayList<>();
		File file = new File(STUDENT_FILE_NAME);
		if (file.exists()) {
			System.out.println("File ton tai");
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = "";
				String[] array = null;
				while ((line = br.readLine()) != null) {
					array = line.split(",");
					Student student = new Student(Integer.parseInt(array[0]), array[1], array[2], array[3], Double.parseDouble(array[4]));
					students.add(student);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File khong ton tai");
		}
		return students;
	}
//
//	public static void write(List<Student> studentList) {
//		FileOutputStream fos = null;
//		ObjectOutputStream oos = null;
//		try {
//			fos = new FileOutputStream(new File(STUDENT_FILE_NAME));
//			oos = new ObjectOutputStream(fos);
//			oos.writeObject(studentList);
//			oos.close();
//			fos.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static List<Student> read() {
//		List<Student> studentList = new ArrayList<>();
//		FileInputStream fis = null;
//		ObjectInputStream ois = null;
//		try {
//			fis = new FileInputStream(new File(STUDENT_FILE_NAME));
//			ois = new ObjectInputStream(fis);
//			studentList = (List<Student>) ois.readObject();
//			ois.close();
//			fis.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return studentList;
//	}
}