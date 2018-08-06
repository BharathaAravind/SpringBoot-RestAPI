package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.User;

@Repository
public interface UserDao extends JpaRepository<entity.User1, Integer> {

	public abstract List<User> getAllUsers();

	public abstract User getUser(Integer userId);

	public abstract int updateUser(User user);

	public abstract User removeUser(Integer userId);

	public abstract int insertUser(User user);

}
