import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Start_Menu extends JFrame {

	private JPanel contentPane;
	private JTextField Username;
	String name;
	 static Connection con ;
	 Statement stm ;
	 

	public String getName() {
		return Username.getText();
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start_Menu frame = new Start_Menu();
					
					frame.setVisible(true);
					Connect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public static void Connect() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		
		  con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/server","root","");
		  
		 System.out.println("done");
		  
		  
	}
	
	public Start_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 436);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.RED);
		separator.setBounds(131, 51, 174, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(22, 36, 122, 19);
		contentPane.add(lblNewLabel);
		
		Username = new JTextField();
		Username.setForeground(Color.RED);
		Username.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 16));
		Username.setCaretColor(Color.WHITE);
		Username.setOpaque(false);
		Username.setBorder(null);
		Username.setBounds(131, 29, 160, 30);
		contentPane.add(Username);
		Username.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setForeground(new Color(255, 255, 0));
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		btnNewButton_1.setBounds(149, 245, 89, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\tStart");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 Statement stm;
				try {
					stm = con.createStatement();
					String sql = "insert into players  values ('"+Username.getText()+" ') ";
					
					
					stm.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
					
				
				if (Username != null) {
					
					new Game().start();;
					
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.setOpaque(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(149, 161, 89, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\jalla\\Downloads\\destroyer.png"));
		lblNewLabel_1.setBounds(10, 36, 392, 306);
		contentPane.add(lblNewLabel_1);
	}
}
