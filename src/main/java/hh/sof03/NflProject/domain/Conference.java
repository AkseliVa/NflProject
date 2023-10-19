package hh.sof03.NflProject.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Conference {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long conferenceid;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "conference")
	@JsonIgnoreProperties("conference")
	private List<Division> divisions;

	public long getConferenceid() {
		return conferenceid;
	}

	public void setConferenceid(long conferenceid) {
		this.conferenceid = conferenceid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Division> getDivisions() {
		return divisions;
	}

	public void setDivisions(List<Division> divisions) {
		this.divisions = divisions;
	}

	public Conference(String name) {
		super();
		this.name = name;
	}

	public Conference() {
		super();
	}
	
	
}
