package com.job.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.ImageIcon;

//import com.resume.run.Run;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.job.model.Notice;
import com.job.model.dao.LoadSave;
import com.job.run.Run;

public class ResumeDeleteView extends JPanel {

	// ��ȣ�ڵ�
	private ArrayList<Notice> pt = new ArrayList<Notice>();
	private ArrayList<Notice> pt2 = new ArrayList<Notice>();
	private ArrayList<Connection> connections = new ArrayList<Connection>();
	private LoadSave dao = LoadSave.getDao();

	private DefaultTableModel DtmStorage;
	private JTable searchTable;
	private JScrollPane scrollPane;
	private JButton btnDelete;
	private JButton btnBack;
	// public Run win = new Run();

	private Image img;

	// private ResumeDelete2 resumeDelete2 = new ResumeDelete2();

	// ��ȣ �ڵ�
	String bNo;
	String category; // pt.get(i)�� �ٹ����� ����
	String bName; // pt.get(i)�� ����� ����
	String timeTotime2; // pt.get(i)�� �ٹ��ð� ����
	String pay; // pt.get(i)�� �ñ� ����
	String region2; // pt.get(i)�� �ּ� ����
	String timeType; // pt.get(i)�� ��ñ����� �ð� ����
	String periodType2; // pt.get(i)�� �Ⱓ ����

	private JFrame frame;

	private static final long serialVersionUID = 1L;
	private JPanel jobTable;
	private JButton searchButton;
	private JComboBox<?> typeOccurType;
	private Run win = new Run();

	public ResumeDeleteView(Run win) {
		this.win = win;
		initialize();
	}

	private void initialize() {

		setSize(1000, 600);
		setLayout(null);

		ImagePanel imgPanel = new ImagePanel(new ImageIcon("./image/����Ʋ.jpg").getImage());
		add(imgPanel);

		imgPanel.setBounds(0, 0, 1000, 600);
		add(imgPanel);
		imgPanel.setLayout(null);
		// //frame.pack();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 561);
		add(panel);
		panel.setLayout(null);

		// ' ���� ��� ' ��ư - ù���� �˾�â���� �Ѿ

		JButton deleteButton = new JButton("");
		deleteButton.setBackground(new Color(255, 215, 0));
		deleteButton.setIcon(new ImageIcon(ResumeDeleteView.class.getResource("/resourses/deleteButton.jpg")));
		deleteButton.setFont(new Font("����������", Font.PLAIN, 14));
		deleteButton.setBorderPainted(false);
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Modal m = new Modal(frame);
				m.setVisible(true);

			}
		});
		deleteButton.setBounds(560, 496, 200, 50);
		imgPanel.add(deleteButton);

		// ���̺�
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(41, 121, 901, 335);
		imgPanel.add(scrollPane);

		String[] colum = { "", "", "", "", "", "", "" };
		DtmStorage = new DefaultTableModel(colum, 0);
		searchTable = new JTable(DtmStorage);

		// ���̺� �� Ÿ��Ʋ
		DtmStorage.setColumnIdentifiers(new String[] { "�����ȣ", "�����", "�ñ�", "�ٹ��ð�", "�ٹ�����", "�Ⱓ", "�ð�", "�ּ�" });

		// ���̺� �� ����

		// ���� ������ ��ȣ�����Լ� �޾ƾ� �� Connection_Table
		DtmStorage.addRow(new Object[] { bNo, bName, pay, timeTotime2, category, periodType2, timeType, region2 });

		searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		searchTable.getTableHeader().setReorderingAllowed(false); // ���̺� �� ���콺�� �̵� ���ϰ�
		searchTable.setAutoCreateRowSorter(true);
		// searchTable.setCellSelectionEnabled(rootPaneCheckingEnabled);
		searchTable.setRowHeight(50);
		searchTable.getSelectedRow();
		scrollPane.setViewportView(searchTable);

		// ��ȣ �ڵ�
		// ��ȸ�ϱ�
		JButton searchB = new JButton("\uC870\uD68C\uD558\uAE30");
		searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DtmStorage.setNumRows(0);
				for (int i = 0; i < pt.size(); i++) {
					// typeOccup2 = pt.get(i).; // pt.get(i)�� �ٹ����� ����
					bNo = Integer.toString(pt.get(i).getbNo());
					bName = pt.get(i).getbName(); // pt.get(i)�� ����� ����
					timeTotime2 = pt.get(i).getTimeTotime(); // pt.get(i)�� �ٹ��ð� ����
					pay = Double.toString(pt.get(i).getPay()); // pt.get(i)�� �ñ� ����
					region2 = pt.get(i).getAddr(); // pt.get(i)�� �ּ� ����
					timeType = pt.get(i).getTimeType(); // pt.get(i)�� ��ñ����� �ð� ����
					periodType2 = pt.get(i).getPeriodType(); // pt.get(i)�� �Ⱓ ����
					category = pt.get(i).getCategory();
					System.out.println(pt.get(i));

					pt2.add((Notice) pt.get(i));
					// { bNo, bName, pay, timeTotime2, category, periodType2, timeType, region2 });
					for (int j = 0; j < pt2.size(); j++) {
						DtmStorage.addRow(new String[] { (String) bNo, bName, pay, timeTotime2, category, periodType2,
								timeType, region2 });
						break;

					}
				}
			}
		});
		searchB.setFont(new Font("����������", Font.PLAIN, 15));
		searchB.setBounds(438, 496, 135, 37);
		imgPanel.add(searchB);

		// <<�ڷΰ��� ��ư
		JButton backButton = new JButton("");
		backButton.setIcon(new ImageIcon(ResumeDeleteView.class.getResource("/resourses/backButton.jpg")));
		backButton.setBackground(new Color(255, 215, 0));
		backButton.setFont(new Font("����������", Font.PLAIN, 14));
		backButton.setBorderPainted(false);
		backButton.setBounds(220, 496, 200, 50);
		imgPanel.add(backButton);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

//				imgPanel.setVisible(false);
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getPartMainView());
				revalidate();
				repaint();
				win.setVisible(false);
				win.setVisible(true);

				// ����ٰ� �ڷΰ��� ȭ�� ����
				// �����̲�

				// ������ ���� ȭ�� = PartMainView

				// PartMainView pmv = new PartMainView(panel);
				// PartMainView.setVisible(true);

			}
		});

		// ��ȣ �ڵ�
		// �׽�Ʈ ���
		// pt.add(new PartTime("KH ����������", "10000", "���� 3�ú���", "IT", "����", "1���� �̻�",
		// "3�ð� ~ 6�ð�"));
		// pt.add(new PartTime("�Ǿ���", "25000", "���� 9�ú���", "�������", "��õ", "3���� �̻�", "6�ð� ~
		// 8�ð�"));
		// pt.add(new PartTime("�н���", "50000", "���� 2�ú���", "����", "�泲", "������", "8�ð� �̻�"));
		// pt.add(new PartTime("�п�", "10000", "���� 10�ú���", "�繫", "�λ�", "�Ϸ�", "1�ð� ~
		// 3�ð�"));
		// pt.add(new PartTime("�������", "14000", "���� 6�ú���", "�ֹ�", "����", "1���� �̻�", "3�ð� ~
		// 6�ð�"));
		// pt.add(new PartTime("�����", " 8000", "���� 4�ú���", "����", "��õ", "������", "3�ð� ~
		// 6�ð�"));
		// pt.add(new PartTime("�븮����", "5000", "���� 3�ú���", "����", "��õ", "�Ϸ�", "8�ð� �̻�"));
		pt = dao.loadNoitce();

	}

	class ImagePanel extends JPanel {

		private Image img;

		public ImagePanel(Image img) {

			this.img = img;
			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setLayout(null);
			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));

		}

		public void paintComponent(Graphics g) {

			g.drawImage(img, 0, 0, null);
		}
	}

	public class Modal extends JDialog {

		// ù ��° �˾�â

		private Image img;

		public Modal(Window parent) {

			super(parent, "���� ���", ModalityType.APPLICATION_MODAL);
			setSize(400, 260);
			setLayout(null);
			setBounds(400, 300, 400, 260);

			ImagePanel imgPanel = new ImagePanel(new ImageIcon("./image/�˾�Ʋ1.jpg").getImage());

			imgPanel.setBounds(0, 0, 400, 260);
			getContentPane().add(imgPanel);
			add(imgPanel);
			imgPanel.setLayout(null);

			JLabel lb = new JLabel("���� �� ������ ����Ͻðڽ��ϱ�?");
			lb.setFont(new Font("����������", Font.PLAIN, 16));
			lb.setBounds(80, 60, 400, 50);

			// ������ ����Ͻðڽ��ϱ�? '��' ��ư

			// yesBtn.setIcon(new
			// ImageIcon(ResumeDelete.class.getResource("/resourses/\uB4A4\uB85C\uAC00\uAE302.jpg")));

			JButton yesBtn = new JButton("��");
			yesBtn.setBounds(100, 150, 60, 30);
			yesBtn.setIcon(new ImageIcon(ResumeDeleteView.class.getResource("/resourses/yesBtn.jpg")));
			yesBtn.setFont(new Font("����������", Font.PLAIN, 14));
			yesBtn.setBorderPainted(false);
			yesBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					yesBtn();

					// pt.add(new PartTime("KH ����������", "10000", "���� 3�ú���", "IT", "����", "1���� �̻�",
					// "3�ð� ~ 6�ð�"));
					// pt.add(new PartTime("�Ǿ���", "25000", "���� 9�ú���", "�������", "��õ", "3���� �̻�", "6�ð� ~
					// 8�ð�"));
					// pt.add(new PartTime("�н���", "50000", "���� 2�ú���", "����", "�泲", "������", "8�ð� �̻�"));
					// pt.add(new PartTime("�п�", "10000", "���� 10�ú���", "�繫", "�λ�", "�Ϸ�", "1�ð� ~
					// 3�ð�"));
					// pt.add(new PartTime("�������", "14000", "���� 6�ú���", "�ֹ�", "����", "1���� �̻�", "3�ð� ~
					// 6�ð�"));
					// pt.add(new PartTime("�����", " 8000", "���� 4�ú���", "����", "��õ", "������", "3�ð� ~
					// 6�ð�"));
					// pt.add(new PartTime("�븮����", "5000", "���� 3�ú���", "����", "��õ", "�Ϸ�", "8�ð� �̻�"));

					// +�迭���� �����ϴ� �ڵ� ����

					// pt.remove(1); //pt2.remove();
					// win.rd.setPt(pt); //����� �ڵ�

					dispose();
					Modal2 m2 = new Modal2(frame);
					m2.setVisible(true);

				}
			});

			// ������ ����Ͻðڽ��ϱ�? '�ƴϿ�'��ư - ����ȭ������ ���ư�

			JButton noBtn = new JButton("�ƴϿ�");
			noBtn.setBounds(225, 150, 73, 30);
			noBtn.setIcon(new ImageIcon(ResumeDeleteView.class.getResource("/resourses/noBtn.jpg")));
			noBtn.setFont(new Font("����������", Font.PLAIN, 14));
			// noBtn.setSelectedIcon(new
			// ImageIcon(ResumeDelete.class.getResource("/resourses/noBtn4.jpg")));
			noBtn.setBorderPainted(false);
			noBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					dispose();
				}
			});

			add(lb);
			add(noBtn);
			add(yesBtn);

		}

	}

	void yesBtn() {

		int row = searchTable.getSelectedRow();
		if (row == -1)
			return;

		DefaultTableModel model = (DefaultTableModel) searchTable.getModel();
		System.out.println(model.getValueAt(row, 0));
		model.removeRow(row);

		pt.remove(row);

		// ���� �ϳ��� ���� �� �� �ְ� �Ѵٸ�

		//
		//
		// save = dao.saveConnection();
		// pt = dao.loadPartimer();
		// for (int i = 0; i < pt.size(); i++) {
		// if (pt.get(i).getUserNo() == UserNo) {
		// pt.remove(i);
		// break;
		// }
		// }
		// dao.saveConnection(��¼��);
		// }
		//

		// for ( int i = 0 ; i<pt.size() ; i++ ) {
		//
		//
		//
		// }
		//

	}

	public class Modal2 extends JDialog {

		// �ι�° �˾�â

		public Modal2(Window parent) {

			super(parent, "���� ��� �Ϸ�", ModalityType.APPLICATION_MODAL);
			setSize(400, 260);
			setLayout(null);
			setBounds(400, 300, 400, 260);

			ImagePanel imgPanel = new ImagePanel(new ImageIcon("./image/�˾�Ʋ2.jpg").getImage());

			imgPanel.setBounds(0, 0, 400, 260);
			getContentPane().add(imgPanel);
			add(imgPanel);
			imgPanel.setLayout(null);

			JLabel lb = new JLabel("���� ��Ұ� �Ϸ�Ǿ����ϴ�.");
			lb.setFont(new Font("����������", Font.PLAIN, 16));
			lb.setBounds(95, 40, 400, 50);
			JLabel lb2 = new JLabel("���� ������� ���ư��ϴ�.");
			lb2.setFont(new Font("����������", Font.PLAIN, 16));
			lb2.setBounds(100, 70, 400, 50);

			// Ȯ�� ��ư
			// ���� �� ����׸� ������ ��� ������

			JButton okBtn = new JButton("Ȯ��");
			okBtn.setFont(new Font("����������", Font.PLAIN, 14));
			okBtn.setBounds(160, 150, 73, 30);
			okBtn.setIcon(new ImageIcon(ResumeDeleteView.class.getResource("/resourses/okBtn.jpg")));
			okBtn.setBorderPainted(false);
			okBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();

				}
			});

			add(lb);
			add(lb2);
			add(okBtn);

		}

	}
}

class ImagePanel extends JPanel {

	private Image img;

	public ImagePanel(Image img) {

		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));

	}

	public void paintComponent(Graphics g) {

		g.drawImage(img, 0, 0, null);
	}

}
