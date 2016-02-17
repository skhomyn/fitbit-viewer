package fitbit_interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import java.awt.Color;

public class DailyDashboard extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DailyDashboard frame = new DailyDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DailyDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDailyDashboard = new JLabel("Daily Dashboard");
		lblDailyDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDailyDashboard.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblDailyDashboard.setBounds(59, 6, 242, 51);
		contentPane.add(lblDailyDashboard);
		
		JLabel lblNewLabel = new JLabel("Calories");
		lblNewLabel.setBounds(31, 71, 73, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblSteps = new JLabel("Steps");
		lblSteps.setBounds(31, 108, 73, 25);
		contentPane.add(lblSteps);
		
		JLabel lblDistance = new JLabel("Distance");
		lblDistance.setBounds(31, 145, 73, 25);
		contentPane.add(lblDistance);
		
		JLabel lblActiveMinutes = new JLabel("Active Minutes");
		lblActiveMinutes.setBounds(140, 69, 106, 25);
		contentPane.add(lblActiveMinutes);
		
		JLabel lblSe = new JLabel("Sedentary Minutes");
		lblSe.setBounds(140, 108, 125, 25);
		contentPane.add(lblSe);
		
		JLabel lblFloors = new JLabel("Floors");
		lblFloors.setBounds(31, 182, 73, 25);
		contentPane.add(lblFloors);
		
		JLabel lblSedentaryMinutes = new JLabel("Sedentary\nMinutes");
		lblSedentaryMinutes.setBounds(140, 142, 125, 30);
		contentPane.add(lblSedentaryMinutes);
		
		JLabel lblDailyProgress = new JLabel("Daily Progress");
		lblDailyProgress.setBounds(140, 177, 125, 30);
		contentPane.add(lblDailyProgress);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.DARK_GRAY);
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setBounds(332, 0, 118, 278);
		contentPane.add(toolBar);
		
		JButton btnDailyDashboard = new JButton("Daily Dashboard");
		toolBar.add(btnDailyDashboard);
		
		JButton btnBestDays = new JButton("Best Days");
		toolBar.add(btnBestDays);
		
		JButton btnDailyGoals = new JButton("Daily Goals");
		toolBar.add(btnDailyGoals);
		
		JButton btnLifeTimeGoals = new JButton("Lifetime Totals");
		toolBar.add(btnLifeTimeGoals);
		
		JButton btnAccolades = new JButton("Accolades");
		toolBar.add(btnAccolades);
		
		JButton btnTimeSeries = new JButton("Time Series");
		toolBar.add(btnTimeSeries);
		
		JLabel lblNewLabel_1 = new JLabel("Last Updated: Date");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(195, 256, 125, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Heart Zone");
		btnNewButton_2.setBounds(6, 243, 117, 29);
		contentPane.add(btnNewButton_2);
	}
}
