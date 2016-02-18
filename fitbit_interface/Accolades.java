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
import javax.swing.JCheckBox;

public class Accolades extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accolades frame = new Accolades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Accolades() {
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
		
		JLabel lblAccolades = new JLabel("Accolades");
		lblAccolades.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccolades.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblAccolades.setBounds(0, 0, 320, 27);
		contentPane.add(lblAccolades);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(316, 39, 15, 239);
		contentPane.add(scrollBar);
		
		JCheckBox chckbxTask = new JCheckBox("Task #1: <description>");
		chckbxTask.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		chckbxTask.setBounds(10, 60, 294, 23);
		contentPane.add(chckbxTask);
		
		JCheckBox chckbxTask_1 = new JCheckBox("Task #2: <description>");
		chckbxTask_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		chckbxTask_1.setBounds(10, 95, 294, 23);
		contentPane.add(chckbxTask_1);
		
		JCheckBox chckbxTask_2 = new JCheckBox("Task #3: <description>");
		chckbxTask_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		chckbxTask_2.setBounds(10, 130, 294, 23);
		contentPane.add(chckbxTask_2);
		
		JCheckBox chckbxTask_3 = new JCheckBox("Task #4: <description>");
		chckbxTask_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		chckbxTask_3.setBounds(10, 165, 294, 23);
		contentPane.add(chckbxTask_3);
		
		JCheckBox chckbxTask_4 = new JCheckBox("Task #5: <description>");
		chckbxTask_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		chckbxTask_4.setBounds(10, 200, 294, 23);
		contentPane.add(chckbxTask_4);
	}
}
