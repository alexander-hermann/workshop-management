package de.hs_kl.staab;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.hs_kl.staab.planner.Service;
import de.hs_kl.staab.planner.WorkingPlatform;

/**
 * <p>
 * This class contains the main function and is called upon start. It starts
 * Spring Boot, which starts an application server and runs your application in
 * this application server so that it can be reached in the Network.
 * </p>
 * 
 * <p>
 * If you now enter the following URL in the browser, you can access the
 * Swagger-Interface of the application: <a href=
 * "http://localhost:8080/swagger-ui/">http://localhost:8080/swagger-ui/</a>.
 * </p>
 *
 * @author Staab
 */
@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		System.out.println("Now the application is started!");
		// Wenn Sie OHNE REST arbeiten wollen, können Sie die folgende Zeile
		// und die Klasse PlannerController löschen!
		// SpringApplication.run(MainApplication.class, args);

		// Wenn Sie MIT REST arbeiten wollen, können Sie die folgende Zeile
		// und die entsprechende Methode löschen!
		runApplication();
	}

	private static void runApplication() {

		WorkingPlatform wkp1 = new WorkingPlatform("Arbeitsbühne1");
		WorkingPlatform wkp2 = new WorkingPlatform("Arbeitsbühne2");
		WorkingPlatform wkp3 = new WorkingPlatform("Arbeitsbühne3");

		Service se1 = new Service("Cleaning", 1.0);
		Service se2 = new Service("Consulting", 1.0);
		Service se3 = new Service("Working", 1.0);

		Service.createNewService(se1);
		Service.createNewService(se2);
		Service.createNewService(se3);

		System.out.println(Service.getServiceById(3));

		// System.out.println(workshop);
		System.out.println(wkp1);
		System.out.println("fehler");
	}

}
