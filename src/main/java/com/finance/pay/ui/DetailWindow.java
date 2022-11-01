package com.finance.pay.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DetailWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailWindow window = new DetailWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DetailWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel DetailTitleLabel = new JLabel("계정 세부 내용");
		DetailTitleLabel.setForeground(Color.WHITE);
		DetailTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		DetailTitleLabel.setBackground(Color.GRAY);
		DetailTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DetailTitleLabel.setBounds(0, 0, 334, 35);
		DetailTitleLabel.setOpaque(true);
		frame.getContentPane().add(DetailTitleLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 240, 245));
		panel.setBounds(0, 45, 334, 396);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("PW 받기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnNewButton.setBounds(116, 346, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("닫기");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnNewButton_1.setBounds(225, 346, 97, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PW 변경");
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnNewButton_2.setBounds(7, 347, 97, 23);
		panel.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(107, 10, 215, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(107, 48, 215, 30);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(107, 88, 215, 30);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(107, 128, 215, 30);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(107, 168, 215, 30);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(107, 208, 215, 30);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(107, 248, 215, 30);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(107, 288, 215, 30);
		panel.add(textField_7);
	}
}
