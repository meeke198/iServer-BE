package com.IServerBE.converter;

import com.IServerBE.dto.roomDto.RoomResponseDto;
import com.IServerBE.dto.roomUserDto.request.RoomUserRequestDto;
import com.IServerBE.dto.roomUserDto.response.RoomUserResponseDto;
import com.IServerBE.dto.userDto.response.UserResponseDto;
import com.IServerBE.entity.RoomUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoomUserConverter {
    private final UserConverter userConverter;
    private final RoomConverter roomConverter;

    public RoomUserResponseDto entityToDto(RoomUser roomUser){
        RoomUserResponseDto roomUserResponseDto = new RoomUserResponseDto();
        BeanUtils.copyProperties(roomUser, roomUserResponseDto);
        RoomResponseDto roomResponseDto = roomConverter.entityToDto(roomUser.getRoom());
        roomUserResponseDto.setRoomResponseDto(roomResponseDto);
        UserResponseDto userResponseDto = userConverter.entityToDto(roomUser.getUser());
        roomUserResponseDto.setUserResponseDto(userResponseDto);
        roomUserResponseDto.setRoomResponseDto(roomResponseDto);
        return roomUserResponseDto;
    }

    public RoomUser dtoToEntity(RoomUserRequestDto roomUserRequestDto){
        RoomUser roomUser = new RoomUser();
        BeanUtils.copyProperties(roomUserRequestDto, roomUser);
        roomUser.setUser(userConverter.dtoToEntity(roomUserRequestDto.getUserRequestDto()));
        roomUser.setRoom(roomConverter.dtoToEntity(roomUserRequestDto.getRoomRequestDto()));
        return roomUser;
    }
}
