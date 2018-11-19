package com.dtech.web.template.spring.autowire;

public class ClassRoom {

	Student studentA;
	
	Student studentB;

	public void setStudentA(Student studentA) {
		this.studentA = studentA;
	}
	public void setStudentB(Student studentB) {
		this.studentB = studentB;
	}
	public Student getStudentA() {
		return studentA;
	}
	public Student getStudentB() {
		return studentB;
	}
}
