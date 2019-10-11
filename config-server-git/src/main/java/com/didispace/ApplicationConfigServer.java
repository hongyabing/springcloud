package com.didispace;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ApplicationConfigServer {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ApplicationConfigServer.class).web(true).run(args);
	}

}
