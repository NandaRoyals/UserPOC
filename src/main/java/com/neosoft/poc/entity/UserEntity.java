package com.neosoft.poc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


/*@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter*/
@Entity
@Table(name = "User")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@NotBlank(message = "Please enter name")
	@Size(min=4, message = "Name should be atleast 4 characters")
	private String userName;
	
	@NotBlank(message = "Please enter Surname")
	@Size(min=4, message = "Name should be atleast 4 characters")
	private String surName;
	
	@NotBlank(message = "Please enter gender")
	@Size(min=4, message = "Gender should be atleast 4 characters")
	private String gender;
	
	private String address;
	@NotBlank(message = "Please enter Date of Birth")
	@JsonFormat(pattern = "dd-mm-yyyy", shape = Shape.STRING)
	private String dateofBirth;
	@NotBlank(message = "Please enter Date of Joining")
	@JsonFormat(pattern = "dd-mm-yyyy", shape = Shape.STRING)
	private String dateOfJoining;
	
	@NotBlank(message = "Please enter Pincode")
	@Pattern(regexp = "^([0-9]{4}|[0-9]{6})$")
	 private String  pincode;
	
	public UserEntity() {
		
	}

	public UserEntity(int userId,
			@NotBlank(message = "Please enter name") @Size(min = 4, message = "Name should be atleast 4 characters") String userName,
			@NotBlank(message = "Please enter Surname") @Size(min = 4, message = "Name should be atleast 4 characters") String surName,
			@NotBlank(message = "Please enter gender") @Size(min = 4, message = "Gender should be atleast 4 characters") String gender,
			String address, @NotBlank(message = "Please enter Date of Birth") String dateofBirth,
			@NotBlank(message = "Please enter Date of Joining") String dateOfJoining,
			@NotBlank(message = "Please enter Pincode") @Pattern(regexp = "^([0-9]{4}|[0-9]{6})$") String pincode) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.surName = surName;
		this.gender = gender;
		this.address = address;
		this.dateofBirth = dateofBirth;
		this.dateOfJoining = dateOfJoining;
		this.pincode = pincode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getPincode() {
		return pincode;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", surName=" + surName + ", gender=" + gender
				+ ", address=" + address + ", dateofBirth=" + dateofBirth + ", dateOfJoining=" + dateOfJoining
				+ ", pincode=" + pincode + "]";
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	

}
