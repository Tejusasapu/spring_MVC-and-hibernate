package com.bankapp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uId;

	@NotEmpty(message = "username can not be left blank")
	@Column(unique = true, nullable = false)
	private String username;

	@NotEmpty(message = "password can not be left blank")
	private String password;

	@Column(name = "role")
	@CollectionTable(name = "roles")
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles = new ArrayList<>();

	@Column(nullable = false)
	@NotEmpty(message = "address can not be left blank")
	private String address;

	@Column(nullable = false)
	@NotEmpty(message = "phone can not be left blank")
	private String phone;

	@Column(nullable = false)
	@NotEmpty(message = "email can not be left blank")
	private String email;

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

	public User(String username, String password, List<String> roles, String address, String phone, String email) {
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public User(Integer uId, String username, String password, List<String> roles, String address, String phone,
			String email) {
		this.uId = uId;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", username=" + username + ", password=" + password + ", roles=" + roles
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}

}
