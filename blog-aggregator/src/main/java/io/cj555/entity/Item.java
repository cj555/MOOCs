package io.cj555.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Item {

	private String title;
	private String description;
	
	private Date publishedData;
	private String link;
	
	
	
}
