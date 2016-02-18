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

public class TimeSeries extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeSeries frame = new TimeSeries();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TimeSeries() {
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
		
		JLabel lblNewLabel = new JLabel("Time Series");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel.setBounds(0, 0, 331, 32);
		contentPane.add(lblNewLabel);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(33, 44, 271, 20);
		contentPane.add(toolBar_1);
		
		JButton btnSteps = new JButton("Steps");
		toolBar_1.add(btnSteps);
		
		JButton btnCalories = new JButton("Calories");
		toolBar_1.add(btnCalories);
		
		JButton btnDistance = new JButton("Distance");
		toolBar_1.add(btnDistance);
		
		JButton btnHeartDisance = new JButton("Heart Rate");
		toolBar_1.add(btnHeartDisance);
		
		JToolBar toolBar_2 = new JToolBar();
		toolBar_2.setFloatable(false);
		toolBar_2.setBounds(107, 238, 130, 20);
		contentPane.add(toolBar_2);
		
		JButton btnZoomIn = new JButton("Zoom In");
		toolBar_2.add(btnZoomIn);
		
		JButton btnZoomOut = new JButton("Zoom Out");
		toolBar_2.add(btnZoomOut);
		
		JLabel lblGraph = new JLabel("Graph");
		lblGraph.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblGraph.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraph.setBackground(new Color(64, 64, 64));
		lblGraph.setBounds(33, 100, 259, 114);
		contentPane.add(lblGraph);
	}

}
