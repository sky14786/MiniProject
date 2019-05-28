package com.job.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import com.job.controller.OwnerSignUpController;

import javax.swing.JTextField;
import javax.swing.JButton;

public class OwnerSignUpView {

	private JFrame frame;
	private JTextField tfID;
	private JTextField tfPW;
	private JTextField tfName;
	private JTextField tfbNumber;
	private JTextField tfAddr;
	private JButton btnSignUp, btnBack;
	private OwnerSignUpController ownerSignUpController = new OwnerSignUpController();
	private JLabel lbErrorMsg;
	private JButton btnDuplicateCheck;
	private boolean isDuplicate;

	public OwnerSignUpView() {
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
		label.setBounds(158, 38, 275, 59);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("ID :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("나눔스퀘어", Font.PLAIN, 17));
		label_1.setBounds(106, 120, 87, 35);
		frame.getContentPane().add(label_1);

		tfID = new JTextField();
		tfID.setColumns(10);
		tfID.setBounds(219, 120, 189, 35);
		frame.getContentPane().add(tfID);

		JLabel label_2 = new JLabel("PW :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("나눔스퀘어", Font.PLAIN, 17));
		label_2.setBounds(106, 173, 87, 35);
		frame.getContentPane().add(label_2);

		tfPW = new JTextField();
		tfPW.setColumns(10);
		tfPW.setBounds(219, 173, 189, 35);
		frame.getContentPane().add(tfPW);

		JLabel label_3 = new JLabel("\uC774\uB984 :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("나눔스퀘어", Font.PLAIN, 17));
		label_3.setBounds(106, 225, 87, 35);
		frame.getContentPane().add(label_3);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(219, 225, 189, 35);
		frame.getContentPane().add(tfName);

		JLabel label_4 = new JLabel("\uC0AC\uC5C5\uC790\uB4F1\uB85D\uBC88\uD638 :");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("나눔스퀘어", Font.PLAIN, 17));
		label_4.setBounds(57, 279, 136, 35);
		frame.getContentPane().add(label_4);

		tfbNumber = new JTextField();
		tfbNumber.setColumns(10);
		tfbNumber.setBounds(219, 279, 189, 35);
		frame.getContentPane().add(tfbNumber);

		JLabel label_5 = new JLabel("\uC8FC\uC18C : ");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("나눔스퀘어", Font.PLAIN, 17));
		label_5.setBounds(106, 335, 87, 35);
		frame.getContentPane().add(label_5);

		tfAddr = new JTextField();
		tfAddr.setColumns(10);
		tfAddr.setBounds(219, 335, 189, 35);
		frame.getContentPane().add(tfAddr);

		btnSignUp = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnSignUp.setFont(new Font("나눔스퀘어", Font.PLAIN, 26));
		btnSignUp.setBounds(74, 433, 189, 94);
		frame.getContentPane().add(btnSignUp);

		btnBack = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnBack.setFont(new Font("나눔스퀘어", Font.PLAIN, 26));
		btnBack.setBounds(311, 433, 189, 94);
		frame.getContentPane().add(btnBack);

		lbErrorMsg = new JLabel("");
		lbErrorMsg.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		lbErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lbErrorMsg.setBounds(74, 395, 423, 28);
		frame.getContentPane().add(lbErrorMsg);

		btnDuplicateCheck = new JButton("\uC911\uBCF5\uCCB4\uD06C");
		btnDuplicateCheck.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
		btnDuplicateCheck.setBounds(429, 120, 87, 35);
		frame.getContentPane().add(btnDuplicateCheck);

		setSignUpButton();
		setDuplicateCheckButton();
		setBackButton();
	}

	public void resetTextField() {
		tfID.setText("");
		tfPW.setText("");
		tfName.setText("");
		tfbNumber.setText("");
		tfAddr.setText("");
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
					if (ownerSignUpController.duplicateCheck(tfID.getText())) {
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
							if (!tfbNumber.getText().equals("")) {
								if (!tfAddr.getText().equals("")) {
									if (isDuplicate) {
										ownerSignUpController.addOwner(tfID.getText(), tfPW.getText(), tfName.getText(),
												tfbNumber.getText(), tfAddr.getText());

										resetTextField();
									} else {
										lbErrorMsg.setText("ID 중복검사를 하세요.");
									}
								} else {
									lbErrorMsg.setText("주소를 입력해 주세요.");
								}
							} else {
								lbErrorMsg.setText("사업자등록번호를 입력해 주세요.");
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
