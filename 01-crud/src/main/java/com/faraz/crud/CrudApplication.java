package com.faraz.crud;

import com.faraz.crud.dao.StudentDao;
import com.faraz.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);}

	@Bean
	public  CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
       createStudent(studentDao);
		};
	}

	private void createStudent(StudentDao studentDao) {
		//create student object
		System.out.println("Creating new student object...");
		Student student = new Student("Faraz Ahmed","Abir","farazabir@gmail.com");

		//save the student object
		System.out.println("Saving the student");
		studentDao.save(student);



		//display id of the saved student
		System.out.println("Saved student id: " + student.getId());
		System.out.println("Saved student id: " + student.getFirstName());
		System.out.println("Saved student id: " + student.getEmail());
	}

}
