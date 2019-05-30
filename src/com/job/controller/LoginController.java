package com.job.controller;

import java.util.ArrayList;

import com.job.model.Owner;
import com.job.model.Partimer;
import com.job.model.dao.LoadSave;

public class LoginController {
	private ArrayList<Partimer> partimers = new ArrayList<Partimer>();
	private ArrayList<Owner> owners = new ArrayList<Owner>();
	private Owner nowOwner = new Owner();
	private Partimer nowPartimer = new Partimer();
	private LoadSave dao = LoadSave.getDao();

	public int login(String id, String pw, boolean loginType) {
		owners = dao.loadOnwer();
		partimers = dao.loadPartimer();
		int errorType = 0;
		if (loginType) {
			for (int i = 0; i < owners.size(); i++) {
				if (owners.get(i).getId().equals(id)) {
					if (owners.get(i).getPw().equals(pw)) {
						nowOwner = owners.get(i);
						errorType = 1;
						break;
					} else {
						errorType = 3;
					}

				} else {
					errorType = 2;
				}
			}
		} else {
			for (int i = 0; i < partimers.size(); i++) {
				if (partimers.get(i).getId().equals(id)) {
					if (partimers.get(i).getPw().equals(pw)) {
						nowPartimer = partimers.get(i);
						errorType = 4;
						break;
					} else {
						errorType = 3;
					}

				} else {
					errorType = 2;
				}
			}
		}
		return errorType;
	}

}
