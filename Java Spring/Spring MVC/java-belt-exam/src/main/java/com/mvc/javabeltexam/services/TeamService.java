package com.mvc.javabeltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.javabeltexam.models.Team;
import com.mvc.javabeltexam.models.User;
import com.mvc.javabeltexam.repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	TeamRepository teamRepo;
	@Autowired
	UserService userService;

	//CREATE: 
	public Team create(Team team) {
		return teamRepo.save(team);
	}

	//READ:
	public List<Team> retrieveAll() {
		return this.teamRepo.findAll();
	}

	public Team retrieveTeam(Long id) {
		Optional<Team> optTeam = teamRepo.findById(id);
		if (optTeam.isPresent()) {
			Team team = optTeam.get();
			return team;
		}
		return null;
	}
	
	//UPDATE:
	public Team updateTeam(Team team) {
		Optional<Team> optTeam = teamRepo.findById(team.getId());
		if (optTeam.isPresent()) {
			return teamRepo.save(team);
		}
		return null;

	}
	
	//DELETE:
	public void deleteTeam(Long id) {
		teamRepo.deleteById(id);
	}
	
	//FIND BY ID:
	public Optional<Team> findById(Long id) {
		return teamRepo.findById(id);
	}
	
	//wtf was i doing here?
//	public void addPlayerToTeam(Long userId, Team team) {
//		User teamPlayer = userService.retrieveUserById(userId);
//		List<Team> players = teamPlayer.getTeamList();
//		players.add(team);
//		teamPlayer.setTeams(players);
//		userService.save(teamPlayer);
//		teamRepo.save(team);
//	}
	
//	public List <Team> playerTeams(Long userId){
//		User user = userService.retrieveUserById(userId);
//		return teamRepo.findAllByTeam(user);
//	}
	
//	public List<Team> availablePlayers(Long userId) {
//		User user = userService.retrieveUserById(userId);
//		return teamRepo.findByTeamNotContains(user);
//	}
}