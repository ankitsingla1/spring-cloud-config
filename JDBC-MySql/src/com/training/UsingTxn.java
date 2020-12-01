package com.training;

import java.sql.Connection;

import com.training.models.Invoice;
import com.training.services.CustomerService;
import com.training.utils.ConnectionUtils;

public class UsingTxn {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
Invoice inv=new Invoice(88,"Sushil Kumar Reddi",8999.00);

Connection connection=ConnectionUtils.getConnectionFromPool();
connection.getClass().getName();
CustomerService  custService=new CustomerService(connection);

custService.add(inv);
	}

}
