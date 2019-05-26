package com.job.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class LoginView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uC54C\uBC14\uC758\uBBFC\uC871");
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(238, 178, 189, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		lblId.setBounds(125, 178, 87, 35);
		frame.getContentPane().add(lblId);
		
		JLabel lblPw = new JLabel("PW :");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		lblPw.setBounds(125, 250, 87, 35);
		frame.getContentPane().add(lblPw);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(238, 250, 189, 35);
		frame.getContentPane().add(textField_1);
		
		JLabel label = new JLabel("\uC54C\uBC14\uC758\uBBFC\uC871");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("¹è´ÞÀÇ¹ÎÁ· ÁÖ¾Æ", Font.BOLD, 34));
		label.setBounds(152, 31, 275, 59);
		frame.getContentPane().add(label);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 26));
		btnNewButton.setBounds(83, 362, 189, 94);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\uB85C\uADF8\uC778");
		button.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 26));
		button.setBounds(320, 362, 189, 94);
		frame.getContentPane().add(button);
	}
}
