package com.hackathon.app.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="items")
public class Item {


		 
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

	    
	    @NotEmpty(message="Title is required!")
	    @Size(min = 2, max = 100, message="Title must be between 2 and 20 characters" )
	    private String title;
	    
	    @NotEmpty(message="Description is required!")
	    @Size(min = 2, max = 500, message="Description must be between 2 and 20 characters" )
	    private String description;
	    
	    
	    private String img;
	    
	    @NotEmpty(message="price is required!")
	    @Size(min = 2, max = 5, message="price must be between 2 and 5 characters" )
	    private String price;
	    
	    
	    @NotEmpty(message="price is required!")
	    @Size(min = 2, max = 5, message="price must be between 2 and 5 characters" )
	    private String targetPrice;
	    
	    @ManyToOne(fetch= FetchType.LAZY)
		@JoinColumn(name="user_id")
		private User user;

	   
	
	    
//	    Constructor
	    public Item(){}



//	    Getter & Setter
		public Long getId() {
			return id;
		}




		public void setId(Long id) {
			this.id = id;
		}




		public String getTitle() {
			return title;
		}




		public void setTitle(String title) {
			this.title = title;
		}




		public String getDescription() {
			return description;
		}




		public void setDescription(String description) {
			this.description = description;
		}




		public String getImg() {
			return img;
		}




		public void setImg(String img) {
			this.img = img;
		}




		public User getUser() {
			return user;
		}




		public void setUser(User user) {
			this.user = user;
		}



		public String getPrice() {
			return price;
		}



		public void setPrice(String price) {
			this.price = price;
		}



		public String getTargetPrice() {
			return targetPrice;
		}



		public void setTargetPrice(String targetPrice) {
			this.targetPrice = targetPrice;
		}




	    
	    
}
	

