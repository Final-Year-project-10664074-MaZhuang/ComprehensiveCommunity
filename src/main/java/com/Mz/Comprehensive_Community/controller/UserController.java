/**
 * 
 */
package com.Mz.Comprehensive_Community.controller;

import com.Mz.Comprehensive_Community.domain.User;
import com.Mz.Comprehensive_Community.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


/**
 * @author 26862
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ModelAndView list(Model model) {
		model.addAttribute("userList", userRepository.findAll());
		model.addAttribute("title", "User Management");
		return new ModelAndView("users/list","userModel",model);
	}
	
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id, Model model) {
		User user = userRepository.findById(id).orElse(null);
		model.addAttribute("user", user);
		model.addAttribute("title", "View User");
		return new ModelAndView("users/view","userModel",model);
	}
	
	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User(null,null,null));
		model.addAttribute("title", "Create User");
		return new ModelAndView("users/form","userModel",model);
	}
	
	@PostMapping
	public ModelAndView saveOrUpdateUser(User user) {
		userRepository.save(user);
		return new ModelAndView("redirect:/users");
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
		return new ModelAndView("redirect:/users");
	}
	
	@GetMapping("/modify/{id}")
	public ModelAndView modify(@PathVariable("id") Long id,Model model) {
		User user = userRepository.findById(id).orElse(null);
		model.addAttribute("user", user);
		model.addAttribute("title", "Modify User");
		return new ModelAndView("users/form","userModel",model);
	}
}
