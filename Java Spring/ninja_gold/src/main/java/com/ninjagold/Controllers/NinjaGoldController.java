package com.ninjagold.Controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NinjaGoldController {
	Integer golds=0;
	ArrayList<String> activities = new ArrayList<>(); 
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
//		HashMap map = new HashMap();
//		map.put("golds", golds);
//		map.put("activities", activities);
//		model.addAllAttributes(map);
		
		model.addAttribute("golds", golds);
		model.addAttribute("activities", activities);
		return "index.jsp";
	}
	
	@RequestMapping(value="/addGolds", method = RequestMethod.POST)
	public String countGolds(@RequestParam(value="building") String building,
							HttpSession session,
							Model model) {
		Random num = new Random();		
		System.out.println(!building.equals("quest"));
		if (!building.equals("quest")) {
			int randomGolds = num.nextInt(10, 20);
			activities.add(earnGoldActivity(building, randomGolds));
			golds += randomGolds;
			return "redirect:/";
		}
		int randomGolds = num.nextInt(-50, 50);
		activities.add(questActivity(randomGolds));
		golds += randomGolds;
		return "redirect:/";
	}
	private String earnGoldActivity(String building, int randomGolds) {
		return "You entered a" + building + "and earned" + randomGolds ;
	}
	private String questActivity(int randomGolds) {
		if (randomGolds < 0) {
			return "You entered a quest and lost "  + randomGolds ;
		}
		return "You entered a quest and earned "  + randomGolds ;
	}
}
