package com.bankapp.web.formbeans;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserBean {
	
	private Integer uId;
	
	@NotEmpty(message = "username can not be left blank")
	private String username;
	
	@NotEmpty(message = "password can not be left blank")
	private String password;
	
	public UserBean() {	
	}
	public UserBean(Integer uId, String username, String password) {
		this.uId = uId;
		this.username = username;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

