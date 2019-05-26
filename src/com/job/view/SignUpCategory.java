package com.job.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpCategory {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpCategory window = new SignUpCategory();
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
	public SignUpCategory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("\uAD6C\uC9C1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 26));
		button.setBounds(12, 76, 189, 94);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\uAD6C\uC778");
		button_1.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 26));
		button_1.setBounds(233, 76, 189, 94);
		frame.getContentPane().add(button_1);
	}

}
