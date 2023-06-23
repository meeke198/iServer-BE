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
//import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
            User currentUser = userConverter.dtoToEntity(userRequestDto);
            userRepo.save(currentUser);
            log.info("Saving new user to database {}", currentUser.getUserName());
            return userConverter.entityToDto(currentUser);

    }

//    @Override
//    public UserResponseDto editUser(UserRequestDto userRequestDto) {
//        User currentUser = userConverter.dtoToEntity(userRequestDto);
//        userRepo.save(currentUser);
//        log.info("Saving new user to database {}", currentUser.getUserName());
//        return userConverter.entityToDto(currentUser);
//    }

    @Override
    public UserResponseDto findUserById(Long id){
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return userConverter.entityToDto(user.get());
        }
        return null;
//        }else {
//           throw new IllegalArgumentException("User doesn't exist");
//        }
    }

    @Override
    public UserResponseDto findUserByEmail(String email){
        Optional<User> user = userRepo.findUserByEmail(email);
        if (user.isPresent()) {
            return userConverter.entityToDto(user.get());
        }else {
            return null;
        }
    }
    @Override
    public UserResponseDto findUserByUserName(String userName){
        Optional<User> user = userRepo.findUserByUserName(userName);
        if (user.isPresent()) {
            return userConverter.entityToDto(user.get());
        }else {
            return null;
        }
    }

    @Override
    public UserResponseDto deleteUserStatusById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            user.get().setIsActive(false);
            userRepo.save(user.get());
            return userConverter.entityToDto(user.get());
        }
        else {
            throw new IllegalArgumentException("User doesn't exist");
        }

    }

    @Override
    public List<UserResponseDto> getAllActiveUsers() {
        Optional<List<User>> userList = userRepo.findAllActiveUsers();
        if(userList.isPresent()){
            List<UserResponseDto> userResponseDtoList = new ArrayList<>();
            userList.get().forEach(user -> {
                UserResponseDto userResponseDto = userConverter.entityToDto(user);
                userResponseDtoList.add(userResponseDto);
            });
            return userResponseDtoList;
        } else {
            throw new IllegalArgumentException("No users found");
        }
    }

    @Override
    public UserResponseDto getUserByUserNameAndPassword(String email, String password) {
        Optional<User> user = userRepo.findUserByUserNameAndPassword(email, password);
        if(user.isPresent()){
            userRepo.save(user.get());
            return userConverter.entityToDto(user.get());
        } else{
            throw new IllegalArgumentException("No users found");
        }
    }
}
