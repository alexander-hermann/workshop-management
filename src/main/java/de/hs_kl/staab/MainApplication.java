package de.hs_kl.staab;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.hs_kl.staab.planner.CLEANINGPROGRAMM;
import de.hs_kl.staab.planner.CleaningAppointment;
import de.hs_kl.staab.planner.ConsultantAppointment;
import de.hs_kl.staab.planner.Contact;
import de.hs_kl.staab.planner.Customer;
import de.hs_kl.staab.planner.PlannerService;
import de.hs_kl.staab.planner.PlanningCalendar;
import de.hs_kl.staab.planner.Service;
import de.hs_kl.staab.planner.WorkingAppointment;
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
		PlannerService plannerService = PlannerService.getInstance();
		PlanningCalendar planningCalendar = new PlanningCalendar();

		WorkingPlatform wkp1 = new WorkingPlatform("Arbeitsbühne1");
		WorkingPlatform wkp2 = new WorkingPlatform("Arbeitsbühne2");
		WorkingPlatform wkp3 = new WorkingPlatform("Arbeitsbühne3");

		Service se1 = new Service("Cleaning", 1.0);
		Service se2 = new Service("Consulting", 1.0);
		Service se3 = new Service("Working", 1.0);
		Contact Ammar = new Contact("asd", 1, 2, "dsad");

		Customer customer1 = new Customer("Ammar Said", Ammar, null);

		plannerService.createNewWorkingPlatform(wkp1);
		plannerService.createNewWorkingPlatform(wkp2);
		plannerService.createNewWorkingPlatform(wkp3);

		plannerService.createNewService(se1);
		plannerService.createNewService(se2);
		plannerService.createNewService(se3);

		plannerService.getWorkingPlatforms();
		plannerService.getServices();
		ConsultantAppointment appointment1 = new ConsultantAppointment(2016, 2, 5, 13, 15, customer1, 1);
		ConsultantAppointment appointment2 = new ConsultantAppointment(2016, 1, 5, 13, 15, customer1, 1);
		ConsultantAppointment appointment3 = new ConsultantAppointment(2016, 1, 6, 13, 15, customer1, 1);
		ConsultantAppointment appointment4 = new ConsultantAppointment(2016, 3, 5, 13, 15, customer1, 1);
		WorkingAppointment appointment5 = new WorkingAppointment(2016, 1, 5, 13, 15, wkp1, null, se1);
		CleaningAppointment appointment6 = new CleaningAppointment(2016, 1, 5, 13, 15, wkp3, CLEANINGPROGRAMM.FAST);

		// System.out.println(appointment1);
		planningCalendar.createNewAppointment(appointment1);
		planningCalendar.createNewAppointment(appointment2);
		planningCalendar.createNewAppointment(appointment3);
		planningCalendar.createNewAppointment(appointment4);
		planningCalendar.createNewAppointment(appointment5);
		planningCalendar.createNewAppointment(appointment6);

		planningCalendar.getWeekOverview(1);

	}

}
