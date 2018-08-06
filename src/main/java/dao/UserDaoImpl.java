package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import entity.User1;
import models.User;
import models.User.Gender;

public class UserDaoImpl {

	@Autowired
	private UserDao dao;

	private User1 convertBeanToEntity(User user) {
		User1 u = new User1();
		u.setAge(user.getAge());
		u.setEmail(user.getEmail());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		if (user.getGender() == Gender.MALE) {
			u.setGender("MALE");
		} else {
			u.setGender("FEMALE");
		}
		u.setUserId(user.getUserId());

		return u;
	}

	private List<User> convertEntityToBean(List<User1> list) {
		List<User> temp = new ArrayList<>();
		for (User1 user1 : list) {
			User user = new User();
			user.setUserId(user1.getUserId());
			user.setAge(user1.getAge());
			user.setEmail(user1.getEmail());
			user.setFirstName(user1.getFirstName());
			user.setLastName(user1.getLastName());
			if (user1.getGender().equals("MALE")) {
				user.setGender(Gender.MALE);
			} else {
				user.setGender(Gender.FEMALE);
			}
			temp.add(user);
		}
		return temp;
	}

	public List<User> getAllUsers() {
		return convertEntityToBean(dao.findAll());
	}

	public User getUser(Integer userId) {

		// dao.findOne(example)
		Optional<User1> obj = dao.findById(userId);
		if (obj.isPresent()) {
			User user = new User();
			user.setAge(obj.get().getAge());
			user.setEmail(obj.get().getEmail());
			user.setFirstName(obj.get().getFirstName());
			user.setLastName(obj.get().getLastName());
			user.setUserId(obj.get().getUserId());
			if (obj.get().getGender().equalsIgnoreCase("MALE")) {
				user.setGender(Gender.MALE);
			} else {
				user.setGender(Gender.FEMALE);
			}
			return user;
		} else {
			return null;
		}

	}

	public int updateUser(User user) {
		Optional<User1> user2 = dao.findById(user.getUserId());

		if (user2.isPresent()) {
			User1 u = user2.get();
			u.setAge(user.getAge());
			u.setEmail(user.getEmail());
			u.setFirstName(user.getFirstName());
			u.setLastName(user.getLastName());
			if (user.getGender() == Gender.MALE) {
				u.setGender("MALE");
			} else {
				u.setGender("FEMALE");
			}
			u.setUserId(user.getUserId());
			dao.save(u);
		} else {
			return 0;
		}
		return 1;
	}

	public User removeUser(Integer userId) {
		Optional<User1> user2 = dao.findById(userId);
		if (user2.isPresent()) {
			dao.delete(user2.get());
		} else {
			return null;
		}
		return new User();
	}

	public int insertUser(User user) {

		User1 user1 = convertBeanToEntity(user);
		dao.save(user1);
		return 1;
	}
}
