package fitbit_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(152, 189, 117, 29);
		contentPane.add(btnLogin);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(152, 76, 134, 28);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(152, 122, 134, 28);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(60, 82, 80, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(60, 128, 80, 16);
		contentPane.add(lblPassword);
		
		JLabel lblAppName = new JLabel("App Name");
		lblAppName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppName.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblAppName.setBounds(115, 19, 205, 41);
		contentPane.add(lblAppName);
		
		JLabel lblFitbitLogo = new JLabel("FitBit Logo");
		lblFitbitLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFitbitLogo.setBounds(173, 242, 75, 16);
		contentPane.add(lblFitbitLogo);
	}
}
