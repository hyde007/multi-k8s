package com.sb.hml.homeworklog.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.hml.homeworklog.controller.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
