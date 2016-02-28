package ca.uwo.csd.cs2212.team13;

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

public class HRZView extends JFrame {
	private JPanel heartPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRZView frame = new HRZView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//text field declarations
	//based on current InterfaceView
		JLabel lblRestRate = new JLabel("Resting Heart Rate:");
		JLabel lblMins = new JLabel("Minutes:");
		JLabel lblCardio = new JLabel("Zone 1:");
		JLabel lblPeak = new JLabel("Zone 2:");
		JLabel lblFatBurn = new JLabel("Zone 3:");
		
		JLabel restVal = new JLabel();
		JLabel minsVal = new JLabel();
		JLabel cardioVal = new JLabel();
		JLabel peakVal = new JLabel();
		JLabel fatBurnVal = new JLabel();
		
		//menu button declarations
		JButton btnDailyDashboard = new JButton("Daily Dashboard");
		JButton btnBestDays = new JButton("Best Days");
		JButton btnDailyGoals = new JButton("Daily Goals");
		JButton btnLifeTimeTotals = new JButton("Lifetime Totals");
		JButton btnAccolades = new JButton("Accolades");
		JButton btnTimeSeries = new JButton("Time Series");
		JButton btnHeartRateZone = new JButton("Heart Rate Zone");
		
	//constructor
		public HRZView() {
			
			//set panel layout
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			heartPane = new JPanel();
			heartPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(heartPane);
			heartPane.setLayout(null);
			
			//page title
			JLabel lblNewLabel = new JLabel("Heart Rate Zone");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			lblNewLabel.setBounds(31, 16, 205, 42);
			heartPane.add(lblNewLabel);
			
			//displays resting heart rate
			lblRestRate.setBounds(72, 70, 100, 16);
			restVal.setBounds(250, 70, 100, 16);
			heartPane.add(lblRestRate);
			heartPane.add(restVal);
			
			//displays minutes
			lblMins.setBounds(72, 70, 100, 16);
			minsVal.setBounds(250, 70, 100, 16);
			heartPane.add(lblMins);
			heartPane.add(minsVal);
			
			//displays Zone 1 (cardio
			lblCardio.setBounds(72, 70, 100, 16);
			cardioVal.setBounds(250, 70, 100, 16);
			heartPane.add(lblCardio);
			heartPane.add(cardioVal);
			
			//displays Zone 2 (peak)
			lblPeak.setBounds(72, 70, 100, 16);
			peakVal.setBounds(250, 70, 100, 16);
			heartPane.add(lblPeak);
			heartPane.add(peakVal);
			
			//displays Zone 3 (fat burn)
			lblFatBurn.setBounds(72, 70, 100, 16);
			fatBurnVal.setBounds(250, 70, 100, 16);
			heartPane.add(lblFatBurn);
			heartPane.add(fatBurnVal);
			
			//TODO: error handling will go here
			
			//create side bar menu obj.
			JToolBar toolBar = new JToolBar();
			toolBar.setOrientation(SwingConstants.VERTICAL);
			toolBar.setBackground(Color.DARK_GRAY);
			toolBar.setBounds(332, 0, 118, 278);
			heartPane.add(toolBar);
			
			//add menu bar components
			toolBar.add(btnDailyDashboard);
			toolBar.add(btnBestDays);
			toolBar.add(btnDailyGoals);
			toolBar.add(btnLifeTimeTotals);
			toolBar.add(btnAccolades);
			toolBar.add(btnTimeSeries);
			toolBar.add(btnHeartRateZone);
			
		} //end of constructor
		
		//method used by controller to update view with mins data
		public void setMinutes(int minutes) {
			minsVal.setText(Integer.toString(minutes));
		}
		
		//method used by controller to update view with resting rate data
		public void setRestRate(int rest) {
			restVal.setText(Integer.toString(rest));
		}
		
		//method used by controller to update view with zone 1 data
		public void setCardioZone(int cz) {
			cardioVal.setText(Integer.toString(cz));
		}
		
		//method used by controller to update view with zone 2 data
		public void setPeakZone(int pz) {
			peakVal.setText(Integer.toString(pz));
		}
				
		//method used by controller to update view with zone 1 data
		public void setFatBurnZone(int fbz) {
			fatBurnVal.setText(Integer.toString(fbz));
		}
		
		//if the Lifetime totals button in the side bar menu is clicked,
		//execute "action performed" method in the controller
		void addRefreshListener(ActionListener listenForRefresh) {
			btnHeartRateZone.addActionListener(listenForRefresh);
		}
		
		void displayErrorMessage() {
			//do something
		}	
}