package com.IServerBE;

import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.User;
import com.IServerBE.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class IServerBeApplication {
//@Autowired
//private UserServiceImpl userService;
	public static void main(String[] args) {
		SpringApplication.run(IServerBeApplication.class, args);
	}
//	@Override
//	public void run(String...args) throws Exception{
//		Page<UserResponseDto> userPage = userService.getAllUsers(PageRequest.of(0,3));
//		userPage.forEach(System.out::println);
//	}
}
