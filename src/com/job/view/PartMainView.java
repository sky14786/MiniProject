package com.job.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.job.controller.CheckingController;
import com.job.controller.ResumeDeleteController;
import com.job.model.Partimer;
import com.job.run.Run;

public class PartMainView extends JPanel {

	private JTextField tfKeyword;
	private JButton searchBtn;
	private JButton enrollBtn;
	private JButton modifyBtn;
	private JButton deleteBtn;
	private JButton listBtn;
	private JButton logoutBtn;
	private JButton ansYes;
	private JButton ansNo;
	private JLabel loginLabel;
	private JLabel nowUserLabel;

	private ResumeDeleteController resumeDeleteController = new ResumeDeleteController();
	private CheckingController checkingController = new CheckingController();

	public Run win = new Run();

	public int check = 1;

	public PartMainView(Run win) {
		this.win = win;
		initialize();
	}

	private void initialize() {
		setSize(1000, 600);
		setLayout(null);

		tfKeyword = new JTextField();
		tfKeyword.setHorizontalAlignment(SwingConstants.CENTER);
		tfKeyword.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		tfKeyword.setBounds(340, 256, 230, 70);
		add(tfKeyword);
		tfKeyword.setColumns(10);

		searchBtn = new JButton("\uAC80\uC0C9");
		searchBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		searchBtn.setBounds(570, 256, 70, 70);
		add(searchBtn);

		enrollBtn = new JButton("\uC774\uB825\uC11C \uB4F1\uB85D");
		enrollBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		enrollBtn.setBounds(245, 190, 110, 30);
		add(enrollBtn);

		modifyBtn = new JButton("\uC774\uB825\uC11C \uC218\uC815");
		modifyBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		modifyBtn.setBounds(365, 190, 110, 30);
		add(modifyBtn);

		deleteBtn = new JButton("\uC774\uB825\uC11C \uC0AD\uC81C");
		deleteBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		deleteBtn.setBounds(485, 190, 110, 30);
		add(deleteBtn);

		listBtn = new JButton("\uC9C0\uC6D0 \uBAA9\uB85D");
		listBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		listBtn.setBounds(605, 190, 110, 30);
		add(listBtn);

		logoutBtn = new JButton("\uB85C\uADF8\uC544\uC6C3");
		logoutBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		logoutBtn.setBounds(896, 12, 90, 30);
		add(logoutBtn);

		loginLabel = new JLabel("\uB2D8 \uC811\uC18D\uC911");
		loginLabel.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 15));
		loginLabel.setBounds(822, 12, 60, 30);
		add(loginLabel);

		nowUserLabel = new JLabel("anonymous");
		nowUserLabel.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 15));
		nowUserLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nowUserLabel.setBounds(704, 12, 110, 30);
		add(nowUserLabel);

		showId();
		buttonTest();
		searchClick();
		searchEnter();
		enrollScene();
		modifyScene();
		deleteScene();
		listScene();
		prevScene();

	}

	// 현재 접속중인 유저 띄우기
	public void showId() {
		Partimer temp = null;
		if ((temp = checkingController.sendUserInformation()) != null) {
			System.out.println("-------------------------------------------");
			System.out.println("showId : " + temp.toString());
			System.out.println("-------------------------------------------");
			nowUserLabel.setText(temp.getId());
		} else {
			// System.out.println("아이디 불러오기 오류");
		}
	}

	// 등록,수정,삭제버튼 enable 여부
	public void buttonTest() {
		check = checkingController.isApplyCheck();
		// System.out.println("버튼 활성화 : " + check);
		if (check == 3) {
			enrollBtn.setEnabled(true);
			deleteBtn.setEnabled(false);
			modifyBtn.setEnabled(false);
		} else if (check == 2) {
			enrollBtn.setEnabled(false);
			deleteBtn.setEnabled(true);
			modifyBtn.setEnabled(true);
		} else {
			// System.out.println("버튼 활성화 오류");
		}
	}

	// 검색버튼 액션
	public void searchClick() {
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) // 구현할것 : 화면전환, 키워드 넘기기
			{
				// 키워드 넘기기 임시테스트
				String keyword = tfKeyword.getText();
				System.out.println("-------------------------------------------");
				System.out.println("검색 키워드 : " + keyword);
				System.out.println("-------------------------------------------");

				// 화면전환
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getJobSearchView()); // 여기서 기호오빠 화면으로 전환
				win.getContentPane().revalidate();
				win.getContentPane().repaint();
			}
		});
	}

	// 검색창 액션 (enter키)
	public void searchEnter() {
		tfKeyword.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) // 구현할것 : 화면전환, 키워드 넘기기
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// 키워드 넘기기 임시테스트
					String keyword = tfKeyword.getText();
					System.out.println("-------------------------------------------");
					System.out.println("검색 키워드 : " + keyword);
					System.out.println("-------------------------------------------");

					// 화면전환
					win.getContentPane().removeAll();
					win.getContentPane().add(win.getJobSearchView()); // 여기서 기호오빠 화면으로 전환
					win.getContentPane().revalidate();
					win.getContentPane().repaint();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	// 이력서 등록 버튼 액션
	// 스위치 확인, 이력서 등록창 띄우기
	public void enrollScene() {
		enrollBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getResumeEnrollView());
				win.getContentPane().revalidate();
				win.getContentPane().repaint();
				win.getResumeEnrollView().settingData();
			}
		});
	}

	// 이력서 수정 버튼 액션
	// 스위치 확인, 저장된 이력서 불러와 띄우기
	public void modifyScene() {
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getResumeModifyView());
				win.getContentPane().revalidate();
				win.getContentPane().repaint();
				win.getResumeModifyView().settingData();
			}
		});
	}

	// 이력서 삭제 버튼 액션
	// 이력서 모두 비우기 , 스위치, 팝업
	public void deleteScene() {
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 팝업 알림창
				JDialog notice = new JDialog(win, "삭제알림", false);
				notice.setBounds(300, 150, 400, 300);
				notice.getContentPane().setLayout(null);

				JLabel label = new JLabel("삭제하시겠습니까?");
				label.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(90, 70, 200, 20);
				notice.getContentPane().add(label);

				// 삭제 진행 승인 버튼
				ansYes = new JButton("삭제");
				ansYes.setBounds(100, 150, 80, 50);
				ansYes.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
				ansYes.setVisible(true);
				notice.getContentPane().add(ansYes);
				ansYes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 이력서 삭제
						resumeDeleteController.delResume();

						// 삭제시 등록 버튼 활성화
						buttonTest();

						// 등록화면 null로 세팅
						win.getResumeEnrollView().clearTextField();
						notice.setVisible(false);
					}
				});

				// 삭제 진행 취소 버튼
				ansNo = new JButton("취소");
				ansNo.setBounds(200, 150, 80, 50);
				ansNo.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
				ansNo.setVisible(true);
				notice.getContentPane().add(ansNo);
				ansNo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						notice.setVisible(false);
					}
				});

				notice.setVisible(true);
			}
		});
	}

	// 지원목록 버튼 액션
	public void listScene() {
		listBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 지원목록 띄우기 (현희언니꺼랑 연결)
				win.getContentPane().removeAll();
				win.setSize(1000, 600);
				win.getContentPane().add(win.getResumeDeleteView()); // 여기서 현희언니 화면으로 전환
				win.getContentPane().revalidate();
				win.getContentPane().repaint();
			}
		});
	}

	// 로그아웃 버튼 액션
	public void prevScene() {
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getLoginView());
				win.setSize(590, 590);
				revalidate();
				repaint();
			}
		});
	}
}
