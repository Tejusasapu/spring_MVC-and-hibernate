package com.bankapp.web.formbeans;

import javax.validation.constraints.NotNull;

import com.bankapp.model.entities.AccountType;

public class AddAccountBean {

	private Integer accountId;
	
	@NotNull(message = "name can not be left blank")
	private String name;
	
	@NotNull(message = "address can not be left blank")
	private String address;
	
	@NotNull(message = "phone can not be left blank")
	private String phone;
	
	@NotNull(message = "email can not be left blank")
	private String email;
	
	@NotNull(message = "pannumber can not be left blank")
	private String panNumber;
	
	
	@NotNull(message = "AadharNumber can not be left blank")
	private String AadharNumber;
	
	
	private AccountType accountType;
	public AddAccountBean() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAadharNumber() {
		return AadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		AadharNumber = aadharNumber;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

}
