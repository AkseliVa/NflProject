package hh.sof03.NflProject.webController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.NflProject.domain.Team;
import hh.sof03.NflProject.domain.TeamRepository;

@Controller
public class TeamRestController {

	@Autowired
	private TeamRepository trepository;
	
	@GetMapping("/teams")
	public @ResponseBody List<Team> teamListRest() {
		return (List<Team>) trepository.findAll();
	}
	
	@GetMapping("/teams/{id}")
	public @ResponseBody Optional<Team> findTeamRest(@PathVariable("id") Long teamId) {
		return trepository.findById(teamId);
	}
	
	@PostMapping("/teams")
	public @ResponseBody Team saveTeamRest(@RequestBody Team team) {
		return trepository.save(team);
	}
}
