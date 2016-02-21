package sharkzilla;

import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LifetimeView extends JFrame {

	private JPanel lifetimePane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LifetimeView frame = new LifetimeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//text field declarations
	JLabel lblDistance = new JLabel("Distance:");
	JLabel lblFloors = new JLabel("Floors:");
	JLabel lblSteps = new JLabel("Steps:");

	JLabel distanceVal = new JLabel();
	JLabel floorsVal = new JLabel();
	JLabel stepsVal = new JLabel();
	
	//menu button declarations
	JButton btnDailyDashboard = new JButton("Daily Dashboard");
	JButton btnBestDays = new JButton("Best Days");
	JButton btnDailyGoals = new JButton("Daily Goals");
	JButton btnLifeTimeTotals = new JButton("Lifetime Totals");
	JButton btnAccolades = new JButton("Accolades");
	JButton btnTimeSeries = new JButton("Time Series");

	//constructor
	public LifetimeView() {		
		
		//set panel layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		lifetimePane = new JPanel();
		lifetimePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(lifetimePane);
		lifetimePane.setLayout(null);
		
		//page title
		JLabel lblNewLabel = new JLabel("Lifetime Totals");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel.setBounds(31, 16, 205, 42);
		lifetimePane.add(lblNewLabel);
		
		//displays lifetime total for distance
		lblDistance.setBounds(72, 70, 100, 16);
		distanceVal.setBounds(250, 70, 100, 16);
		lifetimePane.add(lblDistance);
		lifetimePane.add(distanceVal);
		
		//displays lifetime total for floors
		lblFloors.setBounds(72, 98, 100, 16);
		floorsVal.setBounds(250, 98, 100, 16);
		lifetimePane.add(lblFloors);
		lifetimePane.add(floorsVal);
		
		//displays lifetime total for steps
		lblSteps.setBounds(72, 126, 100, 16);
		stepsVal.setBounds(250, 126, 100, 16);
		lifetimePane.add(lblSteps);
		lifetimePane.add(stepsVal);
		
		//add something to display error 
		
		//create side bar menu object
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setBackground(Color.DARK_GRAY);
		toolBar.setBounds(332, 0, 118, 278);
		lifetimePane.add(toolBar);
		
		//add menu bar components
		toolBar.add(btnDailyDashboard);
		toolBar.add(btnBestDays);
		toolBar.add(btnDailyGoals);
		toolBar.add(btnLifeTimeTotals);
		toolBar.add(btnAccolades);
		toolBar.add(btnTimeSeries);

	}
	
	//method used by controller to update view with distance data
	public void setDistance(float distance) {
		distanceVal.setText(Float.toString(distance));
	}
	
	//method used by controller to update view with floors data
	public void setFloors(int floors) {
		floorsVal.setText(Integer.toString(floors));
	}
	
	//method used by controller to update view with steps data
	public void setSteps(int steps) {
		stepsVal.setText(Integer.toString(steps));
	}
	
	//if the Lifetime totals button in the side bar menu is clicked,
	//execute "action performed" method in the controller
	void addRefreshListener(ActionListener listenForRefresh) {
		btnLifeTimeTotals.addActionListener(listenForRefresh);
	}
	
	void displayErrorMessage() {
		//do something
	}

}
