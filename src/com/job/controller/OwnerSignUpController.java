package com.job.controller;

import java.util.ArrayList;

import com.job.model.Owner;
import com.job.model.dao.LoadSave;

public class OwnerSignUpController {

	private ArrayList<Owner> owners = new ArrayList<Owner>();
	private LoadSave dao = LoadSave.getDao();

	public void addOwner(String id, String pw, String name, String bNumber, String addr) {
		owners = dao.loadOnwer();
		owners.add(new Owner(owners.size(), id, pw, name, bNumber, addr, false));
		dao.saveOwner(owners);
	}

	public boolean duplicateCheck(String id) {
		boolean checkType = true;
		owners = dao.loadOnwer();
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getId().equals(id)) {
				checkType = false;
				break;
			}
		}
		return checkType;
	}
}
