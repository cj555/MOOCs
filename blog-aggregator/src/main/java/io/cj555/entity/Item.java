package io.cj555.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String title;
	private String description;
	
	private Date publishedData;
	private String link;
	
	
	
}
