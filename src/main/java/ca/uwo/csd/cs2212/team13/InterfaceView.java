package ca.uwo.csd.cs2212.team13;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.PlotChangeListener;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
//import org.jfree.ui.Spacer;








import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JLayeredPane;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

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

import javax.swing.Icon;

import java.awt.Point;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import org.jdatepicker.constraints;







import org.jdatepicker.DateModel;

import java.util.Calendar;

import javax.swing.Icon;

/**
 * {@code InterfaceView} creates the GUI of the Fitbit program. It also
 * implements page navigation between the different screens.
 */

public class InterfaceView {

	private UtilDateModel dateModel;
	private CalendarModel<Calendar> modelForDay;

	
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
	
	/**
	 * JButtons for refresh buttons on every page
	 */
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

	private JScrollPane panelAccoladesScroll;
	private JPanel panelAccoladesDisplay;
	private JLabel[][] labels;

	private JPanel panelLifetimeTotalsView;
	private JPanel panelTimeSeriesView;
	private JPanel panelDailyGoalsView;
	private JPanel panelHeartrateZonesView;

	/**
	 * JLabels for all values to be displayed on all pages
	 */
	private JLabel lblLifetimeTotalsDistVal;
	private JLabel lblLifetimeTotalsFloorsVal;
	private JLabel lblLifetimeTotalsStepsVal;

	private SLabel lblDailyDistVal;
	private SLabel lblDailyCaloriesVal;
	private SLabel lblDailyStepsVal;
	private SLabel lblDailyFloorsVal;
	private SLabel lblDailySedenteryMinVal;
	private SLabel lblDailyVeryActMinVal;

	private JLabel lblDailyLightlyActMinVal;
	private JLabel lblDailyFairlyActMinVal;
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
	private JLabel lblHeartCardioMax;
	private JLabel lblHeartFatBurnMax;
	private JLabel lblHeartPeakMax;
	private JLabel lblHeartOORMax;
	private JLabel lblHeartCardioMin;
	private JLabel lblHeartFatBurnMin;
	private JLabel lblHeartPeakMin;
	private JLabel lblHeartOORMin;	
	private JLabel lblHeartCardioMinutes;
	private JLabel lblHeartFatBurnMinutes;
	private JLabel lblHeartPeakMinutes;
	private JLabel lblHeartOORMinutes;


	/**
	 * Label for goals
	 */
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
	 * Labels for the date of the information being displayed on date-dependent pages
	 */
	private JLabel lblDisplayDateGoals;
	private JLabel lblDisplayDateHRZ;
	private JLabel lblDisplayDateTS;

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
	private SPanel dailyCaloriesPanel;
	private SPanel dailyTotalDistPanel;
	private SPanel dailyActiveMinPanel;
	private SPanel dailySedMinPanel;
	private SPanel dailyFloorsPanel;
	private SPanel dailyStepsPanel;
	private SPanel[] panelArray;

	
	/**
	 * For graphs
	 */
	private JPanel distpanel;
	private JPanel panelGraph;
	private ChartPanel chartPanel;
	
	/**
	 * Constraints for calendar
	 * rc is for interface
	 * rc_2 is for API calls next/prev
	 */
	private RangeConstraint rc;

	/**
	 * JDatePickerImpl object for calendar
	 */
	private JDatePickerNew datePicker;
	private JDatePanelNew datePanel;
	private JLabel lblPic_1;
	private JLabel lblNewLabel_1;
	private JButton button;
	private JLabel lblClickAndDrag;


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
		
		Calendar todayPlus = Calendar.getInstance();
		Calendar todayMinusThreeYear = Calendar.getInstance();
		todayMinusThreeYear.add(Calendar.YEAR, -3);
		rc = new RangeConstraint(todayMinusThreeYear, todayPlus);

		
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

		btnDailyDashboard = new JButton("");
		btnDailyDashboard.setRolloverSelectedIcon(new ImageIcon("src/main/resources/DDselect.png"));
		btnDailyDashboard.setRolloverIcon(new ImageIcon("src/main/resources/DDselect.png"));
		btnDailyDashboard.setSelectedIcon(new ImageIcon("src/main/resources/DDselect.png"));
		btnDailyDashboard.setIcon(new ImageIcon("src/main/resources/DailyDashboard.png"));
		btnDailyDashboard.setMargin(new Insets(0, 0, 0, 0));
		btnDailyDashboard.setMaximumSize(new Dimension(180, 82));
		btnDailyDashboard.setBorder(null);
		MenuBar.add(btnDailyDashboard);
		btnDailyDashboard.setSelected(true);

		btnBestDays = new JButton("");
		btnBestDays.setRolloverSelectedIcon(new ImageIcon("src/main/resources/BestDaysSelect.png"));
		btnBestDays.setRolloverIcon(new ImageIcon("src/main/resources/BestDaysSelect.png"));
		btnBestDays.setSelectedIcon(new ImageIcon("src/main/resources/BestDaysSelect.png"));
		btnBestDays.setIcon(new ImageIcon("src/main/resources/BestDays.png"));
		btnBestDays.setMargin(new Insets(0, 0, 0, 0));
		btnBestDays.setMaximumSize(new Dimension(180, 82));
		btnBestDays.setBorder(null);
		MenuBar.add(btnBestDays);

		btnDailyGoals = new JButton("");
		btnDailyGoals.setRolloverSelectedIcon(new ImageIcon("src/main/resources/DailyGoalsSelected.png"));
		btnDailyGoals.setRolloverIcon(new ImageIcon("src/main/resources/DailyGoalsSelected.png"));
		btnDailyGoals.setSelectedIcon(new ImageIcon("src/main/resources/DailyGoalsSelected.png"));
		btnDailyGoals.setIcon(new ImageIcon("src/main/resources/DailyGoals.png"));
		btnDailyGoals.setMargin(new Insets(0, 0, 0, 0));
		btnDailyGoals.setMaximumSize(new Dimension(180, 82));
		btnDailyGoals.setBorder(null);
		MenuBar.add(btnDailyGoals);

		btnLifetimeTotals = new JButton("");
		btnLifetimeTotals.setRolloverSelectedIcon(new ImageIcon("src/main/resources/lifetimeTotalsSelect.png"));
		btnLifetimeTotals.setRolloverIcon(new ImageIcon("src/main/resources/lifetimeTotalsSelect.png"));
		btnLifetimeTotals.setSelectedIcon(new ImageIcon("src/main/resources/lifetimeTotalsSelect.png"));
		btnLifetimeTotals.setIcon(new ImageIcon("src/main/resources/lifetime totals.png"));
		btnLifetimeTotals.setMargin(new Insets(0, 0, 0, 0));
		btnLifetimeTotals.setMaximumSize(new Dimension(180, 82));
		btnLifetimeTotals.setBorder(null);
		MenuBar.add(btnLifetimeTotals);

		btnAccolades = new JButton("");
		btnAccolades.setRolloverSelectedIcon(new ImageIcon("src/main/resources/accoladeSelect.png"));
		btnAccolades.setRolloverIcon(new ImageIcon("src/main/resources/accoladeSelect.png"));
		btnAccolades.setSelectedIcon(new ImageIcon("src/main/resources/accoladeSelect.png"));
		btnAccolades.setIcon(new ImageIcon("src/main/resources/accolades.png"));
		btnAccolades.setMargin(new Insets(0, 0, 0, 0));
		btnAccolades.setMaximumSize(new Dimension(180, 82));
		btnAccolades.setBorder(null);
		MenuBar.add(btnAccolades);

		btnTimeSeries = new JButton("");
		btnTimeSeries.setRolloverSelectedIcon(new ImageIcon("src/main/resources/timeseriesSelected.png"));
		btnTimeSeries.setRolloverIcon(new ImageIcon("src/main/resources/timeseriesSelected.png"));
		btnTimeSeries.setSelectedIcon(new ImageIcon("src/main/resources/timeseriesSelected.png"));
		btnTimeSeries.setMargin(new Insets(0, 0, 0, 0));
		btnTimeSeries.setIcon(new ImageIcon("src/main/resources/timeseriesbutton.png"));
		btnTimeSeries.setMaximumSize(new Dimension(180, 82));
		btnTimeSeries.setBorder(null);
		MenuBar.add(btnTimeSeries);

		btnHeartRateZones = new JButton("");
		btnHeartRateZones.setRolloverSelectedIcon(new ImageIcon("src/main/resources/HRZ-select.png"));
		btnHeartRateZones.setRolloverIcon(new ImageIcon("src/main/resources/HRZ-select.png"));
		btnHeartRateZones.setSelectedIcon(new ImageIcon("src/main/resources/HRZ-select.png"));
		btnHeartRateZones.setIcon(new ImageIcon("src/main/resources/HRZ.png"));
		btnHeartRateZones.setMargin(new Insets(0, 0, 0, 0));
		btnHeartRateZones.setMaximumSize(new Dimension(180, 82));
		btnHeartRateZones.setBorder(null);
		MenuBar.add(btnHeartRateZones);

	}

	/**
	 * This method implements the Dashboard screen.
	 */
	private void dashboardView() {

		panelDashboardView.setLayout(null);

		/**
		 * Soemthing something grid bag layout
		 */
		dailyActiveMinPanel = new SPanel();
		dailyActiveMinPanel.setBounds(374, 477, 120, 100);
		GridBagLayout gbl_dailyActiveMinPanel = new GridBagLayout();
		gbl_dailyActiveMinPanel.columnWidths = new int[]{1, 112, 0};
		gbl_dailyActiveMinPanel.rowHeights = new int[]{16, 0};
		gbl_dailyActiveMinPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_dailyActiveMinPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		dailyActiveMinPanel.setLayout(gbl_dailyActiveMinPanel);

		lblDailyVeryActMinVal = new SLabel();
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
		dailyStepsPanel = new SPanel();
		dailyStepsPanel.setBounds(496, 453, 120, 100);

		lblDailyStepsVal = new SLabel();
		dailyStepsPanel.add(lblDailyStepsVal);
		lblDailyStepsVal.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel label_3 = new JLabel("Steps");
		dailyStepsPanel.add(label_3);

		dailyCaloriesPanel = new SPanel();
		dailyCaloriesPanel.setBounds(608, 452, 120, 100);

		lblDailyCaloriesVal = new SLabel();
		dailyCaloriesPanel.add(lblDailyCaloriesVal);
		lblDailyCaloriesVal.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel label = new JLabel("Calories Burned");
		dailyCaloriesPanel.add(label);

		dailySedMinPanel = new SPanel();
		dailySedMinPanel.setBounds(264, 448, 120, 100);

		lblDailySedenteryMinVal = new SLabel();
		lblDailySedenteryMinVal.setBounds(3, 34, 97, 16);
		dailySedMinPanel.add(lblDailySedenteryMinVal);
		lblDailySedenteryMinVal.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel lblSedMin = new JLabel("Sedentary Minutes");
		lblSedMin.setBounds(3, 0, 106, 16);
		dailySedMinPanel.add(lblSedMin);

		dailyFloorsPanel = new SPanel();
		dailyFloorsPanel.setBounds(0, 448, 120, 100);

		JLabel lblFloorsClimbed = new JLabel("Floors Climbed");
		lblFloorsClimbed.setBounds(15, 5, 85, 16);
		dailyFloorsPanel.add(lblFloorsClimbed);

		lblDailyFloorsVal = new SLabel();
		lblDailyFloorsVal.setBounds(10, 34, 70, 16);
		dailyFloorsPanel.add(lblDailyFloorsVal);
		lblDailyFloorsVal.setHorizontalAlignment(SwingConstants.TRAILING);

		dailyTotalDistPanel = new SPanel();
		dailyTotalDistPanel.setBounds(126, 477, 120, 100);


		lblDailyDistVal = new SLabel();
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
		lblLastUpdated.setForeground(Color.WHITE);
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelDashboardView.add(lblLastUpdated);

		lblLastUpdatedDash = new JLabel();
		lblLastUpdatedDash.setForeground(Color.WHITE);
		lblLastUpdatedDash.setBounds(486, 540, 222, 16);
		lblLastUpdatedDash.setHorizontalAlignment(SwingConstants.TRAILING);
		panelDashboardView.add(lblLastUpdatedDash);

		/**
		 * Switching panel is a card layout which sits underneath all of the custom layout
		 * option panels (ie. 1-panel layout, 2-panel layout etc.) and switches which one is 
		 * displayed based on user selection of radio buttons.
		 */
		JPanel SwitchingPanel = new JPanel();
		SwitchingPanel.setBounds(40, 160, 640, 360);
		panelDashboardView.add(SwitchingPanel);
		SwitchingPanel.setLayout(new CardLayout(0, 0));

		SwitchingPanel.setVisible(true);

		/**
		 * Layout panel for custom dashboard: 1-panel display
		 */
		OnePanel = new JPanel();
		SwitchingPanel.add(OnePanel, "name_784837328464246");
		OnePanel.setLayout(null);

		onePanel_1 = new BackgroundPanel();
		onePanel_1.setBounds(240, 108, 160, 144);
		OnePanel.add(onePanel_1);
		// Add image:
		JLabel lblPic_1 = new JLabel(new ImageIcon("src/main/resources/rect.png"));
		OnePanel.add(lblPic_1);
		lblPic_1.setBounds(0, 0, 640, 360);
		lblPic_1.setOpaque(false);

		/**
		 * Layout panel for custom dashboard: 2-panel display
		 */
		TwoPanel = new JPanel();
		SwitchingPanel.add(TwoPanel, "name_784837275135018");
		TwoPanel.setLayout(null);

		twoPanel_1 = new BackgroundPanel();
		twoPanel_1.setBounds(107, 108, 160, 144);
		TwoPanel.add(twoPanel_1);

		twoPanel_2 = new BackgroundPanel();
		twoPanel_2.setBounds(374, 108, 160, 144);		
		TwoPanel.add(twoPanel_2);
		// Add image:
		JLabel lblPic_2 = new JLabel(new ImageIcon("src/main/resources/rect.png"));
		TwoPanel.add(lblPic_2);
		lblPic_2.setBounds(0, 0, 640, 360);
		lblPic_2.setOpaque(false);

		/**
		 * Layout panel for custom dashboard: 3-panel display
		 */
		ThreePanel = new JPanel();
		SwitchingPanel.add(ThreePanel, "name_784837286074452");
		ThreePanel.setLayout(null);

		threePanel_1 = new BackgroundPanel();
		threePanel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		threePanel_1.setBounds(40, 108, 160, 144);
		ThreePanel.add(threePanel_1);

		threePanel_2 = new BackgroundPanel();
		threePanel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		threePanel_2.setBounds(240, 108, 160, 144);
		ThreePanel.add(threePanel_2);

		threePanel_3 = new BackgroundPanel();
		threePanel_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		threePanel_3.setBounds(440, 108, 160, 144);
		ThreePanel.add(threePanel_3);

		// Add image:
		JLabel lblPic_3 = new JLabel(new ImageIcon("src/main/resources/rect.png"));
		ThreePanel.add(lblPic_3);
		lblPic_3.setBounds(0, 0, 640, 360);
		lblPic_3.setOpaque(false);

		/**
		 * Layout panel for custom dashboard: 4-panel display
		 */
		FourPanel = new JPanel();
		SwitchingPanel.add(FourPanel, "name_784837296062649");
		FourPanel.setLayout(null);

		fourPanel_1 = new BackgroundPanel();
		fourPanel_1.setBounds(107, 24, 160, 144);
		FourPanel.add(fourPanel_1);

		fourPanel_2 = new BackgroundPanel();
		fourPanel_2.setBounds(374, 24, 160, 144);
		FourPanel.add(fourPanel_2);

		fourPanel_3 = new BackgroundPanel();
		fourPanel_3.setBounds(107, 192, 160, 144);
		FourPanel.add(fourPanel_3);

		fourPanel_4 = new BackgroundPanel();
		fourPanel_4.setBounds(374, 192, 160, 144);
		FourPanel.add(fourPanel_4);

		// Add image:
		JLabel lblPic_4 = new JLabel(new ImageIcon("src/main/resources/rect.png"));
		FourPanel.add(lblPic_4);
		lblPic_4.setBounds(0, 0, 640, 360);
		lblPic_4.setOpaque(false);

		/**
		 * Layout panel for custom dashboard: 5-panel display
		 */
		FivePanel = new JPanel();
		SwitchingPanel.add(FivePanel, "name_784837306362861");
		FivePanel.setLayout(null);

		fivePanel_1 = new BackgroundPanel();
		fivePanel_1.setBounds(40, 24, 160, 144);
		FivePanel.add(fivePanel_1);

		fivePanel_2 = new BackgroundPanel();
		fivePanel_2.setBounds(240, 24, 160, 144);
		FivePanel.add(fivePanel_2);

		fivePanel_3 = new BackgroundPanel();
		fivePanel_3.setBounds(440, 24, 160, 144);
		FivePanel.add(fivePanel_3);

		fivePanel_4 = new BackgroundPanel();
		fivePanel_4.setBounds(107, 192, 160, 144);
		FivePanel.add(fivePanel_4);

		fivePanel_5 = new BackgroundPanel();
		fivePanel_5.setBounds(374, 192, 160, 144);
		FivePanel.add(fivePanel_5);

		// Add image:
		JLabel lblPic_5 = new JLabel(new ImageIcon("src/main/resources/rect.png"));
		FivePanel.add(lblPic_5);
		lblPic_5.setBounds(0, 0, 640, 360);
		lblPic_5.setOpaque(false);

		/**
		 * Layout panel for custom dashboard: 6-panel display
		 */
		SixPanel = new JPanel();
		SwitchingPanel.add(SixPanel, "name_784837317868029");
		SixPanel.setLayout(null);

		sixPanel_1 = new BackgroundPanel();
		sixPanel_1.setBounds(40, 24, 160, 144);
		SixPanel.add(sixPanel_1);
		sixPanel_1.setLayout(null);

		sixPanel_2 = new BackgroundPanel();
		sixPanel_2.setBounds(240, 24, 160, 144);
		SixPanel.add(sixPanel_2);

		sixPanel_3 = new BackgroundPanel();
		sixPanel_3.setBounds(new Rectangle(0, 0, 180, 160));
		sixPanel_3.setBounds(440, 24, 160, 144);
		SixPanel.add(sixPanel_3);

		sixPanel_4 = new BackgroundPanel();
		sixPanel_4.setBounds(new Rectangle(0, 0, 180, 160));
		sixPanel_4.setBounds(40, 192, 160, 144);
		SixPanel.add(sixPanel_4);

		sixPanel_5 = new BackgroundPanel();
		sixPanel_5.setBounds(new Rectangle(0, 0, 180, 160));
		sixPanel_5.setBounds(240, 192, 160, 144);
		SixPanel.add(sixPanel_5);

		sixPanel_6 = new BackgroundPanel();
		sixPanel_6.setBounds(new Rectangle(0, 0, 180, 160));
		sixPanel_6.setBounds(440, 192, 160, 144);
		SixPanel.add(sixPanel_6);

		// Add image:
		JLabel lblPic_6 = new JLabel(new ImageIcon("src/main/resources/rect.png"));
		SixPanel.add(lblPic_6);
		lblPic_6.setBounds(0, 0, 640, 360);
		lblPic_6.setOpaque(false);

		/**
		 * Layout customization, or "settings", menu
		 */
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(40, 10, 50, 50);
		panelDashboardView.add(menuBar);

		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setRolloverEnabled(true);
		mnNewMenu.setRolloverIcon(new ImageIcon("src/main/resources/rotatedGear.png"));
		mnNewMenu.setBorder(null);
		mnNewMenu.setBackground(Color.BLACK);
		mnNewMenu.setIconTextGap(0);
		mnNewMenu.setIcon(new ImageIcon("src/main/resources/settings.png"));
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
				if (radioCounter() == 0) {
					radioFloors.setSelected(true);
				}

				else if (radioFloors.isSelected()) {
					if (panelArray[radioCounter() - 1] != dailyFloorsPanel) {
						int position = 0;
						for (int x = radioCounter(); x < 6; x++) {
							if (panelArray[x] == dailyFloorsPanel) {
								position = x;
							}
						}
						SPanel switcheyPanel = panelArray[radioCounter() - 1];
						panelArray[radioCounter() - 1] = dailyFloorsPanel;
						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}

				else {
					while (panelArray[radioCounter()] != dailyFloorsPanel) {

						int position = 0;
						for (int x = 0; x < radioCounter(); x++) {
							if (panelArray[x] == dailyFloorsPanel) {
								position = x;
							}
						}
						SPanel switcheyPanel = panelArray[position + 1];
						panelArray[position + 1] = dailyFloorsPanel;
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
				if (radioCounter() == 0) {
					radioSteps.setSelected(true);
				}

				else if (radioSteps.isSelected()) {
					if (panelArray[radioCounter() - 1] != dailyStepsPanel) {
						int position = 0;
						for (int x = radioCounter(); x < 6; x++) {
							if (panelArray[x] == dailyStepsPanel) {
								position = x;
							}
						}
						SPanel switcheyPanel = panelArray[radioCounter() - 1];
						panelArray[radioCounter() - 1] = dailyStepsPanel;

						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}
				else {
					while (panelArray[radioCounter()] != dailyStepsPanel) {
						int position = 0;
						for (int x = 0; x < radioCounter(); x++) {
							if (panelArray[x] == dailyStepsPanel) {
								position = x;
							}
						}
						SPanel switcheyPanel = panelArray[position + 1];
						panelArray[position + 1] = dailyStepsPanel;

						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}
			}
		});

		radioCalories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioCounter() == 0) {
					radioCalories.setSelected(true);
				}

				else if (radioCalories.isSelected()) {
					if (panelArray[radioCounter() - 1] != dailyCaloriesPanel) {
						int position = 0;
						for (int x = radioCounter(); x < 6; x++) {
							if (panelArray[x] == dailyCaloriesPanel) {
								position = x;
							}
						}
						SPanel switcheyPanel = panelArray[radioCounter() - 1];
						panelArray[radioCounter() - 1] = dailyCaloriesPanel;

						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}
				else {
					while (panelArray[radioCounter()] != dailyCaloriesPanel) {
						int position = 0;
						for (int x = 0; x < radioCounter(); x++) {
							if (panelArray[x] == dailyCaloriesPanel) {
								position = x;
							}
						}
						SPanel switcheyPanel = panelArray[position + 1];
						panelArray[position + 1] = dailyCaloriesPanel;

						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}
			}
		});
		radioTotalDist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (radioCounter() == 0) {
					radioTotalDist.setSelected(true);
				}

				else if (radioTotalDist.isSelected()) {
					if (panelArray[radioCounter() - 1] != dailyTotalDistPanel) {
						int position = 0;
						for (int x = radioCounter(); x < 6; x++) {
							if (panelArray[x] == dailyTotalDistPanel) {
								position = x;
							}
						}
						SPanel switcheyPanel = panelArray[radioCounter() - 1];
						panelArray[radioCounter() - 1] = dailyTotalDistPanel;

						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}


				else {
					while (panelArray[radioCounter()] != dailyTotalDistPanel) {
						int position = 0;
						for (int x = 0; x < radioCounter(); x++) {
							if (panelArray[x] == dailyTotalDistPanel) {
								position = x;
							}
						}
						SPanel switcheyPanel = panelArray[position + 1];
						panelArray[position + 1] = dailyTotalDistPanel;
						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}
			}
		});

		radioSedMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioCounter() == 0) {
					radioSedMin.setSelected(true);
				}

				else if (radioSedMin.isSelected()) {
					if (panelArray[radioCounter() - 1] != dailySedMinPanel) {
						int position = 0;
						for (int x = radioCounter(); x < 6; x++) {
							if (panelArray[x] == dailySedMinPanel) {
								position = x;
							}
						}
						SPanel switcheyPanel = panelArray[radioCounter() - 1];
						panelArray[radioCounter() - 1] = dailySedMinPanel;
						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}
				else {
					while (panelArray[radioCounter()] != dailySedMinPanel) {
						int position = 0;
						for (int x = 0; x < radioCounter(); x++) {
							if (panelArray[x] == dailySedMinPanel) {
								position = x;
							}
						}
						SPanel switcheyPanel = panelArray[position + 1];
						panelArray[position + 1] = dailySedMinPanel;

						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}
			}
		});

		radioActiveMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioCounter() == 0) {
					radioActiveMin.setSelected(true);
				}

				else if (radioActiveMin.isSelected()) {
					if (panelArray[radioCounter() - 1] != dailyActiveMinPanel) {
						int position = 0;
						for (int x = radioCounter(); x < 6; x++) {
							if (panelArray[x] == dailyActiveMinPanel) {
								position = x;
							}
						}
						SPanel switcheyPanel = panelArray[radioCounter() - 1];
						panelArray[radioCounter() - 1] = dailyActiveMinPanel;
						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}
				else {
					while (panelArray[radioCounter()] != dailyActiveMinPanel) {
						int position = 0;
						for (int x = 0; x < radioCounter(); x++) {
							if (panelArray[x] == dailyActiveMinPanel) {
								position = x;
							}
						}
						SPanel switcheyPanel = panelArray[position + 1];
						panelArray[position + 1] = dailyActiveMinPanel;

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
		
		Calendar calForDay = Calendar.getInstance();
		modelForDay = new DefaultCalendarModel(calForDay);
				
		//utilModel.setDate(2000, 02, 22);
		//System.out.println(utilModel.getMonth());
		
		Properties properties = new Properties();
		properties.put("text.today", "Today");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
				
		datePanel = new JDatePanelNew(modelForDay, properties);
		datePicker = new JDatePickerNew(datePanel, new DateLabelFormatter());
		datePicker.setBackground(Color.DARK_GRAY);
		datePicker.setBounds(284,105,163,30);

		//RangeConstraint range =  new RangeConstraint();
						
		panelDashboardView.add(datePicker);
												
		//SHORTCUT

		/**
		 * "Previous Date" button moves the date forward by one day on the calendar.
		 */
		btnPrevDate = new JButton("");
		btnPrevDate.setRolloverIcon(new ImageIcon("src/main/resources/larrowWhite.png"));
		btnPrevDate.setIcon(new ImageIcon("src/main/resources/LArrow.png"));
		btnPrevDate.setOpaque(true);
		btnPrevDate.setBounds(217, 93, 50, 50);
		panelDashboardView.add(btnPrevDate);
						
		/**
		 * "Next Date" button moves the date forward by one day on the calendar.	
		 */
		btnNextDate = new JButton("");
		btnNextDate.setRolloverIcon(new ImageIcon("src/main/resources/rArrowWhite.png"));
		btnNextDate.setIcon(new ImageIcon("src/main/resources/rArrow.png"));
		btnNextDate.setOpaque(true);
		btnNextDate.setBounds(460, 93, 50, 50);
		panelDashboardView.add(btnNextDate);


		/////////////LOOK AT THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//////////////////

		/////THIS NEEDS TO BE REPLACED WITH THE ARRAY WHICH IS PASSED IN/////////

		/**

						panelArray = new SPanel[6];
						panelArray[0]=dailyActiveMinPanel;
						panelArray[1]=dailyCaloriesPanel;
						panelArray[2]=dailySedMinPanel;
						panelArray[3]=dailyFloorsPanel;
						panelArray[4]=dailyStepsPanel;
						panelArray[5]=dailyTotalDistPanel;
		 */
		////////////////////////////////////////////////////////////////
		/////ALSO MAKE SURE TO SET THE APPROPRIATE RADIOBUTTONS//////////



		SettingsRecord sr = null;

		WriterReader wr = new WriterReader();
		try {
			System.out.println("Reading in SettingsRecord from File\n");
			sr = (SettingsRecord) wr
					.loadRecord("src/main/resources/settingsrecord");		
			load_settings(sr);
		} catch (Exception e) {
			System.out.println("Could not read SettingsRecord from File");

			panelArray = new SPanel[6];
			panelArray[0]=dailyActiveMinPanel;
			panelArray[1]=dailyCaloriesPanel;
			panelArray[2]=dailySedMinPanel;
			panelArray[3]=dailyFloorsPanel;
			panelArray[4]=dailyStepsPanel;
			panelArray[5]=dailyTotalDistPanel;

			radioCalories.setSelected(true);
			radioActiveMin.setSelected(true);
		}

		//radioCalories.setSelected(true);
		//radioActiveMin.setSelected(true);

		/////////////////////////////////////////////////////////////////
		/////KEEP THIS THO.//////////////////////////////////////////////

		btnRefresh = new JButton("");
		btnRefresh.setRolloverIcon(new ImageIcon("src/main/resources/refrot.png"));
		btnRefresh.setIcon(new ImageIcon("src/main/resources/refreshButton.png"));
		btnRefresh.setBounds(630, 10, 50, 50);
		panelDashboardView.add(btnRefresh);
		repanel(radioCounter());
		////////////////////////////////////////////////////////////////////

		//---
		/**
		 * Background Image Implementation
		 */
		JLabel lblPic = new JLabel(new ImageIcon("src/main/resources/DDdash.png"));
		lblPic.setBounds(0, 0, 720, 574);
		panelDashboardView.add(lblPic);
	}

	private void load_settings(SettingsRecord sr)
	{

		if(sr.isRadioTotalDist())
			radioTotalDist.setSelected(true);

		if(sr.isRadioCalories())
			radioCalories.setSelected(true);

		if(sr.isRadioSedMin())
			radioSedMin.setSelected(true);

		if(sr.isRadioActiveMin())
			radioActiveMin.setSelected(true);

		if(sr.isRadioFloors())
			radioFloors.setSelected(true);

		if(sr.isRadioSteps())
			radioSteps.setSelected(true);

		panelArray = sr.getPanelArray();
		dailyCaloriesPanel = sr.getDailyCaloriesPanel();
		dailyTotalDistPanel = sr.getDailyTotalDistPanel();
		dailyActiveMinPanel = sr.getDailyActiveMinPanel();
		dailySedMinPanel = sr.getDailySedMinPanel();
		dailyFloorsPanel = sr.getDailyFloorsPanel();
		dailyStepsPanel = sr.getDailyStepsPanel();
		
		lblDailyDistVal = sr.getLblDailyDistVal();
		lblDailyCaloriesVal = sr.getLblDailyCaloriesVal();
		lblDailyStepsVal = sr.getLblDailyStepsVal();
		lblDailyFloorsVal = sr.getLblDailyFloorsVal();
		lblDailySedenteryMinVal = sr.getLblDailySedenteryMinVal();
		lblDailyVeryActMinVal = sr.getLblDailyVeryActMinVal();
	}

	private void save_settings()
	{

		WriterReader wr = new WriterReader();
		boolean dist = (radioTotalDist.isSelected());
		boolean calories = (radioCalories.isSelected());
		boolean sedMin = (radioSedMin.isSelected());
		boolean activeMin = (radioActiveMin.isSelected());
		boolean floors = (radioFloors.isSelected());
		boolean steps = (radioSteps.isSelected());
		
		SettingsRecord sr = new SettingsRecord(dist, calories, sedMin, activeMin, floors, steps, panelArray, radioCounter(), dailyCaloriesPanel, dailyTotalDistPanel, dailyActiveMinPanel, dailySedMinPanel, dailyFloorsPanel, dailyStepsPanel,	lblDailyDistVal, lblDailyCaloriesVal, lblDailyStepsVal, lblDailyFloorsVal, lblDailySedenteryMinVal, lblDailyVeryActMinVal);
		try {
			wr.writeRecord(sr, "settingsrecord");
		} catch (Exception e) {
			System.out.println("Could not write to file");
		}

	}

	/**
	 * This method implements the Best Days screen.
	 */
	private void bestDaysView() {
		
		lblBestDaysDistVal = new JLabel();
		lblBestDaysDistVal.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblBestDaysDistVal.setForeground(Color.WHITE);
		lblBestDaysDistVal.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestDaysDistVal.setBounds(474, 375, 184, 112);
		panelBestDaysView.add(lblBestDaysDistVal);

		lblBestDaysDistDate = new JLabel();
		lblBestDaysDistDate.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblBestDaysDistDate.setForeground(Color.WHITE);
		lblBestDaysDistDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestDaysDistDate.setBounds(484, 321, 162, 42);
		panelBestDaysView.add(lblBestDaysDistDate);

		lblBestDaysFloorsVal = new JLabel();
		lblBestDaysFloorsVal.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblBestDaysFloorsVal.setForeground(Color.WHITE);
		lblBestDaysFloorsVal.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestDaysFloorsVal.setBounds(268, 375, 184, 112);
		panelBestDaysView.add(lblBestDaysFloorsVal);

		lblBestDaysFloorsDate = new JLabel();
		lblBestDaysFloorsDate.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblBestDaysFloorsDate.setForeground(Color.WHITE);
		lblBestDaysFloorsDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestDaysFloorsDate.setBounds(280, 321, 162, 42);
		panelBestDaysView.add(lblBestDaysFloorsDate);

		lblBestDaysStepsVal = new JLabel();
		lblBestDaysStepsVal.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblBestDaysStepsVal.setForeground(Color.WHITE);
		lblBestDaysStepsVal.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestDaysStepsVal.setBounds(62, 375, 184, 112);
		panelBestDaysView.add(lblBestDaysStepsVal);

		lblBestDaysStepsDate = new JLabel();
		lblBestDaysStepsDate.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblBestDaysStepsDate.setForeground(Color.WHITE);
		lblBestDaysStepsDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestDaysStepsDate.setBounds(74, 321, 162, 42);
		panelBestDaysView.add(lblBestDaysStepsDate);

		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setForeground(Color.WHITE);
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelBestDaysView.add(lblLastUpdated);

		lblLastUpdatedBd = new JLabel();
		lblLastUpdatedBd.setForeground(Color.WHITE);
		lblLastUpdatedBd.setBounds(486, 540, 222, 16);
		lblLastUpdatedBd.setHorizontalAlignment(SwingConstants.TRAILING);
		panelBestDaysView.add(lblLastUpdatedBd);
		
		/**
		 * Background Image Implementation
		 */
		JLabel lblPic = new JLabel(new ImageIcon("src/main/resources/BDdash.png"));
		lblPic.setBounds(0, 0, 720, 574);
		panelBestDaysView.add(lblPic);
	
	}

	/**
	 * This method implements the Accolades screen.
	 */
	private void accoladesView() {

		panelAccoladesDisplay = new JPanel(new GridBagLayout());
		panelAccoladesDisplay.setForeground(Color.WHITE);
		panelAccoladesDisplay.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		labels = new JLabel[20][2];

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 2; j++) {
				labels[i][j] = new JLabel();

				labels[i][j].setForeground(Color.WHITE);
				if (j == 1) {
					gbc.insets = new Insets(70, 40, 40, 40);
					panelAccoladesDisplay.add(labels[i][j], gbc);
				} else
					panelAccoladesDisplay.add(labels[i][j]);
			}
			// gbc.gridx++;
		}

		panelAccoladesScroll = new JScrollPane(panelAccoladesDisplay);
		panelAccoladesScroll.setBounds(40, 70, 640, 450);
		panelAccoladesView.add(panelAccoladesScroll);

		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setForeground(Color.WHITE);
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelAccoladesView.add(lblLastUpdated);

		lblLastUpdatedAccolades = new JLabel();
		lblLastUpdatedAccolades.setForeground(Color.WHITE);
		lblLastUpdatedAccolades.setBounds(486, 540, 222, 16);
		lblLastUpdatedAccolades.setHorizontalAlignment(SwingConstants.TRAILING);
		panelAccoladesView.add(lblLastUpdatedAccolades);
		
		/**
		 * Background Image Implementation
		 */
		JLabel lblPic = new JLabel(new ImageIcon("src/main/resources/ACCdash.png"));
		lblPic.setBounds(0, 0, 720, 574);
		panelAccoladesView.add(lblPic);
	

	}

	/**
	 * This method implements the Lifetime Totals screen.
	 */
	private void lifetimeTotalsView() {

		lblLifetimeTotalsDistVal = new JLabel();
		lblLifetimeTotalsDistVal.setForeground(Color.WHITE);
		lblLifetimeTotalsDistVal.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblLifetimeTotalsDistVal
		.setHorizontalAlignment(SwingConstants.CENTER);
		lblLifetimeTotalsDistVal.setBounds(486, 384, 158, 101);
		panelLifetimeTotalsView.add(lblLifetimeTotalsDistVal);

		lblLifetimeTotalsFloorsVal = new JLabel();
		lblLifetimeTotalsFloorsVal.setForeground(Color.WHITE);
		lblLifetimeTotalsFloorsVal.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblLifetimeTotalsFloorsVal
		.setHorizontalAlignment(SwingConstants.CENTER);
		lblLifetimeTotalsFloorsVal.setBounds(278, 384, 167, 101);
		panelLifetimeTotalsView.add(lblLifetimeTotalsFloorsVal);

		lblLifetimeTotalsStepsVal = new JLabel();
		lblLifetimeTotalsStepsVal.setForeground(Color.WHITE);
		lblLifetimeTotalsStepsVal.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblLifetimeTotalsStepsVal
		.setHorizontalAlignment(SwingConstants.CENTER);
		lblLifetimeTotalsStepsVal.setBounds(71, 384, 167, 101);
		panelLifetimeTotalsView.add(lblLifetimeTotalsStepsVal);

		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setForeground(Color.WHITE);
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelLifetimeTotalsView.add(lblLastUpdated);

		lblLastUpdatedLt = new JLabel();
		lblLastUpdatedLt.setForeground(Color.WHITE);
		lblLastUpdatedLt.setBounds(486, 540, 222, 16);
		lblLastUpdatedLt.setHorizontalAlignment(SwingConstants.TRAILING);
		panelLifetimeTotalsView.add(lblLastUpdatedLt);
		
		/**
		 * Background Image Implementation
		 */
		JLabel lblPic = new JLabel(new ImageIcon("src/main/resources/LTdash.png"));
		lblPic.setBounds(0, 0, 720, 574);
		panelLifetimeTotalsView.add(lblPic);
	
	}

	/**
	 * This method implements the Time Series screen.
	 */
	private void timeseriesView() {
		
		JToolBar zoom = new JToolBar();
		zoom.setBorder(null);
		zoom.setFloatable(false);
		zoom.setBounds(40, 20, 50, 50);
		panelTimeSeriesView.add(zoom);

		JButton btnZoomOut = new JButton("");
		btnZoomOut.setMargin(new Insets(0, -4, 0, 0));
		btnZoomOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnZoomOut.setHorizontalTextPosition(SwingConstants.LEFT);
		btnZoomOut.setBorderPainted(false);
		btnZoomOut.setIconTextGap(0);
		btnZoomOut.setBorder(null);
		btnZoomOut.setIcon(new ImageIcon("src/main/resources/zoomOut40.png"));
		zoom.add(btnZoomOut);
		btnZoomOut.addActionListener(new ActionListener() {

	          @Override
	            public void actionPerformed(ActionEvent e) {
	                chartPanel.restoreAutoBounds();
	            }
	    });
		
		panelGraph = new JPanel();
		panelGraph.setBackground(Color.BLACK);
		panelGraph.setBounds(40, 160, 640, 362);
		panelTimeSeriesView.add(panelGraph);

		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setForeground(Color.WHITE);
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelTimeSeriesView.add(lblLastUpdated);

		lblLastUpdatedTS = new JLabel();
		lblLastUpdatedTS.setForeground(Color.WHITE);
		lblLastUpdatedTS.setBounds(486, 540, 222, 16);
		lblLastUpdatedTS.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTimeSeriesView.add(lblLastUpdatedTS);
		
		lblDisplayDateTS = new JLabel();
		lblDisplayDateTS.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplayDateTS.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		lblDisplayDateTS.setForeground(Color.WHITE);
		lblDisplayDateTS.setBounds(0, 60, 720, 100);
		panelTimeSeriesView.add(lblDisplayDateTS);
		
		lblClickAndDrag = new JLabel("Click and drag on the graph to zoom in.");
		lblClickAndDrag.setForeground(Color.WHITE);
		lblClickAndDrag.setHorizontalAlignment(SwingConstants.CENTER);
		lblClickAndDrag.setBounds(40, 144, 640, 16);
		panelTimeSeriesView.add(lblClickAndDrag);
	
		/**
		 * Background Image Implementation
		 */
		JLabel lblPic = new JLabel(new ImageIcon("src/main/resources/TSdash.png"));
		lblPic.setBounds(0, 0, 720, 574);
		panelTimeSeriesView.add(lblPic);
		
	}

	/**
	 * This method implements the Daily Goals screen.
	 */
	private void dailygoalsView() {

		lblActiveMinGoal = new JLabel();
		lblActiveMinGoal.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblActiveMinGoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblActiveMinGoal.setForeground(Color.WHITE);
		lblActiveMinGoal.setBounds(325, 454, 232, 46);

		panelDailyGoalsView.add(lblActiveMinGoal);

		lblStepsGoal = new JLabel();
		lblStepsGoal.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblStepsGoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblStepsGoal.setForeground(Color.WHITE);
		lblStepsGoal.setBounds(325, 317, 232, 46);
		panelDailyGoalsView.add(lblStepsGoal);

		lblDistanceGoal = new JLabel();
		lblDistanceGoal.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblDistanceGoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistanceGoal.setForeground(Color.WHITE);
		lblDistanceGoal.setBounds(325, 180, 232, 46);
		panelDailyGoalsView.add(lblDistanceGoal);

		lblCaloriesGoal = new JLabel();
		lblCaloriesGoal.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblCaloriesGoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaloriesGoal.setForeground(Color.WHITE);
		lblCaloriesGoal.setBounds(325, 385, 232, 46);
		panelDailyGoalsView.add(lblCaloriesGoal);

		lblFloorsGoal = new JLabel();
		lblFloorsGoal.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblFloorsGoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblFloorsGoal.setForeground(Color.WHITE);
		lblFloorsGoal.setBounds(325, 248, 232, 46);
		panelDailyGoalsView.add(lblFloorsGoal);

		lblStepsCompare = new JLabel();
		lblStepsCompare.setHorizontalAlignment(SwingConstants.CENTER);
		lblStepsCompare.setBounds(563, 317, 96, 46);
		panelDailyGoalsView.add(lblStepsCompare);

		lblDistanceCompare = new JLabel();
		lblDistanceCompare.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistanceCompare.setForeground(Color.WHITE);
		lblDistanceCompare.setBounds(563, 180, 96, 48);
		panelDailyGoalsView.add(lblDistanceCompare);

		lblCaloriesCompare = new JLabel();
		lblCaloriesCompare.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblCaloriesCompare.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaloriesCompare.setForeground(Color.WHITE);
		lblCaloriesCompare.setBounds(563, 385, 96, 46);
		panelDailyGoalsView.add(lblCaloriesCompare);

		lblFloorsCompare = new JLabel();
		lblFloorsCompare.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblFloorsCompare.setHorizontalAlignment(SwingConstants.CENTER);
		lblFloorsCompare.setForeground(Color.WHITE);
		lblFloorsCompare.setBounds(563, 248, 96, 46);
		panelDailyGoalsView.add(lblFloorsCompare);

		lblActiveMinCompare = new JLabel();
		lblActiveMinCompare.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblActiveMinCompare.setHorizontalAlignment(SwingConstants.CENTER);
		lblActiveMinCompare.setForeground(Color.WHITE);
		lblActiveMinCompare.setBounds(563, 454, 96, 46);
		panelDailyGoalsView.add(lblActiveMinCompare);

		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setForeground(Color.WHITE);
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelDailyGoalsView.add(lblLastUpdated);

		lblLastUpdatedGoals = new JLabel();
		lblLastUpdatedGoals.setForeground(Color.WHITE);
		lblLastUpdatedGoals.setBounds(486, 540, 222, 16);
		lblLastUpdatedGoals.setHorizontalAlignment(SwingConstants.TRAILING);
		panelDailyGoalsView.add(lblLastUpdatedGoals);
		
		lblDisplayDateGoals = new JLabel();
		lblDisplayDateGoals.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplayDateGoals.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		lblDisplayDateGoals.setForeground(Color.WHITE);
		lblDisplayDateGoals.setBounds(0, 60, 720, 100);
		panelDailyGoalsView.add(lblDisplayDateGoals);
		
		/**
		 * Background Image Implementation
		 */
		JLabel lblPic = new JLabel(new ImageIcon("src/main/resources/DGdash.png"));
		lblPic.setBounds(0, 0, 720, 574);
		panelDailyGoalsView.add(lblPic);

	}

	/**
	 * This method implements the Heart Rate Zones screen.
	 */
	private void heartratezonesView() {

		lblHeartRest = new JLabel();
		lblHeartRest.setFont(new Font("Dialog", Font.PLAIN, 28));
		lblHeartRest.setForeground(Color.WHITE);
		lblHeartRest.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartRest.setBounds(59, 211, 289, 61);
		panelHeartrateZonesView.add(lblHeartRest);

		lblHeartMins = new JLabel();
		lblHeartMins.setFont(new Font("Dialog", Font.PLAIN, 28));
		lblHeartMins.setForeground(Color.WHITE);
		lblHeartMins.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartMins.setBounds(372, 211, 286, 61);
		panelHeartrateZonesView.add(lblHeartMins);

		lblHeartCardioMax = new JLabel();
		lblHeartCardioMax.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblHeartCardioMax.setForeground(Color.WHITE);
		lblHeartCardioMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartCardioMax.setBounds(59, 318, 104, 45);
		panelHeartrateZonesView.add(lblHeartCardioMax);
		
		lblHeartCardioMin = new JLabel();
		lblHeartCardioMin.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblHeartCardioMin.setForeground(Color.WHITE);
		lblHeartCardioMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartCardioMin.setBounds(162, 318, 88, 45);
		panelHeartrateZonesView.add(lblHeartCardioMin);
		
		lblHeartCardioMinutes = new JLabel();
		lblHeartCardioMinutes.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblHeartCardioMinutes.setForeground(Color.WHITE);
		lblHeartCardioMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartCardioMinutes.setBounds(253, 318, 96, 45);
		panelHeartrateZonesView.add(lblHeartCardioMinutes);

		lblHeartFatBurnMax = new JLabel();
		lblHeartFatBurnMax.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblHeartFatBurnMax.setForeground(Color.WHITE);
		lblHeartFatBurnMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartFatBurnMax.setBounds(372, 318, 94, 45);
		panelHeartrateZonesView.add(lblHeartFatBurnMax);
		
		lblHeartFatBurnMin = new JLabel();
		lblHeartFatBurnMin.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblHeartFatBurnMin.setForeground(Color.WHITE);
		lblHeartFatBurnMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartFatBurnMin.setBounds(470, 318, 85, 45);
		panelHeartrateZonesView.add(lblHeartFatBurnMin);
		
		lblHeartFatBurnMinutes = new JLabel();
		lblHeartFatBurnMinutes.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblHeartFatBurnMinutes.setForeground(Color.WHITE);
		lblHeartFatBurnMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartFatBurnMinutes.setBounds(558, 318, 100, 45);
		panelHeartrateZonesView.add(lblHeartFatBurnMinutes);

		lblHeartPeakMax = new JLabel();
		lblHeartPeakMax.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblHeartPeakMax.setForeground(Color.WHITE);
		lblHeartPeakMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartPeakMax.setBounds(62, 434, 97, 45);
		panelHeartrateZonesView.add(lblHeartPeakMax);
		
		lblHeartPeakMin = new JLabel();
		lblHeartPeakMin.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblHeartPeakMin.setForeground(Color.WHITE);
		lblHeartPeakMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartPeakMin.setBounds(163, 434, 86, 45);
		panelHeartrateZonesView.add(lblHeartPeakMin);
		
		lblHeartPeakMinutes = new JLabel();
		lblHeartPeakMinutes.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblHeartPeakMinutes.setForeground(Color.WHITE);
		lblHeartPeakMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartPeakMinutes.setBounds(253, 434, 98, 45);
		panelHeartrateZonesView.add(lblHeartPeakMinutes);
		
		lblHeartOORMax = new JLabel();
		lblHeartOORMax.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblHeartOORMax.setForeground(Color.WHITE);
		lblHeartOORMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartOORMax.setBounds(372, 434, 94, 45);
		panelHeartrateZonesView.add(lblHeartOORMax);
		
		lblHeartOORMin = new JLabel();
		lblHeartOORMin.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblHeartOORMin.setForeground(Color.WHITE);
		lblHeartOORMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartOORMin.setBounds(469, 434, 87, 45);
		panelHeartrateZonesView.add(lblHeartOORMin);
		
		lblHeartOORMinutes = new JLabel();
		lblHeartOORMinutes.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblHeartOORMinutes.setForeground(Color.WHITE);
		lblHeartOORMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartOORMinutes.setBounds(558, 434, 98, 45);
		panelHeartrateZonesView.add(lblHeartOORMinutes);

		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setForeground(Color.WHITE);
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelHeartrateZonesView.add(lblLastUpdated);

		lblLastUpdatedHRZ = new JLabel();
		lblLastUpdatedHRZ.setForeground(Color.WHITE);
		lblLastUpdatedHRZ.setBounds(486, 540, 222, 16);
		lblLastUpdatedHRZ.setHorizontalAlignment(SwingConstants.TRAILING);
		panelHeartrateZonesView.add(lblLastUpdatedHRZ);
		
		lblDisplayDateHRZ = new JLabel();
		lblDisplayDateHRZ.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplayDateHRZ.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		lblDisplayDateHRZ.setBounds(0, 60, 720, 100);
		lblDisplayDateHRZ.setForeground(Color.WHITE);
		panelHeartrateZonesView.add(lblDisplayDateHRZ);	
		
		/**
		 * Background Image Implementation
		 */
		JLabel lblPic = new JLabel(new ImageIcon("src/main/resources/HRZdash.jpg"));
		lblPic.setBounds(0, 0, 720, 574);
		panelHeartrateZonesView.add(lblPic);
	}
		

	/**
	 * This method controls page navigation, depending on button actions.
	 */
	private void actionEvents() {

		btnBestDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Set Visibility of panels:
				panelDashboardView.setVisible(false);
				panelBestDaysView.setVisible(true);
				panelLifetimeTotalsView.setVisible(false);
				panelDailyGoalsView.setVisible(false);
				panelAccoladesView.setVisible(false);
				panelTimeSeriesView.setVisible(false);
				panelHeartrateZonesView.setVisible(false);
				// Set selection of buttons:
				btnDailyDashboard.setSelected(false);
				btnBestDays.setSelected(true);
				btnDailyGoals.setSelected(false);
				btnLifetimeTotals.setSelected(false);
				btnAccolades.setSelected(false);
				btnTimeSeries.setSelected(false);
				btnHeartRateZones.setSelected(false);
			}

		});

		btnDailyDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Set Visibility of panels:
				panelDashboardView.setVisible(true);
				panelBestDaysView.setVisible(false);
				panelLifetimeTotalsView.setVisible(false);
				panelDailyGoalsView.setVisible(false);
				panelAccoladesView.setVisible(false);
				panelTimeSeriesView.setVisible(false);
				panelHeartrateZonesView.setVisible(false);
				// Set selection of buttons:
				btnDailyDashboard.setSelected(true);
				btnBestDays.setSelected(false);
				btnDailyGoals.setSelected(false);
				btnLifetimeTotals.setSelected(false);
				btnAccolades.setSelected(false);
				btnTimeSeries.setSelected(false);
				btnHeartRateZones.setSelected(false);
			}
		});

		/**
		 * Switch window to Lifetime Totals screen:
		 */
		btnLifetimeTotals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Set Visibility of panels:
				panelDashboardView.setVisible(false);
				panelBestDaysView.setVisible(false);
				panelLifetimeTotalsView.setVisible(true);
				panelDailyGoalsView.setVisible(false);
				panelAccoladesView.setVisible(false);
				panelTimeSeriesView.setVisible(false);
				panelHeartrateZonesView.setVisible(false);
				// Set selection of buttons:
				btnDailyDashboard.setSelected(false);
				btnBestDays.setSelected(false);
				btnDailyGoals.setSelected(false);
				btnLifetimeTotals.setSelected(true);
				btnAccolades.setSelected(false);
				btnTimeSeries.setSelected(false);
				btnHeartRateZones.setSelected(false);
			}
		});

		btnDailyGoals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Set Visibility of panels:
				panelDashboardView.setVisible(false);
				panelBestDaysView.setVisible(false);
				panelLifetimeTotalsView.setVisible(false);
				panelDailyGoalsView.setVisible(true);
				panelAccoladesView.setVisible(false);
				panelTimeSeriesView.setVisible(false);
				panelHeartrateZonesView.setVisible(false);
				// Set selection of buttons:
				btnDailyDashboard.setSelected(false);
				btnBestDays.setSelected(false);
				btnDailyGoals.setSelected(true);
				btnLifetimeTotals.setSelected(false);
				btnAccolades.setSelected(false);
				btnTimeSeries.setSelected(false);
				btnHeartRateZones.setSelected(false);
			}
		});

		/**
		 * Switch window to Accolades screen:
		 */
		btnAccolades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Set Visibility of panels:
				panelDashboardView.setVisible(false);
				panelBestDaysView.setVisible(false);
				panelLifetimeTotalsView.setVisible(false);
				panelDailyGoalsView.setVisible(false);
				panelAccoladesView.setVisible(true);
				panelTimeSeriesView.setVisible(false);
				panelHeartrateZonesView.setVisible(false);
				// Set selection of buttons:
				btnDailyDashboard.setSelected(false);
				btnBestDays.setSelected(false);
				btnDailyGoals.setSelected(false);
				btnLifetimeTotals.setSelected(false);
				btnAccolades.setSelected(true);
				btnTimeSeries.setSelected(false);
				btnHeartRateZones.setSelected(false);
			}
		});

		/**
		 * Switch window to Timeseries screen:
		 */
		btnTimeSeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Set Visibility of panels:
				panelDashboardView.setVisible(false);
				panelBestDaysView.setVisible(false);
				panelLifetimeTotalsView.setVisible(false);
				panelDailyGoalsView.setVisible(false);
				panelAccoladesView.setVisible(false);
				panelTimeSeriesView.setVisible(true);
				panelHeartrateZonesView.setVisible(false);
				// Set selection of buttons:
				btnDailyDashboard.setSelected(false);
				btnBestDays.setSelected(false);
				btnDailyGoals.setSelected(false);
				btnLifetimeTotals.setSelected(false);
				btnAccolades.setSelected(false);
				btnTimeSeries.setSelected(true);
				btnHeartRateZones.setSelected(false);
			}
		});

		/**
		 * Switch window to Heart Rate Zones screen:
		 */
		btnHeartRateZones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Set Visibility of panels:
				panelDashboardView.setVisible(false);
				panelBestDaysView.setVisible(false);
				panelLifetimeTotalsView.setVisible(false);
				panelDailyGoalsView.setVisible(false);
				panelAccoladesView.setVisible(false);
				panelTimeSeriesView.setVisible(false);
				panelHeartrateZonesView.setVisible(true);
				// Set selection of buttons:
				btnDailyDashboard.setSelected(false);
				btnBestDays.setSelected(false);
				btnDailyGoals.setSelected(false);
				btnLifetimeTotals.setSelected(false);
				btnAccolades.setSelected(false);
				btnTimeSeries.setSelected(false);
				btnHeartRateZones.setSelected(true);
			}
		});

	}

	// Setters
	/**
	 * Setter method for the 'Display Date' labels on time-dependent pages, which
	 * indicate which date the current information on the page is from.
	 * @param date the date of the current data being displayed
	 */
	public void setDisplayDate(Date date){
		
	    String datePattern = "MMM dd, yyyy";
	    SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
	    
	    String formattedDate = dateFormatter.format(date);
		
		lblDisplayDateGoals.setText(formattedDate);
		lblDisplayDateHRZ.setText(formattedDate);
		lblDisplayDateTS.setText(formattedDate);
	}

	/**
	 * Setter methods for the 'Last Updated' label on each page, indicating when the
	 * last API call was successfully made.
	 * @param date time of the last successful API call
	 */
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
	public void setHeartRateZonesFields(int minutes, double rate, int cardio_max,
			int fatburn_max, int peak_max, int cardio_min, int fatburn_min,
			int peak_min, int cardio_minutes, int fatburn_minutes,
			int peak_minutes, int oor_max, int oor_min, int oor_minutes) {
		lblHeartMins.setText(Integer.toString(minutes));
		lblHeartRest.setText(Double.toString(rate));

		lblHeartCardioMax.setText(Integer.toString(cardio_max));
		lblHeartCardioMin.setText(Integer.toString(cardio_min));
		lblHeartCardioMinutes.setText(Integer.toString(cardio_minutes));
		
		lblHeartFatBurnMax.setText(Integer.toString(fatburn_max));
		lblHeartFatBurnMin.setText(Integer.toString(fatburn_min));
		lblHeartFatBurnMinutes.setText(Integer.toString(fatburn_minutes));
		
		lblHeartPeakMax.setText(Integer.toString(peak_max));
		lblHeartPeakMin.setText(Integer.toString(peak_min));
		lblHeartPeakMinutes.setText(Integer.toString(peak_minutes));
		
		lblHeartOORMax.setText(Integer.toString(oor_max));
		lblHeartOORMin.setText(Integer.toString(oor_min));
		lblHeartOORMinutes.setText(Integer.toString(oor_minutes));
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
	 * {@code BestDaysRecord}. Called when "Best Days" menu button is clicked,
	 * as defined in {@code BestDaysController}.
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
	 * {@code GoalsRecord}. Called when "Daily Goals" menu button is clicked, as
	 * defined in {@code GoalsController}.
	 * 
	 * @param activeMinutes
	 *            daily goal for active minutes
	 * @param caloriesOut
	 *            daily goal for calories burned
	 * @param distance
	 *            daily goal for distance traveled
	 * @param floors
	 *            daily goal for floors climbed
	 * @param steps
	 *            daily goal for steps taken
	 * @param activeMinStatus
	 * @param caloriesStatus
	 * @param distanceStatus
	 * @param stepsStatus
	 * @param floorsStatus
	 */
	public void setDailyGoalsFields(int activeMinutes, double caloriesOut,
			double distance, int floors, int steps, String activeMinStatus,
			String caloriesStatus, String distanceStatus, String stepsStatus,
			String floorsStatus) {
		lblActiveMinGoal.setText(Integer.toString(activeMinutes));
		lblCaloriesGoal.setText(Double.toString(caloriesOut));
		lblDistanceGoal.setText(Double.toString(distance));
		lblStepsGoal.setText(Integer.toString(steps));
		lblFloorsGoal.setText(Integer.toString(floors));
		
		if (activeMinStatus.equals("N")) {
			lblActiveMinCompare.setIcon(new ImageIcon("src/main/resources/blueX.png"));
		}
		else {
			lblActiveMinCompare.setIcon(new ImageIcon("src/main/resources/blueCheck.png"));
		}
		
		if (caloriesStatus.equals("N")) {
			lblCaloriesCompare.setIcon(new ImageIcon("src/main/resources/blueX.png"));
		}
		else {
			lblCaloriesCompare.setIcon(new ImageIcon("src/main/resources/blueCheck.png"));
		}
		
		if (distanceStatus.equals("N")) {
			lblDistanceCompare.setIcon(new ImageIcon("src/main/resources/blueX.png"));
		}
		else {
			lblDistanceCompare.setIcon(new ImageIcon("src/main/resources/blueCheck.png"));
		}
		
		if (stepsStatus.equals("N")) {
			lblStepsCompare.setIcon(new ImageIcon("src/main/resources/blueX.png"));
		}
		else {
			lblStepsCompare.setIcon(new ImageIcon("src/main/resources/blueCheck.png"));
		}
		
		if (floorsStatus.equals("N")) {
			lblFloorsCompare.setIcon(new ImageIcon("src/main/resources/blueX.png"));
		}
		else {
			lblFloorsCompare.setIcon(new ImageIcon("src/main/resources/blueCheck.png"));
		}

		
	}

	public void setAccoladeFields(AccoladeRecord[] ar) {

		for (int i = 0; i < 20; i++) {

			if (ar[i].getAchieved() == true) {
				ImageIcon imageIcon = new ImageIcon("src/main/resources/"
						+ ar[i].getImage() + ".jpg"); // load the image to a
														// imageIcon
				Image image = imageIcon.getImage(); // transform it
				Image newimg = image.getScaledInstance(120, 120,
						java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
				imageIcon = new ImageIcon(newimg); // transform it back

				labels[i][0].setIcon(imageIcon);
			}
			else
			{
				ImageIcon imageIcon = new ImageIcon("src/main/resources/"
						+ ar[i].getImage() + "Grey.jpg"); // load the image to a
														// imageIcon
				Image image = imageIcon.getImage(); // transform it
				Image newimg = image.getScaledInstance(120, 120,
						java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
				imageIcon = new ImageIcon(newimg); // transform it back

				labels[i][0].setIcon(imageIcon);
			}

			labels[i][1].setText(ar[i].getDesc());
		}
	}

	// ActionListeners

	/**
	 * Attaches an {@code ActionListner} object to the calendar that will trigger
	 * API calls to change the date of the information displayed across all pages 
	 * of the application, when the user selects a new date on the calendar.
	 * 
	 * @param changeData 
	 * 			{@code ActionListener} makes API calls using the selected date and is defined in {@link Main}
	 */
	public void addCalendarDateChangeActions(ActionListener changeData) {
		
		datePicker.addActionListener(changeData);
		
		datePicker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//setDisplayDate(dateModel.getValue());
				setDisplayDate(modelForDay.getValueDate());
			}
			
		});
		
	}
	
	/**
	 * Attaches an {@code ActionListner} object to the "previous" button that will trigger
	 * API calls to change the date of the information displayed across all pages 
	 * of the application to the previous day. Also attaches an {@code ActionListener} to 
	 * change the date displayed on the calendar.
	 * 
	 * @param changeData 
	 * 			{@code ActionListener} makes API calls using the date previous to the one
	 * 			currently displayed, and is defined in {@link Main}
	 */
	public void addPreviousDayActions(ActionListener changeData) {
		
		btnPrevDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int oldDay = modelForDay.getDay();
				modelForDay.setDay(modelForDay.getDay()-1);

				if (!checkConstraints(modelForDay)) {
					// rollback
					modelForDay.setDay(oldDay);
					System.out.println("noooo! - message from addPreviousDayActions in InterfaceView");
				}
				else
					setDisplayDate(modelForDay.getValueDate());

				/**
				dateModel.setDay(dateModel.getDay()-1);
				datePicker.getModel().setDay(datePicker.getModel().getDay());
				setDisplayDate(dateModel.getValue());
				 */
				
				}
		});
		
		btnPrevDate.addActionListener(changeData);
		
	}
	
	/**
	 * Attaches an {@code ActionListner} object to the "next" button that will trigger
	 * API calls to change the date of the information displayed across all pages 
	 * of the application to the previous day.Also attaches an {@code ActionListener} to 
	 * change the date displayed on the calendar.
	 * Does not allow date to be changed to a future date.
	 * 
	 * @param changeData 
	 * 			{@code ActionListener} makes API calls using the date one day in advance 
	 * 			of the date currently displayed, and is defined in {@link Main}
	 */
	public void addNextDayActions(ActionListener changeData) {
		
		btnNextDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				//if(getDateObject().compareTo(new Date()) <= 1) {
					
					int oldDay = modelForDay.getDay();
					modelForDay.setDay(modelForDay.getDay()+1);

					if (!checkConstraints(modelForDay)) {
						// rollback
						modelForDay.setDay(oldDay);
						System.out.println("noooo! - message from addNextDayActions in InterfaceView");
					}
					else
						setDisplayDate(modelForDay.getValueDate());

					/**
					dateModel.setDay(dateModel.getDay()-1);
					datePicker.getModel().setDay(datePicker.getModel().getDay());
					setDisplayDate(dateModel.getValue());
					 */

				//}
				//else System.out.println("noooo! - message from addNextDayActions in InterfaceView");
			}
			});
		
		btnNextDate.addActionListener(changeData);
	}
	
	public boolean checkConstraints(CalendarModel model) {


		if (!rc.isValidSelection(model)) {
			return false;
		}
		
		return true;
	}

	
	public boolean checkConstraintsLower(CalendarModel model) {


		if (!rc.isLower(model)) {
			return false;
		}
		
		return true;
	}
	
	public boolean checkConstraintsUpper(CalendarModel model) {

		if (!rc.isUpper(model)) {
			return false;
		}
		
		return true;
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
	 * Attaches an {@code ActionListener} object to Daily Goals menu button,
	 * which executes {@code InterfaceVie}
	 * 
	 * @param actionsOnClick
	 *            ActionListener object defined in {@link GoalsController}
	 */
	public void addClickListenerGoals(ActionListener actionsOnClick) {
		btnDailyGoals.addActionListener(actionsOnClick);
	}

	/**
	 * Attaches two {@code ActionListener} objects to the refresh button on each
	 * page. One which triggers new API calls (implemented in {@link Main}), and one
	 * which updates the date displayed on the date labels of
	 * date-dependent pages.
	 * @param refresh
	 */
	public void addListenerForRefresh(ActionListener refresh){
		//add API calls trigger
		btnRefresh.addActionListener(refresh);
		
		//add display date update to today's date
		btnRefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDisplayDate(new Date());	
			}
			
		});
	}

	/**
	 * Attaches an {@code ActionListener} object to Accolades menu button, which
	 * executes {@code InterfaceView}
	 * 
	 * @param actionsOnClick
	 *            ActionListener object defined in {@link AccoladeController}
	 */
	public void addClickListenerAccolades(ActionListener actionsOnClick) {
		btnAccolades.addActionListener(actionsOnClick);
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
	public void addClickListenerTimeSeries(ActionListener actionsOnClick) {

		// the btnLifetimeTotals.addActionListner() call is encapsulated by a
		// method
		// so that it can be accessed by the controller;
		// the controller passes in the clicklistener, which contains the method
		// that updates the view;
		// this method gets executed when the controller is initialized

		btnTimeSeries.addActionListener(actionsOnClick);
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
	public int radioCounter() {
		int counter = 0;
		if (radioCalories.isSelected()) {
			counter += 1;
		}
		if (radioTotalDist.isSelected()) {
			counter += 1;
		}
		if (radioSedMin.isSelected()) {
			counter += 1;
		}
		if (radioActiveMin.isSelected()) {
			counter += 1;
		}
		if (radioFloors.isSelected()) {
			counter += 1;
		}
		if (radioSteps.isSelected()) {
			counter += 1;
		}
		return counter;
	}

 
/**
 * Method switches to a new layout for the custom dashboard.
 * @param count the number of radio buttons selected in the custom layout menu for the dashboard.
 */
	/**
	 * Method switches to a new layout for the custom dashboard.
	 * @param count the number of radio buttons selected in the custom layout menu for the dashboard.
	 */
		public void repanel(int count) {
			switch (count) {
			case 1:

				TwoPanel.setVisible(false);
				try {
					twoPanel_1.removeAll();
					twoPanel_2.removeAll();
				} catch (Exception e) {
				}
				ThreePanel.setVisible(false);
				FourPanel.setVisible(false);
				FivePanel.setVisible(false);
				SixPanel.setVisible(false);

				onePanel_1.add(panelArray[0]);
				OnePanel.setVisible(true);

				break;

			case 2:
				OnePanel.setVisible(false);
				try {
					onePanel_1.removeAll();
				} catch (Exception e) {
				}
				ThreePanel.setVisible(false);
				try {
					threePanel_1.removeAll();
					threePanel_2.removeAll();
					threePanel_3.removeAll();
				} catch (Exception e) {
				}

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
				try {
					twoPanel_1.removeAll();
					twoPanel_2.removeAll();
				} catch (Exception e) {
				}

				FourPanel.setVisible(false);
				try {
					fourPanel_1.removeAll();
					fourPanel_2.removeAll();
					fourPanel_3.removeAll();
					fourPanel_4.removeAll();

				} catch (Exception e) {
				}
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

				try {
					threePanel_1.removeAll();
					threePanel_2.removeAll();
					threePanel_3.removeAll();
				} catch (Exception e) {
				}
				FivePanel.setVisible(false);
				try {
					fivePanel_1.removeAll();
					fivePanel_2.removeAll();
					fivePanel_3.removeAll();
					fivePanel_4.removeAll();
					fivePanel_5.removeAll();

				} catch (Exception e) {
				}
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

				try {
					fourPanel_1.removeAll();
					fourPanel_2.removeAll();
					fourPanel_3.removeAll();
					fourPanel_4.removeAll();
				} catch (Exception e) {
				}
				SixPanel.setVisible(false);
				try {
					sixPanel_1.removeAll();
					sixPanel_2.removeAll();
					sixPanel_3.removeAll();
					sixPanel_4.removeAll();
					sixPanel_5.removeAll();
					sixPanel_6.removeAll();
				} catch (Exception e) {
				}

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

				} catch (Exception e) {
				}

				sixPanel_1.add(panelArray[0]);
				sixPanel_2.add(panelArray[1]);
				sixPanel_3.add(panelArray[2]);
				sixPanel_4.add(panelArray[3]);
				sixPanel_5.add(panelArray[4]);
				sixPanel_6.add(panelArray[5]);
				SixPanel.setVisible(true);

				break;
			}
			
			//save_settings();

		}

		public void setTimeSeriesGraph(final DistanceTSRecord dRecords, final StepsTSRecord sRecords, final CaloriesTSRecord caRecord, final HeartRateRecord rRecord)
		{		
			try {
				panelGraph.removeAll();
			} catch (Exception e) {
				System.out.println("\n");
			}
			panelGraph.revalidate(); // This removes the old chart 
			
			// Generate Graph:
			final XYDataset dataset = createDataset(dRecords, sRecords, caRecord, rRecord);         
			final JFreeChart chart = createChart( dataset );
			
			//chart.getXYPlot().setDataset(createDataset(dRecords, sRecords, caRecord, rRecord));
			
			chart.getPlot().addChangeListener(new PlotChangeListener(){
				  @Override
				  public void plotChanged(PlotChangeEvent event)
				  {
						panelGraph.revalidate();
						panelGraph.repaint();

				  }});

			chartPanel = new ChartPanel( chart ); 
			chartPanel.setPreferredSize( new java.awt.Dimension( 620 , 360 ) );         
			//chartPanel.setMouseZoomable( true , false );   
			chartPanel.setDomainZoomable(true);
		
			//chartPanel.setZoomInFactor(10);
			panelGraph.add( chartPanel );
			panelGraph.revalidate(); // This checks the chart 
			panelGraph.repaint();

		}
		
	private XYDataset createDataset(final DistanceTSRecord dRecord, final StepsTSRecord sRecord, final CaloriesTSRecord caRecord, final HeartRateRecord rRecord) 
	{
		System.out.println(dRecord.getDateTime());

		final TimeSeriesCollection datasetTS = new TimeSeriesCollection();
        datasetTS.setDomainIsPointsInTime(true);
        
        //Minute(int minute, int hour, int day, int month, int year) 
        
        final TimeSeries s1 = new TimeSeries("Distance");
        final TimeSeries s2 = new TimeSeries("Steps");
        final TimeSeries s3 = new TimeSeries("Calories");
        final TimeSeries s4 = new TimeSeries("Heart Rate");

    	String str[] = dRecord.getDateTime().split("-");
    	int year = Integer.parseInt(str[0]);
    	int month = Integer.parseInt(str[1]);
    	int day = Integer.parseInt(str[2]);
    	
    	DistanceRecord[] distance_arr = dRecord.getdRecords();
    	StepsRecord[] steps_arr = sRecord.getsRecords();
    	CaloriesRecord[] calories_arr = caRecord.getdRecords();
    	HeartRateInstanceRecord[] rate_arr = rRecord.getdRecords();

        for(int i = 0; i < distance_arr.length ; i++)
        {
        	String str2[] = distance_arr[i].getTime().split(":");
        	int hour = Integer.parseInt(str2[0]);
        	int minute = Integer.parseInt(str2[1]);
        	//System.out.println(hour + " " + minute);
        	double value = distance_arr[i].getValue();
        	s1.add(new Minute(minute, hour, day, month, year), value);
        }
        
        for(int i = 0; i < steps_arr.length ; i++)
        {
        	String str2[] = steps_arr[i].getTime().split(":");
        	int hour = Integer.parseInt(str2[0]);
        	int minute = Integer.parseInt(str2[1]);
        	
        	double value = steps_arr[i].getValue();
        	s2.add(new Minute(minute, hour, day, month, year), value);
        }
        
        for(int i = 0; i < rate_arr.length ; i++)
        {
        	String str2[] = rate_arr[i].getTime().split(":");
        	int hour = Integer.parseInt(str2[0]);
        	int minute = Integer.parseInt(str2[1]);
        	
        	double value = rate_arr[i].getValue();
        	s4.add(new Minute(minute, hour, day, month, year), value);
        }
        
        for(int i = 0; i < calories_arr.length ; i++)
        {
        	String str2[] = calories_arr[i].getTime().split(":");
        	int hour = Integer.parseInt(str2[0]);
        	int minute = Integer.parseInt(str2[1]);
        	
        	double value = calories_arr[i].getValue();
        	s3.add(new Minute(minute, hour, day, month, year), value);

        }
        
        datasetTS.addSeries(s1);
        datasetTS.addSeries(s2);
        datasetTS.addSeries(s3);
        datasetTS.addSeries(s4);

        return datasetTS;
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
		
		//int year = dateModel.getYear();
		//int day = dateModel.getDay();
		int year = modelForDay.getYear();
		int day = modelForDay.getDay();
		
		if(incrementFlag == "previous") day-=1;
		else if(incrementFlag == "next") day+=1;
				
		//convert int (0-11) to int(1-12) for MM
		//int month = dateModel.getMonth();
		int month = modelForDay.getMonth();
		month+=1;
		
		//prefix 0 to single-digit months and days
		if (month<=9 && day<=9) return year+"-0"+month+"-0"+day;
		
		else if (month<=9)return year+"-0"+month+"-"+day;
		else if (day<=9) return year+"-"+month+"-0"+day;
		
		else return year+"-"+month+"-"+day;
	}
	//SHORTCUT
	
	public Date getDateObject() {
		return dateModel.getValue();
	}
	
	public CalendarModel getCalendarObject() {
		return modelForDay;
	}
	
	/**
	 * Objects of this inner class format the date to be displayed in the calendar text box.
	 * A {@link DateLabelFormatter} object is required as a parameter in the
	 * {@code JDatePickerImpl} constructor called in the {@link #dashboardView} method.
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

	private JFreeChart createChart(final XYDataset dataset ) 
	{
		final JFreeChart chart = ChartFactory.createTimeSeriesChart(             
				"", 
				"Time",              
				"Value",              
				dataset,             
				true,              
				true,              
				false);
		 chart.setBackgroundPaint(Color.BLACK);

	   final XYPlot plot = chart.getXYPlot();
       //plot.setOutlinePaint(null);
       plot.setBackgroundPaint(Color.DARK_GRAY);
       plot.setDomainGridlinePaint(Color.white);
       plot.setRangeGridlinePaint(Color.white);
       //plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
       plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
       plot.setDomainCrosshairVisible(true);
       plot.setRangeCrosshairVisible(false);
     
       
       final XYItemRenderer renderer = plot.getRenderer();
       if (renderer instanceof StandardXYItemRenderer) {
           StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
           rr.setBaseShapesVisible(true); //PlotShapes(true);
           rr.setShapesFilled(true);
           renderer.setSeriesStroke(0, new BasicStroke(2.0f));
           renderer.setSeriesStroke(1, new BasicStroke(2.0f));

          }
       
       final DateAxis axis = (DateAxis) plot.getDomainAxis();
       DateTickUnit stu = new DateTickUnit(DateTickUnit.HOUR,1); 
       axis.setAutoTickUnitSelection(false);
       axis.setVerticalTickLabels(true);
       axis.setTickUnit(stu); 
       axis.setDateFormatOverride(new SimpleDateFormat("hh:mma"));
       
       return chart;

   }
}