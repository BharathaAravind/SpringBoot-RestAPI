package dao;

import java.util.List;
import java.util.UUID;

import models.User;

public interface UserDao {

	public abstract List<User> getAllUsers();

	public abstract User getUser(UUID userId);

	public abstract int updateUser(User user);

	public abstract User removeUser(UUID userId);

	public abstract int insertUser(User user);

}
