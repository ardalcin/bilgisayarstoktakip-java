import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import java.awt.Color;

public class kayit extends JFrame {

	private JPanel contentPane;
	private JTextField textad;
	private JTextField textsoy;
	private JTextField textkadi;
	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kayit frame = new kayit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection =null;
	private JPasswordField textsifre;
	private JButton btnNewButton;
	/**
	 * Create the frame.
	 */
	public kayit() {
		frame = new JFrame();
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 0));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdnz = new JLabel("Ad\u0131n\u0131z:");
		lblAdnz.setBackground(new Color(51, 0, 0));
		lblAdnz.setForeground(Color.LIGHT_GRAY);
		lblAdnz.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAdnz.setBounds(10, 23, 46, 14);
		contentPane.add(lblAdnz);
		
		JLabel lblSoyadnz = new JLabel("Soyad\u0131n\u0131z:");
		lblSoyadnz.setBackground(new Color(51, 0, 0));
		lblSoyadnz.setForeground(Color.LIGHT_GRAY);
		lblSoyadnz.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSoyadnz.setBounds(10, 54, 86, 14);
		contentPane.add(lblSoyadnz);
		
		JLabel lblKullancAdnz = new JLabel("Kullan\u0131c\u0131 Ad\u0131n\u0131z:");
		lblKullancAdnz.setBackground(new Color(51, 0, 0));
		lblKullancAdnz.setForeground(Color.LIGHT_GRAY);
		lblKullancAdnz.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblKullancAdnz.setBounds(10, 90, 104, 14);
		contentPane.add(lblKullancAdnz);
		
		JLabel lblifre = new JLabel("\u015Eifre:");
		lblifre.setBackground(new Color(51, 0, 0));
		lblifre.setForeground(Color.LIGHT_GRAY);
		lblifre.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblifre.setBounds(10, 115, 86, 14);
		contentPane.add(lblifre);
		
		textad = new JTextField();
		textad.setBounds(131, 21, 146, 20);
		contentPane.add(textad);
		textad.setColumns(10);
		
		textsoy = new JTextField();
		textsoy.setBounds(131, 52, 146, 20);
		contentPane.add(textsoy);
		textsoy.setColumns(10);
		
		textkadi = new JTextField();
		textkadi.setBounds(131, 82, 146, 20);
		contentPane.add(textkadi);
		textkadi.setColumns(10);
		
		
		textsifre = new JPasswordField();
		textsifre.setBounds(131, 113, 146, 20);
		contentPane.add(textsifre);
		
		btnNewButton = new JButton("Geri");
		btnNewButton.setBackground(new Color(51, 0, 0));
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login window=new Login();
				window.frame.setVisible(true);
				
				
				
			}
		});
		btnNewButton.setBounds(25, 155, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblreg = new JLabel("New label");
		lblreg.setBounds(304, 23, 130, 155);
		contentPane.add(lblreg);
		Image img1= new ImageIcon(this.getClass().getResource("/reg.png")).getImage();
		lblreg.setIcon(new ImageIcon(img1));
		
		JLabel lblog = new JLabel("");
		lblog.setBounds(42, 205, 365, 152);
		contentPane.add(lblog);
		Image img= new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblog.setIcon(new ImageIcon(img));
		
		JButton kayýttamam = new JButton("Kay\u0131t Ol");
		kayýttamam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String query="insert into uyeler(username,password,name,surname) values(?,?,?,?)";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.setString(1,textkadi.getText());
					pst.setString(2,textsifre.getText());
					pst.setString(3,textad.getText());
					pst.setString(4,textsoy.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null,"Kayýt Eklendi");
					pst.close();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				
				Login window=new Login();
				window.frame.setVisible(true);
					
			}
		});
		kayýttamam.setForeground(Color.LIGHT_GRAY);
		kayýttamam.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		kayýttamam.setBackground(new Color(51, 0, 0));
		kayýttamam.setBounds(130, 155, 89, 23);
		contentPane.add(kayýttamam);
	}
}
