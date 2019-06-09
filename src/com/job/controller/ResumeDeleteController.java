package com.job.controller;

import java.util.ArrayList;

import com.job.model.Partimer;
import com.job.model.Resume;
import com.job.model.dao.LoadSave;

public class ResumeDeleteController {

	private ArrayList<Resume> resumes = new ArrayList<Resume>();
	private ArrayList<Partimer> parttimers = new ArrayList<Partimer>();
	private int userNo = 0;
	private LoadSave dao = LoadSave.getDao();
	
	public ResumeDeleteController() {}
	
	//이력서 삭제하기
	public void delResume() {
		userNo = dao.getNowUser();
		resumes = dao.loadResume();
		parttimers = dao.loadPartimer();
		for (int i = 0; i < resumes.size(); i++) {
			if (resumes.get(i).getUserNo() == userNo) {
				resumes.remove(i);
				break;
			}
		}
		dao.saveResume(resumes);
		parttimerApplyUpdate();
		dao.savePartimer(parttimers);
	}
	
	//알바생 isApply 세팅
	public void parttimerApplyUpdate() {
		userNo = dao.getNowUser();
		for (int i = 0; i < parttimers.size(); i++) {
			if (parttimers.get(i).getNo() == userNo) {
				parttimers.get(i).setApply(false);
				break;
			}
		}
	}
	
	
	
}
