package com.job.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.job.controller.NoticeRegisterController;
import com.job.model.Connection;
import com.job.model.Notice;
import com.job.model.Resume;
import com.job.model.dao.LoadSave;
import com.job.run.Run;

public class OwnerMainView extends JPanel {
	private JTable table;
	private DefaultTableModel Dtm;
	private ArrayList<Resume> resumes = new ArrayList<Resume>();
	private ArrayList<Notice> notices = new ArrayList<Notice>();
	private ArrayList<Connection> connections = new ArrayList<Connection>();
	private Connection connection = null;
	private JButton btnShowNoticeReg, btnShowMyNotice, btnsShowSearchView, btnDetailView;

	private NoticeRegisterController nrc = new NoticeRegisterController();
	private LoadSave dao = LoadSave.getDao();
	private Run win = new Run();

	public OwnerMainView(Run win) {
		this.win = win;
		setLayout(null);
		setSize(1000, 600);
		btnShowNoticeReg = new JButton("");
		btnShowNoticeReg.setBackground(Color.WHITE);
		btnShowNoticeReg.setBounds(63, 119, 161, 66);
		btnShowNoticeReg.setIcon(new ImageIcon(this.getClass().getResource("/resource/NoticeReg.png")));
		btnShowNoticeReg.setContentAreaFilled(false);
		btnShowNoticeReg.setBorderPainted(false);
		add(btnShowNoticeReg);

		btnShowMyNotice = new JButton("");
		btnShowMyNotice.setBackground(Color.WHITE);
		btnShowMyNotice.setBounds(236, 119, 161, 66);
		btnShowMyNotice.setIcon(new ImageIcon(this.getClass().getResource("/resource/MyNotice.png")));
		btnShowMyNotice.setContentAreaFilled(false);
		btnShowMyNotice.setBorderPainted(false);

		add(btnShowMyNotice);

		btnsShowSearchView = new JButton("");
		btnsShowSearchView.setBackground(Color.WHITE);
		btnsShowSearchView.setForeground(Color.BLACK);
		btnsShowSearchView.setIcon(new ImageIcon(this.getClass().getResource("/resource/SearchBtn.png")));
		btnsShowSearchView.setContentAreaFilled(false);
		btnsShowSearchView.setBorderPainted(false);

		btnsShowSearchView.setBounds(726, 119, 161, 66);
		add(btnsShowSearchView);
		// ----------------------------------------------------------------------------------------------------------------------------------------------------------

		String[] colum = { "", "", "", "" };
		Dtm = new DefaultTableModel(colum, 0);

		table = new JTable(Dtm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(20);
		Dtm.setColumnIdentifiers(new String[] { "이름", "성별", "나이", "전화번호" });

		JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setEnabled(false);
		scrollPane1.setBounds(99, 255, 786, 320);
		add(scrollPane1);

		// 상세보기 버튼
		btnDetailView = new JButton("\uC0C1\uC138\uBCF4\uAE30");
		btnDetailView.setBounds(563, 204, 105, 27);
		add(btnDetailView);
		// ----------------------------------------------------------------------------------------------------------------------------------------------------------

		JButton btnLogout = new JButton("");
		btnLogout.setBounds(876, 25, 112, 28);
		btnLogout.setIcon(new ImageIcon(this.getClass().getResource("/resource/LogoutBtn.png")));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		add(btnLogout);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/resource/OwnerMainView.jpg")));
		label.setBounds(0, 0, 1000, 600);
		add(label);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = table.getColumnModel();
		table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가
		table.setFocusable(false);

		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(dtcr);
		}

		Dtm.setNumRows(0);
		showResume();
		// ----------------------------------------------------------------------------------------------------------------------------------------------------------

		settingButton();

	}

	private void showNoticeReg() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getNoticeRegisterView());
		win.setVisible(false);
		win.setVisible(true);
		revalidate();
		repaint();
	}

	private void showMyNotice() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getNoticeUpdateView());
		revalidate();
		repaint();
		win.getNoticeUpdateView().settingData();
		win.setVisible(false);
		win.setVisible(true);

	}

	private void showSearchView() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getSearchView());
		revalidate();
		repaint();
		win.setSize(1000, 620);
		win.getSearchView().reset();
		win.setVisible(false);
		win.setVisible(true);
	}

	public void resetDTM() {
		Dtm.setNumRows(0);
	}

	private void logout() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getLoginView());
		win.setSize(590, 590);
		revalidate();
		repaint();
	}

	// OwnerMainView 진입시에 내가 올린 구인공고에 지원한 구인자를 보여주는 메소드
	public void showResume() {
		ArrayList<Connection> connections = dao.loadConnection();
		Connection connection = new Connection();
		ArrayList<Resume> resumes = null;
		if (connections != null) {
			for (int i = 0; i < connections.size(); i++) {
				if (connections.get(i).getNoticeNo() == dao.getNowUser()) {
					connection = connections.get(i);
					break;
				}
			}

			if (connection.getResumes() != null) {
				resumes = connection.getResumes();
				System.out.println("-------------------------------------------");
				System.out.println("Now Notice : " + connection.getNoticeNo());
				System.out.println("Now Resumes Count : " + connection.getResumes().size());
				System.out.println("Now Resumes : " + connection.getResumes().toString());
				System.out.println("-------------------------------------------");

				if (resumes.size() > 0) {
					for (int i = 0; i < resumes.size(); i++) {
						Dtm.addRow(new String[] { resumes.get(i).getName(), Integer.toString(resumes.get(i).getAge()),
								resumes.get(i).getGender(), resumes.get(i).getPhone() });
					}
				}
			}

		}
	}

	private void settingButton() {
		btnShowMyNotice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showMyNotice();
			}
		});
		btnShowNoticeReg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showNoticeReg();
			}
		});

		btnsShowSearchView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showSearchView();
			}
		});

		btnDetailView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = table.getSelectedRow();
				win.getOwnerDetailView().OwnerDetailButton1(seeMore(num));

			}
		});
	}

	public void isNoticeTest() {
		if (nrc.isApplyCheck()) {
			System.out.println();
			btnShowNoticeReg.setEnabled(true);
			btnShowMyNotice.setEnabled(false);
		} else {
			btnShowMyNotice.setEnabled(true);
			btnShowNoticeReg.setEnabled(false);
		}
	}

	// 상세보기
	public Resume seeMore(int num) {
		Resume temp = new Resume();
		ArrayList<Resume> arr = LoadSave.getDao().loadResume();
		ArrayList<Connection> con = LoadSave.getDao().loadConnection();

		if (num == -1) {

			// 아무것도 선택하지 않고 지원하기를 클릭했을때
			// 안내메세지

			JOptionPane.showMessageDialog(null, "원하시는 알바를 선택해주세요!");

			System.out.println("선택 안함");

		} else if (num != -1) {
			for (int i = 0; i < con.size(); i++) {
				if (con.get(i).getNoticeNo() == dao.getNowUser()) {
					arr = con.get(i).getResumes();
				}
			}

			temp.setName(arr.get(num).getName());
			temp.setAge(arr.get(num).getAge());
			temp.setGender(arr.get(num).getGender());
			temp.setPhone(arr.get(num).getPhone());
			temp.setCareer(arr.get(num).getCareer());
			temp.setPeriodType(arr.get(num).getPeriodType());
			temp.setTypeOccup(arr.get(num).getTypeOccup());
			temp.setPeriodType(arr.get(num).getPeriodType());
			temp.setDow(arr.get(num).getDow());
			temp.setTime(arr.get(num).getTime());
			temp.setRegion(arr.get(num).getRegion());

			System.out.println(temp.toString());

			win.getContentPane().removeAll();
			win.getContentPane().add(win.getOwnerDetailView());
			revalidate();
			repaint();
			win.setSize(1000, 600);
			win.setVisible(false);
			win.setVisible(true);

		}

		return temp;
	}
}
