package com.sb.hml.homeworklog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.hml.homeworklog.exception.StudentNotFoundException;
import com.sb.hml.homeworklog.jpa.StudentRepository;
import com.sb.hml.homeworklog.proxy.Quote;
import com.sb.hml.homeworklog.proxy.QuoteServiceProxy;

@RestController
@RequestMapping("/hml")
public class StudentResource {
	
	@Autowired
	private StudentRepository studRepo;
	
	@Autowired
	private QuoteServiceProxy quoteService;
	
	@PostMapping("/student/add")
	public Student createStudent(@RequestBody Student stud) {
		Student newStud = studRepo.save(stud);
		return newStud;
	}

	
	@GetMapping("/student/find/{id}")
	public ResponseEntity<Object> fetchStudentById(@PathVariable int id){
		
		Optional<Student> foundStud = studRepo.findById(id);
		if(foundStud.isPresent()) {
			return new ResponseEntity<>(foundStud.get(), HttpStatus.OK);
		}else {
			throw new StudentNotFoundException("Student Id:"+id+" not found");	
		}
		
	}
	
	@GetMapping("/student/getQuote")
	public Quote getQuote() {
		return quoteService.getQuote();	
	}
}
