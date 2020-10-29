import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Oem extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxislem;
	private JComboBox comboBoxram;
	private JComboBox comboBoxhdd;
	private JComboBox comboBoxana;
	private JComboBox comboBoxekran;
	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Oem frame = new Oem();
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
	private JButton button;
	private JTable table;
	private JTextField textField_2;
        public void fillComboBox()
        {
        	
        	try {
        			String query="select * from Oem";
        			PreparedStatement pst= connection.prepareStatement(query);
        			ResultSet rs=pst.executeQuery();
        			
        			
        				while(rs.next()	)
        				{
        							
        							comboBoxislem.addItem(rs.getString("islemci"));		
        							comboBoxram.addItem(rs.getString("Ram"));		
        							comboBoxana.addItem(rs.getString("Anakart"));		
        							comboBoxhdd.addItem(rs.getString("Harddisk"));		
        							comboBoxekran.addItem(rs.getString("Ekrankartý"));		
        				}
        					
        		
        		
			} catch (Exception e) {
				e.printStackTrace();
			
			
			
			
			
			}
        	
        }

	/**
	 * Create the frame.
	 */
	public Oem() {
		frame=new JFrame();
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxislem = new JComboBox();
		comboBoxislem.setBackground(new Color(51, 0, 0));
		comboBoxislem.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBoxislem.setForeground(Color.LIGHT_GRAY);
		comboBoxislem.setBounds(102, 55, 236, 20);
		contentPane.add(comboBoxislem);
		
		 comboBoxram = new JComboBox();
		comboBoxram.setBackground(new Color(51, 0, 0));
		comboBoxram.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBoxram.setForeground(Color.LIGHT_GRAY);
		comboBoxram.setBounds(102, 86, 236, 20);
		contentPane.add(comboBoxram);
		
		 comboBoxekran = new JComboBox();
		comboBoxekran.setBackground(new Color(51, 0, 0));
		comboBoxekran.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBoxekran.setForeground(Color.LIGHT_GRAY);
		comboBoxekran.setBounds(102, 117, 236, 20);
		contentPane.add(comboBoxekran);
		
		 comboBoxhdd = new JComboBox();
		comboBoxhdd.setBackground(new Color(51, 0, 0));
		comboBoxhdd.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBoxhdd.setForeground(Color.LIGHT_GRAY);
		comboBoxhdd.setBounds(102, 148, 236, 20);
		contentPane.add(comboBoxhdd);
		
		 comboBoxana = new JComboBox();
		comboBoxana.setBackground(new Color(51, 0, 0));
		comboBoxana.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBoxana.setForeground(Color.LIGHT_GRAY);
		comboBoxana.setBounds(102, 179, 236, 20);
		contentPane.add(comboBoxana);
		
		JLabel lblislemci = new JLabel("islemci");
		lblislemci.setBackground(new Color(51, 0, 0));
		lblislemci.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblislemci.setForeground(Color.LIGHT_GRAY);
		lblislemci.setBounds(10, 55, 86, 14);
		contentPane.add(lblislemci);
		
		JLabel lblram = new JLabel("Ram");
		lblram.setBackground(new Color(51, 0, 0));
		lblram.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblram.setForeground(Color.LIGHT_GRAY);
		lblram.setBounds(10, 86, 86, 14);
		contentPane.add(lblram);
		
		JLabel lblekran = new JLabel("Ekran Kart\u0131");
		lblekran.setBackground(new Color(51, 0, 0));
		lblekran.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblekran.setForeground(Color.LIGHT_GRAY);
		lblekran.setBounds(10, 117, 86, 14);
		contentPane.add(lblekran);
		
		JLabel lblhdd = new JLabel("Harddisk");
		lblhdd.setBackground(new Color(51, 0, 0));
		lblhdd.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblhdd.setForeground(Color.LIGHT_GRAY);
		lblhdd.setBounds(10, 148, 86, 14);
		contentPane.add(lblhdd);
		
		JLabel lblana = new JLabel("Ana kart");
		lblana.setBackground(new Color(51, 0, 0));
		lblana.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblana.setForeground(Color.LIGHT_GRAY);
		lblana.setBounds(10, 179, 86, 14);
		contentPane.add(lblana);
		
		JButton btnSatnAl = new JButton("Sat\u0131n Al");
		btnSatnAl.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnSatnAl.setBackground(new Color(51, 0, 0));
		btnSatnAl.setForeground(Color.LIGHT_GRAY);
		btnSatnAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				try {
					String query="update uyeler set  islemci='"+comboBoxislem.getSelectedItem()+"',ram='"+comboBoxram.getSelectedItem()+"',ekrankartý='"+comboBoxekran.getSelectedItem()+"',anakart='"+comboBoxana.getSelectedItem()+"',hdd='"+comboBoxhdd.getSelectedItem()+"' where username='"+textField_1.getText()+"'";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.execute();
					
					String querry="UPDATE Oem SET adetislem=adetislem-1 WHERE islemci='"+comboBoxislem.getSelectedItem()+ "'   ";
					PreparedStatement ppppsstt= connection.prepareStatement(querry);
					ppppsstt.execute();	
					String querrry="UPDATE Oem SET adetram=adetram-1 WHERE Ram='"+comboBoxram.getSelectedItem()+ "'   ";
					PreparedStatement ppsstt= connection.prepareStatement(querrry);
					ppsstt.execute();
					
					String queerryy="UPDATE Oem SET adethdd=adethdd-1 WHERE Harddisk='"+comboBoxhdd.getSelectedItem()+ "'   ";
					PreparedStatement pssstttt= connection.prepareStatement(queerryy);
					pssstttt.execute();
					
					String queerry="UPDATE Oem SET adetana=adetana-1 WHERE Anakart='"+comboBoxana.getSelectedItem()+ "'   ";
					PreparedStatement pssttt= connection.prepareStatement(queerry);
					pssttt.execute();
					String quuerry="UPDATE Oem SET adetekran=adetekran-1 WHERE Ekrankartý='"+comboBoxekran.getSelectedItem()+ "'   ";
					PreparedStatement pssstt= connection.prepareStatement(quuerry);
					pssstt.execute();
					
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
		
		btnAlveri.setBounds(32, 210, 179, 26);
		contentPane.add(btnAlveri);
		btnSatnAl.setBounds(249, 210, 89, 23);
		contentPane.add(btnSatnAl);
		
		textField_1 = new JTextField();
		textField_1.setBounds(136, 27, 202, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		button = new JButton("Sipari\u015Fimi G\u00F6r");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.dispose();
				Sipariþ is= new Sipariþ();
				is.setVisible(true);
					
			}
		});
		button.setForeground(Color.LIGHT_GRAY);
		button.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button.setBackground(new Color(51, 0, 0));
		button.setBounds(10, 278, 134, 23);
		contentPane.add(button);
		
		JLabel lblKullancAdnz = new JLabel("Kullan\u0131c\u0131 ad\u0131n\u0131z");
		lblKullancAdnz.setForeground(Color.LIGHT_GRAY);
		lblKullancAdnz.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblKullancAdnz.setBackground(new Color(51, 0, 0));
		lblKullancAdnz.setBounds(10, 29, 116, 14);
		contentPane.add(lblKullancAdnz);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(358, 30, 236, 206);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnNewButton.setBounds(426, 279, 89, 23);
		contentPane.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
try {
					
					
					String query="select * from Oem where islemci=?";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.setString(1, textField_1.getText());
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
			
					
					
					pst.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		textField_2.setBounds(426, 247, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		fillComboBox();
		
	}
}
