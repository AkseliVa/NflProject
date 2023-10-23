package hh.sof03.NflProject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long teamid;
	
	private String name;
	private String city;
	
	private Integer wins;
	private Integer losses;
	
	@ManyToOne
	@JsonIgnoreProperties ("teams")
	@JoinColumn(name="divisionid")
	private Division division;

	public long getTeamid() {
		return teamid;
	}

	public void setTeamid(long teamid) {
		this.teamid = teamid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}
	

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}

	public Team(String name, String city, Division division, Integer wins, Integer losses) {
		super();
		this.name = name;
		this.city = city;
		this.division = division;
		this.wins = wins;
		this.losses = losses;
	}

	public Team() {
		super();
	}
	
	
}
