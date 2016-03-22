package io.cj555.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.cj555.entity.Blog;
import io.cj555.entity.User;
import io.cj555.service.BlogService;
import io.cj555.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BlogService blogService;

	@ModelAttribute("user")
	public User construct() {

		return new User();
	}

	@ModelAttribute("blog")
	public Blog constructblog() {
		return new Blog();
	}

	@RequestMapping("users")
	public String users(Model model) {

		model.addAttribute("users", userService.findAll());
		return "users";

	}

	@RequestMapping("users/remove/{id}")
	public String removeUser(@PathVariable int id) {

		userService.delete(id);
		return ("redirect:/users.html");

	}

	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id) {

		model.addAttribute("user", userService.findOneWithBlogs(id));

		return "user-detail";

	}

	@RequestMapping("/register")
	public String showRegister() {
		return "user-register";

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			return "user-register";

		}

		userService.save(user);

		return "redirect:/register.html?success=true";

	}

	@RequestMapping(value = "/account")
	public String account(Model model, Principal principal) {

		String name = principal.getName();

		model.addAttribute("user", userService.findOneWithName(name));
		
		return "account";

	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String doAddBlog(Model model, @Valid @ModelAttribute("blog") Blog blog, BindingResult result,
			Principal principal) {
		if (result.hasErrors()) {
			return account(model, principal);
		}
		String name = principal.getName();
		blogService.saveBlog(blog, name);
		return "redirect:/account.html";

	}

	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id) {
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account.html";

	}

}
