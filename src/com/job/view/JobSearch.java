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

	String periodType; // comBobox에서 가져온 요일
	String typeOccup; // comBobox에서 가져온 직종
	String region; // comBobox에서 가져온 지역
    String timeTotime;  // comBobox에서 가져온 몇시까지
    
    
	String typeOccup2; // pt.get(i)의 근무형태 변수
	String bName; // pt.get(i)의 업장명 변수
	String timeTotime2; // pt.get(i)의 근무시간 변수
	String pay; // pt.get(i)의 시급 변수
	String region2; // pt.get(i)의 주소 변수
	String timeType; // pt.get(i)의 몇시까지의 시간 변수
	String periodType2; // pt.get(i)의 기간 변수

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
		Title.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 24));
		Title.setBackground(SystemColor.control);
		Title.setText("\uAD6C \uC778 \uACF5 \uACE0 \uAC80 \uC0C9");
		Title.setBounds(12, 10, 199, 35);
		jobTable.add(Title);

		// 직종 ComboBox
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

		// 검색버튼
		searchButton = new JButton("\uAC80\uC0C9");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				search();

//				//"직종","연령","성별","기간","요일","시간","지역"
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

		// 테이블
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(34, 216, 901, 335);
		jobTable.add(scrollPane);

		String[] colum = { "", "", "", "", "", "", "" };
		DtmStorage = new DefaultTableModel(colum, 0);
		searchTable = new JTable(DtmStorage);

		//테이블 행 타이틀
		DtmStorage.setColumnIdentifiers(new String[] { "업장명", "시급", "근무시간", "근무형태", "주소", "기간", "시간" });

		// 테이블에 행 삽입
		DtmStorage.addRow(new String[] { (String) bName, pay, timeTotime2, typeOccup2, region2, periodType2, timeType });

		searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		searchTable.getTableHeader().setReorderingAllowed(false); // 테이블 셀 마우스로 이동 못하게
		searchTable.setAutoCreateRowSorter(true);
		searchTable.setCellSelectionEnabled(rootPaneCheckingEnabled);
		searchTable.setRowHeight(50);
		searchTable.getSelectedRow();
		scrollPane.setViewportView(searchTable);

		JTextPane regionName = new JTextPane();
		regionName.setBackground(SystemColor.control);
		regionName.setFont(new Font("나눔고딕", Font.BOLD, 18));
		regionName.setText("\uC9C0\uC5ED");
		regionName.setBounds(49, 95, 40, 28);
		jobTable.add(regionName);

		// 지역 ComboBox
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
		jobName.setFont(new Font("나눔고딕", Font.BOLD, 18));
		jobName.setBackground(SystemColor.menu);
		jobName.setBounds(265, 95, 40, 28);
		jobTable.add(jobName);

//		ButtonGroup group = new ButtonGroup();
//		group.add(genderMale);
//		group.add(genderFemale);

		JTextPane periodName = new JTextPane();
		periodName.setText("\uAE30\uAC04");
		periodName.setFont(new Font("나눔고딕", Font.BOLD, 18));
		periodName.setBackground(SystemColor.menu);
		periodName.setBounds(265, 155, 40, 28);
		jobTable.add(periodName);

		// 요일 ComboBox
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

		// 초기화 버튼
		JButton resetButton = new JButton("\uC0C1\uC138 \uC815\uBCF4");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		resetButton.setBounds(844, 173, 91, 35);
		jobTable.add(resetButton);

		// 지원하기 버튼
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
		textPane.setFont(new Font("나눔고딕", Font.BOLD, 18));
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
	 * //"업장명", "시급", "근무시간", "근무형태", "주소", "기간", "시간" // 테스트 할 리스트 객체 pt.add(new
	 * Partimer("KH 정보교육원", "10000", "오후 3시부터", "IT", "서울", "1개월 이상", "3시간 ~ 6시간"));
	 * pt.add(new Partimer("피씨방", "25000", "오전 9시부터", "매장관리", "인천", "3개월 이상",
	 * "6시간 ~ 8시간")); pt.add(new Partimer("분식집", "50000", "오후 2시부터", "영업", "충남",
	 * "일주일", "8시간 이상")); pt.add(new Partimer("학원", "10000", "오전 10시부터", "사무", "부산",
	 * "하루", "1시간 ~ 3시간")); pt.add(new Partimer("레스토랑", "14000", "오후 6시부터", "주방",
	 * "서울", "1개월 이상", "3시간 ~ 6시간")); pt.add(new Partimer("정비소", " 8000", "오후 4시부터",
	 * "운전", "인천", "일주일", "3시간 ~ 6시간")); pt.add(new Partimer("대리운전", "5000",
	 * "오후 3시부터", "운전", "인천", "하루", "8시간 이상"));
	 * 
	 * 
	 * }
	 */

	public void search() {
		pt2.clear();
		System.out.println("출력 결과");
		DtmStorage.setNumRows(0); // 검색 버튼을 누를때마다 테이블 갱신

		// List pt 의 사이즈만큼 반복
		for (int i = 0; i < pt.size(); i++) {

			// pt의 인덱스별 변수 저장
			 typeOccup2 = pt.get(i).getTypeOccup(); // pt.get(i)의 근무형태 변수
			 bName = pt.get(i).getbName(); // pt.get(i)의 업장명 변수
			 timeTotime2 = pt.get(i).getTimeTotime(); // pt.get(i)의 근무시간 변수
			 pay = pt.get(i).getPay(); // pt.get(i)의 시급 변수
			 region2 = pt.get(i).getRegion(); // pt.get(i)의 주소 변수
			 timeType = pt.get(i).getTimeType(); // pt.get(i)의 몇시까지의 시간 변수
			 periodType2 = pt.get(i).getPriodType(); // pt.get(i)의 기간 변수
			

			// 각 항목 비교 if문들
			 
//				String periodType; // comBobox에서 가져온 기간
//				String typeOccup; // comBobox에서 가져온 직종
//				String region; // comBobox에서 가져온 지역
//			    String timeTotime;  // comBobox에서 가져온 몇시까지
			 
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
//    	System.out.println("pt2로 리스트 이동 결과");
//    	for(int i = 0; i < pt2.size(); i++)
//    	{
//    		System.out.println(pt2.get(i));
//    	}

		if (searchTable.getSelectedRow() == -1) {
			System.out.println("선택 안함");
		} else {
			int row = searchTable.getSelectedRow();


			System.out.println("지원 내용");
			temp.add(new Partimer(searchTable.getValueAt(row, 0).toString(), searchTable.getValueAt(row, 1).toString(),
					searchTable.getValueAt(row, 2).toString(), searchTable.getValueAt(row, 3).toString(),
					searchTable.getValueAt(row, 4).toString(), searchTable.getValueAt(row, 5).toString(),
					searchTable.getValueAt(row, 6).toString()));

			System.out.println(temp.toString());

		}
	}
}
