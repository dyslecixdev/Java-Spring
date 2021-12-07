package com.christiandemesa.ninjagoldgame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldGameController {
        
        @RequestMapping("/")
    	public String home(HttpSession session) {
        	Integer currentGold = (Integer) session.getAttribute("gold");
        	// If currentGold does not exist, set it to 0 and create an ArrayList for activities.
        	if(currentGold == null) {
        		session.setAttribute("gold", 0);
        		session.setAttribute("activities", new ArrayList<String>());
        		return "index.jsp";
        	}
        	// Redirects to a prison page.
        	else if(currentGold <= -100) {
        		return "prison.jsp";
        	}
        	// Otherwise redirect the main page.
        	else {
        		return "index.jsp";
        	}
    	}
        
        @RequestMapping("/gold")
        public String changeGold(@RequestParam(value="place") String place, HttpSession session) {
        	// Creates a random number.
        	Random randInt = new Random();
        	// Creates the current date and time.
        	Date currDate = new Date();
        	// Creates a format as MONTH day year hour:minute am/pm.
        	SimpleDateFormat formatter = new SimpleDateFormat("MMMMMMMMM dd yyyy hh:mm aa");
        	// Formats the current date ant time.
    		String formatDate = formatter.format(currDate);
    		// Creates an activities array to hold messages, and have it equal to the previous version of this array.
    		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
    		// "farm" comes from the hidden input type in index.jsp.
    		// .equals() compares two strings, and this will run if those strings are the same.
        	if("farm".equals(place)) {
        		int min = 10;
        		// Random number from 10 to 20.
        		int randGold = randInt.nextInt(11) + min;
        		// Sessions the original number ((Integer) session.getAttribute("gold")) plus the random number.
        		session.setAttribute("gold", (Integer) session.getAttribute("gold") + randGold);
        		// Adds a new message to the activities array.
        		activities.add(0, "You entered a farm and worked for " + randGold + " gold  (" + formatDate + ")");
        		// Sessions the new message.
        		session.setAttribute("activities", activities);
        	}
        	else if("cave".equals(place)) {
        		int min = 5;
        		int randGold = randInt.nextInt(6) + min;
        		session.setAttribute("gold", (Integer) session.getAttribute("gold") + randGold);
        		activities.add(0, "You entered a cave and found " + randGold + " gold  (" + formatDate + ")");
        		session.setAttribute("activities", activities);
        	}
        	else if("house".equals(place)) {
        		int min = 2;
        		int randGold = randInt.nextInt(4) + min;
        		session.setAttribute("gold", (Integer) session.getAttribute("gold") + randGold);
        		activities.add(0, "You entered a house and received " + randGold + " gold  (" + formatDate + ")");
        		session.setAttribute("activities", activities);
        	}
        	else if("casino".equals(place)){
        		int min = -50;
        		int randGold = randInt.nextInt(101) + min;
        		session.setAttribute("gold", (Integer) session.getAttribute("gold") + randGold);
        		if(randGold > 0) {
        			activities.add(0, "You entered a casino and won " + randGold + " gold  (" + formatDate + ")");
        		}
        		// Different message if you get a negative number.
        		else if(randGold < 0) {
        			activities.add(0, "You entered a casino and lost " + (randGold * -1) + " gold...Ouch  (" + formatDate + ")");
        		}
        		// Different message if you get 0.
        		else {
        			activities.add(0, "You entered a casino and broke even  (" + formatDate + ")");
        		}
        		session.setAttribute("activities", activities);
        	}
        	else {
        		int min = 5;
        		int randGold = (randInt.nextInt(16) + min) * -1;
        		session.setAttribute("gold", (Integer) session.getAttribute("gold") + randGold);
        		activities.add(0, "You entered a spa and spent " + (randGold * -1) + " gold  (" + formatDate + ")");
        		session.setAttribute("activities", activities);
        	}
        	// Redirects to @RequestMapping("/").
        	return "redirect:/";
        }
        
        @RequestMapping("/reset")
        public String reset(HttpSession session) {
        	// Removes the listed objects from the session.
        	session.removeAttribute("gold");
        	session.removeAttribute("activities");
        	return "redirect:/";
        }

}