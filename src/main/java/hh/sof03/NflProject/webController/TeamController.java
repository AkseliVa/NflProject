package hh.sof03.NflProject.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof03.NflProject.domain.ConferenceRepository;
import hh.sof03.NflProject.domain.DivisionRepository;
import hh.sof03.NflProject.domain.Team;
import hh.sof03.NflProject.domain.TeamRepository;

@Controller
public class TeamController {

	@Autowired
	TeamRepository trepository;
	
	@Autowired
	DivisionRepository drepository;
	
	@Autowired
	ConferenceRepository crepository;
	
	@GetMapping("/teamlist")
	public String getTeams(Model model) {
		List<Team> teams = (List<Team>) trepository.findAll();
		
		model.addAttribute("teams", teams);
		
		return "teamlist";
	}
	
	@GetMapping("/add")
	public String addTeam(Model model) {
		model.addAttribute("team", new Team());
		model.addAttribute("divisions", drepository.findAll());
		model.addAttribute("conferences", crepository.findAll());
		return "addteam";
	}
	
	@GetMapping("/edit/{teamid}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editTeam(@PathVariable("teamid") Long teamId, Model model) {
		model.addAttribute("team", trepository.findById(teamId));
		model.addAttribute("divisions", drepository.findAll());
		return "editteam";
	}
	
	@PostMapping("/save")
	public String save(Team team) {
		trepository.save(team);
		return "redirect:/homepage";
	}
	
	@PostMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteTeam(@PathVariable("id") Long teamid, Model model) {
		trepository.deleteById(teamid);
		return "redirect:/homepage";
	}
}
