package com.hackathon.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="some_companys")
public class Some_company {
		
	 
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    
    @NotEmpty(message="Title is required!")
    @Size(min = 2, max = 25, message="Title must be between 2 and 25 characters" )
    private String name;
    
    
    @NotEmpty(message="Phone number is required!")
    @Size(min = 10, max = 10, message=" Phone number must be between 10 characters" )
    private String phone;
    
    
    @NotEmpty(message="Description is required!")
    @Size(min = 2, max = 500, message="Description must be between 2 and 20 characters" )
    private String description;
    
    
    
    @NotEmpty(message="Address is required!")
    @Size(min = 2, max =300 , message="Address must be between 2 and 500 characters" )
    private String address;
    
    @Lob
    private String img_path;
    
    @Lob
    private byte[] img;

  


    
//    Constructor
    public Some_company(){}





//  Getter & Setter
	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
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





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	




	public String getImg_path() {
		return img_path;
	}





	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}





	public byte[] getImg() {
		return img;
	}





	public void setImg(byte[] img) {
		this.img = img;
	}





	public String getPhone() {
		return phone;
	}





	public void setPhone(String phone) {
		this.phone = phone;
	}



    
    
}
