package service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import models.User;

@Service
public class UserService {

	private UserDao userDao;

	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUser(UUID userId) {
		return userDao.getUser(userId);
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	public User removeUser(UUID userId) {
		return userDao.removeUser(userId);
	}

	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

}
