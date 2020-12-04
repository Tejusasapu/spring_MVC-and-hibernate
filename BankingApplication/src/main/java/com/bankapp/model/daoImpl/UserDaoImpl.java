package com.bankapp.model.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.dao.UserDao;
import com.bankapp.model.dao.exceptions.UserNotFoundException;
import com.bankapp.model.entities.User;

@Repository
public class UserDaoImpl  implements UserDao{
	
	private SessionFactory factory;
	
	@Autowired
	public UserDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();	
	}
	
	@Override
	public List<User> getAllUsers() {
		return getSession().createQuery("from User").list();
	}

	@Override
	public User updateUser(User user) {
		System.out.println("email= "+ user.getEmail());
		System.out.println("address = "+user.getAddress());
		System.out.println("phone= "+user.getPhone());
		System.out.println("id="+user.getuId());
		getSession().update(user);
		return user;
	}

	@Override
	public User deleteUser(int uId) {
		User delUser=getSession().find(User.class, uId);
		getSession().delete(delUser);
		return delUser;
	}

	@Override
	public User getUserById(int uId) {
		User user=getSession().find(User.class, uId);
		if(user==null) {
			throw new UserNotFoundException("User with id "+ uId + " not found!!!");
		}
		return user;
	}

	@Override
	public User addUser(User user) {
		getSession().persist(user);
		return user;
	}

	@Override
	public User getUser(String username,String password) {
		Query gettingUserQuery = getSession().createQuery("from User where username=:uname and password=:pwd");
		gettingUserQuery.setParameter("uname", username);
		gettingUserQuery.setParameter("pwd", password);
		User user = (User)  gettingUserQuery.getSingleResult();
		if(user==null) {
			throw new UserNotFoundException("User with id "+ username + " not found!!!");
		}
		return user;
	}
	}
