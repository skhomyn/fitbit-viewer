package fitbit_interface;

import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LifetimeView extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LifetimeTotals frame = new LifetimeTotals();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LifetimeTotals() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
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
		*/
		
		JLabel lblNewLabel = new JLabel("Lifetime Totals");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel.setBounds(31, 16, 205, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblDistance = new JLabel("Distance: <distance>");
		lblDistance.setBounds(72, 70, 189, 16);
		contentPane.add(lblDistance);
		
		JLabel lblFloors = new JLabel("Floors: <floors>");
		lblFloors.setBounds(72, 98, 189, 16);
		contentPane.add(lblFloors);
		
		JLabel lblSteps = new JLabel("Steps: <steps>");
		lblSteps.setBounds(72, 126, 189, 16);
		contentPane.add(lblSteps);
	}

}
