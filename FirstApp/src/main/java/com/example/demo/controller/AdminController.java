package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entity.Admin_User;
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
	
	//08-09-2020 task
		
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
		adminService.deleteProduct(id);   
        return "redirect:/findAllDetails";    
    }  
	
    @RequestMapping(value="/editemp/{id}")    
	public String edit(@PathVariable int id, Model m){    
    Admin_User admin=adminService.getProductById(id);
    m.addAttribute("command",admin);  
    return "edit";    
	}  
	 
	    /* It updates model object. */    
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)    
	 public String editsave(@ModelAttribute("admin") Admin_User admin){    
	 adminService.updateProduct(admin);    
	 return "redirect:/findAllDetails";    
	 }  
	 
//	 @RequestMapping("/")
//	    public String viewHomePage(Model model, @Param("keyword") String keyword) {
//	        List<Admin_User> listProducts = adminService.listAll(keyword);
//	        model.addAttribute("listProducts", listProducts);
//	        model.addAttribute("keyword", keyword);	         
//	        return "search";
//	    }
	 
//	   @RequestMapping(value="/viewHomePage",method=RequestMethod.GET)
//	    public String viewHomePage(ModelMap modelMap, @Param("keyword") String keyword,@Param("AccountStatus") String AccountStatus)
//	   {	   
//	        modelMap.put("listProducts", adminService.listAll(keyword));  	       
//	        return "view";
//	    }
	 
	 
	 @RequestMapping(value="/viewHomePage",method=RequestMethod.GET)
	    public String viewHomePage(ModelMap modelMap, @Param("keyword") String keyword,@Param("AccountStatus") String AccountStatus)
	   {	   
		 List<Admin_User> listProducts = adminService.listAll(keyword);
	        List<Admin_User>statusFilteredList = new ArrayList<>();
	       
	        listProducts.stream().forEach(action->{
	        	if(action.getAccountStatus().equals(AccountStatus)) {
	        		statusFilteredList.add(action);
	        	}
	        });
	        if(statusFilteredList.isEmpty()) {
	        	modelMap.put("listProducts", listProducts);
	        }
	        else {
	        	modelMap.put("listProducts", statusFilteredList);
	        }
	        System.out.println(modelMap);
	        return "view";
	    }
	 
	   @RequestMapping("/ClearData")
		public String clearData() {
		   return "redirect:/findAllDetails"; 
		} 
	     	   
	    @Value("${app.name}")
	    private String name;
	    
	    @Value("${button.search}")
	    private String search;
	    
	    @Value("${userid.name}")
	    private String userid;
	    
	    @Value("${fname.name}")
	    private String fname;
	    
	    @Value("${mname.name}")
	    private String mname;
	    
	    @Value("${lname.name}")
	    private String lname;
	    
	    @Value("${accessdetails.name}")
	    private String accessdetails;
	    
	    @Value("${accountstatus.name}")
	    private String accountstatus;
	    
	    @Value("${edit.name}")
	    private String edit;
	    
	    @Value("${delete.name}")
	    private String delete;
	    
	    @Value("${category.name}")
	    private String category;

	    @Value("${completed.name}")
	    private String completed;

	    @Value("${active.name}")
	    private String active;

	    @Value("${pending.name")
	    private String pending;

	    @Value("${locked.name}")
	    private String locked;
	    
	    @Value("${showall.name}")
	    private String showall;
	    
	    public String home(ModelMap map){
	        map.addAttribute("var2", name);	  
	        map.addAttribute("search", search);	
	        map.addAttribute("userid", userid);
	        map.addAttribute("fname", fname);
	        map.addAttribute("mname", mname);
	        map.addAttribute("lname", lname);
	        map.addAttribute("accessdetails", accessdetails);
	        map.addAttribute("accountstatus", accountstatus);
	        map.addAttribute("edit", edit);
	        map.addAttribute("category", category);
	        map.addAttribute("completed", completed);
	        map.addAttribute("active", active);
	        map.addAttribute("pending", pending);
	        map.addAttribute("locked", locked);
	        map.addAttribute("showall", showall);
	        return "view";
	    }
	   
}
