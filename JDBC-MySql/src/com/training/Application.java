package com.training;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.training.models.Invoice;
import com.training.utils.ConnectionUtils;


public class Application {

	public static void main(String[] args) {
/*		// TODO Auto-generated method stub
Invoice inv1=new Invoice(1211,"Sit aKIT",5644);

Invoice inv2=new Invoice(1411,"Heyyyy",5009);

Invoice inv31=new Invoice(12211,"Srivatsan",5689);

Invoice inv4=new Invoice(14111,"Srivatsan",5689);

System.out.println("IS EQUAL===="+inv31.equals(inv4));



Connection connection =ConnectionUtils.getMyConnection();
InvoiceService service=new InvoiceService(connection);
System.out.println(service.add(inv1));

System.out.println(service.add(inv2));

//System.out.println(service.add(inv31));
*/
		Invoice inv1=new Invoice(11,"Singla",5644);
		
		Connection connection =ConnectionUtils.getMyConnection();
		InvoiceService service=new InvoiceService(connection);
		service.add(inv1);
		service.closeConnection();
List<Invoice> list=service.findAll();

Iterator<Invoice> itr=list.iterator();

while(itr.hasNext()) {
  Invoice inv=itr.next();
  System.out.println(inv);
	}

Invoice inv=service.findById(1411);
System.out.println("---------------");
System.out.println(inv);
System.out.println("*************************************");
boolean res=service.remove(inv1);
System.out.println(res);
/*List<String> names=Arrays.asList("rahul","anki","tanya");
Collections.sort(names,Collections.reverseOrder());
System.out.println(names);
*/
}}
