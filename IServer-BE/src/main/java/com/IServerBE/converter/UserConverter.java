package com.IServerBE.converter;

import com.IServerBE.dto.roomUserDto.response.RoomUserResponseDto;
import com.IServerBE.dto.userDto.request.UserRequestDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.RoomUser;
import com.IServerBE.entity.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserConverter {
    private final RoomUserConverter roomUserConverter;
    public UserResponseDto entityToDto(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(user, userResponseDto);
        List<RoomUserResponseDto> roomUserResponseDtoList = new ArrayList<>();
        user.getRoomUserList().forEach(roomUser -> {
            RoomUserResponseDto roomUserResponseDto = new RoomUserResponseDto();
            BeanUtils.copyProperties(roomUser, roomUserResponseDto);
            roomUserResponseDtoList.add(roomUserResponseDto);
        });
//        roomUserResponseDtoList.setRoomUserResponseDtoList(roomUsers.stream()
//                .map(roomUserConverter::entityToDto).collect(Collectors.toList()));
//        BeanUtils.copyProperties(user, userResponseDto);
        userResponseDto.setRoomUserResponseDtoList(roomUserResponseDtoList);
        return userResponseDto;
    }
    public List<UserResponseDto> entitiesToDtos(List<User> userList){
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        userList.forEach(user -> userResponseDtoList.add(entityToDto(user)));
        return userResponseDtoList;
    }
    public User dtoToEntity(UserRequestDto userRequestDto){
        User user = new User();
        BeanUtils.copyProperties(userRequestDto, user);
        return user;
    }
}