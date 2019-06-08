package com.job.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.job.controller.SearchController;
import com.job.model.Resume;
import com.job.run.Run;
import java.awt.Color;

//우현
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
		setVisible(true);
		Color fontColor = new Color(0x4f4f4f);
		// 여기서부터 이력서 입력정보들어가는곳

		lbName = new JLabel();
		lbName.setText("a");
		lbName.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbName.setForeground(fontColor);
		lbName.setBounds(150, 151, 123, 46);
		add(lbName);

		lbAge = new JLabel();
		lbAge.setForeground(fontColor);
		lbAge.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbAge.setBounds(397, 149, 123, 54);
		add(lbAge);

		lbGender = new JLabel();
		lbGender.setForeground(fontColor);
		lbGender.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbGender.setBounds(140, 239, 123, 54);
		add(lbGender);

		lbRegion = new JLabel();
		lbRegion.setForeground(fontColor);
		lbRegion.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbRegion.setBounds(140, 329, 155, 54);
		add(lbRegion);

		lbAcademic = new JLabel();
		lbAcademic.setForeground(fontColor);
		lbAcademic.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbAcademic.setBounds(142, 420, 103, 54);
		add(lbAcademic);

		lbPhone = new JLabel();
		lbPhone.setForeground(fontColor);
		lbPhone.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbPhone.setBounds(396, 238, 156, 54);
		add(lbPhone);

		lbCareer = new JLabel();
		lbCareer.setForeground(fontColor);
		lbCareer.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbCareer.setBounds(391, 327, 164, 54);
		add(lbCareer);

		lbTypeOccup = new JLabel();
		lbTypeOccup.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbTypeOccup.setForeground(fontColor);
		lbTypeOccup.setBounds(355, 497, 191, 46);
		add(lbTypeOccup);

		lbPeriodType = new JLabel();
		lbPeriodType.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbPeriodType.setForeground(fontColor);
		lbPeriodType.setBounds(352, 575, 207, 45);
		add(lbPeriodType);

		lbDow = new JLabel();
		lbDow.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbDow.setForeground(fontColor);
		lbDow.setBounds(349, 650, 203, 43);
		add(lbDow);

		setBounds(100, 100, 581, 793);
		
				// 메인메뉴로 뒤로가기
				JButton button_4 = new JButton("");
				button_4.setBounds(399, 703, 135, 46);
				button_4.setBorderPainted(false);
				button_4.setContentAreaFilled(false);
				button_4.setIcon(new ImageIcon(this.getClass().getResource("/resource/BackButton.png")));
				add(button_4);
				button_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						win.getContentPane().removeAll();
						win.getContentPane().add(win.getSearchView());
						win.setSize(1000, 620);
						revalidate();
						repaint();
						win.setVisible(false);
						win.setVisible(true);
					}
				});
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(0, 0, 581, 783);
		label_10.setIcon(new ImageIcon(this.getClass().getResource("/resource/SearchView2.jpg")));
		add(label_10);
		setVisible(true);
	}

	public void dataSetting(Run win, int userNo, String inputvar) {
		Resume temp = sc.resumeset(win, userNo, inputvar);
		lbName.setText(temp.getName());
		lbAge.setText(String.valueOf(temp.getAge()));
		lbGender.setText(temp.getGender());
		lbPhone.setText(temp.getPhone());
		lbRegion.setText(temp.getRegion());
		lbCareer.setText(temp.getCareer());
		lbAcademic.setText(temp.getAcademic());
		lbTypeOccup.setText(temp.getTypeOccup());
		lbPeriodType.setText(temp.getPeriodType());
		lbDow.setText(temp.getDow());
	}
}
