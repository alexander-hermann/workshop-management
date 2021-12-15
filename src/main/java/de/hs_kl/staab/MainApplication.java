package de.hs_kl.staab;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.hs_kl.staab.planner.CLEANINGPROGRAMM;
import de.hs_kl.staab.planner.Car;
import de.hs_kl.staab.planner.CleaningAppointment;
import de.hs_kl.staab.planner.ConsultingAppointment;
import de.hs_kl.staab.planner.Customer;
import de.hs_kl.staab.planner.CustomerService;
import de.hs_kl.staab.planner.InvoiceAddress;
import de.hs_kl.staab.planner.PlannerService;
import de.hs_kl.staab.planner.PlanningCalendar;
import de.hs_kl.staab.planner.Service;
import de.hs_kl.staab.planner.Vehicle;
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
		CustomerService customerService = new CustomerService();

		WorkingPlatform wkp1 = new WorkingPlatform("Arbeitsbühne1");
		WorkingPlatform wkp2 = new WorkingPlatform("Arbeitsbühne2");
		WorkingPlatform wkp3 = new WorkingPlatform("Arbeitsbühne3");

		Service oilChange = new Service("Ölwechsel", 0.5);
		Service tireChange = new Service("Reifenwechsel", 1.0);
		Service glassRepair = new Service("Glasreparatur", 2.0);
		Service inspectionCar = new Service("KFZ-Inspektion", 1.5);

		InvoiceAddress addressOfSaid = new InvoiceAddress("Hauptstraße", 20, 66840, "Zweibrücken");
		InvoiceAddress addressOfTreitz = new InvoiceAddress("Hauptstraße", 15, 66820, "Bierbach");
		InvoiceAddress addressOfHermann = new InvoiceAddress("Hauptstraße", 30, 66880, "Kaiserslautern");

		Vehicle car1 = new Car("HOM-SB-211", "BMW", "M1", 2016, 2018, 8, 1);
		Vehicle car2 = new Car("SB-HO-333", "Mercedes", "CLA", 2010, 2013, 8, 1);

		customerService.createNewVehicle(car1);
		customerService.createNewVehicle(car2);

		Customer customer1 = new Customer("Ammar Said", addressOfSaid, "+49176 258484750", "ammar@web.de", null);
		Customer customer2 = new Customer("Alexander Hermann", addressOfHermann, "0176-5656556", "alex@web.de", null);
		Customer customer3 = new Customer("Hendrik Treitz", addressOfTreitz, "+49176-4548484", "hendrik@web.de", null);

		customer1.getListOfVehiclesForCustomer();
		// customerservice.updateCustomer("HoM", customer1);

		plannerService.createNewWorkingPlatform(wkp1);
		plannerService.createNewWorkingPlatform(wkp2);
		plannerService.createNewWorkingPlatform(wkp3);

		plannerService.createNewService(oilChange);
		plannerService.createNewService(tireChange);
		plannerService.createNewService(glassRepair);
		plannerService.createNewService(inspectionCar);

		plannerService.getWorkingPlatforms();
		plannerService.getServices();
		ConsultingAppointment appointment1 = new ConsultingAppointment(2016, 2, 5, 13, 15, customer1, 1);
		ConsultingAppointment appointment2 = new ConsultingAppointment(2016, 1, 5, 13, 15, customer1, 1);
		ConsultingAppointment appointment3 = new ConsultingAppointment(2016, 1, 6, 13, 15, customer1, 1);
		ConsultingAppointment appointment4 = new ConsultingAppointment(2016, 3, 5, 13, 15, customer1, 1);
		WorkingAppointment appointment5 = new WorkingAppointment(2016, 1, 5, 13, 15, wkp1, car1, oilChange);
		CleaningAppointment appointment6 = new CleaningAppointment(2016, 1, 5, 13, 15, wkp3, CLEANINGPROGRAMM.FAST);
		CleaningAppointment appointment7 = new CleaningAppointment(2022, 1, 5, 13, 15, wkp3, CLEANINGPROGRAMM.FAST);

		// System.out.println(appointment1);
		planningCalendar.createNewAppointment(appointment1);
		planningCalendar.createNewAppointment(appointment2);
		planningCalendar.createNewAppointment(appointment3);
		planningCalendar.createNewAppointment(appointment4);
		planningCalendar.createNewAppointment(appointment5);
		planningCalendar.createNewAppointment(appointment6);
		planningCalendar.createNewAppointment(appointment7);

		planningCalendar.getWeekOverview(1, 2016);

	}

}
