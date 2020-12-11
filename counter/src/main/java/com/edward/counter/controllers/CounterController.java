package com.edward.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {

	@RequestMapping("/")
	public String counter(HttpSession session, Model model) {
		Object sessionCount = session.getAttribute("count");
		if(sessionCount == null) {
			session.setAttribute("count", 0);
		}
		session.setAttribute("count", (Integer) session.getAttribute("count") + 1);
		model.addAttribute("count", session.getAttribute("count"));
		
		return "Counter.jsp";
	}
}
