package de.hs_kl.staab.planner;

import org.springframework.web.bind.annotation.RequestMapping;
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

}