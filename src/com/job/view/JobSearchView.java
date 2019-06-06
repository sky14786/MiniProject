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

//객체 임포트

public class JobSearchView extends JPanel {

//    MainMenu mm = new MainMenu();
	JobSearchController jsc = new JobSearchController();
	JobSearchView2 sub = new JobSearchView2();
//	Notice n = new Notice();
	public DefaultTableModel DtmStorage;
	public int row;

//	public static List<Notice> pt2 = new ArrayList<Notice>();// 조회결과를 테이블에 보여주기 위한 리스트
//	public static List<Notice> pt3 = new ArrayList<Notice>();// 테이블에 선택한 결과를 담는 리스트
//	public Notice temp = new Notice();
//	Notice temp2 = new Notice();

	public static String periodType; // comBobox에서 가져온 요일
	public static String typeOccup; // comBobox에서 가져온 직종
	public static String region; // comBobox에서 가져온 지역
	public static String timeTotime; // comBobox에서 가져온 몇시간

	private JComboBox<Object> regionType, periodCombobox, timeTotimeCombo;

//    public int bNo2;
//    public String bName; // pt.get(i)의 업장명 변수
//	public double pay; // pt.get(i)의 시급 변수
//	public String timeTotime2; // pt.get(i)의 몇시까지 변수
//    public String typeOccup2; // pt.get(i)의 근무형태 변수
//	public String periodType2; // pt.get(i)의 기간 변수
//	public String timeType2; // pt.get(i)의 몇 시간 변수
//	public String region2; // pt.get(i)의 주소 변수
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
		Title.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 24));
		Title.setBackground(SystemColor.control);
		Title.setText("\uAD6C \uC778 \uACF5 \uACE0 \uAC80 \uC0C9");
		Title.setBounds(12, 10, 199, 35);
		add(Title);

		// 직종 ComboBox
		typeOccurType = new JComboBox<Object>();
		typeOccurType.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
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

		// 검색버튼
		searchButton = new JButton("\uAC80\uC0C9");
		searchButton.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
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

		// 테이블
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(34, 216, 901, 335);
		add(scrollPane);

		String[] colum = { "", "", "", "", "", "", "" };
		DtmStorage = new DefaultTableModel(colum, 0);

		searchTable = new JTable(DtmStorage);
		searchTable.setEnabled(true);

		// 테이블 행 타이틀
		DtmStorage.setColumnIdentifiers(new String[] { "업장번호", "업장명", "시급", "근무시간", "근무형태", "기간", "시간", "주소", "키워드 1",
				"키워드 2", "키워드 3", "추가 설명" });
		// 키워드랑 상세설명은 상세설명 클래스에서 보여주기

		// 테이블에 행 삽입
		// DtmStorage.addRow(new Object[] { jsc.bNo2, jsc.bName, jsc.pay,
		// jsc.timeTotime2, jsc.typeOccup2, jsc.periodType2,jsc.timeType2, jsc.region2,
		// jsc.key1, jsc.key2, jsc.key3, jsc.etc1 });
		searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		searchTable.getTableHeader().setReorderingAllowed(false); // 테이블 셀 마우스로 이동 못하게
		searchTable.setAutoCreateRowSorter(true);
		// searchTable.setCellSelectionEnabled(rootPaneCheckingEnabled);
		searchTable.setRowHeight(50);
		searchTable.getSelectedRow();

		// 키워드 1 항목 숨기기
		searchTable.getColumn("키워드 1").setWidth(0);
		searchTable.getColumn("키워드 1").setMinWidth(0);
		searchTable.getColumn("키워드 1").setMaxWidth(0);

		// 키워드 2 항목 숨기기
		searchTable.getColumn("키워드 2").setWidth(0);
		searchTable.getColumn("키워드 2").setMinWidth(0);
		searchTable.getColumn("키워드 2").setMaxWidth(0);

		// 키워드 3 항목 숨기기
		searchTable.getColumn("키워드 3").setWidth(0);
		searchTable.getColumn("키워드 3").setMinWidth(0);
		searchTable.getColumn("키워드 3").setMaxWidth(0);

		// 추가 설명 항목 숨기기
		searchTable.getColumn("추가 설명").setWidth(0);
		searchTable.getColumn("추가 설명").setMinWidth(0);
		searchTable.getColumn("추가 설명").setMaxWidth(0);

		// 추가 설명 항목 숨기기
		searchTable.getColumn("업장번호").setWidth(0);
		searchTable.getColumn("업장번호").setMinWidth(0);
		searchTable.getColumn("업장번호").setMaxWidth(0);

		scrollPane.setViewportView(searchTable);

		// 셀 내용 가운데 정렬
		DefaultTableCellRenderer DtmCellRender = new DefaultTableCellRenderer();
		DtmCellRender.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = searchTable.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(DtmCellRender);
		}

		//
		JTextPane regionName = new JTextPane();
		regionName.setBackground(SystemColor.control);
		regionName.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		regionName.setText("\uC9C0\uC5ED");
		regionName.setBounds(49, 95, 40, 28);
		add(regionName);

		// 지역 ComboBox
		regionType = new JComboBox<Object>();
		regionType.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
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
		jobName.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		jobName.setBackground(SystemColor.menu);
		jobName.setBounds(265, 95, 40, 28);
		add(jobName);

		//
		JTextPane periodName = new JTextPane();
		periodName.setText("\uAE30\uAC04");
		periodName.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		periodName.setBackground(SystemColor.menu);
		periodName.setBounds(265, 155, 40, 28);
		add(periodName);

		// 요일 ComboBox
		periodCombobox = new JComboBox<Object>();
		periodCombobox.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
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

		// 상세보기 버튼
		JButton viewMore = new JButton("\uC0C1\uC138 \uC815\uBCF4");
		viewMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				row = searchTable.getSelectedRow();
				sub.subSearch2(jsc.seeMore(row));

			}
		});
		viewMore.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));

		viewMore.setBounds(844, 173, 91, 35);
		add(viewMore);

		// 지원하기 버튼
		JButton apply = new JButton("\uC9C0\uC6D0\uD558\uAE30");
		apply.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
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
		textPane.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		textPane.setBackground(SystemColor.menu);
		textPane.setBounds(49, 155, 40, 28);
		add(textPane);

		timeTotimeCombo = new JComboBox<Object>();
		timeTotimeCombo.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
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

		// 리스트 초기화 버튼
		JButton resetButton = new JButton("\uB9AC\uC2A4\uD2B8 \uCD08\uAE30\uD654");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DtmStorage.setNumRows(0);

			}
		});
		resetButton.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		resetButton.setBounds(741, 38, 194, 35);
		add(resetButton);

		// 전체 보기 버튼
		JButton allView = new JButton("\uC804\uCCB4 \uBCF4\uAE30");
		allView.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
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
