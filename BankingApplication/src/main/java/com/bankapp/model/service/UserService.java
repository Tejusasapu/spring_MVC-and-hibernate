package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.User;

public interface UserService {

	public List<User> getAllUsers();
	public User updateUser(User user);
	public User deleteUser(int uId);
	public User getUserById(int uId);
	public User addUser(User user);
	public User getUser(String username,String password);
	public boolean verifyDetails(String username, String password);
}
