package com.job.controller;

import java.util.ArrayList;

import com.job.model.Resume;
import com.job.run.Run;
import com.job.view.SearchView;

public class SearchController {

	public String region2;
	public String typeOccup2;
	public String periodType2;
	public String re;
	public String oc;
	public String pe;
	private String inputvar2;

	public ArrayList<Resume> rs2 = new ArrayList<Resume>();
	public ArrayList<Resume> rs3 = new ArrayList<Resume>();
	public ArrayList<Resume> rs5 = new ArrayList<Resume>();
	SearchView ss = null;

	// SearchView

	public void Search(Run win, String region, String typeOccup, String periodType) {

		rs2.clear();

		ss = win.getSearchView();
		for (int i = 0; i < ss.rs.size(); i++) {

			region2 = ss.rs.get(i).getRegion();
			typeOccup2 = ss.rs.get(i).getTypeOccup();
			periodType2 = ss.rs.get(i).getPeriodType();
			re = "[�ٹ�����]";
			oc = "[�ٹ�����]";
			pe = "[�ٹ��Ⱓ]";

			// �ƹ��͵� �ȴ�������
			if (region.equals(re) && typeOccup.equals(oc) && periodType.equals(pe)) {

				System.out.println("�ٽ� �Է��Ͻÿ�");

			}

			// ���� , ����
			if (region.equals(region2) && typeOccup.equals(typeOccup2) && periodType.equals(pe)) {
				System.out.println(ss.rs.get(i).toString());

				rs2.add((Resume) ss.rs.get(i));

			}
			// ���� , �Ⱓ
			if (region.equals(region2) && typeOccup.equals(oc) && periodType.equals(periodType2)) {

				System.out.println(ss.rs.get(i).toString());

				rs2.add((Resume) ss.rs.get(i));

			}

			// ���� , �Ⱓ
			if (region.equals(re) && typeOccup.equals(typeOccup2) && periodType.equals(periodType2)) {
				System.out.println(ss.rs.get(i));

				rs2.add((Resume) ss.rs.get(i));

			}
			// ����
			if (region.equals(region2) && typeOccup.equals(oc) && periodType.equals(pe)) {
				System.out.println(ss.rs.get(i));

				rs2.add((Resume) ss.rs.get(i));

			}
			// ����
			if (region.equals(re) && typeOccup.equals(typeOccup2) && periodType.equals(pe)) {
				System.out.println(ss.rs.get(i));

				rs2.add((Resume) ss.rs.get(i));

			}
			// �Ⱓ
			if (region.equals(re) && typeOccup.equals(oc) && periodType.equals(periodType2)) {
				System.out.println(ss.rs.get(i));

				rs2.add((Resume) ss.rs.get(i));

			}
		}
		System.out.println();

	}

	public Resume resumeset(Run win, int userNo, String inputvar) {

		Resume resume = new Resume();
		ss = win.getSearchView();

		for (int i = 0; i < ss.rs.size(); i++) {

			if (ss.rs.get(i).getUserNo() == Integer.parseInt(ss.inputvar)) {

				resume = ss.rs.get(i);
			}
		}

		System.out.println(resume.toString());
		return resume;
	}
}
