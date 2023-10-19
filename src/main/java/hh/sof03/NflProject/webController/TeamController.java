package hh.sof03.NflProject.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof03.NflProject.domain.DivisionRepository;
import hh.sof03.NflProject.domain.Team;
import hh.sof03.NflProject.domain.TeamRepository;

@Controller
public class TeamController {

	@Autowired
	TeamRepository trepository;
	
	@Autowired
	DivisionRepository drepository;
	
	@GetMapping("/teamlist")
	public String getTeams(Model model) {
		List<Team> teams = (List<Team>) trepository.findAll();
		
		model.addAttribute("teams", teams);
		
		return "teamlist";
	}
}
