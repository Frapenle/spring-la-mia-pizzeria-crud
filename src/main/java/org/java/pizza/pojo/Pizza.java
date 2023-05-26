package org.java.pizza.pojo;

import java.math.BigDecimal;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@NonNull
	private String name;
	private String description;
	private String imageUrl;
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
