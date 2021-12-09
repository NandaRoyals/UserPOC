package com.neosoft.poc.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.poc.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	List<UserEntity> findByUserName(String userName);
	
		
	
	
}
