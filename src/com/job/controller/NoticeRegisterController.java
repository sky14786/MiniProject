package com.job.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.job.model.Notice;
import com.job.model.Owner;
import com.job.model.Partimer;

public class NoticeRegisterController {
	private String fileName = "notice.txt";
	private ArrayList<Notice> notices = new ArrayList<Notice>();

	public void addNotice(String bName, double pay, String timeTotime, String category, String bKeyword1,
			String bKeyword2, String bKeyword3, String etc, String periodType, String timeType) {
		loadData();
		notices.add(new Notice(notices.size(), bName, pay, timeTotime, category, bKeyword1, bKeyword2, bKeyword3, etc,
				periodType, timeType));
		save();
	}

	public void save() {
		File file = new File(fileName);
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(notices);
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
		ObjectInputStream ois = null;
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);

			notices = (ArrayList<Notice>) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
