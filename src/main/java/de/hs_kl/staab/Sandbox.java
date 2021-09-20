package de.hs_kl.staab;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is to try out things.
 * 
 * @author Staab
 *
 */
@RestController
@RequestMapping(path = "/sandbox")
public class Sandbox {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam String name) {
		String salutation = "Hallo " + name + "!";
		return salutation;
	}

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String home() {
		return "Sandbox is here!";
	}

}
