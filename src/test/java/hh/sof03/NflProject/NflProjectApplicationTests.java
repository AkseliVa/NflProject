package hh.sof03.NflProject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.NflProject.domain.Conference;
import hh.sof03.NflProject.domain.ConferenceRepository;
import hh.sof03.NflProject.domain.Division;
import hh.sof03.NflProject.domain.DivisionRepository;
import hh.sof03.NflProject.domain.Team;
import hh.sof03.NflProject.domain.TeamRepository;
import hh.sof03.NflProject.domain.User;
import hh.sof03.NflProject.domain.UserRepository;
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
	
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private DivisionRepository divisionRepository;
	@Autowired
	private ConferenceRepository conferenceRepository;
	@Autowired
	private UserRepository userRepository;

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
	
	@Test
    public void FindTeamsByDivisionName() {
        List<Team> teams = teamRepository.findByDivisionName("East");

        assertThat(teams).isNotEmpty();
        assertThat(teams).hasSize(8);
    }

    @Test
    public void FindConferences() {
        Conference conference = conferenceRepository.findByName("AFC");
        
        List<Division> divisions = divisionRepository.findByConference(conference);

        assertThat(divisions).isNotEmpty();
        assertThat(divisions).hasSize(4);
    }
    
    @Test
    public void createNewConference() {
        Conference conference = new Conference("CFC");
        conferenceRepository.save(conference);
        assertThat(conference.getConferenceid()).isNotNull();
    }

    @Test
    public void createNewDivision() {
        Conference conference = new Conference("LFC");
        conferenceRepository.save(conference);
        Division division = new Division("SouthEast", conference);
        divisionRepository.save(division);
        assertThat(division.getDivisionid()).isNotNull();
    }

    @Test
    public void createNewTeam() {
        Conference conference = new Conference("KFC");
        conferenceRepository.save(conference);
        Division division = new Division("NorthEast", conference);
        divisionRepository.save(division);
        Team team = new Team("Roosters", "Helsinki", division, 10, 0);
        teamRepository.save(team);
        assertThat(team.getTeamid()).isNotNull();
    }

    @Test
    public void createNewUser() {
        User user = new User("akseli", "vartiainen", "Admin");
        userRepository.save(user);
        assertThat(user.getId()).isNotNull();
    }
    
    @Test
    public void deleteConference() {
        Conference conference = new Conference("ÖFC");
        conferenceRepository.save(conference);
        Long conferenceId = conference.getConferenceid();
        assertThat(conferenceId).isNotNull();
        conferenceRepository.deleteById(conferenceId);
        assertThat(conferenceRepository.findById(conferenceId)).isEmpty();
    }

    @Test
    public void deleteDivision() {
        Conference conference = new Conference("ÄFC");
        conferenceRepository.save(conference);
        Division division = new Division("Etelä", conference);
        divisionRepository.save(division);
        Long divisionId = division.getDivisionid();
        assertThat(divisionId).isNotNull();
        divisionRepository.deleteById(divisionId);
        assertThat(divisionRepository.findById(divisionId)).isEmpty();
    }

    @Test
    public void deleteTeam() {
        Conference conference = new Conference("MFC");
        conferenceRepository.save(conference);
        Division division = new Division("Itä", conference);
        divisionRepository.save(division);
        Team team = new Team("Steelers", "Kuopio", division, 4, 3);
        teamRepository.save(team);
        Long teamId = team.getTeamid();
        assertThat(teamId).isNotNull();
        teamRepository.deleteById(teamId);
        assertThat(teamRepository.findById(teamId)).isEmpty();
    }

    @Test
    public void deleteUser() {
        User user = new User("username", "password", "ROLE_USER");
        userRepository.save(user);
        Long userId = user.getId();
        assertThat(userId).isNotNull();
        userRepository.deleteById(userId);
        assertThat(userRepository.findById(userId)).isEmpty();
    }
}
