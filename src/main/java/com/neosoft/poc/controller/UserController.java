package com.neosoft.poc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.poc.entity.UserEntity;
import com.neosoft.poc.service.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired(required = true)
	UserService userService;
	@PostMapping(path="/newUser")
	public UserEntity saveUser(@RequestBody UserEntity userEntity) { 
		return userService.addUser(userEntity);
	}
	
	@GetMapping("getById/{id}")
	public Optional<UserEntity> getUserById(@PathVariable("id") int userId) {
		return userService.findUserById(userId);
	}
	
	
	@PostMapping("Updateuser/{id}")
	public UserEntity UpdateUser(@PathVariable("id") int userId, @Valid @RequestBody UserEntity userEntity) {
		return userService.updateById(userId, userEntity);
	}

//	@GetMapping("getUser/{values}")
//	public List<User> fetchBylastNameOrpinCodeOrfirstName(@PathVariable("values") String firstName,
//			@PathVariable("values") String lastName,@PathVariable("values") String pincode){
//		return userservice.findByfirstNameOrlastNameOrpincode(name, SurName, pincode);
//	}
	
	@GetMapping("getByName/{name}")
	public List<UserEntity> getUseByName(@PathVariable("name") String name) {
		return userService.findUserByName(name);
	}
	
	@GetMapping("/getAllUser")
	public List<UserEntity> SortByDateofJoinAndDateofBirth(){
		return userService.SortByDateofJoinAndDateofBirth();
	}
	@DeleteMapping("softDelete/{id}")
	public String softDeleteUser(@PathVariable("id") int userId) {
		
		return userService.userSoftDelete(userId);
	}


}
