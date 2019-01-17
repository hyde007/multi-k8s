package com.sb.hml.homeworklog.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.hml.homeworklog.controller.HomeWorkBook;
import com.sb.hml.homeworklog.controller.Student;


public interface HomeWorkRepository extends JpaRepository<HomeWorkBook, Integer> {

	List<HomeWorkBook> findByStudent(Student stud);
	
}
