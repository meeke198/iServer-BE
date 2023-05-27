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

@Component
@RequiredArgsConstructor
public class UserConverter {
    private final UserConverter userConverter;
    public UserResponseDto entityToDto(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(user, userResponseDto);
//        List<RoomUser> roomUserList = user.getRoomUserList();
//        userResponseDto.setUserName(user.getUserName());
//        if(roomUserList != null){
//            List<RoomUserResponseDto>  roomUserResponseDtos = new ArrayList<>();
//            roomUserList.forEach(roomUser -> roomUserResponseDtos.add(roomUserConverter.entityToDto(roomUser)));
//            userResponseDto.setRoomUserResponseDtoList(roomUserResponseDtos);
//        }
        return userResponseDto;
    }
    public List<UserResponseDto> entitiesToDtos(List<User> userList){
//        BeanUtils.copyProperties(user, userResponseDto);
//        List<RoomUser> roomUserList = user.getRoomUserList();
//        userResponseDto.setUserName(user.getUserName());
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        userList.forEach(user -> userResponseDtoList.add(userConverter.entityToDto(user)));
//        userResponseDto.setRoomUserResponseDtoList(roomUserResponseDtos);
//
        return userResponseDtoList;
    }
    public User dtoToEntity(UserRequestDto userRequestDto){
        User user = new User();
        BeanUtils.copyProperties(userRequestDto, user);
        return user;
    }
}
