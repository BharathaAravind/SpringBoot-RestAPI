package resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import models.User;
import service.UserService;

@Component
@Path("/api/v1/users")
public class UserResourceRestEasyImpl {

	private UserService service;
	
	@Autowired
	public UserResourceRestEasyImpl(UserService service) {
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
}
