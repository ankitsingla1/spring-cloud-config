package com.demo;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Student s=new Student(5,"Uttam Kumar", 58000.0);
		Connection con=Connectivity.getConnectivity();
		StudentService serv=new StudentService(con);
		//System.out.println(serv.addStudent(s));
ArrayList<Student> list=serv.findAllStudent();
for(Student student:list)
{
	System.out.println(student);}

	}

}
