package com.job.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.job.controller.SearchController;
import com.job.model.Resume;
import com.job.model.dao.LoadSave;
import com.job.run.Run;
import java.awt.Color;

public class SearchView extends JPanel {
	private Run win = new Run();
	private JTable table;
	private JTextField textField;
	public DefaultTableModel DtmStorage;
	private JComboBox<?> addrType;
	private JButton searchButton;

	private String region;
	private String typeOccup;
	private String periodType;

	private String name;
	private int age;
	private String gender;
	private String phone;

	private String academic;
	private String career;

	private int userNo;
	private String dow;

	public String inputvar = "";

	private SearchController sc = new SearchController();

	public ArrayList<Resume> rs = new ArrayList<Resume>();

	public SearchView(Run win) {
		this.win = win;
		initialize();
		dummyset();
	}

	private void initialize() {
		
		Color fontColor = new Color(0x4f4f4f);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setSize(1000, 600);

		String[] colum = { "", "", "", "", "", "", "" };
		DtmStorage = new DefaultTableModel(colum, 0);
		table = new JTable(DtmStorage);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(20);
		DtmStorage.setColumnIdentifiers(new String[] { "이력서 번호", "직종", "이름", "지역", "근무기간", "근무요일", "전화번호" });

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(85, 278, 831, 252);
		add(scrollPane);

		// 검색버튼 기능
		searchButton = new JButton("");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// 객체명.메소드명(메소드가 받는 인자);
					DtmStorage.setNumRows(0);
					sc.Search(win, region, typeOccup, periodType);
					for (int i = 0; i < sc.rs2.size(); i++) {
						DtmStorage.addRow(new Object[] { sc.rs2.get(i).getUserNo(), sc.rs2.get(i).getTypeOccup(),
								rs.get(i).getName(), sc.rs2.get(i).getRegion(), rs.get(i).getPeriodType(),
								rs.get(i).getDow(), rs.get(i).getPhone() });
					}

					// sc.parameterTest(textField.getText())
				} catch (NullPointerException a) {
					a.printStackTrace();
				}

			}
		});
		searchButton.setBounds(784, 215, 125, 46);
		searchButton.setBorderPainted(false);
		searchButton.setContentAreaFilled(false);
		searchButton.setIcon(new ImageIcon(this.getClass().getResource("/resource/SearchBtn.png")));
		add(searchButton);

		// 메인메뉴로 뒤로가기
		JButton button_3 = new JButton("");
		button_3.setBounds(761, 544, 150, 40);
		add(button_3);
		button_3.setBorderPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setIcon(new ImageIcon(this.getClass().getResource("/resource/BackButton.png")));
		button_3.addActionListener(new ActionListener() {
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
		setVisible(true);

		// 지역콤보박스
		addrType = new JComboBox<Object>();
		addrType.setForeground(fontColor);
		addrType.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		addrType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				region = addrType.getSelectedItem().toString();

			}
		});
		addrType.setModel(new DefaultComboBoxModel(new String[] { "[\uADFC\uBB34\uC9C0\uC5ED]", "\uC11C\uC6B8",
				"\uBD80\uC0B0", "\uB300\uAD6C", "\uC778\uCC9C", "\uAD11\uC8FC", "\uB300\uC804", "\uC6B8\uC0B0",
				"\uACBD\uB0A8", "\uACBD\uBD81", "\uCDA9\uB0A8", "\uCDA9\uBD81", "\uC804\uB0A8", "\uC804\uBD81",
				"\uAC15\uC6D0", "\uC81C\uC8FC" }));
		addrType.setSelectedIndex(0);
		addrType.setBounds(246, 222, 105, 35);
		add(addrType);

		// 직종콤보박스
		JComboBox<Object> typeOccupType = new JComboBox<Object>();
		typeOccupType.setForeground(fontColor);
		typeOccupType.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		typeOccupType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				typeOccup = typeOccupType.getSelectedItem().toString();

			}
		});
		typeOccupType.setModel(new DefaultComboBoxModel(
				new String[] { "[\uADFC\uBB34\uD615\uD0DC]", "\uB9E4\uC7A5\uAD00\uB9AC", "\uC8FC\uBC29",
						"\uBBF8\uB514\uC5B4", "\uC6B4\uC804", "\uC0AC\uBB34", "IT", "\uC601\uC5C5", "\uAD50\uC721" }));
		typeOccupType.setSelectedIndex(0);
		typeOccupType.setBounds(444, 222, 105, 35);
		add(typeOccupType);

		// 근무기간콤보박스
		JComboBox<Object> period = new JComboBox<Object>();
		period.setForeground(fontColor);
		period.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		period.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				periodType = period.getSelectedItem().toString();

			}
		});
		period.setModel(new DefaultComboBoxModel(
				new String[] { "[\uADFC\uBB34\uAE30\uAC04]", "\uC77C\uC8FC\uC77C", "1\uAC1C\uC6D4 \uC774\uC0C1",
						"3\uAC1C\uC6D4 \uC774\uC0C1", "6\uAC1C\uC6D4 \uC774\uC0C1", "\uC7A5\uAE30" }));
		period.setSelectedIndex(0);
		period.setBounds(662, 223, 105, 35);
		add(period);

		// 구직자 전체조회
		JButton button = new JButton("");
		button.setBounds(724, 144, 171, 40);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setIcon(new ImageIcon(this.getClass().getResource("/resource/allSearchBtn.png")));
		add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DtmStorage.setNumRows(0);
				for (int i = 0; i < rs.size(); i++) {

					userNo = rs.get(i).getUserNo();
					typeOccup = rs.get(i).getTypeOccup();
					name = rs.get(i).getName();
					region = rs.get(i).getRegion();
					periodType = rs.get(i).getPeriodType();
					dow = rs.get(i).getDow();
					phone = rs.get(i).getPhone();

					DtmStorage
							.addRow(new Object[] { (Object) userNo, typeOccup, name, region, periodType, dow, phone });

				}
			}
		});

		textField = new JTextField();
		textField.setBounds(347, 138, 206, 34);
		add(textField);
		textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		textField.setOpaque(false);
		textField.setColumns(10);

		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(add(textField));

			}
		});

		// 열람
		JButton button_1 = new JButton("");
		button_1.setBounds(565, 139, 77, 45);
		button_1.setBorderPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setIcon(new ImageIcon(this.getClass().getResource("/resource/OpenBtn.png")));
		add(button_1);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(0, 0, 1000, 600);
		label_6.setIcon(new ImageIcon(this.getClass().getResource("/resource/SearchView.jpg")));
		add(label_6);
		
		
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				win.getContentPane().removeAll();
				win.getContentPane().add(win.getSearch2View());
				win.setSize(581, 793);
				revalidate();
				repaint();

				inputvar = textField.getText();
				win.getSearch2View().dataSetting(win, userNo, inputvar);

				// 객체명.메소드명(메소드가 받는 인자);
				// sc.resumeset(textField.getText()));

			}
		});
	}

	private void dummyset() {
		rs = LoadSave.getDao().loadResume();
	}

	public void reset() {
		textField.setText("");
		DtmStorage.setNumRows(0);
	}
}
