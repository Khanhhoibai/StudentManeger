package community.com;

import java.util.Scanner;

/**
 * Main class
 * 
 * @author viettuts.vn
 */
public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static StudentService service = new StudentService();

	public static void main(String[] args) {
		while (true) {
			System.out.println("-----------menu------------");
			System.out.println("1. Thêm sinh viên.");
			System.out.println("2. Tìm sinh viên");
			System.out.println("3. Xóa sinh viên");
			System.out.println("4. Kiểm tra sinh viên");
			System.out.println("5. Hiển thị danh sách");
			System.out.println("6. Lưu danh sách sinh viên.");
			System.out.println("7. In danh sách sinh viên.");
			System.out.println("0. exit.");
			System.out.println("---------------------------");
			int choise = getChoise(0, 7);
			switch (choise) {
			case 1:
				create();
				break;
			case 2:
				search();
				break;
			case 3:
				delete();
				break;
			case 4:
				check();
				break;
			case 5:
				display();
				break;
			case 6:
				saveFile();
				break;
			case 7:
				openFile();
				break;
			case 0:
				System.exit(0);
			}
		}
	}

	private static void display() {
		for (int i = 0; i < service.listStudent.size(); i++) {
			System.out.println(service.listStudent);
		}
	}

	private static void create() {
		System.out.print("Nhập mã sinh viên: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("Nhập họ và tên: ");
		String nameStudent = scanner.nextLine();
		System.out.print("Nhập ngày sinh: ");
		String age = scanner.nextLine();
		System.out.print("Nhập tên lớp: ");
		String nameClass = scanner.nextLine();
		System.out.print("Nhập điểm trung bình: ");
		double point = Double.parseDouble(scanner.nextLine());
		Student student = new Student(id, nameStudent, nameClass, age, point);
		service.add(student);
	}

	private static void search() {
		System.out.println("1. Tìm theo mã sinh viên." + "\n2. Tìm sinh viên có điểm cao nhất.");
		int choise = getChoise(1, 2);
		switch (choise) {
		case 1:
			searchID();
			break;
		case 2:
			searhMax();
			break;
		}

	}

	private static void searchID() {
		System.out.print("Nhập mã sinh viên cần tìm: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println(service.searchId(id));
	}

	private static void searhMax() {
		Student student = service.searchPoint();
		System.out.println("Sinh viên " + student.getName() + " có điểm cao nhất là: " + student.getGpa());
	}

	private static void delete() {
		System.out.println("1. Xóa theo mã sinh viên." + "\n2. Xóa theo lớp.");
		int choise = getChoise(1, 2);
		switch (choise) {
		case 1:
			deleteID();
			break;
		case 2:
			deleteClass();
			break;
		}
	}

	private static void deleteID() {
		System.out.print("Nhập mã sinh viên cần xóa: ");
		int id = Integer.parseInt(scanner.nextLine());
		service.deleteID(id);
	}

	private static void deleteClass() {
		System.out.print("Nhập tên lớp cần xóa: ");
		String nameClass = scanner.nextLine();
		boolean flag = service.deleteClass(nameClass);
		if (flag) {
			System.out.println("Xóa thành công");
		} else {
			System.out.println("Không tìm thấy lớp chỉ định");
		}
	}

	private static void check() {
		System.out.print("Nhập mã sinh viên và lớp cần kiểm tra: ");
		int id = Integer.parseInt(scanner.nextLine());
		String nameClass = scanner.nextLine();
		boolean flag = service.searchIdClass(nameClass, id);
		if (flag) {
			System.out.println("Sinh viên có trong lớp");
		}else {
			System.out.println("Sinh viên không tồn tại");
		}
		
	

	}

	private static int getChoise(int from, int end) {
		int choise;
		do {
			System.out.print("Nhập lựa chọn: ");
			choise = Integer.parseInt(scanner.nextLine());
		} while (choise < from || choise > end);
		return choise;
	}

	private static void openFile() {
			service.listStudent = service.readListStudents();
	}

	private static void saveFile() {
		service.writeListStudents();
	}
}