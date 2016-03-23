package io.cj555.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.cj555.service.ItemService;


@Controller
public class IndexController {
	
	@Autowired
	private ItemService itemServie;

	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("items", itemServie.getItems());
		return "index";
	}
	
}
