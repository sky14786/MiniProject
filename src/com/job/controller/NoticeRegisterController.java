package com.job.controller;

import java.util.ArrayList;

import com.job.model.Notice;
import com.job.model.Owner;
import com.job.model.dao.LoadSave;

public class NoticeRegisterController {
	private ArrayList<Notice> notices = new ArrayList<Notice>();
	private ArrayList<Owner> owners = new ArrayList<Owner>();
	private int userNo = 0;
	private LoadSave dao = LoadSave.getDao();

	public NoticeRegisterController() {
	}

	public void addNotice(String bName, double pay, String timeTotime, String category, String addr, String periodType,
			String timeType, String bKeyword1, String bKeyword2, String bKeyword3, String etc) {
		notices = dao.loadNoitce();
		owners = dao.loadOnwer();
		notices.add(new Notice(userNo, bName, pay, timeTotime, category, addr, periodType, timeType, bKeyword1,
				bKeyword2, bKeyword3, etc));
		dao.saveNotice(notices);
		ownerApplyUpdate();
		dao.saveOwner(owners);

	}

	public NoticeRegisterController(int userNo, ArrayList<Owner> owners) {
		this.userNo = userNo;
		this.owners = owners;
	}

	public boolean isApplyCheck() {
		owners = dao.loadOnwer();
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getNo() == userNo) {
				if (!owners.get(i).isApply()) {
					System.out.println(owners.get(i).toString());
					return true;
				}
			}
		}
		return false;
	}

	public void ownerApplyUpdate() {
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getNo() == userNo) {
				owners.get(i).setApply(true);
				break;
			}
		}
	}
}
