import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection =null;
	private JTextField txtusername;
	private JPasswordField pswpassword;

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection=sqliteConnection.dbConnector();
	}

	/**
	 * initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 0, 0));
		frame.setBounds(100, 100, 817, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtusername = new JTextField();
		txtusername.setBounds(120, 58, 150, 20);
		frame.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 59, 103, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 106, 46, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		pswpassword = new JPasswordField();
		pswpassword.setBounds(120, 106, 150, 20);
		frame.getContentPane().add(pswpassword);
		
		JButton btnNewButton = new JButton("Kay\u0131t Ol");
		btnNewButton.setBackground(new Color(51, 0, 0));
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				kayit kayýt=new kayit();
				kayýt.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton.setBounds(120, 193, 117, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnyeGiri = new JButton("\u00DCye Giri\u015F");
		btnyeGiri.setBackground(new Color(51, 0, 0));
		btnyeGiri.setForeground(Color.LIGHT_GRAY);
		btnyeGiri.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent arg0) {
					try {
						String query="select username,password from uyeler where username=? and password=?";
						PreparedStatement pst= connection.prepareStatement(query);
						pst.setString(1, txtusername.getText());
						pst.setString(2, pswpassword.getText());
						ResultSet rs= pst.executeQuery();
						int count =0;
						while(rs.next()) {
							count=count+1;		
						}
						if(count==1) {
							
							JOptionPane.showMessageDialog(null," Kullanýcý Adý ve Þifre doðru");
							frame.dispose();
							Kullanýcý kayit=new Kullanýcý();
							kayit.setVisible(true);
						}
						else if(count>1) {
							JOptionPane.showMessageDialog(null,"Yinelenen Kullanýcý Adý ve Þifre");
						}
						else{
							JOptionPane.showMessageDialog(null,"Kullanýcý Adý veya Þifre Yanlýþ");
						}
						rs.close();
						pst.close();
					}
					catch(Exception e4){
						JOptionPane.showMessageDialog(null,e4);
						
					}
					
				}
			
		});
		btnyeGiri.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnyeGiri.setBounds(207, 150, 117, 24);
		frame.getContentPane().add(btnyeGiri);
		
		
		JButton btngiris = new JButton("Admin Giri\u015F");
		btngiris.setBackground(new Color(51, 0, 0));
		btngiris.setForeground(Color.LIGHT_GRAY);
		btngiris.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select Kadý,sifre from Adminuye where Kadý=? and sifre=?";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.setString(1, txtusername.getText());
					pst.setString(2, pswpassword.getText());
					ResultSet rs= pst.executeQuery();
					int count =0;
					while(rs.next()) {
						count=count+1;		
					}
					if(count==1) {
						
						JOptionPane.showMessageDialog(null," Kullanýcý Adý ve Þifre doðru");
						frame.dispose();
						stoktakip kayt=new stoktakip();
						kayt.setVisible(true);
					}
					else if(count>1) {
						JOptionPane.showMessageDialog(null,"Yinelenen Kullanýcý Adý ve Þifre");
					}
					else{
						JOptionPane.showMessageDialog(null,"Kullanýcý Adý veya Þifre Yanlýþ");
					}
					rs.close();
					pst.close();
				}
				catch(Exception e4){
					JOptionPane.showMessageDialog(null,e4);
					
				}
				
			}
		});
		btngiris.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btngiris.setBounds(45, 151, 117, 23);
		frame.getContentPane().add(btngiris);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(380, 23, 365, 152);
		frame.getContentPane().add(lblNewLabel_2);
		Image img= new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		
		JLabel lblFdf = new JLabel("fdf");
		lblFdf.setBounds(410, 169, 273, 72);
		frame.getContentPane().add(lblFdf);
		Image img1= new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblFdf.setIcon(new ImageIcon(img1));
		
		JButton btnSipariimiGr = new JButton("Sipari\u015Fimi G\u00F6r");
		btnSipariimiGr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Sipariþ sip=new Sipariþ();
				sip.setVisible(true);
			}
			
		});
		btnSipariimiGr.setForeground(Color.LIGHT_GRAY);
		btnSipariimiGr.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnSipariimiGr.setBackground(new Color(51, 0, 0));
		btnSipariimiGr.setBounds(10, 395, 134, 23);
		frame.getContentPane().add(btnSipariimiGr);
	}
}





