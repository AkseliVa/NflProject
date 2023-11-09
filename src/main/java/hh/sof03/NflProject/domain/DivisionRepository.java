package hh.sof03.NflProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DivisionRepository extends CrudRepository<Division, Long>{

	List<Division> findByConference(Conference conference);

}
