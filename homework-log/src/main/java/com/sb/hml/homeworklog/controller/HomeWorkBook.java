package com.sb.hml.homeworklog.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@JsonFilter("HWFilter")
public class HomeWorkBook {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	
	private String description;
	
	private String work;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HomeWorkBook(int id, String title, String description, String work) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.work = work;
	}

	public HomeWorkBook() {}

	@Override
	public String toString() {
		return "HomeWorkBook [id=" + id + ", title=" + title + ", description=" + description + ", work=" + work + "]";
	}

	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
