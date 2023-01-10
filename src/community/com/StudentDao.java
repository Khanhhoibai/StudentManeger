package community.com;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import community.com.FileUtils;
import community.com.Student;
import community.com.StudentXML;

/**
* StudentDao class
* 
* @author viettuts.vn
*/
public class StudentDao {
    private static final String STUDENT_FILE_NAME = "student.xml";
    private List<Student> listStudent;
 
    public StudentDao() {
        this.listStudent = readListStudents();
        if (listStudent == null) {
            listStudent = new ArrayList<Student>();
        }
    }
 
    /**
     * Lưu các đối tượng student vào file student.xml
     * 
     * @param students
     */
    public void writeListStudents(List<Student> students) {
        StudentXML studentXML = new StudentXML();
        studentXML.setStudent(students);
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, studentXML);
    }
 
    /**
     * Đọc các đối tượng student từ file student.xml
     * 
     * @return list student
     */
    public List<Student> readListStudents() {
        List<Student> list = new ArrayList<Student>();
        StudentXML studentXML = (StudentXML) FileUtils.readXMLFile(
                STUDENT_FILE_NAME, StudentXML.class);
        if (studentXML != null) {
            list = studentXML.getStudent();
        }
        return list;
    }
     
 
   //Them sinh vien
    public void add(Student student) {
        int id = 1;
        if (listStudent != null && listStudent.size() > 0) {
            id = listStudent.size() + 1;
        }
        student.setId(id);
        listStudent.add(student);
        writeListStudents(listStudent);
    }
 
    //Xoa sinh vien dua ma Id
    public boolean delete(Student student) {
        boolean isFound = false;
        int size = listStudent.size();
        for (int i = 0; i < size; i++) {
            if (listStudent.get(i).getId() == student.getId()) {
                student = listStudent.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listStudent.remove(student);
            writeListStudents(listStudent);
            return true;
        }
        return false;
    }
 // Tim kiem sinh vien theo ma sinh vien
    public Student searchId(int id) {
        Student student = new Student();
        for (Student value : listStudent) {
            if (value.getId() == id) {
                student = value;
            }
        }
        return student;
    }
  
 // kiểm tra sinh viên có tồn tại vs class và id cho sẵn không
    public boolean searchIdClass(String clas, int idSearch) {
        for (Student student : listStudent) {
            if (student.getClas().trim().equals(clas) && student.getId() == idSearch) {
                return true;
            }
        }
        return false;
    }
    
    // tìm sinh viên có điểm cao nhất đầu tiên
    public Student searchPoint() {
        Student student = new Student();
        Collections.sort((List<T>) listStudent);
        if (listStudent.size() == 1) {
            student =listStudent.get(0);
        } else {
            for (int i = listStudent.size() - 1; i >= 0; i--) {
                if (listStudent.get(i).getGpa() >listStudent.get(i - 1).getGpa()) {
                    student = listStudent.get(i);
                    break;
                }
            }
        }
        return student;
    }
    // xoa danh sach theo ten lop
    public boolean deleteStudent(String nameClass) {
        List<Student> toRemove = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getClas().trim().equals(nameClass)) {
                toRemove.add(student);
            }
        }
        if (!toRemove.isEmpty()) {
        	listStudent.removeAll(toRemove);
            return true;
        }
        return false;
    }
    
  
 
   
 
   
 
    public List<Student> getListStudents() {
        return getListStudents();
    }
 
    public void setListStudents(List<Student> listStudents) {
        this.listStudent = listStudents;
    }
}