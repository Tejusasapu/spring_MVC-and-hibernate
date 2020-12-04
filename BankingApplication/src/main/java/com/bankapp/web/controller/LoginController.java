package com.bankapp.web.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.bankapp.web.formbeans.UserBean;

@Controller
public class LoginController {
	private UserService userService;

	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("login")
	public String login(ModelMap map) {
		map.addAttribute("userBean",new UserBean());
		return "login";
	}
	
	@PostMapping("login")
	public String loginPost(@ModelAttribute(name="userBean") UserBean user,HttpServletRequest req) {

		HttpSession session = req.getSession();
		String username = user.getUsername();
		String password = user.getPassword();
		User userDetails=userService.getUser(username, password);
		session.setAttribute("user", userDetails);
		boolean isValid = userService.verifyDetails(username, password);
		if (isValid) {
			return "redirect:/home";
		} else {
			return "redirect:/login";
		}
	}

}
	
	
