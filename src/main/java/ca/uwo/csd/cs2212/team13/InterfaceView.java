package ca.uwo.csd.cs2212.team13;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
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

import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.util.Date;
import java.util.Properties;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.util.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import org.jdatepicker.constraints;

import org.jdatepicker.DateModel;

import java.util.Calendar;




/**
 * {@code InterfaceView} creates the GUI of the Fitbit program.
 * It also implements page navigation between the different screens.
 */

public class InterfaceView {

	private UtilDateModel dateModel;
	
	private JFrame frame;

	/**
	 * JButtons for menu
	 */
	private JButton btnBestDays;
	private JButton btnDailyDashboard;
	private JButton btnDailyGoals;
	private JButton btnLifetimeTotals;
	private JButton btnAccolades;
	private JButton btnTimeSeries;
	private JButton btnHeartRateZones;
	private JButton btnRefresh;
	
	/**
	 * JButtons for next/previous day on calendar
	 */
	private JButton btnPrevDate;
	private JButton btnNextDate;

	/**
	 * JPanels for all pages
	 */
	private JPanel panelDashboardView;
	private JPanel panelBestDaysView;
	private JPanel panelAccoladesView;
	private JPanel panelLifetimeTotalsView;
	private JPanel panelTimeSeriesView;
	private JPanel panelDailyGoalsView;
	private JPanel panelHeartrateZonesView;
	
	/**
	 * JLabels for all values to be displayed on all pages
	 */
	private JLabel lblLifetimeTotalsDistVal;
	private JLabel lblLifetimeTotalsFloorsVal;
	private JLabel lblDailyDistVal;
	private JLabel lblLifetimeTotalsStepsVal;
	private JLabel lblDailyCaloriesVal;
	private JLabel lblDailyStepsVal;
	private JLabel lblDailyFloorsVal;
	private JLabel lblDailySedenteryMinVal;
	private JLabel lblDailyLightlyActMinVal;
	private JLabel lblDailyFairlyActMinVal;
	private JLabel lblDailyVeryActMinVal;
	private JLabel lblDailyGoalsVal;
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
	private JLabel lblHeartMins;
	private JLabel lblHeartRest;
	private JLabel lblHeartCardioMaxMin;
	private JLabel lblHeartFatBurnMaxMin;
	private JLabel lblHeartPeakMaxMin;
	private JLabel lblHeartOORMaxMin;
	
	private JLabel lblActiveMinGoal;
	private JLabel lblCaloriesGoal;
	private JLabel lblDistanceGoal;
	private JLabel lblStepsGoal;
	private JLabel lblFloorsGoal;
	
	/**
	 * Labels for comparison results between goals values and actual values
	 */
	private JLabel lblStepsCompare;
	private JLabel lblFloorsCompare;
	private JLabel lblDistanceCompare;
	private JLabel lblCaloriesCompare;
	private JLabel lblActiveMinCompare;
	
	/**
	 * Labels for the time that each page was last updated
	 */
	private JLabel lblLastUpdatedDash;
	private JLabel lblLastUpdatedBd;
	private JLabel lblLastUpdatedLt;
	private JLabel lblLastUpdatedTS;
	private JLabel lblLastUpdatedHRZ;
	private JLabel lblLastUpdatedGoals;
	private JLabel lblLastUpdatedAccolades;


	/**
	 * JPanels for the custom dashboard
	 */
	private JPanel OnePanel;
		private JPanel onePanel_1;
	private JPanel TwoPanel;
		private JPanel twoPanel_1;
		private JPanel twoPanel_2;
	private JPanel ThreePanel;
		private JPanel threePanel_1;
		private JPanel threePanel_2;
		private JPanel threePanel_3;
	private JPanel FourPanel;
		private JPanel fourPanel_1;
		private JPanel fourPanel_2;
		private JPanel fourPanel_3;
		private JPanel fourPanel_4;
	private JPanel FivePanel;
		private JPanel fivePanel_1;
		private JPanel fivePanel_2;
		private JPanel fivePanel_3;
		private JPanel fivePanel_4;
		private JPanel fivePanel_5;
	private JPanel SixPanel;
		private JPanel sixPanel_1;
		private JPanel sixPanel_2;
		private JPanel sixPanel_3;
		private JPanel sixPanel_4;
		private JPanel sixPanel_5;
		private JPanel sixPanel_6;
	
	/**
	 * Radio button menu for custom dashboard
	 */
	private JRadioButton radioTotalDist;
	private JRadioButton radioCalories;
	private JRadioButton radioSedMin;
	private JRadioButton radioActiveMin;
	private JRadioButton radioFloors;
	private JRadioButton radioSteps;
	
	/**
	 * JPanels for custom dashboard
	 */
	private JPanel dailyCaloriesPanel;
	private JPanel dailyTotalDistPanel;
	private JPanel dailyActiveMinPanel;
	private JPanel dailySedMinPanel;
	private JPanel dailyFloorsPanel;
	private JPanel dailyStepsPanel;
	
	private JPanel[] panelArray;
	
	/**
	 * JDatePickerImpl object for calendar
	 */
	private JDatePickerImpl datePicker;
	
	/**
	 * Constructor: uses initialize() method
	 */
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
		CardLayout.setBounds(0, 0, 720, 574);
		frame.getContentPane().add(CardLayout);
		CardLayout.setLayout(new CardLayout(0, 0));

		panelDashboardView = new JPanel();
		panelDashboardView.setBackground(null);
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

	/**
	 * This method implements the buttons used for page navigation. The buttons
	 * are held in a toolbar.
	 */
	private void menuBar() {
		JToolBar MenuBar = new JToolBar();
		MenuBar.setBorder(null);
		MenuBar.setBounds(720, 0, 180, 574);
		MenuBar.setFloatable(false);
		MenuBar.setBackground(null);
		MenuBar.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(MenuBar);

		btnDailyDashboard = new JButton("Daily Dashboard");
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
		// To put an image on the screen: 
		//ImageIcon whatever = new ImageIcon("path/to/image.png");
		//lblwhatever.setIcon(whatever);
		
		JLabel lblDailyDashboard = new JLabel("Daily Dashboard");
		lblDailyDashboard.setBounds(0, 0, 720, 30);
		lblDailyDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDailyDashboard.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		panelDashboardView.add(lblDailyDashboard);
		
		/**
		 * Soemthing something grid bag layout
		 */
		dailyActiveMinPanel = new JPanel();
		dailyActiveMinPanel.setBounds(374, 477, 120, 100);
		GridBagLayout gbl_dailyActiveMinPanel = new GridBagLayout();
		gbl_dailyActiveMinPanel.columnWidths = new int[]{1, 112, 0};
		gbl_dailyActiveMinPanel.rowHeights = new int[]{16, 0};
		gbl_dailyActiveMinPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_dailyActiveMinPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		dailyActiveMinPanel.setLayout(gbl_dailyActiveMinPanel);
						
		lblDailyVeryActMinVal = new JLabel();
		GridBagConstraints gbc_lblDailyVeryActMinVal = new GridBagConstraints();
		gbc_lblDailyVeryActMinVal.anchor = GridBagConstraints.SOUTH;
		gbc_lblDailyVeryActMinVal.insets = new Insets(0, 0, 0, 5);
		gbc_lblDailyVeryActMinVal.gridx = 0;
		gbc_lblDailyVeryActMinVal.gridy = 0;
		dailyActiveMinPanel.add(lblDailyVeryActMinVal, gbc_lblDailyVeryActMinVal);
		lblDailyVeryActMinVal.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel label_1 = new JLabel("Very Active Minutes");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 0;
		dailyActiveMinPanel.add(label_1, gbc_label_1);
		
		/**
		 * All the individual panels and labels for dashboard fields
		 */
		dailyStepsPanel = new JPanel();
		dailyStepsPanel.setBounds(496, 453, 120, 100);
	
		lblDailyStepsVal = new JLabel();
		dailyStepsPanel.add(lblDailyStepsVal);
		lblDailyStepsVal.setHorizontalAlignment(SwingConstants.TRAILING);
				
		JLabel label_3 = new JLabel("Steps");
		dailyStepsPanel.add(label_3);
		
		dailyCaloriesPanel = new JPanel();
		dailyCaloriesPanel.setBounds(608, 452, 120, 100);
		
		lblDailyCaloriesVal = new JLabel();
		dailyCaloriesPanel.add(lblDailyCaloriesVal);
		lblDailyCaloriesVal.setHorizontalAlignment(SwingConstants.TRAILING);
				
		JLabel label = new JLabel("Calories Burned");
		dailyCaloriesPanel.add(label);
		
		dailySedMinPanel = new JPanel();
		dailySedMinPanel.setBounds(264, 448, 120, 100);
		
		lblDailySedenteryMinVal = new JLabel();
		lblDailySedenteryMinVal.setBounds(3, 34, 97, 16);
		dailySedMinPanel.add(lblDailySedenteryMinVal);
		lblDailySedenteryMinVal.setHorizontalAlignment(SwingConstants.TRAILING);
				
		JLabel lblSedMin = new JLabel("Sedentary Minutes");
		lblSedMin.setBounds(3, 0, 106, 16);
		dailySedMinPanel.add(lblSedMin);
				
		dailyFloorsPanel = new JPanel();
		dailyFloorsPanel.setBounds(0, 448, 120, 100);
				
		JLabel lblFloorsClimbed = new JLabel("Floors Climbed");
		lblFloorsClimbed.setBounds(15, 5, 85, 16);
		dailyFloorsPanel.add(lblFloorsClimbed);
				
		lblDailyFloorsVal = new JLabel();
		lblDailyFloorsVal.setBounds(10, 34, 70, 16);
		dailyFloorsPanel.add(lblDailyFloorsVal);
		lblDailyFloorsVal.setHorizontalAlignment(SwingConstants.TRAILING);
						
		dailyTotalDistPanel = new JPanel();
		dailyTotalDistPanel.setBounds(126, 477, 120, 100);
	
						
		lblDailyDistVal = new JLabel();
		lblDailyDistVal.setBounds(19, 34, 70, 16);
		dailyTotalDistPanel.add(lblDailyDistVal);
		lblDailyDistVal.setHorizontalAlignment(SwingConstants.TRAILING);
						
		JLabel lblTotalDist = new JLabel("Total Distance");
		lblTotalDist.setBounds(19, 5, 81, 16);
		dailyTotalDistPanel.add(lblTotalDist);
		
		/**
		 * "Last Updated" Field
		 */
		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelDashboardView.add(lblLastUpdated);
		
		lblLastUpdatedDash = new JLabel();
		lblLastUpdatedDash.setBounds(486, 540, 222, 16);
		lblLastUpdatedDash.setHorizontalAlignment(SwingConstants.TRAILING);
		panelDashboardView.add(lblLastUpdatedDash);
		
		/**
		 * Switching panel is a card layout which sits underneath all of the custom layout
		 * option panels (ie. 1-panel layout, 2-panel layout etc.) and switches which one is 
		 * displayed based on user selection of radio buttons.
		 */
		JPanel SwitchingPanel = new JPanel();
		SwitchingPanel.setBounds(37, 120, 629, 357);
		panelDashboardView.add(SwitchingPanel);
		SwitchingPanel.setLayout(new CardLayout(0, 0));
		
		SwitchingPanel.setVisible(true);

		
		/**
		 * Layout panel for custom dashboard: 1-panel display
		 */
		OnePanel = new JPanel();
		SwitchingPanel.add(OnePanel, "name_784837328464246");
		OnePanel.setLayout(null);
		
		onePanel_1 = new JPanel();
		onePanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		onePanel_1.setBounds(243, 142, 120, 100);
		OnePanel.add(onePanel_1);
		
		/**
		 * Layout panel for custom dashboard: 2-panel display
		 */
		TwoPanel = new JPanel();
		SwitchingPanel.add(TwoPanel, "name_784837275135018");
		TwoPanel.setLayout(null);
		
		twoPanel_1 = new JPanel();
		twoPanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		twoPanel_1.setBounds(120, 126, 120, 100);
		TwoPanel.add(twoPanel_1);
		
		twoPanel_2 = new JPanel();
		twoPanel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		twoPanel_2.setBounds(343, 126, 120, 100);
		TwoPanel.add(twoPanel_2);
		
		/**
		 * Layout panel for custom dashboard: 3-panel display
		 */
		ThreePanel = new JPanel();
		SwitchingPanel.add(ThreePanel, "name_784837286074452");
		ThreePanel.setLayout(null);
		
		threePanel_1 = new JPanel();
		threePanel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		threePanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		threePanel_1.setBounds(64, 140, 120, 100);
		ThreePanel.add(threePanel_1);
		
		threePanel_2 = new JPanel();
		threePanel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		threePanel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		threePanel_2.setBounds(256, 140, 120, 100);
		ThreePanel.add(threePanel_2);
		
		threePanel_3 = new JPanel();
		threePanel_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		threePanel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		threePanel_3.setBounds(448, 140, 120, 100);
		ThreePanel.add(threePanel_3);
		
		/**
		 * Layout panel for custom dashboard: 4-panel display
		 */
		FourPanel = new JPanel();
		SwitchingPanel.add(FourPanel, "name_784837296062649");
		FourPanel.setLayout(null);
		
		fourPanel_1 = new JPanel();
		fourPanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fourPanel_1.setBounds(69, 145, 120, 100);
		FourPanel.add(fourPanel_1);
		
		fourPanel_2 = new JPanel();
		fourPanel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fourPanel_2.setBounds(242, 58, 120, 100);
		FourPanel.add(fourPanel_2);
		
		fourPanel_3 = new JPanel();
		fourPanel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fourPanel_3.setBounds(430, 145, 120, 100);
		FourPanel.add(fourPanel_3);
		
		fourPanel_4 = new JPanel();
		fourPanel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fourPanel_4.setBounds(242, 218, 120, 100);
		FourPanel.add(fourPanel_4);
		
		/**
		 * Layout panel for custom dashboard: 5-panel display
		 */
		FivePanel = new JPanel();
		SwitchingPanel.add(FivePanel, "name_784837306362861");
		FivePanel.setLayout(null);
		
		fivePanel_1 = new JPanel();
		fivePanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fivePanel_1.setBounds(86, 66, 120, 100);
		FivePanel.add(fivePanel_1);
		
		fivePanel_2 = new JPanel();
		fivePanel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fivePanel_2.setBounds(266, 70, 120, 100);
		FivePanel.add(fivePanel_2);
		
		fivePanel_3 = new JPanel();
		fivePanel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fivePanel_3.setBounds(459, 72, 120, 100);
		FivePanel.add(fivePanel_3);
		
		fivePanel_4 = new JPanel();
		fivePanel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fivePanel_4.setBounds(176, 199, 120, 100);
		FivePanel.add(fivePanel_4);
		
		fivePanel_5 = new JPanel();
		fivePanel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fivePanel_5.setBounds(381, 205, 120, 100);
		FivePanel.add(fivePanel_5);
		
		/**
		 * Layout panel for custom dashboard: 6-panel display
		 */
		SixPanel = new JPanel();
		SwitchingPanel.add(SixPanel, "name_784837317868029");
		SixPanel.setLayout(null);
		
		sixPanel_1 = new JPanel();
		sixPanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sixPanel_1.setBounds(64, 58, 120, 100);
		SixPanel.add(sixPanel_1);
		
		sixPanel_2 = new JPanel();
		sixPanel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sixPanel_2.setBounds(242, 58, 120, 100);
		SixPanel.add(sixPanel_2);
		
		sixPanel_3 = new JPanel();
		sixPanel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sixPanel_3.setBounds(451, 58, 120, 100);
		SixPanel.add(sixPanel_3);
		
		sixPanel_4 = new JPanel();
		sixPanel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sixPanel_4.setBounds(64, 218, 120, 100);
		SixPanel.add(sixPanel_4);
		
		sixPanel_5 = new JPanel();
		sixPanel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sixPanel_5.setBounds(242, 218, 120, 100);
		SixPanel.add(sixPanel_5);
		
		sixPanel_6 = new JPanel();
		sixPanel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sixPanel_6.setBounds(451, 218, 120, 100);
		SixPanel.add(sixPanel_6);
		
		/**
		 * Layout customization, or "settings", menu
		 */
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 13, 70, 26);
		panelDashboardView.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Settings");
		menuBar.add(mnNewMenu);
		
		radioSedMin = new JRadioButton("Sedentary Minutes");
		mnNewMenu.add(radioSedMin);
		
		radioActiveMin = new JRadioButton("Very Active Minutes");
		mnNewMenu.add(radioActiveMin);
	
		
		radioTotalDist = new JRadioButton("Total Distance");
		mnNewMenu.add(radioTotalDist);
		
		radioCalories = new JRadioButton("Calories Burned");
		mnNewMenu.add(radioCalories);
		
		radioFloors = new JRadioButton("Floors Climbed");
		mnNewMenu.add(radioFloors);
		
		/**
		 * Change which custom layout panel is being displayed based on the 
		 * count of the number of radio buttons selected in the "settings" menu.
		 */
		radioFloors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioCounter()==0){
					radioFloors.setSelected(true);
				}
				
				else if (radioFloors.isSelected()){	
					if(panelArray[radioCounter()-1]!=dailyFloorsPanel){
						int position = 0;
						for(int x=radioCounter(); x<6; x++){
							if (panelArray[x]==dailyFloorsPanel){
								position = x;
							}
						}
						JPanel switcheyPanel = panelArray[radioCounter()-1];
						panelArray[radioCounter()-1] = dailyFloorsPanel;
						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}
				
				else{
					while(panelArray[radioCounter()]!=dailyFloorsPanel){
						int position = 0;
						for(int x=0; x<radioCounter(); x++){
							if (panelArray[x]==dailyFloorsPanel){
								position = x;
							}
						}
						JPanel switcheyPanel = panelArray[position+1];
						panelArray[position+1] = dailyFloorsPanel;
						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}
			}
		});
		
		radioSteps = new JRadioButton("Steps");
		mnNewMenu.add(radioSteps);
		radioSteps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(radioCounter()==0){
				radioSteps.setSelected(true);
			}
			
			else if (radioSteps.isSelected()){	
				if(panelArray[radioCounter()-1]!=dailyStepsPanel){
					int position = 0;
					for(int x=radioCounter(); x<6; x++){
						if (panelArray[x]==dailyStepsPanel){
							position = x;
						}
					}
					JPanel switcheyPanel = panelArray[radioCounter()-1];
					panelArray[radioCounter()-1] = dailyStepsPanel;
					panelArray[position] = switcheyPanel;
				}
				repanel(radioCounter());
			}
			
			else{
				while(panelArray[radioCounter()]!=dailyStepsPanel){
					int position = 0;
					for(int x=0; x<radioCounter(); x++){
						if (panelArray[x]==dailyStepsPanel){
							position = x;
						}
					}
					JPanel switcheyPanel = panelArray[position+1];
					panelArray[position+1] = dailyStepsPanel;
					panelArray[position] = switcheyPanel;
				}
				repanel(radioCounter());
			}
		}
	});
		
		radioCalories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(radioCounter()==0){
				radioCalories.setSelected(true);
			}
			
			else if (radioCalories.isSelected()){	
				if(panelArray[radioCounter()-1]!=dailyCaloriesPanel){
					int position = 0;
					for(int x=radioCounter(); x<6; x++){
						if (panelArray[x]==dailyCaloriesPanel){
							position = x;
						}
					}
					JPanel switcheyPanel = panelArray[radioCounter()-1];
					panelArray[radioCounter()-1] = dailyCaloriesPanel;
					panelArray[position] = switcheyPanel;
				}
				repanel(radioCounter());
			}
			
			else{
				while(panelArray[radioCounter()]!=dailyCaloriesPanel){
					int position = 0;
					for(int x=0; x<radioCounter(); x++){
						if (panelArray[x]==dailyCaloriesPanel){
							position = x;
						}
					}
					JPanel switcheyPanel = panelArray[position+1];
					panelArray[position+1] = dailyCaloriesPanel;
					panelArray[position] = switcheyPanel;
				}
				repanel(radioCounter());
			}
		}
	});
		radioTotalDist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(radioCounter()==0){
				radioTotalDist.setSelected(true);
			}
			
			else if (radioTotalDist.isSelected()){	
				if(panelArray[radioCounter()-1]!=dailyTotalDistPanel){
					int position = 0;
					for(int x=radioCounter(); x<6; x++){
						if (panelArray[x]==dailyTotalDistPanel){
							position = x;
						}
					}
					JPanel switcheyPanel = panelArray[radioCounter()-1];
					panelArray[radioCounter()-1] = dailyTotalDistPanel;
					panelArray[position] = switcheyPanel;
				}
				repanel(radioCounter());
			}
			
			else{
				while(panelArray[radioCounter()]!=dailyTotalDistPanel){
					int position = 0;
					for(int x=0; x<radioCounter(); x++){
						if (panelArray[x]==dailyTotalDistPanel){
							position = x;
						}
					}
					JPanel switcheyPanel = panelArray[position+1];
					panelArray[position+1] = dailyTotalDistPanel;
					panelArray[position] = switcheyPanel;
				}
				repanel(radioCounter());
			}
		}
	});
		
		
		radioSedMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(radioCounter()==0){
				radioSedMin.setSelected(true);
			}
			
			else if (radioSedMin.isSelected()){	
				if(panelArray[radioCounter()-1]!=dailySedMinPanel){
					int position = 0;
					for(int x=radioCounter(); x<6; x++){
						if (panelArray[x]==dailySedMinPanel){
							position = x;
						}
					}
					JPanel switcheyPanel = panelArray[radioCounter()-1];
					panelArray[radioCounter()-1] = dailySedMinPanel;
					panelArray[position] = switcheyPanel;
				}
				repanel(radioCounter());
			}
			
			else{
				while(panelArray[radioCounter()]!=dailySedMinPanel){
					int position = 0;
					for(int x=0; x<radioCounter(); x++){
						if (panelArray[x]==dailySedMinPanel){
							position = x;
						}
					}
					JPanel switcheyPanel = panelArray[position+1];
					panelArray[position+1] = dailySedMinPanel;
					panelArray[position] = switcheyPanel;
				}
				repanel(radioCounter());
			}
		}
	});
		
		radioActiveMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(radioCounter()==0){
				radioActiveMin.setSelected(true);
			}
			
			else if (radioActiveMin.isSelected()){	
				if(panelArray[radioCounter()-1]!=dailyActiveMinPanel){
					int position = 0;
					for(int x=radioCounter(); x<6; x++){
						if (panelArray[x]==dailyActiveMinPanel){
							position = x;
						}
					}
					JPanel switcheyPanel = panelArray[radioCounter()-1];
					panelArray[radioCounter()-1] = dailyActiveMinPanel;
					panelArray[position] = switcheyPanel;
				}
				repanel(radioCounter());
			}
			
			else{
				while(panelArray[radioCounter()]!=dailyActiveMinPanel){
					int position = 0;
					for(int x=0; x<radioCounter(); x++){
						if (panelArray[x]==dailyActiveMinPanel){
							position = x;
						}
					}
					JPanel switcheyPanel = panelArray[position+1];
					panelArray[position+1] = dailyActiveMinPanel;
					panelArray[position] = switcheyPanel;
				}
				repanel(radioCounter());
			}
		}
	});
		

		/**
		 * Calendar implementation
		 */
		Date currentDate = new Date();
		dateModel = new UtilDateModel(currentDate);
		
		//utilModel.setDate(2000, 02, 22);
		//System.out.println(utilModel.getMonth());
		
		Properties properties = new Properties();
		properties.put("text.today", "Today");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
		
		JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, properties);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(278,43,163,26);

		//RangeConstraint range =  new RangeConstraint();
						
		panelDashboardView.add(datePicker);
												
		//SHORTCUT
		/**
		 * "Previous Date" button moves the date forward by one day on the calendar.
		 */
		btnPrevDate = new JButton("Prev");
		btnPrevDate.setBounds(217, 44, 49, 25);
		panelDashboardView.add(btnPrevDate);
						
		/**
		 * "Next Date" button moves the date forward by one day on the calendar.	
		 */
		btnNextDate = new JButton("Next");
		btnNextDate.setBounds(453, 44, 49, 25);
		panelDashboardView.add(btnNextDate);

						
													
						/////////////LOOK AT THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//////////////////
						
						/////THIS NEEDS TO BE REPLACED WITH THE ARRAY WHICH IS PASSED IN/////////
						panelArray = new JPanel[6];
						panelArray[0]=dailyActiveMinPanel;
						panelArray[1]=dailyCaloriesPanel;
						panelArray[2]=dailySedMinPanel;
						panelArray[3]=dailyFloorsPanel;
						panelArray[4]=dailyStepsPanel;
						panelArray[5]=dailyTotalDistPanel;
						////////////////////////////////////////////////////////////////
						/////ALSO MAKE SURE TO SET THE APPROPRIATE RADIOBUTTONS//////////
						radioCalories.setSelected(true);
						radioActiveMin.setSelected(true);
						

						/////////////////////////////////////////////////////////////////
						/////KEEP THIS THO.//////////////////////////////////////////////

						btnRefresh = new JButton("Refresh");
						btnRefresh.setBounds(617, 10, 91, 29);
						panelDashboardView.add(btnRefresh);
						repanel(radioCounter());
						////////////////////////////////////////////////////////////////////
						
						///Uncomment to see and change added panels in window builder.////////////////
						
						//panelDashboardView.add(dailyTotalDistPanel);
						//panelDashboardView.add(dailyActiveMinPanel);		
						//panelDashboardView.add(dailySedMinPanel);			
						//panelDashboardView.add(dailyCaloriesPanel);			
						//panelDashboardView.add(dailyFloorsPanel);			
						//panelDashboardView.add(dailyStepsPanel);	
						
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
		
		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelBestDaysView.add(lblLastUpdated);
		
		lblLastUpdatedBd = new JLabel();
		lblLastUpdatedBd.setBounds(486, 540, 222, 16);
		lblLastUpdatedBd.setHorizontalAlignment(SwingConstants.TRAILING);
		panelBestDaysView.add(lblLastUpdatedBd);
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
		
		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelAccoladesView.add(lblLastUpdated);
		
		lblLastUpdatedAccolades = new JLabel();
		lblLastUpdatedAccolades.setBounds(486, 540, 222, 16);
		lblLastUpdatedAccolades.setHorizontalAlignment(SwingConstants.TRAILING);
		panelAccoladesView.add(lblLastUpdatedAccolades);
		
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
		
		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelLifetimeTotalsView.add(lblLastUpdated);
		
		lblLastUpdatedLt = new JLabel();
		lblLastUpdatedLt.setBounds(486, 540, 222, 16);
		lblLastUpdatedLt.setHorizontalAlignment(SwingConstants.TRAILING);
		panelLifetimeTotalsView.add(lblLastUpdatedLt);
		
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
		
		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelTimeSeriesView.add(lblLastUpdated);
		
		lblLastUpdatedTS = new JLabel();
		lblLastUpdatedTS.setBounds(486, 540, 222, 16);
		lblLastUpdatedTS.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTimeSeriesView.add(lblLastUpdatedTS);
		
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

		JLabel lblActiveMin = new JLabel("Active Minutes:");
		lblActiveMin.setBounds(16, 160, 120, 16);
		panelDailyGoalsView.add(lblActiveMin);
		
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
		
		lblActiveMinGoal = new JLabel();
		lblActiveMinGoal.setBounds(150, 160, 61, 16);

		panelDailyGoalsView.add(lblActiveMinGoal);
		
		lblStepsGoal = new JLabel();
		lblStepsGoal.setBounds(150, 52, 61, 16);
		panelDailyGoalsView.add(lblStepsGoal);

		lblDistanceGoal = new JLabel();
		lblDistanceGoal.setBounds(150, 80, 61, 16);
		panelDailyGoalsView.add(lblDistanceGoal);

		lblCaloriesGoal = new JLabel();
		lblCaloriesGoal.setBounds(150, 108, 61, 16);
		panelDailyGoalsView.add(lblCaloriesGoal);

		lblFloorsGoal = new JLabel();
		lblFloorsGoal.setBounds(150, 136, 61, 16);
		panelDailyGoalsView.add(lblFloorsGoal);
		
		lblStepsCompare = new JLabel();
		lblStepsCompare.setBounds(336, 52, 61, 16);
		panelDailyGoalsView.add(lblStepsCompare);
		
		lblDistanceCompare = new JLabel();
		lblDistanceCompare.setBounds(336, 80, 61, 16);
		panelDailyGoalsView.add(lblDistanceCompare);
		
		lblCaloriesCompare = new JLabel();
		lblCaloriesCompare.setBounds(336, 108, 61, 16);
		panelDailyGoalsView.add(lblCaloriesCompare);
		
		lblFloorsCompare = new JLabel();
		lblFloorsCompare.setBounds(336, 136, 61, 16);
		panelDailyGoalsView.add(lblFloorsCompare);
		
		lblActiveMinCompare = new JLabel();
		lblActiveMinCompare.setBounds(336, 160, 61, 16);
		panelDailyGoalsView.add(lblActiveMinCompare);
		
		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelDailyGoalsView.add(lblLastUpdated);
		
		lblLastUpdatedGoals = new JLabel();
		lblLastUpdatedGoals.setBounds(486, 540, 222, 16);
		lblLastUpdatedGoals.setHorizontalAlignment(SwingConstants.TRAILING);
		panelDailyGoalsView.add(lblLastUpdatedGoals);
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
		
		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelHeartrateZonesView.add(lblLastUpdated);
		
		lblLastUpdatedHRZ = new JLabel();
		lblLastUpdatedHRZ.setBounds(486, 540, 222, 16);
		lblLastUpdatedHRZ.setHorizontalAlignment(SwingConstants.TRAILING);
		panelHeartrateZonesView.add(lblLastUpdatedHRZ);
	}

	/**
	 * This method controls page navigation, depending on button actions.
	 */
	private void actionEvents() {

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
	
	// Setters
	
	public void setLastUpdatedDash(String date){
		lblLastUpdatedDash.setText(date);
	}
	
	public void setLastUpdatedBd(String date){
		lblLastUpdatedBd.setText(date);
	}
	
	public void setLastUpdatedLt(String date){
		lblLastUpdatedLt.setText(date);
	}
	
	public void setLastUpdatedTS(String date){
		lblLastUpdatedTS.setText(date);
	}
	
	public void setLastUpdatedHRZ(String date){
		lblLastUpdatedHRZ.setText(date);
	}
	
	public void setLastUpdatedGoals(String date){
		lblLastUpdatedGoals.setText(date);
	}
	
	public void setLastUpdatedAccolades(String date){
		lblLastUpdatedAccolades.setText(date);
	}
	public void setLastUpdatedTestMode(String test){
		lblLastUpdatedDash.setText(test);
		lblLastUpdatedBd.setText(test);
		lblLastUpdatedLt.setText(test);
		lblLastUpdatedTS.setText(test);
		lblLastUpdatedHRZ.setText(test);
		lblLastUpdatedGoals.setText(test);
		lblLastUpdatedAccolades.setText(test);
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
	 * {@code DailyRecord}. Called when application is first loaded and when
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
		//lblLastUpdated.setText(date); -- this should actually be the calendar date
		lblDailyDistVal.setText(Double.toString(distance));
		lblDailyCaloriesVal.setText(Integer.toString(calories));
		lblDailyFloorsVal.setText(Integer.toString(floors));
		lblDailyStepsVal.setText(Integer.toString(steps));
		lblDailyVeryActMinVal.setText(Integer.toString(veryActMin));
		lblDailySedenteryMinVal.setText(Integer.toString(sedenteryMin));
	}

	/**
	 * Sets JLabel values for Best Days page with data from
	 * {@code BestDaysRecord}. Called when "Best Days" menu button is clicked, as
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
	 * Sets JLabel values for Daily Goasl page with data from 
	 * {@code GoalsRecord}. Called when "Daily Goals" menu button is clicked,
	 * as defined in {@code GoalsController}.
	 * @param activeMinutes
	 * 			daily goal for active minutes
	 * @param caloriesOut
	 * 			daily goal for calories burned
	 * @param distance
	 * 			daily goal for distance traveled
	 * @param floors
	 * 			daily goal for floors climbed
	 * @param steps
	 * 			daily goal for steps taken
	 * @param activeMinStatus
	 * @param caloriesStatus
	 * @param distanceStatus
	 * @param stepsStatus
	 * @param floorsStatus
	 */
	public void setDailyGoalsFields(int activeMinutes, double caloriesOut, 
			double distance, int floors, int steps, String activeMinStatus, String caloriesStatus,
			String distanceStatus, String stepsStatus, String floorsStatus) {
		lblActiveMinGoal.setText(Integer.toString(activeMinutes));
		lblCaloriesGoal.setText(Double.toString(caloriesOut));
		lblDistanceGoal.setText(Double.toString(distance));
		lblStepsGoal.setText(Integer.toString(steps));
		lblFloorsGoal.setText(Integer.toString(floors));
		
		lblActiveMinCompare.setText(activeMinStatus);
		lblCaloriesCompare.setText(caloriesStatus);
		lblDistanceCompare.setText(distanceStatus);
		lblStepsCompare.setText(stepsStatus);
		lblFloorsCompare.setText(floorsStatus);
	}
	
	// ActionListeners

	/**
	 * Attaches an {@code ActionListner} object to the calendar that will trigger
	 * API calls to change the date of the information displayed across all pages 
	 * of the application, when the user selects a new date on the calendar.
	 * 
	 * @param actionsOnClick 
	 * 			{@code ActionListener} makes API calls using the selected date and is defined in {@link Main}
	 */
	public void addCalendarDateChangeActions(ActionListener changeData) {
		
		datePicker.addActionListener(changeData);
		
	}
	
	/**
	 * Attaches an {@code ActionListner} object to the "previous" button that will trigger
	 * API calls to change the date of the information displayed across all pages 
	 * of the application to the previous day. Also attaches an {@code ActionListener} to 
	 * change the date displayed on the calendar.
	 * 
	 * @param actionsOnClick 
	 * 			{@code ActionListener} makes API calls using the date previous to the one
	 * 			currently displayed, and is defined in {@link Main}
	 */
	public void addPreviousDayActions(ActionListener changeData) {
		
		btnPrevDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dateModel.setDay(dateModel.getDay()-1);
				datePicker.getModel().setDay(datePicker.getModel().getDay());

							}
		});
		
		btnPrevDate.addActionListener(changeData);
		
	}
	
	/**
	 * Attaches an {@code ActionListner} object to the "next" button that will trigger
	 * API calls to change the date of the information displayed across all pages 
	 * of the application to the previous day.Also attaches an {@code ActionListener} to 
	 * change the date displayed on the calendar.
	 * 
	 * @param actionsOnClick 
	 * 			{@code ActionListener} makes API calls using the date one day in advance 
	 * 			of the date currently displayed, and is defined in {@link Main}
	 */
	public void addNextDayActions(ActionListener changeData) {
		
		btnNextDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					dateModel.setDay(dateModel.getDay()+1);
					datePicker.getModel().setDay(datePicker.getModel().getDay());
				}
			});
		
		btnNextDate.addActionListener(changeData);
	}
	/**
	 * Attaches an {@code ActionListner} object to the Lifetime Totals menu
	 * button, which executes
	 * {@code InterfaceView#setLifetimeTotalsFields(double, int, int)} upon
	 * button click event.
	 * 
	 * @param actionsOnClick
	 *            {@code ActionListner} object defined in {@link LifetimeController}
	 * 
	 */
	public void addClickListenerLifetimeTotals(ActionListener actionsOnClick) {

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
	 * Attaches an {@code ActionListener} object to Daily Goals menu
	 * button, which executes
	 * {@code InterfaceVie}
	 * 
	 * @param actionsOnClick 
	 * 			ActionListener object defined in {@link GoalsController}
	 */
	public void addClickListenerGoals(ActionListener actionsOnClick) {
		btnDailyGoals.addActionListener(actionsOnClick);
	}
	
	public void addListenerForRefresh(ActionListener refresh){
		btnRefresh.addActionListener(refresh);
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
	
	/**
	 * Preferences / custom layout menu for dashboard.
	 * 
	 * @param component
	 * @param popup
	 */
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
	
	/**
	 * Method to count of how many radio buttons are selected at a given time
	 * @return number of radio buttons selected in custom layout menu for dashboard.
	 */
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
	
	/**
	 * Method switches to a new layout for the custom dashboard.
	 * @param count the number of radio buttons selected in the custom layout menu for the dashboard.
	 */
	public void repanel(int count){
		switch(count){
		case 1:
			
			TwoPanel.setVisible(false);
				try{
				twoPanel_1.removeAll();
				twoPanel_2.removeAll();
				}
				catch(Exception e){}
			ThreePanel.setVisible(false);
			FourPanel.setVisible(false);
			FivePanel.setVisible(false);
			SixPanel.setVisible(false);
			
			onePanel_1.add(panelArray[0]);
			OnePanel.setVisible(true);
			
			
			break;
			
		case 2:
			OnePanel.setVisible(false);
				try{
				onePanel_1.removeAll();
				}
				catch(Exception e){}
			ThreePanel.setVisible(false);
				try{
				threePanel_1.removeAll();
				threePanel_2.removeAll();
				threePanel_3.removeAll();
				}
				catch(Exception e){}
			FourPanel.setVisible(false);
			FivePanel.setVisible(false);
			SixPanel.setVisible(false);
			
			twoPanel_1.add(panelArray[0]);
			twoPanel_2.add(panelArray[1]);
			TwoPanel.setVisible(true);
			
			break;
			
		case 3:
			OnePanel.setVisible(false);
			TwoPanel.setVisible(false);
				try{
				twoPanel_1.removeAll();
				twoPanel_2.removeAll();
				}
				catch(Exception e){}
			FourPanel.setVisible(false);
			try{
				fourPanel_1.removeAll();
				fourPanel_2.removeAll();
				fourPanel_3.removeAll();
				fourPanel_4.removeAll();
				}
				catch(Exception e){}
			FivePanel.setVisible(false);
			SixPanel.setVisible(false);
			
			
			threePanel_1.add(panelArray[0]);
			threePanel_2.add(panelArray[1]);
			threePanel_3.add(panelArray[2]);
			ThreePanel.setVisible(true);
			
			break;
			
			
		case 4:
			OnePanel.setVisible(false);
			TwoPanel.setVisible(false);
			ThreePanel.setVisible(false);
				try{
				threePanel_1.removeAll();
				threePanel_2.removeAll();
				threePanel_3.removeAll();
				}
				catch(Exception e){}
			FivePanel.setVisible(false);
				try{
				fivePanel_1.removeAll();
				fivePanel_2.removeAll();
				fivePanel_3.removeAll();
				fivePanel_4.removeAll();
				fivePanel_5.removeAll();
				}
				catch(Exception e){}
			SixPanel.setVisible(false);
			
			
			
			fourPanel_1.add(panelArray[0]);
			fourPanel_2.add(panelArray[1]);
			fourPanel_3.add(panelArray[2]);
			fourPanel_4.add(panelArray[3]);

			FourPanel.setVisible(true);
			
			break;
		
		
		
		case 5:
			OnePanel.setVisible(false);
			TwoPanel.setVisible(false);
			ThreePanel.setVisible(false);
			FourPanel.setVisible(false);
				try{
				fourPanel_1.removeAll();
				fourPanel_2.removeAll();
				fourPanel_3.removeAll();
				fourPanel_4.removeAll();
				}
				catch(Exception e){}
			SixPanel.setVisible(false);
				try{
				sixPanel_1.removeAll();
				sixPanel_2.removeAll();
				sixPanel_3.removeAll();
				sixPanel_4.removeAll();
				sixPanel_5.removeAll();
				sixPanel_6.removeAll();
				}
				catch(Exception e){}
			
				fivePanel_1.add(panelArray[0]);
				fivePanel_2.add(panelArray[1]);
				fivePanel_3.add(panelArray[2]);
				fivePanel_4.add(panelArray[3]);
				fivePanel_5.add(panelArray[4]);
			FivePanel.setVisible(true);
			break;
		
		
		case 6:
			OnePanel.setVisible(false);
			TwoPanel.setVisible(false);
			ThreePanel.setVisible(false);
			FourPanel.setVisible(false);
			FivePanel.setVisible(false);
				try{
				fivePanel_1.removeAll();
				fivePanel_2.removeAll();
				fivePanel_3.removeAll();
				fivePanel_4.removeAll();
				fivePanel_5.removeAll();
				}
				catch(Exception e){}
			
			
			sixPanel_1.add(panelArray[0]);
			sixPanel_2.add(panelArray[1]);
			sixPanel_3.add(panelArray[2]);
			sixPanel_4.add(panelArray[3]);
			sixPanel_5.add(panelArray[4]);
			sixPanel_6.add(panelArray[5]);
			SixPanel.setVisible(true);
			
			
			break;
		}
	}
	
	/**
	 * Converts the {@code UtilDateModel} object, which represents the date selected
	 * on the calendar, to a string, and returns the string.
	 * @param incrementFlag flag to determine if the day field should be incremented or decremented
	 * 		to reflect in the {@code UtilDateModel} object that date has been changed to the previous
	 * 		or next day.
	 * @return a String representing the date selected on the calendar.
	 */
	public String getStringDate(String incrementFlag){
		
		int year = dateModel.getYear();
		int day = dateModel.getDay();
		
		if(incrementFlag == "previous") day-=1;
		else if(incrementFlag == "next") day+=1;
				
		//convert int (0-11) to int(1-12) for MM
		int month = dateModel.getMonth();
		month+=1;
		
		//prefix 0 to single-digit months and days
		if (month<=9 && day<=9) return year+"-0"+month+"-0"+day;
		
		else if (month<=9)return year+"-0"+month+"-"+day;
		else if (day<=9) return year+"-"+month+"-0"+day;
		
		else return year+"-"+month+"-"+day;
	}
	//SHORTCUT
	
	/**
	 * Objects of this inner class format the date to be displayed in the calendar text box.
	 * A {@DateLabelFormatter} object is required as a parameter in the
	 * {@code JDatePickerImpl} constructor called in the {@link #dashboardView} method.
	 *
	 */
	class DateLabelFormatter extends AbstractFormatter {

	    private String datePattern = "dd-MMM-yyyy";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

	}
}