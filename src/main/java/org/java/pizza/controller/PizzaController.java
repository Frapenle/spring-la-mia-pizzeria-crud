package org.java.pizza.controller;

import java.util.List;
import java.util.Optional;

import org.java.pizza.pojo.Pizza;
import org.java.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzaController {
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		List<Pizza> pizze = pizzaService.findAll();
		model.addAttribute("pizze", pizze);
		return "index";
	}
//	SHOW
	@GetMapping("/pizza/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		Optional<Pizza> optionalPizza = pizzaService.findById(id);
		Pizza pizza = optionalPizza.get();
		model.addAttribute("pizza", pizza);
		return "pizza";
	}
	
	@PostMapping("/pizze")
	public String getPizzaByName(Model model, @RequestParam(required = false) String name) {
		List<Pizza> pizze = pizzaService.findByName(name);
		System.err.println(pizze);
		model.addAttribute("pizze", pizze);
		model.addAttribute("name", name);
		return "index";
	}
	
//	CREATE
	@GetMapping("/pizze/create")
	public String createPizza(Model model) {
		return "create";
	}
	
	@PostMapping("/pizze/create")
	public String storePizza(@ModelAttribute Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}

}
