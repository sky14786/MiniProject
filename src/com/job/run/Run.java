package com.job.run;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.job.view.LoginView;
import com.job.view.NoticeRegisterView;
import com.job.view.NoticeUpdateView;
import com.job.view.OwnerSignUpView;
import com.job.view.PartimerSignUpView;
import com.job.view.SignUpCategory;

public class Run extends JFrame {

	public LoginView loginView = null;
	public SignUpCategory signUpCategory = null;
	public PartimerSignUpView partimerSignView = null;
	public OwnerSignUpView ownerSignUpView = null;
	public NoticeRegisterView noticeRegisterView = null;
	public NoticeUpdateView noticeUpdateView = null;

	public static void main(String[] args) {

		Run win = new Run();
		win.setTitle("æÀπŸ¿« πŒ¡∑");
		win.loginView = new LoginView(win);
		win.signUpCategory = new SignUpCategory(win);
		win.partimerSignView = new PartimerSignUpView(win);
		win.ownerSignUpView = new OwnerSignUpView(win);
		win.noticeRegisterView = new NoticeRegisterView(win);
		win.noticeUpdateView = new NoticeUpdateView(win);

		win.add(win.loginView);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(590, 590);
//		win.setSize(1000, 600);
		win.setResizable(false);
		ImageIcon img = new ImageIcon(win.getClass().getResource("/resource/MainLogo.png"));
		win.setIconImage(img.getImage());
		win.setVisible(true);

	}

}
