package resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import models.ErrorMessage;
import models.User;
import service.UserService;

@Component
@Path("/api/v1/users")
public class UserResourceJerseyImpl {

	private UserService service;

	@Autowired
	public UserResourceJerseyImpl(UserService service) {
		super();
		this.service = service;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(@QueryParam("gender") String gender) {
		System.out.println(gender);
		System.out.println("rest easy implementation");
		return service.getAllUsers();
	}

	@GET
	@Path("{userId}")
	public ResponseEntity<?> getUser(@PathParam("userId") Integer userId) {
		if (service.getUser(userId) != null) {
			return ResponseEntity.ok(service.getUser(userId));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("User not found!"));
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertUser(@RequestBody User user) {
		int result = service.insertUser(user);
		if (result == 1) {
			return ResponseEntity.ok("User added");
		} else {
			return ResponseEntity.badRequest().body(new ErrorMessage("Couldnt inser user"));
		}
	}

	@PUT
	@Path("{userId}")
	public ResponseEntity<Integer> updateUser(@PathParam("userId") String userId, @RequestBody User user) {
		if (service.updateUser(user) == 1) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DELETE
	@Path("{userId}")
	private ResponseEntity<Integer> deleteUser(@PathParam("userId") Integer uuid) {
		User res = service.removeUser(uuid);
		if (res != null) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

}
