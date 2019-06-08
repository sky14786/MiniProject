package com.job.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import com.job.view.NoticeRegisterView;

import com.job.model.Resume;
import com.job.run.Run;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OwnerDetailView extends JPanel {
	private JTextField textField;
	private Resume temp1 = null;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;

	public Run win = new Run();

	public OwnerDetailView(Run win) {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(14, 12, 451, 588);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(14, 51, 57, 30);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(184, 5, 116, 24);
		textField.setText("\uC0C1\uC138\uC815\uBCF4");
		panel.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("\uB098\uC774");
		label.setBounds(14, 99, 62, 18);
		panel.add(label);

		JLabel label_1 = new JLabel("\uC131\uBCC4");
		label_1.setBounds(14, 147, 62, 18);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_2.setBounds(14, 202, 62, 18);
		panel.add(label_2);

		JLabel lblNewLabel_1 = new JLabel("\uD559\uB825");
		lblNewLabel_1.setBounds(14, 251, 62, 18);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uACBD\uB825");
		lblNewLabel_2.setBounds(14, 302, 62, 18);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uC9C1\uC885");
		lblNewLabel_3.setBounds(14, 353, 62, 18);
		panel.add(lblNewLabel_3);

		JLabel label_3 = new JLabel("\uAE30\uAC04");
		label_3.setBounds(14, 401, 62, 18);
		panel.add(label_3);

		JLabel lblNewLabel_4 = new JLabel("\uC694\uC77C");
		lblNewLabel_4.setBounds(231, 57, 62, 18);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\uC2DC\uAC04");
		lblNewLabel_5.setBounds(231, 99, 62, 18);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\uC9C0\uC5ED");
		lblNewLabel_6.setBounds(231, 147, 62, 18);
		panel.add(lblNewLabel_6);

		label_4 = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");//
		label_4.setBounds(68, 57, 99, 18);

		panel.add(label_4);

		label_5 = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		label_5.setBounds(68, 99, 99, 18);
		panel.add(label_5);

		label_6 = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		label_6.setBounds(68, 147, 99, 18);
		panel.add(label_6);

		label_7 = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		label_7.setBounds(85, 202, 125, 18);
		panel.add(label_7);

		label_8 = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		label_8.setBounds(68, 251, 99, 18);
		panel.add(label_8);

		label_9 = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		label_9.setBounds(68, 302, 125, 18);
		panel.add(label_9);

		label_10 = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		label_10.setBounds(68, 353, 142, 18);
		panel.add(label_10);

		label_11 = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		label_11.setBounds(68, 401, 160, 18);
		panel.add(label_11);

		label_12 = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		label_12.setBounds(285, 57, 116, 18);
		panel.add(label_12);

		label_13 = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		label_13.setBounds(285, 99, 116, 18);
		panel.add(label_13);

		label_14 = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		label_14.setBounds(285, 147, 99, 18);
		panel.add(label_14);

		JButton btnNewButton = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
            //뒤로가기
			public void actionPerformed(ActionEvent e) {
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getOwnerMainView());
				win.setSize(1000, 620);
				revalidate();
				repaint();
				win.setVisible(false);
				win.setVisible(true);
			
			}
		});
		btnNewButton.setBounds(285, 419, 105, 27);
		panel.add(btnNewButton);
		initialize();
	}

	private void initialize() {

		setLayout(null);
		setSize(1000, 600);
	}

	public void OwnerDetailButton1(Resume temp) {

		setLayout(null);
		setSize(1000, 600);

		label_4.setText(temp.getName());
		label_5.setText(Integer.toString(temp.getAge()));
		label_6.setText(temp.getGender());
		label_7.setText(temp.getPhone());
		label_8.setText(temp.getAcademic());
		label_9.setText(temp.getCareer());
		label_10.setText(temp.getTypeOccup());
		label_11.setText(temp.getPeriodType());
		label_12.setText(temp.getDow());
		label_13.setText(temp.getTime());
		label_14.setText(temp.getRegion());

	}
}
