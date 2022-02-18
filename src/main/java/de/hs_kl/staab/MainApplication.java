package de.hs_kl.staab;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
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
import de.hs_kl.staab.planner.UserService;
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
		SpringApplication.run(MainApplication.class, args);

		// Wenn Sie MIT REST arbeiten wollen, können Sie die folgende Zeile
		// und die entsprechende Methode löschen!
		runApplication();
	}

	private static void runApplication() {

		// @formatter:off
		PlannerService plannerService = PlannerService.getInstance();
		PlanningCalendar planningCalendar = PlanningCalendar.getInstance();
		CustomerService customerService = CustomerService.getInstance();
		UserService userService = UserService.getInstance();

		WorkingPlatform wkp1 = new WorkingPlatform("Arbeitsbühne1");
		WorkingPlatform wkp2 = new WorkingPlatform("Arbeitsbühne2");
		WorkingPlatform wkp3 = new WorkingPlatform("Arbeitsbühne3");

		CarMechanic carMechanic1 = new CarMechanic("Auto Meschaniker", "1234567890", "Otto@ATU.de");
		CustomerConsultant customerConsultant1 = new CustomerConsultant("Kunden Berater1", "1234547890-1",
				"Ralph@ATU.de");
		CustomerConsultant customerConsultant2 = new CustomerConsultant("Kunden Berater2", "1234547890-2",
				"Ralph@ATU.de");
		Dispatcher dispatcher1 = new Dispatcher("Dispo Person", "1232567890", "Herbert@ATU.de");

		Service oilChange = new Service("Ölwechsel", 0.5);
		Service tireChange = new Service("Reifenwechsel", 1.0);
		Service glassRepair = new Service("Glasreparatur", 2.0);
		Service inspectionCar = new Service("KFZ-Inspektion", 1.5);

		List<Service> collectionOfWorkForCustomer01 = new ArrayList<Service>();
		collectionOfWorkForCustomer01.add(oilChange);
		collectionOfWorkForCustomer01.add(glassRepair);

		List<Service> collectionOfWorkForCustomer02 = new ArrayList<Service>();
		collectionOfWorkForCustomer02.add(inspectionCar);
		collectionOfWorkForCustomer02.add(oilChange);

		List<Service> collectionOfWorkForCustomer03 = new ArrayList<Service>();
		collectionOfWorkForCustomer03.add(glassRepair);
		collectionOfWorkForCustomer03.add(inspectionCar);

		InvoiceAddress invoiceAddressOfCustomer1 = new InvoiceAddress("Hauptstraße", 20, 66840, "Zweibrücken");
		InvoiceAddress invoiceAddressOfCustomer2 = new InvoiceAddress("Hauptstraße", 30, 66880, "Kaiserslautern");
		InvoiceAddress invoiceAddressOfCustomer3 = new InvoiceAddress("Hauptstraße", 15, 66820, "Bierbach");

		Customer customer1 = new Customer("Ammar Said", invoiceAddressOfCustomer1, "+49176 258484750", "ammar@web.de");
		Customer customer2 = new Customer("Alexander Hermann", invoiceAddressOfCustomer2, "0176-5656556","alex@web.de");
		Customer customer3 = new Customer("Hendrik Treitz", invoiceAddressOfCustomer3, "+49176-4548484","hendrik@web.de");
		Customer customer4 = new Customer("Max Müller", null, "+490176-99988874", "max@web.de");

		Vehicle car1 = new Car("HOM-SB 211", "BMW", "M1", 2016, 2018, 8, 1, customer1);
		Vehicle car2 = new Car("SB-HO 333", "Mercedes", "CLA", 2010, 2013, 8, 1, customer2);
		Vehicle car3 = new Car("KUS-AM 24", "Audi", "RS6", 2010, 2013, 8, 1, customer3);
		Vehicle car4 = new Car("KL-AX 500", "Porsche", "Taycan Turbo S", 2019, 2020, 8, 2, customer4);

		ConsultingAppointment consultingAppointment1 = new ConsultingAppointment(2021, 12, 20, 8, 00, customer1, 1, customerConsultant1);
		ConsultingAppointment consultingAppointment2 = new ConsultingAppointment(2021, 12, 20, 9, 00, customer1, 1, customerConsultant1);
		ConsultingAppointment consultingAppointment3 = new ConsultingAppointment(2021, 12, 20, 10, 00, customer1, 1, customerConsultant1);
		ConsultingAppointment consultingAppointment4 = new ConsultingAppointment(2021, 12, 20, 14, 15, customer1, 1, customerConsultant1);
		ConsultingAppointment consultingAppointment5 = new ConsultingAppointment(2021, 12, 20, 14, 15, customer1, 1, customerConsultant2);

		WorkingAppointment workingAppointment01 = new WorkingAppointment(2022, 2, 20, 8, 00, wkp1, car1, collectionOfWorkForCustomer01, carMechanic1);
		WorkingAppointment workingAppointment02 = new WorkingAppointment(2022, 2, 17, 10, 30, wkp1, car1, collectionOfWorkForCustomer01, carMechanic1);
		WorkingAppointment workingAppointment03 = new WorkingAppointment(2022, 2, 17, 8, 00, wkp1, car2, collectionOfWorkForCustomer01, carMechanic1);
		WorkingAppointment workingAppointment04 = new WorkingAppointment(2022, 2, 17, 14, 00, wkp1, car2, collectionOfWorkForCustomer01, carMechanic1);
		WorkingAppointment workingAppointment05 = new WorkingAppointment(2022, 1, 22, 8, 00, wkp2, car2, collectionOfWorkForCustomer01, carMechanic1);
		WorkingAppointment workingAppointment06 = new WorkingAppointment(2022, 1, 15, 10, 00, wkp2, car2, collectionOfWorkForCustomer01, carMechanic1);
		WorkingAppointment workingAppointment07 = new WorkingAppointment(2022, 1, 15, 12, 00, wkp2, car2, collectionOfWorkForCustomer01, carMechanic1);
		WorkingAppointment workingAppointment08 = new WorkingAppointment(2022, 1, 15, 14, 00, wkp2, car2, collectionOfWorkForCustomer01, carMechanic1);
		WorkingAppointment workingAppointment09 = new WorkingAppointment(2022, 1, 15, 8, 00, wkp3, car2, collectionOfWorkForCustomer01, carMechanic1);
		WorkingAppointment workingAppointment10 = new WorkingAppointment(2022, 1, 15, 10, 00, wkp3, car2, collectionOfWorkForCustomer01, carMechanic1);
		WorkingAppointment workingAppointment11 = new WorkingAppointment(2022, 1, 15, 12, 00, wkp3, car2, collectionOfWorkForCustomer01, carMechanic1);
		WorkingAppointment workingAppointment12 = new WorkingAppointment(2022, 1, 15, 14, 00, wkp3, car2, collectionOfWorkForCustomer01, carMechanic1);

		CleaningAppointment cleaningAppointment1 = new CleaningAppointment(2022, 2, 18, 8, 00, wkp1, CLEANINGPROGRAMM.FAST, dispatcher1);
		CleaningAppointment cleaningAppointment2 = new CleaningAppointment(2022, 1, 12, 12, 00, wkp3, CLEANINGPROGRAMM.INTENSE, dispatcher1);
		CleaningAppointment cleaningAppointment3 = new CleaningAppointment(2022, 1, 12, 15, 00, wkp3, CLEANINGPROGRAMM.INTENSE, dispatcher1);
		CleaningAppointment cleaningAppointment4 = new CleaningAppointment(2022, 1, 12, 13, 05, wkp3, CLEANINGPROGRAMM.INTENSE, dispatcher1);

		// ########################################################
		customerService.createNewVehicle(car1);
		customerService.createNewVehicle(car1);
		customerService.createNewVehicle(car2);
		customerService.createNewVehicle(car3);

		customerService.createNewCustomer(customer1);
		customerService.createNewCustomer(customer2);
		customerService.createNewCustomer(customer2);
		customerService.createNewCustomer(customer3);
		customerService.createNewCustomer(null);

		customerService.updateCustomerForVehicle(customer1, car1);
		customerService.updateCustomerForVehicle(customer1, car4);
		customerService.updateCustomerForVehicle(customer2, car2);
		customerService.updateCustomerForVehicle(customer2, null);

		customerService.getCustomerById("CS-1");
		customerService.getListOfVehiclesForCustomer(customer1);
		customerService.getListOfVehiclesForCustomer(customer2);
		System.out.println("##############");
		customerService.getListOfVehiclesForCustomer(null);

		customerService.getVehicleByLicensePlate("HOM-SB 211");
		customerService.getVehicleByLicensePlate("HOM-SH 212");
		customerService.updateVehicle(null, null);

		customerService.getServiceHistoryForVehicle(null);

		// customerService.getListOfVehiclesForCustomer(customer4);

		// #############################################################
		userService.createNewUser(dispatcher1);
		userService.createNewUser(customerConsultant1);
		userService.createNewUser(customerConsultant2);

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
		planningCalendar.createNewAppointment(consultingAppointment5);

		planningCalendar.createNewAppointment(workingAppointment01);
		planningCalendar.createNewAppointment(workingAppointment02);
		planningCalendar.createNewAppointment(workingAppointment03);
		planningCalendar.createNewAppointment(workingAppointment04);
		planningCalendar.createNewAppointment(workingAppointment05);
		planningCalendar.createNewAppointment(workingAppointment06);
		planningCalendar.createNewAppointment(workingAppointment07);
		planningCalendar.createNewAppointment(workingAppointment08);
		planningCalendar.createNewAppointment(workingAppointment09);
		planningCalendar.createNewAppointment(workingAppointment10);
		planningCalendar.createNewAppointment(workingAppointment11);
		planningCalendar.createNewAppointment(workingAppointment12);

		planningCalendar.createNewAppointment(cleaningAppointment1);
		planningCalendar.createNewAppointment(cleaningAppointment2);
		planningCalendar.createNewAppointment(cleaningAppointment3);
		planningCalendar.createNewAppointment(cleaningAppointment4);
		planningCalendar.getWeekOverview(10, 2016);

		planningCalendar.setAutomaticallyCleaningAppointment(wkp1, CLEANINGPROGRAMM.INTENSE, dispatcher1);
		planningCalendar.setAutomaticallyCleaningAppointment2(wkp1, CLEANINGPROGRAMM.INTENSE, dispatcher1);

		planningCalendar.getAppointments();

		// planningCalendar.setWorkingAppoinmentToCompleted(workingAppointment1);
		planningCalendar.setWorkingAppoinmentToCompleted(workingAppointment02);
		planningCalendar.setWorkingAppoinmentToCompleted(workingAppointment03);
		planningCalendar.setWorkingAppoinmentToCompleted(workingAppointment04);
		System.out.println("Service history for car1: ");

		// Check if all finished work is issued for car1
		customerService.getServiceHistoryForVehicle(car1);

		System.out.println("Appointments of yesterday:");
		planningCalendar.getYesterdayWorkingAppointments();

		// planningCalendar.getAppointments();
		planningCalendar.getAppointmentById("AP-14");

		System.out.println("The list of working appointments for the car mechanic 1 of today:");

		planningCalendar.getOverviewOfTodayWorks(carMechanic1, wkp1);
		// plannerService.getOverviewOfTodayWorks(carMechanic1, wkp2);

		planningCalendar.getSuggestThreeWorkingAppointments(tireChange, wkp1);
		System.out.println(planningCalendar.getListOfAppointments());
		// planningCalendar.getSuggestThreeWorkingAppointments(null, null);
		// planningCalendar.getSuggestThreeWorkingAppointments(oilChange, wkp1);
		// planningCalendar.getSuggestThreeWorkingAppointments(tireChange, wkp1);
	}
}