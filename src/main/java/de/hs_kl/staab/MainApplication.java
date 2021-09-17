package de.hs_kl.staab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This Application only contains the main function and is called upon start.
 * Spring boot.
 *
 * @author Staab
 */
@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		System.out.println("Now the Spring framework is started!");
		SpringApplication.run(MainApplication.class, args);
	}

}
