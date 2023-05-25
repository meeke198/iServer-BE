package com.IServerBE.service;

import com.IServerBE.dto.userDto.request.UserRequestDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface UserService {
    UserResponseDto saveUser(UserRequestDto userRequestDto);
    Optional<UserResponseDto> getUser(Long id);

    void deleteUserByStatus(Long id);

    Page<UserResponseDto> getAllUsers(Pageable pageable);

}
