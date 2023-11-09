package hh.sof03.NflProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long>{
	
	List<Team> findByDivisionName(String divisionName);

	List<Team> getTeamByName(String teamName);

}
