package com.hackathon.app.controller;


import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hackathon.app.models.Item;
import com.hackathon.app.models.LoginUser;
import com.hackathon.app.models.Order;
import com.hackathon.app.models.Some_company;
import com.hackathon.app.models.User;
import com.hackathon.app.services.ItemService;
import com.hackathon.app.services.OrderService;
import com.hackathon.app.services.Some_companyService;
import com.hackathon.app.services.UserService;




    
@Controller
public class UserController {

    @Autowired
    private UserService userServ;
    
    @Autowired
    private Some_companyService some_companyServ;

    @Autowired
    private ItemService itemServ;
    
    @Autowired
    private OrderService orderServ;
//    ------------------- Login and Registration ----------------
    @GetMapping("/logReg")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/";
    }
    
    @GetMapping("/login")
    public String logPage(Model model) {
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
    
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/";
	  }
//  -------------------------- Main Page | Dashboard ---------------------------
    @GetMapping("/")
	public String index(Model model, HttpSession session) {
    	User user;
    	Long id = (Long)session.getAttribute("user_id");	
    	if(id == null) {
    		user = null;
    	}else {
    		user = userServ.findUserById(id);
    	}
		
		 
		model.addAttribute("user", user);				
		return "dashboard.jsp";
    	
    	
	}
//	    -------------------------- Deserts ---------------------------
	    @GetMapping("/dersert")
		public String createDes(@ModelAttribute("some_company") Some_company some_company,HttpSession session,Model model) {

			User user;
	    	Long id = (Long)session.getAttribute("user_id");
			if(id == null) {
	    		user = null;
	    	}else {
	    		user = userServ.findUserById(id);
	    	}
			model.addAttribute("user", user);	
				return "desertForm.jsp";				    	
		}
		
		@PostMapping("/dersert")
		public String creatingDes(@Valid @ModelAttribute("some_company") Some_company some_company, BindingResult result,
				@RequestParam(value="report_image") MultipartFile report_image) throws IOException {	
			if(result.hasErrors()) {		
				return "desertForm.jsp";
			}
			
			String img_path = Base64.getEncoder().encodeToString(report_image.getBytes());		
			some_company.setImg_path(img_path);
			some_company.setImg(report_image.getBytes());
				Some_company temp = some_companyServ.createDes(some_company);		
//				return "redirect:/dersert/"+temp.getId();
				return "redirect:/success";		
		}
//		-------------------------- Deserts ---------------------------
//	    @GetMapping("/dersert/{id}")
//		public String postDes( Model model,
//				@PathVariable(value = "id") Long id) {
//			model.addAttribute("report",some_companyServ.findSomeById(id));
//				return "successDes.jsp";			
//			
//	
//	    	
//		}
//		-------------------------- Success Page ---------------------------
	
	    @GetMapping("/success")
		public String postDes() {
				return "successDes.jsp";			  	
		}
	    
	    @GetMapping("/success/donate")
		public String postDeonate() {
				return "successDonate.jsp";			  	
		}
//		-------------------------- Show Items ------------------------
		@GetMapping("/items")
		public String showItem( Model model,
				HttpSession session) {
			Long user_id = (Long)session.getAttribute("user_id");
			if(user_id != null) {
				User user = userServ.findUserById(user_id);
				model.addAttribute("user", user);
				model.addAttribute("allItems", itemServ.findAllItems());
				return "show.jsp";
			}
	    	else {
	    		return "redirect:/logReg";
	    	}
		}
		
		
	    @GetMapping("items/{id}")
	    public String profile( Model model , HttpSession session,@PathVariable("id") Long id){
	        Long user_id = (Long)session.getAttribute("user_id");
	        if(user_id != null) {
	            model.addAttribute("user", userServ.findUserById(user_id));
	            model.addAttribute("item", itemServ.findItemById(id));
	            return "moreInfo.jsp";
	        }else{
	            return "redirect:/logReg";
	        }
	    }
	    
//	-------------------------- Donaite ------------------------  

	    @PostMapping("/items/{id}/order")
	    public String order(HttpSession session, @PathVariable(value = "id") long id) {
	    	Long user_id = (Long)session.getAttribute("user_id");
	        if(user_id != null) {
	        
	    	Item temp = itemServ.findItemById(id);
	    	User user = userServ.findUserById(user_id);
	    	orderServ.createOrder(new Order(temp.getTitle() , temp.getPrice() , user.getUserName()));
	    	return "successDonate.jsp";
	        }
	     	return "redirect:/logReg";
	        }
	    	
//		-------------------------- About ------------------------  
	    @GetMapping("/about")
		public String about(Model model, HttpSession session) {
	    	User user;
	    	Long id = (Long)session.getAttribute("user_id");	
	    	if(id == null) {
	    		user = null;
	    	}else {
	    		user = userServ.findUserById(id);
	    	}
			
			 
			model.addAttribute("user", user);				
			return "about.jsp";
	    	
	    	
		}
	    	
//  -------------------------- Logout  ---------------------------
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user_id");
    	return "redirect:/logReg";
    }
    
}

