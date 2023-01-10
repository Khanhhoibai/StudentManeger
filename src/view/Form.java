package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import community.com.StudentDao;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldThem;
	private JTextField textFieldKiemTra;
	private JTextField textFieldHsGioiNhat;
	private JTable table;
	/**
	 * Launch the application.
	 */
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
		new StudentDao();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 567);
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
		
		
		JButton btnNewThem = new JButton("Thêm");
		btnNewThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewThem.setBounds(50, 221, 117, 23);
		contentPane.add(btnNewThem);
		
		JLabel lblNewMsvien = new JLabel("Mã Sinh Viên");
		lblNewMsvien.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewMsvien.setBounds(239, 91, 107, 14);
		contentPane.add(lblNewMsvien);
		
		textFieldThem = new JTextField();
		textFieldThem.setBounds(459, 85, 86, 20);
		contentPane.add(textFieldThem);
		textFieldThem.setColumns(10);
		
		
		
		JButton btnNewXoa = new JButton("Xóa ");
		btnNewXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewXoa.setBounds(208, 221, 117, 23);
		contentPane.add(btnNewXoa);
		
		
		JButton btnNewXoaLop = new JButton("Xóa lớp");
		btnNewXoaLop.setBounds(351, 221, 117, 23);
		contentPane.add(btnNewXoaLop);
		
		JButton btnNewKiemTra = new JButton("Kiểm tra ");
		btnNewKiemTra.setBounds(491, 221, 117, 23);
		contentPane.add(btnNewKiemTra);
		
		textFieldKiemTra = new JTextField();
		textFieldKiemTra.setBounds(459, 130, 86, 20);
		contentPane.add(textFieldKiemTra);
		textFieldKiemTra.setColumns(10);
		
		JLabel lblNewNhapLop = new JLabel("Nhập lớp");
		lblNewNhapLop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewNhapLop.setBounds(243, 131, 92, 14);
		contentPane.add(lblNewNhapLop);
		
		JLabel lblNewDiemTb = new JLabel("Điểm trung bình lớn nhất");
		lblNewDiemTb.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewDiemTb.setBounds(195, 170, 175, 27);
		contentPane.add(lblNewDiemTb);
		
		textFieldHsGioiNhat = new JTextField();
		textFieldHsGioiNhat.setBounds(459, 175, 86, 20);
		contentPane.add(textFieldHsGioiNhat);
		textFieldHsGioiNhat.setColumns(10);
		
		JButton btnNewHsGioiNhat = new JButton("Học sinh giỏi nhất");
		btnNewHsGioiNhat.setBounds(642, 221, 117, 23);
		contentPane.add(btnNewHsGioiNhat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 255, 761, 242);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 48));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 sinh vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "N\u0103m sinh", "T\u00EAn l\u1EDBp", "\u0110i\u1EC3m trung b\u00ECnh"
			}
		));
		scrollPane.setViewportView(table);
		
		
		
	
	}
}
