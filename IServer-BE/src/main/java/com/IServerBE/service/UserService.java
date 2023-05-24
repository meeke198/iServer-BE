package com.IServerBE.service;

import com.IServerBE.dto.userDto.request.UserCreateRequestDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface UserService {
    UserResponseDto saveUser(UserCreateRequestDto userRequestDto);
    Optional<UserResponseDto> getUser(Long id);

    void deleteUserByStatus(Long id);

    Page<UserResponseDto> getAllUsers(String name, Pageable pageable);

    Page<UserResponseDto> findAll(Pageable pageable);

    Optional<UserResponseDto> addServiceToPackage(Long id, Long serviceId);
}
