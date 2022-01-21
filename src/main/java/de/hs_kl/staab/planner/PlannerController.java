package de.hs_kl.staab.planner;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Klasse, die das REST-Interface für den Werkstattplaner zur Verfügung stellt
 * (optional!).
 * 
 * @author Staab
 *
 */
@RestController
@RequestMapping(path = "/planner")
public class PlannerController {

	private final PlannerService plannerService = PlannerService.getInstance();

	/* ************************************************ */
	/* * HIER KÖNNEN SIE IHRE REST-METHODEN SCHREIBEN * */
	/* * Siehe RestSandbox für Beispiele ************** */
	/* ************************************************ */

	@RequestMapping(value = "/services", method = RequestMethod.GET)
	public List<Service> getAllServices() {
		return plannerService.getListOfServices();
	}

	@RequestMapping(value = "/workingplatforms", method = RequestMethod.GET)
	public List<WorkingPlatform> getAllWorkingPlatforms() {
		return plannerService.getListOfWorkingPlatforms();
	}
}
