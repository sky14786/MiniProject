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
		DtmStorage.setColumnIdentifiers(new String[] { "resume NO", "����", "�̸�", "����", "�ٹ��Ⱓ", "�ٹ�����", "��ȭ��ȣ" });

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(185, 191, 634, 300);
		add(scrollPane);

		JLabel label = new JLabel("\uAD6C\uC9C1\uC790\uAC80\uC0C9");
		label.setFont(new Font("���� ���", Font.BOLD, 20));
		label.setBounds(441, 10, 153, 53);
		add(label);

		// �˻���ư ���
		searchButton = new JButton("\uAC80\uC0C9");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// ��ü��.�޼ҵ��(�޼ҵ尡 �޴� ����);
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

		// ���θ޴��� �ڷΰ���
		JButton button_3 = new JButton("�ڷΰ���");
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
		label_4.setFont(new Font("���� ���", Font.BOLD, 18));
		label_4.setBounds(306, 73, 109, 27);
		add(label_4);

		JLabel label_5 = new JLabel("(\uC9C0\uC5ED,\uC9C1\uC885,\uADFC\uBB34\uAE30\uAC04\uC73C\uB85C \uAC80\uC0C9)");
		label_5.setFont(new Font("���� ���", Font.BOLD, 15));
		label_5.setBounds(347, 107, 220, 27);
		add(label_5);

		// ������ ��ü��ȸ
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

		// ����
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
					System.out.println("Grid���� �������ּ���.");
				}

				// ��ü��.�޼ҵ��(�޼ҵ尡 �޴� ����);
				// sc.resumeset(textField.getText()));

			}
		});
	}

	private void dummyset() {
//		rs.add(new Resume("ȫ�浿", 19, "��", "010-1111-1111", "����", "�ǽù�", "IT", "������", "�ָ�", "3~6�ð�", "����", 121313));
//		rs.add(new Resume("���Ѽ�", 23, "��", "010-2111-1111", "����", "������", "ī��", "1���� �̻�", "����", "3~6�ð�", "��õ", 123131));
//		rs.add(new Resume("��Į��", 29, "��", "010-3111-1111", "����", "ī��", "��Ʈ", "3���� �̻�", "�ָ�", "3~6�ð�", "�泲", 122115));
//		rs.add(new Resume("�����", 24, "��", "010-4111-1111", "����", "�������", "���", "������", "����", "3~6�ð�", "����", 1278552));
//		rs.add(new Resume("�̴�ȣ", 26, "��", "010-5111-1111", "����", "������", "���", "3���� �̻�", "�ָ�", "3~6�ð�", "���", 234211));
//		rs.add(new Resume("�κ���", 32, "��", "010-6111-1111", "����", "������", "��Ʈ", "1���� �̻�", "����", "3~6�ð�", "��õ", 212311));

	}
}
