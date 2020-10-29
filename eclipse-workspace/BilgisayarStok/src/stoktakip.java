import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import java.awt.event.MouseAdapter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


import java.awt.event.MouseEvent;
public class stoktakip extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stoktakip frame = new stoktakip();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection =null;
	private JLabel label;
	private JTextField textField_4;
	public void refreshTable ()
	{
		
		try {
			String query="select EÝD,model,ürünkodu,ürünsayýsý,fiyat from bilgisayar ";
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
	public stoktakip() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblmodel = new JLabel("Model :");
		lblmodel.setForeground(Color.LIGHT_GRAY);
		lblmodel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblmodel.setBounds(11, 67, 112, 14);
		contentPane.add(lblmodel);
		
		JLabel lblürünkodu = new JLabel("Ürün Kodu:");
		lblürünkodu.setForeground(Color.LIGHT_GRAY);
		lblürünkodu .setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblürünkodu .setBounds(11, 92, 112, 14);
		contentPane.add(lblürünkodu );
		
		JLabel lblÜrünAdedi = new JLabel("ürünsayýsý:");
		lblÜrünAdedi.setForeground(Color.LIGHT_GRAY);
		lblÜrünAdedi.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblÜrünAdedi.setBounds(11, 117, 103, 14);
		contentPane.add(lblÜrünAdedi);
		
		JLabel lblfiyat = new JLabel("fiyat :");
		lblfiyat.setForeground(Color.LIGHT_GRAY);
		lblfiyat.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblfiyat.setBounds(11, 142, 112, 14);
		contentPane.add(lblfiyat);
		
		
		
		textField = new JTextField();
		textField.setBounds(109, 61, 162, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 88, 162, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(109, 115, 161, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(109, 142, 162, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		btnNewButton = new JButton("Listele");
		btnNewButton.setBackground(new Color(51, 0, 0));
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from bilgisayar ";
					PreparedStatement pst= connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(208, 173, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Sil");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="delete from bilgisayar where EÝD='"+textField_4.getText()+"'	";
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
		btnNewButton_1.setBackground(new Color(51, 0, 0));
		btnNewButton_1.setForeground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton_1.setBounds(109, 173, 89, 23);
		contentPane.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(337, 36, 379, 174);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				try {
					
					int row =table.getSelectedRow();
					String EÝD_=(table.getModel().getValueAt(row,  0)).toString();
					
					String query="select * from bilgisayar where EÝD='"+EÝD_+"'";
					PreparedStatement pst= connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						
						textField_4.setText(rs.getString("EÝD"));
						textField_3.setText(rs.getString("fiyat"));
						textField_2.setText(rs.getString("ürünsayýsý"));
						textField_1.setText(rs.getString("ürünkodu"));
						textField.setText(rs.getString("model"));
						
						
					}
					pst.close();

					} catch (Exception e2) {
					e2.printStackTrace();
					}
			
			
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Ekle");
		btnNewButton_2.setBackground(new Color(51, 0, 0));
		btnNewButton_2.setForeground(Color.LIGHT_GRAY);
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into bilgisayar(EÝD,model,ürünkodu,ürünsayýsý,fiyat) values(?,?,?,?,?)";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.setString(1,textField_4.getText());
					pst.setString(2,textField.getText());
					pst.setString(3,textField_1.getText());
					pst.setString(4,textField_2.getText());
					pst.setString(5,textField_3.getText());
						pst.execute();
					JOptionPane.showMessageDialog(null,"Kayýt Eklendi");
					pst.close();

					} catch (Exception e2) {
					e2.printStackTrace();
					}
				refreshTable ();

		
			}
		});
		btnNewButton_2.setBounds(10, 173, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(92, 278, 570, 165);
		contentPane.add(lblNewLabel);
		Image img= new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JLabel lblEd = new JLabel("EID:");
		lblEd.setForeground(Color.LIGHT_GRAY);
		lblEd.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblEd.setBackground(new Color(51, 0, 0));
		lblEd.setBounds(11, 42, 46, 14);
		contentPane.add(lblEd);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(109, 36, 162, 20);
		contentPane.add(textField_4);
		
		JButton btnOemEkle = new JButton("Oem ekle");
		btnOemEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				oemekle top=new oemekle();
				top.setVisible(true);
			}
		});
		btnOemEkle.setForeground(Color.LIGHT_GRAY);
		btnOemEkle.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnOemEkle.setBackground(new Color(51, 0, 0));
		btnOemEkle.setBounds(42, 207, 112, 23);
		contentPane.add(btnOemEkle);
		
		JButton btnKullancDzenle = new JButton("m\u00FC\u015Fteri ayar");
		btnKullancDzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				üyedüzen müsteri=new üyedüzen();
				müsteri.setVisible(true);
			}
		});
		btnKullancDzenle.setForeground(Color.LIGHT_GRAY);
		btnKullancDzenle.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnKullancDzenle.setBackground(new Color(51, 0, 0));
		btnKullancDzenle.setBounds(164, 207, 119, 23);
		contentPane.add(btnKullancDzenle);
		
		JButton btnAdminEkle = new JButton("Admin Ekle");
		btnAdminEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminekle adm=new adminekle();
				adm.setVisible(true);
			}
		});
		btnAdminEkle.setForeground(Color.LIGHT_GRAY);
		btnAdminEkle.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnAdminEkle.setBackground(new Color(51, 0, 0));
		btnAdminEkle.setBounds(109, 244, 119, 23);
		contentPane.add(btnAdminEkle);
		
	}
}
