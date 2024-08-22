package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
//import com.example.demo.dto.UserDTO;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
    
	@Override
	public void findAllUsers() {
		System.out.println("# UserServiceImpl.java > findAllUsers");
         List<UserEntity> userEntityList = userRepository.findAll();
         for (UserEntity userEntity : userEntityList) {
        	 System.out.println("userEntity : " + userEntity);
        	 UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
        	 System.out.println("userId : " + userDTO.getUserPw() + ", userPw : " + userDTO.getUserPw());
         }
         
         return;
    }
}
