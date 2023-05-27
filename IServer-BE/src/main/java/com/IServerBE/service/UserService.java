package com.IServerBE.service;

import com.IServerBE.dto.userDto.request.UserRequestDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.User;


import java.util.List;
import java.util.Optional;

public interface UserService {


    UserResponseDto saveUser(UserRequestDto userRequestDto);
    UserResponseDto findUserById(Long id);

    UserResponseDto deleteUserStatusById(Long id);

    List<UserResponseDto> getAllUsers();

}
