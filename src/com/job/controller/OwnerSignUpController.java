package com.job.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.job.model.Owner;

public class OwnerSignUpController {

	private String fileName = "onwer.txt";
	private ArrayList<Owner> owners = new ArrayList<Owner>();

	public void addOwner(String id, String pw, String name, String bNumber, String addr) {
		owners.add(new Owner(owners.size(), id, pw, name, bNumber, addr));
		save();
	}

	public boolean duplicateCheck(String id) {
		boolean checkType = true;

		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getId().equals(id)) {
				checkType = false;
				break;
			}
		}
		return checkType;
	}

	public void save() {
		File file = new File(fileName);
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(owners);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
