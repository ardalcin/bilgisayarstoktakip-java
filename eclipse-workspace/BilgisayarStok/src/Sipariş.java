import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Image;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Sipariþ extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JFrame frame;
	private JTable table;
	Connection connection =null;
	private JTable table_1;
	private JTextField textField;
	private JButton btnk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sipariþ frame = new Sipariþ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void refreshTable ()
	{
		
		try {
			String query="select name,surname,username,islemci,ram,hdd,ekrankartý,anakart from uyeler ";
			PreparedStatement pst= connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Sipariþ() {
		frame=new JFrame();
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 420);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(new Color(51, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 60, 452, 300);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
			
			
			
			
		});
		scrollPane_1.setViewportView(table);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				try {
					
					
					String query="select * from uyeler where username=?";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.setString(1, textField.getText());
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
			
					
					
					pst.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
			}
		});
		textField.setBounds(195, 28, 155, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblKullancAdnGiriniz = new JLabel("Kullan\u0131c\u0131 Ad\u0131n\u0131 giriniz");
		lblKullancAdnGiriniz.setForeground(Color.LIGHT_GRAY);
		lblKullancAdnGiriniz.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblKullancAdnGiriniz.setBackground(new Color(51, 0, 0));
		lblKullancAdnGiriniz.setBounds(27, 27, 136, 20);
		contentPane.add(lblKullancAdnGiriniz);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(480, 11, 157, 133);
		contentPane.add(lblNewLabel);
		Image img1= new ImageIcon(this.getClass().getResource("/sep.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		
		btnk = new JButton("\u00C7\u0131k\u0131\u015F");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login window=new Login();
				window.frame.setVisible(true);
				
			}
		});
		btnk.setForeground(Color.LIGHT_GRAY);
		btnk.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnk.setBackground(new Color(51, 0, 0));
		btnk.setBounds(490, 337, 134, 23);
		contentPane.add(btnk);
		
	}
}
