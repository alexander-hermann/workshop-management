package de.hs_kl.staab;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.hs_kl.staab.planner.CLEANINGPROGRAMM;
import de.hs_kl.staab.planner.Car;
import de.hs_kl.staab.planner.CarMechanic;
import de.hs_kl.staab.planner.CleaningAppointment;
import de.hs_kl.staab.planner.ConsultingAppointment;
import de.hs_kl.staab.planner.Customer;
import de.hs_kl.staab.planner.CustomerConsultant;
import de.hs_kl.staab.planner.CustomerService;
import de.hs_kl.staab.planner.Dispatcher;
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

		CarMechanic user1 = new CarMechanic("Auto Meschaniker", "1234567890", "Otto@ATU.de");
		CustomerConsultant user2 = new CustomerConsultant("Kunden Berater", "1234547890", "Ralph@ATU.de");
		Dispatcher user3 = new Dispatcher("Dispo Person", "1232567890", "Herbert@ATU.de");

		Service oilChange = new Service("Ölwechsel", 0.5);
		Service tireChange = new Service("Reifenwechsel", 1.0);
		Service glassRepair = new Service("Glasreparatur", 2.0);
		Service inspectionCar = new Service("KFZ-Inspektion", 1.5);

		InvoiceAddress addressOfSaid = new InvoiceAddress("Hauptstraße", 20, 66840, "Zweibrücken");
		InvoiceAddress addressOfTreitz = new InvoiceAddress("Hauptstraße", 15, 66820, "Bierbach");
		InvoiceAddress addressOfHermann = new InvoiceAddress("Hauptstraße", 30, 66880, "Kaiserslautern");

		Vehicle car1 = new Car("HOM-SB 211", "BMW", "M1", 2016, 2018, 8, 1);
		Vehicle car2 = new Car("SB-HO 333", "Mercedes", "CLA", 2010, 2013, 8, 1);
		Vehicle car3 = new Car("KUS-AM 24", "Audi", "RS6", 2010, 2013, 8, 1);
		Vehicle car4 = new Car("KL-AX 500", "Porsche", "Taycan Turbo S", 2019, 2020, 8, 2);

		Customer customer1 = new Customer("Ammar Said", addressOfSaid, "+49176 258484750", "ammar@web.de");
		Customer customer2 = new Customer("Alexander Hermann", addressOfHermann, "0176-5656556", "alex@web.de");
		Customer customer3 = new Customer("Hendrik Treitz", addressOfTreitz, "+49176-4548484", "hendrik@web.de");

		ConsultingAppointment consultingAppointment1 = new ConsultingAppointment(2016, 1, 5, 13, 15, customer1, 1,
				user2);
		ConsultingAppointment consultingAppointment2 = new ConsultingAppointment(2016, 1, 5, 13, 15, customer1, 1,
				user2);
		ConsultingAppointment consultingAppointment3 = new ConsultingAppointment(2016, 1, 6, 13, 15, customer1, 1,
				user2);
		ConsultingAppointment consultingAppointment4 = new ConsultingAppointment(2016, 1, 5, 13, 15, customer1, 1,
				user2);

		WorkingAppointment workingAppointment1 = new WorkingAppointment(2021, 12, 27, 13, 15, wkp1, car1, oilChange,
				user1);
		WorkingAppointment workingAppointment2 = new WorkingAppointment(2021, 12, 27, 10, 15, wkp1, car1, tireChange,
				user1);
		WorkingAppointment workingAppointment3 = new WorkingAppointment(2016, 1, 7, 13, 15, wkp1, car1, glassRepair,
				user1);
		WorkingAppointment workingAppointment4 = new WorkingAppointment(2016, 1, 8, 13, 15, wkp1, car1, inspectionCar,
				user1);

		CleaningAppointment cleaningAppointment1 = new CleaningAppointment(2016, 1, 5, 13, 15, wkp3,
				CLEANINGPROGRAMM.FAST, user3);
		CleaningAppointment cleaningAppointment2 = new CleaningAppointment(2016, 1, 5, 13, 15, wkp3,
				CLEANINGPROGRAMM.INTENSE, user3);

		// ########################################################
		customerService.createNewVehicle(car1);
		customerService.createNewVehicle(car2);
		customerService.createNewVehicle(car3);

		customerService.createNewCustomer(customer1);
		customerService.createNewCustomer(customer2);
		customerService.createNewCustomer(customer3);

		customerService.addVehicleForCustomer(customer1, car1);
		customerService.addVehicleForCustomer(customer1, car4);
		customerService.addVehicleForCustomer(customer2, car2);
		customerService.addVehicleForCustomer(customer3, car3);

		customerService.getListOfVehiclesForCustomer(customer1);
		customerService.getListOfVehiclesForCustomer(customer2);
		customerService.getListOfVehiclesForCustomer(customer3);

		customerService.getVehicleForCustomer(customer2, car2);
		customerService.getVehicleHistory(car1);

		// ########################################################
		plannerService.createNewWorkingPlatform(wkp1);
		plannerService.createNewWorkingPlatform(wkp2);
		plannerService.createNewWorkingPlatform(wkp3);

		plannerService.createNewService(oilChange);
		plannerService.createNewService(tireChange);
		plannerService.createNewService(glassRepair);
		plannerService.createNewService(inspectionCar);

		plannerService.getWorkingPlatforms();
		plannerService.getServices();

		// ########################################################
		planningCalendar.createNewAppointment(consultingAppointment1);
		planningCalendar.createNewAppointment(consultingAppointment2);
		planningCalendar.createNewAppointment(consultingAppointment3);
		planningCalendar.createNewAppointment(consultingAppointment4);

		planningCalendar.createNewAppointment(workingAppointment1);
		planningCalendar.createNewAppointment(workingAppointment2);
		planningCalendar.createNewAppointment(workingAppointment3);
		planningCalendar.createNewAppointment(workingAppointment4);

		planningCalendar.createNewAppointment(cleaningAppointment1);
		planningCalendar.createNewAppointment(cleaningAppointment2);
		planningCalendar.getWeekOverview(1, 2016);

		planningCalendar.setWorkingAppoinmentToCompleted(workingAppointment1);
		planningCalendar.setWorkingAppoinmentToCompleted(workingAppointment2);
		planningCalendar.setWorkingAppoinmentToCompleted(workingAppointment3);
		planningCalendar.setWorkingAppoinmentToCompleted(workingAppointment4);

		System.out.println("Appointments of yesterday:");
		planningCalendar.getYesterdayWorkingAppointments();

		planningCalendar.getAppointments();
		planningCalendar.getAppointmentById("AP-14");
	}
}