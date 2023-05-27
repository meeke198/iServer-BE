package com.IServerBE.service.impl;

import com.IServerBE.converter.UserConverter;
import com.IServerBE.dto.userDto.request.UserRequestDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.User;
import com.IServerBE.repository.UserRepo;
import com.IServerBE.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
//automatically generate a logger field for that class
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserConverter userConverter;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
        Optional<User> userEmail = userRepo.findUserByEmail(userRequestDto.getEmail());
        Optional<User> userName = userRepo.findUserByUserName(userRequestDto.getUserName());
        UserResponseDto userResponseDto = new UserResponseDto();
        if (userEmail.isPresent() && userName.isPresent()) {
            throw new IllegalArgumentException("email & username links with an account, please log in");
        } else if (!userEmail.isPresent() && userName.isPresent()) {
            throw new IllegalArgumentException("Username is already taken");
        } else if (userEmail.isPresent() && !userName.isPresent()) {
            throw new IllegalArgumentException("Email links with an account, please log in");
        } else {
            User newUser = userConverter.dtoToEntity(userRequestDto);
//            String encodedPassword = bCryptPasswordEncoder.encode(userRequestDto.getPassword());
            String encodedPassword = "letImagineThisIsAn$%BcryptEncodedPassword@#$%%";
            newUser.setPassword(encodedPassword);
            userRepo.save(newUser);
            log.info("Saving new user to database {}", newUser.getUserName());
              return userConverter.entityToDto(newUser);
        }
    }

    @Override
    public UserResponseDto findUserById(Long id){
        Optional<User> user = userRepo.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("User doesn't exist");
        }else {
            return userConverter.entityToDto(user.get());
        }
    }

    @Override
    public UserResponseDto deleteUserStatusById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("User doesn't exist");
        }else {
            user.get().setIsActive(false);
            return userConverter.entityToDto(user.get());
        }

    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        Optional<List<User>> userList = Optional.of(userRepo.findAll());
        if(userList.isPresent()){
            List<UserResponseDto> userResponseDtoList = userConverter.entitiesToDtos(userList.get());
            return userResponseDtoList;
        }else{
            throw new IllegalArgumentException("No users found");
        }
    }
}
