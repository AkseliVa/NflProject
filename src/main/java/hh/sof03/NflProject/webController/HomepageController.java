package hh.sof03.NflProject.webController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

	@GetMapping("/homepage")
	public String getHomepage(Model model) {
			
		return "homepage";
	}
}
