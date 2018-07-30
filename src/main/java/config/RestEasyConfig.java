package config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import resource.UserResourceRestEasyImpl;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Component
public class RestEasyConfig extends ResourceConfig {

	public RestEasyConfig() {
	//	register(UserResourceRestEasyImpl.class);
	}
	
}