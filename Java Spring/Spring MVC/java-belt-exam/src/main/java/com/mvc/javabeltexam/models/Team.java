package com.mvc.javabeltexam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="teams")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="Team Name is required!")
    @Size(min=3, max=30, message="Team Name must be between 3 and 30 characters")
	private String teamName;

	@NotNull
	@Min(value=1, message="Min 1, Max 5!")
	@Max(value=5, message="Min 1, Max 5!")
	private double skillLevel;
	
	@NotNull(message="Game Day is required!")
    @Size(min=3, max=30, message="Team Name must be between 3 and 10 characters")
	private String gameDay;
	
	///////////////Connecting team to user, many teams for one user/////////////////
	//many-to-one relationship:
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name="user_id" )
	private User user;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_teams", 
        joinColumns = @JoinColumn(name = "team_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
	
    private List<User> users;
	
	//---------------------added on sunday 20-nove
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Column(updatable=false)		
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate()	{
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Team() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public double getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(double skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getGameDay() {
		return gameDay;
	}

	public void setGameDay(String gameDay) {
		this.gameDay = gameDay;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}