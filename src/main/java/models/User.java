package models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	private Integer userId;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Integer age;
	private String email;
	private String fullName;

	public enum Gender {
		MALE, FEMALE
	}

	public User() {
		super();
	}

	public User(Integer userId, String firstName, String lastName, Gender gender, Integer age, String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.email = email;
	}

	@JsonProperty("Id")
	public Integer getUserId() {
		return userId;
	}

	@JsonProperty("Complete Name")
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	@JsonIgnore
	@JsonProperty("Fk All")
	public Date getBirthday() {
		return new Date();
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User: " + userId + "->" + firstName + "->" + lastName + "->" + gender + "->" + email;
	}

}
