package com.daikichi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("")
	public String index() {
		return "Welcome!";
	}
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will rise, so be sure to be open to new ideas!";
	}
	@RequestMapping("/{what}/{where}")
    public String showLesson(@PathVariable("what") String what, @PathVariable("where") String where){
    	return "Congratulations! You will soon " + what + " to " + where + "!";
    }
	@RequestMapping("/{name}/{number}/{times}")
    public String waterTracker(@PathVariable("name") String userName, @PathVariable("number") int waterBottles, @PathVariable("times") int times){
	   	String welcome = "";
		for(int i = 0; i<times; i+=1) {
			if (waterBottles>=3) {
			welcome += "Welcome " + userName + " to your Water Tracker! Today you drank: " + waterBottles + " bottles of water.<br>" + "GREAT JOOOOB!!<br>";
			}
			else {
			welcome += "Welcome " + userName + " to your Water Tracker! Today you drank: " + waterBottles + " bottles of water.<br>" + "YOU SHOULD DRINK MORE";
			}
    	}
		return welcome;
    }
	
	
	@RequestMapping("/lotto/{number}")
    public String lotto(@PathVariable("number") int number) {
		if (number % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
    }
	
}


















