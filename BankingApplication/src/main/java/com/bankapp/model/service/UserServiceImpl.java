package com.bankapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.UserDao;
import com.bankapp.model.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public User deleteUser(int uId) {
		
		return userDao.deleteUser(uId);
	}

	@Override
	public User getUserById(int uId) {
		
		return userDao.getUserById(uId);
	}

	@Override
	public User addUser(User user) {
		
		return userDao.addUser(user);
	}

	public boolean verifyDetails(String username, String password) {
		User user = userDao.getUser(username, password);
		if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
}

	@Override
	public User getUser(String username, String password) {
		return userDao.getUser(username, password);
	}
}
