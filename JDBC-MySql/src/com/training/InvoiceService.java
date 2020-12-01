package com.training;

import com.training.ifaces.DataAccess;
import com.training.models.Invoice;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class InvoiceService implements DataAccess<Invoice> {

	private Connection connection;
	
	

	public InvoiceService(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public boolean add(Invoice t) {
	
		String sql="insert into invoice values(?,?,?)";
		int rowAdded=0;
		try {
			PreparedStatement pre=connection.prepareStatement(sql);
			
			pre.setInt(1, t.getInvoiceNumber());
			pre.setString(2, t.getCustomerName());
			pre.setDouble(3, t.getAmount());
			
			rowAdded=pre.executeUpdate();//return How many rows which get affected
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowAdded==1?true:false;
	}

	@Override
	public List<Invoice> findAll() {
		// TODO Auto-generated method stub
		String sql="select * from invoice";
	List<Invoice> list=new ArrayList<Invoice>();
		try {
			PreparedStatement pre=connection.prepareStatement(sql);
			ResultSet result = pre.executeQuery();
			
			while(result.next()) {
				Invoice inv=new Invoice(result.getInt("invoiceNumber"),result.getString("customerName"),result.getDouble("amount"));
				list.add(inv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean remove(Invoice t) {
		// TODO Auto-generated method stub
		
		String sql="Delete from invoice where invoiceNumber=?";
		
		int rowDeleted=0;
		try {
			PreparedStatement pre=connection.prepareStatement(sql);
			
			pre.setInt(1, t.getInvoiceNumber());
			
			
			rowDeleted=pre.executeUpdate();//return How many rows which get affected
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowDeleted==1?true:false;
		
	}

	@Override
	public int update(int key, Invoice t) {
		// TODO Auto-generated method stub
		
String sql="UPDATE invoice SET invoiceNumber=?,, customerName=?, amount=? where invoiceNumber=?";
		
		int rowUpdated=0;
		try {
			PreparedStatement pre=connection.prepareStatement(sql);
			
			pre.setInt(1, t.getInvoiceNumber());
			pre.setString(2, t.getCustomerName());
			pre.setDouble(3, t.getAmount());
			pre.setInt(4, key);
			
			
			rowUpdated=pre.executeUpdate();//return How many rows which get affected
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowUpdated;
			}

	@Override
	public Invoice findById(int key) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		String sql="select * from invoice where invoiceNumber=?";
	Invoice list=null;
		try {
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setInt(1,key);
			ResultSet result = pre.executeQuery();
			
			if(result.next()) {
				list=new Invoice(result.getInt("invoiceNumber"),result.getString("customerName"),result.getDouble("amount"));
				
			}}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public void closeConnection() {
		
		try {
			this.connection.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	

	
}
