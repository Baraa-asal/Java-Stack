package com.display_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class displayController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date myDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy");
		String formattedDate = formatter.format(myDate);
		model.addAttribute("date", formattedDate);
		return "date.jsp";
	}
	

	@RequestMapping("/time")
	public String time(Model model) {
		Date myTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
		String formattedTime = formatter.format(myTime);
		model.addAttribute("time", formattedTime);
	
		return "time.jsp";
	}
	
}

