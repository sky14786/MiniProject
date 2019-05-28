package com.job.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.job.controller.LoginController;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

public class LoginView {

	private SignUpCategory signUpCategory = new SignUpCategory();

	private JFrame frame;
	private JTextField tfID;
	private JTextField tfPW;
	private JButton btnLogin;
	private JButton btnSignup;
	private LoginController loginController = new LoginController();
	private JRadioButton radio[] = new JRadioButton[2];
	private ButtonGroup rbg = new ButtonGroup();
	private JLabel lbTest;

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
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Git\\Mini Project\\MiniProject\\src\\resource\\MainLogo.png"));
		frame.setTitle("\uC54C\uBC14\uC758\uBBFC\uC871");
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tfID = new JTextField();
		tfID.setBounds(188, 463, 189, 35);
		frame.getContentPane().add(tfID);
		tfID.setColumns(10);

		tfPW = new JTextField();
		tfPW.setColumns(10);
		tfPW.setBounds(188, 506, 189, 35);
		frame.getContentPane().add(tfPW);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		btnLogin.setBounds(402, 463, 125, 35);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		frame.getContentPane().add(btnLogin);

		btnSignup = new JButton("SignUp");
		btnSignup.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		btnSignup.setBounds(402, 506, 125, 35);
		btnSignup.setContentAreaFilled(false);
		btnSignup.setBorderPainted(false);
		frame.getContentPane().add(btnSignup);

		radio[0] = new JRadioButton("\uAD6C\uC778");
		radio[0].setBounds(416, 410, 66, 23);
		frame.getContentPane().add(radio[0]);
		radio[0].setOpaque(false);

		radio[1] = new JRadioButton("\uAD6C\uC9C1");
		radio[1].setBounds(488, 410, 72, 23);
		frame.getContentPane().add(radio[1]);
		radio[1].setOpaque(false);

		lbTest = new JLabel("");
		lbTest.setBounds(59, 415, 194, 25);
		lbTest.setEnabled(true);
		frame.getContentPane().add(lbTest);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Git\\Mini Project\\MiniProject\\src\\resource\\back2.png"));
		label_1.setBounds(0, 0, 584, 561);
		frame.getContentPane().add(label_1);

		rbg.add(radio[0]);
		rbg.add(radio[1]);

		setSignUpButton();
		setLoginButton();
	}

	public void setSignUpButton() {
		btnSignup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signUpCategory.showThisView();

			}
		});
	}

	public void setLoginButton() {
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (loginController.login(tfID.getText(), tfPW.getText(), radio[0].isSelected())) {
				case 1:
					lbTest.setText("로그인 성공");
					break;
				case 2:
					lbTest.setText("존재하지 않는 아이디입니다.");
					break;
				case 3:
					lbTest.setText("비밀번호가 틀렸습니다.");
					break;
				}
			}
		});
	}

}
