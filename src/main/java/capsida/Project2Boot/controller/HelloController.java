package capsida.Project2Boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String addUsers() {
		return "hello/index";
	}
}
