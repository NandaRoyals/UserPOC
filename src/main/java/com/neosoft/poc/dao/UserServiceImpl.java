package com.neosoft.poc.dao;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.neosoft.poc.entity.UserEntity;
import com.neosoft.poc.repositary.UserRepository;
import com.neosoft.poc.service.UserService;

@Service
@Component
public class UserServiceImpl implements UserService{
	@Autowired(required = true)
	private UserRepository repository;

	// register new user with so many field along with validation
	@Override
	public UserEntity addUser(UserEntity userEntity) {
		return repository.save(userEntity);
	}

	// update or Edit User base on user id
	@Override
	public UserEntity updateById(int UserId, UserEntity userEntity) {
		UserEntity userdb = repository.findById(UserId).get();
		if (userdb != null) {
			userdb.setUserName(userEntity.getUserName());
			userdb.setGender(userEntity.getGender());
			userdb.setDateOfJoining(userEntity.getDateOfJoining());
			userdb.setDateofBirth(userEntity.getDateofBirth());
			userdb.setAddress(userEntity.getAddress());
			userdb.setPincode(userEntity.getPincode());
		}

		return repository.save(userdb);
	}

//	//Search User by Name or Surname or Pincode 
//	@Override
//	public List<User> findByfirstNameOrlastNameOrpincode(String Name, String surName, String pincode) {
//	return repository.findByfirstNameOrlastNameOrpincode(firstName, lastName, pincode);	}

	// Sort User by DOB & Joining Date
	@Override
	public List<UserEntity> SortByDateofJoinAndDateofBirth() {
		List<UserEntity> userdb = repository.findAll();
		List<UserEntity> sortedUser = userdb.stream()
				.sorted(Comparator.comparing(UserEntity::getDateofBirth).thenComparing(UserEntity::getDateOfJoining))
				.collect(Collectors.toList());
		return sortedUser;
	}

	// Soft & Hard Delete User,
	@Override
	public String userSoftDelete(int userId) {
		repository.deleteById(userId);
		return "user deleted ";
	}
	@Override
	public Optional<UserEntity> findUserById(int UserID) {
		return repository.findById(UserID);
	}
	@Override
	public List<UserEntity> findUserByName(String name) {
		return repository.findByUserName(name);
	}

}
