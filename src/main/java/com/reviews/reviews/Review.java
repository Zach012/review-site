package com.reviews.reviews;

public class Review {

	private Long id;
	private String name;
	private String description;
	private String category;
	private String image;

	public Review(long id, String name, String category, String description, String image) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.image = image;
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getImage() {
		return image;
	}

}
