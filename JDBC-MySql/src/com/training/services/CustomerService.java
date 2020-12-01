package com.training.services;

import java.sql.*;

import com.training.models.Invoice;
public class CustomerService {

	private Connection connection;

	public CustomerService(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean add(Invoice inv)
	{
		boolean res=false;
		PreparedStatement invStmt;
		PreparedStatement custStmt;
		Savepoint point1=null;
		Savepoint point2=null;
		try {
			
			String addInvSQL="insert into invoice values(?,?,?)";
			String addCustSQL="insert into customer values(?,?)";
			
			connection.setAutoCommit(false);
			
			invStmt=connection.prepareStatement(addInvSQL);
			
			invStmt.setInt(1, inv.getInvoiceNumber());
			invStmt.setString(2, inv.getCustomerName());
			invStmt.setDouble(3, inv.getAmount());
			
			custStmt=connection.prepareStatement(addCustSQL);
			custStmt.setString(1, inv.getCustomerName());
			custStmt.setDouble(2, inv.getAmount()*.95);
			
			
			
			
			int res2=custStmt.executeUpdate();
			point1=connection.setSavepoint("point1");
			
			int res1=invStmt.executeUpdate();
			point2=connection.setSavepoint("point2");
			connection.commit();
			if(res1==1 && res2==1)
			res=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			
			try {
				
				connection.rollback(point1);

				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
			e.printStackTrace();
		}
		return res;
	}
}
