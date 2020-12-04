package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entities.User;
import com.bankapp.model.service.UserService;
import com.bankapp.web.formbeans.AddUserBean;

@Controller
public class UserManagementController {
	
	private UserService userService;
	
	@Autowired
	public UserManagementController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("showallusers")
	public ModelAndView showAllAccounts(ModelAndView mv) {
		mv.setViewName("showallusers");
		mv.addObject("users", userService.getAllUsers());
		return mv;
	}
		
	@GetMapping("addusers")
	public String addUserGet(ModelMap mv) {
		mv.addAttribute("addUserBean", new AddUserBean());
		return "addusers";
		
	}
	@PostMapping("addusers")
	public String addUserPost(@Valid @ModelAttribute(name="addUserBean") AddUserBean addUserBean,BindingResult result ) {
		if(result.hasErrors()) {
			return "addusers";
		}else {
		int id=addUserBean.getuId();
		User user=new User(addUserBean.getUsername(), addUserBean.getPassword(), addUserBean.getRoles(),addUserBean.getAddress(), addUserBean.getPhone(),
				addUserBean.getEmail());
			userService.addUser(user);
			return "redirect:/home";	
	}
	}
	@GetMapping("updateuser")
	public String updateUserGet(ModelMap mv,HttpServletRequest request) {
		int id=Integer.parseInt(request.getParameter("id"));
		AddUserBean user=new AddUserBean();
		user.setuId(id);
		mv.addAttribute("updateUsertBean", user);
		return "updateuser";
		
	}
	
	@PostMapping("updateuser")
	public String updateUserPost(@Valid @ModelAttribute(name="updateUsertBean") AddUserBean updateUsertBean,BindingResult result ) {
		if(result.hasErrors()) {
			return "updateuser";
		}else {
		int id=updateUsertBean.getuId();
		 User update_user=userService.getUserById(id);
		 update_user.setRoles(updateUsertBean.getRoles());
		 update_user.setAddress(updateUsertBean.getAddress());
		 userService.updateUser(update_user);
		 return "redirect:/home";	
	}
	
	}
	@GetMapping("deleteuser")
	public String deleteUser(HttpServletRequest request) {
		int id=Integer.parseInt(request.getParameter("id"));
		userService.deleteUser(id);
		return "redirect:/showallusers";
	}


	
	
	
}
