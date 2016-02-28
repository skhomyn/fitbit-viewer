package ca.uwo.csd.cs2212.team13;

// Import necessary libraries:
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class InterfaceView {

	// Attributes:
	private JFrame frame;

	private JButton btnBestDays;
	private JButton btnDailyDashboard;
	private JButton btnDailyGoals;
	private JButton btnLifetimeTotals;
	private JButton btnAccolades;
	private JButton btnTimeSeries;
	private JButton btnHeartRateZones;

	private JPanel panelDashboardView;
	private JPanel panelBestDaysView;
	private JPanel panelAccoladesView;
	private JPanel panelLifetimeTotalsView;
	private JPanel panelTimeSeriesView;
	private JPanel panelDailyGoalsView;
	private JPanel panelHeartrateZonesView;
	
	private JLabel lblLifetimeTotalsDistVal;
	private JLabel lblLifetimeTotalsFloorsVal;
	private JLabel lblLifetimeTotalsStepsVal;
	
	private JLabel lblBestDaysDistVal;
	private JLabel lblBestDaysFloorsVal;
	private JLabel lblBestDaysStepsVal;
	private JLabel lblBestDaysDistDate;
	private JLabel lblBestDaysFloorsDate;
	private JLabel lblBestDaysStepsDate;

	private JLabel lblHeartRateMinVal;
	private JLabel lblRestRateVal;
	private JLabel lblZoneOneVal;
	private JLabel lblZoneTwoVal;
	private JLabel lblZoneThreeVal;

	
	// Launch Application:
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceView window = new InterfaceView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	// Constructor:
	public InterfaceView() {
		initialize();
	}

	// Launch the program:
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setMaximumSize(new Dimension(600, 400));
		frame.setBounds(0, 0, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);

		JPanel CardLayout = new JPanel();
		CardLayout.setBounds(0, 0, 470, 378);
		frame.getContentPane().add(CardLayout);
		CardLayout.setLayout(new CardLayout(0, 0));

		panelDashboardView = new JPanel();
		CardLayout.add(panelDashboardView, "name_1456446913223833000");
		panelDashboardView.setLayout(null);

		panelBestDaysView = new JPanel();
		CardLayout.add(panelBestDaysView, "name_1456446950405885000");
		panelBestDaysView.setLayout(null);

		panelAccoladesView = new JPanel();
		CardLayout.add(panelAccoladesView, "name_1456451728799720000");
		panelAccoladesView.setLayout(null);

		panelLifetimeTotalsView = new JPanel();
		CardLayout.add(panelLifetimeTotalsView, "name_1456451737104428000");
		panelLifetimeTotalsView.setLayout(null);

		panelTimeSeriesView = new JPanel();
		CardLayout.add(panelTimeSeriesView, "name_1456451744019523000");
		panelTimeSeriesView.setLayout(null);

		panelDailyGoalsView = new JPanel();
		CardLayout.add(panelDailyGoalsView, "name_1456456744677539000");
		panelDailyGoalsView.setLayout(null);
		
		panelHeartrateZonesView = new JPanel();
		CardLayout.add(panelHeartrateZonesView, "name_1456529539691360000");
		panelHeartrateZonesView.setLayout(null);

		menuBar();

		dashboardView();

		bestDaysView();

		actionEvents();

		accoladesView();

		lifetimeTotalsView();

		timeseriesView();

		dailygoalsView();
		
		heartratezonesView();
	}

	private void menuBar() {
		JToolBar MenuBar = new JToolBar();
		MenuBar.setBounds(470, 0, 130, 378);
		MenuBar.setFloatable(false);
		MenuBar.setBackground(Color.DARK_GRAY);
		MenuBar.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(MenuBar);

		btnDailyDashboard = new JButton("Daily Dashboard");
		btnDailyDashboard.setMaximumSize(new Dimension(150, 54));
		MenuBar.add(btnDailyDashboard);

		btnBestDays = new JButton("Best Days");
		btnBestDays.setMaximumSize(new Dimension(150, 54));
		MenuBar.add(btnBestDays);

		btnDailyGoals = new JButton("Daily Goals");
		btnDailyGoals.setMaximumSize(new Dimension(150, 54));
		MenuBar.add(btnDailyGoals);

		btnLifetimeTotals = new JButton("Lifetime Totals");
		btnLifetimeTotals.setMaximumSize(new Dimension(150, 54));
		MenuBar.add(btnLifetimeTotals);

		btnAccolades = new JButton("Accolades");
		btnAccolades.setMaximumSize(new Dimension(150, 54));
		MenuBar.add(btnAccolades);

		btnTimeSeries = new JButton("Time Series");
		btnTimeSeries.setMaximumSize(new Dimension(150, 54));
		MenuBar.add(btnTimeSeries);
		
		btnHeartRateZones = new JButton("Heart Rate Zones");
		btnHeartRateZones.setMaximumSize(new Dimension(150, 54));
		MenuBar.add(btnHeartRateZones);
	}

	private void dashboardView() {
		JLabel lblDailyDashboard = new JLabel("Daily Dashboard");
		lblDailyDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDailyDashboard.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblDailyDashboard.setBounds(0, 0, 472, 30);
		panelDashboardView.add(lblDailyDashboard);

		JLabel lblCalories = new JLabel("Calories");
		lblCalories.setBounds(132, 65, 73, 25);
		panelDashboardView.add(lblCalories);

		JLabel lblSteps = new JLabel("Steps");
		lblSteps.setBounds(132, 102, 73, 25);
		panelDashboardView.add(lblSteps);

		JLabel lblDistance = new JLabel("Distance");
		lblDistance.setBounds(132, 139, 73, 25);
		panelDashboardView.add(lblDistance);

		JLabel lblActiveMinutes = new JLabel("Active Minutes");
		lblActiveMinutes.setBounds(241, 63, 106, 25);
		panelDashboardView.add(lblActiveMinutes);

		JLabel lblSe = new JLabel("Sedentary Minutes");
		lblSe.setBounds(241, 102, 125, 25);
		panelDashboardView.add(lblSe);

		JLabel lblFloors = new JLabel("Floors");
		lblFloors.setBounds(132, 176, 73, 25);
		panelDashboardView.add(lblFloors);

		JLabel lblSedentaryMinutes = new JLabel("Sedentary\nMinutes");
		lblSedentaryMinutes.setBounds(241, 136, 125, 30);
		panelDashboardView.add(lblSedentaryMinutes);

		JLabel lblDailyProgress = new JLabel("Daily Progress");
		lblDailyProgress.setBounds(241, 171, 125, 30);
		panelDashboardView.add(lblDailyProgress);

		JLabel lblNewLabel_1 = new JLabel("Last Updated: Date");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(335, 356, 125, 16);
		panelDashboardView.add(lblNewLabel_1);
	}

	private void bestDaysView() {
		JLabel lblBestDays = new JLabel("Best Days");
		lblBestDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestDays.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblBestDays.setBounds(0, 0, 472, 30);
		panelBestDaysView.add(lblBestDays);

		JLabel lblDistance = new JLabel("Distance:");
		lblDistance.setBounds(72, 70, 189, 16);
		panelBestDaysView.add(lblDistance);

		JLabel lblFloors = new JLabel("Floors:");
		lblFloors.setBounds(72, 98, 189, 16);
		panelBestDaysView.add(lblFloors);

		JLabel lblSteps = new JLabel("Steps:");
		lblSteps.setBounds(72, 126, 189, 16);
		panelBestDaysView.add(lblSteps);
		
		lblBestDaysDistVal = new JLabel();
		lblBestDaysDistVal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBestDaysDistVal.setBounds(259, 70, 95, 16);
		panelBestDaysView.add(lblBestDaysDistVal);
		
		lblBestDaysDistDate = new JLabel();
		lblBestDaysDistDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBestDaysDistDate.setBounds(360, 70, 95, 16);
		panelBestDaysView.add(lblBestDaysDistDate);
		
		lblBestDaysFloorsVal = new JLabel();
		lblBestDaysFloorsVal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBestDaysFloorsVal.setBounds(259, 98, 95, 16);
		panelBestDaysView.add(lblBestDaysFloorsVal);
		
		lblBestDaysFloorsDate = new JLabel();
		lblBestDaysFloorsDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBestDaysFloorsDate.setBounds(360, 98, 95, 16);
		panelBestDaysView.add(lblBestDaysFloorsDate);
		
		lblBestDaysStepsVal = new JLabel();
		lblBestDaysStepsVal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBestDaysStepsVal.setBounds(259, 126, 95, 16);
		panelBestDaysView.add(lblBestDaysStepsVal);
		
		lblBestDaysStepsDate = new JLabel();
		lblBestDaysStepsDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBestDaysStepsDate.setBounds(360, 126, 95, 16);
		panelBestDaysView.add(lblBestDaysStepsDate);
	}

	private void accoladesView() {
		JLabel lblAccolades = new JLabel("Accolades");
		lblAccolades.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccolades.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblAccolades.setBounds(0, 0, 472, 32);
		panelAccoladesView.add(lblAccolades);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(455, 0, 15, 378);
		panelAccoladesView.add(scrollBar);

		JCheckBox chckbxTask = new JCheckBox("Task #1:");
		chckbxTask.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		chckbxTask.setBounds(10, 60, 235, 23);
		panelAccoladesView.add(chckbxTask);

		JCheckBox chckbxTask_1 = new JCheckBox("Task #2:");
		chckbxTask_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		chckbxTask_1.setBounds(10, 95, 294, 23);
		panelAccoladesView.add(chckbxTask_1);

		JCheckBox chckbxTask_2 = new JCheckBox("Task #3:");
		chckbxTask_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		chckbxTask_2.setBounds(10, 130, 294, 23);
		panelAccoladesView.add(chckbxTask_2);

		JCheckBox chckbxTask_3 = new JCheckBox("Task #4:");
		chckbxTask_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		chckbxTask_3.setBounds(10, 165, 294, 23);
		panelAccoladesView.add(chckbxTask_3);

		JCheckBox chckbxTask_4 = new JCheckBox("Task #5:");
		chckbxTask_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		chckbxTask_4.setBounds(10, 200, 294, 23);
		panelAccoladesView.add(chckbxTask_4);
		
		JLabel lblDscp1 = new JLabel("<description>");
		lblDscp1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDscp1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDscp1.setBounds(257, 60, 150, 23);
		panelAccoladesView.add(lblDscp1);
		
		JLabel lblDscp2 = new JLabel("<description>");
		lblDscp2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDscp2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDscp2.setBounds(257, 95, 150, 23);
		panelAccoladesView.add(lblDscp2);
		
		JLabel lblDscp3 = new JLabel("<description>");
		lblDscp3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDscp3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDscp3.setBounds(257, 130, 150, 23);
		panelAccoladesView.add(lblDscp3);
		
		JLabel lblDscp4 = new JLabel("<description>");
		lblDscp4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDscp4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDscp4.setBounds(257, 165, 150, 23);
		panelAccoladesView.add(lblDscp4);
		
		JLabel lblDscp5 = new JLabel("<description>");
		lblDscp5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDscp5.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDscp5.setBounds(257, 200, 150, 23);
		panelAccoladesView.add(lblDscp5);
	}

	private void lifetimeTotalsView() {
		JLabel lblTitle = new JLabel("Lifetime Totals");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblTitle.setBounds(0, 0, 472, 32);
		panelLifetimeTotalsView.add(lblTitle);

		JLabel lblDistance = new JLabel("Distance:");
		lblDistance.setBounds(72, 70, 189, 16);
		panelLifetimeTotalsView.add(lblDistance);

		JLabel lblFloors = new JLabel("Floors:");
		lblFloors.setBounds(72, 98, 189, 16);
		panelLifetimeTotalsView.add(lblFloors);

		JLabel lblSteps = new JLabel("Steps:");
		lblSteps.setBounds(72, 126, 189, 16);
		panelLifetimeTotalsView.add(lblSteps);
		
		lblLifetimeTotalsDistVal = new JLabel();
		lblLifetimeTotalsDistVal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLifetimeTotalsDistVal.setBounds(260, 70, 95, 16);
		panelLifetimeTotalsView.add(lblLifetimeTotalsDistVal);
		
		lblLifetimeTotalsFloorsVal = new JLabel();
		lblLifetimeTotalsFloorsVal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLifetimeTotalsFloorsVal.setBounds(260, 98, 95, 16);
		panelLifetimeTotalsView.add(lblLifetimeTotalsFloorsVal);
		
		lblLifetimeTotalsStepsVal = new JLabel();
		lblLifetimeTotalsStepsVal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLifetimeTotalsStepsVal.setBounds(260, 126, 95, 16);
		panelLifetimeTotalsView.add(lblLifetimeTotalsStepsVal);
	}

	private void timeseriesView() {
		JLabel lblNewLabel = new JLabel("Time Series");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel.setBounds(0, 0, 472, 32);
		panelTimeSeriesView.add(lblNewLabel);

		JToolBar graphTitle = new JToolBar();
		graphTitle.setFloatable(false);
		graphTitle.setBounds(128, 44, 235, 20);
		panelTimeSeriesView.add(graphTitle);

		JButton btnSteps = new JButton("Steps");
		graphTitle.add(btnSteps);

		JButton btnCalories = new JButton("Calories");
		graphTitle.add(btnCalories);

		JButton btnDistance = new JButton("Distance");
		graphTitle.add(btnDistance);

		JButton btnHeartDisance = new JButton("Heart Rate");
		graphTitle.add(btnHeartDisance);

		JToolBar zoom = new JToolBar();
		zoom.setFloatable(false);
		zoom.setBounds(173, 352, 130, 20);
		panelTimeSeriesView.add(zoom);

		JButton btnZoomIn = new JButton("Zoom In");
		zoom.add(btnZoomIn);

		JButton btnZoomOut = new JButton("Zoom Out");
		zoom.add(btnZoomOut);

		JLabel lblGraph = new JLabel("Graph");
		lblGraph.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblGraph.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraph.setBackground(new Color(64, 64, 64));
		lblGraph.setBounds(0, 142, 472, 41);
		panelTimeSeriesView.add(lblGraph);		
	}

	private void dailygoalsView() {
		JLabel lblDailyGoals = new JLabel("Daily Goals");
		lblDailyGoals.setForeground(Color.BLACK);
		lblDailyGoals.setBackground(Color.GRAY);
		lblDailyGoals.setHorizontalAlignment(SwingConstants.CENTER);
		lblDailyGoals.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblDailyGoals.setBounds(0, 0, 472, 28);
		panelDailyGoalsView.add(lblDailyGoals);

		JLabel lblSteps = new JLabel("Steps:");
		lblSteps.setBounds(16, 52, 61, 16);
		panelDailyGoalsView.add(lblSteps);

		JLabel lblDistance = new JLabel("Distance:");
		lblDistance.setBounds(16, 80, 61, 16);
		panelDailyGoalsView.add(lblDistance);

		JLabel lblCalories = new JLabel("Calories:");
		lblCalories.setBounds(16, 108, 61, 16);
		panelDailyGoalsView.add(lblCalories);

		JLabel lblFloors = new JLabel("Floors:");
		lblFloors.setBounds(16, 136, 61, 16);
		panelDailyGoalsView.add(lblFloors);

		JButton btnAddNewGoal = new JButton("Add \nNew Goal");
		btnAddNewGoal.setBounds(145, 163, 144, 22);
		panelDailyGoalsView.add(btnAddNewGoal);

		JLabel lblMyGoals = new JLabel("My Goals:");
		lblMyGoals.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblMyGoals.setBounds(16, 206, 85, 28);
		panelDailyGoalsView.add(lblMyGoals);

	}

	private void heartratezonesView() {
		JLabel lblHeartRateZones = new JLabel("Heart Rate Zones");
		lblHeartRateZones.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartRateZones.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblHeartRateZones.setBounds(0, 0, 466, 27);
		panelHeartrateZonesView.add(lblHeartRateZones);
		
		JLabel lblHeartRate = new JLabel("Resting Heart Rate: ");
		lblHeartRate.setBounds(30, 60, 189, 16);
		panelHeartrateZonesView.add(lblHeartRate);
		lblRestRateVal = new JLabel("Resting Heart Rate: ");
		lblRestRateVal.setBounds(30, 60, 189, 16);
		panelHeartrateZonesView.add(lblRestRateVal);
		
		JLabel lblNewLabel = new JLabel("Minutes: ");
		lblNewLabel.setBounds(30, 88, 133, 16);
		panelHeartrateZonesView.add(lblNewLabel);

		lblHeartRateMinVal.setBounds(165, 88, 133, 16);;
		panelHeartrateZonesView.add(lblHeartRateMinVal);
		
		JLabel lblZoneDescriptions = new JLabel("Zone Descriptions:");
		lblZoneDescriptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblZoneDescriptions.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblZoneDescriptions.setBounds(0, 161, 460, 27);
		panelHeartrateZonesView.add(lblZoneDescriptions);
		
		lblZoneOneVal = new JLabel("Zone 1: ");
		lblZoneOneVal.setBounds(30, 200, 148, 16);
		panelHeartrateZonesView.add(lblZoneOneVal);
		
		lblZoneTwoVal = new JLabel("Zone 2: ");
		lblZoneTwoVal.setBounds(30, 228, 148, 16);
		panelHeartrateZonesView.add(lblZoneTwoVal);
		
		lblZoneThreeVal = new JLabel("Zone 3: ");
		lblZoneThreeVal.setBounds(30, 256, 148, 16);
		panelHeartrateZonesView.add(lblZoneThreeVal);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(455, 0, 15, 378);
		panelHeartrateZonesView.add(scrollBar);
	}
	
	private void actionEvents() {
		// Switch window to Best Days screen:
		btnBestDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDashboardView.setVisible(false);
				panelBestDaysView.setVisible(true);
				panelLifetimeTotalsView.setVisible(false);
				panelDailyGoalsView.setVisible(false);
				panelAccoladesView.setVisible(false);
				panelTimeSeriesView.setVisible(false);
				panelHeartrateZonesView.setVisible(false);
			}
		});

		// Switch window to Daily Dashboard screen:
		btnDailyDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDashboardView.setVisible(true);
				panelBestDaysView.setVisible(false);
				panelLifetimeTotalsView.setVisible(false);
				panelDailyGoalsView.setVisible(false);
				panelAccoladesView.setVisible(false);
				panelTimeSeriesView.setVisible(false);
				panelHeartrateZonesView.setVisible(false);
			}
		});

		// Switch window to Lifetime Totals screen:
		btnLifetimeTotals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDashboardView.setVisible(false);
				panelBestDaysView.setVisible(false);
				panelLifetimeTotalsView.setVisible(true);
				panelDailyGoalsView.setVisible(false);
				panelAccoladesView.setVisible(false);
				panelTimeSeriesView.setVisible(false);
				panelHeartrateZonesView.setVisible(false);
			}
		});

		btnDailyGoals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDashboardView.setVisible(false);
				panelBestDaysView.setVisible(false);
				panelLifetimeTotalsView.setVisible(false);
				panelDailyGoalsView.setVisible(true);
				panelAccoladesView.setVisible(false);
				panelTimeSeriesView.setVisible(false);
				panelHeartrateZonesView.setVisible(false);
			}
		});

		// Switch window to Accolades screen:
		btnAccolades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDashboardView.setVisible(false);
				panelBestDaysView.setVisible(false);
				panelLifetimeTotalsView.setVisible(false);
				panelDailyGoalsView.setVisible(false);
				panelAccoladesView.setVisible(true);
				panelTimeSeriesView.setVisible(false);
				panelHeartrateZonesView.setVisible(false);
			}
		});

		// Switch window to Timeseries screen:
		btnTimeSeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDashboardView.setVisible(false);
				panelBestDaysView.setVisible(false);
				panelLifetimeTotalsView.setVisible(false);
				panelDailyGoalsView.setVisible(false);
				panelAccoladesView.setVisible(false);
				panelTimeSeriesView.setVisible(true);
				panelHeartrateZonesView.setVisible(false);
			}
		});
		
		// Switch window to Heart Rate Zones screen:
		btnHeartRateZones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDashboardView.setVisible(false);
				panelBestDaysView.setVisible(false);
				panelLifetimeTotalsView.setVisible(false);
				panelDailyGoalsView.setVisible(false);
				panelAccoladesView.setVisible(false);
				panelTimeSeriesView.setVisible(false);
				panelHeartrateZonesView.setVisible(true);
			}
		});

	}
	
	//method used by action listener to update the view fields from the controller (using model data);
	//  this method gets attached to the lifetime totals button and
	// gets executed when the click actually happens
	public void setLifetimeTotalsFields(double distance, int floors, int steps) {
		lblLifetimeTotalsDistVal.setText(Double.toString(distance));
		lblLifetimeTotalsFloorsVal.setText(Integer.toString(floors));
		lblLifetimeTotalsStepsVal.setText(Integer.toString(steps));
	}
		
	public void setBestDaysFields(double distance, int floors, int steps, String dist_date, String floors_date, String steps_date) {
		lblBestDaysDistVal.setText(Double.toString(distance));
		lblBestDaysFloorsVal.setText(Integer.toString(floors));
		lblBestDaysStepsVal.setText(Integer.toString(steps));
		lblBestDaysDistDate.setText(dist_date);
		lblBestDaysFloorsDate.setText(floors_date);
		lblBestDaysStepsDate.setText(steps_date);
	}

		public void setHeartRateFields(int minutes, HeartZoneRecord[] restRate) {
		lblHeartRateMinVal.setText(Integer.toString(minutes));
		//lblRestRateVal.setText(restRate.toString());
		/*
		lblZoneOneVal.setText(zone1);
		lblZoneTwoVal.setText(zone2);
		lblZoneThreeVal.setText(zone3);
		*/
	}

	// the btnLifetimeTotals.addActionListner() call is encapsulated by a method so that it can be accessed by the controller;
	// the controller passes in the clicklistener, which contains the method that updates the view;
	// this method gets executed when the controller is initialized
	public void addClickListenerLifetimeTotals(ActionListener actionsOnClick){
		btnLifetimeTotals.addActionListener(actionsOnClick);
	}
	
	public void addClickListenerBestDays(ActionListener actionsOnClick){
		btnBestDays.addActionListener(actionsOnClick);
	}
	
	public void setVisible(InterfaceView view) {
		view.frame.setVisible(true);
	}
	
	public void addClickListenerHeartRateZone(ActionListener actionsOnClick){
		btnHeartRateZones.addActionListener(actionsOnClick);
	}

}