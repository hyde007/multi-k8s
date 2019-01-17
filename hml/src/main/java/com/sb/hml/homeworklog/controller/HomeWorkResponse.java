package com.sb.hml.homeworklog.controller;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class HomeWorkResponse extends ResourceSupport{

	private int hwId;
	
	private String title;
	
	private String description;
	
	private String work;

	public int getHwId() {
		return hwId;
	}

	public void setHwId(int hwId) {
		this.hwId = hwId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public HomeWorkResponse(int hwId, String title, String description, String work) {
		super();
		this.hwId = hwId;
		this.title = title;
		this.description = description;
		this.work = work;
	}
	
	public HomeWorkResponse() {}
	
}
