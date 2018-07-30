package com.abharatha.LearningSpringBoot;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import dao.FakeDataDao;
import dao.UserDao;

public class FakeDataDaoTests {

	private UserDao userDao;

	@Before
	public void setUp() throws Exception {
		userDao = new FakeDataDao();
	}

	@Test
	public void getAllUsersTest() {
		assertThat(userDao.getAllUsers().size(), greaterThanOrEqualTo(8));
		Assertions.assertThat(userDao.getAllUsers()).hasSize(1);
	}

	@Test
	public void getUserTest() {

	}

	@Test
	public void updateUserTest() {

	}

	@Test
	public void removeUserTest() {

	}

	@Test
	public void insertUserTest() {

	}

}
