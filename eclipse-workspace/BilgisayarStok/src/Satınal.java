import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Satýnal extends JFrame {
	private JFrame frame;
	Connection connection =null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Satýnal frame = new Satýnal();
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
	public Satýnal() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 409);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(new Color(51, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ad");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBackground(new Color(51, 0, 0));
		lblNewLabel.setBounds(46, 21, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Soyad");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBackground(new Color(51, 0, 0));
		lblNewLabel_1.setBounds(46, 46, 90, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBackground(new Color(51, 0, 0));
		lblNewLabel_2.setBounds(46, 71, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Adres");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBackground(new Color(51, 0, 0));
		lblNewLabel_3.setBounds(46, 96, 90, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefon");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setBackground(new Color(51, 0, 0));
		lblNewLabel_4.setBounds(46, 121, 90, 14);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setBackground(Color.WHITE);
		textField.setBounds(133, 21, 170, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(133, 46, 170, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(133, 71, 170, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(133, 96, 170, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_4.setForeground(Color.LIGHT_GRAY);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(133, 121, 170, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(135, 194, 365, 152);
		contentPane.add(lblNewLabel_5);
		Image img= new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(51, 0, 0));
		Image img1= new ImageIcon(this.getClass().getResource("/sal.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					String query="insert into satýnal(Ad,Soyad,Email,Adres,Telefon,kk,cvv) values(?,?,?,?,?,?,?)";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textField_2.getText());
					pst.setString(4,textField_3.getText());
					pst.setString(5,textField_4.getText());
					pst.setString(6,textField_5.getText());
					pst.setString(7,textField_6.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null,"Satýn Alma Ýþleminiz Tamamlanmýþtýr.");
					pst.close();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(442, 145, 115, 32);
		contentPane.add(btnNewButton);
		
		JButton btnAlveri = new JButton("Al\u0131\u015Fveri\u015Fe devam et >>");
		btnAlveri.setForeground(Color.LIGHT_GRAY);
		btnAlveri.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnAlveri.setBackground(new Color(51, 0, 0));
		btnAlveri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Kullanýcý alsv=new 	Kullanýcý();
				alsv.setVisible(true);
			}
		});
		btnAlveri.setBounds(130, 147, 176, 30);
		contentPane.add(btnAlveri);
		
		textField_5 = new JTextField();
		textField_5.setBounds(442, 19, 155, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(442, 44, 155, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Kredi Kart\u0131");
		lblNewLabel_6.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_6.setBackground(new Color(51, 0, 0));
		lblNewLabel_6.setBounds(363, 22, 80, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("CVV");
		lblNewLabel_7.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_7.setBackground(new Color(51, 0, 0));
		lblNewLabel_7.setBounds(363, 47, 80, 14);
		contentPane.add(lblNewLabel_7);
	}
}
