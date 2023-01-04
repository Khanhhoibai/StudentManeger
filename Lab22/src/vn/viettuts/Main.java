package vn.viettuts;
 
import java.util.Scanner;
 
/**
 * Main class
 * 
 * @author viettuts.vn
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);
 
    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        StudentManager studentManager = new StudentManager();
        int studentId;
        // show menu
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
            case "1":
            	//thêm sinh viên
                studentManager.add();
                break;
            case "2":
            	// xoa sinh vien theo ma sinh vien
            	studentId = studentManager.inputId();
                studentManager.delete(studentId);
                studentManager.show();
                break;
            
               
			case "3":
				// in ra danh sach sinh vien
            	studentManager.show();
            	break;
               
             
            case "4":
            	//kiểm tra sinh viên có tồn tại vs class và id cho sẵn không
            	
            	
                break;
           
            case "6":
            	// tìm sinh viên có điểm cao nhất đầu tiên
            	
                break;
            case "7":
            	// xoa danh sach lop dua vao ten lop
            	
            	break;
               
            case "0":
                System.out.println("exited!");
                exit = true;
                break;
            default:
                System.out.println("invalid! please choose action in below menu:");
                break;
            }
            if (exit) {
                break;
            }
            // show menu
            showMenu();
        }
    }
 
    /**
     * create menu
     */
    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Add student.");
        System.out.println("2. Edit student by id.");
        System.out.println("3. Delete student by id.");
        System.out.println("4. Sort student by gpa.");
        System.out.println("5. Sort student by name.");
        System.out.println("6. Show student.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
}