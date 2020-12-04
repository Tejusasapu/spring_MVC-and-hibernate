package com.bankapp.web.formbeans;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AddUserBean {
	private Integer uId;
	@NotEmpty(message = "username can not be left blank")
	private String username;
	
	@NotEmpty(message = "password can not be left blank")
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@NotEmpty(message = "roles can not be left blank")
	private List<String> roles = new ArrayList<>();
	
	@NotEmpty(message = "address can not be left blank")
	private String address;
	
	@NotEmpty(message = "phone can not be left blank")
	private String phone;
	
	
	private String email;
	public AddUserBean() {
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
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
	@Override
	public String toString() {
		return "AddUserBean [uId=" + uId + ", username=" + username + ", password=" + password + ", roles=" + roles
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}
	
}
