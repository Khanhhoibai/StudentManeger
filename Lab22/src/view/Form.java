package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.FormView;

import community.com.Student;
import community.com.StudentService;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.jar.Attributes.Name;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Point;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Form extends JFrame {

	private StudentService service = new StudentService();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNhapMaSinhVien;
	private JTextField textNhapLop;
	private JTextField texthienThiTen;
	private JTable table;
	private JTextField textNhapHovaTen;
	private JTextField textNhapNamSinh;
	private JTextField hienThiDiem;
	private JTextField textNhapDiem;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JRadioButton btnClass;

	private JRadioButton btnMaSinhVien;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form() {
		new StudentService();
		ActionListener actionListener = new Controller(this);
		setTitle("Student Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lí thông tin sinh viên");
		lblNewLabel.setBackground(new Color(128, 255, 255));
		lblNewLabel.setForeground(new Color(255, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblNewLabel.setBounds(161, 11, 431, 63);
		contentPane.add(lblNewLabel);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(actionListener);

		btnThem.setBounds(50, 221, 117, 23);
		contentPane.add(btnThem);

		JLabel lblMaSinhVien = new JLabel("Mã Sinh Viên");
		lblMaSinhVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaSinhVien.setBounds(31, 86, 94, 17);
		contentPane.add(lblMaSinhVien);

		textNhapMaSinhVien = new JTextField();
		textNhapMaSinhVien.setBounds(181, 85, 96, 19);
		contentPane.add(textNhapMaSinhVien);
		textNhapMaSinhVien.setColumns(10);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(actionListener);

		btnXoa.setBounds(253, 221, 117, 23);
		contentPane.add(btnXoa);

		JButton btnKiemTra = new JButton("Kiểm tra");
		btnKiemTra.addActionListener(actionListener);
		btnKiemTra.setBounds(586, 221, 117, 23);
		contentPane.add(btnKiemTra);

		textNhapLop = new JTextField();
		textNhapLop.setBounds(551, 84, 96, 19);
		contentPane.add(textNhapLop);
		textNhapLop.setColumns(10);

		JLabel lblNhapLop = new JLabel("Nhập lớp");
		lblNhapLop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNhapLop.setBounds(401, 84, 64, 17);
		contentPane.add(lblNhapLop);

		texthienThiTen = new JTextField();
		texthienThiTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		texthienThiTen.setBounds(302, 180, 167, 31);
		contentPane.add(texthienThiTen);
		texthienThiTen.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 281, 777, 206);
		contentPane.add(scrollPane);

		JLabel lblHvt = new JLabel("Họ và tên");
		lblHvt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHvt.setBounds(31, 119, 69, 17);
		contentPane.add(lblHvt);

		textNhapHovaTen = new JTextField();
		textNhapHovaTen.setBounds(181, 116, 96, 19);
		contentPane.add(textNhapHovaTen);
		textNhapHovaTen.setColumns(10);

		JLabel lblNamSinh = new JLabel("Năm sinh");
		lblNamSinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNamSinh.setBounds(401, 120, 68, 17);
		contentPane.add(lblNamSinh);

		textNhapNamSinh = new JTextField();
		textNhapNamSinh.setBounds(551, 113, 96, 19);
		contentPane.add(textNhapNamSinh);
		textNhapNamSinh.setColumns(10);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel((Object[][]) data, columnNames));
		scrollPane.setViewportView(table);

		btnMaSinhVien = new JRadioButton("Theo mã sinh viên");
		buttonGroup.add(btnMaSinhVien);
		btnMaSinhVien.setBounds(414, 222, 138, 21);
		contentPane.add(btnMaSinhVien);

		btnClass = new JRadioButton("Theo lớp chỉ định");
		buttonGroup.add(btnClass);
		btnClass.setBounds(414, 254, 138, 21);
		contentPane.add(btnClass);

		hienThiDiem = new JTextField();
		hienThiDiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		hienThiDiem.setColumns(10);
		hienThiDiem.setBounds(536, 180, 167, 31);
		contentPane.add(hienThiDiem);

		JLabel lblimTrunhBnh = new JLabel("Điểm trunh bình");
		lblimTrunhBnh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblimTrunhBnh.setBounds(401, 147, 151, 17);
		contentPane.add(lblimTrunhBnh);

		textNhapDiem = new JTextField();
		textNhapDiem.setColumns(10);
		textNhapDiem.setBounds(551, 146, 96, 19);
		contentPane.add(textNhapDiem);

		JButton btnMax = new JButton("Điểm trung bình lớn nhất");
		btnMax.addActionListener(actionListener);
		btnMax.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMax.setBounds(15, 176, 228, 35);
		contentPane.add(btnMax);

		texthienThiTen.setEnabled(false);
		hienThiDiem.setEnabled(false);

		JButton btnLuuFile = new JButton("Lưu");
		btnLuuFile.addActionListener(actionListener);
		btnLuuFile.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuuFile.setBounds(166, 508, 125, 35);
		contentPane.add(btnLuuFile);

		JButton btnMoFile = new JButton("Mở");
		btnMoFile.addActionListener(actionListener);

		btnMoFile.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMoFile.setBounds(467, 508, 125, 35);
		contentPane.add(btnMoFile);

		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(actionListener);
		btnTim.setBounds(586, 248, 117, 23);
		contentPane.add(btnTim);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private Object data = new Object[][] {};
	private String[] columnNames = new String[] { "M\u00E3 sinh vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "N\u0103m sinh",
			"T\u00EAn l\u1EDBp", "\u0110i\u1EC3m trung b\u00ECnh" };

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public void clearInput() {
		this.textNhapDiem.setText("");
		this.textNhapMaSinhVien.setText("");
		this.textNhapHovaTen.setText("");
		this.textNhapNamSinh.setText("");
		this.textNhapLop.setText("");
	}

	public void setTable(List<Student> list) {
		int size = list.size();

		Object[][] student = new Object[size][5];
		for (int i = 0; i < size; i++) {
			student[i][0] = list.get(i).getId();
			student[i][1] = list.get(i).getName();
			student[i][3] = list.get(i).getClas();
			student[i][2] = list.get(i).getAge();
			student[i][4] = list.get(i).getGpa();
		}
		table.setModel(new DefaultTableModel(student, columnNames));
	}

	public void loadTable() {
		while (true) {
			DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
			int row = modelTable.getRowCount();
			if (row == 0) {
				break;
			} else {
				try {
					modelTable.removeRow(0);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		}
		this.setTable(service.listStudent);

	}

	public void create() {
		int id = Integer.parseInt(textNhapMaSinhVien.getText());
		String name = textNhapHovaTen.getText();
		String year = textNhapNamSinh.getText();
		String nameClass = textNhapLop.getText();
		double point = Double.parseDouble(textNhapDiem.getText());
		Student student = new Student(id, name, year, nameClass, point);
		System.out.println(student);
		service.add(student);
		clearInput();
		loadTable();
	}

	public void delete() {
		if (this.btnMaSinhVien.isSelected()) {
			int id = Integer.parseInt(textNhapMaSinhVien.getText());
			service.deleteID(id);
			this.showMessage("Xoa thanh cong");
		} else if (this.btnClass.isSelected()) {
			String nameClass = textNhapLop.getText();
			boolean flag = service.deleteClass(nameClass);
			if (flag) {
				this.showMessage("Xoa thanh cong");
			} else {
				this.showMessage("Lop khong ton tai");
			}
		}
		loadTable();
	}

	public void searchId() {
		int id = Integer.parseInt(textNhapMaSinhVien.getText());
		System.out.println(id);
		service.searchId(id);
		loadTable();
	}

	public void searchPoint() {
		Student student = service.searchPoint();
		texthienThiTen.setText(student.getName());
		hienThiDiem.setText(student.getGpa() + "");
	}

	public void check() {
		try {
			int id = Integer.parseInt(textNhapMaSinhVien.getText());
			System.out.println(id);
			String nameClass = textNhapLop.getText();
			System.out.println(nameClass);
			boolean flag = service.searchIdClass( nameClass,id);
			System.out.println(flag);
			if (flag) {
				this.showMessage("Sinh viên có tồn tại");
			} else {
				this.showMessage("SInh viên không tồn tại trong lớp");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		loadTable();
	}

	private void openFile() {
		service.listStudent = service.readListStudents();
		loadTable();
	}

	private void saveFile() {
		service.writeListStudents();
	}

	public class Controller implements ActionListener {
		Form form;

		public Controller(Form form) {
			super();
			this.form = form;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			switch (button) {
			case "Thêm":
				System.out.println("Da an vao them");
				create();
				break;
			case "Tìm":
				System.out.println("Đã in ra sinh viên bạn cần tìm");
				searchId();
				break;
			case "Xóa":
				System.out.println("Da nhan xoa");
				delete();
				break;
			case "Kiểm tra":
				System.out.println("Đã kiểm tra sinh viên");
				check();
				break;
			case "Điểm trung bình lớn nhất":
				System.out.println("Đã in ra sinh viên lớn nhất");
				searchPoint();
				break;
			case "Lưu":
				System.out.println("Đã nhấn lưu");
				saveFile();
				break;
			case "Mở":
				System.out.println("Đã nhân mở");
				openFile();
				break;
			}

		}

	}
}
