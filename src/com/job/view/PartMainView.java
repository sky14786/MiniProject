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
		tfKeyword.setFont(new Font("����������", Font.PLAIN, 20));
		tfKeyword.setBounds(340, 256, 230, 70);
		add(tfKeyword);
		tfKeyword.setColumns(10);

		searchBtn = new JButton("\uAC80\uC0C9");
		searchBtn.setFont(new Font("����������", Font.PLAIN, 20));
		searchBtn.setBounds(570, 256, 70, 70);
		add(searchBtn);

		enrollBtn = new JButton("\uC774\uB825\uC11C \uB4F1\uB85D");
		enrollBtn.setFont(new Font("����������", Font.PLAIN, 15));
		enrollBtn.setBounds(245, 190, 110, 30);
		add(enrollBtn);

		modifyBtn = new JButton("\uC774\uB825\uC11C \uC218\uC815");
		modifyBtn.setFont(new Font("����������", Font.PLAIN, 15));
		modifyBtn.setBounds(365, 190, 110, 30);
		add(modifyBtn);

		deleteBtn = new JButton("\uC774\uB825\uC11C \uC0AD\uC81C");
		deleteBtn.setFont(new Font("����������", Font.PLAIN, 15));
		deleteBtn.setBounds(485, 190, 110, 30);
		add(deleteBtn);

		listBtn = new JButton("\uC9C0\uC6D0 \uBAA9\uB85D");
		listBtn.setFont(new Font("����������", Font.PLAIN, 15));
		listBtn.setBounds(605, 190, 110, 30);
		add(listBtn);

		logoutBtn = new JButton("\uB85C\uADF8\uC544\uC6C3");
		logoutBtn.setFont(new Font("����������", Font.PLAIN, 15));
		logoutBtn.setBounds(896, 12, 90, 30);
		add(logoutBtn);

		loginLabel = new JLabel("\uB2D8 \uC811\uC18D\uC911");
		loginLabel.setFont(new Font("���������� Bold", Font.PLAIN, 15));
		loginLabel.setBounds(822, 12, 60, 30);
		add(loginLabel);

		nowUserLabel = new JLabel("anonymous");
		nowUserLabel.setFont(new Font("���������� Bold", Font.PLAIN, 15));
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

	// ���� �������� ���� ����
	public void showId() {
		Partimer temp = null;
		if ((temp = checkingController.sendUserInformation()) != null) {
			System.out.println("-------------------------------------------");
			System.out.println("showId : " + temp.toString());
			System.out.println("-------------------------------------------");
			nowUserLabel.setText(temp.getId());
		} else {
			// System.out.println("���̵� �ҷ����� ����");
		}
	}

	// ���,����,������ư enable ����
	public void buttonTest() {
		check = checkingController.isApplyCheck();
		// System.out.println("��ư Ȱ��ȭ : " + check);
		if (check == 3) {
			enrollBtn.setEnabled(true);
			deleteBtn.setEnabled(false);
			modifyBtn.setEnabled(false);
		} else if (check == 2) {
			enrollBtn.setEnabled(false);
			deleteBtn.setEnabled(true);
			modifyBtn.setEnabled(true);
		} else {
			// System.out.println("��ư Ȱ��ȭ ����");
		}
	}

	// �˻���ư �׼�
	public void searchClick() {
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) // �����Ұ� : ȭ����ȯ, Ű���� �ѱ��
			{
				// Ű���� �ѱ�� �ӽ��׽�Ʈ
				String keyword = tfKeyword.getText();
				System.out.println("-------------------------------------------");
				System.out.println("�˻� Ű���� : " + keyword);
				System.out.println("-------------------------------------------");

				// ȭ����ȯ
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getJobSearchView()); // ���⼭ ��ȣ���� ȭ������ ��ȯ
				win.getContentPane().revalidate();
				win.getContentPane().repaint();
			}
		});
	}

	// �˻�â �׼� (enterŰ)
	public void searchEnter() {
		tfKeyword.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) // �����Ұ� : ȭ����ȯ, Ű���� �ѱ��
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// Ű���� �ѱ�� �ӽ��׽�Ʈ
					String keyword = tfKeyword.getText();
					System.out.println("-------------------------------------------");
					System.out.println("�˻� Ű���� : " + keyword);
					System.out.println("-------------------------------------------");

					// ȭ����ȯ
					win.getContentPane().removeAll();
					win.getContentPane().add(win.getJobSearchView()); // ���⼭ ��ȣ���� ȭ������ ��ȯ
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

	// �̷¼� ��� ��ư �׼�
	// ����ġ Ȯ��, �̷¼� ���â ����
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

	// �̷¼� ���� ��ư �׼�
	// ����ġ Ȯ��, ����� �̷¼� �ҷ��� ����
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

	// �̷¼� ���� ��ư �׼�
	// �̷¼� ��� ���� , ����ġ, �˾�
	public void deleteScene() {
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �˾� �˸�â
				JDialog notice = new JDialog(win, "�����˸�", false);
				notice.setBounds(300, 150, 400, 300);
				notice.getContentPane().setLayout(null);

				JLabel label = new JLabel("�����Ͻðڽ��ϱ�?");
				label.setFont(new Font("���������� Bold", Font.PLAIN, 20));
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(90, 70, 200, 20);
				notice.getContentPane().add(label);

				// ���� ���� ���� ��ư
				ansYes = new JButton("����");
				ansYes.setBounds(100, 150, 80, 50);
				ansYes.setFont(new Font("����������", Font.PLAIN, 15));
				ansYes.setVisible(true);
				notice.getContentPane().add(ansYes);
				ansYes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// �̷¼� ����
						resumeDeleteController.delResume();

						// ������ ��� ��ư Ȱ��ȭ
						buttonTest();

						// ���ȭ�� null�� ����
						win.getResumeEnrollView().clearTextField();
						notice.setVisible(false);
					}
				});

				// ���� ���� ��� ��ư
				ansNo = new JButton("���");
				ansNo.setBounds(200, 150, 80, 50);
				ansNo.setFont(new Font("����������", Font.PLAIN, 15));
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

	// ������� ��ư �׼�
	public void listScene() {
		listBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ������� ���� (�����ϲ��� ����)
				win.getContentPane().removeAll();
				win.setSize(1000, 600);
				win.getContentPane().add(win.getResumeDeleteView()); // ���⼭ ������ ȭ������ ��ȯ
				win.getContentPane().revalidate();
				win.getContentPane().repaint();
			}
		});
	}

	// �α׾ƿ� ��ư �׼�
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
