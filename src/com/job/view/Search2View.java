package com.job.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.job.controller.SearchController;
import com.job.model.Resume;
import com.job.run.Run;


public class Search2View extends JPanel {

	private Run win = new Run();
	private String inputvar;
	private ArrayList<Resume> rs4 = new ArrayList<Resume>();
	private SearchController sc = new SearchController();
	SearchView search = new SearchView(win);
	private JLabel lbName;
	private JLabel lbAge;
	private JLabel lbGender;
	private JLabel lbPhone;
	private JLabel lbRegion;
	private JLabel lbCareer;
	private JLabel lbAcademic;
	private JLabel lbTypeOccup;
	private JLabel lbPeriodType;
	private JLabel lbDow;
	
	

	public Search2View(Run win) {
		this.win = win;
		initialize();
	}

	private void initialize() {
		setLayout(null);

		// ¸ÞÀÎ¸Þ´º·Î µÚ·Î°¡±â
		JButton button_4 = new JButton("µÚ·Î°¡±â");
		button_4.setBounds(350, 650, 90, 40);
		add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getSearch2View());
			}
		});
		setVisible(true);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 25));
		lblNewLabel.setBounds(242, 35, 84, 48);
		add(lblNewLabel);

		JLabel label = new JLabel("\uC774\uB984");
		label.setFont(new Font("±¼¸²", Font.BOLD, 20));
		label.setBounds(72, 113, 54, 54);
		add(label);

		JLabel label_1 = new JLabel("\uB098\uC774");
		label_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
		label_1.setBounds(256, 110, 54, 61);
		add(label_1);

		JLabel label_2 = new JLabel("\uC131\uBCC4");
		label_2.setFont(new Font("±¼¸²", Font.BOLD, 20));
		label_2.setBounds(72, 179, 54, 61);
		add(label_2);

		JLabel label_3 = new JLabel("\uD3F0\uBC88\uD638");
		label_3.setFont(new Font("±¼¸²", Font.BOLD, 20));
		label_3.setBounds(256, 182, 84, 54);
		add(label_3);

		JLabel label_4 = new JLabel("\uD559\uB825");
		label_4.setFont(new Font("±¼¸²", Font.BOLD, 20));
		label_4.setBounds(72, 315, 54, 54);
		add(label_4);

		JLabel label_5 = new JLabel("\uACBD\uB825\r\n");
		label_5.setFont(new Font("±¼¸²", Font.BOLD, 20));
		label_5.setBounds(256, 252, 54, 61);
		add(label_5);

		JLabel label_6 = new JLabel("\uD76C\uB9DD \uC5C5\uBB34\uD615\uD0DC");
		label_6.setFont(new Font("±¼¸²", Font.BOLD, 20));
		label_6.setBounds(127, 423, 179, 48);
		add(label_6);

		JLabel label_7 = new JLabel("\uD76C\uB9DD \uADFC\uBB34\uAE30\uAC04");
		label_7.setFont(new Font("±¼¸²", Font.BOLD, 20));
		label_7.setBounds(127, 483, 179, 48);
		add(label_7);

		JLabel label_8 = new JLabel("\uC9C0\uC5ED");
		label_8.setFont(new Font("±¼¸²", Font.BOLD, 20));
		label_8.setBounds(72, 252, 54, 54);
		add(label_8);

		JLabel label_9 = new JLabel("\uD76C\uB9DD \uADFC\uBB34\uC694\uC77C");
		label_9.setFont(new Font("±¼¸²", Font.BOLD, 20));
		label_9.setBounds(127, 543, 179, 48);
		add(label_9);

		// ¿©±â¼­ºÎÅÍ ÀÌ·Â¼­ ÀÔ·ÂÁ¤º¸µé¾î°¡´Â°÷

		lbName = new JLabel();
		lbName.setBounds(138, 126, 90, 32);
		add(lbName);

		
	     lbAge = new JLabel();
		 lbAge.setFont(new Font("±¼¸²", Font.BOLD, 15));
		 lbAge.setBounds(361, 113, 123, 54);
		 add(lbAge);

	    lbGender = new JLabel();
		lbGender.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbGender.setBounds(140, 179, 54, 54);
		add(lbGender);

		lbRegion = new JLabel();
		lbRegion.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbRegion.setBounds(140, 252, 74, 54);
		add(lbRegion);

		lbAcademic = new JLabel();
		lbAcademic.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbAcademic.setBounds(140, 315, 54, 54);
		add(lbAcademic);

		lbPhone = new JLabel();
		lbPhone.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbPhone.setBounds(354, 179, 156, 54);
		add(lbPhone);

		lbCareer = new JLabel();
		lbCareer.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbCareer.setBounds(354, 252, 54, 54);
		add(lbCareer);

		lbTypeOccup = new JLabel();
		lbTypeOccup.setBounds(320, 440, 62, 18);
		add(lbTypeOccup);

		lbPeriodType = new JLabel();
		lbPeriodType.setBounds(320, 500, 62, 18);
		add(lbPeriodType);

		lbDow = new JLabel();
		lbDow.setBounds(320, 560, 62, 18);
		add(lbDow);

		setBounds(100, 100, 581, 793);
		setVisible(true);
	}

	public void dataSetting(Run win, Resume player) {
	
	lbName.setText(player.getName());
	lbAge.setText(String.valueOf(player.getAge()));
	lbGender.setText(player.getGender());
	lbPhone.setText(player.getPhone());
	lbRegion.setText(player.getRegion());
	lbCareer.setText(player.getCareer());
	lbAcademic.setText(player.getAcademic());
	lbTypeOccup.setText(player.getTypeOccup());
	lbPeriodType.setText(player.getPeriodType());
	lbDow.setText(player.getDow());
		
		
	}

}
