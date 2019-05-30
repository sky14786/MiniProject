package com.job.controller;

import java.util.ArrayList;

import com.job.model.Partimer;
import com.job.model.dao.LoadSave;

public class PartimerSignUpController {
	private String fileName = "partimer.txt";
	private ArrayList<Partimer> partimers = new ArrayList<Partimer>();
	private LoadSave dao = LoadSave.getDao();

	public void addPartimer(String id, String pw, String name, int age, String gender, String phone) {
		partimers = dao.loadPartimer();
		partimers.add(new Partimer(partimers.size(), id, pw, name, age, gender, phone, false));
		dao.savePartimer(partimers);
	}

	public boolean duplicateCheck(String id) {
		boolean checkType = true;
		partimers = dao.loadPartimer();
		for (int i = 0; i < partimers.size(); i++) {
			if (partimers.get(i).getId().equals(id)) {
				checkType = false;
				break;
			}
		}
		return checkType;
	}

}
