package com.dxc.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dxc.model.Student;
import com.dxc.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentservice;
	

	 @GetMapping("/all")
	 public List<Student> getAllStudent(){
		return studentservice.getAllStudent();
	}
	 
	
	 @PostMapping("/add")
	 public Student addStudent(@RequestBody Student student) {
		 return studentservice.addStudent(student);
	 }
	 
	 @PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentservice.updateStudent(student);
		 
	 }

	 @GetMapping("/students/{id}")
	 public Student findStudentById(@PathVariable int id) { 
		 return studentservice.findStudentById(id);
	 }
	 
	 
	 @GetMapping("/delete/{id}")
	public List<Student> deleteStudent(@PathVariable int id) {
		studentservice.deleteStudent(id);
		return studentservice.getAllStudent();	
	}
	
}
