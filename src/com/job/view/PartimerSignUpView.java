package com.job.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.job.controller.PartimerSignUpController;

public class PartimerSignUpView {

	private JFrame frame;
	private JTextField tfID;
	private JTextField tfPW;
	private JTextField tfName;
	private JTextField tfAge;
	private JTextField tfPhone;
	private JLabel lbErrorMsg;
	private JButton btnBack, btnSignUp, btnDuplicateCheck;
	private PartimerSignUpController partimerSignUpController = new PartimerSignUpController();
	private boolean isDuplicate;
	private ButtonGroup rbg = new ButtonGroup();
	private JRadioButton[] radio = new JRadioButton[2];

	/**
	 * Create the application.
	 */
	public PartimerSignUpView() {
		initialize();
	}

	public void showThisView() {
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("배달의민족 주아", Font.BOLD, 34));
		label.setBounds(158, 26, 275, 59);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("ID :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("나눔스퀘어", Font.PLAIN, 17));
		label_1.setBounds(106, 108, 87, 35);
		frame.getContentPane().add(label_1);

		tfID = new JTextField();
		tfID.setColumns(10);
		tfID.setBounds(219, 108, 189, 35);
		frame.getContentPane().add(tfID);

		tfPW = new JTextField();
		tfPW.setColumns(10);
		tfPW.setBounds(219, 161, 189, 35);
		frame.getContentPane().add(tfPW);

		JLabel lblPw = new JLabel("PW :");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setFont(new Font("나눔스퀘어", Font.PLAIN, 17));
		lblPw.setBounds(106, 161, 87, 35);
		frame.getContentPane().add(lblPw);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(219, 213, 189, 35);
		frame.getContentPane().add(tfName);

		JLabel label_3 = new JLabel("\uC774\uB984 :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("나눔스퀘어", Font.PLAIN, 17));
		label_3.setBounds(106, 213, 87, 35);
		frame.getContentPane().add(label_3);

		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(219, 267, 189, 35);
		frame.getContentPane().add(tfAge);

		JLabel label_4 = new JLabel("\uB098\uC774 :");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("나눔스퀘어", Font.PLAIN, 17));
		label_4.setBounds(106, 267, 87, 35);
		frame.getContentPane().add(label_4);

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(219, 348, 189, 35);
		frame.getContentPane().add(tfPhone);

		JLabel label_5 = new JLabel("\uC5F0\uB77D\uCC98 : ");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("나눔스퀘어", Font.PLAIN, 17));
		label_5.setBounds(106, 348, 87, 35);
		frame.getContentPane().add(label_5);

		radio[0] = new JRadioButton("\uC5EC");
		radio[0].setBounds(332, 313, 44, 23);
		frame.getContentPane().add(radio[0]);

		radio[1] = new JRadioButton("\uB0A8");
		radio[1].setBounds(230, 313, 50, 23);
		frame.getContentPane().add(radio[1]);

		rbg.add(radio[0]);
		rbg.add(radio[1]);

		btnSignUp = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnSignUp.setFont(new Font("나눔스퀘어", Font.PLAIN, 26));
		btnSignUp.setBounds(74, 421, 189, 94);
		frame.getContentPane().add(btnSignUp);

		btnBack = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnBack.setFont(new Font("나눔스퀘어", Font.PLAIN, 26));
		btnBack.setBounds(311, 421, 189, 94);
		frame.getContentPane().add(btnBack);

		btnDuplicateCheck = new JButton("\uC911\uBCF5\uCCB4\uD06C");
		btnDuplicateCheck.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
		btnDuplicateCheck.setBounds(425, 108, 87, 35);
		frame.getContentPane().add(btnDuplicateCheck);

		lbErrorMsg = new JLabel("");
		lbErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lbErrorMsg.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		lbErrorMsg.setBounds(75, 389, 423, 28);
		frame.getContentPane().add(lbErrorMsg);

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

	}

	public void setBackButton() {
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetTextField();
				frame.setVisible(false);
			}
		});
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
