package com.job.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SignUpCategory {
	private OwnerSignUpView ownerSignUpView = new OwnerSignUpView();
	private PartimerSignUpView partimerSignUpView = new PartimerSignUpView();
	private JFrame frame;
	private JButton btnPartimer, btnOwner;

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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		btnPartimer = new JButton("");
		btnPartimer.setIcon(new ImageIcon(this.getClass().getResource("/resource/PartimerSignUpButton.jpg")));
		btnPartimer.setFont(new Font("배달의민족 주아", Font.PLAIN, 60));
		btnPartimer.setBounds(0, 0, 221, 271);
		btnPartimer.setContentAreaFilled(false);
		btnPartimer.setBorderPainted(false);
		frame.getContentPane().add(btnPartimer);

		btnOwner = new JButton("");
		btnOwner.setIcon(new ImageIcon(this.getClass().getResource("/resource/OwnerSignUpButton.jpg")));
		btnOwner.setFont(new Font("배달의민족 주아", Font.PLAIN, 60));
		btnOwner.setBounds(233, 0, 211, 271);
		btnOwner.setContentAreaFilled(false);
		btnOwner.setBorderPainted(false);
		frame.getContentPane().add(btnOwner);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/resource/categoryBack.jpg")));
		label.setBounds(0, 0, 444, 271);
		frame.getContentPane().add(label);

		setOwnerButton();
		setPartimerButton();

	}

	public void showThisView() {
		frame.setVisible(true);
	}

	private void setOwnerButton() {
		btnOwner.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ownerSignUpView.showThisView();
			}
		});
	}

	private void setPartimerButton() {
		btnPartimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				partimerSignUpView.showThisView();
			}
		});
	}
}
