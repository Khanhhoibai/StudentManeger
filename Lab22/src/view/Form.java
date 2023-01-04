package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;

public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Them");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(289, 23, 117, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Ma sinh vien");
		lblNewLabel.setBounds(10, 27, 107, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(147, 24, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Xóa ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(289, 66, 117, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa lớp");
		btnNewButton_2.setBounds(289, 110, 117, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Kiểm tra ");
		btnNewButton_3.setBounds(289, 155, 117, 23);
		contentPane.add(btnNewButton_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 69, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập mã sinh viên");
		lblNewLabel_1.setBounds(10, 75, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(147, 113, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập mã sinh viên");
		lblNewLabel_2.setBounds(10, 114, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(147, 158, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nhập lớp");
		lblNewLabel_3.setBounds(10, 159, 92, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Điểm trung bình lớn nhất");
		lblNewLabel_4.setBounds(10, 205, 117, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(147, 202, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Học sinh giỏi nhất");
		btnNewButton_4.setBounds(289, 199, 117, 23);
		contentPane.add(btnNewButton_4);
		
		table = new JTable();
		table.setBounds(40, 250, 712, 252);
		contentPane.add(table);
	}
}
