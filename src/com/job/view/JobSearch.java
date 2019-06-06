package com.job.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.job.model.Partimer;

public class JobSearch extends JFrame {

	private DefaultTableModel DtmStorage;
	static List<Partimer> pt = new ArrayList<Partimer>();
	static List<Partimer> pt2 = new ArrayList<Partimer>();

	String periodType; // comBobox���� ������ ����
	String typeOccup; // comBobox���� ������ ����
	String region; // comBobox���� ������ ����
    String timeTotime;  // comBobox���� ������ ��ñ���
    
    
	String typeOccup2; // pt.get(i)�� �ٹ����� ����
	String bName; // pt.get(i)�� ����� ����
	String timeTotime2; // pt.get(i)�� �ٹ��ð� ����
	String pay; // pt.get(i)�� �ñ� ����
	String region2; // pt.get(i)�� �ּ� ����
	String timeType; // pt.get(i)�� ��ñ����� �ð� ����
	String periodType2; // pt.get(i)�� �Ⱓ ����

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jobTable;
	private JTable searchTable;
	private JButton searchButton;
	private JComboBox<?> typeOccurType;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JobSearch frame = new JobSearch();
					frame.setVisible(true);
					testset();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JobSearch() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1000, 600);
		jobTable = new JPanel();
		jobTable.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jobTable);
		jobTable.setLayout(null);

		JTextPane Title = new JTextPane();
		Title.setFont(new Font("������� ExtraBold", Font.BOLD, 24));
		Title.setBackground(SystemColor.control);
		Title.setText("\uAD6C \uC778 \uACF5 \uACE0 \uAC80 \uC0C9");
		Title.setBounds(12, 10, 199, 35);
		jobTable.add(Title);

		// ���� ComboBox
		typeOccurType = new JComboBox<Object>();
		typeOccurType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				typeOccup = typeOccurType.getSelectedItem().toString();

			}
		});

		typeOccurType.setModel(new DefaultComboBoxModel(
				new String[] { "[\uADFC\uBB34 \uD615\uD0DC]", "\uB9E4\uC7A5\uAD00\uB9AC", "\uC8FC\uBC29",
						"\uBBF8\uB514\uC5B4", "\uC6B4\uC804", "\uC0AC\uBB34", "IT", "\uC601\uC5C5", "\uAD50\uC721" }));
		typeOccurType.setSelectedIndex(0);
		typeOccurType.setBounds(317, 92, 192, 35);
		jobTable.add(typeOccurType);

		// �˻���ư
		searchButton = new JButton("\uAC80\uC0C9");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				search();

//				//"����","����","����","�Ⱓ","����","�ð�","����"
//				for(int i = 0; i < pt2.size(); i++)
//				{
//					DtmStorage.addRow(new String[] {(String)pt.get(i).getTypeOccup().toString() , pt.get(i).getAge().toString() , 
//							pt.get(i).getGender().toString() , pt.get(i).getTimeType().toString() , pt.get(i).getDow().toString(),
//							pt.get(i).getTimeTotime().toString(), pt.get(i).getRegion().toString()});
//				}

			}
		});
		searchButton.setBounds(741, 128, 194, 35);
		jobTable.add(searchButton);

		// ���̺�
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(34, 216, 901, 335);
		jobTable.add(scrollPane);

		String[] colum = { "", "", "", "", "", "", "" };
		DtmStorage = new DefaultTableModel(colum, 0);
		searchTable = new JTable(DtmStorage);

		//���̺� �� Ÿ��Ʋ
		DtmStorage.setColumnIdentifiers(new String[] { "�����", "�ñ�", "�ٹ��ð�", "�ٹ�����", "�ּ�", "�Ⱓ", "�ð�" });

		// ���̺� �� ����
		DtmStorage.addRow(new String[] { (String) bName, pay, timeTotime2, typeOccup2, region2, periodType2, timeType });

		searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		searchTable.getTableHeader().setReorderingAllowed(false); // ���̺� �� ���콺�� �̵� ���ϰ�
		searchTable.setAutoCreateRowSorter(true);
		searchTable.setCellSelectionEnabled(rootPaneCheckingEnabled);
		searchTable.setRowHeight(50);
		searchTable.getSelectedRow();
		scrollPane.setViewportView(searchTable);

		JTextPane regionName = new JTextPane();
		regionName.setBackground(SystemColor.control);
		regionName.setFont(new Font("�������", Font.BOLD, 18));
		regionName.setText("\uC9C0\uC5ED");
		regionName.setBounds(49, 95, 40, 28);
		jobTable.add(regionName);

		// ���� ComboBox
		JComboBox<Object> regionType = new JComboBox<Object>();
		regionType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				region = regionType.getSelectedItem().toString();

			}
		});
		regionType.setModel(new DefaultComboBoxModel(new String[] {"[\uADFC\uBB34 \uC9C0\uC5ED]", "\uC11C\uC6B8", "\uACBD\uAE30", "\uBD80\uC0B0", "\uB300\uAD6C", "\uC778\uCC9C", "\uAD11\uC8FC", "\uB300\uC804", "\uC6B8\uC0B0", "\uACBD\uB0A8", "\uACBD\uBD81", "\uCDA9\uB0A8", "\uCDA9\uBD81", "\uC804\uB0A8", "\uC804\uBD81", "\uAC15\uC6D0", "\uC81C\uC8FC"}));
		regionType.setSelectedIndex(0);
		regionType.setBounds(101, 92, 144, 35);
		jobTable.add(regionType);

		JTextPane jobName = new JTextPane();
		jobName.setText("\uC9C1\uC885");
		jobName.setFont(new Font("�������", Font.BOLD, 18));
		jobName.setBackground(SystemColor.menu);
		jobName.setBounds(265, 95, 40, 28);
		jobTable.add(jobName);

//		ButtonGroup group = new ButtonGroup();
//		group.add(genderMale);
//		group.add(genderFemale);

		JTextPane periodName = new JTextPane();
		periodName.setText("\uAE30\uAC04");
		periodName.setFont(new Font("�������", Font.BOLD, 18));
		periodName.setBackground(SystemColor.menu);
		periodName.setBounds(265, 155, 40, 28);
		jobTable.add(periodName);

		// ���� ComboBox
		JComboBox<Object> periodCombobox = new JComboBox<Object>();
		periodCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				periodType = periodCombobox.getSelectedItem().toString();

			}
		});
		periodCombobox.setModel(new DefaultComboBoxModel(new String[] {"[\uAE30\uAC04 \uC120\uD0DD]", "\uD558\uB8E8", "\uC77C\uC8FC\uC77C", "1\uAC1C\uC6D4 \uC774\uC0C1", "3\uAC1C\uC6D4 \uC774\uC0C1", "6\uAC1C\uC6D4 \uC774\uC0C1"}));
		periodCombobox.setSelectedIndex(0);
		periodCombobox.setBounds(317, 152, 130, 35);
		jobTable.add(periodCombobox);

		// �ʱ�ȭ ��ư
		JButton resetButton = new JButton("\uC0C1\uC138 \uC815\uBCF4");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		resetButton.setBounds(844, 173, 91, 35);
		jobTable.add(resetButton);

		// �����ϱ� ��ư
		JButton apply = new JButton("\uC9C0\uC6D0\uD558\uAE30");
		apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				search2();

			}
		});
		apply.setBounds(741, 173, 91, 35);
		jobTable.add(apply);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("\uC2DC\uAC04");
		textPane.setFont(new Font("�������", Font.BOLD, 18));
		textPane.setBackground(SystemColor.menu);
		textPane.setBounds(49, 155, 40, 28);
		jobTable.add(textPane);
		
		JComboBox<Object> timeTotimeCombo = new JComboBox<Object>();
		timeTotimeCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				timeTotime = timeTotimeCombo.getSelectedItem().toString();
			}
		});
		timeTotimeCombo.setModel(new DefaultComboBoxModel(new String[] {"[\uC2DC\uAC04 \uC120\uD0DD]", "1\uC2DC\uAC04 ~ 3\uC2DC\uAC04", "3\uC2DC\uAC04 ~ 6\uC2DC\uAC04", "6\uC2DC\uAC04 ~ 8\uC2DC\uAC04", "8\uC2DC\uAC04 \uC774\uC0C1"}));
		timeTotimeCombo.setSelectedIndex(0);
		timeTotimeCombo.setBounds(101, 152, 130, 35);
		jobTable.add(timeTotimeCombo);
		
		JButton button = new JButton("\uCD08\uAE30\uD654");
		button.setBounds(844, 10, 91, 35);
		jobTable.add(button);
	}

	/*
	 * public static void testset() {
	 * 
	 * //"�����", "�ñ�", "�ٹ��ð�", "�ٹ�����", "�ּ�", "�Ⱓ", "�ð�" // �׽�Ʈ �� ����Ʈ ��ü pt.add(new
	 * Partimer("KH ����������", "10000", "���� 3�ú���", "IT", "����", "1���� �̻�", "3�ð� ~ 6�ð�"));
	 * pt.add(new Partimer("�Ǿ���", "25000", "���� 9�ú���", "�������", "��õ", "3���� �̻�",
	 * "6�ð� ~ 8�ð�")); pt.add(new Partimer("�н���", "50000", "���� 2�ú���", "����", "�泲",
	 * "������", "8�ð� �̻�")); pt.add(new Partimer("�п�", "10000", "���� 10�ú���", "�繫", "�λ�",
	 * "�Ϸ�", "1�ð� ~ 3�ð�")); pt.add(new Partimer("�������", "14000", "���� 6�ú���", "�ֹ�",
	 * "����", "1���� �̻�", "3�ð� ~ 6�ð�")); pt.add(new Partimer("�����", " 8000", "���� 4�ú���",
	 * "����", "��õ", "������", "3�ð� ~ 6�ð�")); pt.add(new Partimer("�븮����", "5000",
	 * "���� 3�ú���", "����", "��õ", "�Ϸ�", "8�ð� �̻�"));
	 * 
	 * 
	 * }
	 */

	public void search() {
		pt2.clear();
		System.out.println("��� ���");
		DtmStorage.setNumRows(0); // �˻� ��ư�� ���������� ���̺� ����

		// List pt �� �����ŭ �ݺ�
		for (int i = 0; i < pt.size(); i++) {

			// pt�� �ε����� ���� ����
			 typeOccup2 = pt.get(i).getTypeOccup(); // pt.get(i)�� �ٹ����� ����
			 bName = pt.get(i).getbName(); // pt.get(i)�� ����� ����
			 timeTotime2 = pt.get(i).getTimeTotime(); // pt.get(i)�� �ٹ��ð� ����
			 pay = pt.get(i).getPay(); // pt.get(i)�� �ñ� ����
			 region2 = pt.get(i).getRegion(); // pt.get(i)�� �ּ� ����
			 timeType = pt.get(i).getTimeType(); // pt.get(i)�� ��ñ����� �ð� ����
			 periodType2 = pt.get(i).getPriodType(); // pt.get(i)�� �Ⱓ ����
			

			// �� �׸� �� if����
			 
//				String periodType; // comBobox���� ������ �Ⱓ
//				String typeOccup; // comBobox���� ������ ����
//				String region; // comBobox���� ������ ����
//			    String timeTotime;  // comBobox���� ������ ��ñ���
			 
			if(region.equals(region2) && typeOccup.equals(typeOccup2) && timeTotime.equals(timeTotime2) && periodType.equals(periodType2))
			{
				System.out.println(pt.get(i));
	             
	             pt2.add((Partimer) pt.get(i));
	             
	             for(int j = 0; j < pt2.size(); j++)
	            {
	               DtmStorage.addRow(new String[] { (String) bName, pay, timeType, typeOccup2, region2, periodType2, timeTotime2 });
	               break;
	            }

			}
			

		}

		System.out.println();

	}

	public void search2() {
		
		ArrayList<Partimer> temp = new ArrayList<Partimer>();
//    	System.out.println();
//    	System.out.println("pt2�� ����Ʈ �̵� ���");
//    	for(int i = 0; i < pt2.size(); i++)
//    	{
//    		System.out.println(pt2.get(i));
//    	}

		if (searchTable.getSelectedRow() == -1) {
			System.out.println("���� ����");
		} else {
			int row = searchTable.getSelectedRow();


			System.out.println("���� ����");
			temp.add(new Partimer(searchTable.getValueAt(row, 0).toString(), searchTable.getValueAt(row, 1).toString(),
					searchTable.getValueAt(row, 2).toString(), searchTable.getValueAt(row, 3).toString(),
					searchTable.getValueAt(row, 4).toString(), searchTable.getValueAt(row, 5).toString(),
					searchTable.getValueAt(row, 6).toString()));

			System.out.println(temp.toString());

		}
	}
}
