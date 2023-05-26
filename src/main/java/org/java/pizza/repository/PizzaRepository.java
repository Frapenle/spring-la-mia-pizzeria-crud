package org.java.pizza.repository;

import org.java.pizza.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository <Pizza, Integer>{
	
}
