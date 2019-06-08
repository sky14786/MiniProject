package com.job.controller;

import java.sql.Connection;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.job.model.Notice;
import com.job.model.dao.LoadSave;
import com.job.view.ApplicationDeleteView;

public class ApplicationDeleteController {

	private ArrayList<Notice> pt = new ArrayList<Notice>();
	private ArrayList<Notice> pt2 = new ArrayList<Notice>();
	private ArrayList<Connection> connections = new ArrayList<Connection>();
	private ArrayList<Integer> resuems = new ArrayList<Integer>();
	private LoadSave dao = LoadSave.getDao();
	private DefaultTableModel DtmStorage = new DefaultTableModel();
	private int noticeNo;

    

	String bNo;
	String category; // pt.get(i)�� �ٹ����� ����
	String bName; // pt.get(i)�� ����� ����
	String timeTotime2; // pt.get(i)�� �ٹ��ð� ����
	String pay; // pt.get(i)�� �ñ� ����
	String region2; // pt.get(i)�� �ּ� ����
	String timeType; // pt.get(i)�� ��ñ����� �ð� ����
	String periodType2; // pt.get(i)�� �Ⱓ ����

	public DefaultTableModel loadApplicationList() {

		pt = dao.loadNoitce();

		DtmStorage.setNumRows(0);
		for (int i = 0; i < pt.size(); i++) {
			// typeOccup2 = pt.get(i).; // pt.get(i)�� �ٹ����� ����
			// bNo = Integer.toString(pt.get(i).getbNo());
			bName = pt.get(i).getbName(); // pt.get(i)�� ����� ����
			timeTotime2 = pt.get(i).getTimeTotime(); // pt.get(i)�� �ٹ��ð� ����
			pay = Double.toString(pt.get(i).getPay()); // pt.get(i)�� �ñ� ����
			region2 = pt.get(i).getAddr(); // pt.get(i)�� �ּ� ����
			timeType = pt.get(i).getTimeType(); // pt.get(i)�� ��ñ����� �ð� ����
			periodType2 = pt.get(i).getPeriodType(); // pt.get(i)�� �Ⱓ ����
			category = pt.get(i).getCategory();
			System.out.println(pt.get(i));

			DtmStorage.addRow(
					new String[] { (String) bName, pay, timeTotime2, category, periodType2, timeType, region2 });

		}
		return DtmStorage;

	}
	
	
	public void deleteApplicationList() {
		
		
		
		
		
		
		
	}
	
	
	

}

        