package ca.uwo.csd.cs2212.team13;

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
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;

/**
 * {@code InterfaceView} creates the GUI of the Fitbit program.
 * It also implements page navigation between the different screens.
 */

public class InterfaceView {

	/**
	 * JFrame for frame obv
	 * 
	 */
	private JFrame frame;

	/**
	 * JButton for best days
	 */
	private JButton btnBestDays;
	/**
	 * JButton for daily dashboard
	 */
	private JButton btnDailyDashboard;
	/**
	 * JButton for daily goals
	 */
	private JButton btnDailyGoals;
	/**
	 * JButton for lifetime totals
	 */
	private JButton btnLifetimeTotals;
	/**
	 * JButton for accolades
	 */
	private JButton btnAccolades;
	/**
	 * JButton for time series
	 */
	private JButton btnTimeSeries;
	/**
	 * JButton for heart rate zones
	 */
	private JButton btnHeartRateZones;

	/**
	 * JPanel for dashboard view
	 */
	private JLayeredPane panelDashboardView;
	/**
	 * JPanel for dashboard view
	 */
	private JPanel panelBestDaysView;
	/**
	 * JPanel for accolades view
	 */
	private JPanel panelAccoladesView;
	/**
	 * JPanel for lifetime totals view
	 */
	private JPanel panelLifetimeTotalsView;
	/**
	 * JPanel for time series view
	 */
	private JPanel panelTimeSeriesView;
	/**
	 * JPanel for daily goals view
	 */
	private JPanel panelDailyGoalsView;
	/**
	 * JPanel for heart rate zones view
	 */
	private JPanel panelHeartrateZonesView;

	/**
	 * label for lifetime totals distance value
	 */
	private JLabel lblLifetimeTotalsDistVal;
	/**
	 * label for lifetime totals floors value
	 */
	private JLabel lblLifetimeTotalsFloorsVal;
	/**
	 * label for lifetime totals floors value
	 */
	private JLabel lblLifetimeTotalsStepsVal;

	/**
	 * Jlabel for last updated
	 */
	private JLabel lblLastUpdated;
	/**
	 * label for daily calories out
	 */
	private JLabel lblDailyCaloriesVal;
	/**
	 * label for daily dashboard steps
	 */
	private JLabel lblDailyStepsVal;
	/**
	 * label for daily dashboard floors
	 */
	private JLabel lblDailyFloorsVal;
	/**
	 * Label for daily dashboard sedentary minutes
	 */
	private JLabel lblDailySedenteryMinVal;
	/**
	 * Label for daily dashboard lightly active minutes
	 */
	private JLabel lblDailyLightlyActMinVal;
	/**
	 * Label for daily dashboard fairly active minutes
	 */
	private JLabel lblDailyFairlyActMinVal;
	/**
	 * Label for daily dashboard very active minutes
	 */
	private JLabel lblDailyVeryActMinVal;
	/**
	 * label for daily goals value
	 */
	private JLabel lblDailyGoalsVal;

	/**
	 * label for best days distance
	 */
	private JLabel lblBestDaysDistVal;
	/**
	 * label for best day: floors
	 */
	private JLabel lblBestDaysFloorsVal;
	/**
	 * label for best day: steps
	 */
	private JLabel lblBestDaysStepsVal;
	/**
	 * label for best days: distance date
	 */
	private JLabel lblBestDaysDistDate;
	/**
	 * label for best days: floors date
	 */
	private JLabel lblBestDaysFloorsDate;
	/**
	 * label for best days: steps date
	 */
	private JLabel lblBestDaysStepsDate;

	/**
	 * label for min value[?] not used
	 */
	private JLabel lblHeartRateMinVal;
	/**
	 * Label for resting rate[?] not used
	 */
	private JLabel lblRestRateVal;
	/**
	 * Label for zone aka cardio
	 */
	private JLabel lblZoneOneVal;
	/**
	 * Label for zone two aka fat burn
	 */
	private JLabel lblZoneTwoVal;
	/**
	 * Label for zone three aka peak
	 */
	private JLabel lblZoneThreeVal;

	/**
	 * Label for heart total minutes
	 */
	private JLabel lblHeartMins;
	/**
	 * Label for heart resting rate
	 */
	private JLabel lblHeartRest;

	/**
	 * Label for max min minutes cardio zone
	 */
	private JLabel lblHeartCardioMaxMin;
	/**
	 * Label for max min minutes fat burn zone
	 */
	private JLabel lblHeartFatBurnMaxMin;

	/**
	 * Label for max min minutes peak zone
	 */
	private JLabel lblHeartPeakMaxMin;

	/**
	 * Label for max min minutes out of range zone
	 */
	private JLabel lblHeartOORMaxMin;

	/**
	 * Constructor: uses initialize() method
	 */
	
	
	private JPanel[] panelArray;
	
	private JRadioButton radioTotalDist;
	private JRadioButton radioCalories;
	private JRadioButton radioSedMin;
	private JRadioButton radioActiveMin;
	private JRadioButton radioFloors;
	private JRadioButton radioSteps;
	
	public InterfaceView() {
		initialize();
	}

	/**
	 * This method implements the GUI of the fibit program. The frame is the
	 * foundation, making up the whole window that holds the ContentPane. The
	 * ContentPane holds the CardLayout and the MenuBar toolbar. The Cardlayout
	 * contains multiple different panels which make up different screens of the
	 * program. The Cardlayout allows page navigation between these panels, by
	 * setting the visibility of every screen. The MenuBar is a tooldbar menu
	 * holding the buttons used for page navigation. This method sets up the
	 * prame and panels, then calls other methods for each screen and the menu.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(900, 596));
		frame.setResizable(false);
		frame.setMaximumSize(new Dimension(900, 600));
		frame.setBounds(0, 0, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);

		JPanel CardLayout = new JPanel();
		CardLayout.setBounds(0, 0, 720, 578);
		frame.getContentPane().add(CardLayout);
		CardLayout.setLayout(new CardLayout(0, 0));

		panelDashboardView = new JLayeredPane();
		CardLayout.add(panelDashboardView, "name_1456446913223833000");

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

	/**
	 * This method implements the buttons used for page navigation. The buttons
	 * are held in a toolbar.
	 */
	private void menuBar() {
		JToolBar MenuBar = new JToolBar();
		MenuBar.setBorder(null);
		MenuBar.setBounds(720, 0, 180, 578);
		MenuBar.setFloatable(false);
		MenuBar.setBackground(null);
		MenuBar.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(MenuBar);

		btnDailyDashboard = new JButton("Daily Dasboard");
		btnDailyDashboard.setMargin(new Insets(0, 0, 0, 0));
		btnDailyDashboard.setMaximumSize(new Dimension(180, 82));
		MenuBar.add(btnDailyDashboard);

		btnBestDays = new JButton("Best Days");
		btnBestDays.setMargin(new Insets(0, 0, 0, 0));
		btnBestDays.setMaximumSize(new Dimension(180, 82));
		MenuBar.add(btnBestDays);

		btnDailyGoals = new JButton("Daily Goals");
		btnDailyGoals.setMargin(new Insets(0, 0, 0, 0));
		btnDailyGoals.setMaximumSize(new Dimension(180, 82));
		MenuBar.add(btnDailyGoals);

		btnLifetimeTotals = new JButton("Lifetime Totals");
		btnLifetimeTotals.setMargin(new Insets(0, 0, 0, 0));
		btnLifetimeTotals.setMaximumSize(new Dimension(180, 82));
		MenuBar.add(btnLifetimeTotals);

		btnAccolades = new JButton("Accolades");
		btnAccolades.setMargin(new Insets(0, 0, 0, 0));
		btnAccolades.setMaximumSize(new Dimension(180, 82));
		MenuBar.add(btnAccolades);

		btnTimeSeries = new JButton("Time Series");
		btnTimeSeries.setMargin(new Insets(0, 0, 0, 0));
		btnTimeSeries.setMaximumSize(new Dimension(180, 82));
		MenuBar.add(btnTimeSeries);

		btnHeartRateZones = new JButton("Heart Rate Zones");
		btnHeartRateZones.setMargin(new Insets(0, 0, 0, 0));
		btnHeartRateZones.setMaximumSize(new Dimension(180, 82));
		MenuBar.add(btnHeartRateZones);
	}

	/**
	 * This method implements the Dashboard screen.
	 */
	private void dashboardView() {
		panelDashboardView.setLayout(null);
		JLabel lblDailyDashboard = new JLabel("Daily Dashboard");
		lblDailyDashboard.setBounds(0, 0, 720, 30);
		lblDailyDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDailyDashboard.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		panelDashboardView.add(lblDailyDashboard);

		// Commented out until implementation
		// JLabel lblDailyProgress = new JLabel("Daily Goals");
		// lblDailyProgress.setBounds(241, 171, 125, 16);
		// panelDashboardView.add(lblDailyProgress);

		lblLastUpdated = new JLabel();
		lblLastUpdated.setBounds(583, 540, 125, 16);
		lblLastUpdated.setHorizontalAlignment(SwingConstants.TRAILING);
		panelDashboardView.add(lblLastUpdated);

		lblDailyFloorsVal = new JLabel();
		lblDailyFloorsVal.setBounds(160, 196, 70, 16);
		lblDailyFloorsVal.setHorizontalAlignment(SwingConstants.TRAILING);
		panelDashboardView.add(lblDailyFloorsVal);

		lblDailySedenteryMinVal = new JLabel();
		lblDailySedenteryMinVal.setBounds(270, 122, 70, 16);
		lblDailySedenteryMinVal.setHorizontalAlignment(SwingConstants.TRAILING);
		panelDashboardView.add(lblDailySedenteryMinVal);
		
		JLabel label_5 = new JLabel("Floors Climbed");
		label_5.setBounds(66, 413, 85, 16);
		panelDashboardView.add(label_5);
		
		JLabel label_2 = new JLabel("Sedentary Minutes");
		label_2.setBounds(45, 452, 106, 16);
		panelDashboardView.add(label_2);
		
		JLabel label_4 = new JLabel("Total Distance");
		label_4.setBounds(187, 426, 81, 16);
		panelDashboardView.add(label_4);
		
		radioCalories = new JRadioButton("Calories Burned");
		radioCalories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		radioCalories.setBounds(0, 531, 127, 25);
		panelDashboardView.add(radioCalories);
		
		radioTotalDist = new JRadioButton("Total Distance");
		radioTotalDist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (this.radioCounter()==3){;}
			}
		});
		radioTotalDist.setBounds(0, 501, 127, 25);
		panelDashboardView.add(radioTotalDist);
		
		radioActiveMin = new JRadioButton("Very Active Minutes");
		radioActiveMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		radioActiveMin.setBounds(141, 531, 127, 25);
		panelDashboardView.add(radioActiveMin);
		
		radioFloors = new JRadioButton("Floors Climbed");
		radioFloors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		radioFloors.setBounds(285, 531, 127, 25);
		panelDashboardView.add(radioFloors);
		
		JRadioButton radioSteps = new JRadioButton("Steps");
		radioSteps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		radioSteps.setBounds(285, 501, 127, 25);
		panelDashboardView.add(radioSteps);
		
		JPanel ActiveMinPanel = new JPanel();
		ActiveMinPanel.setBounds(324, 413, 112, 58);
		panelDashboardView.add(ActiveMinPanel);
		
				lblDailyVeryActMinVal = new JLabel();
				ActiveMinPanel.add(lblDailyVeryActMinVal);
				lblDailyVeryActMinVal.setHorizontalAlignment(SwingConstants.TRAILING);
				
				JLabel label_1 = new JLabel("Very Active Minutes");
				ActiveMinPanel.add(label_1);
		
		JPanel StepsPanel = new JPanel();
		StepsPanel.setBounds(445, 452, 112, 58);
		panelDashboardView.add(StepsPanel);
		
				lblDailyStepsVal = new JLabel();
				StepsPanel.add(lblDailyStepsVal);
				lblDailyStepsVal.setHorizontalAlignment(SwingConstants.TRAILING);
				
				JLabel label_3 = new JLabel("Steps");
				StepsPanel.add(label_3);
		
		JPanel CaloriesPanel = new JPanel();
		CaloriesPanel.setBounds(573, 452, 112, 58);
		panelDashboardView.add(CaloriesPanel);
		
				lblDailyCaloriesVal = new JLabel();
				CaloriesPanel.add(lblDailyCaloriesVal);
				lblDailyCaloriesVal.setHorizontalAlignment(SwingConstants.TRAILING);
				
				JLabel label = new JLabel("Calories Burned");
				CaloriesPanel.add(label);
		
		JPanel SwitchingPanel = new JPanel();
		SwitchingPanel.setBounds(38, 43, 629, 357);
		panelDashboardView.add(SwitchingPanel);
		SwitchingPanel.setLayout(new CardLayout(0, 0));
		
		JPanel OnePanel = new JPanel();
		SwitchingPanel.add(OnePanel, "name_784837328464246");
		OnePanel.setLayout(null);
		
		JPanel CaloriesOnePanel = new JPanel();
		
		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_19.setBounds(243, 142, 119, 102);
		OnePanel.add(panel_19);
		
		JPanel TwoPanel = new JPanel();
		SwitchingPanel.add(TwoPanel, "name_784837275135018");
		TwoPanel.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_14.setBounds(145, 126, 119, 102);
		TwoPanel.add(panel_14);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_13.setBounds(343, 126, 134, 108);
		TwoPanel.add(panel_13);
		
		JPanel ThreePanel = new JPanel();
		SwitchingPanel.add(ThreePanel, "name_784837286074452");
		ThreePanel.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBounds(64, 140, 119, 102);
		ThreePanel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8.setBounds(256, 140, 119, 102);
		ThreePanel.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_9.setBounds(448, 140, 119, 102);
		ThreePanel.add(panel_9);
		
		JPanel FourPanel = new JPanel();
		SwitchingPanel.add(FourPanel, "name_784837296062649");
		FourPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(242, 218, 119, 102);
		FourPanel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(242, 58, 119, 102);
		FourPanel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(430, 145, 119, 102);
		FourPanel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(69, 145, 119, 102);
		FourPanel.add(panel_4);
		
		JPanel FivePanel = new JPanel();
		SwitchingPanel.add(FivePanel, "name_784837306362861");
		FivePanel.setLayout(null);
		
		JPanel Generic1_1 = new JPanel();
		Generic1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Generic1_1.setBounds(86, 66, 119, 102);
		FivePanel.add(Generic1_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBounds(266, 70, 119, 102);
		FivePanel.add(panel_6);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_10.setBounds(459, 72, 119, 102);
		FivePanel.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_11.setBounds(176, 199, 119, 102);
		FivePanel.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_12.setBounds(381, 205, 119, 102);
		FivePanel.add(panel_12);
		
		
		JPanel SixPanel = new JPanel();
		SwitchingPanel.add(SixPanel, "name_784837317868029");
		SixPanel.setLayout(null);
		
		JPanel Generic1 = new JPanel();
		Generic1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Generic1.setBounds(64, 58, 119, 102);
		SixPanel.add(Generic1);
		
		JPanel Generic2 = new JPanel();
		Generic2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Generic2.setBounds(242, 58, 119, 102);
		SixPanel.add(Generic2);
		
		JPanel Generic3 = new JPanel();
		Generic3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Generic3.setBounds(451, 58, 119, 102);
		SixPanel.add(Generic3);
		
		JPanel Generic4 = new JPanel();
		Generic4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Generic4.setBounds(64, 218, 119, 102);
		SixPanel.add(Generic4);
		
		JPanel Generic5 = new JPanel();
		Generic5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Generic5.setBounds(242, 218, 119, 102);
		SixPanel.add(Generic5);
		
		JPanel Generic6 = new JPanel();
		Generic6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Generic6.setBounds(451, 218, 119, 102);
		SixPanel.add(Generic6);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 13, 70, 26);
		panelDashboardView.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Settings");
		menuBar.add(mnNewMenu);
		
		radioSedMin = new JRadioButton("Sedentary Minutes");
		mnNewMenu.add(radioSedMin);
		radioSedMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
	}

	/**
	 * This method implements the Best Days screen.
	 */
	private void bestDaysView() {
		JLabel lblBestDays = new JLabel("Best Days");
		lblBestDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestDays.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblBestDays.setBounds(0, 0, 720, 30);
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

	/**
	 * This method implements the Accolades screen.
	 */
	private void accoladesView() {
		JLabel lblAccolades = new JLabel("Accolades");
		lblAccolades.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccolades.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblAccolades.setBounds(0, 0, 720, 32);
		panelAccoladesView.add(lblAccolades);

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

	/**
	 * This method implements the Lifetime Totals screen.
	 */
	private void lifetimeTotalsView() {
		JLabel lblTitle = new JLabel("Lifetime Totals");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblTitle.setBounds(0, 0, 720, 32);
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
		lblLifetimeTotalsDistVal
				.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLifetimeTotalsDistVal.setBounds(260, 70, 95, 16);
		panelLifetimeTotalsView.add(lblLifetimeTotalsDistVal);

		lblLifetimeTotalsFloorsVal = new JLabel();
		lblLifetimeTotalsFloorsVal
				.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLifetimeTotalsFloorsVal.setBounds(260, 98, 95, 16);
		panelLifetimeTotalsView.add(lblLifetimeTotalsFloorsVal);

		lblLifetimeTotalsStepsVal = new JLabel();
		lblLifetimeTotalsStepsVal
				.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLifetimeTotalsStepsVal.setBounds(260, 126, 95, 16);
		panelLifetimeTotalsView.add(lblLifetimeTotalsStepsVal);
	}

	/**
	 * This method implements the Time Series screen.
	 */
	private void timeseriesView() {
		JLabel lblNewLabel = new JLabel("Time Series");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel.setBounds(0, 0, 720, 32);
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

	/**
	 * This method implements the Daily Goals screen.
	 */
	private void dailygoalsView() {
		JLabel lblDailyGoals = new JLabel("Daily Goals");
		lblDailyGoals.setForeground(Color.BLACK);
		lblDailyGoals.setBackground(Color.GRAY);
		lblDailyGoals.setHorizontalAlignment(SwingConstants.CENTER);
		lblDailyGoals.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblDailyGoals.setBounds(0, 0, 720, 28);
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

	/**
	 * This method implements the Heart Rate Zones screen.
	 */
	private void heartratezonesView() {
		JLabel lblHeartRateZones = new JLabel("Heart Rate Zones");
		lblHeartRateZones.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartRateZones.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblHeartRateZones.setBounds(0, 0, 720, 27);
		panelHeartrateZonesView.add(lblHeartRateZones);

		JLabel lblHeartRate = new JLabel("Resting Heart Rate: ");
		lblHeartRate.setBounds(30, 60, 189, 16);
		panelHeartrateZonesView.add(lblHeartRate);

		lblHeartRest = new JLabel();
		lblHeartRest.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHeartRest.setBounds(218, 60, 95, 16);
		panelHeartrateZonesView.add(lblHeartRest);

		JLabel lblNewLabel = new JLabel("Minute Total: ");
		lblNewLabel.setBounds(30, 88, 133, 16);
		panelHeartrateZonesView.add(lblNewLabel);

		lblHeartMins = new JLabel();
		lblHeartMins.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHeartMins.setBounds(218, 88, 95, 16);
		panelHeartrateZonesView.add(lblHeartMins);

		JLabel lblZoneDescriptions = new JLabel("Zone Descriptions:");
		lblZoneDescriptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblZoneDescriptions.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblZoneDescriptions.setBounds(0, 161, 460, 27);
		panelHeartrateZonesView.add(lblZoneDescriptions);

		/*
		 * lists what the heart rate 3 zones are
		 */
		JLabel lblZone = new JLabel("Zone 1: Cardio Max/Min/Minutes");
		lblZone.setBounds(30, 200, 228, 16);
		panelHeartrateZonesView.add(lblZone);

		lblHeartCardioMaxMin = new JLabel();
		lblHeartCardioMaxMin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHeartCardioMaxMin.setBounds(200, 200, 148, 16);
		panelHeartrateZonesView.add(lblHeartCardioMaxMin);

		JLabel lblZone_1 = new JLabel("Zone 2: Fat Burn Max/Min/Minutes");
		lblZone_1.setBounds(30, 228, 228, 16);
		panelHeartrateZonesView.add(lblZone_1);

		lblHeartFatBurnMaxMin = new JLabel();
		lblHeartFatBurnMaxMin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHeartFatBurnMaxMin.setBounds(200, 228, 148, 16);
		panelHeartrateZonesView.add(lblHeartFatBurnMaxMin);

		JLabel lblZone_2 = new JLabel("Zone 3: Peak Max/Min/Minutes");
		lblZone_2.setBounds(30, 256, 228, 16);
		panelHeartrateZonesView.add(lblZone_2);

		lblHeartPeakMaxMin = new JLabel();
		lblHeartPeakMaxMin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHeartPeakMaxMin.setBounds(200, 256, 148, 16);
		panelHeartrateZonesView.add(lblHeartPeakMaxMin);

		JLabel lblZone_3 = new JLabel("Zone 0: Out of Range Max/Min/Minutes");
		lblZone_3.setBounds(30, 286, 268, 16);
		panelHeartrateZonesView.add(lblZone_3);

		lblHeartOORMaxMin = new JLabel();
		lblHeartOORMaxMin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHeartOORMaxMin.setBounds(230, 286, 148, 16);
		panelHeartrateZonesView.add(lblHeartOORMaxMin);
	}

	/**
	 * This method controls page navigation, depending on button actions.
	 */
	private void actionEvents() {
		/**
		 * Switch window to Best Days screen:
		 */
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

		/**
		 * Switch window to Daily Dashboard screen:
		 */
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

		/**
		 *  Switch window to Lifetime Totals screen:
		 */
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

		/**
		 * Switch window to Daily Goals screen:
		 */
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

		/**
		 *  Switch window to Accolades screen:
		 */
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

		/**
		 *  Switch window to Timeseries screen:
		 */
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
		
		/**
		 *  Switch window to Heart Rate Zones screen:
		 */
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

	/**
	 * Sets JLabel values for Heart Rate Zones page with data from
	 * {@code HeartRateRecord}. Called when "Heart Rate Zones" menu button is
	 * clicked, as defined in {@code HRZController}. For now, zones will be left
	 * out (hardcoded in currently)
	 * 
	 * @param minutes
	 *            total minutes in all heart rate zones
	 * @param rate
	 *            resting heart rate
	 * @param cardio_max
	 *            cardio max value for zone
	 * @param fatburn_max
	 *            fat burn max value for zone
	 * @param peak_max
	 *            peak max value for zone
	 * @param cardio_min
	 *            cardio min value for zone
	 * @param fatburn_min
	 *            fatburn min value for zone
	 * @param peak_min
	 *            peak min value for zone
	 * @param cardio_minutes
	 *            cardio minutes value for zone
	 * @param fatburn_minutes
	 *            fatburn minutes value for zone
	 * @param peak_minutes
	 *            peak minutes value for zone
	 * @param oor_max
	 *            out of range max value for zone
	 * @param oor_min
	 *            out of range min value for zone
	 * @param oor_minutes
	 *            out of range minutes value for zone
	 */
	public void setHeartRateZonesFields(int minutes, int rate, int cardio_max,
			int fatburn_max, int peak_max, int cardio_min, int fatburn_min,
			int peak_min, int cardio_minutes, int fatburn_minutes,
			int peak_minutes, int oor_max, int oor_min, int oor_minutes) {
		lblHeartMins.setText(Integer.toString(minutes));
		lblHeartRest.setText(Integer.toString(rate));

		lblHeartCardioMaxMin.setText(Integer.toString(cardio_max) + "/"
				+ Integer.toString(cardio_min) + "/"
				+ Integer.toString(cardio_minutes));
		lblHeartFatBurnMaxMin.setText(Integer.toString(fatburn_max) + "/"
				+ Integer.toString(fatburn_min) + "/"
				+ Integer.toString(fatburn_minutes));
		lblHeartPeakMaxMin.setText(Integer.toString(peak_max) + "/"
				+ Integer.toString(peak_min) + "/"
				+ Integer.toString(peak_minutes));

		lblHeartOORMaxMin.setText(Integer.toString(oor_max) + "/"
				+ Integer.toString(oor_min) + "/"
				+ Integer.toString(oor_minutes));
	}

	/**
	 * Sets JLabel values for Lifetime Totals page with data from
	 * {@code LifetimeRecord}. Called when "Lifetime Totals" menu button is
	 * clicked, as defined in {@code LifetimeController}.
	 * 
	 * @param distance
	 *            lifetime total for distance traveled
	 * @param floors
	 *            lifetime total for floors climbed
	 * @param steps
	 *            lifetime total for steps taken
	 */
	public void setLifetimeTotalsFields(double distance, int floors, int steps) {
		lblLifetimeTotalsDistVal.setText(Double.toString(distance));
		lblLifetimeTotalsFloorsVal.setText(Integer.toString(floors));
		lblLifetimeTotalsStepsVal.setText(Integer.toString(steps));
	}

	/**
	 * Sets JLabel values for Daily Dashboard page with data from
	 * {@code DailyRecord} Called when application is first loaded and when
	 * "Daily Dashboard" menu button is clicked, as defined in
	 * {@code DailyDashboardController}.
	 * 
	 * @param date
	 *            date information was updated
	 * @param distance
	 *            distance traveled on date last updated
	 * @param calories
	 *            total calories burned on date last updated
	 * @param floors
	 *            total floors climbed on date last updated
	 * @param steps
	 *            total steps taken on date last updated
	 * @param veryActMin
	 *            total "very active minutes" on date last updated
	 * @param sedenteryMin
	 *            toal "sedentary minutes" on date last updated
	 */
	public void setDailyDashFields(String date, double distance, int calories,
			int floors, int steps, int veryActMin, int sedenteryMin) {
		lblLastUpdated.setText(date);
		lblDailyDistVal.setText(Double.toString(distance));
		lblDailyCaloriesVal.setText(Integer.toString(calories));
		lblDailyFloorsVal.setText(Integer.toString(floors));
		lblDailyStepsVal.setText(Integer.toString(steps));
		lblDailyVeryActMinVal.setText(Integer.toString(veryActMin));
		lblDailySedenteryMinVal.setText(Integer.toString(sedenteryMin));
	}

	/**
	 * Sets JLabel values for Best Days page with data from
	 * {@code BestDaysRecord} Called when "Best Days" menu button is clicked, as
	 * defined in {@code BestDaysController}.
	 * 
	 * @param distance
	 *            distance traveled on best day for distance
	 * @param floors
	 *            floors climbed on best day for floors
	 * @param steps
	 *            steps taken on best day for steps
	 * @param dist_date
	 *            date of farthest distance traveled
	 * @param floors_date
	 *            date of most floors climbed
	 * @param steps_date
	 *            date of most steps taken
	 */
	public void setBestDaysFields(double distance, int floors, int steps,
			String dist_date, String floors_date, String steps_date) {
		lblBestDaysDistVal.setText(Double.toString(distance));
		lblBestDaysFloorsVal.setText(Integer.toString(floors));
		lblBestDaysStepsVal.setText(Integer.toString(steps));
		lblBestDaysDistDate.setText(dist_date);
		lblBestDaysFloorsDate.setText(floors_date);
		lblBestDaysStepsDate.setText(steps_date);
	}

	/**
	 * Attaches an {@code ActionListner} object to the Lifetime Totals menu
	 * button, which executes
	 * {@code InterfaceView#setLifetimeTotalsFields(double, int, int)} upon
	 * button click event.
	 * 
	 * @param actionsOnClick
	 *            ActionListener object defined in {@link LifetimeController}
	 * 
	 */
	public void addClickListenerLifetimeTotals(ActionListener actionsOnClick) {

		// the btnLifetimeTotals.addActionListner() call is encapsulated by a
		// method
		// so that it can be accessed by the controller;
		// the controller passes in the clicklistener, which contains the method
		// that updates the view;
		// this method gets executed when the controller is initialized

		btnLifetimeTotals.addActionListener(actionsOnClick);
	}

	/**
	 * Attaches an {@code ActionListner} object to the Best Days menu button,
	 * which executes
	 * {@code InterfaceView#setBestDaysFields(double, int, int, String, String, String)}
	 * upon button click event.
	 * 
	 * @param actionsOnClick
	 *            ActionListener object defined in {@link BestDaysController}
	 * 
	 */
	public void addClickListenerBestDays(ActionListener actionsOnClick) {
		btnBestDays.addActionListener(actionsOnClick);
	}

	/**
	 * Attaches an {@code ActionListner} object to the Heart Rate Zones menu
	 * button, which executes
	 * {@code InterfaceView#setHeartRateZonesFields(int, int, int, int, int, int, int, int)}
	 * upon button click event.
	 * 
	 * @param actionsOnClick
	 *            ActionListener object defined in {@link HRZController}
	 * 
	 */
	public void addClickListenerHeartRateZones(ActionListener actionsOnClick) {
		btnHeartRateZones.addActionListener(actionsOnClick);
	}

	/**
	 * Attaches an {@code ActionListner} object to the Daily Dashboard menu
	 * button, which executes
	 * {@code InterfaceView#setDailyDashFields(String, double, int, int, int, int, int)}
	 * upon button click event.
	 * 
	 * @param actionsOnClick
	 *            ActionListener object defined in
	 *            {@link DailyDashboardController}
	 * 
	 */
	public void addClickListenerDashboard(ActionListener actionsOnClick) {
		btnDailyDashboard.addActionListener(actionsOnClick);
	}

	/**
	 * Makes the frame visible!
	 * 
	 * @param view
	 *            the view to make visible
	 */
	public void setVisible(InterfaceView view) {
		view.frame.setVisible(true);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public int radioCounter(){
		int counter = 0;
		if (radioCalories.isSelected()){
			counter += 1;
		}
		if (radioTotalDist.isSelected()){
			counter += 1;
		}
		if (radioSedMin.isSelected()){
			counter += 1;
		}
		if (radioActiveMin.isSelected()){
			counter += 1;
		}
		if (radioFloors.isSelected()){
			counter += 1;
		}
		if (radioSteps.isSelected()){
			counter += 1;
		}
		return counter;
	}
}