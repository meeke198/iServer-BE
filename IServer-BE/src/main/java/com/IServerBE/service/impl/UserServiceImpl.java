package com.IServerBE.service.impl;

import com.IServerBE.converter.UserConverter;
import com.IServerBE.dto.userDto.request.UserRequestDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.User;
import com.IServerBE.repository.MessageRepo;
import com.IServerBE.repository.RoomRepo;
import com.IServerBE.repository.RoomUserRepo;
import com.IServerBE.repository.UserRepo;
import com.IServerBE.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
//automatically generate a logger field for that class
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoomRepo roomRepo;
    private final RoomUserRepo roomUserRepo;
    private final MessageRepo messageRepo;
    private final UserConverter userConverter;
    @Override
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
        log.info("Saving new user to database {}", userRequestDto.getUserName());
        User eUser =  userConverter.dtoToEntity(userRequestDto);
        User savedUser =  userRepo.save(eUser);
        return userConverter.entityToDto(savedUser);
    }

    @Override
    public Optional<UserResponseDto> getUser(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteUserByStatus(Long id) {

    }

    @Override
    public Page<UserResponseDto> getAllUsers(Pageable pageable) {
        return null;
    }
}
