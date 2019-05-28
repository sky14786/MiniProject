package com.job.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

		btnPartimer = new JButton("\uAD6C\uC9C1");
		btnPartimer.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 26));
		btnPartimer.setBounds(12, 76, 189, 94);
		frame.getContentPane().add(btnPartimer);

		btnOwner = new JButton("\uAD6C\uC778");
		btnOwner.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 26));
		btnOwner.setBounds(233, 76, 189, 94);
		frame.getContentPane().add(btnOwner);

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
