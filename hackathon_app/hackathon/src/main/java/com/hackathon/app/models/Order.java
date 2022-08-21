package com.hackathon.app.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

	 	
		private String itemName;
		
		private String itemPrice;
		
		private String userName;


		public Order() {
			
		}
		


		public Order( String itemName, String itemPrice, String userName) {
			
			
			this.itemName = itemName;
			this.itemPrice = itemPrice;
			this.userName = userName;
		}



		public String getItemName() {
			return itemName;
		}


		public void setItemName(String itemName) {
			this.itemName = itemName;
		}


		public String getItemPrice() {
			return itemPrice;
		}


		public void setItemPrice(String itemPrice) {
			this.itemPrice = itemPrice;
		}


		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}
			
}
