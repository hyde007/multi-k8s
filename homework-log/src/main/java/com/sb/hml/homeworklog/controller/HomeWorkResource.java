package com.sb.hml.homeworklog.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sb.hml.homeworklog.exception.HomeWorkNotFoundException;
import com.sb.hml.homeworklog.exception.StudentNotFoundException;
import com.sb.hml.homeworklog.jpa.HomeWorkRepository;
import com.sb.hml.homeworklog.jpa.StudentRepository;

@RestController
@RequestMapping("/hml")
public class HomeWorkResource{
	
	@Autowired
	private HomeWorkRepository hwRepo;
	
	@Autowired
	private StudentRepository studRepo;
	
	@PostMapping("/user/{id}/hw/add")
	public ResponseEntity<Object> addNewHomeWork(@RequestBody HomeWorkBook hwb,@PathVariable int id) {
		
		Optional<Student> existingStud = studRepo.findById(id);
		
		if(existingStud.isPresent()) {
			
			hwb.setStudent(existingStud.get());
			HomeWorkBook savedHwb = hwRepo.save(hwb);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		}else {
			throw new StudentNotFoundException("Student Id:"+id+" not found");
		}
		
	}
	
	@GetMapping("/user/{id}/hw/fetch/all")
	public Resources<HomeWorkBook> fetchAllHwsForUser(@PathVariable int id){
		
		Optional<Student> existingUser = studRepo.findById(id);
		
		if(existingUser.isPresent()) {
			
			List<HomeWorkBook> allHws = hwRepo.findByStudent(existingUser.get());
			
			if(allHws.isEmpty()) {
				throw new HomeWorkNotFoundException("No home works found for student id:"+id);
			}else {
				
				Link link = linkTo(methodOn(StudentResource.class).fetchStudentById(id)).withSelfRel();
				Resources<HomeWorkBook> allRes = new Resources<>(allHws, link);
				return allRes;
			}
			
		}else {
			throw new StudentNotFoundException("Student Id:"+id+" not found");
		}
		
	}
	
	
}