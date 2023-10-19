package hh.sof03.NflProject.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Division {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long divisionid;
	
	private String name;
	
	@ManyToOne
	@JsonIgnoreProperties ("divisions")
	@JoinColumn(name="conferenceid")
	private Conference conference;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
	@JsonIgnoreProperties("division")
	private List<Team> teams;

	public long getDivisionid() {
		return divisionid;
	}

	public void setDivisionid(long divisionid) {
		this.divisionid = divisionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Division(String name, Conference conference) {
		super();
		this.name = name;
		this.conference = conference;
	}

	public Division() {
		super();
	}
	
	
}
