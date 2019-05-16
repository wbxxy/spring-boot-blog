package com.wbx.controller;

import java.util.List;

import com.wbx.domain.User;
import com.wbx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * 用户控制器
 */
@RestController
@RequestMapping("/users")
@EnableAutoConfiguration
public class UserController {
	
	@Autowired 
	private IUserService iUserService;


	/**
	 * 查询所用用户
	 * @return
	 */
	@GetMapping
	public ModelAndView list(Model model) {
        model.addAttribute("userList", iUserService.findAll());
		model.addAttribute("title", "用户管理");
        System.out.println(iUserService.findAll());
		return new ModelAndView("users/list", "userModel", model);
	}
 

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") int id, Model model) {
		User user = iUserService.findById(id);
		model.addAttribute("user", user);
		model.addAttribute("title", "查看用户");
		return new ModelAndView("users/view", "userModel", model);
	}


	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "创建用户");
		return new ModelAndView("users/form", "userModel", model);
	}

//	@PostMapping
//	public ModelAndView create(User user) {
// 		user = userRepository.saveOrUpateUser(user);
//		return new ModelAndView("redirect:/users");
//	}

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
//	@GetMapping(value = "delete/{id}")
//	public ModelAndView delete(@PathVariable("id") Long id, Model model) {
//		userRepository.deleteUser(id);
//
//		model.addAttribute("userList", getUserlist());
//		model.addAttribute("title", "删除用户");
//		return new ModelAndView("users/list", "userModel", model);
//	}

//
//	@GetMapping(value = "modify/{id}")
//	public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
//		User user = userRepository.getUserById(id);
//
//		model.addAttribute("user", user);
//		model.addAttribute("title", "修改用户");
//		return new ModelAndView("users/form", "userModel", model);
//	}

}
