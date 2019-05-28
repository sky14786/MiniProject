package com.job.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.job.controller.NoticeRegisterController;

public class NoticeRegisterView {

	private JFrame frame;
	private JTextField tfBName;
	private JTextField tfPay;
	private JTextField tfTimeToTime;
	private JTextField tfCategory;
	private JTextField tfAddr;
	private JTextField tfBKeyword1;
	private JTextField tfBKeyword2;
	private JTextField tfBKeyword3;
	private JButton btnAddNotice, btnBack;
	private JTextArea taETC;
	private JComboBox periodType, timeType;
	private NoticeRegisterController noticeRegisterController = new NoticeRegisterController();
	private JLabel lbErrorMsg;

	public NoticeRegisterView() {
		initialize();
	}

	public static void main(String[] args) {
		NoticeRegisterView window = new NoticeRegisterView();

		window.frame.setVisible(true);

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\uC5C5\uC7A5\uBA85 :");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label.setBounds(116, 89, 87, 35);
		frame.getContentPane().add(label);

		tfBName = new JTextField();
		tfBName.setColumns(10);
		tfBName.setBounds(229, 89, 189, 35);
		frame.getContentPane().add(tfBName);

		JLabel label_1 = new JLabel("\uC2DC\uAE09 :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_1.setBounds(116, 142, 87, 35);
		frame.getContentPane().add(label_1);

		tfPay = new JTextField();
		tfPay.setColumns(10);
		tfPay.setBounds(229, 142, 189, 35);
		frame.getContentPane().add(tfPay);

		JLabel label_2 = new JLabel("\uADFC\uBB34\uC2DC\uAC04 :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_2.setBounds(116, 194, 87, 35);
		frame.getContentPane().add(label_2);

		tfTimeToTime = new JTextField();
		tfTimeToTime.setColumns(10);
		tfTimeToTime.setBounds(229, 194, 189, 35);
		frame.getContentPane().add(tfTimeToTime);

		JLabel label_3 = new JLabel("\uADFC\uBB34\uD615\uD0DC :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_3.setBounds(67, 250, 136, 35);
		frame.getContentPane().add(label_3);

		tfCategory = new JTextField();
		tfCategory.setColumns(10);
		tfCategory.setBounds(229, 250, 189, 35);
		frame.getContentPane().add(tfCategory);

		JLabel laddr = new JLabel("\uC8FC\uC18C : ");
		laddr.setHorizontalAlignment(SwingConstants.RIGHT);
		laddr.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		laddr.setBounds(116, 308, 87, 35);
		frame.getContentPane().add(laddr);

		tfAddr = new JTextField();
		tfAddr.setColumns(10);
		tfAddr.setBounds(229, 308, 189, 35);
		frame.getContentPane().add(tfAddr);

		btnAddNotice = new JButton("\uACF5\uACE0\uB4F1\uB85D");
		btnAddNotice.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 26));
		btnAddNotice.setContentAreaFilled(false);
		btnAddNotice.setBorderPainted(false);
		btnAddNotice.setBounds(78, 689, 135, 59);
		frame.getContentPane().add(btnAddNotice);

		JLabel label_5 = new JLabel("\uAD6C\uC778\uACF5\uACE0\uB4F1\uB85D");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("¹è´ÞÀÇ¹ÎÁ· ÁÖ¾Æ", Font.BOLD, 34));
		label_5.setBounds(160, 10, 275, 59);
		frame.getContentPane().add(label_5);

		tfBKeyword1 = new JTextField();
		tfBKeyword1.setColumns(10);
		tfBKeyword1.setBounds(87, 373, 87, 35);
		frame.getContentPane().add(tfBKeyword1);

		JLabel lkeyword = new JLabel("\uD0A4\uC6CC\uB4DC 1:");
		lkeyword.setHorizontalAlignment(SwingConstants.RIGHT);
		lkeyword.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		lkeyword.setBounds(-12, 373, 87, 35);
		frame.getContentPane().add(lkeyword);

		JLabel label_7 = new JLabel("\uD0A4\uC6CC\uB4DC 2:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_7.setBounds(168, 373, 87, 35);
		frame.getContentPane().add(label_7);

		tfBKeyword2 = new JTextField();
		tfBKeyword2.setColumns(10);
		tfBKeyword2.setBounds(274, 373, 87, 35);
		frame.getContentPane().add(tfBKeyword2);

		JLabel label_8 = new JLabel("\uD0A4\uC6CC\uB4DC 3:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_8.setBounds(366, 373, 87, 35);
		frame.getContentPane().add(label_8);

		tfBKeyword3 = new JTextField();
		tfBKeyword3.setColumns(10);
		tfBKeyword3.setBounds(470, 373, 87, 35);
		frame.getContentPane().add(tfBKeyword3);

		btnBack = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnBack.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 26));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setBounds(318, 689, 135, 59);
		frame.getContentPane().add(btnBack);

		JLabel label_9 = new JLabel("\uC0C1\uC138\uB0B4\uC6A9 :");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 17));
		label_9.setBounds(53, 447, 87, 35);
		frame.getContentPane().add(label_9);

		taETC = new JTextArea();
		taETC.setBounds(151, 447, 360, 209);
		frame.getContentPane().add(taETC);

		periodType = new JComboBox();
		periodType.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 14));
		periodType.setModel(new DefaultComboBoxModel(
				new String[] { "\uAE30\uAC04 \uC120\uD0DD", "\uD558\uB8E8", "\uC77C\uC8FC\uC77C",
						"1\uAC1C\uC6D4 \uC774\uC0C1", "3\uAC1C\uC6D4 \uC774\uC0C1", "6\uAC1C\uC6D4 \uC774\uC0C1" }));
		periodType.setBounds(435, 250, 122, 35);
		frame.getContentPane().add(periodType);

		timeType = new JComboBox();
		timeType.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 14));
		timeType.setModel(new DefaultComboBoxModel(new String[] { "\uC2DC\uAC04 \uC120\uD0DD",
				"1\uC2DC\uAC04 ~ 3\uC2DC\uAC04", "3\uC2DC\uAC04 ~ 6\uC2DC\uAC04", "6\uC2DC\uAC04 ~ 8\uC2DC\uAC04",
				"8\uC2DC\uAC04\uC774\uC0C1" }));
		timeType.setBounds(435, 308, 122, 35);
		frame.getContentPane().add(timeType);

		lbErrorMsg = new JLabel("");
		lbErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lbErrorMsg.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 15));
		lbErrorMsg.setBounds(78, 667, 423, 28);
		frame.getContentPane().add(lbErrorMsg);

		setAddNoticeButton();
		setBackButton();
	}

	public void setAddNoticeButton() {
		btnAddNotice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(tfAddr.getText().equals("") && tfBName.getText().equals("") && tfCategory.getText().equals("")
						&& tfPay.getText().equals("") && tfTimeToTime.getText().equals("")
						&& timeType.getSelectedItem().toString().equals("½Ã°£ ¼±ÅÃ")
						&& periodType.getSelectedItem().toString().equals("±â°£ ¼±ÅÃ"))) {
					noticeRegisterController.addNotice(tfBName.getText(), Double.parseDouble(tfPay.getText()),
							tfTimeToTime.getText(), tfCategory.getText(), tfBKeyword1.getText(), tfBKeyword2.getText(),
							tfBKeyword3.getText(), taETC.getText(), periodType.getSelectedItem().toString(),
							timeType.getSelectedItem().toString());
					resetTextField();
				} else {
					lbErrorMsg.setText("ºóÄ­ ¾øÀÌ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
				}
			}
		});
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

	public void resetTextField() {
		tfAddr.setText("");
		tfBKeyword1.setText("");
		tfBKeyword2.setText("");
		tfBKeyword3.setText("");
		tfBName.setText("");
		tfCategory.setText("");
		tfPay.setText("");
		tfTimeToTime.setText("");
		timeType.setSelectedItem("½Ã°£ ¼±ÅÃ");
		periodType.setSelectedItem("±â°£ ¼±ÅÃ");
		taETC.setText("");
	}

}
