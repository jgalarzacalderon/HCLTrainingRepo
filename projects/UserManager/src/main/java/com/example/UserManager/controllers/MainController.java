package com.example.UserManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class MainController {
	
	 @GetMapping(value="/")
	 // value="dog" is irrelevant to the code of the program. All it does is append to the URL
	 // example landing URL localhost:8090/. When @RequestParam is used with the value= tag it will set URL to:
	 // localhost:8090:/?id="String variable that equals the 'String name' parameter". 
	 
	 // In model.addAttribute("id", name) the "Name" parameter maps to the reference of ${id}
	 // in the JSP. This is how the servlet knows to pass the String "name" to the variable ${id}
	 
	 // The return "index" then returns the index.jsp page but maps the attribute "id" with the 
	 // value matching in the URL. Example: entering "localhost:8090/?dog=John" will cause the servlet
	 // to pass the String "John" to the attribute "id" which will be passed to the index.jsp 
	 // variable ${id} causing the web page to display "Hello John!" instead of the defaultValue of "World"
	 
	 // required=false and defaultValue are not required but helpful. 
     public String showIndexPage(ModelMap model, 
    		 @RequestParam(value="dog", required=false, defaultValue="World") String name){
	     model.addAttribute("id", name);    
		 return "index";
     }

}
