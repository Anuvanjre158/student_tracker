package com.dxc.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dxc.model.Student;
import com.dxc.repository.StudentRepository;

@Service
public class StudentService {


	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
		
	}
	
	public void deleteStudent(int id) {
		
		studentRepository.deleteById(id);
	}
	
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
	}
	
	 public Student findStudentById(int id) { 
		  Optional<Student> student = studentRepository.findById(id);
		  return student.get();   
	 }
	 
	 public Student updateStudent(Student student) {
		  
		  Optional<Student> update =studentRepository.findById(student.getId());
			Student s = update.get();
			s.setEmail(student.getEmail());
			return studentRepository.save(student);
			
	  }
}
