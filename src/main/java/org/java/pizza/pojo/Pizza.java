package org.java.pizza.pojo;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.URL;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@NonNull
//	@NotBlank(message = "Il nome non può essere vuoto.")
	@Size(min = 2, max = 20, message = "Il nome deve avere almeno 2 caratteri e massimo 20.")
	private String name;
	@NotBlank(message = "La descrizione non può essere vuota.")
	@Size(min = 5, max = 100, message = "La descrizione deve avere almeno almeno 5 caratteri e massimo 100.")
	private String description;
	@NotBlank(message = "Inserisci un url valido.")
	@URL(message = "Url non valido.")
	private String imageUrl;
	@NotNull(message = "Inserisci un numero.")
	@PositiveOrZero(message = "Il numero deve essere positivo.")
	@Max(value = 1000, message = "Non è possibile inserire un numero maggiore di 1000.")
	private BigDecimal price;
	
	public Pizza() {};
	
	public Pizza(String name, String description, String imageUrl, BigDecimal price) {
		setName(name);
		setDescription(description);
		setImageUrl(imageUrl);
		setPrice(price);
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Id: " + getId()
				+ "\nName: " + getName()
				+ "\nDescription: " + getDescription()
				+ "\n:Price " + getPrice()
				+ "\nImage: " + getImageUrl();
	}

}
