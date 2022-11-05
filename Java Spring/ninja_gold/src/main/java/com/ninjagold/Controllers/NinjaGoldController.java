package com.ninjagold.Controllers;
import java.util.Random;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NinjaGoldController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		return "index.jsp";
	}
	
	@RequestMapping(value="/addGolds", method = RequestMethod.POST)
	public String countGolds(@RequestParam(value="building") String building,
							HttpSession session,
							Model model) {
		Integer golds=0;
		Random num = new Random();		
		
		if (building != "quest") {
			int randomGolds = num.nextInt(10);
			golds += randomGolds;
			return "redirect:/";
		}
		int randomGolds = num.nextInt(-50, 50);
		golds += randomGolds;
		return "redirect:/";
		
	}
}
