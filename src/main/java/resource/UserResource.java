package resource;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.ErrorMessage;
import models.User;
import service.UserService;

@RestController
@RequestMapping(path = "/users/v1/all")
public class UserResource {

	private UserService service;

	@Autowired
	public UserResource(UserService service) {
		this.service = service;
		
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(@QueryParam("gender") String gender) {
		System.out.println(gender);
		return service.getAllUsers();
	}

	@RequestMapping(method = RequestMethod.GET, path = "{userId}")
	public ResponseEntity<?> getUser(@PathVariable("userId") UUID userId) {
		if (service.getUser(userId) != null) {
			return ResponseEntity.ok(service.getUser(userId));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("User not found!"));
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertUser(@RequestBody User user) {
		int result = service.insertUser(user);
		if (result == 1) {
			return ResponseEntity.ok("User added");
		} else {
			return ResponseEntity.badRequest().body(new ErrorMessage("Couldnt inser user"));
		}
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{userId}")
	public ResponseEntity<Integer> updateUser(@PathVariable("userId") UUID userId, @RequestBody User user) {
		if (service.updateUser(user) == 1) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{userId}")
	private ResponseEntity<Integer> deleteUser(@PathVariable("userId") UUID uuid) {
		User res = service.removeUser(uuid);
		if (res != null) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
