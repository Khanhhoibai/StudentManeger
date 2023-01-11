package community.com;

import java.io.*;
import java.util.*;
import community.com.*;


/**
 * StudentDao class
 * 
 * @author viettuts.vn
 */
@SuppressWarnings("unused")
public class StudentService {

	public List<Student> listStudent = new ArrayList<>();

	// viết ra file txt
	public void writeListStudents() {
		try {
			FileUtils.write(listStudent);
			System.out.println("Lưu file thành công");
		} catch (Exception e) {
			System.out.println("File khong ton tai");
			e.printStackTrace();
		}
	}

	//đọc file từ txt
	public List<Student> readListStudents() {
		List<Student> list = null;
		try {
			list = FileUtils.read();
			System.out.println("Mở file thành công");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("File không tồn tại");
		}
		return list;
	}

	// Them sinh vien
	public void add(Student student) {
		listStudent.add(student);
	}

	// Xoa sinh vien dua ma Id
	public void deleteID(int id) {
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getId() == id) {
				listStudent.remove(i);
				System.out.println("Xóa thành công");
				return;
			}
		}
		System.out.println("Sinh viên không tồn tại");
	}
	// xoa danh sach theo ten lop
		public boolean deleteClass(String nameClass) {
			List<Student> toRemove = new ArrayList<>();
			for (Student student : listStudent) {
				if (student.getClas().equals(nameClass)) {
					toRemove.add(student);
				}
			}
			if (!toRemove.isEmpty()) {
				listStudent.removeAll(toRemove);
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
		Collections.sort(listStudent);
		if (listStudent.size() == 1) {
			student = listStudent.get(0);
		} else {
			for (int i = listStudent.size() - 1; i >= 0; i--) {
				if (listStudent.get(i).getGpa() > listStudent.get(i - 1).getGpa()) {
					student = listStudent.get(i);
					break;
				}
			}
		}
		return student;
	}

	

	public List<Student> getListStudents() {
		return getListStudents();
	}

	public void setListStudents(List<Student> listStudents) {
		this.listStudent = listStudents;
	}
}