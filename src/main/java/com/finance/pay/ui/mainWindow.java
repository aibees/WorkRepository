package com.finance.pay.ui;

import com.finance.pay.ui.common.CommonComponents;
import com.finance.pay.ui.tabbed.MilestoneTab;
import com.finance.pay.ui.tabbed.QuerySaveTab;
import com.finance.pay.ui.tabbed.SettingTab;
import com.finance.pay.ui.tabbed.WorkListTab;

import java.awt.EventQueue;

import javax.management.Query;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;

public class mainWindow {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	private final CommonComponents common = new CommonComponents();

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
	}

	/**
	 * frame visible
	 */
	public void start() {
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		// main frame
		frame = new JFrame();
		frame.setBounds(200, 200, 1100, 670);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
//		frame.getContentPane().setBackground(new Color(45, 180, 0), BorderLayout.SOUTH);

		JPanel workList = new WorkListTab();
		tabbedPane.addTab("업무리스트", null, workList, null);

		JPanel milestone = new MilestoneTab();
		tabbedPane.addTab("마일스톤", null, milestone, null);

		JPanel querySave = new QuerySaveTab();
		tabbedPane.addTab("쿼리저장소", null, querySave, "업무 별 쿼리저장");

		JPanel setting = new SettingTab();
		tabbedPane.addTab("설정", null, setting, "");

		frame.getContentPane().add(common.createFooter("NAVER CLOUD / Finance Dev1 / 박준서"), BorderLayout.SOUTH);
		frame.setResizable(false);

//		JPanel idSearch = new JPanel();
//		idSearch.setBackground(Color.WHITE);
//		tabbedPane.addTab("계정 검색", null, idSearch, null);
//		idSearch.setLayout(null);
//
//		JLabel header_1 = new JLabel("\uACC4\uC815 \uAC80\uC0C9");
//		header_1.setForeground(Color.WHITE);
//		header_1.setBackground(SystemColor.controlShadow);
//		header_1.setOpaque(true);
//		header_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
//		header_1.setHorizontalAlignment(SwingConstants.CENTER);
//		header_1.setBounds(0, 0, 562, 31);
//		idSearch.add(header_1);
//
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.WHITE);
//		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		panel.setBounds(0, 34, 562, 53);
//		idSearch.add(panel);
//
//		JPanel tableSearch = new JPanel();
//		tableSearch.setBackground(Color.WHITE);
//		tabbedPane.addTab("테이블 검색", null, tableSearch, null);
//		tableSearch.setLayout(null);
//
//		JLabel foot_2 = new JLabel("\uC7AC\uBB34\uC2DC\uC2A4\uD15C");
//		foot_2.setOpaque(true);
//		foot_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
//		foot_2.setForeground(Color.YELLOW);
//		foot_2.setBackground(SystemColor.desktop);
//		foot_2.setHorizontalAlignment(SwingConstants.CENTER);
//		foot_2.setBounds(0, 370, 562, 48);
//		tableSearch.add(foot_2);
//
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(Color.WHITE);
//		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panel_1.setBounds(0, 34, 562, 53);
//		tableSearch.add(panel_1);
//		panel_1.setLayout(null);
//
//		JButton btnNewButton = new JButton("검색");
//		btnNewButton.setBounds(482, 10, 68, 33);
//		panel_1.add(btnNewButton);
//
//		textField = new JTextField();
//		textField.setBounds(201, 16, 269, 21);
//		panel_1.add(textField);
//		textField.setColumns(10);
//
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(12, 16, 139, 21);
//		panel_1.add(comboBox);
//
//		JLabel header_2 = new JLabel("\uB808\uC774\uC544\uC6C3 \uAC80\uC0C9");
//		header_2.setForeground(Color.WHITE);
//		header_2.setOpaque(true);
//		header_2.setHorizontalAlignment(SwingConstants.CENTER);
//		header_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
//		header_2.setBackground(SystemColor.controlShadow);
//		header_2.setBounds(0, 0, 562, 31);
//		tableSearch.add(header_2);
//
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(0, 87, 1200, 285);
//		tableSearch.add(scrollPane);
//
//		table = new JTable();
//		table.setShowGrid(false);
//		table.setCellSelectionEnabled(true);
//		table.getTableHeader().setReorderingAllowed(false);
//		DefaultTableModel model = new DefaultTableModel(
//				new Object[][] {
//					{"toinb40", "토인비OS접속계정", "TOINB", "174.100.29.48", "DEV", "OS", "2021.02.15"}
//				},
//				new String[] {
//					"\uACC4\uC815\uBA85", "\uC124\uBA85", "\uAD6C\uBD84", "IP", "Env", "\uAD00\uB828\uC5C5\uBB34", "\uCD5C\uC885\uBCC0\uACBD\uC77C\uC790"
//				}
//
//			) {
//			Class[] columnTypes = new Class[] {
//					String.class, String.class, String.class, String.class, String.class, String.class, String.class
//				};
//				public Class getColumnClass(int columnIndex) {
//					return columnTypes[columnIndex];
//				}
//				public boolean isCellEditable(int row, int column) {
//					return false;
//				};
//		};
//
//		table.setModel(model);
//		scrollPane.setViewportView(table);
//
//		JScrollBar scrollBar = new JScrollBar();
//		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
//		scrollPane.setColumnHeaderView(scrollBar);
	}
}
