package com.shopforhome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shopforhome.models.Admin;
import com.shopforhome.services.AdminService;

@SpringBootApplication
public class ShopforHomeBackendApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ShopforHomeBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ShopforHomeBackendApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(AdminService service) {
	    return (args) -> {
	    	if(service.count()==0) {
	    		service.updateAdmin(new Admin("ravi", "ravi", "Ruler"));
	    		log.info("Admin is King");
	    	}
	    };
	}

}
