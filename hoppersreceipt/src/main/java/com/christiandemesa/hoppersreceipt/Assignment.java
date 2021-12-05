package com.christiandemesa.hoppersreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// Imports Model
import org.springframework.ui.Model;

@Controller
public class Assignment {
        
    @RequestMapping("/")
    // Model is a container that stores data (e.g. key-value pairs) you pass to the views file (src/main/webapp/WEB-INF/index.jsp).
    public String index(Model model) {
        
        String name = "Grace Hopper";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Metal strips. Also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";
        
        // The values (e.g. itemName) match the variables above.
    	model.addAttribute("name", name);
    	model.addAttribute("item", itemName);
    	model.addAttribute("price", price);
    	model.addAttribute("description", description);
    	model.addAttribute("store", vendor);
    	
    	// Retrieves the entire views file.
        return "index.jsp";
        
    }

}