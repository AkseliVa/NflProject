/*package hh.sof03.NflProject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.NflProject.webController.ConferenceController;
import hh.sof03.NflProject.webController.ConferenceRestController;
import hh.sof03.NflProject.webController.DivisionController;
import hh.sof03.NflProject.webController.DivisionRestController;
import hh.sof03.NflProject.webController.HomepageController;
import hh.sof03.NflProject.webController.TeamController;
import hh.sof03.NflProject.webController.TeamRestController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NflProjectApplicationTests {
	
	@Autowired
	private TeamController tcontroller;
	@Autowired
	private TeamRestController trcontroller;
	
	@Autowired
	private DivisionController dcontroller;
	@Autowired
	private DivisionRestController drcontroller;
	
	@Autowired
	private ConferenceController ccontroller;
	@Autowired
	private ConferenceRestController crcontroller;
	
	@Autowired
	private HomepageController hcontroller;

	@Test
	void contextLoads() {
		assertThat(tcontroller).isNotNull();
		assertThat(trcontroller).isNotNull();
		
		assertThat(dcontroller).isNotNull();
		assertThat(drcontroller).isNotNull();
		
		assertThat(ccontroller).isNotNull();
		assertThat(crcontroller).isNotNull();
		
		assertThat(hcontroller).isNotNull();
		
	}

}*/
