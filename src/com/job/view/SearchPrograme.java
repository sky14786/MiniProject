package com.job.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.job.model.Resume;
import com.job.model.dao.LoadSave;

public class SearchPrograme extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane2;
	private JTable table;
	private JTextField textField;
	private DefaultTableModel DtmStorage;
	private JComboBox<?> addrType;
	private JButton searchButton;

	String region;
	String typeOccup;
	String periodType;

	String name;
	int age;
	String gender;
	String phone;
	String academic;
	String career;
	String typeOccup2;
	String periodType2;
	int userNo;
	String dow;
	String region2;

	static ArrayList<Resume> pt = new ArrayList<Resume>();
	static ArrayList<Resume> pt2 = new ArrayList<Resume>();
	private LoadSave dao = LoadSave.getDao();

	static String inputvar = " ";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPrograme frame = new SearchPrograme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public SearchPrograme() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] colum = { "", "", "", "", "", "", "" };
		DtmStorage = new DefaultTableModel(colum, 0);
		table = new JTable(DtmStorage);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(20);
		DtmStorage.setColumnIdentifiers(new String[] { "resume NO", "����", "�̸�", "����", "�ٹ��Ⱓ", "�ٹ�����", "��ȭ��ȣ" });

		for (int i = 0; i < pt.size(); i++) {
			DtmStorage.addRow(new String[] { (String) "no", typeOccup2, name, region2, periodType2, dow, phone });
		}

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(185, 280, 632, 202);
		contentPane.add(scrollPane);

		JLabel label = new JLabel("\uAD6C\uC9C1\uC790\uAC80\uC0C9");
		label.setFont(new Font("���� ���", Font.BOLD, 20));
		label.setBounds(443, 12, 153, 53);
		contentPane.add(label);

		searchButton = new JButton("\uAC80\uC0C9");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				search();

			}
		});
		searchButton.setBounds(473, 202, 61, 27);
		contentPane.add(searchButton);

		JLabel label_1 = new JLabel("\uC9C0\uC5ED");
		label_1.setFont(new Font("���� ���", Font.BOLD, 18));
		label_1.setBounds(236, 160, 38, 27);
		contentPane.add(label_1);

		// �����޺��ڽ�
		addrType = new JComboBox<Object>();
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
		addrType.setBounds(290, 163, 99, 26);
		contentPane.add(addrType);

		// �����޺��ڽ�
		JComboBox<Object> typeOccupType = new JComboBox<Object>();
		typeOccupType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				typeOccup = typeOccupType.getSelectedItem().toString();

			}
		});
		typeOccupType.setModel(new DefaultComboBoxModel(
				new String[] { "[\uADFC\uBB34\uD615\uD0DC]", "\uB9E4\uC7A5\uAD00\uB9AC", "\uC8FC\uBC29",
						"\uBBF8\uB514\uC5B4", "\uC6B4\uC804", "\uC0AC\uBB34", "IT", "\uC601\uC5C5", "\uAD50\uC721" }));
		typeOccupType.setSelectedIndex(0);
		typeOccupType.setBounds(453, 163, 99, 26);
		contentPane.add(typeOccupType);

		// �ٹ��Ⱓ�޺��ڽ�
		JComboBox<Object> period = new JComboBox<Object>();
		period.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				periodType = period.getSelectedItem().toString();

			}
		});
		period.setModel(new DefaultComboBoxModel(
				new String[] { "[\uADFC\uBB34\uAE30\uAC04]", "\uC77C\uC8FC\uC77C", "1\uAC1C\uC6D4 \uC774\uC0C1",
						"3\uAC1C\uC6D4 \uC774\uC0C1", "6\uAC1C\uC6D4 \uC774\uC0C1", "\uC7A5\uAE30" }));
		period.setSelectedIndex(0);
		period.setBounds(646, 163, 99, 26);
		contentPane.add(period);

		JLabel label_2 = new JLabel("\uC9C1\uC885");
		label_2.setFont(new Font("���� ���", Font.BOLD, 18));
		label_2.setBounds(403, 160, 45, 27);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\uADFC\uBB34\uAE30\uAC04");
		label_3.setFont(new Font("���� ���", Font.BOLD, 18));
		label_3.setBounds(566, 160, 81, 27);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\uC9C0\uC6D0\uC790 \uC5F4\uB78C");
		label_4.setFont(new Font("���� ���", Font.BOLD, 18));
		label_4.setBounds(305, 94, 96, 27);
		contentPane.add(label_4);

		textField = new JTextField();
		textField.setBounds(415, 98, 157, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(getContentPane().add(textField));

			}
		});

		JLabel label_5 = new JLabel("(\uC774\uB825\uC11C \uBC88\uD638\uB85C \uAC80\uC0C9)");
		label_5.setFont(new Font("���� ���", Font.BOLD, 18));
		label_5.setBounds(305, 124, 185, 27);
		contentPane.add(label_5);

		// ������ ��ü��ȸ
		JButton button = new JButton("\uAD6C\uC9C1\uC790 \uC804\uCCB4\uC870\uD68C");
		button.setBounds(429, 241, 153, 27);
		contentPane.add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pt2.clear();
				DtmStorage.setNumRows(0);

				for (int i = 0; i < pt.size(); i++) {

					userNo = pt.get(i).getUserNo();
					typeOccup2 = pt.get(i).getTypeOccup();
					name = pt.get(i).getName();
					region2 = pt.get(i).getRegion();
					periodType2 = pt.get(i).getPeriodType();
					dow = pt.get(i).getDow();
					phone = pt.get(i).getPhone();

					DtmStorage.addRow(
							new Object[] { (Object) userNo, typeOccup2, name, region2, periodType2, dow, phone });

				}
			}
		});

		// ����
		JButton button_1 = new JButton("\uC5F4\uB78C");
		button_1.setBounds(586, 97, 61, 27);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputvar = textField.getText();
				test();
			}
		});
		
		testset();

	}

	// ��������
	public void testset() {
		pt = dao.loadResume();
	}

	// �˻����
	public void search() {

		pt2.clear();
		System.out.println("��� ���");
		DtmStorage.setNumRows(0);

		for (int i = 0; i < pt.size(); i++) {
			// pt�� �ε����� ���� ����
			userNo = pt.get(i).getUserNo();
			typeOccup2 = pt.get(i).getTypeOccup();
			name = pt.get(i).getName();
			region2 = pt.get(i).getRegion();
			periodType2 = pt.get(i).getPeriodType();
			dow = pt.get(i).getDow();
			phone = pt.get(i).getPhone();

//	            DtmStorage.addRow(new String[] {(String)resumeNO, typeOccup2, 
//	            name , region2 , period2,
//	            dow, phone});

			if (region.equals("[�ٹ�����]") && typeOccup.equals("[�ٹ�����]") && periodType.equals(periodType2)) {
				System.out.println(pt.get(i)); // ����� �߳������� ���

				pt2.add((Resume) pt.get(i)); // wk�� �ε����� wk2 ����Ʈ�� �ε����� �߰�

				// ���̺� ���
				for (int j = 0; j < pt2.size(); j++) {
					DtmStorage.addRow(
							new Object[] { (Object) userNo, typeOccup2, name, region2, periodType2, dow, phone });
					break;
				}

			}

			if (region.equals("[�ٹ�����]") && typeOccup.equals(typeOccup2) && periodType.equals(periodType2)) {
				System.out.println(pt.get(i));

				pt2.add((Resume) pt.get(i));

				for (int j = 0; j < pt2.size(); j++) {
					DtmStorage.addRow(
							new Object[] { (Object) userNo, typeOccup2, name, region2, periodType2, dow, phone });
					break;
				}
			}

			if (region.equals(region2) && typeOccup.equals(typeOccup2) && periodType.equals(periodType2)) {
				System.out.println(pt.get(i));

				pt2.add((Resume) pt.get(i));

				for (int j = 0; j < pt2.size(); j++) {
					DtmStorage.addRow(
							new Object[] { (Object) userNo, typeOccup2, name, region2, periodType2, dow, phone });
					break;
				}
			}

			if (region.equals(region2) && typeOccup.equals("[�ٹ�����]") && periodType.equals("[�ٹ��Ⱓ]")) {
				System.out.println(pt.get(i));

				pt2.add((Resume) pt.get(i));

				for (int j = 0; j < pt2.size(); j++) {
					DtmStorage.addRow(
							new Object[] { (Object) userNo, typeOccup2, name, region2, periodType2, dow, phone });
					break;
				}
			}

			if (region.equals(region2) && typeOccup.equals(typeOccup2) && periodType.equals("[�ٹ��Ⱓ]")) {
				System.out.println(pt.get(i));

				pt2.add((Resume) pt.get(i));

				for (int j = 0; j < pt2.size(); j++) {
					DtmStorage.addRow(
							new Object[] { (Object) userNo, typeOccup2, name, region2, periodType2, dow, phone });
					break;
				}
			}

			if (region.equals("[�ٹ�����]") && typeOccup.equals(typeOccup2) && periodType.equals("[�ٹ��Ⱓ]")) {
				System.out.println(pt.get(i));

				pt2.add((Resume) pt.get(i));

				for (int j = 0; j < pt2.size(); j++) {
					DtmStorage.addRow(
							new Object[] { (Object) userNo, typeOccup2, name, region2, periodType2, dow, phone });
					break;
				}
			}

			if (region.equals(region2) && typeOccup.equals("[�ٹ�����]") && periodType.equals(periodType2)) {
				System.out.println(pt.get(i));

				pt2.add((Resume) pt.get(i));

				for (int j = 0; j < pt2.size(); j++) {
					DtmStorage.addRow(
							new Object[] { (Object) userNo, typeOccup2, name, region2, periodType2, dow, phone });
					break;
				}
			}

		}

		System.out.println();

	}

	public void test() {

		setTitle("�̷¼� ����");

		JPanel NewContainer = new JPanel();
		setContentPane(NewContainer);
		NewContainer.setLayout(null);

		List<Resume> list = new ArrayList<Resume>();
		list = pt;
		System.out.println(list.get(1));

		Resume resume = new Resume();

		for (int i = 0; i < list.size(); i++) {

//        	if(userNo2.equals(inputvar)) {
			if (list.get(i).getUserNo() == Integer.parseInt(inputvar)) {

				resume = list.get(i);
			}
		}

		System.out.println(resume.toString());

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel.setBounds(242, 35, 84, 48);
		NewContainer.add(lblNewLabel);

		JLabel label = new JLabel("\uC774\uB984");
		label.setFont(new Font("����", Font.BOLD, 20));
		label.setBounds(72, 113, 54, 54);
		NewContainer.add(label);

		JLabel label_1 = new JLabel("\uB098\uC774");
		label_1.setFont(new Font("����", Font.BOLD, 20));
		label_1.setBounds(256, 110, 54, 61);
		NewContainer.add(label_1);

		JLabel label_2 = new JLabel("\uC131\uBCC4");
		label_2.setFont(new Font("����", Font.BOLD, 20));
		label_2.setBounds(72, 179, 54, 61);
		NewContainer.add(label_2);

		JLabel label_3 = new JLabel("\uD3F0\uBC88\uD638");
		label_3.setFont(new Font("����", Font.BOLD, 20));
		label_3.setBounds(256, 182, 84, 54);
		NewContainer.add(label_3);

		JLabel label_4 = new JLabel("\uD559\uB825");
		label_4.setFont(new Font("����", Font.BOLD, 20));
		label_4.setBounds(72, 315, 54, 54);
		NewContainer.add(label_4);

		JLabel label_5 = new JLabel("\uACBD\uB825\r\n");
		label_5.setFont(new Font("����", Font.BOLD, 20));
		label_5.setBounds(256, 252, 54, 61);
		NewContainer.add(label_5);

		JLabel label_6 = new JLabel("\uD76C\uB9DD \uC5C5\uBB34\uD615\uD0DC");
		label_6.setFont(new Font("����", Font.BOLD, 20));
		label_6.setBounds(127, 423, 179, 48);
		NewContainer.add(label_6);

		JLabel label_7 = new JLabel("\uD76C\uB9DD \uADFC\uBB34\uAE30\uAC04");
		label_7.setFont(new Font("����", Font.BOLD, 20));
		label_7.setBounds(127, 483, 179, 48);
		NewContainer.add(label_7);

		JLabel label_8 = new JLabel("\uC9C0\uC5ED");
		label_8.setFont(new Font("����", Font.BOLD, 20));
		label_8.setBounds(72, 252, 54, 54);
		NewContainer.add(label_8);

		JLabel label_9 = new JLabel("\uD76C\uB9DD \uADFC\uBB34\uC694\uC77C");
		label_9.setFont(new Font("����", Font.BOLD, 20));
		label_9.setBounds(127, 543, 179, 48);
		NewContainer.add(label_9);

		JLabel lblNewLabel_1 = new JLabel(resume.getName());
		lblNewLabel_1.setBounds(137, 133, 62, 18);
		NewContainer.add(lblNewLabel_1);

		String to = Integer.toString(resume.getAge());
		JLabel lblAa = new JLabel(to);
		lblAa.setFont(new Font("����", Font.BOLD, 15));
		lblAa.setBounds(361, 113, 123, 54);
		NewContainer.add(lblAa);

		JLabel lblBb = new JLabel(resume.getGender());
		lblBb.setFont(new Font("����", Font.BOLD, 15));
		lblBb.setBounds(140, 179, 54, 54);
		NewContainer.add(lblBb);

		JLabel lblDd = new JLabel(resume.getRegion());
		lblDd.setFont(new Font("����", Font.BOLD, 15));
		lblDd.setBounds(140, 252, 74, 54);
		NewContainer.add(lblDd);

		JLabel lblQq = new JLabel(resume.getAcademic());
		lblQq.setFont(new Font("����", Font.BOLD, 15));
		lblQq.setBounds(140, 315, 54, 54);
		NewContainer.add(lblQq);

		JLabel lblCc = new JLabel(resume.getPhone());
		lblCc.setFont(new Font("����", Font.BOLD, 15));
		lblCc.setBounds(354, 179, 156, 54);
		NewContainer.add(lblCc);

		JLabel lblEe = new JLabel(resume.getCareer());
		lblEe.setFont(new Font("����", Font.BOLD, 15));
		lblEe.setBounds(354, 252, 54, 54);
		NewContainer.add(lblEe);

		JLabel label_10 = new JLabel(resume.getTypeOccup());
		label_10.setBounds(320, 440, 62, 18);
		NewContainer.add(label_10);

		JLabel label_11 = new JLabel(resume.getPeriodType());
		label_11.setBounds(320, 500, 62, 18);
		NewContainer.add(label_11);

		JLabel label_12 = new JLabel(resume.getDow());
		label_12.setBounds(320, 560, 62, 18);
		NewContainer.add(label_12);

		setBounds(100, 100, 581, 793);
		setVisible(true);
	}
}
