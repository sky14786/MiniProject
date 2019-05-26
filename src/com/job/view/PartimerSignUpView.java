package com.job.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class PartimerSignUpView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartimerSignUpView window = new PartimerSignUpView();
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
	public PartimerSignUpView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("¹è´ÞÀÇ¹ÎÁ· ÁÖ¾Æ", Font.BOLD, 34));
		label.setBounds(158, 26, 275, 59);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("ID :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_1.setBounds(106, 108, 87, 35);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(219, 108, 189, 35);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(219, 161, 189, 35);
		frame.getContentPane().add(textField_1);
		
		JLabel lblPw = new JLabel("PW :");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		lblPw.setBounds(106, 161, 87, 35);
		frame.getContentPane().add(lblPw);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(219, 213, 189, 35);
		frame.getContentPane().add(textField_2);
		
		JLabel label_3 = new JLabel("\uC774\uB984 :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_3.setBounds(106, 213, 87, 35);
		frame.getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(219, 267, 189, 35);
		frame.getContentPane().add(textField_3);
		
		JLabel label_4 = new JLabel("\uB098\uC774 :");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_4.setBounds(106, 267, 87, 35);
		frame.getContentPane().add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(219, 348, 189, 35);
		frame.getContentPane().add(textField_4);
		
		JLabel label_5 = new JLabel("\uC5F0\uB77D\uCC98 : ");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_5.setBounds(106, 348, 87, 35);
		frame.getContentPane().add(label_5);
		
		JRadioButton radioButton_1 = new JRadioButton("\uC5EC");
		radioButton_1.setBounds(332, 313, 44, 23);
		frame.getContentPane().add(radioButton_1);
		
		JRadioButton radioButton = new JRadioButton("\uB0A8");
		radioButton.setBounds(230, 313, 50, 23);
		frame.getContentPane().add(radioButton);
		
		JButton button = new JButton("\uD68C\uC6D0\uAC00\uC785");
		button.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 26));
		button.setBounds(74, 421, 189, 94);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		button_1.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 26));
		button_1.setBounds(311, 421, 189, 94);
		frame.getContentPane().add(button_1);
	}
}
