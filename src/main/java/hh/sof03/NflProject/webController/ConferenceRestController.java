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

import hh.sof03.NflProject.domain.Conference;
import hh.sof03.NflProject.domain.ConferenceRepository;

@Controller
public class ConferenceRestController {

	@Autowired
	private ConferenceRepository crepository;
	
	@GetMapping("/conferences")
	public @ResponseBody List<Conference> conferenceListRest() {
		return (List<Conference>) crepository.findAll();
	}
	
	@GetMapping("/conferences/{id}")
	public @ResponseBody Optional<Conference> findConferenceRest(@PathVariable("id") Long conferenceId) {
		return crepository.findById(conferenceId);
	}
	
	@PostMapping("/conferences")
	public @ResponseBody Conference saveConferenceRest(@RequestBody Conference conference) {
		return crepository.save(conference);
	}
}
