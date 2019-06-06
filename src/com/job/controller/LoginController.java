package com.job.controller;

import java.util.ArrayList;

import com.job.model.Owner;
import com.job.model.Partimer;
import com.job.model.dao.LoadSave;

public class LoginController {
	private ArrayList<Partimer> partimers = new ArrayList<Partimer>();
	private ArrayList<Owner> owners = new ArrayList<Owner>();
	private LoadSave dao = LoadSave.getDao();
	//로그인메소드
	public int login(String id, String pw, boolean loginType) {
		//DAO로부터 owner와 partimer .txt 로드
		owners = dao.loadOnwer();
		partimers = dao.loadPartimer();
		int errorType = 0;
		if (loginType) {
			for (int i = 0; i < owners.size(); i++) {
				if (owners.get(i).getId().equals(id)) {
					if (owners.get(i).getPw().equals(pw)) {
						errorType = 1;
						dao.setNowUser(owners.get(i).getNo());
						break;
					} else {
						errorType = 3;
						break;
					}

				} else {
					errorType = 2;
				}
			}
		} else {
			for (int i = 0; i < partimers.size(); i++) {
				if (partimers.get(i).getId().equals(id)) {
					if (partimers.get(i).getPw().equals(pw)) {
						dao.setNowUser(partimers.get(i).getNo());
						errorType = 4;
						break;
					} else {
						errorType = 3;
						break;
					}

				} else {
					errorType = 2;
				}
			}
		}

		return errorType;
	}

}
