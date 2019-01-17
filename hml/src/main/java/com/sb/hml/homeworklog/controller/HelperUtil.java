package com.sb.hml.homeworklog.controller;

import java.util.ArrayList;
import java.util.List;

public class HelperUtil {
	
	public static List<HomeWorkResponse> transferToBean(List<HomeWorkBook> allHw){
		
		List<HomeWorkResponse> allHwResp = new ArrayList<HomeWorkResponse>();
		for(int i=0;i<allHw.size();i++) {
			HomeWorkResponse hwResp = new HomeWorkResponse();
			hwResp.setHwId(allHw.get(i).getId());
			hwResp.setDescription(allHw.get(i).getDescription());
			hwResp.setTitle(allHw.get(i).getTitle());
			hwResp.setWork(allHw.get(i).getWork());
			allHwResp.add(hwResp);
		}
		return allHwResp;
	}

}
