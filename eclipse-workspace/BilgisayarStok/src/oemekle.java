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

public class oemekle extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JFrame frame;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					oemekle frame = new oemekle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection =null;
	private JTable table_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
	public void refreshTable ()
	{
		
		try {
			String query="select islemci,Ram,Ekrankartý,Harddisk,Anakart from Oem ";
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
	public oemekle() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 453);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(new Color(51, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setBackground(Color.WHITE);
		textField.setBounds(112, 11, 114, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(112, 42, 114, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(112, 73, 114, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(112, 104, 114, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_4.setForeground(Color.LIGHT_GRAY);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(112, 135, 114, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("i\u015Flemci");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBackground(new Color(51, 0, 0));
		lblNewLabel.setBounds(21, 14, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ram");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBackground(new Color(51, 0, 0));
		lblNewLabel_1.setBounds(21, 45, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ekran kart\u0131");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBackground(new Color(51, 0, 0));
		lblNewLabel_2.setBounds(21, 76, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("hard disk");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBackground(new Color(51, 0, 0));
		lblNewLabel_3.setBounds(21, 107, 81, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("anakart");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setBackground(new Color(51, 0, 0));
		lblNewLabel_4.setBounds(21, 138, 81, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.setForeground(Color.LIGHT_GRAY);
		btnEkle.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnEkle.setBackground(new Color(51, 0, 0));
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query="insert into Oem(islemci,Ram,Ekrankartý,Harddisk,Anakart,adetislem,adetram,adetekran,adethdd,adetana) values(?,?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement pst= connection.prepareStatement(query);
					
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textField_2.getText());
					pst.setString(4,textField_3.getText());
					pst.setString(5,textField_4.getText());
					pst.setString(6,textField_5.getText());
					pst.setString(7,textField_6.getText());
					pst.setString(8,textField_7.getText());
					pst.setString(9,textField_8.getText());
					pst.setString(10,textField_9.getText());
					
					
					
					
					
					pst.execute();
					
					
					JOptionPane.showMessageDialog(null,"Kayýt Eklendi");
					
					
					pst.close();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				refreshTable ();
				
				
			}
		});
		btnEkle.setBounds(21, 166, 89, 23);
		contentPane.add(btnEkle);
		
		JButton btnNewButton = new JButton("sil");
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(51, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="delete from Oem where Anakart='"+textField_4.getText()+"'	";
					PreparedStatement pst= connection.prepareStatement(query);
					
						pst.execute();
					JOptionPane.showMessageDialog(null,"Kayýt Silindi");
					pst.close();

					} catch (Exception e2) {
					e2.printStackTrace();
					}
				refreshTable ();
				
			} 
		});
		btnNewButton.setBounds(135, 166, 89, 23);
		contentPane.add(btnNewButton); 
		
		JButton btnNewButton_1 = new JButton("Listele");
		btnNewButton_1.setForeground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(51, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="select * from Oem ";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(237, 166, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 208, 761, 174);
		contentPane.add(scrollPane_1);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row =table.getSelectedRow();
					String EÝ_=(table.getModel().getValueAt(row,  0)).toString();
					
					String query="select * from Oem where islemci='"+EÝ_+"'";
					PreparedStatement pst= connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						
						textField.setText(rs.getString("islemci"));
						textField_1.setText(rs.getString("Ram"));
						textField_2.setText(rs.getString("Ekrankartý"));
						textField_3.setText(rs.getString("Harddisk"));
						textField_4.setText(rs.getString("Anakart"));
						textField_5.setText(rs.getString("adetislem"));
						textField_6.setText(rs.getString("adetram"));
						textField_7.setText(rs.getString("adetekran"));
						textField_8.setText(rs.getString("adethdd"));
						textField_9.setText(rs.getString("adetana"));
						
						
					}
					pst.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			
			
			
		});
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(310, 31, 467, 100);
		contentPane.add(lblNewLabel_5);
		Image img= new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img));
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.LIGHT_GRAY);
		textField_5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(303, 11, 46, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setForeground(Color.LIGHT_GRAY);
		textField_6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_6.setColumns(10);
		textField_6.setBackground(Color.WHITE);
		textField_6.setBounds(304, 42, 45, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setForeground(Color.LIGHT_GRAY);
		textField_7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_7.setColumns(10);
		textField_7.setBackground(Color.WHITE);
		textField_7.setBounds(303, 73, 46, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setForeground(Color.LIGHT_GRAY);
		textField_8.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_8.setColumns(10);
		textField_8.setBackground(Color.WHITE);
		textField_8.setBounds(304, 104, 45, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setForeground(Color.LIGHT_GRAY);
		textField_9.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_9.setColumns(10);
		textField_9.setBackground(Color.WHITE);
		textField_9.setBounds(304, 135, 45, 20);
		contentPane.add(textField_9);
		
		JLabel lblAdet = new JLabel("Adet");
		lblAdet.setForeground(Color.LIGHT_GRAY);
		lblAdet.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAdet.setBackground(new Color(51, 0, 0));
		lblAdet.setBounds(256, 13, 55, 14);
		contentPane.add(lblAdet);
		
		JLabel label = new JLabel("Adet");
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label.setBackground(new Color(51, 0, 0));
		label.setBounds(256, 45, 55, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Adet");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label_1.setBackground(new Color(51, 0, 0));
		label_1.setBounds(256, 76, 55, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Adet");
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label_2.setBackground(new Color(51, 0, 0));
		label_2.setBounds(256, 106, 55, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Adet");
		label_3.setForeground(Color.LIGHT_GRAY);
		label_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label_3.setBackground(new Color(51, 0, 0));
		label_3.setBounds(256, 138, 55, 14);
		contentPane.add(label_3);
		
	}
}
