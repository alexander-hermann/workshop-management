package de.hs_kl.staab;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.hs_kl.staab.planner.Address;
import de.hs_kl.staab.planner.WorkingPlatform;
import de.hs_kl.staab.planner.Workshop;

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
		Address addressOfWorkshop = new Address("Industriestraße", 20, 66000, "Zweibrücken");
		Workshop workshop = new Workshop("Auto Werkstatt GmbH", addressOfWorkshop);

		WorkingPlatform wkp1 = new WorkingPlatform("A", false, workshop);

		System.out.println(workshop);
		System.out.println(wkp1);
	}

}
