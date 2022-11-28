package com.mvc.javabeltexam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.javabeltexam.models.LoginUser;
import com.mvc.javabeltexam.models.Team;
import com.mvc.javabeltexam.models.User;
import com.mvc.javabeltexam.repositories.TeamRepository;
import com.mvc.javabeltexam.services.TeamService;
import com.mvc.javabeltexam.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private TeamRepository teamRepo;

	@GetMapping("/")
	public String index(Model model, HttpSession session) {

		if (session.getAttribute("user_id") != null) {
			return "redirect:/home";
		}
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

	@GetMapping("/home")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			User loggedInUser = userService.retrieveUserById((Long) session.getAttribute("user_id"));
			model.addAttribute("loggedInUser", loggedInUser);
			// for viewing the teams in the main page:
			List<Team> teamList = teamService.retrieveAll();
			model.addAttribute("teamList", teamList);
			model.addAttribute("userId", (Long) session.getAttribute("user_id"));
			return "dashboard.jsp";
		}
		return "redirect:/";
	}

	// REGISTER NEW USER:
	@PutMapping("/")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		userService.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		// storing the registered user id in session (so it loggs in directly):
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/home";
	}

	// LOGIN TO AN EXISTING USER:
	@PostMapping("/")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User user = userService.login(newLogin, result);
		if (result.hasErrors()) {
			// sending the logged in user to the jsp file if has errors:
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		// if no errors: storing the logged in user id in session, and log in to the
		// dashboard:
		session.setAttribute("user_id", user.getId());
		return "redirect:/home";
	}

	// LOG OUT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

/////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////// ------methods start from here after LogReg------  //////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////

	// method to render the form of adding new team.
	@GetMapping("/teams/new")
	public String newTeamForm(@ModelAttribute("newTeam") Team newTeam, Model model, HttpSession session) {
		User loggedInUser = userService.retrieveUserById((Long) session.getAttribute("user_id"));
		model.addAttribute("loggedInUser", loggedInUser);
		return "newTeam.jsp";
	}

	// it reaches this method after i click on submit of adding new team (create
	// team in data base)
	@PostMapping("/teams/new/")
	public String createTeam(@Valid @ModelAttribute("newTeam") Team newTeam, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("newTeam", newTeam);
			return "newTeam.jsp";
		}
		teamService.create(newTeam);
		return "redirect:/home";
	}

	// **** GET: Render team information **************************
	@GetMapping("/teams/{id}")
	public String teamDetails(@PathVariable("id") Long teamID, Model model, HttpSession session) {
		// ---- Check if User is Logged In -----------------------
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		// ---- Get the LoggedIn User -------------------------------
		User loggedInUser = this.userService.retrieveUserById((Long) session.getAttribute("user_id"));
		model.addAttribute("loggedInUser", loggedInUser);
		// ---- Get Team specified by ID --------------------------
		Team team = this.teamService.retrieveTeam(teamID);
		model.addAttribute("userId", (Long) session.getAttribute("user_id"));
		model.addAttribute("team", team);
		model.addAttribute("players_list", team.getUsers());
		model.addAttribute("playersAvailable",
				userService.getUsersNotOfTeam(teamService.retrieveTeam(teamID)));
		return "teamDetails.jsp";
	}

	// ******************* UPDATE AND DELETE *******************

	// **** GET: Render Edit Form *****
	@GetMapping("/teams/{id}/edit")
	public String teamsEdit(@PathVariable("id") Long teamID, Model model, HttpSession session) {
		// ---- Check if User is Logged In -----------------------
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		// ---- Get the Logged In User -------------------------------
		User loggedInUser = this.userService.retrieveUserById((Long) session.getAttribute("user_id"));
		model.addAttribute("loggedInUser", loggedInUser);
		// ---- Get Team specified by ID --------------------------
		Team oldTeam = this.teamService.retrieveTeam(teamID);
		model.addAttribute("oldTeam", oldTeam);
		return "teamsidedit.jsp";
	}

	// **** PUT: Update Old Team on database *************************
	@PutMapping("/teams/{id}/edit")
	public String updateTeamInfo(@Valid @ModelAttribute("oldTeam") Team oldTeam, BindingResult result,
			@PathVariable("id") Long teamID, Model model, HttpSession session) {
		// ---- Check if User is Logged In ------------------------
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		// ---- Get the Log In User --------------------------------
		User loggedInUser = this.userService.retrieveUserById((Long) session.getAttribute("user_id"));
		model.addAttribute("loggedInUser", loggedInUser);
		oldTeam.setUser(loggedInUser);
		if (result.hasErrors()) {
			return "teamsidedit.jsp";
		} else {
			this.teamService.updateTeam(oldTeam);
			return "redirect:/teams/" + oldTeam.getId();
		}
	}


	@DeleteMapping("/teams/{id}/delete")
	public String deleteTeam(@PathVariable("id") Long teamID, Model model) {
		this.teamService.deleteTeam(teamID);
		return "redirect:/home";
	}
	
	
	// Add a player to team
	@PostMapping("teams/{id}")
	public String addPlayerToTeam(@RequestParam("selectedPlayer") Long selectedPlayerID,
			@PathVariable("id") Long teamID) {
		Team thisTeam = teamService.retrieveTeam(teamID);
		User thisPlayer = userService.retrieveUserById(selectedPlayerID);
		List<User> playersList = thisTeam.getUsers();
		playersList.add(thisPlayer);
		thisTeam.setUsers(playersList);
		teamService.updateTeam(thisTeam);
		return "redirect:/teams/" + teamID;
	}

}
