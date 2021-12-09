package com.neosoft.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.neosoft.poc.entity.UserEntity;



@Service
public interface UserService {
	
	public UserEntity addUser(UserEntity userEntity);

	public UserEntity updateById(int userId,UserEntity userEntity);
	
	public Optional<UserEntity> findUserById(int userID);
	
//	public List<User> findByfirstNameOrlastNameOrpincode(String firstName,String lastName,String pincode);

	public List<UserEntity> findUserByName(String userName);
	
	public List<UserEntity> SortByDateofJoinAndDateofBirth();
	
	public String userSoftDelete(int userId);
	

}
