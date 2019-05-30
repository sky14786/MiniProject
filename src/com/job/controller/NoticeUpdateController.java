package com.job.controller;


import java.util.ArrayList;

import com.job.model.Notice;
import com.job.model.dao.LoadSave;

public class NoticeUpdateController {
	private int userNo = 0;
	private ArrayList<Notice> notices = new ArrayList<Notice>();
	private String fileName = "notice.txt";
	private LoadSave dao = LoadSave.getDao();

	public void updateNotice(String bName, double pay, String timeTotime, String category, String addr,
			String periodType, String timeType, String bKeyword1, String bKeyword2, String bKeyword3, String etc) {

		for (int i = 0; i < notices.size(); i++) {
			if (notices.get(i).getbNo() == userNo) {
				notices.set(i, new Notice(userNo, bName, pay, timeTotime, category, addr, periodType, timeType,
						bKeyword1, bKeyword2, bKeyword3, etc));
				dao.saveNotice(notices);
				break;
			}
		}
	}

	public Notice sendUserInformation() {
		notices = dao.loadNoitce();
		Notice temp = null;
		for (int i = 0; i < notices.size(); i++) {
			if (notices.get(i).getbNo() == userNo) {
				temp = notices.get(i);
				break;
			}
		}
		return temp;
	}
}
