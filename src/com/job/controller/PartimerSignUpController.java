package com.job.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.job.model.Partimer;

public class PartimerSignUpController {
	private String fileName = "partimer.txt";
	private ArrayList<Partimer> partimers = new ArrayList<Partimer>();

	public void addPartimer(String id, String pw, String name, int age, String gender, String phone) {
		loadData();
		partimers.add(new Partimer(partimers.size(), id, pw, name, age, gender, phone));
		save();
	}

	public boolean duplicateCheck(String id) {
		boolean checkType = true;

		for (int i = 0; i < partimers.size(); i++) {
			if (partimers.get(i).getId().equals(id)) {
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
			oos.writeObject(partimers);
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

	public void loadData() {
		ObjectInputStream partimerOIS = null;
		try {
			File partimerFile = new File(fileName);
			FileInputStream partimerFIS = new FileInputStream(partimerFile);
			partimerOIS = new ObjectInputStream(partimerFIS);

			partimers = (ArrayList<Partimer>) partimerOIS.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				partimerOIS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
