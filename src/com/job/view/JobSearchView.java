package com.job.view;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.job.controller.JobSearchController;
import com.job.model.dao.LoadSave;
import com.job.run.Run;

//��ü ����Ʈ

public class JobSearchView extends JPanel {

//    MainMenu mm = new MainMenu();
	JobSearchController jsc = new JobSearchController();
	JobSearchView2 sub = new JobSearchView2();
//	Notice n = new Notice();
	public DefaultTableModel DtmStorage;
	public int row;

//	public static List<Notice> pt2 = new ArrayList<Notice>();// ��ȸ����� ���̺� �����ֱ� ���� ����Ʈ
//	public static List<Notice> pt3 = new ArrayList<Notice>();// ���̺� ������ ����� ��� ����Ʈ
//	public Notice temp = new Notice();
//	Notice temp2 = new Notice();

	public static String periodType; // comBobox���� ������ ����
	public static String typeOccup; // comBobox���� ������ ����
	public static String region; // comBobox���� ������ ����
	public static String timeTotime; // comBobox���� ������ ��ð�

	private JComboBox<Object> regionType, periodCombobox, timeTotimeCombo;

//    public int bNo2;
//    public String bName; // pt.get(i)�� ����� ����
//	public double pay; // pt.get(i)�� �ñ� ����
//	public String timeTotime2; // pt.get(i)�� ��ñ��� ����
//    public String typeOccup2; // pt.get(i)�� �ٹ����� ����
//	public String periodType2; // pt.get(i)�� �Ⱓ ����
//	public String timeType2; // pt.get(i)�� �� �ð� ����
//	public String region2; // pt.get(i)�� �ּ� ����
//	public String key1;
//	public String key2;
//	public String key3;
//	public String etc1;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTable searchTable;
	private JButton searchButton;
	private JComboBox<?> typeOccurType;
	private JScrollPane scrollPane;
	private JButton btnNo;
	private JButton btnYes;
	private Run win = new Run();
	private LoadSave dao = LoadSave.getDao();

	public JobSearchView() {
	}

	public JobSearchView(Run win) {
		this.win = win;
		setBounds(100, 100, 1000, 600);
		setLayout(null);

		JTextPane Title = new JTextPane();
		Title.setFont(new Font("������� ExtraBold", Font.BOLD, 24));
		Title.setBackground(SystemColor.control);
		Title.setText("\uAD6C \uC778 \uACF5 \uACE0 \uAC80 \uC0C9");
		Title.setBounds(12, 10, 199, 35);
		add(Title);

		// ���� ComboBox
		typeOccurType = new JComboBox<Object>();
		typeOccurType.setFont(new Font("����������", Font.PLAIN, 18));
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
		add(typeOccurType);

		// �˻���ư
		searchButton = new JButton("\uAC80\uC0C9");
		searchButton.setFont(new Font("����������", Font.PLAIN, 18));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DtmStorage.setNumRows(0);
				jsc.search(region, typeOccup, timeTotime, periodType);
				for (int i = 0; i < jsc.pt2.size(); i++) {
					DtmStorage.addRow(new Object[] { jsc.pt2.get(i).getbNo(), jsc.pt2.get(i).getbName(),
							jsc.pt2.get(i).getPay(), jsc.pt2.get(i).getTimeTotime(), jsc.pt2.get(i).getCategory(),
							jsc.pt2.get(i).getPeriodType(), jsc.pt2.get(i).getTimeType(), jsc.pt2.get(i).getAddr(),
							jsc.pt2.get(i).getbKeyword1(), jsc.pt2.get(i).getbKeyword2(), jsc.pt2.get(i).getbKeyword3(),
							jsc.pt2.get(i).getEtc() });

				}

			}
		}

		);
		searchButton.setBounds(741, 128, 194, 35);
		add(searchButton);

		// ���̺�
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(34, 216, 901, 335);
		add(scrollPane);

		String[] colum = { "", "", "", "", "", "", "" };
		DtmStorage = new DefaultTableModel(colum, 0);

		searchTable = new JTable(DtmStorage);
		searchTable.setEnabled(true);

		// ���̺� �� Ÿ��Ʋ
		DtmStorage.setColumnIdentifiers(new String[] { "�����ȣ", "�����", "�ñ�", "�ٹ��ð�", "�ٹ�����", "�Ⱓ", "�ð�", "�ּ�", "Ű���� 1",
				"Ű���� 2", "Ű���� 3", "�߰� ����" });
		// Ű����� �󼼼����� �󼼼��� Ŭ�������� �����ֱ�

		// ���̺� �� ����
		// DtmStorage.addRow(new Object[] { jsc.bNo2, jsc.bName, jsc.pay,
		// jsc.timeTotime2, jsc.typeOccup2, jsc.periodType2,jsc.timeType2, jsc.region2,
		// jsc.key1, jsc.key2, jsc.key3, jsc.etc1 });
		searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		searchTable.getTableHeader().setReorderingAllowed(false); // ���̺� �� ���콺�� �̵� ���ϰ�
		searchTable.setAutoCreateRowSorter(true);
		// searchTable.setCellSelectionEnabled(rootPaneCheckingEnabled);
		searchTable.setRowHeight(50);
		searchTable.getSelectedRow();

		// Ű���� 1 �׸� �����
		searchTable.getColumn("Ű���� 1").setWidth(0);
		searchTable.getColumn("Ű���� 1").setMinWidth(0);
		searchTable.getColumn("Ű���� 1").setMaxWidth(0);

		// Ű���� 2 �׸� �����
		searchTable.getColumn("Ű���� 2").setWidth(0);
		searchTable.getColumn("Ű���� 2").setMinWidth(0);
		searchTable.getColumn("Ű���� 2").setMaxWidth(0);

		// Ű���� 3 �׸� �����
		searchTable.getColumn("Ű���� 3").setWidth(0);
		searchTable.getColumn("Ű���� 3").setMinWidth(0);
		searchTable.getColumn("Ű���� 3").setMaxWidth(0);

		// �߰� ���� �׸� �����
		searchTable.getColumn("�߰� ����").setWidth(0);
		searchTable.getColumn("�߰� ����").setMinWidth(0);
		searchTable.getColumn("�߰� ����").setMaxWidth(0);

		// �߰� ���� �׸� �����
		searchTable.getColumn("�����ȣ").setWidth(0);
		searchTable.getColumn("�����ȣ").setMinWidth(0);
		searchTable.getColumn("�����ȣ").setMaxWidth(0);

		scrollPane.setViewportView(searchTable);

		// �� ���� ��� ����
		DefaultTableCellRenderer DtmCellRender = new DefaultTableCellRenderer();
		DtmCellRender.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = searchTable.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(DtmCellRender);
		}

		//
		JTextPane regionName = new JTextPane();
		regionName.setBackground(SystemColor.control);
		regionName.setFont(new Font("����������", Font.PLAIN, 18));
		regionName.setText("\uC9C0\uC5ED");
		regionName.setBounds(49, 95, 40, 28);
		add(regionName);

		// ���� ComboBox
		regionType = new JComboBox<Object>();
		regionType.setFont(new Font("����������", Font.PLAIN, 18));
		regionType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				region = regionType.getSelectedItem().toString();

			}
		});
		regionType.setModel(new DefaultComboBoxModel(new String[] { "[\uADFC\uBB34 \uC9C0\uC5ED]", "\uAC15\uC6D0",
				"\uACBD\uAE30", "\uACBD\uB0A8", "\uACBD\uBD81", "\uAD11\uC8FC", "\uB300\uAD6C", "\uB300\uC804",
				"\uC11C\uC6B8", "\uC138\uC885", "\uC6B8\uC0B0", "\uC778\uCC9C", "\uC804\uB0A8", "\uC804\uBD81",
				"\uC81C\uC8FC", "\uBD80\uC0B0", "\uCDA9\uB0A8", "\uCDA9\uBD81" }));
		regionType.setSelectedIndex(0);
		regionType.setBounds(101, 92, 144, 35);
		add(regionType);

		//
		JTextPane jobName = new JTextPane();
		jobName.setText("\uC9C1\uC885");
		jobName.setFont(new Font("����������", Font.PLAIN, 18));
		jobName.setBackground(SystemColor.menu);
		jobName.setBounds(265, 95, 40, 28);
		add(jobName);

		//
		JTextPane periodName = new JTextPane();
		periodName.setText("\uAE30\uAC04");
		periodName.setFont(new Font("����������", Font.PLAIN, 18));
		periodName.setBackground(SystemColor.menu);
		periodName.setBounds(265, 155, 40, 28);
		add(periodName);

		// ���� ComboBox
		periodCombobox = new JComboBox<Object>();
		periodCombobox.setFont(new Font("����������", Font.PLAIN, 18));
		periodCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				periodType = periodCombobox.getSelectedItem().toString();

			}
		});
		periodCombobox.setModel(new DefaultComboBoxModel(
				new String[] { "[\uAE30\uAC04 \uC120\uD0DD]", "\uD558\uB8E8", "\uC77C\uC8FC\uC77C",
						"1\uAC1C\uC6D4 \uC774\uC0C1", "3\uAC1C\uC6D4 \uC774\uC0C1", "6\uAC1C\uC6D4 \uC774\uC0C1" }));
		periodCombobox.setSelectedIndex(0);
		periodCombobox.setBounds(317, 152, 130, 35);
		add(periodCombobox);

		// �󼼺��� ��ư
		JButton viewMore = new JButton("\uC0C1\uC138 \uC815\uBCF4");
		viewMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				row = searchTable.getSelectedRow();
				sub.subSearch2(jsc.seeMore(row));

			}
		});
		viewMore.setFont(new Font("����������", Font.PLAIN, 14));

		viewMore.setBounds(844, 173, 91, 35);
		add(viewMore);

		// �����ϱ� ��ư
		JButton apply = new JButton("\uC9C0\uC6D0\uD558\uAE30");
		apply.setFont(new Font("����������", Font.PLAIN, 14));
		apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				row = searchTable.getSelectedRow();	
				jsc.search2(row);

			}
		});
		apply.setBounds(741, 173, 91, 35);
		add(apply);

		JTextPane textPane = new JTextPane();
		textPane.setText("\uC2DC\uAC04");
		textPane.setFont(new Font("����������", Font.PLAIN, 18));
		textPane.setBackground(SystemColor.menu);
		textPane.setBounds(49, 155, 40, 28);
		add(textPane);

		timeTotimeCombo = new JComboBox<Object>();
		timeTotimeCombo.setFont(new Font("����������", Font.PLAIN, 18));
		timeTotimeCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				timeTotime = timeTotimeCombo.getSelectedItem().toString();
			}
		});
		timeTotimeCombo.setModel(new DefaultComboBoxModel(new String[] { "[\uC2DC\uAC04 \uC120\uD0DD]",
				"1\uC2DC\uAC04 ~ 3\uC2DC\uAC04", "3\uC2DC\uAC04 ~ 6\uC2DC\uAC04", "6\uC2DC\uAC04 ~ 8\uC2DC\uAC04",
				"8\uC2DC\uAC04 \uC774\uC0C1" }));
		timeTotimeCombo.setSelectedIndex(0);
		timeTotimeCombo.setBounds(101, 152, 130, 35);
		add(timeTotimeCombo);

		// ����Ʈ �ʱ�ȭ ��ư
		JButton resetButton = new JButton("\uB9AC\uC2A4\uD2B8 \uCD08\uAE30\uD654");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DtmStorage.setNumRows(0);

			}
		});
		resetButton.setFont(new Font("����������", Font.PLAIN, 18));
		resetButton.setBounds(741, 38, 194, 35);
		add(resetButton);

		// ��ü ���� ��ư
		JButton allView = new JButton("\uC804\uCCB4 \uBCF4\uAE30");
		allView.setFont(new Font("����������", Font.PLAIN, 18));
		allView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jsc.pt2 = dao.loadNoitce();
				DtmStorage.setNumRows(0);
				jsc.printAll();
				for (int i = 0; i < jsc.pt2.size(); i++) {
					DtmStorage.addRow(new Object[] { jsc.pt2.get(i).getbNo(), jsc.pt2.get(i).getbName(),
							jsc.pt2.get(i).getPay(), jsc.pt2.get(i).getTimeTotime(), jsc.pt2.get(i).getCategory(),
							jsc.pt2.get(i).getPeriodType(), jsc.pt2.get(i).getTimeType(), jsc.pt2.get(i).getAddr(),
							jsc.pt2.get(i).getbKeyword1(), jsc.pt2.get(i).getbKeyword2(), jsc.pt2.get(i).getbKeyword3(),
							jsc.pt2.get(i).getEtc() });

				}
			}
		});
		allView.setBounds(741, 83, 194, 35);
		add(allView);

	}
}
