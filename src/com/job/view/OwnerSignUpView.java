package com.job.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class OwnerSignUpView {

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
					OwnerSignUpView window = new OwnerSignUpView();
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
	public OwnerSignUpView() {
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
		label.setBounds(158, 38, 275, 59);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("ID :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_1.setBounds(106, 120, 87, 35);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(219, 120, 189, 35);
		frame.getContentPane().add(textField);
		
		JLabel label_2 = new JLabel("PW :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_2.setBounds(106, 173, 87, 35);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(219, 173, 189, 35);
		frame.getContentPane().add(textField_1);
		
		JLabel label_3 = new JLabel("\uC774\uB984 :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_3.setBounds(106, 225, 87, 35);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(219, 225, 189, 35);
		frame.getContentPane().add(textField_2);
		
		JLabel label_4 = new JLabel("\uC0AC\uC5C5\uC790\uB4F1\uB85D\uBC88\uD638 :");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_4.setBounds(57, 279, 136, 35);
		frame.getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(219, 279, 189, 35);
		frame.getContentPane().add(textField_3);
		
		JLabel label_5 = new JLabel("\uC8FC\uC18C : ");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_5.setBounds(106, 335, 87, 35);
		frame.getContentPane().add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(219, 335, 189, 35);
		frame.getContentPane().add(textField_4);
		
		JButton button = new JButton("\uD68C\uC6D0\uAC00\uC785");
		button.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 26));
		button.setBounds(74, 433, 189, 94);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		button_1.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 26));
		button_1.setBounds(311, 433, 189, 94);
		frame.getContentPane().add(button_1);
	}

}
