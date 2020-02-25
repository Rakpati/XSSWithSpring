package com.javadeveloperzone.controller;

import java.util.List;

public interface StudentService {

	StudentForm findById(long id);
    
	StudentForm findByName(String student);
     
    void saveStudent(StudentForm student);
     
    void updateStudent(StudentForm student);
     
    void deleteStudentById(long id);
 
    List<StudentForm> findAllUsers();
     
    void deleteAllStudents();
     
    boolean isUserExist(StudentForm student);
}
