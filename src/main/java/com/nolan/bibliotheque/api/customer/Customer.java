package com.nolan.bibliotheque.api.customer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nolan.bibliotheque.api.loan.Loan;

@Entity
@Table(name = "CUSTOMERS")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerID;	
	private String firstName;
	private String lastName;
	private String adress;
	private String phone;
	private String email;
	private String profession;
	
	@OneToMany(mappedBy = "loanBookCustomer.customer", 
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL)
	private Set<Loan> loans = new HashSet<Loan>();
	
	public Customer() {}

	public Customer(Long customerID, String firstName, String lastName, String adress, 
			String phone, String email, String profession) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.profession = profession;
	}

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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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
	
}
