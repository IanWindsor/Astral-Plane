package astralplane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles only index requests Removed static Index that Spring Boot uses so I
 * can insert templates using Thymeleaf
 * 
 * @author ianww
 *
 */
@Controller
public class IndexController {

	@GetMapping(value = { "/", "index" })
	public String getIndex(Model model) {
		return "index";
	}
}
