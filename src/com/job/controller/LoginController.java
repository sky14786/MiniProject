package com.job.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.job.model.Owner;
import com.job.model.Partimer;

public class LoginController {
	private ArrayList<Partimer> partimers = new ArrayList<Partimer>();
	private ArrayList<Owner> owners = new ArrayList<Owner>();
	private String ownerFileName = "owner.txt";
	private String partimerFileName = "partimer.txt";
	private Owner nowOwner = new Owner();
	private Partimer nowPartimer = new Partimer();

	public int login(String id, String pw, boolean loginType) {
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
						errorType = 1;
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

	public void saveData() {
		ObjectOutputStream partimerOOS = null, ownerOOS = null;
		try {
			File partimerFile = new File(partimerFileName);
			FileOutputStream partimerFOS = new FileOutputStream(partimerFile);
			partimerOOS = new ObjectOutputStream(partimerFOS);

			File ownerFile = new File(ownerFileName);
			FileOutputStream ownerFOS = new FileOutputStream(ownerFile);
			ownerOOS = new ObjectOutputStream(ownerFOS);

			partimerOOS.writeObject(partimers);
			ownerOOS.writeObject(owners);

			partimerOOS.flush();
			ownerOOS.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				partimerOOS.close();
				ownerOOS.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void loadData() {
		ObjectInputStream partimerOIS = null, ownerOIS = null;
		try {
			File partimerFile = new File(partimerFileName);
			FileInputStream partimerFIS = new FileInputStream(partimerFile);
			partimerOIS = new ObjectInputStream(partimerFIS);

			File ownerFile = new File(ownerFileName);
			FileInputStream ownerFIS = new FileInputStream(ownerFile);
			ownerOIS = new ObjectInputStream(ownerFIS);

			partimers = (ArrayList<Partimer>) partimerOIS.readObject();
			owners = (ArrayList<Owner>) ownerOIS.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				partimerOIS.close();
				ownerOIS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
