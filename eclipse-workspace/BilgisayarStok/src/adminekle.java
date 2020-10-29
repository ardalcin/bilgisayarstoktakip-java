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

public class adminekle extends JFrame {

	private JPanel contentPane;

	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminekle frame = new adminekle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection =null;
	private JTable table_1;
	
	public void refreshTable ()
	{
		
		try {
			String query="select Kadý,sifre from Adminuye ";
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
	public adminekle() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 420);
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
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBackground(new Color(51, 0, 0));
		lblNewLabel.setBounds(21, 14, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sifre");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBackground(new Color(51, 0, 0));
		lblNewLabel_1.setBounds(21, 45, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.setForeground(Color.LIGHT_GRAY);
		btnEkle.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnEkle.setBackground(new Color(51, 0, 0));
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query="insert into Adminuye(Kadý,sifre) values(?,?)";
					
					PreparedStatement pst= connection.prepareStatement(query);
					
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					
					
					
					
					pst.execute();
					
					
					JOptionPane.showMessageDialog(null,"Kayýt Eklendi");
					
					
					pst.close();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				refreshTable ();
				
				
			}
		});
		btnEkle.setBounds(21, 70, 89, 23);
		contentPane.add(btnEkle);
		
		JButton btnNewButton = new JButton("sil");
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(51, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="delete from Adminuye where Kadý='"+textField.getText()+"'	";
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
		btnNewButton.setBounds(137, 70, 89, 23);
		contentPane.add(btnNewButton); 
		
		JButton btnNewButton_1 = new JButton("Listele");
		btnNewButton_1.setForeground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(51, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="select * from Adminuye ";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(515, 200, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(236, 15, 368, 174);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row =table.getSelectedRow();
					String kad_=(table.getModel().getValueAt(row,  0)).toString();
					
					String query="select * from Adminuye where Kadý='"+kad_+"'";
					PreparedStatement pst= connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						
						textField.setText(rs.getString("Kadý"));
						textField_1.setText(rs.getString("sifre"));
					
						
						
					}
					pst.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			
			
			
		});
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(24, 255, 600, 100);
		contentPane.add(lblNewLabel_5);
		Image img= new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img));
		}

}
