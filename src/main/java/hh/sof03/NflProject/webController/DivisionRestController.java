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

import hh.sof03.NflProject.domain.Division;
import hh.sof03.NflProject.domain.DivisionRepository;

@Controller
public class DivisionRestController {
	
	@Autowired
	private DivisionRepository drepository;
	
	@GetMapping("/divisions")
	public @ResponseBody List<Division> divisionListRest() {
		return (List<Division>) drepository.findAll();
	}
	
	@GetMapping("/divisions/{id}")
	public @ResponseBody Optional<Division> findDivisionRest(@PathVariable("id") Long divisionId) {
		return drepository.findById(divisionId);
	}
	
	@PostMapping("/divisions")
	public @ResponseBody Division saveDivisionRest(@RequestBody Division division) {
		return drepository.save(division);
	}

}
