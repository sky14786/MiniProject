package com.job.view;

import java.util.ArrayList;
import java.util.List;

import com.job.model.Notice;
import com.job.model.dao.LoadSave;
public class DummyData {
	
	private LoadSave dao = LoadSave.getDao();
    public static List<Notice> notice = new ArrayList<Notice>();
    public DummyData() {
    	notice = dao.loadNoitce();
    }

	public void mainMenu()
	{
		
//		pt.add(new Notice(1234,"KH 정보교육원", 10000, "1시간 ~ 3시간", "IT", "인천", "1개월 이상", "오전 1시부터", "키워드 하나", "키워드 둘", "키워드 셋", "학원 입니다."));
//		pt.add(new Notice(5678,"피씨방", 25000, "6시간 ~ 8시간", "매장관리", "서울", "3개월 이상", "오후 3시부터", "키워드 하나", "키워드 둘", "키워드 셋", "피씨방 입니다"));
//		pt.add(new Notice(1534,"분식집", 50000, "8시간 이상", "영업", "충남", "일주일", "오후 2시부터", "키워드 하나", "키워드 둘", "키워드 셋", "분식집 입니다."));
//		pt.add(new Notice(1532,"학원", 12000, "3시간 ~ 6시간", "사무", "부산", "하루", "오전 10시부터", "키워드 하나", "키워드 둘", "키워드 셋", "학원 입니다."));
//		pt.add(new Notice(75686,"레스토랑", 140000, "3시간 ~ 6시간", "주방", "서울", "1개월 이상", "오후 6시부터", "키워드 하나", "키워드 둘", "키워드 셋", "레스토랑 입니다."));
//		pt.add(new Notice(9999,"정비소", 80000, "8시간 이상", "운전", "인천", "일주일", "오후 4시부터", "키워드 하나", "키워드 둘", "키워드 셋", "정비소 입니다."));
//		pt.add(new Notice(1736,"대리운전", 50000, "6시간 ~ 8시간", "운전", "서울", "하루", "오후 11시부터", "키워드 하나", "키워드 둘", "키워드 셋", "대리 운전 입니다."));		
	}

}
