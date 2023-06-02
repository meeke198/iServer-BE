package com.IServerBE.service;

import com.IServerBE.dto.userDto.request.UserRequestDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface UserService {

    UserResponseDto saveUser(UserRequestDto userRequestDto);
    UserResponseDto findUserById(Long id);

    UserResponseDto deleteUserStatusById(Long id);

    List<UserResponseDto> getAllActiveUsers();
    UserResponseDto getUserByUserNameAndPassword(String username, String password) throws ChangeSetPersister.NotFoundException;
    UserResponseDto findUserByEmail(String email);
    UserResponseDto findUserByUserName(String userName);

}
