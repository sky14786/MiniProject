package com.job.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
import javax.swing.SwingConstants;

import com.job.controller.PartimerSignUpController;
import com.job.run.Run;

public class PartimerSignUpView extends JPanel {

	private JTextField tfID;
	private JPasswordField tfPW;
	private JTextField tfName;
	private JTextField tfAge;
	private JTextField tfPhone;
	private JLabel lbErrorMsg;
	private JButton btnBack, btnSignUp, btnDuplicateCheck;
	private PartimerSignUpController partimerSignUpController = new PartimerSignUpController();
	private boolean isDuplicate;
	private ButtonGroup rbg = new ButtonGroup();
	private JRadioButton[] radio = new JRadioButton[2];
	private JLabel label;
	public Run win;

	/**
	 * Create the application.
	 */
	public PartimerSignUpView(Run win) {
		this.win = win;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setLayout(null);

		Color fontColor = new Color(0x4f4f4f);

		tfID = new JTextField();
		tfID.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfID.setColumns(10);
		tfID.setForeground(fontColor);
		tfID.setBounds(165, 151, 189, 35);
		tfID.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfID.setOpaque(false);
		add(tfID);

		tfPW = new JPasswordField();
		tfPW.setEchoChar('*');
		tfPW.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfPW.setColumns(10);
		tfPW.setForeground(fontColor);
		tfPW.setBounds(165, 221, 189, 35);
		tfPW.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfPW.setOpaque(false);
		add(tfPW);

		tfName = new JTextField();
		tfName.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfName.setColumns(10);
		tfName.setForeground(fontColor);
		tfName.setBounds(165, 292, 189, 35);
		tfName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfName.setOpaque(false);
		add(tfName);

		tfAge = new JTextField();
		tfAge.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfAge.setColumns(10);
		tfAge.setForeground(fontColor);
		tfAge.setBounds(165, 361, 189, 35);
		tfAge.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfAge.setOpaque(false);
		add(tfAge);

		tfPhone = new JTextField();
		tfPhone.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfPhone.setColumns(10);
		tfPhone.setForeground(fontColor);
		tfPhone.setBounds(165, 430, 203, 35);
		tfPhone.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfPhone.setOpaque(false);
		add(tfPhone);

		radio[0] = new JRadioButton("\uC5EC");
		radio[0].setBounds(480, 365, 50, 33);
		radio[0].setForeground(fontColor);
		radio[0].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		radio[0].setOpaque(false);
		radio[0].setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		add(radio[0]);

		radio[1] = new JRadioButton("\uB0A8");
		radio[1].setBounds(420, 365, 50, 33);
		radio[1].setForeground(fontColor);
		radio[1].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		radio[1].setOpaque(false);
		radio[1].setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		add(radio[1]);

		rbg.add(radio[0]);
		rbg.add(radio[1]);

		btnSignUp = new JButton("");
		btnSignUp.setIcon(new ImageIcon(this.getClass().getResource("/resource/SignUpButton.png")));
		btnSignUp.setFont(new Font("나눔스퀘어", Font.PLAIN, 26));
		btnSignUp.setBounds(134, 507, 146, 53);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		add(btnSignUp);

		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(this.getClass().getResource("/resource/BackButton.png")));
		btnBack.setFont(new Font("나눔스퀘어", Font.PLAIN, 26));
		btnBack.setBounds(328, 507, 146, 53);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		add(btnBack);

		btnDuplicateCheck = new JButton("");
		btnDuplicateCheck.setIcon(new ImageIcon(this.getClass().getResource("/resource/DuplicateCheckButton.png")));
		btnDuplicateCheck.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
		btnDuplicateCheck.setBounds(401, 143, 112, 53);
		btnDuplicateCheck.setContentAreaFilled(false);
		btnDuplicateCheck.setBorderPainted(false);
		add(btnDuplicateCheck);

		lbErrorMsg = new JLabel("");
		lbErrorMsg.setForeground(Color.RED);
		lbErrorMsg.setHorizontalAlignment(SwingConstants.LEFT);
		lbErrorMsg.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbErrorMsg.setBounds(483, 29, 423, 44);
		add(lbErrorMsg);

		label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/resource/PartimerSignUpImage2.jpg")));
		label.setBounds(0, 0, 994, 571);
		add(label);

		setBackButton();
		setDuplicateCheckButton();
		setSignUpButton();

	}

	public void testPrompt() {
		tfID.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (tfID.getText().isEmpty()) {
					tfID.setText("ex)예시입니다.");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (tfID.getText().equals("ex)예시입니다.")) {
					tfID.setText("");
				}
			}
		});
	}

	public void resetTextField() {
		tfID.setText("");
		tfPW.setText("");
		tfName.setText("");
		tfPhone.setText("");
		tfAge.setText("");
		lbErrorMsg.setText("");

	}

	public void setBackButton() {
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveLoginView();
			}
		});
	}

	public void moveLoginView() {
		resetTextField();
		win.getContentPane().removeAll();
		win.getContentPane().add(win.loginView);
		win.setSize(590, 590);
		revalidate();
		repaint();
	}

	public void setDuplicateCheckButton() {
		btnDuplicateCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tfID.getText().equals("")) {
					if (partimerSignUpController.duplicateCheck(tfID.getText())) {
						isDuplicate = true;
						lbErrorMsg.setText("사용 가능한 ID 입니다.");
					} else {
						isDuplicate = false;
						lbErrorMsg.setText("사용중인 ID 입니다.");
					}
				} else {
					lbErrorMsg.setText("ID를 입력해 주세요.");
				}

			}
		});
	}

	public void setSignUpButton() {
		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tfID.getText().equals("")) {
					if (!tfPW.getText().equals("") && (tfPW.getText().length() >= 8 && tfPW.getText().length() <= 12)) {
						if (!tfName.getText().equals("")) {
							if (!tfAge.getText().equals("")) {
								if (!tfPhone.getText().equals("")) {
									if (isDuplicate) {
										partimerSignUpController.addPartimer(tfID.getText(), tfPW.getText(),
												tfName.getText(), Integer.parseInt(tfAge.getText()),
												radio[0].isSelected() == true ? "남자" : "여자", tfPhone.getText());

										resetTextField();
										moveLoginView();
									} else {
										lbErrorMsg.setText("ID 중복검사를 하세요.");
									}
								} else {
									lbErrorMsg.setText("연락처를 입력해 주세요.");
								}
							} else {
								lbErrorMsg.setText("나이를 입력해 주세요.");
							}
						} else {
							lbErrorMsg.setText("이름을 입력해 주세요.");
						}
					} else if (!(tfPW.getText().length() >= 8 && tfPW.getText().length() <= 12)) {
						lbErrorMsg.setText("비밀번호는 8~12자 입니다.");
					} else {
						lbErrorMsg.setText("PW를 입력해 주세요.");
					}
				} else {
					lbErrorMsg.setText("ID를 입력해 주세요.");
				}
			}
		});
	}
}
