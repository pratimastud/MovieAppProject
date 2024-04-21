package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.UserRepository;
import com.example.demo.model.*;
import java.util.*;
@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/index.html")
	public String Images()
	{
		return "index.html";
	}
	
	@GetMapping("/lists")
	public ModelAndView showUsers()
	{
		ModelAndView mav=new ModelAndView("list-users");
		List<User> list=userRepository.findAll();
		mav.addObject("users",list);
		
		return mav;
		
	}
	
	@GetMapping("/addform")
	public String showFormModel(Model model)
	{
		User newuser=new User();
		model.addAttribute("user",newuser);
		List<String> movielist=Arrays.asList("Movie1","Movie2","Movie3");
		model.addAttribute("movielist",movielist);
		return "adduserform";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user)
	{
		userRepository.save(user);
		return "redirect:/lists";
		
	}
	
	
	
	@GetMapping("/deleteUser")
	public String deleteStudent(@RequestParam Long userId)
	{
		userRepository.deleteById(userId);
		return "redirect:/lists";
		
	}
	
	@GetMapping("/viewUser")
	public ModelAndView showStudentById(@RequestParam Long userId)
	{
		ModelAndView mav=new ModelAndView("oneuser");
	User user=userRepository.findById(userId).get();
	mav.addObject("user",user);
	return mav;
	}
	
	
    
}
