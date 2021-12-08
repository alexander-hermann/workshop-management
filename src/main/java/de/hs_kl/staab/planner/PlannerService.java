package de.hs_kl.staab.planner;

/**
 * Verwaltet den Planungskalender
 */
public class PlannerService {

	private static PlannerService INSTANCE;

	private final PlanningCalendar planningCalendar;

	/**
	 * Singleton-Pattern: Der Konstruktor kann nicht aufgerufen werden, sondern
	 * {@link #getInstance()} muss aufgerufen werden. So kann sichergestellt werden,
	 * dass nur eine einzige Instanz dieser Klasse erstellt wird.
	 */
	private PlannerService() {
		planningCalendar = new PlanningCalendar();
	}

	/**
	 * Teil des Singleton-Patterns
	 * 
	 * @return Die einzige Instanz des PlannerService.
	 */
	public static PlannerService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PlannerService();
		}
		return INSTANCE;
	}

	/* ******************************************* */
	/* * HIER KÖNNEN SIE IHRE METHODEN SCHREIBEN * */
	/* * Dieser Service bietet alle Funktionen *** */
	/* * an, die Ihre Anwendung bietet. So ******* */
	/* * können beispielsweise Anfragen validiert* */
	/* * werden, bevor Sie diese an den Kalender * */
	/* * weitergeben. **************************** */
	/* ******************************************* */
}
