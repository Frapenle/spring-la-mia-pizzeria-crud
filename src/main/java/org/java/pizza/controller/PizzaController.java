package org.java.pizza.controller;

import java.util.List;
import java.util.Optional;

import org.java.pizza.pojo.Pizza;
import org.java.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("/pizza/{id}")
	public String getPizza(Model model, @PathVariable("id") Integer id) {
		Optional<Pizza> optionalPizza = pizzaService.findById(id);
		Pizza pizza = optionalPizza.get();
		model.addAttribute("pizza", pizza);
		return "pizza";
	}

}
