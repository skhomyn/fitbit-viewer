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
import java.awt.Rectangle;

import javax.swing.JLayeredPane;
import javax.imageio.ImageIO;
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

import net.sourceforge.jdatepicker.impl.*;

import java.util.Date;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.util.Date;
import javax.swing.Icon;
import java.awt.Point;




/**
 * {@code InterfaceView} creates the GUI of the Fitbit program.
 * It also implements page navigation between the different screens.
 */

public class InterfaceView {


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
	private SPanel dailyCaloriesPanel;
	private SPanel dailyTotalDistPanel;
	private SPanel dailyActiveMinPanel;
	private SPanel dailySedMinPanel;
	private SPanel dailyFloorsPanel;
	private SPanel dailyStepsPanel;
	private SPanel[] panelArray;


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
		dailyStepsPanel = new SPanel();
		dailyStepsPanel.setBounds(496, 453, 120, 100);

		lblDailyStepsVal = new JLabel();
		dailyStepsPanel.add(lblDailyStepsVal);
		lblDailyStepsVal.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel label_3 = new JLabel("Steps");
		dailyStepsPanel.add(label_3);

		dailyCaloriesPanel = new SPanel();
		dailyCaloriesPanel.setBounds(608, 452, 120, 100);

		lblDailyCaloriesVal = new JLabel();
		dailyCaloriesPanel.add(lblDailyCaloriesVal);
		lblDailyCaloriesVal.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel label = new JLabel("Calories Burned");
		dailyCaloriesPanel.add(label);

		dailySedMinPanel = new SPanel();
		dailySedMinPanel.setBounds(264, 448, 120, 100);

		lblDailySedenteryMinVal = new JLabel();
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

		lblDailyFloorsVal = new JLabel();
		lblDailyFloorsVal.setBounds(10, 34, 70, 16);
		dailyFloorsPanel.add(lblDailyFloorsVal);
		lblDailyFloorsVal.setHorizontalAlignment(SwingConstants.TRAILING);

		dailyTotalDistPanel = new SPanel();
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

		onePanel_1 = new JPanel();
		onePanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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

		twoPanel_1 = new JPanel();
		twoPanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		twoPanel_1.setBounds(107, 108, 160, 144);
		TwoPanel.add(twoPanel_1);

		twoPanel_2 = new JPanel();
		twoPanel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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

		threePanel_1 = new JPanel();
		threePanel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		threePanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		threePanel_1.setBounds(40, 108, 160, 144);
		ThreePanel.add(threePanel_1);

		threePanel_2 = new JPanel();
		threePanel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		threePanel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		threePanel_2.setBounds(240, 108, 160, 144);
		ThreePanel.add(threePanel_2);

		threePanel_3 = new JPanel();
		threePanel_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		threePanel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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

		fourPanel_1 = new JPanel();
		fourPanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fourPanel_1.setBounds(107, 24, 160, 144);
		FourPanel.add(fourPanel_1);

		fourPanel_2 = new JPanel();
		fourPanel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fourPanel_2.setBounds(374, 24, 160, 144);
		FourPanel.add(fourPanel_2);

		fourPanel_3 = new JPanel();
		fourPanel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fourPanel_3.setBounds(107, 192, 160, 144);
		FourPanel.add(fourPanel_3);

		fourPanel_4 = new JPanel();
		fourPanel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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

		fivePanel_1 = new JPanel();
		fivePanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fivePanel_1.setBounds(40, 24, 160, 144);
		FivePanel.add(fivePanel_1);

		fivePanel_2 = new JPanel();
		fivePanel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fivePanel_2.setBounds(240, 24, 160, 144);
		FivePanel.add(fivePanel_2);

		fivePanel_3 = new JPanel();
		fivePanel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fivePanel_3.setBounds(440, 24, 160, 144);
		FivePanel.add(fivePanel_3);

		fivePanel_4 = new JPanel();
		fivePanel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fivePanel_4.setBounds(107, 192, 160, 144);
		FivePanel.add(fivePanel_4);

		fivePanel_5 = new JPanel();
		fivePanel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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

		sixPanel_1 = new JPanel();
		sixPanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sixPanel_1.setBounds(40, 24, 160, 144);
		SixPanel.add(sixPanel_1);

		sixPanel_2 = new JPanel();
		sixPanel_2.setBounds(240, 24, 160, 144);
		SixPanel.add(sixPanel_2);
		sixPanel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		sixPanel_3 = new JPanel();
		sixPanel_3.setBounds(new Rectangle(0, 0, 180, 160));
		sixPanel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sixPanel_3.setBounds(440, 24, 160, 144);
		SixPanel.add(sixPanel_3);

		sixPanel_4 = new JPanel();
		sixPanel_4.setBounds(new Rectangle(0, 0, 180, 160));
		sixPanel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sixPanel_4.setBounds(40, 192, 160, 144);
		SixPanel.add(sixPanel_4);

		sixPanel_5 = new JPanel();
		sixPanel_5.setBounds(new Rectangle(0, 0, 180, 160));
		sixPanel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sixPanel_5.setBounds(240, 192, 160, 144);
		SixPanel.add(sixPanel_5);

		sixPanel_6 = new JPanel();
		sixPanel_6.setBounds(new Rectangle(0, 0, 180, 160));
		sixPanel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sixPanel_6.setBounds(440, 192, 160, 144);
		SixPanel.add(sixPanel_6);
		sixPanel_6.setLayout(null);

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
						SPanel switcheyPanel = panelArray[radioCounter()-1];
						panelArray[radioCounter()-1] = (SPanel) dailyFloorsPanel;
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
						SPanel switcheyPanel = panelArray[position+1];
						panelArray[position+1] = (SPanel) dailyFloorsPanel;
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
						SPanel switcheyPanel = panelArray[radioCounter()-1];
						panelArray[radioCounter()-1] = (SPanel) dailyStepsPanel;
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
						SPanel switcheyPanel = panelArray[position+1];
						panelArray[position+1] = (SPanel) dailyStepsPanel;
						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}
			}
		});

		radioCalories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("WOW");

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
						SPanel switcheyPanel = panelArray[radioCounter()-1];
						panelArray[radioCounter()-1] = (SPanel) dailyCaloriesPanel;
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
						SPanel switcheyPanel = panelArray[position+1];
						panelArray[position+1] = (SPanel) dailyCaloriesPanel;
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
						SPanel switcheyPanel = panelArray[radioCounter()-1];
						panelArray[radioCounter()-1] = (SPanel) dailyTotalDistPanel;
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
						SPanel switcheyPanel = panelArray[position+1];
						panelArray[position+1] = (SPanel) dailyTotalDistPanel;
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
						SPanel switcheyPanel = panelArray[radioCounter()-1];
						panelArray[radioCounter()-1] = (SPanel) dailySedMinPanel;
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
						SPanel switcheyPanel = panelArray[position+1];
						panelArray[position+1] = (SPanel) dailySedMinPanel;
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
						SPanel switcheyPanel = panelArray[radioCounter()-1];
						panelArray[radioCounter()-1] = (SPanel) dailyActiveMinPanel;
						panelArray[position] = switcheyPanel;
					}
					repanel(radioCounter());
				}

				else{
					System.out.println("WAHWAHWAH\n");
					while(panelArray[radioCounter()]!=dailyActiveMinPanel){
						int position = 0;
						for(int x=0; x<radioCounter(); x++){
							if (panelArray[x]==dailyActiveMinPanel){
								position = x;
							}
						}
						System.out.println(position +"\n");
						SPanel switcheyPanel = panelArray[position+1];
						panelArray[position+1] = (SPanel) dailyActiveMinPanel;
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
		UtilDateModel utilModel = new UtilDateModel(currentDate);
		JDatePanelImpl datePanel = new JDatePanelImpl(utilModel);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(278,105,170,30);
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalendarToAPI();
			}
		});

		panelDashboardView.add(datePicker);

		/**
		 * "Next Date" button to move the date forward by one day	
		 */
		JButton btnPrevDate = new JButton("");
		btnPrevDate.setRolloverIcon(new ImageIcon("src/main/resources/larrowWhite.png"));
		btnPrevDate.setIcon(new ImageIcon("src/main/resources/LArrow.png"));
		btnPrevDate.setOpaque(true);
		btnPrevDate.setBounds(217, 93, 50, 50);
		panelDashboardView.add(btnPrevDate);
		btnPrevDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datePicker.getModel().setDay(datePicker.getModel().getDay()-1);
				CalendarToAPI();
			}
		});

		/**
		 * "Previous Date" button to move the date back by one day	
		 */
		JButton btnNextDate = new JButton("");
		btnNextDate.setRolloverIcon(new ImageIcon("src/main/resources/rArrowWhite.png"));
		btnNextDate.setIcon(new ImageIcon("src/main/resources/rArrow.png"));
		btnNextDate.setOpaque(true);
		btnNextDate.setBounds(460, 93, 50, 50);
		panelDashboardView.add(btnNextDate);
		btnNextDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datePicker.getModel().setDay(datePicker.getModel().getDay()+1);
				CalendarToAPI();

			}
		});


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

		///Uncomment to see and change added panels in window builder.////////////////

		//panelDashboardView.add(dailyTotalDistPanel);
		//panelDashboardView.add(dailyActiveMinPanel);		
		//panelDashboardView.add(dailySedMinPanel);			
		//panelDashboardView.add(dailyCaloriesPanel);			
		//panelDashboardView.add(dailyFloorsPanel);			
		//panelDashboardView.add(dailyStepsPanel);	

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

		SettingsRecord sr = new SettingsRecord(dist, calories, sedMin, activeMin, floors, steps, panelArray, radioCounter(), dailyCaloriesPanel, dailyTotalDistPanel, dailyActiveMinPanel, dailySedMinPanel, dailyFloorsPanel, dailyStepsPanel);
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

		JLabel lblDscp1 = new JLabel("<description>");
		lblDscp1.setForeground(Color.WHITE);
		lblDscp1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDscp1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDscp1.setBounds(290, 103, 369, 23);
		panelAccoladesView.add(lblDscp1);

		JLabel lblDscp2 = new JLabel("<description>");
		lblDscp2.setForeground(Color.WHITE);
		lblDscp2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDscp2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDscp2.setBounds(290, 138, 369, 23);
		panelAccoladesView.add(lblDscp2);

		JLabel lblDscp3 = new JLabel("<description>");
		lblDscp3.setForeground(Color.WHITE);
		lblDscp3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDscp3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDscp3.setBounds(290, 173, 369, 23);
		panelAccoladesView.add(lblDscp3);

		JLabel lblDscp4 = new JLabel("<description>");
		lblDscp4.setForeground(Color.WHITE);
		lblDscp4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDscp4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDscp4.setBounds(290, 208, 369, 23);
		panelAccoladesView.add(lblDscp4);

		JLabel lblDscp5 = new JLabel("<description>");
		lblDscp5.setForeground(Color.WHITE);
		lblDscp5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDscp5.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDscp5.setBounds(290, 243, 369, 23);
		panelAccoladesView.add(lblDscp5);

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
		lblLifetimeTotalsDistVal.setFont(new Font("Lucida Grande", Font.PLAIN, 48));
		lblLifetimeTotalsDistVal
		.setHorizontalAlignment(SwingConstants.CENTER);
		lblLifetimeTotalsDistVal.setBounds(486, 384, 158, 101);
		panelLifetimeTotalsView.add(lblLifetimeTotalsDistVal);

		lblLifetimeTotalsFloorsVal = new JLabel();
		lblLifetimeTotalsFloorsVal.setForeground(Color.WHITE);
		lblLifetimeTotalsFloorsVal.setFont(new Font("Lucida Grande", Font.PLAIN, 48));
		lblLifetimeTotalsFloorsVal
		.setHorizontalAlignment(SwingConstants.CENTER);
		lblLifetimeTotalsFloorsVal.setBounds(278, 384, 167, 101);
		panelLifetimeTotalsView.add(lblLifetimeTotalsFloorsVal);

		lblLifetimeTotalsStepsVal = new JLabel();
		lblLifetimeTotalsStepsVal.setForeground(Color.WHITE);
		lblLifetimeTotalsStepsVal.setFont(new Font("Lucida Grande", Font.PLAIN, 48));
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

		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setForeground(Color.WHITE);
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelTimeSeriesView.add(lblLastUpdated);

		lblLastUpdatedTS = new JLabel();
		lblLastUpdatedTS.setForeground(Color.WHITE);
		lblLastUpdatedTS.setBounds(486, 540, 222, 16);
		lblLastUpdatedTS.setHorizontalAlignment(SwingConstants.TRAILING);
		panelTimeSeriesView.add(lblLastUpdatedTS);
		
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
		lblStepsCompare.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblStepsCompare.setHorizontalAlignment(SwingConstants.CENTER);
		lblStepsCompare.setForeground(Color.WHITE);
		lblStepsCompare.setBounds(563, 317, 96, 46);
		panelDailyGoalsView.add(lblStepsCompare);

		lblDistanceCompare = new JLabel();
		lblDistanceCompare.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblDistanceCompare.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistanceCompare.setForeground(Color.WHITE);
		lblDistanceCompare.setBounds(563, 180, 96, 46);
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
		lblHeartRest.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblHeartRest.setForeground(Color.WHITE);
		lblHeartRest.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartRest.setBounds(59, 211, 289, 61);
		panelHeartrateZonesView.add(lblHeartRest);

		lblHeartMins = new JLabel();
		lblHeartMins.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblHeartMins.setForeground(Color.WHITE);
		lblHeartMins.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeartMins.setBounds(372, 211, 286, 61);
		panelHeartrateZonesView.add(lblHeartMins);

		lblHeartCardioMaxMin = new JLabel();
		lblHeartCardioMaxMin.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblHeartCardioMaxMin.setForeground(Color.WHITE);
		lblHeartCardioMaxMin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHeartCardioMaxMin.setBounds(59, 318, 289, 45);
		panelHeartrateZonesView.add(lblHeartCardioMaxMin);

		lblHeartFatBurnMaxMin = new JLabel();
		lblHeartFatBurnMaxMin.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblHeartFatBurnMaxMin.setForeground(Color.WHITE);
		lblHeartFatBurnMaxMin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHeartFatBurnMaxMin.setBounds(372, 318, 286, 45);
		panelHeartrateZonesView.add(lblHeartFatBurnMaxMin);

		lblHeartPeakMaxMin = new JLabel();
		lblHeartPeakMaxMin.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblHeartPeakMaxMin.setForeground(Color.WHITE);
		lblHeartPeakMaxMin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHeartPeakMaxMin.setBounds(62, 434, 286, 45);
		panelHeartrateZonesView.add(lblHeartPeakMaxMin);

		lblHeartOORMaxMin = new JLabel();
		lblHeartOORMaxMin.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblHeartOORMaxMin.setForeground(Color.WHITE);
		lblHeartOORMaxMin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHeartOORMaxMin.setBounds(372, 434, 289, 45);
		panelHeartrateZonesView.add(lblHeartOORMaxMin);

		JLabel lblLastUpdated = new JLabel("Last Updated:");
		lblLastUpdated.setForeground(Color.WHITE);
		lblLastUpdated.setBounds(410, 540, 90, 16);
		panelHeartrateZonesView.add(lblLastUpdated);

		lblLastUpdatedHRZ = new JLabel();
		lblLastUpdatedHRZ.setForeground(Color.WHITE);
		lblLastUpdatedHRZ.setBounds(486, 540, 222, 16);
		lblLastUpdatedHRZ.setHorizontalAlignment(SwingConstants.TRAILING);
		panelHeartrateZonesView.add(lblLastUpdatedHRZ);
		
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
		/**
		 * Switch window to Best Days screen:
		 */
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

		/**
		 * Switch window to Daily Dashboard screen:
		 */
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
		 *  Switch window to Lifetime Totals screen:
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

		/**
		 * Switch window to Daily Goals screen:
		 */
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
		 *  Switch window to Accolades screen:
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
		 *  Switch window to Timeseries screen:
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
		 *  Switch window to Heart Rate Zones screen:
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
			// Add images:
			JLabel img_21 = new ILabel();
			onePanel_1.setLayout(null);
			onePanel_1.add(img_21);
			// ---
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
			// Add images:
			JLabel img_19 = new ILabel();
			JLabel img_20 = new ILabel();
			twoPanel_1.setLayout(null);
			twoPanel_1.add(img_19);
			twoPanel_2.setLayout(null);
			twoPanel_2.add(img_20);
			// ---
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
			// Add images:
			JLabel img_16 = new ILabel();
			JLabel img_17 = new ILabel();
			JLabel img_18 = new ILabel();
			threePanel_1.setLayout(null);
			threePanel_1.add(img_16);
			threePanel_2.setLayout(null);
			threePanel_2.add(img_17);
			threePanel_3.setLayout(null);
			threePanel_3.add(img_18);
			// ---
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
			// Add images:
			JLabel img_12 = new ILabel();
			JLabel img_13 = new ILabel();
			JLabel img_14 = new ILabel();
			JLabel img_15 = new ILabel();
			fourPanel_1.setLayout(null);
			fourPanel_1.add(img_12);
			fourPanel_2.setLayout(null);
			fourPanel_2.add(img_13);
			fourPanel_3.setLayout(null);
			fourPanel_3.add(img_14);
			fourPanel_4.setLayout(null);
			fourPanel_4.add(img_15);
			// ---
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
			// Add images:
			JLabel img_7 = new ILabel();
			JLabel img_8 = new ILabel();
			JLabel img_9 = new ILabel();
			JLabel img_10 = new ILabel();
			JLabel img_11 = new ILabel();
			fivePanel_1.setLayout(null);
			fivePanel_1.add(img_7);
			fivePanel_2.setLayout(null);
			fivePanel_2.add(img_8);
			fivePanel_3.setLayout(null);
			fivePanel_3.add(img_9);
			fivePanel_4.setLayout(null);
			fivePanel_4.add(img_10);
			fivePanel_5.setLayout(null);
			fivePanel_5.add(img_11);
			// ---
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
			// Add images:
			JLabel img_1 = new ILabel();
			JLabel img_2 = new ILabel();
			JLabel img_3 = new ILabel();
			JLabel img_4 = new ILabel();
			JLabel img_5 = new ILabel();
			JLabel img_6 = new ILabel();
			sixPanel_1.setLayout(null);
			sixPanel_1.add(img_1);
			sixPanel_2.setLayout(null);
			sixPanel_2.add(img_2);
			sixPanel_3.setLayout(null);
			sixPanel_3.add(img_3);
			sixPanel_4.setLayout(null);
			sixPanel_4.add(img_4);
			sixPanel_5.setLayout(null);
			sixPanel_5.add(img_5);
			sixPanel_6.add(img_6);
			// ---

			SixPanel.setVisible(true);
			break;
		}

		save_settings();

	}

	/**
	 * Returns the date selected on the calendar icon as a String.
	 * @return a String representing the date selected on the calendar.
	 */
	public String CalendarToAPI(){
		System.out.println(datePicker.getJFormattedTextField().getText());
		return datePicker.getJFormattedTextField().getText();
	}
}