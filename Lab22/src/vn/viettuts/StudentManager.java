package vn.viettuts;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
/**
 * StudentManager class
 * 
 * @author viettuts.vn
 */
public class StudentManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Student> studentList;
    private StudentDao studentDao;
     
      
    public StudentManager() {
        studentDao = new StudentDao();
        studentList = studentDao.read();
    }
//    thêm sinh viên
   
    public void add() {
    	int id =inputId();
        String name = inputName();
        String clas = inputClas();
        int age = inputAge();
        double gpa = inputGpa();
        Student student = new Student(id,name,clas,age,gpa);
        studentList.add(student);
        studentDao.write(studentList);
    }
 // Tim kiem sinh vien theo ma sinh vien
    public Student searchId(int id) {
        Student student = new Student();
        for (Student value : studentList) {
            if (value.getId() == id) {
                student = value;
            }
        }
        return student;
    }
  
 // kiểm tra sinh viên có tồn tại vs class và id cho sẵn không
    public boolean searchIdClass(String className, int idSearch) {
        for (Student student : studentList) {
            if (student.getClas().trim().equals(className) && student.getId() == idSearch) {
                return true;
            }
        }
        return false;
    }
    
    // tìm sinh viên có điểm cao nhất đầu tiên
    public Student searchPoint() {
        Student student = new Student();
        Collections.sort(studentList);
        if (studentList.size() == 1) {
            student = studentList.get(0);
        } else {
            for (int i = studentList.size() - 1; i >= 0; i--) {
                if (studentList.get(i).getGpa() > studentList.get(i - 1).getGpa()) {
                    student = studentList.get(i);
                    break;
                }
            }
        }
        return student;
    }
    // xoa danh sach theo ten lop
    public boolean deleteStudent(String nameClass) {
        List<Student> toRemove = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getClas().trim().equals(nameClass)) {
                toRemove.add(student);
            }
        }
        if (!toRemove.isEmpty()) {
            studentList.removeAll(toRemove);
            return true;
        }
        return false;
    }
    
    // xóa tên sinh viên theo mã sinh viên
    public void delete(int id) {
        Student student = null;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                student = studentList.get(i);
                break;
            }
        }
        if (student != null) {
            studentList.remove(student);
            studentDao.write(studentList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    
            
        
    }
   
    // in danh sach
    public void show() {
        for (Student student : studentList) {
            System.out.format("%5d | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%20s | ", student.getClas());
            System.out.format("%5d | ", student.getAge());
            System.out.format("%10.1f%n", student.getGpa());
        }
    }
 
 
  
   
 
   
    int inputId() {
        System.out.println("Nhap ma sinh vien: ");
        return Integer.parseInt(scanner.nextLine()) ;
    }
     
    
    private String inputName() {
        System.out.println("Nhap ho va ten: ");
        return scanner.nextLine();
    }
 
    private String inputClas() {
        System.out.println("Nhap lop hoc: ");
        return scanner.nextLine();
    }
 
    
    private int inputAge() {
    	System.out.println("Nhap nam sinh: ");
       return Integer.parseInt(scanner.nextLine()) ;
    }
 
    private float inputGpa() {
        System.out.println("Input student gpa: ");
       return Float.parseFloat(scanner.nextLine());
    }
 
    // getter && setter
    public List<Student> getStudentList() {
        return studentList;
    }
 
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}