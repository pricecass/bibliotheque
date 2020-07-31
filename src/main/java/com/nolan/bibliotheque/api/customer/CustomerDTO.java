package com.nolan.bibliotheque.api.customer;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nolan.bibliotheque.api.loan.Loan;

public class CustomerDTO implements Comparable<CustomerDTO>{

	@JsonIgnore
	private Long customerID;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
	private String profession;
	
	@JsonIgnore
	private Set<Loan> loans = new HashSet<Loan>();
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	@Override
	public int compareTo(CustomerDTO o) {
		return this.firstName.compareToIgnoreCase(o.getFirstName());
	}
	
}
