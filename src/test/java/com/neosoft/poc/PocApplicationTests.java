package com.neosoft.poc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import com.neosoft.poc.entity.UserEntity;
import com.neosoft.poc.repositary.UserRepository;
import com.neosoft.poc.service.UserService;

@SpringBootTest
class PocApplicationTests {
	@Mock
	UserRepository repo;

	UserEntity saveuser = null;

	@Autowired
	UserService service;

	@BeforeEach
	public void setUp() {
		saveuser = new UserEntity(1, "nanda", "yamba", "male", "Bangalore", "02-07-1995", "05-11-2020", "997898");
	}

	@Test
	@Description(value = "saveUserSet")
	void saveUserEntityTest() {
		when(repo.save(saveuser)).thenReturn(saveuser);
		assertEquals("nanda", service.addUser(saveuser).getUserName());

	}

	@Test
	@Description("Test getBy id Service")
	void getuserbyID() {

		when(repo.getById(1)).thenReturn(
				new UserEntity(1, "My name", "sure name", "Male", "banglore", "20-05-1996", "20-11-2021", "517291"));
		assertEquals(Optional.empty(), service.findUserById(1));
	}

	
	  @Test
	  @Description("Test getByUsername service") void getUserByName() {
		  List<UserEntity> userlist=new ArrayList<UserEntity>();
		  userlist.add( new UserEntity(1, "My name", "sure name", "Male", "banglore", "20-05-1996","20-11-2021", "517291"));
		  when(repo.getById(anyInt())).thenReturn(new UserEntity(1, "My name", "sure name", "Male", "banglore", "20-05-1996","20-11-2021", "517291"));
		  assertEquals("517291",service.findUserByName("nanda").get(0).getPincode());
	  }
	 

		
		  @Test
		  void UpdateUser() { 
			  UserEntity user = new UserEntity(10,"kishore","yamba","male","11-01-2004","11-01-2006","Banglore", "560035");
			  when(repo.save(user)).thenReturn(user);
				assertEquals("yamba", service.addUser(saveuser).getSurName());
			  
		  }
		 @Test
		  void DeleteUser() {
			  UserEntity user = new UserEntity(11,"kishore","yamba","male","11-01-2004","11-01-2006","Banglore", "560035");

			 repo.save(user);
			 assertEquals("user deleted ", service.userSoftDelete(11));
		  }

}
