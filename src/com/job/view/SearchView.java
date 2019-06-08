package com.job.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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

public class SearchView extends JPanel {
	private Run win = new Run();
	private JTable table;
	private JTextField textField;
	public DefaultTableModel DtmStorage;
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

	public int getidx() {
		System.out.println("???");
		return table.getSelectedRow();
	}

	public SearchView(Run win) {
		this.win = win;
		initialize();
		rs =  LoadSave.getDao().loadResume();
	}

	private void initialize() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		String[] colum = { "", "", "", "", "", "", "" };
		DtmStorage = new DefaultTableModel(colum, 0) {
			public boolean isCellEditable(int row, int colum) {
				return false;
			}
		};

		table = new JTable(DtmStorage);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(20);
		DtmStorage.setColumnIdentifiers(new String[] { "resume NO", "직종", "이름", "지역", "근무기간", "근무요일", "전화번호" });

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(185, 191, 634, 300);
		add(scrollPane);

		JLabel label = new JLabel("\uAD6C\uC9C1\uC790\uAC80\uC0C9");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label.setBounds(441, 10, 153, 53);
		add(label);

		// 검색버튼 기능
		searchButton = new JButton("\uAC80\uC0C9");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// 객체명.메소드명(메소드가 받는 인자);
					DtmStorage.setNumRows(0);
					inputvar = textField.getText();
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
		searchButton.setBounds(594, 73, 61, 27);
		add(searchButton);

		// 메인메뉴로 뒤로가기
		JButton button_3 = new JButton("뒤로가기");
		button_3.setBounds(750, 500, 90, 40);
		add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getSearch2View());
				revalidate();
				repaint();
				
			}
		});
		setVisible(true);

		JLabel label_4 = new JLabel("\uC9C0\uC6D0\uC790 \uAC80\uC0C9");
		label_4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		label_4.setBounds(306, 73, 109, 27);
		add(label_4);

		JLabel label_5 = new JLabel("(\uC9C0\uC5ED,\uC9C1\uC885,\uADFC\uBB34\uAE30\uAC04\uC73C\uB85C \uAC80\uC0C9)");
		label_5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label_5.setBounds(347, 107, 220, 27);
		add(label_5);

		// 구직자 전체조회
		JButton button = new JButton("\uAD6C\uC9C1\uC790 \uC804\uCCB4\uC870\uD68C");
		button.setBounds(423, 144, 153, 27);
		add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
		textField.setBounds(423, 75, 157, 24);
		add(textField);
		textField.setColumns(10);

		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(add(textField));

			}
		});

		// 열람
		JButton button_1 = new JButton("\uC5F4\uB78C");
		button_1.setBounds(182, 501, 61, 27);
		add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					win.getContentPane().removeAll();
					win.getContentPane().add(win.getSearch2View());
					win.setSize(581, 793);
					revalidate();
					repaint();

					Resume player = new Resume();
					player = sc.resumeset(win);
					win.getSearch2View().dataSetting(win, player);
				} else {
					System.out.println("Grid에서 선택해주세요.");
				}

				// 객체명.메소드명(메소드가 받는 인자);
				// sc.resumeset(textField.getText()));

			}
		});
	}

	private void dummyset() {
//		rs.add(new Resume("홍길동", 19, "남", "010-1111-1111", "대졸", "피시방", "IT", "일주일", "주말", "3~6시간", "서울", 121313));
//		rs.add(new Resume("강한수", 23, "남", "010-2111-1111", "대졸", "편의점", "카페", "1개월 이상", "평일", "3~6시간", "인천", 123131));
//		rs.add(new Resume("스칼렛", 29, "여", "010-3111-1111", "대졸", "카페", "마트", "3개월 이상", "주말", "3~6시간", "경남", 122115));
//		rs.add(new Resume("장원삼", 24, "남", "010-4111-1111", "고졸", "서브웨이", "배달", "일주일", "평일", "3~6시간", "전남", 1278552));
//		rs.add(new Resume("이대호", 26, "남", "010-5111-1111", "중졸", "편의점", "배달", "3개월 이상", "주말", "3~6시간", "경북", 234211));
//		rs.add(new Resume("민병헌", 32, "남", "010-6111-1111", "대졸", "편의점", "마트", "1개월 이상", "평일", "3~6시간", "인천", 212311));

	}
}
