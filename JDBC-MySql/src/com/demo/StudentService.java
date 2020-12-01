package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentService {
	
	private Connection connection;

	public StudentService(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean addStudent(Student s)
	{int res=0;
		String sql="insert into student values(?,?,?)";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setInt(2, s.getRollNumber());
	ps.setDouble(3, s.getFees());
	 res=ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res>0?true:false;
	}
	public ArrayList<Student> findAllStudent(){
		
		ArrayList<Student> list=new ArrayList<Student>();
		String sql="select * from student";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ResultSet res=ps.executeQuery();
			
			while(res.next()) {
				String name=res.getString("name");
				int rollNo=res.getInt("rollNumber");
				double fees=res.getDouble("fees");
				list.add(new Student(rollNo, name, fees));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	

}
