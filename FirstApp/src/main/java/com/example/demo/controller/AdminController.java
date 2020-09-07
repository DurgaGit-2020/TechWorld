package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.service.AdminService;


@Controller
public class AdminController {

	@Autowired 
	AdminService adminService;
	
//	@RequestMapping("/home")
//	public String home() 
//	{
//		return "view";	
//	}

//	@PostMapping("/findAllDetails")
//	public List<Admin_User> findAllUsers(){
//		return adminService.getUserDetails();
//	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findAllDetails")
	public String index(ModelMap modelMap) {
		modelMap.put("adminuser", adminService.getUserDetails());
		return "view";
	}	
}
