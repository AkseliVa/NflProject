package hh.sof03.NflProject.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof03.NflProject.domain.Conference;
import hh.sof03.NflProject.domain.ConferenceRepository;

@Controller
public class ConferenceController {
	
	@Autowired
	ConferenceRepository crepository;
	
	@GetMapping("/conferencelist")
	public String getConferences(Model model) {
		List<Conference> conferences = (List<Conference>) crepository.findAll();
		
		model.addAttribute("conferences", conferences);
		
		return "conferencelist";
	}

}
