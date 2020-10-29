import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Kullanýcý extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxName;
private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kullanýcý frame = new Kullanýcý();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField textField;
	private JTextField textField_1;
        public void fillComboBox()
        {
        	
        	try {
        			String query="select * from bilgisayar";
        			PreparedStatement pst= connection.prepareStatement(query);
        			ResultSet rs=pst.executeQuery();
        			
        			
        				while(rs.next()	)
        				{
        							
        							comboBoxName.addItem(rs.getString("model"));		
        				}
        					
        		
        		
			} catch (Exception e) {
				e.printStackTrace();
			
			
			
			
			
			}
        	
        }
	/**
	 * Create the frame.
	 */
	public Kullanýcý() {
		frame=new JFrame();
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(new Color(51, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxName = new JComboBox();
		comboBoxName.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBoxName.setForeground(Color.LIGHT_GRAY);
		comboBoxName.setBackground(new Color(51, 0, 0));
		comboBoxName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					try {
					
					
					String query="select * from bilgisayar where model=?";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.setString(1, 	(String)comboBoxName.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						
						textField.setText(rs.getString("fiyat"));
						
						
					}
					pst.close();

					} catch (Exception e2) {
					e2.printStackTrace();
					}
			
				
				
			}
		});
		comboBoxName.setBounds(136, 43, 151, 26);
		contentPane.add(comboBoxName);
		
		JLabel lblModelSeiniz = new JLabel("Model Se\u00E7iniz:");
		lblModelSeiniz.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblModelSeiniz.setForeground(Color.LIGHT_GRAY);
		lblModelSeiniz.setBackground(new Color(51, 0, 0));
		lblModelSeiniz.setBounds(10, 46, 97, 20);
		contentPane.add(lblModelSeiniz);
		
		JLabel lblFiyat = new JLabel("Fiyat");
		lblFiyat.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblFiyat.setForeground(Color.LIGHT_GRAY);
		lblFiyat.setBackground(new Color(51, 0, 0));
		lblFiyat.setBounds(297, 49, 46, 14);
		contentPane.add(lblFiyat);
		
		textField = new JTextField();
		textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setBounds(342, 46, 62, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Toplama Sihirbaz\u0131");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Oem Top=new Oem();
				Top.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(51, 0, 0));
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton.setBounds(10, 224, 160, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sat\u0131n Al");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="update uyeler set  hazýrpc='"+comboBoxName.getSelectedItem()+"' where username='"+textField_1.getText()+"' ";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.execute();
					
					String querry="UPDATE bilgisayar SET ürünsayýsý=ürünsayýsý-1 WHERE model='"+comboBoxName.getSelectedItem()+ "'   ";
					PreparedStatement ppppsstt= connection.prepareStatement(querry);
					ppppsstt.execute();	
				
					
					/*
					String query="insert into uyeler(islemci,ram,ekrankartý,anakart,hdd) values(?,?,?,?,?)";
					PreparedStatement pst= connection.prepareStatement(query);
					String value=comboBoxislem.getSelectedItem().toString();
						pst.setString(1,value);
					String value1=comboBoxram.getSelectedItem().toString();
						pst.setString(2,value1);
					String value2=comboBoxekran.getSelectedItem().toString();
						pst.setString(3,value2);
					String value3=comboBoxana.getSelectedItem().toString();
						pst.setString(4,value3);
					String value4=comboBoxhdd.getSelectedItem().toString();
						pst.setString(5,value4);
						*/
				
					
					JOptionPane.showMessageDialog(null,"Satýn Alýndý");
					
					pst.close();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				Satýnal stn=new Satýnal();
				stn.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(51, 0, 0));
		btnNewButton_1.setForeground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton_1.setBounds(264, 225, 160, 25);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("Sipari\u015Fimi G\u00F6r");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Sipariþ is= new Sipariþ();
				is.setVisible(true);
			}
			
		});
		button.setForeground(Color.LIGHT_GRAY);
		button.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button.setBackground(new Color(51, 0, 0));
		button.setBounds(153, 190, 134, 23);
		contentPane.add(button);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
try { 
					
					String query="select * from Oem where islemci=?";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.setString(1, textField_1.getText());
					ResultSet rs=pst.executeQuery();
					
					
			
					
					
					pst.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(136, 19, 202, 20);
		contentPane.add(textField_1);
		
		JLabel label = new JLabel("Kullan\u0131c\u0131 ad\u0131n\u0131z");
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label.setBackground(new Color(51, 0, 0));
		label.setBounds(10, 21, 116, 14);
		contentPane.add(label);
		fillComboBox();
		
	}
}
