package com.job.view;

import java.awt.Font;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.job.controller.PartimerSignUpController;
import java.awt.Color;
import java.awt.Toolkit;

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
	private JLabel label;

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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Git\\Mini Project\\MiniProject\\src\\resource\\MainLogo.png"));
		frame.setTitle("\uD68C\uC6D0\uAC00\uC785 - \uC544\uB974\uBC14\uC774\uD2B8");
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		tfID = new JTextField();
		tfID.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		tfID.setColumns(10);
		tfID.setBounds(165, 151, 189, 35);
		tfID.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfID.setOpaque(false);
		frame.getContentPane().add(tfID);

		tfPW = new JTextField();
		tfPW.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		tfPW.setColumns(10);
		tfPW.setBounds(165, 221, 189, 35);
		tfPW.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfPW.setOpaque(false);
		frame.getContentPane().add(tfPW);

		tfName = new JTextField();
		tfName.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		tfName.setColumns(10);
		tfName.setBounds(165, 292, 189, 35);
		tfName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfName.setOpaque(false);
		frame.getContentPane().add(tfName);

		tfAge = new JTextField();
		tfAge.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		tfAge.setColumns(10);
		tfAge.setBounds(165, 361, 189, 35);
		tfAge.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfAge.setOpaque(false);
		frame.getContentPane().add(tfAge);

		tfPhone = new JTextField();
		tfPhone.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		tfPhone.setColumns(10);
		tfPhone.setBounds(165, 430, 203, 35);
		tfPhone.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfPhone.setOpaque(false);
		frame.getContentPane().add(tfPhone);

		radio[0] = new JRadioButton("\uC5EC");
		radio[0].setBounds(480, 365, 50, 33);
		radio[0].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		radio[0].setOpaque(false);
		radio[0].setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		frame.getContentPane().add(radio[0]);

		radio[1] = new JRadioButton("\uB0A8");
		radio[1].setBounds(420, 365, 50, 33);
		radio[1].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		radio[1].setOpaque(false);
		radio[1].setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		frame.getContentPane().add(radio[1]);

		rbg.add(radio[0]);
		rbg.add(radio[1]);

		btnSignUp = new JButton("");
		btnSignUp.setIcon(new ImageIcon(this.getClass().getResource("/resource/SignUpButton.png")));
		btnSignUp.setFont(new Font("나눔스퀘어", Font.PLAIN, 26));
		btnSignUp.setBounds(134, 507, 146, 53);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		frame.getContentPane().add(btnSignUp);

		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(this.getClass().getResource("/resource/BackButton.png")));
		btnBack.setFont(new Font("나눔스퀘어", Font.PLAIN, 26));
		btnBack.setBounds(328, 507, 146, 53);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		frame.getContentPane().add(btnBack);

		btnDuplicateCheck = new JButton("");
		btnDuplicateCheck
				.setIcon(new ImageIcon(this.getClass().getResource("/resource/DuplicateCheckButton.png")));
		btnDuplicateCheck.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
		btnDuplicateCheck.setBounds(401, 143, 112, 53);
		btnDuplicateCheck.setContentAreaFilled(false);
		btnDuplicateCheck.setBorderPainted(false);
		frame.getContentPane().add(btnDuplicateCheck);

		lbErrorMsg = new JLabel("");
		lbErrorMsg.setForeground(Color.RED);
		lbErrorMsg.setHorizontalAlignment(SwingConstants.LEFT);
		lbErrorMsg.setFont(new Font("나눔스퀘어", Font.PLAIN, 22));
		lbErrorMsg.setBounds(483, 29, 423, 44);
		frame.getContentPane().add(lbErrorMsg);

		label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/resource/PartimerSignUpImage2.jpg")));
		label.setBounds(0, 0, 994, 571);
		frame.getContentPane().add(label);

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
