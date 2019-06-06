package com.job.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	private JButton btnShowNoticeReg, btnShowMyNotice;

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
		btnShowNoticeReg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setShowNoticeRegButton();
			}
		});

		btnShowMyNotice = new JButton("");
		btnShowMyNotice.setBackground(Color.WHITE);
		btnShowMyNotice.setBounds(236, 119, 161, 66);
		btnShowMyNotice.setIcon(new ImageIcon(this.getClass().getResource("/resource/MyNotice.png")));
		btnShowMyNotice.setContentAreaFilled(false);
		btnShowMyNotice.setBorderPainted(false);
		btnShowMyNotice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setShowMyNoticeButton();
			}
		});
		add(btnShowMyNotice);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setIcon(new ImageIcon(this.getClass().getResource("/resource/SearchBtn.png")));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSearchBtn();
			}
		});
		btnNewButton_2.setBounds(726, 119, 161, 66);
		add(btnNewButton_2);
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

		// ----------------------------------------------------------------------------------------------------------------------------------------------------------

		JButton btnLogout = new JButton("");
		btnLogout.setBounds(876, 25, 112, 28);
		btnLogout.setIcon(new ImageIcon(this.getClass().getResource("/resource/LogoutBtn.png")));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setLogoutButton();
			}
		});
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

	}

	private void setShowNoticeRegButton() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getNoticeRegisterView());
		win.setVisible(false);
		win.setVisible(true);
		revalidate();
		repaint();
	}

	private void setShowMyNoticeButton() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getNoticeUpdateView());
		revalidate();
		repaint();
		win.getNoticeUpdateView().settingData();
		win.setVisible(false);
		win.setVisible(true);

	}

	private void setSearchBtn() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getSearchView());
		revalidate();
		repaint();
		win.setSize(1000,620);
		win.getSearchView().reset();
		win.setVisible(false);
		win.setVisible(true);

	}

	public void resetDTM() {
		Dtm.setNumRows(0);
	}

	private void setLogoutButton() {
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

//	public void hyunSikCode() {
//		// setTest();
//		ArrayList<Connection> connections = dao.loadConnection();
//		for (int i = 0; i < connections.size(); i++) {
//			if (connections.get(i).getNoticeNo() == dao.getNowUser()) {
//				connection = connections.get(i);
//				break;
//			}
//		}
//
//		resumes = dao.loadResume();
//		notices = dao.loadNoitce();
//
//		// ##start
//		if (connection.getResumes() != null) {
//			HashMap<Object, Object> map = new HashMap<>();
//			map = SimpleSearch(connection, notices);
////					System.out.println("map : " + map);
//
//			ArrayList<Resume> searchList = new ArrayList<>();
//
//			searchList = (ArrayList<Resume>) map.get("resumes");
//			for (int i = 0; i < searchList.size(); i++) {
//				Dtm.addRow(new String[] { searchList.get(i).getName(), Integer.toString(searchList.get(i).getAge()),
//						searchList.get(i).getGender(), searchList.get(i).getPhone() });
//			}
//
//			Notice notice = new Notice();
//			notice = (Notice) map.get("notices");
//		}
//	}
//
//	private HashMap<Object, Object> SimpleSearch(Connection connection, ArrayList<Notice> notices) {
//		/* if(connection.getNoticeNo()==) */
//		HashMap<Object, Object> map = new HashMap<>();
//		ArrayList<Resume> returnlist = new ArrayList<Resume>();
//		if (notices.size() > 0 || connection.getResumes().size() > 0) {
//			for (int i = 0; i < notices.size(); i++) {
//				if (connection.getNoticeNo() == notices.get(i).getbNo()) {
//					map.put("notices", notices.get(i));
//				}
//			}
//
//			// System.out.println("resumes.size() : " + resumes.size());
//			// System.out.println("connection.getResuems().size() : " +
//			// connection.getResuems().size());
//			for (int j = 0; j < connection.getResumes().size(); j++) {
//				returnlist.add(connection.getResumes().get(j));
//			}
//			map.put("resumes", returnlist);
//		}
//		return map;
//
//	}

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
}
