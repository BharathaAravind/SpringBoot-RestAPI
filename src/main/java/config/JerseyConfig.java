package config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import resource.UserResourceJerseyImpl;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(UserResourceJerseyImpl.class);
	}

}