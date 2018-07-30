package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import models.User;
import models.User.Gender;

@Repository
public class FakeDataDao implements UserDao {

	private static Map<UUID, User> database;

	public FakeDataDao() {
		database = new HashMap<>();
		UUID uuid = UUID.randomUUID();
		database.put(uuid, new User(uuid, "Aravind", "Bharatha", Gender.MALE, 24, "abharath@iu.edu"));
		uuid = UUID.randomUUID();
		database.put(uuid, new User(uuid, "John", "sin", Gender.MALE, 30, "johnsin@iu.edu"));
		uuid = UUID.randomUUID();
		database.put(uuid, new User(uuid, "Anusha", "kareti", Gender.FEMALE, 26, "anushaK@iu.edu"));
		uuid = UUID.randomUUID();
		database.put(uuid, new User(uuid, "Rahul", "Pochamp", Gender.MALE, 24, "rpochamp@iu.edu"));
		uuid = UUID.randomUUID();
		database.put(uuid, new User(uuid, "Haritha", "Damarla", Gender.FEMALE, 25, "hadama@iu.edu"));
		uuid = UUID.randomUUID();
		database.put(uuid, new User(uuid, "Meghesh", "patil", Gender.MALE, 27, "megpatil@iu.edu"));
		uuid = UUID.randomUUID();
		database.put(uuid, new User(uuid, "Sagar", "Pant", Gender.MALE, 27, "spant@iu.edu"));
		uuid = UUID.randomUUID();
		database.put(uuid, new User(uuid, "Ramya", "P", Gender.FEMALE, 25, "ramya@iu.edu"));
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return new ArrayList<>(database.values());
	}

	@Override
	public User getUser(UUID userId) {
		// TODO Auto-generated method stub
		return database.get(userId);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		database.put(user.getUserId(), user);
		return 1;
	}

	@Override
	public User removeUser(UUID userId) {
		// TODO Auto-generated method stub
		return database.remove(userId);
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		user.setUserId(uuid);
		database.put(uuid, user);
		return 1;
	}

}
