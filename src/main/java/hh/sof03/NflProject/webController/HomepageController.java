package hh.sof03.NflProject.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof03.NflProject.domain.Conference;
import hh.sof03.NflProject.domain.ConferenceRepository;
import hh.sof03.NflProject.domain.Division;
import hh.sof03.NflProject.domain.DivisionRepository;
import hh.sof03.NflProject.domain.Team;
import hh.sof03.NflProject.domain.TeamRepository;

@Controller
public class HomepageController {
	
	@Autowired
	ConferenceRepository crepository;
	
	@Autowired
	DivisionRepository drepository;
	
	@Autowired
	TeamRepository trepository;

	@GetMapping("/homepage")
	public String getHomepage(Model model) {
		List<Conference> conferences = (List<Conference>) crepository.findAll();
		System.out.println("Number of conferences: " + conferences.size());
		
		List<Division> divisions = (List<Division>) drepository.findAll();
		System.out.println("Number of divisions: " + divisions.size());
		
		List<Team> teams = (List<Team>) trepository.findAll();
		System.out.println("Number of teams: " + teams.size());
		
		model.addAttribute("teams", teams);
		
		model.addAttribute("divisions", divisions);
		
		model.addAttribute("conferences", conferences);
			
		return "homepage";
	}
}
