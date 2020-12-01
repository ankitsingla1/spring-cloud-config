package com.training.models;



public class Invoice  implements Comparable<Invoice>{
	


	private int invoiceNumber;
	private String customerName;
	private transient double amount;
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice(int invoiceNumber, String customerName, double amount) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.customerName = customerName;
		this.amount = amount;
	}
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.customerName+","+this.amount+","+this.invoiceNumber;
	}
	@Override
	public int compareTo(Invoice inv) {
		
		return this.customerName.compareTo(inv.customerName);
		
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + invoiceNumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (invoiceNumber != other.invoiceNumber)
			return false;
		return true;
	}
	
	
}
