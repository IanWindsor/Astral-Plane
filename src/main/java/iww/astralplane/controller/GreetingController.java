package iww.astralplane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Notes:
 * @Controller designates this class sends back view with the name we return in the string.
 */


/**
 * 
 * @author ianww
 * Controller for the Home page of Astral Plane
 * 
 * This is not needed. Spring Boot looks for "static/index.html" as the default home page.
 * I may need to suck it up and just use Thymeleaf or something else because it still doesn't register "home.html"
 */
@Controller
public class GreetingController {
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World!") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
}
