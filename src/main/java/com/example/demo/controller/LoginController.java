package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.*;
import com.example.demo.repository.LoginRepository;
@Controller
public class LoginController {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@GetMapping("/loginpage")
	public String loginPage(Model model)
	{
		Login login=new Login();
		model.addAttribute("login",login);
		return "login";
		
	}
	
	
	@PostMapping("/userLogin")
	public String loginUser(@ModelAttribute("login") Login login)
	{
		String userId=login.getUserId();//admin
		String password=login.getPassword();//admin
		Optional<Login> userdata=loginRepository.findById(userId);
		if(login.getUserId().equals(userdata.get().getUserId())&&login.getPassword().equals(userdata.get().getPassword()))
		{
			return "redirect:/lists";
		}
		else
		{
			return "error";
		}
		
		
	}
	

}
