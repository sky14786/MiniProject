package com.job.view;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.job.model.Notice;
import com.job.run.Run;

public class JobSearch2View extends JPanel {

	// private JPanel contentPane;
	private JobSearchView sub;
	public JLabel labelBname;
	private Notice temp3 = null;
	private JLabel labelPay;
	private JLabel pay;
	private JLabel labelTimeTotime;
	private JLabel timeType;
	private JLabel labelTypeOccup;
	private JLabel typeOccup;
	private JLabel labelRegion;
	private JLabel region;
	private JLabel labelperiodType;
	private JLabel periodType;
	private JLabel labelTypeTime;
	private JLabel timeTotime;
	private JLabel label;
	private JLabel labelKey1;
	private JLabel labelKey2;
	private JLabel labelKey3;
	private JLabel bNoName;
	private JLabel labelMore;
	private JLabel labelEtc;
	private JLabel labelBno;
	private Run win = new Run();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	public JobSearch2View() {
		// TODO Auto-generated constructor stub
	}
	public JobSearch2View(Run win) {
		this.win = win;

//		setBounds(100, 100, 450, 713);
		setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("����������", Font.BOLD, 18));
		textPane.setText("\uC0C1 \uC138 \uC815 \uBCF4");
		textPane.setBounds(150, 5, 142, 40);
		add(textPane);

		JLabel bname = new JLabel("\uC5C5\uC7A5\uBA85 : ");
		bname.setFont(new Font("����������", Font.BOLD, 18));
		bname.setBounds(11, 89, 69, 40);
		add(bname);

		labelBname = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelBname.setFont(new Font("����������", Font.PLAIN, 18));
		labelBname.setBounds(92, 96, 333, 27);
		add(labelBname);

		labelPay = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelPay.setFont(new Font("����������", Font.PLAIN, 18));
		labelPay.setBounds(72, 135, 349, 27);
		add(labelPay);

		pay = new JLabel("\uC2DC\uAE09 :");
		pay.setFont(new Font("����������", Font.BOLD, 18));
		pay.setBounds(11, 128, 69, 40);
		add(pay);

		labelTimeTotime = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelTimeTotime.setFont(new Font("����������", Font.PLAIN, 18));
		labelTimeTotime.setBounds(72, 172, 349, 27);
		add(labelTimeTotime);

		timeType = new JLabel("\uC2DC\uAC04 :");
		timeType.setFont(new Font("����������", Font.BOLD, 18));
		timeType.setBounds(11, 165, 69, 40);
		add(timeType);

		labelTypeOccup = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelTypeOccup.setFont(new Font("����������", Font.PLAIN, 18));
		labelTypeOccup.setBounds(114, 216, 311, 27);
		add(labelTypeOccup);

		typeOccup = new JLabel("\uADFC\uBB34 \uD615\uD0DC :");
		typeOccup.setFont(new Font("����������", Font.BOLD, 18));
		typeOccup.setBounds(11, 209, 104, 40);
		add(typeOccup);

		labelRegion = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelRegion.setFont(new Font("����������", Font.PLAIN, 18));
		labelRegion.setBounds(72, 256, 349, 27);
		add(labelRegion);

		region = new JLabel("\uC9C0\uC5ED : ");
		region.setFont(new Font("����������", Font.BOLD, 18));
		region.setBounds(11, 249, 69, 40);
		add(region);

		labelperiodType = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelperiodType.setFont(new Font("����������", Font.PLAIN, 18));
		labelperiodType.setBounds(114, 300, 311, 27);
		add(labelperiodType);

		periodType = new JLabel("\uADFC\uBB34 \uAE30\uAC04 :");
		periodType.setFont(new Font("����������", Font.BOLD, 18));
		periodType.setBounds(11, 293, 104, 40);
		add(periodType);

		labelTypeTime = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelTypeTime.setFont(new Font("����������", Font.PLAIN, 18));
		labelTypeTime.setBounds(114, 343, 311, 27);
		add(labelTypeTime);

		timeTotime = new JLabel("\uADFC\uBB34 \uC2DC\uAC04 :");
		timeTotime.setFont(new Font("����������", Font.BOLD, 18));
		timeTotime.setBounds(11, 337, 104, 40);
		add(timeTotime);

		label = new JLabel("\uD0A4\uC6CC\uB4DC :");
		label.setFont(new Font("����������", Font.BOLD, 15));
		label.setBounds(11, 380, 104, 40);
		add(label);

		labelKey1 = new JLabel("\uD0A4\uC6CC\uB4DC 1");
		labelKey1.setFont(new Font("����������", Font.PLAIN, 15));
		labelKey1.setBounds(72, 387, 311, 27);
		add(labelKey1);

		labelKey2 = new JLabel("\uD0A4\uC6CC\uB4DC 2");
		labelKey2.setFont(new Font("����������", Font.PLAIN, 15));
		labelKey2.setBounds(72, 417, 311, 27);
		add(labelKey2);

		labelKey3 = new JLabel("\uD0A4\uC6CC\uB4DC 3");
		labelKey3.setFont(new Font("����������", Font.PLAIN, 15));
		labelKey3.setBounds(72, 448, 311, 27);
		add(labelKey3);

		bNoName = new JLabel("\uC5C5\uC7A5\uBC88\uD638 :");
		bNoName.setFont(new Font("����������", Font.BOLD, 18));
		bNoName.setBounds(10, 48, 89, 40);
		add(bNoName);

		labelMore = new JLabel("\uBD80\uAC00 \uC124\uBA85");
		labelMore.setFont(new Font("����������", Font.BOLD, 15));
		labelMore.setBounds(11, 485, 104, 40);
		add(labelMore);

		labelEtc = new JLabel("\uB0B4\uC6A9 \uC5C6\uC74C");
		labelEtc.setFont(new Font("����������", Font.PLAIN, 15));
		labelEtc.setBounds(10, 521, 411, 144);
		add(labelEtc);

		labelBno = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelBno.setFont(new Font("����������", Font.PLAIN, 18));
		labelBno.setBounds(104, 55, 318, 27);
		add(labelBno);

	}

	public void subSearch2(Notice temp) {
		this.temp3 = temp;
		System.out.println(temp3.toString());

		// ȭ�鿡 ���ΰ����� ���� ���� ���
		labelBno.setText(Integer.toString(temp3.getbNo()));
		labelBname.setText(temp3.getbName());
		labelPay.setText(String.valueOf(temp3.getPay()));
		labelTimeTotime.setText(temp3.getTimeType());
		labelTypeOccup.setText(temp3.getCategory());
		labelRegion.setText(temp3.getAddr());
		labelperiodType.setText(temp3.getPeriodType());
		labelTypeTime.setText(temp3.getTimeTotime());
		labelKey1.setText(temp3.getbKeyword1());
		labelKey2.setText(temp3.getbKeyword2());
		labelKey3.setText(temp3.getbKeyword3());
		labelEtc.setText(temp3.getEtc());

	}
}