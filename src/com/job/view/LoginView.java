package com.job.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.job.controller.LoginController;
import com.job.run.Run;

public class LoginView extends JPanel {

	private JTextField tfID;
	private JPasswordField tfPW;
	private JButton btnLogin;
	private JButton btnSignup;
	private LoginController loginController = new LoginController();
	private JRadioButton radio[] = new JRadioButton[2];
	private ButtonGroup rbg = new ButtonGroup();
	private JLabel lbTest;
	public Run win;

	public LoginView(Run win) {
		this.win = win;
		initialize();
	}

	private void initialize() {
		setLayout(null);

		tfID = new JTextField();
		tfID.setText("");
		tfID.setBounds(164, 462, 189, 35);
		tfID.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfID.setColumns(10);
		tfID.setBorder(null);
		tfID.setOpaque(false);

		tfPW = new JPasswordField();
		tfPW.setEchoChar('*');
		tfPW.setColumns(10);
		tfPW.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfPW.setBounds(164, 505, 189, 35);
		tfPW.setBorder(null);
		tfPW.setOpaque(false);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		btnLogin.setBounds(402, 463, 125, 35);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);

		btnSignup = new JButton("SignUp");
		btnSignup.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		btnSignup.setBounds(402, 506, 125, 35);
		btnSignup.setContentAreaFilled(false);
		btnSignup.setBorderPainted(false);

		radio[0] = new JRadioButton("\uAD6C\uC778");
		radio[0].setBounds(416, 410, 66, 23);
		radio[0].setOpaque(false);

		radio[1] = new JRadioButton("\uAD6C\uC9C1");
		radio[1].setBounds(488, 410, 72, 23);
		radio[1].setOpaque(false);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/resource/back3.png")));
		label_1.setBounds(0, 0, 584, 561);

		rbg.add(radio[0]);
		rbg.add(radio[1]);

		add(tfID);
		add(tfPW);
		add(btnLogin);
		add(btnSignup);
		add(radio[0]);
		add(radio[1]);

		lbTest = new JLabel("");
		lbTest.setBounds(51, 412, 194, 25);
		lbTest.setEnabled(true);
		add(lbTest);
		add(label_1);

		setSignUpButton();
		setLoginButton();
		
		radio[0].setSelected(true);

	}

	public void resetTextField() {
		tfID.setText("");
		tfPW.setText("");
		lbTest.setText("");
	}

	public void setSignUpButton() {
		btnSignup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetTextField();
				win.getContentPane().removeAll();
				win.getContentPane().add(win.signUpCategory);
				win.setSize(450, 300);
				revalidate();
				repaint();
			}
		});
	}

	public void setLoginButton() {
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (loginController.login(tfID.getText(), tfPW.getText(), radio[0].isSelected())) {
				case 1:
					resetTextField();
					win.getContentPane().removeAll();
					win.getContentPane().add(win.noticeRegisterView);
					win.setSize(1000, 600);
					revalidate();
					repaint();
					break;
				case 4:
					lbTest.setText("구직 로그인 성공");
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
