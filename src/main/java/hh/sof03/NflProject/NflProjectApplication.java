package hh.sof03.NflProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.NflProject.domain.Conference;
import hh.sof03.NflProject.domain.ConferenceRepository;
import hh.sof03.NflProject.domain.Division;
import hh.sof03.NflProject.domain.DivisionRepository;
import hh.sof03.NflProject.domain.Team;
import hh.sof03.NflProject.domain.TeamRepository;

@SpringBootApplication
public class NflProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NflProjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner nflDemo(ConferenceRepository crepository, DivisionRepository drepository, TeamRepository trepository) {
		return (args) -> {
			Conference afc = new Conference("AFC");
			Conference nfc = new Conference("NFC");
			
			crepository.save(afc);
			crepository.save(nfc);
			
			
			
			Division afcnorth = new Division("North", afc);
			Division afceast = new Division("East", afc);
			Division afcsouth = new Division("South", afc);
			Division afcwest = new Division("West", afc);
			
			Division nfcnorth = new Division("North", nfc);
			Division nfceast = new Division("East", nfc);
			Division nfcsouth = new Division("South", nfc);
			Division nfcwest = new Division("West", nfc);
			
			drepository.save(afcnorth);
			drepository.save(afceast);
			drepository.save(afcsouth);
			drepository.save(afcwest);
			
			drepository.save(nfcnorth);
			drepository.save(nfceast);
			drepository.save(nfcsouth);
			drepository.save(nfcwest);
			
			
			
			Team team1 = new Team("Bills", "Buffalo", afceast, 4, 3);
			Team team2 = new Team("Dolphins", "Miami", afceast, 5, 2);
			Team team3 = new Team("Patriots", "New England", afceast, 2, 5);
			Team team4 = new Team("Jets", "New York", afceast, 3, 3);
			
			trepository.save(team1);
			trepository.save(team2);
			trepository.save(team3);
			trepository.save(team4);
			
			Team team5 = new Team("Ravens", "Baltimore", afcnorth, 5, 2);
			Team team6 = new Team("Bengals", "Cincinnati", afcnorth, 4, 2);
			Team team7 = new Team("Browns", "Cleveland", afcnorth, 4, 2);
			Team team8 = new Team("Steelers", "Pittsburgh", afcnorth, 3, 3);
			
			trepository.save(team5);
			trepository.save(team6);
			trepository.save(team7);
			trepository.save(team8);
			
			Team team9 = new Team("Texans", "Houston", afcsouth, 3, 3);
			Team team10 = new Team("Colts", "Indianapolis", afcsouth, 3, 4);
			Team team11 = new Team("Jaguars", "Jacksonville", afcsouth, 5, 2);
			Team team12 = new Team("Titans", "Tennesee", afcsouth, 2, 4);
			
			trepository.save(team9);
			trepository.save(team10);
			trepository.save(team11);
			trepository.save(team12);
			
			Team team13 = new Team("Broncos", "Denver", afcwest, 2, 5);
			Team team14 = new Team("Chiefs", "Kansas City", afcwest, 6, 1);
			Team team15 = new Team("Raiders", "Las Vegas", afcwest, 3, 4);
			Team team16 = new Team("Chargers", "Los Angeles", afcwest, 2, 4);
			
			trepository.save(team13);
			trepository.save(team14);
			trepository.save(team15);
			trepository.save(team16);
			
			
			
			Team team17 = new Team("Cowboys", "Dallas", nfceast, 4, 2);
			Team team18 = new Team("Giants", "New York", nfceast, 2, 5);
			Team team19 = new Team("Eagles", "Philadelphia", nfceast, 6, 1);
			Team team20 = new Team("Commanders", "Washington", nfceast, 3, 4);
			
			trepository.save(team17);
			trepository.save(team18);
			trepository.save(team19);
			trepository.save(team20);
			
			Team team21 = new Team("Bears", "Chicago", nfcnorth, 2, 5);
			Team team22 = new Team("Lions", "Detroit", nfcnorth, 5, 2);
			Team team23 = new Team("Packers", "Green Bay", nfcnorth, 2, 4);
			Team team24 = new Team("Vikings", "Minnesota", nfcnorth, 2, 4);
			
			trepository.save(team21);
			trepository.save(team22);
			trepository.save(team23);
			trepository.save(team24);
			
			Team team25 = new Team("Falcons", "Atlanta", nfcsouth, 4, 3);
			Team team26 = new Team("Panthers", "Carolina", nfcsouth, 0, 6);
			Team team27 = new Team("Saints", "New Orleans", nfcsouth, 3, 4);
			Team team28 = new Team("Buccaneers", "Tampa Bay", nfcsouth, 3, 3);
			
			trepository.save(team25);
			trepository.save(team26);
			trepository.save(team27);
			trepository.save(team28);
			
			Team team29 = new Team("Cardinals", "Arizona", nfcwest, 1, 6);
			Team team30 = new Team("Rams", "Los Angeles", nfcwest, 3, 4);
			Team team31 = new Team("49ers", "San Francisco", nfcwest, 5, 1);
			Team team32 = new Team("Seahawks", "Seattle", nfcwest, 4, 2);
			
			trepository.save(team29);
			trepository.save(team30);
			trepository.save(team31);
			trepository.save(team32);
			
			System.out.println("nflDemo method is executed!");
		};
	}

}
