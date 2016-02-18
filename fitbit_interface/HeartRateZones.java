package fitbit_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;

public class HeartRateZones extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeartRateZones frame = new HeartRateZones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public HeartRateZones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setBackground(Color.DARK_GRAY);
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
		
		JLabel lblHeartRateZones = new JLabel("Heart Rate Zones");
		lblHeartRateZones.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartRateZones.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblHeartRateZones.setBounds(0, 0, 320, 27);
		contentPane.add(lblHeartRateZones);
		
		JLabel lblHeartRate = new JLabel("Resting Heart Rate: <hr>");
		lblHeartRate.setBounds(6, 39, 189, 16);
		contentPane.add(lblHeartRate);
		
		JLabel lblNewLabel = new JLabel("Minutes: <time>");
		lblNewLabel.setBounds(6, 67, 133, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblZoneDescriptions = new JLabel("Zone Descriptions:");
		lblZoneDescriptions.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblZoneDescriptions.setBounds(6, 99, 174, 27);
		contentPane.add(lblZoneDescriptions);
		
		JLabel lblZone = new JLabel("Zone 1: <description>");
		lblZone.setBounds(6, 138, 148, 16);
		contentPane.add(lblZone);
		
		JLabel lblZone_1 = new JLabel("Zone 2: <description>");
		lblZone_1.setBounds(6, 166, 148, 16);
		contentPane.add(lblZone_1);
		
		JLabel lblZone_2 = new JLabel("Zone 3: <description>");
		lblZone_2.setBounds(6, 194, 148, 16);
		contentPane.add(lblZone_2);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(317, 39, 15, 239);
		contentPane.add(scrollBar);
	}
}
