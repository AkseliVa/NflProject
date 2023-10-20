package hh.sof03.NflProject.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof03.NflProject.domain.Division;
import hh.sof03.NflProject.domain.DivisionRepository;

@Controller
public class DivisionController {

	@Autowired
	DivisionRepository drepository;
	
	@GetMapping("/divisionlist")
	public String getDivisions(Model model) {
		List<Division> divisions = (List<Division>) drepository.findAll();
		
		model.addAttribute("divisions", divisions);
		
		return "divisionlist";
	}
}
